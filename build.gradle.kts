import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
        implementation("com.jayway.jsonpath:json-path:2.7.0")
        implementation("org.json:json:20090211")
        testImplementation("org.slf4j:slf4j-nop:2.0.0")
        testImplementation("com.codeborne:selenide:6.7.4")
        testImplementation("io.rest-assured:rest-assured:5.2.0")
        testImplementation("io.rest-assured:kotlin-extensions:5.2.0")
        implementation("org.hamcrest:hamcrest:2.2")
        testImplementation("org.jetbrains.kotlin:kotlin-stdlib")
        testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.0")
        testImplementation("io.qameta.allure:allure-selenide:2.18.1")
        testImplementation("io.qameta.allure:allure-rest-assured:2.18.1")
        testImplementation("com.github.javafaker:javafaker:1.0.2")
        testImplementation("org.apache.poi:poi-ooxml:5.2.2")
        implementation("org.projectlombok:lombok:1.18.24")

        implementation("io.ktor:ktor-client-core:2.1.2")
        implementation("io.ktor:ktor-client-cio:2.1.2")
        implementation("io.ktor:ktor-client-websockets:2.1.2")
        implementation("io.ktor:ktor-client-logging:2.1.2")

        implementation("com.google.code.gson:gson:2.8.5")
        implementation("io.ktor:ktor-network:2.1.2")
        implementation("ru.yandex.clickhouse:clickhouse-jdbc:0.3.1-patch")
        testImplementation("io.kotest:kotest-assertions-core:5.3.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}