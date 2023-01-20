package Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public SelenideElement registerBtn = $(By.xpath("//p[@class='register']"));
    public SelenideElement firstNameField = $(By.id("pFirstName"));
    public SelenideElement lastNameField = $(By.id("pLastName"));
    public SelenideElement phoneField = $(By.id("pPhone"));
    public SelenideElement emailField = $(By.id("pEmail"));
    public SelenideElement birthDateField = $(By.id("pDateBirth"));
    public SelenideElement passField = $(By.id("pPassword"));
    public SelenideElement passField2 = $(By.id("pConfirmPassword"));
    public SelenideElement submitRegister = $(By.xpath("//a[@onclick='checkPhysicalFormSubmit()']"));
    public SelenideElement warningField = $(By.id("physicalInfoMassage"));

}
