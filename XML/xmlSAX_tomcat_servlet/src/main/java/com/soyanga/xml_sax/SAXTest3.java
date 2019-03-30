package com.soyanga.xml_sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * @program: xmlSAX_tomcat_servlet
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-30 10:07
 * @Version 1.0
 */
public class SAXTest3 {
    public static void main(String[] args) throws Exception {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        MyDefaultHandler3 defaultHandler3 = new MyDefaultHandler3();

        saxParser.parse(SAXDemo1.class.getClassLoader().getResourceAsStream("contanct.xml"), defaultHandler3);
        List<Contanct> list = defaultHandler3.getList();
        for (Contanct contact : list) {
            System.out.println(contact);
        }
    }
}
