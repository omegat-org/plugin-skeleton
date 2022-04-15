# OmegaT plugin development skeleton

## How to get skeleton into your project

It is recommend to use `Use this template` button on upper-right side of github project page,
to create your project repository.

![](https://docs.github.com/assets/images/help/repository/use-this-template-button.png)

## Where you should change?

- `gradle.properties`
  - Properties: name, description, title, website and category
- Plugin Main class name in `build.gradle.kts`.

## Build system

This skeleton use a Gradle build system as same as OmegaT version 4.3.0 and later.

## Dependency

OmegaT and dependencies are located on remote maven repositories.
It is necessary to connect the internet to compile your project.

Current skeleton example refers OmegaT 5.7.1.

All complex configurations to refer OmegaT core are handled by
`gradle-omegat-plugin`.

## FatJar(ShadowJar)

OmegaT considered a plugin is a single jar file. If it is depend on some libraries, 
you should ship your plugin with these libraries.
It is why generating a FatJar, a single jar file with all runtime dependencies
which is not provided with OmegaT.

`gradle-omegat-plugin` offers special gradle configuration `ParckIntoJar`.
When specified it, gradle will generate a proper FatJar for you.


## Where is a built artifact?

You can find distribution files in `build/distributions/*.zip`.
Also you can find jar files at `build/libs/`

## Github actions

There is an example script to use Github Actions for CI/CD.


## Installation

You can get a plugin jar file from zip distribution file.
OmegaT plugin should be placed in `$HOME/.omegat/plugin` or `C:\Program Files\OmegaT\plugin`
depending on your operating system.
