import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * @program: dom4j
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-20 21:10
 * @Version 1.0
 */
public class Dome2 {
    public static void main(String[] args) throws IOException, DocumentException {
        Document document = new SAXReader().read(Dome.class.getClassLoader().getResource("contanct.xml"));
        //创建输出流对象
        OutputStream outputStream = new FileOutputStream("C:/Users/32183/Desktop/test.xml");
        OutputFormat outputFormat = OutputFormat.createCompactFormat();
        XMLWriter writer = new XMLWriter(outputStream, outputFormat);
        writer.write(document);
        outputStream.close();

    }
}
