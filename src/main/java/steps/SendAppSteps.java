package steps;

import Pages.SendAppPage;
import io.qameta.allure.Step;
import org.junit.Assert;

import java.util.HashMap;

public class SendAppSteps {


        @Step("поле {0} заполняется значением {1}")
        public void fillField(String field, String value){
            new SendAppPage().fillField(field, value);
        }

        @Step("поле {0} заполнено значением {1}")
        public void checkFillField(String field, String value){
            String actual = new SendAppPage().getFillField(field);
            Assert.assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                    actual.equals(value));
        }



        @Step("заполняются поля")
        public void fillFields(HashMap<String, String> fields){
            fields.forEach((k, v)-> fillField(k,v));
        }

        @Step("поля заполнены верно")
        public void checkFillFields(HashMap<String, String> fields){
            fields.forEach((k, v)-> checkFillField(k,v));
        }
}
