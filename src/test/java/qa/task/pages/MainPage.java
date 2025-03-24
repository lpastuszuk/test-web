package qa.task.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    final private String mainPageUrl = "https://www.t-mobile.pl/";
    final private By cartIconCounter = By.xpath("/html/body/div[1]/div/div/header/div/div[2]/div/div/a[1]/div");

    public MainPage openMainPage() {
        open(mainPageUrl);
        return this;
    }

    public MainPage verifyCartIconCounter(String value) {
        $(cartIconCounter).shouldBe(visible).shouldHave(text(value));
        return this;
    }
}
