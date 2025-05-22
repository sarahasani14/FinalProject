package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    private By sizeOption = By.xpath("//ul[@id='configurable_swatch_size']//a[contains(@class,'swatch-link')]");
    private By editButton = By.xpath("(//td[@class='wishlist-cell4 customer-wishlist-item-cart']//a[@class='link-edit button button-secondary'])[1]");
    private By updateWishListButton = By.linkText("Update Wishlist");
    private By addAllToCartButton = By.xpath("//button[@class='button btn-add']");




    public void selectColor(String color) {
        WebElement colorOption = driver.findElement(By.xpath("//img[@alt='" + color + "']"));
        scrollToElementJS(colorOption);
        colorOption.click();
    }

    public void selectSizeByIndex(int index) {
        List<WebElement> sizeOptions = findAll(sizeOption);
        WebElement selectedOption = sizeOptions.get(index);
        scrollToElementJS(selectedOption);
        selectedOption.click();
    }


    public void editItems(String color, int sizeIndex) {
        click(editButton);
        selectColor(color);
        selectSizeByIndex(sizeIndex);
        click(updateWishListButton);
    }

    public ShoppingCartPage clickAddAllToCartButton(){
        scrollToElementJS(addAllToCartButton);
        click(addAllToCartButton);
        return new ShoppingCartPage(driver);
    }








}
