plugins {
    `java-library`
}

dependencies {

//    项目模块依赖
    api(":p3-service-package-domain")
    api(":p3-service-package-infrastructure")

//    工具依赖
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}