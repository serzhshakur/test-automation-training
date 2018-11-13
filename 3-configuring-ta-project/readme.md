# Configuring your first test automation project

In lesson 2 we agreed to create a test automation project for  "http://automationpractice.com/" website.

Check project's sources. In `src/main/java` you will find an implementation of Page object model. In `src/main/test` there's a small Junit5 test which covers basic site navigation scenario. First run it from IntelliJ IDEA and make sure it works.

### Running tests from command line
Next step would be to configure Gradle so it is able to run our tests.

By default `java` plugin adds a number of Gradle tasks to your project (for more info check [here](https://docs.gradle.org/current/userguide/java_plugin.html#sec:java_tasks)). One of them is `test` which runs all the tests from _test_ folder. 
So let's run the following command and see what happens
```aidl
./gradlew clean test
``` 
As we can see no tests were executed. It is because by default `java` plugin uses Junit4 as a test runner. We need to reconfigure a `test` task so it uses Juni5 platform. 
Add the following code to your `build.gradle` file
```aidl
test {
    useJUnitPlatform()
}
```
Now run `./gradlew clean test` again. You can see now tests are being executed.

For more info on configuring Gradle + Juni5 check [Junit5 docs](https://junit.org/junit5/docs/current/user-guide/#running-tests-build-gradle)