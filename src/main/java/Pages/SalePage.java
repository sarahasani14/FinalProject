package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class SalePage extends BasePage {

    public SalePage(WebDriver driver) {
        super(driver);
    }

    private By productCard = By.xpath("//li[@class='item last']");
    private By productPrice = By.xpath("//div[@class='price-box']//span[@class='price']");
    private By originalPrice = By.cssSelector("p.old-price .price");
    private By finalPrice = By.xpath("//p[@class='special-price']");


    public boolean allProductsHaveOriginalAndDiscountedPrices() {
        List<WebElement> products = findAll(productCard);
        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);
            scrollToElementJS(product);
            List<WebElement> prices = findAll(productPrice);
            if (prices.size() < 2) {
                return false;
            }
        }
        return true;
    }

    public String getOriginalPriceColor(){
        scrollToElementJS(originalPrice);
        return find(originalPrice).getCssValue("color");
    }

    public String getOriginalPriceTextDecoration(){
        scrollToElementJS(originalPrice);
       return find(originalPrice).getCssValue("text-decoration");
    }


    public String getFinalPriceColor(){
        scrollToElementJS(finalPrice);
        return find(finalPrice).getCssValue("color");
    }

    public String getFinalPriceTextDecoration(){
        scrollToElementJS(finalPrice);
        return find(finalPrice).getCssValue("text-decoration");
    }


}
