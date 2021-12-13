package util;

import cucumber.api.Result;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestStepFinished;
import io.qameta.allure.Allure;
import io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import steps.BaseSteps;

import java.io.ByteArrayInputStream;

public class AllureReporter extends AllureCucumber4Jvm {

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        super.setEventPublisher(publisher);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        if (event.result.is(Result.Type.FAILED)){
            Allure.getLifecycle().addAttachment("Скрин при падении","image/png","png",new ByteArrayInputStream(((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }
}
