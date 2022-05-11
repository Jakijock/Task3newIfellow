package service;

import org.assertj.core.api.SoftAssertions;

import pages.TestInformationPage;

import java.util.concurrent.TimeUnit;

import static utils.Assertions.isVisible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestInformationService extends TestInformationPage {

    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getBusinessProcessesButton(), "BusinessProcesses");
    }

    public void completeTask() throws InterruptedException {
        getBusinessProcessesButton().click();
        getWebDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        getDoneButton().click();
    }

}
