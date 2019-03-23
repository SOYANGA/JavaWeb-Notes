import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @program: dom4j
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-20 20:54
 * @Version 1.0
 */
public class Dome1 {
    public static void main(String[] args) throws Exception {

        Document document = new SAXReader().read(Dome.class.getClassLoader().getResource("contanct.xml"));
        //创建输出流对象
        OutputStream outputStream = new FileOutputStream("C:/Users/32183/Desktop/test.xml");
        XMLWriter writer = new XMLWriter(outputStream);
        writer.write(document);
        outputStream.close();
    }
}
