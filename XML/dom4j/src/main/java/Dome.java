import Test.Cantanct;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: dom4j
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-20 20:40
 * @Version 1.0
 */
public class Dome {
    public static void main(String[] args) throws Exception {
//        1. 将标签封装成一个类  —-目的获得xml对象
//        2. 读取xml文件
//        3. 创建一个List集合（ArrayList/LinkedList/Vectory)泛型指定：\<contanct>Contanct类
//        4. 读取xml文件：根标签elements() ;List\<Element>
//                5. 封装成Contanct对象  Contanct ct =  new Contanct();
//        6. setxxx(),   getxxx()
        Document document = new SAXReader().read(Dome.class.getClassLoader().getResource("contanct.xml"));
        //创建一个集合对象，list<Contanct>

        List<Cantanct> contanctList = new ArrayList<Cantanct>();
        List<Element> list = document.getRootElement().elements();
        for (Element element : list) {
            //获取到每一个节点对象
            //创建Contanct联系对象并且封装
            Cantanct con = new Cantanct();
            con.setId(element.elementText("id"));
            con.setName(element.elementText("name"));
            contanctList.add(con);
        }
        for (Cantanct cantanct : contanctList) {
            System.out.println(cantanct);

        }


    }

}
