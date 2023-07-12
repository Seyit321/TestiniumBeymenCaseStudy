package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CategoryPage extends BasePage {

    By PRODUCT_LIST = By.className("m-productImageList__item");
    By PAGE_TITLE = By.cssSelector("#productListTitle b");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectRandomProduct() {
        List<WebElement> element_list = findElements(PRODUCT_LIST);
        int element_count = element_list.size();
        Random rand = new Random();
        int rand_index = rand.nextInt(element_count);
        element_list.get(rand_index).click();
        return new ProductPage(driver);
    }

    public String searchedCategoryInfo(){
        return findElement(PAGE_TITLE).getText().replace("\"", "");
    }
}
