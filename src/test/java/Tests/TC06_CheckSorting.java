package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC06_CheckSorting extends BaseTest {

    @Test
    public void checkSortingAndWishListCount() {
        // Precondition - Login
        LoginPage loginPage = homepage.clickLogIn();
        MyAccountPage myAccountPage = loginPage.loginAsDefaultUser();


        myAccountPage.hoverOverWomenMenu();
        WomenPage womenPage = myAccountPage.clickAllWomenCategory();
        womenPage.selectPriceDropdown(2);
        Assert.assertTrue(womenPage.areProductsSortedByPrice(), "Products are not sorted by Price");


        womenPage.addProductToWishList(0);
        womenPage.addProductToWishList(1);


        homepage.clickAccountMenu();
        String wishList = homepage.getWishListCount();
        Assert.assertTrue(wishList.contains("(2 items)"), "There are not 2 items added to wishlist");
    }
}


