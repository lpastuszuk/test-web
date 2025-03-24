package qa.task.pages;

import com.codeborne.selenide.WebElementCondition;
import org.openqa.selenium.By;
import qa.task.factories.ScenarioContext;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShopDeviceDetails {
    private final ScenarioContext context = ScenarioContext.getInstance();

    final private By addToCart = By.xpath("/html/body/div/div[4]/main/section/section/div/span/div/div[2]/div/div/div/div[2]/section[1]/button/span/div");
    final private WebElementCondition addToCartText = text("Dodaj do koszyka");
    final private By devicePrice = By.xpath("/html/body/div/div[4]/main/section/section/div/section/article/div[1]/article/div/section[2]/article/section[2]/section[3]/section/article/div/div[2]");
    final private By startFee = By.xpath("/html/body/div/div[4]/main/section/section/div/span/div/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div");
    final private By monthlyFee = By.xpath("/html/body/div/div[4]/main/section/section/div/span/div/div[2]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div");

    public ShopDeviceDetails clickAddToCart() {
        $(addToCart).shouldBe(visible).shouldHave(addToCartText).click();
        return this;
    }

    public ShopDeviceDetails verifyDevicePriceWithContext(String devicePriceKey) {
        assertThat($(devicePrice).shouldBe(visible).getText())
                .isEqualTo(context.getContext(devicePriceKey));
        return this;
    }

    public ShopDeviceDetails addPurchaseDetailsToContext(String startFeeKey, String monthlyFeeKey) {
        context.setContext(startFeeKey, $(startFee).shouldBe(visible).getText());
        context.setContext(monthlyFeeKey, $(monthlyFee).shouldBe(visible).getText());
        return this;
    }
}