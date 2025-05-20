package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class BasePage {
    protected WebDriver driver;
    protected Actions actions;

    private By optInButton = By.id("privacy_pref_optin");
    private By submitButton = By.id("consent_prompt_submit");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }


    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public void closeConsentModalIfPresent() {
        List<WebElement> optInElements = driver.findElements(optInButton);
        if (!optInElements.isEmpty()) {
            WebElement optIn = optInElements.get(0);
            optIn.click();

            WebElement submit = driver.findElement(submitButton);
            submit.click();
        }
    }




}
