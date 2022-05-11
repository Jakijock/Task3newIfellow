package service;

import org.assertj.core.api.SoftAssertions;
import pages.RapidBoardPage;

import static com.codeborne.selenide.Condition.text;
import static utils.Assertions.isVisible;

public class RapidBoardService extends RapidBoardPage {

    public void openListOfTasks(SoftAssertions softAssertion){
        isVisible(softAssertion, getTasksButton(), "Tasks");
        getTasksButton().click();
    }

    public Integer getNumberOfTasks(){
        getNumberTasksLabel().isDisplayed();
        String numberString = getNumberTasksLabel().getText();
        Integer number = Integer.valueOf(numberString.split(" ")[0]);
        return number;
    }

    public Integer getNumberOfTasksInLisy(){
        getTasksListButtons().getModel(0).isVisible();
        getShowAllTasksButton().click();
        Integer number = getTasksListButtons().size();;
        return number;
    }

    public void selectTest(String testName) {
        showAllTasks();
        getAllTasksButtons().filterBy(text(testName)).first().click();
    }

    public String getStatusValue(SoftAssertions softAssertion){
        isVisible(softAssertion, getStatusLabel(), "Email");
        return getStatusLabel().getText();
    }

    public String getVersionValue(SoftAssertions softAssertion){
        isVisible(softAssertion, getVersionLabel(), "Email");
        return getVersionLabel().getText();
    }

    public void openTestInformationPage(SoftAssertions softAssertion) {
        isVisible(softAssertion, getShowProblemButton(), "ShowProblem");
        getShowProblemButton().click();
    }

    public void showAllTasks() {
        getShowAllTasksButton().click();
    }
}
