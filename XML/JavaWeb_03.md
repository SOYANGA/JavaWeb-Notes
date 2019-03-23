# JavaWeb_03

## dom4j中的一个插件

### xpath技术

#### Xpath的语法：

​	/---—->绝对路径

​	//–--—--—--> 无论层级关系 举例：//contanct

​	\* ———–>/AAA/* 通配符

​	[] ———–>什么…..的：类似定于

​	@—-----—->是什么属性…

​	and———>逻辑与

​	Text()———>标签的文本

### SAX解析：基于事件编程

事件编程—–—--->三要素

SAX解析的开发步骤



### SAX解析和DOM解析的区别



### XML中的两个约束

DTD,Schema约束

Schema约束要比DTD复杂，并且语法多



## 复习

dom解析(document树)的开发步骤---->dom4j工具

底层源码的实现:IO流的方式  读取XML文件

创建xml解析器对象

SAXReader—>读取文件（资源目录：resources)

地址：方式1绝对路径

​	方式2 使用反射原理 获取当前类的字节码文件对象，然后再获取字节码文件在内存方法区中的类加载器获取资源文件（classPtah目录下的文件)

读取XML文件：返回:document对象：

DOM解析中读取xml文件中涉及的主要的API：

​	获取标签对象的相关方法

​	getRootElement()获取根节点

​	Element(“标签对象”)；默认获取第一个子标签对象

​	Elements(“标签对象”)返回一个集合对象，获取同名的所有子节点

​	Elements(“标签对象”)获取当前根节点中所有的子标签，

返回集合对象获取孙标签对象-—–->获取它的父节点，在通过父节点获取孙节点

​	Document.getRootElemnet().element(“标签名称”).elememt(”标签“);

获取属性:Attribute

获取属性必须获取属性所在标签对象

方式1：获取当前标签对象.attributeValue(”“属性名称”)–—->String 属性值

方式二：可以通过当前标签对象获取



通过dom4j—->修改xml文件  覆盖xml文件内容

开发步骤

1. 读取xml文件：new SAXReader().read(url);———-Document

   //修改xml文件

   - 添加相关的：
     - 添加一个空文档（前提不需要读取源文件
     - 添加标签 添加属性….
   - 修改
     - 修改标签的属性 修改标签的文本
     - 标签对象获取属性值：Attribute——>SetValue(“属性值”);
     - 设置一个属性 setAttribute(“属性名称”，“属性值”)；
     - 当前节点对象.setText(“内容”）；
   - 删除：删除属性/节点
   - 删除节点对象
     - 当前对象。detach()
     - 当前节点的父节点.getRootElement().remove(conElement);

2. 使用XMLWriter对下个：输出文件

   Document document = new 	SAXReader().read(Dome.class.getClassLoader().getResource("contanct.xml"));

   OutPutStrean out  = new FileOutPutStream(new File(“XXX”))；

   OutputFormat  = OutputFormat.createCompactFormat();

   XMLWriter write = XMLWriter(输出流对象，输出格式);

   writer.write(document);
     outputStream.close();







今天内容

## Xptah

### 基本定义和语法

xpath：使用特定的语法快速定位某个节点

xptah是dom4j工具中一个插件：javaen-1.1-beta-6.jar

要是使用xpath必须导入jar包



xpah中涉及到的两个方法

```
查询某个节点:selectSingleNode("xptah表达")；->Node对象
查询多个节点:selectNodes("xpath表达)；----->List<Node>
```



> xpath的语法规则
>
> /–-->表示的绝对路径
>
> ​	如果以/开头，选中的是根元素，如果/在中间表示选中的子元素
>
> //—–-->不分层次结构关系：
>
> ​	//contanct:不分层级关系选中当前xml文件中所有的contanct标签
>
> \* —–>统配符
>
> ​	//contancy/*:不分层级关系选中contanct中的所有标签
>
> [ ]——>一般进一步确定元素的位置，类似于语文中的定语
>
> = --—-—--> ….的值是   //BB[@id=‘b1’]
>
> and  ———>逻辑与：并且的关系
>
> text() ———>指定文本

使用dom4j不仅仅可以解析xml文件，还可以解析“标准html文件“;

SAX解析：

​	sun公司的工具—––->jdk的api查询----->org.xml.\*api

### SAX解析和DOM解析的区别



#### DOM解析：基于面向对象编程

​	解析的过程中SAXReader——>一次性将xml文件全部加载然后再读取

​	最终会形成dom树 举例：\<contanct-lsit>

​	优点：在xml文件读取的时候可以来回反复度

​	不仅可以查询节点，还可以修改节点的信息

​	缺点：耗内存，耗时-—-->如果一次性加载的xml文件过大，会导致OOM内存溢出



​	java开发者习惯去用面向对象方式去解析。

#### SAX解析

​	读一点，解析一点—---->在解析的过程中，开始节点和结束节点以及文本内容都会触发的方法

​	优点：省空间

​	缺点：仅仅可查询不可修改！！！！！

​	

