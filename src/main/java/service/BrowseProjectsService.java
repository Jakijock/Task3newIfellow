package service;

import pages.BrowseProjectsPage;

import static com.codeborne.selenide.Condition.text;

public class BrowseProjectsService extends BrowseProjectsPage {

    public void selectProject(String projectName){
        getProjectsCollection().filterBy(text(projectName)).first().click();
    }

    public void isAllRequiredFieldsAreVisible() throws InterruptedException {
        getProjectsCollection().getModel(0).wait(10000);
    }

}
