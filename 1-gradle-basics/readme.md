# Simple gradle project

## Initializing Gradle project
> Prerequisites: Gradle should be installed on your machine

> For more info on initializing Java project check [here](https://guides.gradle.org/building-java-applications/)

```
mkdir my-first-gradle-project

gradle init  # create an empty project
```
This will create a simplest project which does nothing.

In order to initialize a Gradle project for our first Java automation application let's run init command with the following flags

```$xslt
gradle init --type java-library
```
#### Generated project files

The `init` task runs the `wrapper` task first, which generates the `gradlew` and `gradlew.bat` wrapper scripts. 

Then it creates the new project with the following structure:
```$xslt
.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   └── java
    │       └── Library.java
    └── test
        └── java
            └── LibraryTest.java
```
`build.gradle` - a main Gradle file where build configuration script is stored. The build script defines a project and its tasks

`settings.gradle` - file is heavily commented, but has only one active line with `rootProject.name` defined. This assigns the name of the root project to ‘gradle-project’. Settings file comes into play in a multi-project structure

A proper java project structure is built by init script as well (`src/main/java` and `src/test/java`)
