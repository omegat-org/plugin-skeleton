# OmegaT plugin development skelton

## Where you should change?

- A location of source: src/main/java/\*
- Project name in settings.gradle
- Plugin Manifest description in gradle.properties.
- Test code: src/test/java/\* and src/test/resources/\*
- Integration test code: src/integration-test/java/\* and src/integration-test/resources/\*
- Coding rules: config/checkstyle/checkstyle.xml and config/checkstyle/header.txt

## Build system

This skelton use Gralde for build system as same as OmegaT version 4.0 and later.

## Dependency

OmegaT and dependencies are located on remote maven repositories.
It is nessesary to connect the internet at least first time to compile.

## Extensions from Gradle defaults

- Integration test support.
- `Provided` configuration for OmegaT classes and libraries that is bundled with OmegaT.
- Static code verification with Checkstyle and FindBugs.
- FatJar generation.

## FatJar

OmegaT considered a plugin is a single jar file. If it is depend on some library, you should ship your plugin with these library. It is why skelton generate FatJar, single jar with all runtime dependencies without provided by OmegaT distribution. 

## Install

Please download zip file from Github release. You can get jar file from zip distribution.
OmegaT plugin should be placed in `$HOME/.omegat/plugin` or `C:\Program Files\OmegaT\plugin`
depending on your operating system.

## License

This project is distributed under the GNU general public license version 3 or later.

