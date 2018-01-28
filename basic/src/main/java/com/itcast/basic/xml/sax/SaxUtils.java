package com.itcast.basic.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by qfl on 16/6/9.
 */
public class SaxUtils {

    public static void readXML(String path) {
        try {
            if (!path.endsWith(".xml"))
                throw new IllegalArgumentException("文件格式不正确");
            File file = new File(path);
            if (!file.exists())
                throw new NullPointerException("文件不存在");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, new XMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeXML(String path) {
        throw new IllegalArgumentException("Sax 不具备写xml能力");
    }

    private static class XMLHandler extends DefaultHandler {
        private String elementName;

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("开始解析XML文档");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            elementName = qName;
            System.out.println("节点" + qName + "解析开始");
            System.out.println(elementName + " 节点的属性为: ");
            for (int i = 0; i < attributes.getLength(); i++)
                System.out.println(attributes.getQName(i) + " ====> " + attributes.getValue(i));
        }

        /**
         * @param ch     保存xml文件中所有content的数组
         * @param start
         * @param length
         * @throws SAXException
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            System.out.println(elementName + " 节点里的内容: " + new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            System.out.println("节点" + qName + "解析结束");
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("结束解析XML文档");
        }
    }
}
