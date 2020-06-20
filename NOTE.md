### 一、互助网项目--订单管理系统
#### 1.功能描述
**互助网 (一个同校学生互相帮助的网站)**
实现同校同校在网站上发布帮助请求订单
（包含佣金和期限时间）其他同校用户可见，其他同校用户可以接单。
#### 2.实现功能
#### 3.实现步骤
1.搭建一个maven项目
2.配置Tomcat
3.运行Tomcat，看是否配置成功
4.导入maven（导入jar包）
（1）Servlet
（2）jsp
（3）mysql驱动 
（4）standard 包
>具体依赖查看文件 pom.xml
5.创建项目包结构
### 二、遇到的问题和解决
#### 1. 如何同步创建项目，而不是文件夹
创建项目:
https://www.cnblogs.com/whitepine/articles/9282260.html
#### 2. git 里CRLF和LF是两种不同的换行格式的问题
1.问题描述：
执行git add . 的时候警告
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200619193422913.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2phcnZhbjU=,size_16,color_FFFFFF,t_70)
2.解决方案:
别用那个坑人的解决，这个警告问题不大
