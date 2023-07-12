package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class CartPage extends BasePage {

    By PRODUCT_PRICE = By.className("m-productPrice__salePrice");
    By PRODUCT_QUANTITY = By.id("quantitySelect0-key-0");
    By QUANTITY_COUNT = By.xpath(".//*[contains(@id, 'quantity')]//option");
    By EMPTY_CART_POPUP = By.id("emtyCart");
    By REMOVE_BTN = By.id("removeCartItemBtn0-key-0");
    By CART_PAGE_HEADER = By.className("m-basket__header--title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPagePresent(){
        return isElementVisible(CART_PAGE_HEADER);
    }

    public String getProductPrice() {
        return findElement(PRODUCT_PRICE).getText();
    }

    public void changeQuantity(String quantity) {
        List<WebElement> quantityCount = findElements(QUANTITY_COUNT);
        if (quantityCount.size() > 1) {
            Select select = new Select(driver.findElement(PRODUCT_QUANTITY));
            select.selectByValue(quantity);
        }
    }

    public void removeItem() {
        click(REMOVE_BTN);
    }

    public boolean isEmptyCartPopupVisible() {
        return isElementVisible(EMPTY_CART_POPUP);
    }
}
