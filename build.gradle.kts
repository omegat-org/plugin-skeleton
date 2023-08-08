plugins {
    java
    signing
    distribution
    maven
    id("com.diffplug.spotless") version "6.12.0"
    id("org.omegat.gradle") version "1.5.11"
}

version = "0.0.1"

omegat {
    version = "6.0.0"
    pluginClass = "org.omegat.filters2.text.dokuwiki.DokuWikiFilter"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    packIntoJar("org.slf4j:slf4j-api:2.0.7")
    implementation("commons-io:commons-io:2.5")
    implementation("commons-lang:commons-lang:2.6")
    implementation("org.slf4j:slf4j-nop:2.0.7")
    testImplementation("junit:junit:4.13")
    testImplementation("xmlunit:xmlunit:1.6")
    testImplementation("org.madlonkay.supertmxmerge:supertmxmerge:2.0.1")
    testImplementation("com.alibaba:fastjson:1.2.17")
}

distributions {
    main {
        contents {
            from(tasks["jar"], "README.md", "COPYING", "CHANGELOG.md")
        }
    }
}

val signKey = listOf("signingKey", "signing.keyId", "signing.gnupg.keyName").find {project.hasProperty(it)}
tasks.withType<Sign> {
    onlyIf { signKey != null }
}

signing {
    when (signKey) {
        "signingKey" -> {
            val signingKey: String? by project
            val signingPassword: String? by project
            useInMemoryPgpKeys(signingKey, signingPassword)
        }

        "signing.keyId" -> {/* do nothing */
        }

        "signing.gnupg.keyName" -> {
            useGpgCmd()
        }
    }
    sign(tasks.distZip.get())
    sign(tasks.jar.get())
}

val jar by tasks.getting(Jar::class) {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

spotless {
    java {
        target(listOf("src/*/java/**/*.java"))
        removeUnusedImports()
        palantirJavaFormat()
        importOrder("org.omegat", "java", "javax", "", "\\#")
    }
}
