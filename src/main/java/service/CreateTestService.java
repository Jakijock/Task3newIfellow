package service;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CreateTestPage;

import static utils.Assertions.isVisible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateTestService extends CreateTestPage {

    public void performCreateTest(
            String summary,
            String description
    ) {
        getSummaryInput().clearAndType(summary);
        getWebDriver().switchTo().frame((WebElement) getWebDriver().findElement(By.xpath("//div[@id='description-wiki-edit']/descendant::iframe")));
        getDescriptionInpute().clearAndType(description);
        getWebDriver().switchTo().defaultContent();
    }

    public void pressCreateButton() {
        getCreateButton().click();
    }

    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getSummaryInput(), "Summary");
        isVisible(softAssertion, getDescriptionIframeButton(), "Description");
    }
}
