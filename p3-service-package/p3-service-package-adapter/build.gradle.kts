plugins {
    id("org.springframework.boot")
}

dependencies {

//    项目模块依赖
    implementation(project(":p3-service-package:p3-service-package-application"))

//    基础框架依赖
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")

//    工具依赖
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}