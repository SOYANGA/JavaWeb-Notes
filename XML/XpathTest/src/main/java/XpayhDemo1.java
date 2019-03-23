import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @program: XpathTest
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-22 19:18
 * @Version 1.0
 */
public class XpayhDemo1 {
    public static void main(String[] args) throws Exception {

        //原始方式去删除
        Document document = new SAXReader().read(XpayhDemo1.class.getClassLoader().getResource("contanct.xml"));

        //如果逻辑不够严谨，可能报空指针异常

        Document conElement = (Document) document.selectSingleNode("//contanct[@id='002']");
        conElement.detach();

        //覆盖
        OutputStream outputStream = new FileOutputStream(new File("C:/Users/32183/Desktop/test.xml"));
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(document);

        writer.close();
        outputStream.close();


    }

}
