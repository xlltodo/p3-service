plugins {
    `java-library`
}

dependencies {

//    项目模块依赖
    api(project(":p3-service-package:p3-service-package-domain"))
    api(project(":p3-service-package:p3-service-package-infrastructure"))

//    基础框架依赖
    compileOnly("org.springframework:spring-context")

//    工具依赖
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    compileOnly("io.swagger.core.v3:swagger-annotations")
    compileOnly("com.fasterxml.jackson.core:jackson-annotations")
}