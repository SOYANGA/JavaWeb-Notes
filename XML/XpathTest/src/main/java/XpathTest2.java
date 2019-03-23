import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @program: XpathTest
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-22 20:49
 * @Version 1.0
 */
public class XpathTest2 {
    public static void main(String[] args) throws Exception {
        //读取xml文件
        Document document = new SAXReader().read(XpathTest2.class.getClassLoader().getResource("personList.html"));

        System.out.println(document);

        Element titleElement = (Element) document.selectSingleNode("//title");
        System.out.println(titleElement.getText());
        System.out.println("id" + "\t\t" + "姓名" + "\t\t" + "性别\t\t" + "年龄\t\t" + "地址\t\t\t\t" + "电话\t\t");
        List<Element> list = document.selectNodes("//tbody/tr");
        for (Element e : list) {
            //获取每一个tr
            //tr获取td 的内容
            //获取第一个td的内容
            //方式1
//            String id = ((Element) (e.elements("td").get(0))).getText();

            //方式2
            String id = e.selectSingleNode("td[1]").getText();
            String name = e.selectSingleNode("td[2]").getText();
            String gender = e.selectSingleNode("td[3]").getText();
            String age = e.selectSingleNode("td[4]").getText();
            String add = e.selectSingleNode("td[5]").getText();
            String call = e.selectSingleNode("td[6]").getText();
            System.out.println(id + "\t\t" + name + "\t\t" + gender + "\t\t" + age + "\t\t" + add + "\t\t" + call + "\t\t");
        }
    }


}
