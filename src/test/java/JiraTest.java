import hooks.Hooks;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import service.*;

import static org.junit.Assert.assertTrue;

public class JiraTest extends Hooks {

    private HomePageService homePageService = new HomePageService();
    private BrowseProjectsService browseProjectsService = new BrowseProjectsService();
    private RapidBoardService rapidBoardService = new RapidBoardService();
    private SoftAssertions softAssertion = new SoftAssertions();
    private CreateTestService createTestService = new CreateTestService();
    private TestInformationService testInformationService = new TestInformationService();

    @Before
    public void authorization(){
        AuthorizationService authorizationService = new AuthorizationService();
        authorizationService.isAllRequiredFieldsAreVisible(softAssertion);
        authorizationService.performAuthorization("esirozh", "123Qwerty");
        authorizationService.isSignInButtonVisible(softAssertion);
        authorizationService.pressSignInButton();
    }

    @Test
    public void checkNumberOfTasks() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openBrowseProjectsPage();
        browseProjectsService.selectProject("Test");
        rapidBoardService.openListOfTasks(softAssertion);
        Integer numberOfTasks = rapidBoardService.getNumberOfTasks();
        Integer numberOfTasksInList = rapidBoardService.getNumberOfTasksInLisy();
        assertTrue("Заявленное количество и количество задач в листе различны", numberOfTasks.equals(numberOfTasksInList));
    }

    @Test
    public void checkTaskTestSelenium() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openBrowseProjectsPage();
        browseProjectsService.selectProject("Test");
        rapidBoardService.openListOfTasks(softAssertion);
        rapidBoardService.selectTest("TestSelenium");
        String statusTest = rapidBoardService.getStatusValue(softAssertion);
        String versionTest = rapidBoardService.getVersionValue(softAssertion);
        assertTrue("Ожидался статус задачи \"В РАБОТЕ\"", statusTest.equals("В РАБОТЕ"));
        assertTrue("Ожидалась версия \"Version 2.0\"", versionTest.equals("Version 2.0"));
    }

    @Test
    public void createNewTest() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openCreateTestPage();
        createTestService.isAllRequiredFieldsAreVisible(softAssertion);
        createTestService.performCreateTest("TestSirozh", "Description");
        createTestService.isAllRequiredFieldsAreVisible(softAssertion);
        createTestService.pressCreateButton();
    }

    @Test
    public void changeStatusTaskToClosed() throws InterruptedException {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openBrowseProjectsPage();
        browseProjectsService.selectProject("Test");
        rapidBoardService.openListOfTasks(softAssertion);
        rapidBoardService.selectTest("testSirozh");
        rapidBoardService.openTestInformationPage(softAssertion);
        testInformationService.isAllRequiredFieldsAreVisible(softAssertion);
        testInformationService.completeTask();
        Thread.sleep(3000);
        String statusTest = rapidBoardService.getStatusValue(softAssertion);
        assertTrue("Ожидался статус задачи \"ГОТОВО\"", statusTest.equals("ГОТОВО"));
    }
}
