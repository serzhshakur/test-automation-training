import components.Header;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.DressesPage;
import pages.MainPage;
import tests.configuration.SelenideCallbacks;

@ExtendWith(SelenideCallbacks.class)
@Tag("Shopping")
@Tag("All")
class ShopTest {

    private Header header;
    private MainPage mainPage;

    @BeforeEach
    void setup() {
        header = new Header();
        mainPage = new MainPage();
    }

    @Test
    @DisplayName("User is able to navigate to Dresses Pages")
    void test() {
        mainPage.waitForElements();
        DressesPage dressesPage = header
                .waitForElements()
                .chooseDressesCategory();

        dressesPage.waitForElements();
    }
}
