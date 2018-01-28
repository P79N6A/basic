package com.itcast.basic.xml.jdom;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qfl on 16/6/9.
 */
public class JdomUtils {

    public static void readXML(String path) {
        if (!path.endsWith(".xml"))
            throw new IllegalArgumentException("文件格式不正确");
        File file = new File(path);
        if (!file.exists())
            throw new NullPointerException("文件不存在");
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(file);
            Element root = document.getRootElement();
            enumerationElements(root);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeXML(String path) {
        Document document = new Document();
        Element root = new Element("college");
        Map<String, String> rootAttributesMap = new HashMap<>();
        rootAttributesMap.put("name", "哈佛大学");
        rootAttributesMap.put("code", "100101");
        initElementAttributes(root, rootAttributesMap);
        Element chirldElement = new Element("academe");
        Map<String, String> chrildAttributesMap = new HashMap<>();
        chrildAttributesMap.put("name", "经济学院");
        chrildAttributesMap.put("code", "10010101");
        chirldElement.setText("智商第一,情商第二");
        initElementAttributes(chirldElement, chrildAttributesMap);
        //添加子元素
        root.addContent(chirldElement);
        document.setRootElement(root);
        File file = new File(path);
        if (file.exists())
            file.delete();
        try {
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document, new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initElementAttributes(Element element, Map<String, String> map) {
        for (String key : map.keySet())
            element.setAttribute(key, map.get(key));
    }

    private static void enumerationElements(Element element) {
        List<Attribute> attributes = element.getAttributes();
        for (Attribute attribute : attributes)
            System.out.println(attribute.getName() + " =====> " + attribute.getValue());
        List<Element> chlidElements = element.getChildren();
        if (chlidElements.size() == 0)
            System.out.println(element.getName() + " innerText =====> " + element.getTextTrim());
        else
            for (Element childElement : chlidElements)
                enumerationElements(childElement);
    }


}
