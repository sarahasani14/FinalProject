package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;


  public class TC08_EmptyShoppingCartTest extends BaseTest {
      @Test
      public void emptyShoppingCartTest() {

          LoginPage loginPage = homepage.clickLogIn();
          loginPage.loginAsDefaultUser();
          homepage.clickAccountMenu();
          ShoppingCartPage shoppingCartPage = homepage.clickMyCart();

          int initialCount = shoppingCartPage.getNumberOfCartItems();
          shoppingCartPage.removeFirstCartItem();
          int countAfterFirstDelete = shoppingCartPage.getNumberOfCartItems();
          Assert.assertEquals(countAfterFirstDelete, initialCount - 1, "Item count should decrease by 1 after first delete");

          shoppingCartPage.removeFirstCartItem();
          int countAfterSecondDelete = shoppingCartPage.getNumberOfCartItems();
          Assert.assertEquals(countAfterSecondDelete, initialCount - 2, "Item count should decrease by 1 after second delete");

          Assert.assertTrue(shoppingCartPage.isShoppingCartEmpty(), "Shopping cart should be empty after deleting all items");
      }



      }

