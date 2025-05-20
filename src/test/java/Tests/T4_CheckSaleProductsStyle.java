package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.SalePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_CheckSaleProductsStyle extends BaseTest {

    @Test
    public void testProductsStyle(){

        //precondition sign In Tealium Application
        LoginPage loginPage =  homepage.clickLogIn();
        MyAccountPage myAccountPage = loginPage.loginAsDefaultUser();

        myAccountPage.hoverOverSaleMenu();
        SalePage salePage = myAccountPage.clickAllSaleMenu();
        Assert.assertTrue(salePage.allProductsHaveOriginalAndDiscountedPrices(), " \n Not all products have original and discounted prices \n");


        String originalColor = salePage.getOriginalPriceColor();
        String originalTextDecoration = salePage.getOriginalPriceTextDecoration();

        String finalColor = salePage.getFinalPriceColor();
        String finalTextDecoration = salePage.getFinalPriceTextDecoration();


        Assert.assertEquals(originalColor, "rgba(160, 160, 160, 1)", "Original price color is not grey");
        Assert.assertTrue(originalTextDecoration.contains("line-through"), "Original price is not strikethrough");


        Assert.assertEquals(finalColor, "rgba(51, 153, 204, 1)", "Final price color is not blue");
        Assert.assertFalse(finalTextDecoration.contains("line-through"), "Final price should not have strikethrough");
    }


    }



