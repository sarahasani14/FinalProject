package Preconditions;


import Pages.*;
import org.openqa.selenium.WebDriver;

public class TestPreconditions {
    public static WishListPage prepareWishlistWithTwoItems(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogIn();
        MyAccountPage myAccountPage = loginPage.loginAsDefaultUser();

        myAccountPage.hoverOverWomenMenu();
        WomenPage womenPage = myAccountPage.clickAllWomenCategory();
        womenPage.selectPriceDropdown(2);



        WishListPage wishListPage = womenPage.addProductToWishList(0);
        wishListPage.clickWomenMenu();
        womenPage.addProductToWishList(1);

        return new WishListPage(driver);
    }


    public static ShoppingCartPage prepareCartWithTwoItems(WebDriver driver) {
        WishListPage wishListPage = prepareWishlistWithTwoItems(driver);
        return wishListPage.addAllProductsToCart();
    }



}







