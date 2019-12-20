# sba-archetype

spring-boot-assembly应用架构脚手架。

可快速创建用于开发环境的基础应用架构。

## 项目源码结构

```text
├─bin
│      restart.sh
│      shutdown.sh
│      startup.bat
│      startup.sh
├─logs
│      startup.log
├─main
│  ├─assembly
│  │      assembly.xml
│  ├─java
│  │  └─${package}
│  │     ├─controller
│  │     │     HelloController.java
│  │     ├─orm
│  │     └─Application.java
│  └─resources
│      │  application.yml
│      │  application-dev.yml
│      │  application-prod.yml
│      │  application-test.yml
│      │  logback-spring.xml
│      ├─db
│      │      schema.sql
│      │      data.sql
│      ├─static
│      │      index.js
│      └─templates
│             index.html
└─test
```

## 安装脚手架

关于 maven 脚手架相关的知识请自行搜索或查阅相关书籍文档。

将本项目克隆或下载到本地目录，执行

```
# 发布到本地
mvn clean install
# 让maven能够找到该项目并且知道它是个骨架项目
mvn archetype:crawl
```

将脚手架发布到本地maven仓库中。

如果需要将其发布到私服中，请配置 distributionManagement 元素内容为自己的私服地址。（需要私服的发布账号及密码）

```text
<distributionManagement>
  <repository>
    <id>xxx</id>
    <name>xxx</name>
    <url>http://host/nexus/content/repositories/xxx</url>
  </repository>
  <snapshotRepository>
    <id>xxx-snapshot</id>
    <name>xxx-snapshot</name>
    <url>http://host/nexus/content/repositories/xxx-snapshot</url>
  </snapshotRepository>
</distributionManagement>
```

执行

```
mvn clean deploy
```

将脚手架发布到私服。

查看仓库中会多一个：archetype-catalog.xml 文件。

内容大致如下：

```
...
<archetype>
  <groupId>com.quanshi</groupId>
  <artifactId>sba-archetype</artifactId>
  <version>1.0.0</version>
  <description>sba-archetype</description>
</archetype>
...
```

## 使用脚手架

当脚手架发布成功后，就可以使用了。

使用交互的方式：

```
mvn archetype:generate
# 只拉取本地脚手架
mvn archetype:generate -DarchetypeCatalog=local
```

出现脚手架列表：

```
Choose archetype:
...
10: internal -> org.apache.maven.archetypes:maven-archetype-webapp (An archetype which contains a sample Maven Webapp project.)
11: local -> com.quanshi:sof-archetype (sof-archetype)
12: local -> com.quanshi:sba-archetype (sba-archetype)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 7: 
```

选择 `12: local -> com.quanshi:sba-archetype (sba-archetype)`

按照提示，输入下面几项内容：

- groupId: 你要创建的项目的groupId
- artifactId: 你要创建的项目的artifactId
- version: 项目版本号
- package: 项目基础包路径


最终得到项目。

或者可以使用一条命令快速生成：

```
mvn archetype:generate \
-DarchetypeGroupId=com.quanshi \
-DarchetypeArtifactId=sba-archetype \
-DarchetypeVersion=1.0.0 \
-DgroupId=com.quanshi \
-DartifactId=demo \
-Dversion=1.0.0 \
-Dpackage=com.quanshi.demo
```

如果是别人发布到私服，你通过私服来创建的话。

将私服地址配置到setting.xml中。

配置mirror或者repository均可。
