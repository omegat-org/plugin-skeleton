plugins {
    java
    // groovy
    // kotlin("jvm") version "1.3.72"
    checkstyle
    distribution
    maven
    id("org.omegat.gradle") version "1.4.2"
}

version = "0.0.1"

omegat {
    version = "5.4.1"
    pluginClass = "org.omegat.filters2.text.dokuwiki.DokuWikiFilter"
}

dependencies {
    packIntoJar("org.slf4j:slf4j-api:1.7.21")
    implementation("commons-io:commons-io:2.5")
    implementation("commons-lang:commons-lang:2.6")
    implementation("org.slf4j:slf4j-nop:1.7.21")
    testImplementation("junit:junit:4.12")
    testImplementation("xmlunit:xmlunit:1.6")
    testImplementation("org.madlonkay.supertmxmerge:supertmxmerge:2.0.1")
    testImplementation("com.alibaba:fastjson:1.2.17")
}

checkstyle {
    isIgnoreFailures = true
    toolVersion = "7.1"
}

distributions {
    main {
        contents {
            from(tasks["jar"], "README.md", "COPYING", "CHANGELOG.md")
        }
    }
}
