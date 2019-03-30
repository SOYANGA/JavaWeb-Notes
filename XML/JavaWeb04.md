# JavaWeb04

*今天内容*

**XML：SAX解析**

​	使用SAX解析将xx.xml中的标签封装成对象

**约束：XML文件约束**

DTD:相对schema约束比较简单

schema:框架中的配置文件中的约束名称空间



**Tomcat服务器的简单认识**

​	什么是web服务器的简单认识

​	市面上常见的web应用服务器

​	Tomcat服务器得到目录结构

​	如何去开发一个动态web工程



如何去构建一个

**Servlet的基本使用**

http协议相关的请求头和响应头



*回顾内容*：



Dom4j中的xpth技术

​	xptah技术：可以去快速定位到某个具体的标签

​	常见的两个方法	

​		selectSingNode(“xpath表达式”)；—->Node

​		selectNodes(“xpath表达式”);—->List\<Ndoe>

关于xpath表达的语法:

1)  / ：绝对路径     /AAA(AAA根元素)  /AAA/BBB

2) **//** ：不分层级关系//contact：不分层级关系型选中当前所有的contact标签

3) **[** ] : //contact[@id=‘002’]  选中…的标签

4)**@**XX ：xptah 中指定属性

5)**=** : 确定值

6)Text() :描述当前标签的文本 ：//name[Test()=‘xxx’]





## DOM解析   VS    SAX解析

### DOM

读取原理： 将整个xml加载完之后进行读取：

​		占用内存大，如果文件过大，读取的时候可能造成内存溢出：OOM溢出

特点：可以一次按照标签顺序读取，可以往回读。

编程方法：面向对象

### SAX

读取原理：读取一点解析一点

​		占用内存小，使用的时候有利于空间的扩展。

特点：只能从上往下读，不能往回读。

编程方式：事件编程



|          DOM解析          | SAX解析 |
| :-----------------------: | :-----: |
| 将整个xml加载完成之后继续 |         |
|                           |         |
|                           |         |

​		



## XML约束

：W3C组织给xml文件定义了相关的规则（举例：标签先后书顺序的加载）

> 为什么使用DTD
>
> 通过 DTD，您的每一个 X**ML 文件均可携带一个有关其自身格式的描述**。
>
> 通过 DTD，**独立的团体可一致地使用某个标准的 DTD 来交换数据。**
>
> 而您的应用程序也可使用**某个标准的 DTD 来验证从外部接收到的数据**。
>
> 您还可以使用 DTD 来**验证**您自身的数据。

### 1）dtd约束：最简单的一种方式：w3c文档中查看相关语法

```xml-dtd
<!--dtd的内部引用方式-->
<!DOCTYPE note [
        //声明当前标签顺序的时候可以数量词来标记标签名称
        //元素名称+  :表示当前元素出现 一次或多次
        //元素名称？ :表示当前元素出现 一次或次
        //元素名称？ ：表示当前元素出现 零次或多次
    <!ELEMENT note (to,from,heading,body)>  
        <!ELEMENT to      (#PCDATA)>
        <!ELEMENT from    (#PCDATA)>
        <!ELEMENT heading (#PCDATA)>
        <!ELEMENT body    (#PCDATA)>
        ]>


<!--外部引入dtd约束-->
<!DOCTYPE note SYSTEM "note.dtd">
//之后常用的
<!DOCTYPE configuration PUBLIC  "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
```

​	

关于dtd的一些基本语法



- 声明一个元素

```xml-dtd
<!ELEMENT 元素名称 类别>
```

​	或者

```xml-dtd
<!ELEMENT 元素名称 (元素内容)>
```

- 任何元素的定义：当前标签中可以定义任何标签

```xml-dtd
<!ELEMENT 元素名称 ANY>
```

- 只有 PCDATA 的元素

  只有 PCDATA 的元素通过圆括号中的 #PCDATA 进行声明：

```xml-dtd
<!ELEMENT 元素名称 (#PCDATA)>

```

- 空元素 在xml文件中指定标签

  ```xml-dtd
  <!ELEMENT 元素名称 EMPTY>
  <!ELEMENT br EMPTY>
  <br />
  ```

- 带有子元素（序列）的元素

  ```xml-dtd
  <!ELEMENT 元素名称 (子元素名称 1)>   
  <!-- 或者 -->
  <!ELEMENT 元素名称 (子元素名称 1,子元素名称 2,.....)>
  
  <!ELEMENT note (to,from,heading,body)>
  ```



定义-DTD中的属性

```
<!ATTLIST 元素名称 属性名称 属性类型 #IMPLIED/#REQUIRED/#FIXED>
```



| 值           | 解释           |
| ------------ | -------------- |
| 值           | 属性的默认值   |
| #REQUIRED    | 属性值是必需的 |
| #IMPLIED     | 属性不是必需的 |
| #FIXED value | 属性值是固定的 |

属性类型选择：

| 类型               | 描述                          |
| ------------------ | ----------------------------- |
| CDATA              | 值为字符数据 (character data) |
| (*en1*\|*en2*\|..) | 此值是枚举列表中的一个值      |
| ID                 | 值为唯一的 id                 |
| IDREF              | 值为另外一个元素的 id         |
| IDREFS             | 值为其他 id 的列表            |
| NMTOKEN            | 值为合法的 XML 名称           |
| NMTOKENS           | 值为合法的 XML 名称的列表     |
| ENTITY             | 值是一个实体                  |
| ENTITIES           | 值是一个实体列表              |
| NOTATION           | 此值是符号的名称              |
| xml:               | 值是一个预定义的 XML 值       |





### 2）schema约束

> **什么是 XML Schema？**
>
> XML Schema 的作用是定义 XML 文档的合法构建模块，类似 DTD。
>
> **XML Schema:**
>
> - 定义可出现在文档中的元素  
> - 定义可出现在文档中的属性  
> - 定义哪个元素是子元素  
> - 定义子元素的次序  
> - 定义子元素的数目  
> - 定义元素是否为空，或者是否可包含文本  
> - 定义元素和属性的数据类型  
> - 定义元素和属性的默认值以及固定值 
>
> **XML Schema 是 DTD 的继任者**
>
> 我们认为 XML Schema 很快会在大部分网络应用程序中取代 DTD。
>
> **理由如下：**
>
> - XML Schema 可针对未来的需求进行扩展  
> - XML Schema 更完善，功能更强大  
> - XML Schema 基于 XML 编写  
> - XML Schema 支持数据类型  
> - XML Schema 支持命名空

是DTD的约束替代者，语法结构复杂，并且带有名称空间

Sechma是以.xmd结尾的



## Tomcat 服务器

Web应用服务器tomcat

Tomcat容器，可以apache公司产品，容器共享数据

Html,jsp(java服务页面) css,js

放入一个目录进行间接的访问

XXXWeb目录

​	WEB-INF-规定目录

​		classes–目录  java源码文件   contact.class

​		lib—第三方jar包

​		javax,servelt-api,jar,Dom4j.jar

将网站---文件夹

Root	

​	index.html–>首页

Tomcat下载

​	安装版：后缀.exe  .mis

​	压缩版:

​		Windows  .zip—>解压

Windows:

​	Startup.bat—>启动 tomcat

​	Shutdown.bat—>关闭 tomcat

### 访问tomcat:

url:http://localhost:8080

//访问静态资源文件的地址

http://一种协议：请求



localgost:本地域名（企业统称访问:doMain）

顶级域名com

二级域名

三级域名www.localhost:8080



8080：tmocat 默认端口号808     --->JVM  bindExecption 端口号被占用

每一个都有特定的端口号

mysql:3306

hbuilder:8020

极域软件8080

端口号0~65535有效端口  0~1024保留端口号使用

bbs：当前tomcat安装目录webapps的网站工程名称

hello.html:访问 bbs工程下的静态资源文件

#### 注意事项：

Tomcat启动目录中的bin:startup.bat执行参数

如果path环境如果是普通方式，tomcat会出现闪屏，启动失败的

Tomcat里面：变量 catalina：需要在path中找到系统变量：JAVA_HOME



### Tomcat目录结构

| 目录     | 说明                                             |
| -------- | ------------------------------------------------ |
| /bin     | 存放各种操作系统下用于启动和停止Tomcat的命令文件 |
| /conf    | 存放Tomcat服务器各种配置文件                     |
| /lib     | 存放Tomcat服务器所需的依赖Jar文件                |
| /logs    | 存放Tomcat的日志文件                             |
| /temp    | 存放Tomcat运行时的临时文件                       |
| /webapps | 发布Web应用时，默认会将Web应用的发布到此目录中   |
| /work    | Tomcat把由JSP成的Servlet放于此目录下             |



## Servlet初识:high_brightness:

静态资源

​	当页面的源代码没有发生变化

动态资源

​	当页面源码码会随时间发生了变化

​	Servlet程序

​	

​	Servlet是服务器应用程序

​	全称：sever applet , 借助于容器来运行(Tomcat)

