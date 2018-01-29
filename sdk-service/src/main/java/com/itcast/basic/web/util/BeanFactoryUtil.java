package com.itcast.basic.web.util;

import com.sdk.common.model.SortColumn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class BeanFactoryUtil {

    public static final String COMMA_SIGN = ",";


    private static final String excludeFieldName = "serialVersionUID";


    /**
     * 构造排序对象集
     *
     * @param sortColumns 排序字段集合
     * @param classType   实体类类型
     * @return 真实排序字段集
     */
    public static List<SortColumn> createSortColumns(List<SortColumn> sortColumns, Class classType) {
        return sortColumns.stream()
                .filter(sortColumn -> extractFieldName(classType).contains(sortColumn.getColumn()))
                .map(sortColumn -> new SortColumn(convertFieldToColumn(sortColumn.getColumn()), sortColumn.getSort()))
                .collect(Collectors.toList());
    }

    /**
     * 构造查询字段集（项目中不建议使用注释部分代码 维护成本高）
     *
     * @param fileds    实体字段域集
     * @param classType 实体类类型
     * @return 真实查询字段集
     */
    public static List<String> createResultColumns(List<String> fileds, Class classType) {
        return fileds
                .stream()
                .filter(column -> extractFieldName(classType).contains(column))
                .map(column -> convertFieldToColumn(column))
                .collect(Collectors.toList());

//        return fileds.stream()
//                .filter(item ->
//                        Arrays.asList(classType.getDeclaredFields())
//                                .stream()
//                                .map(field -> field.getName())
//                                .filter(fieldName -> !"serialVersionUID".equalsIgnoreCase(fieldName))
//                                .collect(Collectors.toList())
//                                .contains(item))
//                .map(item -> convertFieldToColumn(item))
//                .collect(Collectors.toList());
    }

    /**
     * 字段转换器
     *
     * @param resultColumns     前端传入字段
     * @param resultColumnsList 查询参数
     * @param sortColumn        前端传入字段
     * @param sortColumnList    排序参数
     */
    public static void createSortColumns(String resultColumns, List<String> resultColumnsList, SortColumn sortColumn, List<SortColumn> sortColumnList) {

        if (resultColumns != null && "".equalsIgnoreCase(resultColumns.trim())) {
            resultColumnsList = Arrays.asList(resultColumns.split(COMMA_SIGN));
        }

        if (sortColumn != null) {
            String[] columns = new String[0];
            String[] sorts = new String[0];
            String column = sortColumn.getColumn();
            String sort = sortColumn.getSort();
            if (column != null && "".equalsIgnoreCase(column.trim())) {
                columns = column.split(COMMA_SIGN);
            }
            if (sort != null && "".equalsIgnoreCase(sort.trim())) {
                sorts = sort.split(COMMA_SIGN);
            }
            int columnsLen = columns.length;
            int sortsLen = sorts.length;
            int len = columnsLen > sortsLen ? sortsLen : columnsLen;
            for (int i = 0; i < len; i++) {
                sortColumnList.add(new SortColumn(columns[i], sorts[i]));
            }
        }
    }

    /**
     * 根据classType抽取 fieldName
     *
     * @param classType 实体类类型
     * @return 实体类字段域名称集
     */
    private static List<String> extractFieldName(Class classType) {
        if (classType == null) {
            throw new IllegalArgumentException("参数异常(classType不能为null)");
        }
        return Arrays.asList(classType.getDeclaredFields())
                .stream()
                .map(filed -> filed.getName())
                .filter(fieldName -> !excludeFieldName.equalsIgnoreCase(fieldName))
                .collect(Collectors.toList());
    }


    /**
     * 根据filed构造column
     *
     * @param filed 字段域名称
     * @return column 对应数据库字段名称
     */
    private static String convertFieldToColumn(String filed) {
        StringBuilder columnBuilder = new StringBuilder();
        for (int i = 0; i < filed.length(); i++) {
            char c = filed.charAt(i);
            if (Character.isUpperCase(c)) {
                columnBuilder.append("_").append(Character.toLowerCase(c));
            } else {
                columnBuilder.append(c);
            }
        }
        return columnBuilder.toString();
    }

    //防止构建实例
    private BeanFactoryUtil() {

    }
}
