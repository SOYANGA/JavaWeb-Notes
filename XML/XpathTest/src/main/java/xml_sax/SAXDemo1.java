package xml_sax;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @program: XpathTest
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-22 21:15
 * @Version 1.0
 * <p>
 * <p>
 * 1)创建一个SAXParser解析器
 * 它是一个抽象类---->工厂类:SAXParserFactory里面的newInstance(String factoryClassName, ClassLoader classLoader)-->
 * SAXParserFactory.newSAXParser() 创建一个新实例SAXParser解析器
 * 2)
 */
public class SAXDemo1 {
    public static void main(String[] args) throws Exception {
        //1获取解析器
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

        saxParser.parse(String.valueOf(SAXDemo1.class.getClassLoader().getResource("personList.html")), new MyDefaultHandler1());
    }

}
