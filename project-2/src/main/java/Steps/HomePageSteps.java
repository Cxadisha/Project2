package Steps;

import Pages.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps{

    public HomePage hp = new HomePage();

    @Step
    public HomePageSteps clickOnVacation() {
        hp.vacation.click();
        return this;
    }

    @Step
    public HomePageSteps hoverOnVacation() {
        hp.vacation.hover();
        return this;
    }

    @Step
    public void clickOnBakuriani() {
        hp.bakuriani.click();
    }

    @Step
    public void clickOnLogInBtn() {
        hp.logIn.click();
    }

}
