# Running test in parallel and tests filtering
> This lesson will only contain gradle files. Refer to a lesson 4 codebase
### Configuring gradle task
So far we've been executing our tests in one thread. This is ok for a small test suite but as the number of tests grows the time of tests execution grows as well. In this lesson we will learn how to run our tests in parallel flows. In this case each JUnit5 test class will be executed in a separate thread.

Let's add `setMaxParallelForks` parameter to our `test` task
```aidl
test {
    setMaxParallelForks(2)
    useJUnitPlatform()
}
```
so now your tests will run in 2 parallel flows. 

We can go further. Let's now make the number of forks configurable. Gradle allows to pass properties to it's tasks like this
```aidl
./gradlew someTask -PpropName=propValue
```   
So in our case we would like to run our tests in the following way
```aidl
./gradlew clean test -Pforks=3
```
Let's extend our gradle task
```aidl
test {
    def forks = project.findProperty('forks') ?: 1

    setMaxParallelForks(forks as int)
    useJUnitPlatform()
}
```
So here we use `project.findProperty`