plugins {
    `java-platform`
    id("io.spring.dependency-management") version "1.1.4"
    id("org.springframework.boot") version "3.1.6" apply false
}

javaPlatform {
    allowDependencies()
}

group = "${project.findProperty("group")}"
version = "${project.findProperty("version")}"
description = "p3-services"

allprojects {

    repositories {
        mavenCentral()
//        maven {
//            url = uri("http://nexus3.yuntai-test.com/repository/yt-maven2/")
//        }
    }

    group = "${group}"
    version = "${version}"
}

subprojects {

    plugins.withId("org.springframework.boot") {

        apply(plugin = "java")
        apply(plugin = "io.spring.dependency-management")

        configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        dependencyManagement {

            imports {
                mavenBom("org.springframework.boot:spring-boot-dependencies:${project.findProperty("springBootVersion")}")
                mavenBom("org.springframework.cloud:spring-cloud-dependencies:${project.findProperty("springCloudVersion")}")
                mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${project.findProperty("springCloudAlibabaVersion")}")
            }

            dependencies {
                dependency("com.baomidou:mybatis-plus-boot-starter:${project.findProperty("mybatisPlusVersion")}")
                dependency("jakarta.annotation:jakarta.annotation-api:${project.findProperty("jakartaVersion")}")
                dependency("org.projectlombok:lombok:${project.findProperty("lombokVersion")}")
                dependency("io.swagger.core.v3:swagger-annotations:${project.findProperty("swaggerVersion")}")
                dependency("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:${project.findProperty("knife4jVersion")}")
            }
        }
    }
}
