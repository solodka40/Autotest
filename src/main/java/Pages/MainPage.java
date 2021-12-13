package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//BUTTON[@class='kitt-cookie-warning__close'][text()='Закрыть']")
    WebElement cookies;

    @FindBy(xpath = "//nav[@aria-label='Основное меню']")
    WebElement mainMenu;
    @FindBy(xpath = "(//DIV[@class='kitt-top-menu__dropdown kitt-top-menu__dropdown_icons'])[8]")
    WebElement subMenu;


    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(".//a[@aria-label='" + menuItem + "']")).click();
    }


    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath(".//li/a[text()='" + menuItem + "']")).click();
    }

    public void closeCookies() {
        jsExec.executeScript("arguments[0].click();", cookies);
    }
}
