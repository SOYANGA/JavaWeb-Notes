import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @program: XpathTest
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-22 20:01
 * @Version 1.0
 * <p>
 * <p>
 * <p>
 * 模拟用户登陆
 * -----输入用户名和密码--------和数据库中用户名和密码来进行匹配
 * 如果用户名存在并且密码也正确，那么登陆成功
 * 否则，登陆失败
 * <p>
 * 设计一个xml文件--user.xml
 * <p>
 * <user-list>
 * <user id="001">
 * <name>lucy</name>
 * <password>123456</password>
 * </user>
 * <user id="001">
 * *         <name>jack</name>
 * *         <password>123456</password>
 * *     </user>
 * </user-list>
 * <p>
 * <p>
 * 步骤；
 * 1)录入用户名和密码
 * Scanner(System.in)
 * <p>
 * BufferReader(new InPutStreamReader(System.in)
 * <p>
 * 2)使用dom4j读取xml文件在文件标签中查询是否存在该name 的标签， 存在就取出password标签的文本获取密码，反之返回五用户
 */
public class XpathTest {
    public static void main(String[] args) throws Exception {
        //10)录入用户名和密码
        //使用字符缓冲流(高效流)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //录入用户名
        System.out.println("请输入用户名");
        String name = reader.readLine();
        System.out.println("请输入密码");
        String password = reader.readLine();

        //2)读取xml文件
        Document document = new SAXReader().read(XpathTest.class.getClassLoader().getResource("user.xml"));

        //3)利用xpath定位name标签
        String xpath = "//user/name[text()='" + name + "']";
        Element nameElement = (Element) document.selectSingleNode(xpath);
        //防止出现Null指针异常
        while (true) {
            if (nameElement != null) {
                //用户名存在
                //判断密码是否一致
                //可以通过name标签对象获取父节点------/password的标签

                String dbPwd = nameElement.getParent().elementText("password");
                if (dbPwd.equals(password)) {
                    System.out.println("用户登陆成功");
                    break;

                } else {
                    System.out.println("密码错误");
                }
                break;
            } else {
                System.out.println("用户不存在");
                break;
            }
        }
    }
}
