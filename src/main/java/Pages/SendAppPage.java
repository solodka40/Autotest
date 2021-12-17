package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendAppPage extends BasePage {

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

    @FindBy(xpath = "//div[@class='alert-form alert-form-error']")
    WebElement allertError;

    @FindBy(xpath = "//input-phone2/span/validation-message/span[contains(text(),'Поле не заполнено.')]")
    WebElement allertError1;

    @FindBy(xpath = "//legend[contains(text(),'Контакты')]")
    WebElement contacts;

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

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия":
                return surname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Дата рождения":
                return birthDate.getAttribute("value");
            case "Фамилия страхователя":
                return person_firstName.getAttribute("value");
            case "Имя страхователя":
                return person_lastName.getAttribute("value");
            case "Отчество страхователя":
                return person_middleName.getAttribute("value");
            case "Дата рождения страхователя":
                return person_birthDate.getAttribute("value");
            case "Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Дата выдачи паспорта":
                return documentDate.getAttribute("value");
            case "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }


    public void checkOutBtn() {
        waitUntilElementToBeClickable(finalBtn);
        jsExec.executeScript("arguments[0].click();", finalBtn);
    }

    public void checkingErrors() {
        jsExec.executeScript("return arguments[0].scrollIntoView(true);", contacts);

        String s = allertError.getText();
        Assert.assertTrue("Текст ошибки не соответствует заявленному", s.contains("При заполнении данных произошла ошибка"));

        String k = allertError1.getText();
        Assert.assertTrue("Текст ошибки не соответствует заявленному", k.contains("Поле не заполнено"));
    }


}
