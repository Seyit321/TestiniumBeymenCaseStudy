package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    By PRODUCT_DESCRIPTION = By.className("o-productDetail__description");
    By PRODUCT_PRICE = By.id("priceNew");
    By SIZE = By.xpath(".//*[contains(@class, 'm-variation__item')][not(contains(@class, 'disabled'))]");
    By ADD_TO_CART_BTN = By.id("addBasket");
    By CART_ICON = By.cssSelector(".m-notification__button");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductDescription() {
        return findElement(PRODUCT_DESCRIPTION).getText();
    }

    public String getProductPrice() {
        return findElement(PRODUCT_PRICE).getText();
    }

    public void selectSize() {
        click(SIZE);
    }

    public void addToCart() {
        click(ADD_TO_CART_BTN);
    }

    public CartPage goToCartPage() {
        click(CART_ICON);
        return new CartPage(driver);
    }

}
