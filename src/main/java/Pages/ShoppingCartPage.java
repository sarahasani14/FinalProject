package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtility;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private By quantityOption = By.xpath("(//input[@class='input-text qty'])[1]");
    private By updateButton = By.xpath("(//td[@class='product-cart-actions']//button[@type='submit'])[1]");
    private By productsPrices = By.xpath("//td[@class='product-cart-total']//span[@class='cart-price']");
    private By grandTotalPrice = By.xpath("(//td[@class='a-right']//span[@class='price'])[1]");
    private By deleteButton = By.xpath("//td[@class='a-center product-cart-remove last']//a[@class='btn-remove btn-remove2']");
    private By cartItems = By.xpath("//td[@class='product-cart-image']");
    private By emptyShoppingCartMessage = By.xpath("(//div[@class='cart-empty']//p)[1]");


    public void setQuantityOption(String quantity) {
        click(quantityOption);
        set(quantityOption, quantity);
    }

    public void clickUpdateButton() {
        WaitUtility.explicitWaitUntilVisible(5, updateButton);
        click(updateButton);
    }

    private double parsePrice(String priceText) {
        return Double.parseDouble(priceText.replaceAll("[$,]", "").trim());
    }

    public double getProductPricesSum() {
        List<WebElement> prices = findAll(productsPrices);
        double sum = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            WebElement priceElement = prices.get(i);

            String priceText = priceElement.getText();
            Double priceValue = parsePrice(priceText);
            sum += priceValue;
        }
        return sum;
    }

    public double getGrandTotalPrice() {
        String grandTotalText = find(grandTotalPrice).getText();
        return parsePrice(grandTotalText);

    }

    public int getNumberOfCartItems() {
        return findAll(cartItems).size();
    }


    public void removeFirstCartItem() {
        List<WebElement> deleteButtons = findAll(deleteButton);
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
            waitForCartItemsCountToBe(deleteButtons.size() - 1);
        } else {
            throw new RuntimeException("No items to delete.");
        }
    }

    public void waitForCartItemsCountToBe(int expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> getNumberOfCartItems() == expectedCount);
    }


    public boolean isShoppingCartEmpty() {
        return find(emptyShoppingCartMessage).isDisplayed();
    }
}

