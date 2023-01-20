import Data.Data;
import Steps.HomePageSteps;
import Steps.MainPageSteps;
import Steps.RegistrationPageSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

@Epic("Regression Tests")
@Listeners(ConfigAttachment.class)
public class TestClass {

    Data dt = new Data();
    HomePageSteps homePageSteps = new HomePageSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    SoftAssert softAssert = new SoftAssert();
    RegistrationPageSteps register = new RegistrationPageSteps();
    static WebDriver driver;

    @BeforeTest(groups = "StartBrowser")
    public void startBrowser() {

        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        open(dt.url);
        driver = WebDriverRunner.getWebDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Test(groups = { "Regression1" }, description = "Price range search")
    @Description("Test Description: test sets min and max price and searches results, then checks that output prices are inside the range")
    @Feature("Search Test")
    @Story("Search with price range")
    public void searchWithPriceRange() {

        homePageSteps.clickOnVacation();
        mainPageSteps.setMinPrice().setMaxPrice().search().waitToLoad();

        // store search result prices
        ArrayList<Integer> prices = mainPageSteps.getPrices();

        // validate
        for (int price:prices
             ) {
            softAssert.assertTrue(200 <= price, String.valueOf(prices.get(prices.indexOf(price))));
            softAssert.assertTrue(price < 230);
        }
        softAssert.assertAll();
    }

    @Test(groups = { "Regression1" }, description = "Sort Test")
    @Description("Test Description: test sorts offers by price descending order and checks the ")
    @Feature("Sort Test")
    @Story("Sort price desc and Compare")
    public void sortAndCompare() {

        homePageSteps.hoverOnVacation().clickOnBakuriani();

        // validates
        mainPageSteps.LocationElement().shouldHave(Condition.exactText("ბაკურიანი"));
        mainPageSteps.CategoryElement().shouldHave(Condition.exactText("ბაკურიანი"));

        // sort and validate
        mainPageSteps.sort().priceDescending().waitToLoad();
        Assert.assertTrue(mainPageSteps.firstTwoPrice().get(0) >= mainPageSteps.firstTwoPrice().get(1));
    }

    @Test (dataProvider = "dp", dataProviderClass = dpData.class, groups = { "Regression2" }, description = "Register User")
    @Description("Test Description: test registers new user")
    @Feature("Register Test")
    @Story("Register new user")
    public void registerUser(Object name, Object lastName, Object phone, Object email, Object dateOfBirth, Object password) {

        homePageSteps.clickOnLogInBtn();
        register.clickOnRegister()
                .enterFirstName((String) name).enterLastName((String) lastName)
                .enterPhone((String) phone)
                .enterEmail((String) email)
                .enterBirthDate((String) dateOfBirth)
                .setPassword((String) password).confirmPassword((String) password)
                .clickOnSubmit();

        Assert.assertEquals(register.getWarning(), "გთხოვთ აირჩიოთ სქესი!");
    }

    @AfterTest
    public void closeBrowser() {
        Selenide.closeWebDriver();
        driver = null;
    }
}