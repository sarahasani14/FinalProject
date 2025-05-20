package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.MenPage;
import Pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T5_CheckPageFilters extends BaseTest {

    @Test
    public void testBorderColorAndChangeCriteria(){
        //precondition sign In Tealium Application
        LoginPage loginPage =  homepage.clickLogIn();
        MyAccountPage myAccountPage = loginPage.loginAsDefaultUser();

        myAccountPage.hoverOverMenMenu();
        MenPage menPage = myAccountPage.clickAllMenMenu();
        menPage.clickBlackColor();
        Assert.assertTrue(menPage.selectedColorsHaveBlueBorders(), "Selected color does not have blue border");

        menPage.clickPriceRange();
        int actualDisplayedItems = menPage.getNumberOfDisplayedProducts();
        int expectedDisplayedItems = 3;
        Assert.assertEquals(actualDisplayedItems, expectedDisplayedItems, "actual and expected do not match");


        Assert.assertTrue(menPage.pricesMatchTheDefinedCriteria(70.0, Double.MAX_VALUE), "prices do not match the defined criteria");

    }


}
