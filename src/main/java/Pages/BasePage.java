package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static steps.BaseSteps.getDriver;

public class BasePage {
    JavascriptExecutor jsExec = ((JavascriptExecutor) BaseSteps.getDriver());
    Actions actions = new Actions(BaseSteps.getDriver());

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10, 1000);

    public void fillField(WebElement element, String value) {
        waitUntilElementToBeClickable(element).click();
        element.clear();
        element.sendKeys(value);
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void fillInputField(WebElement field, String value) {

        waitUntilElementToBeClickable(field).click();
        field.sendKeys(value);
    }

}
