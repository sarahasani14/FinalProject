package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class HomePage extends BasePage {

    private By accountMenu = By.xpath("//span[@class='label'][normalize-space()='Account']");
    private By register = By.xpath("//a[@title='Register']");
    private By logIn = By.xpath("//a[@title='Log In']");
    private By logOut = By.xpath("//a[@title='Log Out']");
    private By myWishList = By.xpath("//a[contains(text(), 'My Wishlist')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickRegister(){
        click(accountMenu);
        click(register);
        return new RegisterPage(driver);
    }

    public HomePage clickLogOutButton(){
        click(accountMenu);
        click(logOut);
        return new HomePage(driver);
    }

    public LoginPage clickLogIn(){
        click(accountMenu);
        click(logIn);
        return new LoginPage(driver);
    }

    public void clickAccountMenu() {
        try {
          click(accountMenu);
        } catch (StaleElementReferenceException e) {
            System.out.println("Element was stale, trying again...");
            WebElement accountMenu = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            accountMenu.click();
        }
    }


    public String getWishListCount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(myWishList));
        return element.getText();

    }

}
