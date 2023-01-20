package Steps;

import Pages.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;

public class MainPageSteps {

    public MainPage mp = new MainPage();

    @Step
    public MainPageSteps setMinPrice() {
        mp.priceFrom.sendKeys("200");
        return this;
    }

    @Step
    public MainPageSteps setMaxPrice() {
        mp.priceTo.sendKeys("230");
        return this;
    }

    @Step
    public MainPageSteps search() {
        mp.search.click();
        return this;
    }

    @Step
    public ArrayList<Integer> getPrices() {

        ArrayList<Integer> prices = new ArrayList<>();
        for (SelenideElement offer : mp.allPrices
             ) {
            int price = Integer.parseInt(offer.getText().substring(0, 3));
            prices.add(price);
        }
        return prices;
    }

    @Step
    public SelenideElement LocationElement() {
        return mp.locationCheckbox;
    }

    @Step
    public SelenideElement CategoryElement() {
        return mp.categoryField;
    }

    @Step
    public MainPageSteps sort() {
        mp.sort.click();
        return this;
    }

    @Step
    public MainPageSteps waitToLoad() {
        mp.banner.shouldHave(Condition.attribute("style", "display: block;"));
        return this;
    }


    @Step
    public MainPageSteps priceDescending() {
        mp.priceDescendingOrder.click();
        return this;
    }

    @Step
    public ArrayList<Integer> firstTwoPrice() {
        ArrayList<Integer> prices = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            String full = mp.allPrices.get(i).getText();
            int symbolIndex = full.indexOf("₾");
            int price = Integer.parseInt(full.substring(0, symbolIndex));
            prices.add(price);
        }
        return prices;
    }
}
