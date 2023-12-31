plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    id("java-library")
    id("antlr")
}

repositories {
    mavenCentral()
}

group = "com.xpression"
version = "0.0.1"

sourceSets {
    main {
        java {
            srcDir("${project.projectDir}/build/generated")
        }
        kotlin {
            srcDir("src/main/kotlin")
        }
    }
    test {
        kotlin {
            srcDir("src/test/kotlin")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-package", "com.xpression.internal", "-visitor")
    outputDirectory = File("${project.projectDir}/build/generated/com/xpression/internal")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
    dependsOn(tasks.generateGrammarSource)
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
    dependsOn(tasks.generateTestGrammarSource)
}

dependencies {
    antlr("org.antlr:antlr4:4.13.1")
    implementation("org.antlr:antlr4-runtime:4.13.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("org.apache.commons:commons-text:1.10.0")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.10")
    testImplementation("org.junit.platform:junit-platform-suite-engine:1.10.0")
}

tasks.test {
    useJUnitPlatform()
}