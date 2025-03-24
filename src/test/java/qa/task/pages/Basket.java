package qa.task.pages;

import org.openqa.selenium.By;
import qa.task.factories.ScenarioContext;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Basket {
    private final ScenarioContext context = ScenarioContext.getInstance();

    final private By startFee = By.xpath("/html/body/div/div[4]/div[4]/div[2]/div/div[2]/div[1]/div/div/div[1]/article/span/div");
    final private By monthlyFee = By.xpath("/html/body/div/div[4]/div[4]/div[2]/div/div[2]/div[1]/section/div/div[1]/article/span/div");

    public Basket verifyDevicePriceWithContext(String startFeeKey, String monthlyFeeKey) {
        assertThat($(startFee).shouldBe(visible).getText())
                .isEqualTo(context.getContext(startFeeKey));
        assertThat($(monthlyFee).shouldBe(visible).getText())
                .isEqualTo(context.getContext(monthlyFeeKey));
        return this;
    }
}
