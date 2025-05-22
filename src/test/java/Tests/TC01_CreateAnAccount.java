package Tests;

import Base.BaseTest;
import Pages.MyAccountPage;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_CreateAnAccount extends BaseTest {
    @Test
    public void createNewAccount() {

        RegisterPage registerPage = homepage.clickRegister();


        String actualHeader = registerPage.getTitle();
        String expectedHeader = "CREATE AN ACCOUNT";
        Assert.assertEquals(actualHeader, expectedHeader, "\n Actual and Expected do not match \n");


        registerPage.enterRegisterDetails("Sara", "Hasani", "sara.test@example.com", "sara123!");
        MyAccountPage myAccountPage = registerPage.clickRegisterButton();


        Assert.assertTrue(myAccountPage.isRegisterMessageDisplayed(), "\n Successful Registration Message is not displayed \n");

        homepage.clickLogOutButton();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://ecommerce.tealiumdemo.com/customer/account/index/";
        Assert.assertEquals(actualUrl, expectedUrl, "You have not returned to homepage");




    }

}
