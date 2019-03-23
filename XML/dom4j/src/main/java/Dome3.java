import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Comparator;

/**
 * @program: dom4j
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-20 21:13
 * @Version 1.0
 */
public class Dome3 {
    public static void main(String[] args) throws Exception {
        Document document = new SAXReader().read(Dome.class.getClassLoader().getResource("contanct.xml"));

        //方式1:删除 获取子标签对象：默认第一个
        Element conElement = document.getRootElement().element("contanct");
//        conElement.detach();

        //通过父标签对象删除子标签对象
        document.getRootElement().remove(conElement);

        OutputStream out = new FileOutputStream("C:/Users/32183/Desktop/test.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(document);
        out.close();


    }

    public static void change() throws Exception {
        Document document = new SAXReader().read(Dome.class.getClassLoader().getResource("contanct.xml"));

        //方式1:
        Element conElemet = document.getRootElement().element("contanct");
        Attribute idAttr = conElemet.attribute("id");
        idAttr.setValue("003");

//        //方式2:添加属性的时候，指定同名属性名称，属性值会被覆盖
//        conElemet.addAttribute("id", "004");
//
        //方式3：修改文本内容
        Element nameElement = conElemet.element("name");
        nameElement.setText("ww");


        OutputStream out = new FileOutputStream("C:/Users/32183/Desktop/test.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(document);
        out.close();
    }

    public static void add() throws Exception {
//        Document document = new SAXReader().read(Dome.class.getClassLoader().getResource("contanct.xml"));


        Document document1 = DocumentHelper.createDocument();

        //添加一个根节点
        Element rootElement = document1.addElement("contanct-list");
        Element con = rootElement.addElement("contanct");
        con.addElement("name");
        con.addAttribute("id", "001");
        con.addAttribute("name", "sss");


        OutputStream out = new FileOutputStream("C:/Users/32183/Desktop/test.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(document1);
        out.close();
    }
}
