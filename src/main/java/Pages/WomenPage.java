package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtility;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utilities.DropDownUtility.selectByIndex;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class WomenPage extends BasePage {

    public WomenPage(WebDriver driver) {
        super(driver);
    }


    private By product = By.xpath("//li[@class='item last']//a[@class='product-image']");
    private By selectDropDown = By.xpath("(//select[@title='Sort By'])[1]");
    private By productPrice = By.xpath("//li[@class='item last']//span[@class='price']");
    private By addToWishListLink = By.xpath("//ul[@class='add-to-links']//a[@class='link-wishlist']");
    private By continueShoppingButton = By.linkText("here");



    public String getCssValueBeforeHover(){
        scrollToElementJS(product);
        return find(product).getCssValue("border-color");
    }

    public String getCssValueAfterHover(){
        scrollToElementJS(product);
        actions.moveToElement(find(product)).perform();
        return find(product).getCssValue("border-color");
    }

    public void selectPriceDropdown(int index){
        scrollToElementJS(selectDropDown);
        selectByIndex(selectDropDown, index);
        WaitUtility.explicitWaitUntilVisible(5, product);
    }


    private double parsePrice(String priceText) {
        return Double.parseDouble(priceText.replaceAll("[$,]", "").trim());
    }

    public boolean areProductsSortedByPrice(){
        scrollToElementJS(productPrice);

        List<WebElement> prices = findAll(productPrice);
        List<Double> finalPrices = new ArrayList<>();
        for(int i = 0; i< prices.size(); i++){
            WebElement price = prices.get(i);
            String textDecoration = price.getCssValue("text-decoration");
            if(!textDecoration.contains("line-through")){

                String priceText = price.getText();
                Double priceValue = parsePrice(priceText);
                finalPrices.add(priceValue);
            }
        }
        List<Double> sortedPrices = new ArrayList<>(finalPrices);
        Collections.sort(sortedPrices);

        return finalPrices.equals(sortedPrices);

    }

    public void addProductToWishList(int productIndex) {
        List<WebElement> wishListLinks = findAll(addToWishListLink);
        WebElement product = wishListLinks.get(productIndex);
        scrollToElementJS(product);
        product.click();
        click(continueShoppingButton);

    }

}
