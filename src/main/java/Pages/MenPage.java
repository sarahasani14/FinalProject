package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtility;

import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class MenPage extends BasePage {

    public MenPage(WebDriver driver) {
        super(driver);
    }

    private By blackColorOption = By.xpath("//img[@title='Black']");
    private By productCard = By.xpath("//li[@class='item last']");
    private By selectedBlackColor = By.xpath("//li[@class='option-black is-media filter-match selected']//a[@class='swatch-link swatch-link-92 has-image']");
    private By priceRange = By.xpath("(//dd[@class='even']//a)[1] ");
    private By productPrices = By.xpath("//span[@class='regular-price']");


    public void clickBlackColor() {
        scrollToElementJS(blackColorOption);
        click(blackColorOption);
        WaitUtility.explicitWaitUntilVisible(10, productCard);
    }


    public boolean selectedColorsHaveBlueBorders() {
        List<WebElement> selectedColors = findAll(selectedBlackColor);
        for (int i = 0; i < selectedColors.size(); i++) {
            WebElement color = selectedColors.get(i);
            scrollToElementJS(color);
            String borderColor = color.getCssValue("border-color");
            if (!borderColor.contains("rgb(51, 153, 204)")) {
                return false;
            }
        }
            return true;
    }

    public void clickPriceRange(){
        click(priceRange);
        WaitUtility.explicitWaitUntilVisible(10, productCard);
    }

    public int getNumberOfDisplayedProducts(){
        scrollToElementJS(productCard);
        List<WebElement> products = findAll(productCard);
        return products.size();
    }

    private double parsePrice(String priceText) {
        return Double.parseDouble(priceText.replaceAll("[$,]", "").trim());
    }

    public boolean pricesMatchTheDefinedCriteria(double minPrice, double maxPrice){
        List<WebElement> allPrices = findAll(productPrices);
        for(int i=0; i<allPrices.size(); i++){
            WebElement prices = allPrices.get(i);
            String priceText = prices.getText();
            double priceValue = parsePrice(priceText);

            if(priceValue < minPrice || priceValue > maxPrice){
                return false;
            }
        }
        return true;
    }




    }


