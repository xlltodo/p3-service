plugins {
    `java-library`
}

dependencies {

//    项目模块依赖
    compileOnly(project(":p3-service-package:p3-service-package-domain"))

//    基础框架依赖
    api("com.mysql:mysql-connector-j")
    api("com.baomidou:mybatis-plus-boot-starter")
    api("org.springframework.cloud:spring-cloud-starter-openfeign")
    api("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    api("org.redisson:redisson-spring-boot-starter")
    api("org.springframework:spring-webflux")

//    工具依赖
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}