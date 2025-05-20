package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.WomenPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_CheckHoverStyle extends BaseTest {

    @Test
    public void testHoverEffect(){
        //precondition sign In Tealium Application
        LoginPage loginPage =  homepage.clickLogIn();
        MyAccountPage myAccountPage = loginPage.loginAsDefaultUser();

        myAccountPage.hoverOverWomenMenu();
        WomenPage womenPage = myAccountPage.clickAllWomenCategory();

        String styleBefore  = womenPage.getCssValueBeforeHover();
        String styleAfter = womenPage.getCssValueAfterHover();
        Assert.assertNotEquals(styleBefore, styleAfter, "The border color has not changed after hover!");
    }
}
