package com.itcast.basic.xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qfl on 16/6/9.
 */
public class Dom4jUtils {

    public static void readXMLBySax(String path) {
        File file = new File(path);
        if (!file.exists())
            throw new NullPointerException("文件不存在");
        if (!path.endsWith(".xml"))
            throw new IllegalArgumentException("文件格式不正确");
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(file);
            Element element = document.getRootElement();
            enumerationElements(element);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void writeXML(String path) {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("college");
        Map<String, String> rootAttributesMap = new HashMap<String, String>();
        rootAttributesMap.put("name", "哈佛大学");
        rootAttributesMap.put("code", "100101");
        initElementAttributes(rootElement, rootAttributesMap);
        Element chirldElement = rootElement.addElement("academe");
        Map<String, String> chrildAttributesMap = new HashMap<>();
        chrildAttributesMap.put("name", "经济学院");
        chrildAttributesMap.put("code", "10010101");
        chirldElement.setText("智商第一,情商第二");
        initElementAttributes(chirldElement, chrildAttributesMap);
        document.setRootElement(rootElement);
        File file = new File(path);
        if (file.exists())
            file.delete();
        try {
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readXMLByVisitor(String path) {
        File file = new File(path);
        if (!file.exists())
            throw new NullPointerException("文件不存在");
        if (!path.endsWith(".xml"))
            throw new IllegalArgumentException("文件格式不正确");
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(file);
            document.accept(new DocumentVisitor());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void initElementAttributes(Element element, Map<String, String> attributesMap) {
        for (String key : attributesMap.keySet())
            element.addAttribute(key, attributesMap.get(key));
    }

    private static class DocumentVisitor extends VisitorSupport {
        @Override
        public void visit(Document document) {
            System.out.println("开始解析文档" + document.getName());
        }

        @Override
        public void visit(Element node) {
            if (!node.hasContent())
                System.out.println(node.getName() + " =======> " + node.getTextTrim());
        }

        @Override
        public void visit(Attribute node) {
            System.out.println(node.getName() + " ========> " + node.getValue());
        }
    }

    private static void enumerationElements(Element element) {
        List<Attribute> attributes = element.attributes();
        if (attributes.size() != 0)
            for (Attribute attribute : attributes)
                System.out.println(attribute.getName() + " =======> " + attribute.getValue());
        if (element.hasContent())
            for (Element childElement : (List<Element>) element.elements())
                enumerationElements(childElement);
        else
            System.out.println(element.getName() + " =======> " + element.getTextTrim());
    }
}












