Spring-boot、dubbo、zookeeper整合

spring-boot-dubbo-api:定义接口规范

spring-boot-dubbo-provider: 模拟服务提供方

spring-boot-dubbo-consumer: 模拟服务调用方

整合版本：
spring-boot: 2.0.4版本
dubbo-spring-boot-starter: 2.0.0版本

zkClient: 0.10版本

1. 搭建zookeeper服务
参见网上现有资料搭建单服务支持，启动。
2. 创建服务dubbo服务提供方工程及服务消费方工程。
3. 配置dubbo-admin服务，查看zookeeper服务节点运行情况 
4. 整合过程中消费者服务需要关注dubbo注解与spring容器注解启动加载顺序。dubbo注解优先加载。


