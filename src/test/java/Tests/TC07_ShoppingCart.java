package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_ShoppingCart extends BaseTest {

    @Test
    public void addItemsToShoppingCart() {

        LoginPage loginPage = homepage.clickLogIn();
        loginPage.loginAsDefaultUser();
        homepage.clickAccountMenu();
        WishListPage wishListPage = homepage.clickWishList();


        wishListPage.editItems("Pink", 0);
        wishListPage.editItems("White", 1);
        ShoppingCartPage shoppingCartPage = wishListPage.clickAddAllToCartButton();

        shoppingCartPage.setQuantityOption("2");
        shoppingCartPage.clickUpdateButton();

        double sum = shoppingCartPage.getProductPricesSum();
        double grandTotal = shoppingCartPage.getGrandTotalPrice();

        Assert.assertEquals(sum, grandTotal, 0.01, "\n Prices sum is not equal to grand total price \n");







    }
}
