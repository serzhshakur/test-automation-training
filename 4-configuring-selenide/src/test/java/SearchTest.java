import components.Header;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ProductPage;
import tests.configuration.SelenideCallbacks;

@ExtendWith(SelenideCallbacks.class)
@Tag("Search")
@Tag("All")
class SearchTest {

    private Header header;

    @BeforeEach
    void setup() {
        header = new Header();
    }

    @Test
    @DisplayName("User is able search an item")
    void test() {
        String searchTerm = "sleeve t-shirt";
        ProductPage productPage = header
                .enterSearchTerm(searchTerm)
                .waitForSearchSuggestionsBlock()
                .chooseFirstMatchingSuggestion();
        productPage
                .waitForElements()
                .productNameContains(searchTerm);
    }
}
