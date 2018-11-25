# Filtering and tagging tests
> This lesson will only contain readme file. Refer to a lesson 4 codebase to see full implementation

Sometimes we need to execute only a particular set of tests depending on some conditions (environment-dependent tests, long-running tests, feature-specific tests etc.) 

JUnit5 allows to annotate test classes and methods with `@Tag("SomeMeaningfulName")` annotation. Those tags can be used to filter test discovery and execution. You can add as many tags as you like. We can then use these tags to control which tests to execute during our automated test runs.

Let's do this for our test classes.
```aidl
@Tag("All")
@Tag("Search")
class SearchTest { ...}

@Tag("All")
@Tag("Shopping")
class ShopTest {...}
```
Now we can adjust our gradle task as follows 
```aidl
test {
  ...
  useJUnitPlatform {
      includeTags 'Search', 'Shopping'
  }
  ...
}
```
Let's make a list of tags configurable by introducing `tags` property (like we did in a previous lesson with number of flows)
```
test {
  ...
  def tags = project.findProperty('tags') ?: 'All'
  useJUnitPlatform {
      includeTags(tags.split(',')*.trim() as String[])
  }
  ...
}
```
now we can specify which tags to run while running gradle task
```aidl
./gradlew clean test -Ptags="Search,Shopping"
```