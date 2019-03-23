# JavaWeb _02

1)Dom解析 基于面向对象的一种方式什么是Dom解析

Dom解析的方式  dom4j1.1.6jar包



如何使用dom4j去读取一个xml文件

获取标签对象 Element

获取属性      Attribute

获取文本      Text

2)使用 dom4j去写出xml文件

查看API XMLWriter

3)dom4j里面的一个插件:xpath

​	利用xpath技术快定位到一个标签

4)SAX解析





回顾内容

JavaWeb简介

​	EE的项目：类似于电商复杂系统

C/S结构和B/S结构的区别

​	重点：了解B/S结构模型

​	浏览器和服务器端的交互

​	1)系统复杂

​	2)浏览器端不需要特定的升级

​	3)http协议/https协议

​	4)XML技术

​		Xml语法规则

​		servlet技术

​		

## Xml的解析方式

Dom:dom4j

​	Dom for java

​	xpath技术：表达式的语法规则

​	Josn解析

Servlet:server applet

XML解析/DOM解析/SAX解析



## dom4j如何解析xml文件



读取下xml文件![Dom4j解析Xml](C:\Users\32183\Desktop\Dom4j解析Xml.png)

### Dom4j解析Xml标签对象

创建一个xml解析器对象

```java
SAXReader  reader = ne SAXReader();
```

读取：contanct.xml文件 ：resources

- 使用绝对路径去进行加载

  ```java
  Document document = reader.read(new File("文件路径"));
  ```

- 读取classPath目录

  ```java
  Document document = reader.read(Domo1.class.getClassLoader().getResourse("contanct.xml"));
  ```



获取标签对象

```java
Element getRootElement();
Element rootElement = document.getRootElement();
```

获取根标签对象的名称

```java
rootElement.getName();
```

通过根标签对象获取子标签对象

根据标签名称：默认获取的是第一个子标签对象

```java
Element  contanctElement = rootElement.element("contanct");

Element  contanctElement = rootElement.element();
```



获取所有的同名的子标签对象，通过指定标签名称   ->迭代输出即可

```java
List<Element> contanctList = rootElement.elements("contanct");
```



获取所有的子标签对象不指定标签名称

```java
List<Element> contanctList = rootElement.elements();
```



在xml文件中 空格和换行都可以被解析出来

java代码中的空格和换行只是为了代码风格

```java
rootElement.getText();
```

#### 总结：

> getRootElement():获取根标签对象
>
> 通过根标签对象.emelment(“contanct”):获取第一个子节点对象
>
> 获取节点的同名的子节点对象 .elements(“contanct”); 返回的是一个集合
>
> 获取节点的所有子节点对象 .elements();  返回的是一个集合



### Dom4j解析XML获取属性

- 创建解析器对象

  ```java
  SAXReader reader = new SAXReader();
  ```

- 读取文件

  ```java
  Document document = reader.read(Dom3.class.getClassloader.getResourse("contanct.xml"));
  ```

- 获取第一个子标签的属性id的属性值

  属性的获取：必须要先获取属性所在的标签对象

  ```java
  Element conElement = document.getRootElement().element("contanct);
  ```

- 方式1：通过属名称来获取属性值

  ```java
  String content = conElement.attributeValue("id");
  ```

- 方式2:Attribute对象来获取属性值

  ```java
  //获取第一个子标签对象
  Element conElement = document.getRootElement().element("contanct);
  Attribute idAttr = conElement.attribute("id");
  String name = idAttr.getNmae();
  String value = idAttr.getValue();   
  ```

- 获取节点的多个属性  —迭代输出

  ```java
   List<Attribute>  attrList = conElement.attributes();
  ```

#### 总结：

> 获取属性两种方式
>
> 1）通过节点对象获取属性值：attributeValue(“属性名称”)-------->String
>
> 2)  通过节点对象获取属性对象  attibute(“属性名称”)--—-—-->Attribute
>
> 3)  通过节点对象获取所有属性   attibutes(“属性名称”)————>List



### Dom4j解析XML获取文本



- 创建解析器并读取xml文件

  ```java
  SAXReader reader = new SAXReader();
  ```

  

- 创建文档对象

  ```java
  Document document = reader.read(Dom3.class.getClassloader.getResourse("contanct.xml"));
  ```

- 获取”\<name>张三\<name>“内容

  ```java
  Element nameElememt = document.getRootElement.element("contanct").element("name");
  //getTest()方法
  
  String cintanct = nameElememt.getText();
  ```

- 通过父标签获取子标签的文本内容

  ```java
  Element conElement = document.getRootElement().element("contanct);
               conElement.getElementText();                                       
  ```

  

### 将Xml文件抽象为一个对象–-面向对象编程

面向过程编程关注的是方法，操作的具体方法（于面向对象的关注点不同！）

1. 将标签封装成一个类  —-目的获得xml对象
2. 读取xml文件
3. 创建一个List集合（ArrayList/LinkedList/Vectory)泛型指定：\<contanct>Contanct类
4. 读取xml文件：根标签elements() ;List\<Element>
5. 封装成Contanct对象  Contanct ct =  new Contanct();
6. setxxx(),   getxxx()



## 将对象输出为硬盘上的xml文件

1. 读取原xml文件：dom4j 解析器

2. 创建输出流对象，指定硬盘上的路径

   ```java
           XMLWriter writer = new XMLWriter();
   ```

3. 将内存只能的document对象利用XMLWirte()的，将document对象输出到硬盘上



读取xml文件

创建输出流对象：指定当前硬盘路径

创建输出格式：OutputFormat

设置编码格式

