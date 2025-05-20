package Tests;

import Base.BaseTest;
import Pages.ShoppingCartPage;
import Pages.WishListPage;
import Preconditions.TestPreconditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void addItemsToShoppingCart(){
        WishListPage wishListPage = TestPreconditions.prepareWishlistWithTwoItems(driver);
        ShoppingCartPage shoppingCartPage = wishListPage.addAllProductsToCart();
        shoppingCartPage.setQuantityOption("2");
        shoppingCartPage.clickUpdateButton();

        double sum = shoppingCartPage.getProductPricesSum();
        double grandTotal = shoppingCartPage.getGrandTotalPrice();

        Assert.assertEquals(sum, grandTotal, 0.01, "\n Prices sum is not equal to grand total price \n");



    }
}
