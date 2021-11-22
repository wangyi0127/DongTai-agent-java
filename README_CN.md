## DongTai-agent-java

[![django-project](https://img.shields.io/badge/django%20versions-3.0.3-blue)](https://www.djangoproject.com/)
[![dongtai-project](https://img.shields.io/badge/dongtai%20versions-beta-green)](https://github.com/huoxianclub/dongtai)
[![dongtai--agent--java](https://img.shields.io/badge/dongtai--agent--java-v1.0.0-lightgrey)](https://github.com/huoxianclub/dongtai-web)
[![license GPL-3.0](https://img.shields.io/github/license/HXSecurity/DongTai-agent-java)](https://github.com/HXSecurity/DongTai-agent-java/blob/main/LICENSE)

- [English document](README.md)

## 项目介绍

DongTai-agent-java 是**洞态IAST** 针对 Java 应用开发的数据采集端。在添加 iast-agent 代理的 Java 应用中，通过改写类字节码的方式采集所需数据，然后将数据发送至 DongTai-openapi 服务，再由云端引擎处理数据判断是否存在安全漏洞。

DongTai-agent-java 由`agent.jar`、`iast-core.jar `、`iast-inject.jar`、`dongtai-servlet.jar`四部分构成，其中：

- `agent.jar`用来管理 agent 的生命周期和配置。agent 的生命周期包括下载、安装、启动、停止、重启、卸载。agent 的配置包括配置应用启动模式、漏洞检验模式、是否开启代理等。
- `iast-core.jar`是核心 jar 包，其主要功能是：字节码插桩、数据采集、数据预处理、数据上报、第三方组件管理等。
- `iast-inject.jar`是间谍 jar 包，用于注入至`BootStrap ClassLoader`，后续在目标应用中调用`iast-core.jar`中的数据采集方法
- `dongtai-servlet.jar`用于获取应用发送的请求以及收到的响应，用于数据展示以及请求重放功能。

## 应用场景

- DevOps流程
- 上线前安全测试
- 第三方组件管理
- 代码审计
- 0 Day挖掘


## 快速上手

### 快速使用

请参考：[快速开始](https://hxsecurity.github.io/DongTai-Doc/#/doc/tutorial/quickstart)

### 快速开发

1. Fork [DongTai-agent-java](https://github.com/HXSecurity/DongTai-agent-java) 项目到自己的github仓库并 clone 项目：

   ```shell
   git clone https://github.com/<your-username>/DongTai-agent-java
   ```

2. 根据需求编写代码

3. 使用 Maven 编译 DongTai-agent-java ：

   ```shell
   mvn clean package -Dmaven.test.skip=true
   ```

    - jdk版本为1.8

4. 编译结束后会在项目根目录生成文件夹`./release`：

   ```
   release
   ├── iast-agent.jar
   └── lib
       ├── dongtai-servlet.jar
       ├── iast-core.jar
       └── iast-inject.jar
   ```

5. 拷贝`iast-core.jar`、`iast-inject.jar`、`dongtai-servlet.jar`到系统临时目录。获取系统临时目录可运行以下 Java 代码：

   ```java
   System.getProperty("java.io.tmpdir");
   ```

6. 运行应用，测试代码（以SpringBoot应用为例）：`java -javaagent:/path/to/iast-agent.jar -Ddebug=true -jar app.jar`

7. 贡献代码。如果您想要向洞态 IAST 团队贡献代码，请阅读完整的[贡献指南](https://github.com/HXSecurity/DongTai/blob/main/CONTRIBUTING.md)

#### 支持的Java版本及中间件

- Java 1.6+
- Tomcat、Jetty、WebLogic、WebSphere、SpringBoot等主流软件和中间件

**notice:** `jdk 1.6`开发的Agent需要使用`Maven 3.2.5`进行构建

