package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.JavaScriptUtility.clickJS;

public class LoginPage extends BasePage {
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='pass']");
    private By loginButton = By.xpath("//span[contains(text(),'Login')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterCredentials(String email, String password){
        set(emailField, email);
        set(passwordField, password);
    }

    public MyAccountPage clickLoginButton(){
        clickJS(loginButton);
        return new MyAccountPage(driver);
    }

    public MyAccountPage loginAsDefaultUser() {
        enterCredentials("sara.test@example.com", "sara123!");
        return clickLoginButton();
    }


}
