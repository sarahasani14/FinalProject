package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtility;


import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WishListPage extends BasePage {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    private By womenMenu = By.xpath("//a[@class='level0 has-children'][normalize-space()='Women']");
    private By firstAddToCartButton = By.xpath("//div[@class='cart-cell']//button[@class='button btn-cart']");
    private By finalAddToCartButton = By.xpath("//div[@class='add-to-cart-buttons']//button[@class='button btn-cart']");
    private By colorOption = By.xpath("//ul[@id='configurable_swatch_color']//span[@class='swatch-label']");
    private By sizeOption = By.xpath("(//ul[@id='configurable_swatch_size']//span[@class='swatch-label'])[2]");

    public WomenPage clickWomenMenu() {
        try {
            click(womenMenu);
        } catch (StaleElementReferenceException e) {
            System.out.println("Element was stale, retrying click on Women menu...");
            WebElement womenMenu = driver.findElement(By.xpath("//a[@class='level0 has-children'][normalize-space()='Women']"));
            womenMenu.click();
        }
        return new WomenPage(driver);
    }

    public ShoppingCartPage addAllProductsToCart() {

        WaitUtility.explicitWaitUntilVisible(5, firstAddToCartButton);
        int totalProducts = findAll(firstAddToCartButton).size();
        for (int i = 0; i < totalProducts; i++) {
            List<WebElement> buttons = findAll(firstAddToCartButton);
            WebElement product = buttons.get(0);
            product.click();

            WaitUtility.explicitWaitUntilVisible(5, colorOption);
            click(colorOption);
            click(sizeOption);
            scrollToElementJS(finalAddToCartButton);
            click(finalAddToCartButton);

            driver.get("https://ecommerce.tealiumdemo.com/wishlist/");
            if (i < totalProducts - 1) {
                WaitUtility.explicitWaitUntilVisible(5, firstAddToCartButton);
            }

        }
        driver.get("https://ecommerce.tealiumdemo.com/checkout/cart/");
        return new ShoppingCartPage(driver);
    }
}
