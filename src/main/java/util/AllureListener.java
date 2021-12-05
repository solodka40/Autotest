package util;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import steps.BaseSteps;

public class AllureListener extends AllureJunit4 {

@Override
public void testFailure(Failure failure) {
    BaseSteps.takeScreenshot();
    super.testFailure(failure);
}
}
