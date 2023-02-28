plugins {
  id("java")
  id("org.jetbrains.intellij") version "1.12.0"
}

group = "ee.carlrobert"
version = "1.1.4"

repositories {
  mavenCentral()
}

intellij {
  version.set("2021.1")
  type.set("IC")
  plugins.set(listOf())
}

dependencies {
  implementation("com.fifesoft:rsyntaxtextarea:3.3.2")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

tasks {
  patchPluginXml {
    sinceBuild.set("211")
    untilBuild.set("231.*")
  }

  signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }
}
