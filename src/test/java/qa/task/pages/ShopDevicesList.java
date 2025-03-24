package qa.task.pages;

import org.openqa.selenium.By;
import qa.task.factories.ScenarioContext;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ShopDevicesList {
    private final ScenarioContext context = ScenarioContext.getInstance();

    final private By secondDevice = By.xpath("/html/body/div/div[4]/main/div[3]/div/div[1]/div/div[2]/div[2]/div[2]");
    final private By secondDevicePrice = By.xpath("/html/body/div/div[4]/main/div[3]/div/div[1]/div/div[2]/div[2]/div[2]/section/div[3]/div/div[2]/div[2]");

    public ShopDevicesList clickSecondDevice() {
        $(secondDevice).shouldBe(visible).click();
        return this;
    }

    public ShopDevicesList addSecondDevicePriceToContext(String devicePriceKey) {
        context.setContext(devicePriceKey, $(secondDevicePrice).getText());
        return this;
    }
}
