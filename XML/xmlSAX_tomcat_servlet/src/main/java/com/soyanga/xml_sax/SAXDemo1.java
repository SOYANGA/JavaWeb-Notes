package com.soyanga.xml_sax;

/**
 * @program: xmlSAX_tomcat_servlet
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-30 09:36
 * @Version 1.0
 * * 1)创建一个SAXParser解析器
 * * 它是一个抽象类---->工厂类:SAXParserFactory里面的newInstance(String factoryClassName, ClassLoader classLoader)-->
 * * SAXParserFactory.newSAXParser() 创建一个新实例SAXParser解析器
 * * 2)
 */

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SAXDemo1 {
    public static void main(String[] args) throws Exception {
        //1SAX获取解析器对象
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        //解析指定xml文件

        /**
         * 参数1：值顶一个输入流的方式读取xml文件
         * 参数2:默认的事件处理程序：DefaultHandler
         */

        /**
         * 事件编程的三要素
         * 事件源
         * 事件监听器 触发函数：开始标签（包含了标签属性) 文本内容 结束标注
         * 注册事件监听器：DerfualtHandler:class
         */
        MyDefaultHandler1 handler1 = new MyDefaultHandler1();

        //
        saxParser.parse(SAXDemo1.class.getClassLoader().getResourceAsStream("contanct.xml"), handler1);
        handler1.getText();
//        System.out.println(handler1);
    }

}

