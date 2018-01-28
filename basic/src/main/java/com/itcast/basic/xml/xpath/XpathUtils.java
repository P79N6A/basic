package com.itcast.basic.xml.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by qfl on 16/6/9.
 */
public class XpathUtils {

    public static void sysInnerText(String path, String exp) {
        File file = new File(path);
        if (!file.exists())
            throw new NullPointerException("文件不存在");
        if (!path.endsWith(".xml"))
            throw new IllegalArgumentException("文件格式不合法");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression xPathExpression = xPath.compile(exp);
            NodeList nodes = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("name = " + nodes.item(i).getNodeValue());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
