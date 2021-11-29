package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendAppPage extends BasePage{

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surname;

    @FindBy(id = "name_vzr_ins_0")
    WebElement name;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDate;


    @FindBy(id = "person_lastName")
   public WebElement person_lastName;

    @FindBy(id = "person_firstName")
    WebElement person_firstName;

    @FindBy(id = "person_middleName")
    WebElement person_middleName;

    @FindBy(id = "person_birthDate")
    WebElement person_birthDate;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "passportSeries")
    public WebElement passportSeries;

    @FindBy(xpath = "//label[contains(text(),'Мужской')]")
    public WebElement sex;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

   @FindBy(xpath = "//legend[contains(text(),'Страхователь')]")
   public WebElement person;

    @FindBy(xpath = "//button[@class='btn btn-primary page__btn']")
    public WebElement finalBtn;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия":
                fillField(surname, value);
                break;
            case "Имя":
                fillField(name, value);
                break;
            case "Дата рождения":
                fillField(birthDate, value);
                break;
            case "Фамилия страхователя":
                fillField(person_firstName, value);
                break;
            case "Имя страхователя":
                fillField(person_lastName, value);

                break;
            case "Отчество страхователя":
                fillField(person_middleName, value);
                break;
            case "Дата рождения страхователя":
                fillField(person_birthDate, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Дата выдачи паспорта":
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

}
