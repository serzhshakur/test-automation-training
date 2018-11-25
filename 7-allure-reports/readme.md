# Test reports
> This lesson will only contain readme file. Refer to a lesson 4 codebase to see full implementation

One of most important parts of a good test automation project is a proper tests results report. Although the Test task generates results by default in HTML format this report doesn't look pretty at all.

Allure framework on the other hand is designed to create test execution reports that are nice and clear.

To enable Allure report generation we need to add a gradle plugin first
```aidl
plugins {
    ...
    id "io.qameta.allure" version "2.5"
}

```
Next step is to configure Allure for our project. Let's do it in a separate file. Create`./gradle/allure.gradle`

```aidl
apply plugin: 'io.qameta.allure'

ext.allureVersion = '2.6.0'

allure {
    version = project.ext.allureVersion
    resultsDir = file "$rootDir/build/allure-results/"

    useJUnit5 {
        version = project.ext.allureVersion
    }

}
```
Now let's import this file into our main `build.gradle` script
```
apply from: "$rootDir/gradle/allure.gradle"
```
That's it. Now run your tests. In order to generate Allure reports run the following Gradle tasks.
```aidl
./gradlew allureReport
./gradlew allureServe
```
Report will then be opened in you default browser.