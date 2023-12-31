plugins {
    `java-library`
}

dependencies {

//    基础框架依赖
    compileOnly("org.springframework:spring-context")
    compileOnly("com.baomidou:mybatis-plus-annotation")
    compileOnly("com.baomidou:mybatis-plus-extension")
    compileOnly("org.springframework:spring-web")
    compileOnly("org.springframework:spring-tx")

//    工具依赖
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("jakarta.annotation:jakarta.annotation-api")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}