plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "devsy.toy"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.22.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.22.0")

    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

    /* 주로 asynchronous request */
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    /* synchronous request */
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.2") {
        exclude(group = "commons-fileupload", module = "commons-fileupload")
    }

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.test {
    useJUnitPlatform()
    exclude("**/learn/**")
}


tasks.withType<Test> {
    useJUnitPlatform()
}
