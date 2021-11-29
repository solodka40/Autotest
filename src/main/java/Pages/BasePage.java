package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;


    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void checkFillField(String value, WebElement element) {
        Assert.assertEquals(value, element.getAttribute("value"));
    }

}
