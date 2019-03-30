package com.soyanga.xml_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: xmlSAX_tomcat_servlet
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-30 10:10
 * @Version 1.0
 */

public class MyDefaultHandler3 extends DefaultHandler {
    //创建一个List集合对象<Contact>
    private List<Contanct> conList = new ArrayList<Contanct>();

    //定义一个方法:作用获取最终的有Contact内容的List集合对象
    public List<Contanct> getList() {
        return conList;
    }

    //声明一个Contact对象
    private Contanct contact = null;

    //声明一个遍历:来记录当前读取到的标签
    private String curTag;

    /*
     * 思路:
     *    1)读取xml文件:遇到contact标签信息封装成Contact联系人对象
     *    2)将Contact对象添加到List集合中
     *    3)遍历输出Contact对象
     * */

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        curTag = qName; //记录了当前开始标签名称
        //当前标签对象是contact标签的时候
        //开始标签是包含属性的
        if (qName.equals("contanct")) {
            //创建一个Contact联系人对象
            contact = new Contanct();
            //通过属性名称获取属性值
            String id = attributes.getValue("id");
            //封装contact对象的id属性
            contact.setId(id);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //将文本内容封装
        String content = new String(ch, start, length);
        //遇到文本内容: 空格和换行是被解析的
        //判断当前curTag读取的是哪一个标签
        if ("name".equals(curTag)) {
            contact.setName(content);
        }

        //依次判断
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //清空curTag
        curTag = null;
        //遇到结束标签
        if (qName.equals("contanct")) {
            //直接将Contact联系人对象添加conList
            conList.add(contact);
        }
    }
}

//public class MyDefaultHandler3 extends DefaultHandler {
//
//    ArrayList<Contanct> conList = new ArrayList<>();
//    //contanct独对象
//    Contanct contanct = null;
//
//    private String curTag;
//
//
//    public List<Contanct> getList() {
//        return conList;
//    }
////
////    @Override
////    public void startDocument() throws SAXException {
////        super.startDocument();
////    }
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        curTag = qName; //记录当前开始标签
//
////        开始标签时包含属性的
//        //当前标签对象时contanct标签对象
//        if (qName.equals("contanct")) {
//            //创建一个contanct对象
//            contanct = new Contanct();
//            //获取属性
//            String id = attributes.getValue("id");
//            contanct.setId(id);
//        }
//    }
//
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        //将文本内容封装
//        String content = new String(ch, start, length);
//        //遇到文本内容：空格和换行依旧解析的
//        //判断当前标签是那个标签
//        if (curTag.equals("name")) {
//            contanct.setId(content);
//        }
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        //遇到结束标签
//        if (qName.equals("contanct")) {
//            //直接将Contact联系人对象添加conList
//            conList.add(contanct);
//        }
//    }
//
////    @Override
////    public void endDocument() throws SAXException {
////        super.endDocument();
////    }
//
//
//}
