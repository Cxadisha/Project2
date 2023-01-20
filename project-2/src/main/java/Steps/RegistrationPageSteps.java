package Steps;

import Pages.RegistrationPage;
import com.codeborne.selenide.ClickOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

public class RegistrationPageSteps {

    public RegistrationPage rp = new RegistrationPage();

    @Step
    public RegistrationPageSteps clickOnRegister() {
        rp.registerBtn.click();
        return this;
    }

    @Step
    public RegistrationPageSteps enterFirstName(String name) {
        rp.firstNameField.sendKeys(name);
        return this;
    }

    @Step
    public RegistrationPageSteps enterLastName(String lastName) {
        rp.lastNameField.sendKeys(lastName);
        return this;
    }

    @Step
    public RegistrationPageSteps enterPhone(String phone) {
        rp.phoneField.sendKeys(phone);
        return this;
    }

    @Step
    public RegistrationPageSteps enterEmail(String email) {
        rp.emailField.sendKeys(email);
        return this;
    }

    @Step
    public RegistrationPageSteps enterBirthDate(String birthDate) {
        rp.birthDateField.click();
        rp.birthDateField.sendKeys(birthDate);
        return this;
    }

    @Step
    public RegistrationPageSteps setPassword(String pass) {
        rp.passField.sendKeys(pass);
        return this;
    }

    @Step
    public RegistrationPageSteps confirmPassword(String pass) {
        rp.passField2.sendKeys(pass);
        return this;
    }

    @Step
    public RegistrationPageSteps clickOnSubmit() {
        rp.submitRegister.click();
        return this;
    }

    @Step
    public String getWarning() {
        return rp.warningField.getText();
    }
}
