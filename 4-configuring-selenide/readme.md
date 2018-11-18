# Configuring Selenide

In lesson 3 we set up a small test automation project and wrote our first test.
So far so good. But as our test suite grows so does a boilerplate code. In each test class we need to repeat the following blocks of configuration
```aidl
    @BeforeAll
    static void staticSetup() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void setup() {
        Selenide.open("http://automationpractice.com/");
```
Let's see how JUnit5 can help us to get rid of code duplicates here.
JUnit5 offers a great model for extending tests at various points in the test execution lifecycle - before all tests, before each test, after each test, after all test (for more info see [here](https://junit.org/junit5/docs/current/user-guide/#extensions-lifecycle-callbacks)).
 
 All we need to do is to create a class which implements one or more of the following interfaces
* `BeforeAllCallback`
* `BeforeEachCallback`
* `BeforeTestExecutionCallback`
* `AfterTestExecutionCallback`
* `AfterEachCallback`
* `AfterAllCallback`

In our case we will implement two of them `BeforeAllCallback` and `BeforeEachCallback`

```aidl
public class SelenideCallbacks implements BeforeAllCallback, BeforeEachCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.driverManagerEnabled = true;
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        Selenide.open("");
    }
}
```
Now all we need to do is to annotate all our test classes in the following way:
```aidl
@ExtendWith(SelenideCallbacks.class)
class ShopTest {...}
```
For more details check a projects source code