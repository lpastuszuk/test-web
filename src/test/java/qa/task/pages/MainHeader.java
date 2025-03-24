package qa.task.pages;

import com.codeborne.selenide.WebElementCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainHeader {
    final private By devicesButton = By.xpath("/html/body/div[1]/div/div/header/div/div[2]/div/nav/div/ul/li[1]/button");
    final private WebElementCondition devicesButtonText = text("Urządzenia");
    final private By smartphonesWithoutSubscription = By.cssSelector(".menu > li:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > div:nth-child(1) > span:nth-child(1)");
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
