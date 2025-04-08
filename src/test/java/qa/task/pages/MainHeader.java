package qa.task.pages;

import com.codeborne.selenide.WebElementCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainHeader {
    final private By devicesButton = By.xpath("//button[contains(@class, 'menu-dropdown-item') and text()='Urządzenia']");
    final private WebElementCondition devicesButtonText = text("Urządzenia");
    final private By smartphonesWithoutSubscription = By.xpath("//a[@data-ga-ea='nav-links - Urządzenia/Bez abonamentu/Smartfony']//span[contains(text(), 'Smartfony')]");
    final private WebElementCondition smartphonesWithoutSubscriptionText = text("Smartfony");

    public MainHeader hoverDevicesButton() {
        $(devicesButton).shouldBe(visible).shouldHave(devicesButtonText).hover();
        return this;
    }

    public MainHeader clickSmartphonesWithoutSubscription() {
        $(smartphonesWithoutSubscription).shouldBe(visible).shouldHave(smartphonesWithoutSubscriptionText).click();
        return this;
    }
}
