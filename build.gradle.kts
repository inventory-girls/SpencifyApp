import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"

}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.webjars:Bootstrap-3-Typeahead:3.1.1")
    implementation("org.webjars:webjars-locator-core:0.52")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//The plugins section contains the org.springframework.boot plugin, io.spring.dependency-management plugin, and Kotlin plugins: jvm, plugin.spring, and plugin.jpa.
//
//The group and version properties define the project's Maven coordinates.
//
//The java.sourceCompatibility property sets the Java version used for compilation.
//
//The repositories section specifies the Maven Central repository.
//
//The dependencies section declares the project's dependencies, including Spring Boot starters for web, data JPA, and Thymeleaf templating, along with other libraries like Jackson Kotlin module and MySQL Connector/J.
//
//The developmentOnly dependency is included to enable Spring Boot's developer tools. The testImplementation dependency includes Spring Boot's testing starter and its transitive dependencies.
//
//The tasks.withType<KotlinCompile> block sets the compiler options for Kotlin, including the JVM target version and enabling strict mode for JSR-305 annotations.
//
//Finally, the tasks.withType<Test> block configures the test task to use JUnit 5.



