package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public SelenideElement priceFrom = $(By.xpath("//div[@class='category-filter-desk']//input[@id='minprice']"));
    public SelenideElement priceTo = $(By.xpath("//div[@class='category-filter-desk']//input[@id='maxprice']"));
    public SelenideElement search = $(By.xpath("//div[@class='category-filter-desk']//div[@class='submit-button']"));
    public ElementsCollection allPrices = $$(By.xpath("//div[@class='special-offer']//div[@class='discounted-prices']//p[@class='deal-voucher-price'][1]"));
    public ElementsCollection pages = $$(By.xpath("//div[@class='pager-filter']"));
    public SelenideElement locationCheckbox = $(By.xpath("//div[@class='category-filter-desk']//label"));
    public SelenideElement categoryField = $(By.xpath("//div[@class='category-filter-desk']//ul[@class='subcategory-ul subcategory-hotels']//li[@class='searched-category']//a"));
    public SelenideElement sort = $(By.id("sort"));
    public SelenideElement priceDescendingOrder = $(By.xpath("//select[@id='sort']//option[@value='1']"));

    // attribute changes after sorting/filtering offers
    public SelenideElement banner = $(By.id("main"));


}
