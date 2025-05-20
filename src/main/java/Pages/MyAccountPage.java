package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends BasePage {
    private By successfulRegisterMessage = By.xpath("//li[@class='success-msg']//ul//li");
    private By welcomeMessage = By.xpath("//p[@class='welcome-msg']");
    private By womenMenu = By.xpath("//a[@class='level0 has-children'][normalize-space()='Women']");
    private By menMenu = By.xpath("//li[@class='level0 nav-2 parent']//a[text()='Men']");
    private By saleMenu = By.xpath("//li[@class='level0 nav-5 parent']//a[text()='Sale']");
    private By viewAllWomenCategory = By.xpath("//a[contains(text(), 'View All Women')]");
    private By viewAllMenMenu = By.xpath("//a[contains(text(), 'View All Men')]");
    private By viewAllSaleMenu = By.xpath("//a[contains(text(), 'View All Sale')] ");


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public boolean isRegisterMessageDisplayed(){
        return find(successfulRegisterMessage).isDisplayed();
    }

    public boolean isWelcomeMessageDisplayed(){
        return find(welcomeMessage).isDisplayed();

    }

    public void hoverOverWomenMenu(){
      actions.moveToElement(find(womenMenu)).perform();
    }

    public WomenPage clickAllWomenCategory(){
        click(viewAllWomenCategory);
        return new WomenPage(driver);
    }


    public void hoverOverSaleMenu(){
        actions.moveToElement(find(saleMenu)).perform();
    }

    public SalePage clickAllSaleMenu(){
        click(viewAllSaleMenu);
        return new SalePage(driver);
    }

    public void hoverOverMenMenu(){
        actions.moveToElement(find(menMenu)).perform();
    }

    public MenPage clickAllMenMenu(){
        click(viewAllMenMenu);
        return new MenPage(driver);
    }

}
