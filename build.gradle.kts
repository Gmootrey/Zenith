plugins {
    application
    id("com.gradleup.shadow") version "8.3.1"
}

application.mainClass = "com.gmootrey.Zenith.Bot" //
group = "org.example"
version = "1.0"

val jdaVersion = "5.6.1" //



repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.6.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.isIncremental = true

    // Set this to the version of java you want to use,
    // the minimum required for JDA is 1.8
    sourceCompatibility = "1.8"
}