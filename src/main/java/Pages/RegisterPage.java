package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.JavaScriptUtility.clickJS;

public class RegisterPage extends BasePage {

    private By createAccountHeader = By.xpath("//div[@class='page-title']");
    private By firstNameField = By.xpath("//input[@id='firstname']");
    private By lastNameField = By.xpath("//input[@id='lastname']");
    private By emailField = By.xpath("//input[@id='email_address']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By confirmPasswordField = By.xpath("//input[@id='confirmation']");
    private By registerButton = By.xpath("//button[@title='Register']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public String getTitle(){
        return find(createAccountHeader).getText();
    }

    public void enterRegisterDetails(String fname, String lname, String email, String password) {
        set(firstNameField, fname);
        set(lastNameField, lname);
        set(emailField, email);
        set(passwordField, password);
        set(confirmPasswordField, password);
    }


    public MyAccountPage clickRegisterButton(){
        clickJS(registerButton);
        return new MyAccountPage(driver);
    }


}
