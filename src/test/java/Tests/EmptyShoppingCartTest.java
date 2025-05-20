package Tests;

import Base.BaseTest;
import Pages.ShoppingCartPage;
import Preconditions.TestPreconditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyShoppingCartTest extends BaseTest {
    @Test
    public void emptyShppingCartTest() {
        ShoppingCartPage shoppingCartPage = TestPreconditions.prepareCartWithTwoItems(driver);

        int itemsCount = shoppingCartPage.getNumberOfCartItems();

        while (itemsCount > 0) {
            shoppingCartPage.clickDeleteFirstItem();
            shoppingCartPage.waitForCartItemsCountToBe(itemsCount - 1);
            int newCount = shoppingCartPage.getNumberOfCartItems();

            Assert.assertEquals(newCount, itemsCount - 1,
                    "Cart items count was not decreased by 1 after delete button.");

            itemsCount = newCount;
        }


        Assert.assertTrue(shoppingCartPage.isShoppingCartEmpty(), "Shopping cart should be empty.");
    }
}
