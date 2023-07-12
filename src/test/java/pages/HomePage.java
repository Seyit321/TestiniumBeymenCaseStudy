package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By COOKIES = By.id("onetrust-accept-btn-handler");
    By GENDER_SELECTION_CLOSE_BTN = By.cssSelector(".o-modal__closeButton");
    By SEARCH_INPUT = By.cssSelector(".o-header__search--input");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        click(COOKIES);
    }

    public void closeGenderSelection() {
        click(GENDER_SELECTION_CLOSE_BTN);
    }

    public void fillSearchBox(String text) {
        fillInput(text, SEARCH_INPUT);
    }

    public void clearSearchBox() {
        driver.findElement(SEARCH_INPUT).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    public CategoryPage searchItem(){
        click(SEARCH_INPUT);
        driver.findElement(SEARCH_INPUT).sendKeys(Keys.ENTER);
        return new CategoryPage(driver);
    }
}
