package com.itcast.basic.xml.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qfl on 16/6/8.
 */
public class DomUtils {

    public static void readXML(String path) {
        File file = new File(path);
        if (!file.exists())
            throw new NullPointerException("文件不存在");
        if (!file.isFile())
            throw new IllegalArgumentException("参数异常");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element element = document.getDocumentElement();
            enumerationElements(element);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeXML(String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("college");

            Map<String, String> rootAttributes = new HashMap<>();
            rootAttributes.put("name", "哈佛大学");
            rootAttributes.put("code", "100101");
            addElementAttribute(root, rootAttributes);

            Element childElement = document.createElement("academe");

            Map<String, String> attributes = new HashMap<>();
            attributes.put("name", "经济学院");
            attributes.put("code", "10010100");

            addElementAttribute(childElement, attributes);

            addElementInnerObject(childElement, "智商第一,情商第二");
            addElementInnerObject(root, childElement);

            document.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            File file = new File(path);
            if (file.exists())
                file.delete();
            if (!path.endsWith(".xml"))
                throw new IllegalArgumentException("文件格式不正确");
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

    private static void addElementAttribute(Element element, Map<String, String> attributes) {
        for (String attribute : attributes.keySet())
            element.setAttribute(attribute, attributes.get(attribute));
    }

    private static void addElementInnerObject(Element element, Object o) {
        if (o instanceof String)
            element.setTextContent((String) o);
        else if (o instanceof Element)
            element.appendChild((Element) o);
    }

    private static void enumerationElements(Node element) {
        switch (element.getNodeType()) {
            case Node.ELEMENT_NODE:
                if (element.hasChildNodes()) {
                    NodeList list = element.getChildNodes();
                    for (int i = 0; i < list.getLength(); i++)
                        enumerationElements(list.item(i));
                }
                if (element.hasAttributes()) {
                    NamedNodeMap namedNodeMap = element.getAttributes();
                    for (int i = 0; i < namedNodeMap.getLength(); i++)
                        enumerationElements(namedNodeMap.item(i));
                }
                break;
            case Node.TEXT_NODE:
                System.out.println("节点文本信息:" + element.getNodeName() + " =======> " + element.getTextContent());
                break;
            case Node.ATTRIBUTE_NODE:
                System.out.println("属性值信息:" + element.getNodeName() + " ======> " + element.getNodeValue());
                break;
        }
    }
}















