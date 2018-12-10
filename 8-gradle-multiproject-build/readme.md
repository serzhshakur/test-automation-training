# Gradle multi-project

Very often while working on a project you need some parts of your project to lie separate yet be dependent on each other. In terms of test automation that could be a separate gradle projects for `web` and `api` tests. Here Gradle multi-project structure may come in help. 

> Multi-project builds helps with modularization. It allows a person to concentrate on one area of work in a larger project, while Gradle takes care of dependencies from other parts of the project.

#### Multi-project structure step by step

Assume we have two modules: for `web` and `api` tests. Let's create a project with the following structure
```
.
├── build.gradle
├── tests-api
│   ├── build.gradle
│   └── src
│       ├── main
│       │   └── java
│       └── test
│           └── java
└── tests-web
    ├── build.gradle
    └── src
        ├── main
        │   └── java
        └── test
            └── java
```
As can be seen we have a main `build.gradle` file and two more in every project's folder.