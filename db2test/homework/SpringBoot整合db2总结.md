## SpringBoot整合db2总结：

1.对应db2数据库版本的jar包下载:可以参考：https://www.hangge.com/blog/cache/detail_2832.html. 自己按照步骤试了下，下载不了，可能是网络的原因。后来自己通过baidu搜索了db2 v11.1 的jar包，然后打开控制台在 **jar** 包同一级目录下执行如下命令将 **jar** 包安装到本地仓库：

```
mvn install:install-file -Dfile=db2jcc4.jar -DgroupId=com.ibm.db2 -DartifactId=db2jcc4 -Dversion=11.1 -Dpackaging=jar 
注意：
a.版本号的修改
b.执行命令时需要在Maven的setting.xml文件中将阿里云镜像注释掉，否则命令执行结果会失败。。自己也很迷。。
```

2.在pox.xml添加依赖：

```xml
<!--引入JDBC依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<!--引入DB2驱动包,自己需要的jar包手动添加到本地仓库中，建议版本设置为数据库版本-->
<dependency>
    <groupId>com.ibm.db2</groupId>
    <artifactId>db2jcc4</artifactId>
    <version>11.1</version>
</dependency>
<dependency>
    <groupId>com.ibm.db2</groupId>
    <artifactId>db2jcc_license_cu</artifactId>
    <version>11.1</version>
</dependency>
```

3.application.yml配置数据库   yml文件一定要注意缩进格式

```yaml
spring:
  #数据库连接配置
  datasource:
    driver-class-name: com.ibm.db2.jcc.DB2Driver #数据库链接驱动
    name: sbhw  #数据库名
    #jdbc:db2://<DB2的IP>:<端口>/<数据库名>:currentSchema=<要连接的schema名>;
    url: jdbc:db2://192.168.100.11:50001/sbhw:currentSchema=HOMEWORK;
    username: dwinst
    password: dwinst

#mybatis的相关配置
mybatis:
  #mapper配置文件
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.example.homework.model
  #开启驼峰命名
  configuration:
    map-underscore-to-camel-case: true

```

4.mapper层使用的是**UserMapper+Annotation**的方式实现user的增删改查功能（个人感觉这种方式更清爽 便捷）。
而使用UserMapper.xml文件实现db2Sql编写时，**添加user**时 页面显示id=null  但数据库中能添加成功且显示正确。且**修改功能**会报错。。所以自己选择了**UserMapper+Annotation**的方式实现增删改查。