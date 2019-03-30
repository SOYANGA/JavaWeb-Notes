package com.soyanga.xml_sax;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @program: xmlSAX_tomcat_servlet
 * @Description: 该类继承默认的事件处理程序，覆写核心的事件处理方法
 * @Author: SOYANGA
 * @Create: 2019-03-30 09:37
 * @Version 1.0
 */


public class MyDefaultHandler1 extends DefaultHandler {

    //遇到开始文档
    //开始标签
    //文章标签
    //文档结束


    //构建一个字符缓冲区对象，来将标签个文本拼接起来
    private StringBuffer sb = new StringBuffer();


    public void getText() {
        System.out.println(sb);
    }
    //定义一个方法：作业 将标签以及文本内容获取

    /**
     * 遇到了开始文档
     *
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        sb.append("<?xml version=\" 1.0 \" encoding=\" utf - 8 \" ?>\n");
    }


    /**
     * 读到开始标签的时候触发此方法
     * <contanct id="" name="" ></contanct>
     *
     * @param uri
     * @param localName
     * @param qName      开始标签
     * @param attributes 属性列标签
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //拼接开始
        sb.append("<" + qName);
        //遍历当前标签所有属性
        //获取到每一个属性对象：Attribute
        //attributes.getValue()  通过属性名称获取属性值
        //attributes.getQname()
        for (int i = 0; i < attributes.getLength(); i++) {
            //获取属性名称以及属性值
            String name = attributes.getQName(i);
            String value = attributes.getValue(name);  //属性值
            sb.append(" " + name + "=\"" + value + "\"");
        }
        sb.append(">");
//        System.out.print(qName);
    }

    /**
     * 读到text内容得之后触发
     *
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
        sb.append(content);
//        System.out.print(content);
    }

    /**
     * 读到结束标签的时候触发此方法
     *
     * @param uri
     * @param localName
     * @param qName     结束标签
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        sb.append("<" + qName + ">");
    }

    /**
     * 文档结束时触发
     *
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
//        System.out.print("endElement:");
    }

}
