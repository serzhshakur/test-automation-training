import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import components.Header;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ClothesPage;

class ShopTest {

    private Header header;
    private MainPage mainPage;

    @BeforeAll
    static void staticSetup() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void setup() {
        header = new Header();
        mainPage = new MainPage();
        Selenide.open("http://demo.prestashop.com");
    }

    @Test
    @DisplayName("User is able to navigate to Clothes Pages")
    void test() {
        mainPage.waitForElements();
        ClothesPage clothesPage = header
                .waitForElements()
                .goToClothesCategory();

        clothesPage.waitForElements();
    }
}
