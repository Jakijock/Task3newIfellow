package service;

import org.assertj.core.api.SoftAssertions;
import pages.HomePage;

import static utils.Assertions.isVisible;

public class HomePageService extends HomePage {

    public void openBrowseProjectsPage() {
        getProjectButton().click();
        getViewAllButton().click();
    }

    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getProjectButton(), "Project");
        isVisible(softAssertion, getViewAllButton(), "ViewAll");
        isVisible(softAssertion, getCreateTestButton(), "Create");
    }

    public void openCreateTestPage() {
        getCreateTestButton().click();
    }
}
