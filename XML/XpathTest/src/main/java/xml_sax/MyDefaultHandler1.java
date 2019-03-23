package xml_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @program: XpathTest
 * @Description: 该类继承默认的事件处理程序，覆写核心的事件处理方法
 * @Author: SOYANGA
 * @Create: 2019-03-22 21:23
 * @Version 1.0
 */
public class MyDefaultHandler1 extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
//        System.out.println("StartDocument:");
    }

    /**
     * 读到开始标签的时候触发此方法
     *
     * @param uri
     * @param localName
     * @param qName      开始标签
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(qName);
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print(qName);
    }


    /**
     * @param ch     字符数组 实际字符数
     * @param start  从开始位置开始读
     * @param length length读到的指定长度
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        //内日
        //获取内容
        String content = new String(ch, start, length);
        System.out.print(content);
    }

    @Override
    public void endDocument() throws SAXException {
//        System.out.print("endElement:");
    }

}
