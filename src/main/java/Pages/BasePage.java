package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static steps.BaseSteps.getDriver;

public class BasePage {
    JavascriptExecutor jsExec = ((JavascriptExecutor) BaseSteps.getDriver());

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }


}
