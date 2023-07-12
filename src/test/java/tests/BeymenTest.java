package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;


import java.io.IOException;

public class BeymenTest extends BaseTest {
    BasePage basePage;
    HomePage homePage;
    CategoryPage categoryPage;
    CartPage cartPage;
    ProductPage productPage;

    @Test

    public void testItemAddedToCart() throws IOException {
        logger.info("Go to Beymen homepage and check if the homepage is opened");
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.closeGenderSelection();
        Assertions.assertEquals("https://www.beymen.com/", driver.getCurrentUrl(),
                "Current url is not equal to expected one!");
        logger.info("Homepage is checked successfully!");

        logger.info("Get category name from excel file and search the category");
        String firstItem = String.valueOf(basePage.getExcelData(0,0));
        String secondItem = String.valueOf(basePage.getExcelData(0,1));
        homePage.fillSearchBox(firstItem);
        homePage.clearSearchBox();
        homePage.fillSearchBox(secondItem);
        categoryPage =  homePage.searchItem();
        basePage.sleep(2000);
        Assertions.assertEquals(secondItem, categoryPage.searchedCategoryInfo(), "The search result is not equal to expected value");
        logger.info("Desired category page opened successfully!");

        logger.info("Select random product and write product info to txt file");
        productPage =  categoryPage.selectRandomProduct();
        productPage.selectSize();
        String productPrice = productPage.getProductPrice();
        String productDesc = productPage.getProductDescription();
        basePage.writeDataToTxt(productDesc + "\n" + productPrice);
        logger.info("Random product was selected and product info written the txt file");

        logger.info("Add item to cart and compare product price between cart and product page");
        productPage.addToCart();
        cartPage = productPage.goToCartPage();
        Assertions.assertTrue(cartPage.isCartPagePresent(), "It is not cart page!");
        String cartProductPrice = cartPage.getProductPrice();
        Assertions.assertEquals(productPrice, cartProductPrice,
                "Product Page product price should be equal with cart page product price!");
        logger.info("İtem added to cart and prices compared successfully!");

        logger.info("Change product quantity and remove item from cart");
        cartPage.changeQuantity("2");
        cartPage.removeItem();
        Assertions.assertTrue(cartPage.isEmptyCartPopupVisible(), "Cart is not empty!");
        logger.info("Quantity changed and item removed from cart successfully!");


    }

}
