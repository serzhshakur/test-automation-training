# Running test in parallel
> This lesson will only contain readme file. Refer to a lesson 4 codebase to see full implementation
### Configuring gradle task
So far we've been executing our tests in one thread. This is ok for a small test suite but as the number of tests grows the time of tests execution grows as well. In this lesson we will learn how to run our tests in parallel flows. In this case each JUnit5 test class will be executed in a separate thread.

To accomplish this let's add `maxParallelForks` parameter to our `test` task
```aidl
test {
    maxParallelForks = 2
    useJUnitPlatform()
}
```
Now your tests will run in 2 parallel flows. 

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
    maxParallelForks = forks as int
    
    useJUnitPlatform()
}
```
We can read a property using `project.findProperty` expression. `?:` (Elvis operator) fallbacks us to a default value `1` if property has not been passed to the task.