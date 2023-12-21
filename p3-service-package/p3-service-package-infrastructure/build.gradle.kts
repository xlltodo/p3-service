plugins {
    `java-library`
}

dependencies {

    compileOnly(":p3-service-package-domain")

    api("com.mysql:mysql-connector-j")
    api("com.baomidou:mybatis-plus-boot-starter")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}