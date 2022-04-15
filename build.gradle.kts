plugins {
    java
    checkstyle
    distribution
    id("org.omegat.gradle") version "1.5.3"
}

version = "0.0.1"

omegat {
    version = "5.7.1"
    pluginClass = "your.plugin.package.and.Class"
}

dependencies {
    // when want to pack into fatJar
    // packIntoJar("foo:boo:1")
}

distributions {
    main {
        contents {
            from(tasks["jar"], "README.md", "CHANGELOG.md")
        }
    }
}
