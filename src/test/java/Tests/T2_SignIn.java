package Tests;
import Base.BaseTest;
import Pages.LoginPage;
import Pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_SignIn extends BaseTest {


    @Test
    public void signInWithCreatedAccount(){

        LoginPage loginPage =  homepage.clickLogIn();
        loginPage.enterCredentials("sara.test@example.com", "sara123!");
        MyAccountPage myAccountPage = loginPage.clickLoginButton();
        Assert.assertTrue(myAccountPage.isWelcomeMessageDisplayed());

        homepage.clickLogOutButton();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ecommerce.tealiumdemo.com/customer/account/";
        Assert.assertEquals(actualUrl, expectedUrl, "You have not returned to homepage");


    }

}
