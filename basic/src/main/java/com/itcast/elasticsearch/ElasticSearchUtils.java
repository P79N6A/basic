package com.itcast.elasticsearch; 
import static org.elasticsearch.common.xcontent.XContentFactory.*;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.mapping.delete.DeleteMappingResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.hppc.cursors.ObjectCursor;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.facet.FacetBuilder;
import org.elasticsearch.search.facet.FacetBuilders;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @author qfl
 */
public class ElasticSearchUtils {
	private static Client client = null;
	private final String optionString = "cluster.name";

	public ElasticSearchUtils() {
	}

	/**
	 * 构造方法
	 * 
	 * @param address
	 *            elasticsearch的ip地址
	 * @param clusterName
	 *            端点的名字
	 * @param port
	 *            端口号
	 */
	public ElasticSearchUtils(String address, String clusterName, int port) {
		Settings settings = ImmutableSettings.settingsBuilder().put(
				optionString, clusterName).put("client.transport.sniff", true)
				.build();
		client = new TransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(address,
						port));
	}

	/**
	 * 返回一个连接源
	 * 
	 * @return
	 */
	public Client getElasticsearchClient() {
		return client;
	}

	/**
	 * @param address
	 * @param clusterName
	 * @param port
	 * @return
	 */
	public Client getElasticsearchClient(String address, String clusterName,
			int port) {
		if (client == null) {
			Settings settings = ImmutableSettings.settingsBuilder().put(
					optionString, clusterName).put("client.transport.sniff",
					true).build();
			client = new TransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(
							address, port));
		}
		return client;
	}

	/**
	 * 返回节点 信息(详细信息) ClusterStatsResponse.getStatus()返回节点状态（green yellow red）
	 * ClusterStatsResponse.getClusterNameAsString()返回节点名称
	 * ClusterStatsResponse.getIndicesStats()返回节点中所有索引的信息
	 * 
	 * @return
	 */
	public ClusterStatsResponse getElasticsearchClusterInfo() {
		return client.admin().cluster().prepareClusterStats().execute()
				.actionGet();
	}

	/**
	 * 得到指定索引的source
	 * 
	 * @param indexName
	 * @param indexType
	 * @param indexId
	 * @return
	 */
	public Map<String, Object> getElasticsearchSource(String indexName,
			String indexType, String indexId) {
		return client.prepareGet(indexName, indexType, indexId).execute()
				.actionGet().getSource();
	}

	/**
	 * 通过别名得到索引的名字 while(container.hasNext())遍历索引名字 container.next().value
	 * 得到索引名称
	 * 
	 * @param indexAlias
	 *            索引别名
	 * @return
	 */
	public String[] getIndexNames(String indexAlias) {
		String names = "";
		Iterator<ObjectCursor<String>> container = client.admin().indices()
				.getAliases(new GetAliasesRequest(indexAlias)).actionGet()
				.getAliases().keys().iterator();

		while (container.hasNext()) {
			names += container.next().value + ";";
		}
		return names.split(";");
	}

	/**
	 * 更新别名
	 * 
	 * @param oldNames
	 * @param newName
	 * @param aliasName
	 * @return
	 */
	public boolean updateIndexAlias(String[] oldNames, String newName,
			String aliasName) {
		return client.admin().indices().prepareAliases().removeAlias(oldNames,
				aliasName).addAlias(newName, aliasName).execute().actionGet()
				.isAcknowledged();
	}

	/**
	 * 关闭连接源
	 */
	public void closeClient() {
		if (client != null) {
			client.close();
		}
	}

	/**
	 * 批量索引
	 */
	public boolean blukIndex(List<IndexRequestBuilder> indexRequestBuilderLists) {
		Boolean isSucceed = true;
		BulkRequestBuilder blukBuilder = client.prepareBulk();
		for (IndexRequestBuilder indexRequestBuilder : indexRequestBuilderLists) {
			blukBuilder.add(indexRequestBuilder);
		}
		BulkResponse response = blukBuilder.execute().actionGet();
		if (response.hasFailures()) {
			isSucceed = false;
		}
		return isSucceed;
	}

	/**
	 * 构造IndexRequestBuilder
	 * 
	 * @param indexName
	 * @param indexType
	 * @param indexId
	 * @param sourceBuilder
	 * @return
	 */
	public IndexRequestBuilder getIndexRequestBuilder(String indexName,
			String indexType, String indexId, XContentBuilder sourceBuilder) {
		return client.prepareIndex(indexName, indexType, indexId).setSource(
				sourceBuilder);
	}

	/**
	 * 构造 XContentBuilder
	 * 
	 * @param dataMap
	 * @return
	 */
	public XContentBuilder getXContentBuilder(Map<String, Object> dataMap) {
		XContentBuilder json = null;
		try {
			json = jsonBuilder().startObject();
			for (String key : dataMap.keySet()) {
				json.field(key, dataMap.get(key));
			}
			json.endObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	/**
	 *单一索引 或者 更新指定 的字段
	 * 
	 * @param indexName
	 *            索引名字
	 * @param indexType
	 *            索引类型
	 * @param indexId
	 *            索引id
	 * @param dataMap
	 *            索引数据
	 * @return
	 */
	public boolean index(String indexName, String indexType, String indexId,
			Map<String, Object> dataMap) {
		boolean isSucceed = true;
		try {
			getIndexRequestBuilder(indexName, indexType, indexId,
					getXContentBuilder(dataMap)).execute().actionGet();
		} catch (Exception e) {
			// TODO: handle exception
			isSucceed = false;
			e.printStackTrace();
		}
		return isSucceed;
	}

	/**
	 * 删除一个指定的索引
	 * 
	 * @param indexName
	 * @param indexType
	 * @param indexId
	 * @return
	 */
	public boolean deleteIndex(String indexName, String indexType,
			String indexId) {
		boolean isSucceed = true;
		try {
			client.prepareDelete(indexName, indexType, indexId).execute()
					.actionGet();
		} catch (Exception e) {
			// TODO: handle exception
			isSucceed = false;
			e.printStackTrace();
		}
		return isSucceed;
	}

	/**
	 * 将javabean转为map
	 * 
	 * @param collections
	 *            剔除的属性
	 * @param bean
	 * @return
	 */
	public Map<String, Object> getMapFromBean(Object bean,
			List<String> collections) {
		Map<String, Object> results = new HashMap<String, Object>();
		collections = collections == null ? new ArrayList<String>()
				: collections;
		try {
			Class type = bean.getClass();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (PropertyDescriptor descriptor : propertyDescriptors) {
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")
						&& !propertyName.equals("entityId")
						&& !collections.contains(propertyName)) {
					Method readMethod = descriptor.getReadMethod();

					results.put(propertyName, readMethod.invoke(bean,
							new Object[0]));

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * @param indexName
	 * @param indexType
	 * @param json
	 * @return
	 */
	public boolean updateIndexMappings(String indexName, String indexType,
			XContentBuilder json) {
		boolean isSucceed = false;
		try {
			if (client.admin().indices().prepareGetFieldMappings().addIndices(
					indexName).addTypes(indexType).execute().actionGet()
					.mappings().size() > 0) {
				client.admin().indices().deleteMapping(
						Requests.deleteMappingRequest(indexName).types(
								indexType)).actionGet().isAcknowledged();
			}
			return client.admin().indices().putMapping(
					Requests.putMappingRequest(indexName).type(indexType)
							.source(json)).actionGet().isAcknowledged();

		} catch (Exception e) {
			isSucceed = false;
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSucceed;
	}

	/***********************************************************************************************************************/
	/**
	 * 初始化SearchRequestBuilder
	 * 
	 * @param indexName
	 * @param indexType
	 * @param preferenceType
	 * @param searchType
	 * @param includes
	 */
	public SearchRequestBuilder initSearcher(String indexName,
			String indexType, String preferenceType, SearchType searchType,
			String[] includes) {
		SearchRequestBuilder serach = client.prepareSearch(indexName).setTypes(
				indexType);
		if (preferenceType != null) {
			serach.setPreference(preferenceType);
		}
		if (searchType != null) {
			serach.setSearchType(searchType);
		}
		if (includes.length > 0) {
			serach.setFetchSource(includes, null);
		}
		return serach;
	}

	/**
	 * 初始化排序
	 * 
	 * @param serach
	 * @param sortFileds
	 * @return
	 */
	public SearchRequestBuilder initSort(SearchRequestBuilder serach,
			Map<String, SortOrder> sortFileds) {
		if (serach != null) {
			for (String key : sortFileds.keySet()) {
				serach.addSort(SortBuilders.fieldSort(key).order(
						sortFileds.get(key)));
			}
		}
		return serach;
	}

	/**
	 * 初始化统计
	 * 
	 * @param serach
	 * @param facetBuilders
	 * @return
	 */
	public SearchRequestBuilder initFacets(SearchRequestBuilder serach,
			List<FacetBuilder> facetBuilders) {
		if (serach != null) {
			for (FacetBuilder facetBuilder : facetBuilders) {
				serach.addFacet(facetBuilder);
			}
		}
		return serach;
	}

	/**
	 * 初始化高亮
	 * 
	 * @param serach
	 * @param highLightFields
	 *            (query中必须有该field)
	 * @return
	 */
	public SearchRequestBuilder initHighLightFields(
			SearchRequestBuilder serach, Map<String, String> highLightFields) {
		if (serach != null) {
			for (String key : highLightFields.keySet()) {
				serach.addHighlightedField(key).setHighlighterPreTags(
						"<" + highLightFields.get(key) + ">")
						.setHighlighterPostTags(
								"</" + highLightFields.get(key) + ">");
			}

		}
		return serach;
	}

	/**
	 * 初始化filter
	 * 
	 * @param serach
	 * @param query
	 * @param filter
	 * @return
	 */
	public SearchRequestBuilder initQueryFilter(SearchRequestBuilder serach,
			QueryBuilder query, FilterBuilder filter) {
		if (serach != null) {
			serach.setQuery(QueryBuilders.filteredQuery(query, filter));
		}
		return serach;
	}

	/**
	 * 初始化Query
	 * 
	 * @param serach
	 * @param query
	 * @param filter
	 * @return
	 */
	public SearchRequestBuilder initQuery(SearchRequestBuilder serach,
			QueryBuilder query) {
		if (serach != null) {
			serach.setQuery(query);
		}
		return serach;
	}

	/**
	 * 初始化分页
	 * 
	 * @param serach
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public SearchRequestBuilder initPage(SearchRequestBuilder serach,
			int pageIndex, int pageSize) {
		pageIndex = (pageIndex <= 0 ? 0 : pageIndex - 1) * pageSize;
		pageSize = pageSize;
		if (serach != null) {
			serach.setFrom(pageIndex).setSize(pageSize);
		}
		return serach;
	}

	/**
	 * 得到搜索结果
	 * 
	 * @param serach
	 * @return
	 */
	public SearchResponse getSearchResults(SearchRequestBuilder serach) {
		SearchResponse respone = null;
		if (serach != null) {
			respone = serach.execute().actionGet();
		}
		return respone;
	}

	/**
	 * 是否有分片信息错误
	 * 
	 * @param response
	 * @return
	 */
	public boolean isHasShareFailed(SearchResponse response) {
		boolean isFailed = false;
		if (response != null) {
			isFailed = response.getFailedShards() > 0;
		}
		return isFailed;
	}

	/**
	 * 返回搜索结果数目
	 * 
	 * @param response
	 * @return
	 */
	public long getTotalHits(SearchResponse response) {
		return response == null ? 0 : response.getHits() == null ? 0 : response
				.getHits().getTotalHits();
	}

	/**
	 * 得到搜索结果
	 * 
	 * @param response
	 * @return
	 */
	public SearchHit[] getHits(SearchResponse response) {
		return response == null ? null : response.getHits() == null ? null
				: response.getHits().getHits();
	}

	/**
	 * 得到统计后的分组数据
	 * 
	 * @param key
	 *            关键词
	 * @param response
	 * @return Map<Text, Object> Text关键词 Object数量(int)
	 */
	public Map<Text, Object> getFacetsFields(String key, SearchResponse response) {
		HashMap<Text, Object> map = null;
		TermsFacet facets = (TermsFacet) (response == null ? null : response
				.getFacets() == null ? null : response.getFacets().facet(key));
		if (facets != null) {
			map = new HashMap<Text, Object>();
			for (TermsFacet.Entry tf : facets.getEntries()) {
				map.put(tf.getTerm(), tf.getCount());
			}
		}
		return map;
	}

	/**
	 * 返回高亮文本
	 * 
	 * @param hit
	 *            搜索高亮结果
	 * @param key
	 *            搜索高亮字段
	 * @return
	 */
	public Text getHightText(SearchHit hit, String key) {
		return hit == null ? null
				: hit.highlightFields().isEmpty() ? null
						: hit.highlightFields().get(key) == null ? null
								: hit.highlightFields().get(key).getFragments() == null ? null
										: hit.highlightFields().get(key)
												.getFragments()[0];
	}

	/***********************************************************************************************************************/
	/**
	 * 构造统计语句
	 * 
	 * @param facetFileds
	 * @return
	 */
	public List<FacetBuilder> getFacetBuilders(Map<String, String> facetFileds) {
		List<FacetBuilder> facetBuilders = new ArrayList<FacetBuilder>();
		for (String key : facetFileds.keySet()) {
			facetBuilders.add(FacetBuilders.termsFacet(key).field(
					facetFileds.get(key)));
		}
		return facetBuilders;
	}

}
