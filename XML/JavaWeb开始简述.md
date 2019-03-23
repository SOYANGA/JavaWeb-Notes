# JavaWeb

## WEB：模型 C_C

- C/S：客户端和服务器的交互

  - 特点：
  - 1)客户端需要升级才能使用服务器的高版本功能
  - eg:教务系统/学生管理系统
  - 2）维护成本低
  - 3）访问量不大

- B/S：浏览器和服务器的交互

  - http服务器：nginx–俄罗斯人开发的   并发量5万个

    ​		Nginx+Keepalived:高可用，高并发

    ​		Apache中的其他项目

  - Web应用服务器：

    - Tomcat:理论上并发量500个

  - 复杂系统：电商网站  

  - XXX论坛：简单系统

  ​	B:Business

  ​	C:Customer

  - 电商模式：B2C/C2B/P2P/…/B2B2C

​	

SSM：开发某个电商平台

SpringMvc



## XML可扩展标记语言

## XML的出现原因

html是一个结构不严谨的语言，w3cSchool组织用Xml语言替代html这种语言，但是并没有成功，而是作为配置文件，三大框架(structs2,hibernate,      Spring,SpringMvc,mybatis)

## XML语言和HTML语言的区别

1)结构区别

html语言：规定当前网页的结构特点

遵循html标签的规范：

XML：作为软件配置的文件一种结构

​	后期框架的配置文件都是xml

2)语法区别

Html:语言不够严谨：eg:标签可以不配对，即使不配对的标签也可以没有结束符号

Xml结构严谨：是必须符合xml的语法规则的

## XML的作用



### 1）作软件的配置文件

​	框架得到配置文件等等

​	xxx.properties: JavaSE 属性集合类  Key=value 模式

举例：描述一个主机

Properties方式

IP地址和端口号  ip=192.168.3.1  port=80



xml方式

```xml
<host>
    <ip>192.168.3.1</ip>
    <port>80</port>
</host>
```

### 2)作为一个“小型”的数据库

​	Xml: 描述联系人的

```xml
<contact-list>
	<name>xxx</name>
    <sex>xxx</sex>
    <call>xxx</call>
    <email>xxx</email>
</contact-list>
```

​	MySql:数据库 建库 建表 字段



## XML的语法规则

### 标签

- 标签必须成对出现，否则会报错
- 前后标签必须匹配成对出现，但是命名空间(nameSpace)除外(关于命名空间之后说明)
- 标签中不能出现空格
- 数字不能作为标签的开头，下划线“__”是可以作为标签开头的

### 属性

- 属性在xml中是可以单引号或者是双引号

- 属性名称 = “XXX”  / 属性名称 = ‘XXX’
- 一个xml中可以指定多个属性

### 注释

同html注释 <!– 注释 –->	



### 文档声明

```xml
<?xml version="1.0" encoding="UTF-8"?>
<_student id="01">张三</_student>
<!--张三-->
```

**\<?xml version="1.0" encoding="UTF-8"?>**

version：指定当前xml文件的默认版本

encoding：指定当前xml文件的编码格式：默认 utf-8

如果是使用工具：Eclipse/IDEA,即使在编码的时候编成GBk格式，最终将文件以浏览器格式打开不会出现乱码问题

编码和解码统一一推荐：utf-8



### 转译字符

和html转义字符大致一样：>—>&gt ；   <—–< &lt ;

&nbsp

CDATA块格式：原样输出

```
<![CDATA[   
需要原样输出的文本
]]>
```

需求：通过上面学习的语法，描述联系人：姓名，性别，联系方式，邮箱，地址,并且



## Xml的解析方式

Dom:dom4j

​	Dom for java

​	xpath技术：表达式的语法规则

​	Josn解析

Servlet:server applet

XML解析/DOM解析/SAX解析