package qa.task.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import qa.task.factories.ScenarioContext;
import qa.task.pages.*;

import static com.codeborne.selenide.Selenide.open;

public class CartStepDefinitions {
    private final ScenarioContext context = ScenarioContext.getInstance();
    final Logger logger = LoggerFactory.getLogger(CartStepDefinitions.class);

    @Given("the browser is open")
    public void the_browser_is_open() {
        open("about:blank");
    }

    @When("I open the main page")
    public void i_open_the_main_page() {
        new MainPage()
                .openMainPage();
    }

    @When("I navigate to the device list")
    public void i_navigate_to_the_device_list() {
        new MainHeader()
                .hoverDevicesButton();
    }

    @When("I navigate to the smartphone without subscription list")
    public void i_navigate_to_the_smartphone_without_subscription_list() {
        new MainHeader()
                .clickSmartphonesWithoutSubscription();
    }

    @When("I click on the second smartphone in the list")
    public void i_click_on_the_second_smartphone_in_the_list() {
        new ShopDevicesList()
                .addSecondDevicePriceToContext("secondDevicePrice")
                .clickSecondDevice();
    }

    @When("I click the add to cart button")
    public void i_click_the_add_to_cart_button() {
        new ShopDeviceDetails()
                .verifyDevicePriceWithContext("secondDevicePrice")
                .addPurchaseDetailsToContext("startFee", "monthlyFee")
                .clickAddToCart();
        logger.atInfo().setMessage("Start fee: '{}', monthly fee: '{}'")
                .addArgument(context.getContext("startFee"))
                .addArgument(context.getContext("monthlyFee")).log();
        new Basket()
                .verifyDevicePriceWithContext("startFee", "monthlyFee");
    }

    @Then("the cart icon shows {string} item after returning to the main page")
    public void the_cart_icon_shows_item_after_returning_to_the_main_page(String string) {
        new MainPage()
                .openMainPage()
                .verifyCartIconCounter(string);
    }
}