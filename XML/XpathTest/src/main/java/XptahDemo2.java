import com.sun.org.apache.xpath.internal.SourceTree;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @program: XpathTest
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-22 19:44
 * @Version 1.0
 */
public class XptahDemo2 {
    public static void main(String[] args) throws Exception {
        Document document = new SAXReader().read(XpayhDemo1.class.getClassLoader().getResource("contanct.xml"));

//        利用xpath语法测试
        String xpath = "";
        //1.1.
        xpath = "/contanct-list";//选中跟标签
        xpath = "/contanct-list/contanct";//选中跟标签下的子节点
        //1.2

        xpath = "//contanct";//不分层级关系选中所有的contact标签

        //1.3统配

        xpath = "//contanct-list/*";//选中跟标签下的所有子节点
        xpath = "//contanct-list//*";//选中跟标签下的所有节点（不分层级关系）

        //1.4[]
        xpath = "/contanct-list//contanct[1]";

        xpath = "/contanct-list//contanct[last()]";

        //1.5@
        xpath = "//@id";//返回：Attribute对象
        xpath = "//contanct[@id='002']";//选中id属性是002的contanct标签
        //1.6and
        xpath = "//contanct[@id='001'and @name='张三']";

        //查询多节点

        List<Node> list = document.selectNodes(xpath);
        for (Node node : list) {
            System.out.println(node);
        }
    }
}
