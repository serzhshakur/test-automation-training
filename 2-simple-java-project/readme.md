# Simple Java project for test automation

In lesson 1 we learned how to create a simple Java project. 
Now let's go further and configure our project so it meets our test automation needs.

Let's assume that we need to setup an automation project to cover "http://automationpractice.com/" website with Selenium web tests.
This will require to add some dependencies to `build.gradle` file namely 
* Selenide (a lightweight wrapper over Selenium lib) 
* Junit5 as a test runner

these few lines will do the trick
```$xslt
ext {
    junitJupiterVersion = '5.2.0'
}

dependencies {
    implementation 'com.codeborne:selenide:5.0.0'

    testImplementation "org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion"
    
    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion"
}
```
where 
* `implementation` dependencies required to compile both main and test sources
* `testImplementation` dependencies required to compile and run the test source of the project
* `testRuntimeOnly` dependencies which are only required at test runtime, and not at test compile time

### Building a project
Let's now make sure we made all right. Run the following command. You should see the output like shown below (check `build.gradle` file with full config in a project's root)
```$xslt
./gradlew clean build

> Task :clean
> Task :compileJava NO-SOURCE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :jar
> Task :assemble
> Task :compileTestJava NO-SOURCE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
> Task :test NO-SOURCE
> Task :check UP-TO-DATE
> Task :build

BUILD SUCCESSFUL in 0s
2 actionable tasks: 2 executed
```
Now we are ready to start writing a code.
