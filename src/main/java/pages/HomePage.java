package pages;

import elements.Button;
import org.openqa.selenium.By;

public class HomePage {

    private final Button projectButton = new Button(By.xpath("//a[@id='browse_link']"));
    private final Button viewAllButton = new Button(By.xpath("//li[@id='project_view_all_link']"));
    private final Button createTestButton = new Button(By.xpath("//a[@id='create_link']"));

    public Button getProjectButton() {
        return projectButton;
    }

    public Button getViewAllButton() {
        return viewAllButton;
    }

    public Button getCreateTestButton() {
        return createTestButton;
    }
}
