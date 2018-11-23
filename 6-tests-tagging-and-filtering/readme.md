# Filtering and tagging tests
> This lesson will only contain gradle files. Refer to a lesson 4 codebase to see full implementation

Sometimes we need to execute only a particular set of tests depending on some conditions (environment-dependent tests, long-running tests, feature-specific tests etc.) 

JUnit5 allows to annotate test classes and methods with `@Tag("SomeMeaningfulName")` annotation. Those tags can be used to filter test discovery and execution. You can add as many tags as you like. We can then use these tags to control which tests to execute during our automated test runs.

Let's do this for our test classes.
```aidl
@Tag("Search")
class SearchTest { ...}

@Tag("Shopping")
class ShopTest {...)
```
