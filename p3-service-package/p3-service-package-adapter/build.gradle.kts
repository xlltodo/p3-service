plugins {
    id("org.springframework.boot")
}

dependencies {

//    项目模块依赖
    implementation(":p3-service-package-application")

//    基础框架依赖
    implementation("org.springframework.boot:spring-boot-starter-web")

//    工具依赖
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter")

//    测试依赖
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}