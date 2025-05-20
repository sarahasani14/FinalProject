package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CheckSortingTest extends BaseTest {

    @Test
    public void checkSortingAndWishListCount() {
        // Precondition - Login
        LoginPage loginPage = homepage.clickLogIn();
        MyAccountPage myAccountPage = loginPage.loginAsDefaultUser();


        myAccountPage.hoverOverWomenMenu();
        WomenPage womenPage = myAccountPage.clickAllWomenCategory();
        womenPage.selectPriceDropdown(2);
        Assert.assertTrue(womenPage.areProductsSortedByPrice(), "Products are not sorted by Price");


        WishListPage wishListPage = womenPage.addProductToWishList(0);
        wishListPage.clickWomenMenu();
        womenPage.addProductToWishList(1);


        homepage.clickAccountMenu();
        String wishList = homepage.getWishListCount();
        Assert.assertTrue(wishList.contains("(2 items)"), "There are not 2 items added to wishlist");
    }
}


