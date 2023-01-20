package Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public SelenideElement vacation = $(By.xpath("//label[text()='დასვენება']"));
    public SelenideElement bakuriani = $(By.xpath("//a[@href='/category/24/dasveneba']/following-sibling::div//li[1]/child::a"));
    public SelenideElement logIn = $(By.xpath("//label[text()='შესვლა']"));

}
