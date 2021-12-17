package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolicyPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Минимальная')]")
    public WebElement amount;

    @FindBy(xpath = "//button[contains(text(),'Оформить')]")
    public WebElement sendBtn;

    @FindBy(xpath = "//h2[contains(text(),'')]")
    public WebElement title;

    @FindBy(xpath = "//a[contains(text(),'Оформление')]")
    WebElement title1;

    public void checkPageName(String name) {
        Assert.assertEquals("Заголовок страницы не равен: " + name + ".", name, title.getText());
    }

    public void goToSendAppPage() {
        //sendBtn.click();
        waitUntilElementToBeClickable(sendBtn);
        jsExec.executeScript("arguments[0].click();", sendBtn);
        //actions.click(sendBtn).build().perform();
    }

    public void SumOfIns() {
        jsExec.executeScript("arguments[0].click();", amount);
        jsExec.executeScript("return arguments[0].scrollIntoView(true);", sendBtn);

    }
    public void checkAfterSendBtn(String name){
        Assert.assertTrue("Заголовок страницы не равен: Оформление", name.contains("Оформление"));
    }


}
