# Configuring Selenide

### Configuration parameters
Selenide offers a very elegant configuration model which helps to quickly alter a behaviour of our web tests. `Configuration` class is responsible for tweaking all the Selenide functionality. For full list of configuration parameters check [docs](https://selenide.org/javadoc/current/index.html?com/codeborne/selenide/Configuration.html).

Let's have a look at some of the parameters we can change.
* `browserSize` - sets the browser window size while tests execution
* `startMaximized` - open browser window maximized
* `timeout` - timeout in ms to fail the test if condition is not met
* `browser` - browser to use (defaults to "chrome"). Supported values: "chrome", "firefox", "legacy_firefox", "ie", "htmlunit", "phantomjs", "opera", "safari", "edge", "jbrowser"
* `baseUrl` - Base url for open() function calls
* `driverManagerEnabled` - [webDriverManager](https://github.com/bonigarcia/webdrivermanager) is a library which automatically downloads webdriver executables for any browser. This property controls Selenide and WebDriverManager integration.

So our configuration will now look as follows
```aidl
    @BeforeAll
    static void setupAll() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.driverManagerEnabled = true;
    }
```  

### Extracting Selenide configuration to a JUnit5 extension class
In lesson 3 we set up a small test automation project and wrote our first test.
So far so good. But as our test suite grows so does a boilerplate code. In each test class we need to repeat the following blocks of configuration
```
    @BeforeAll
    static void setupAll() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.driverManagerEnabled = true;
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

In our case we will implement three of them `BeforeAllCallback`, `BeforeEachCallback` and `AfterEachCallback`

```aidl
public class SelenideCallbacks implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback {

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
    
    @Override
    public void afterEach(ExtensionContext context) {
        Selenide.close();
    }
}
```
`beforeAll` callback will add some configuration to a Selenide, `beforeEach` will open a browser before each test, `afterEach` will close the browser after each test.

Now let's annotate all our test classes in the following way:
```aidl
@ExtendWith(SelenideCallbacks.class)
class ShopTest {...}
```
`SelenideCallbacks`'s  callbacks will now be called on each tests' run. 
For more details check a project's source code