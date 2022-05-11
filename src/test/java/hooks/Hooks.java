package hooks;


import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {
    private static final String BASE_URL = "https://edujira.ifellow.ru/";

    @BeforeClass
    public static void openBrowser() {
        Configuration.startMaximized = true;
        open(BASE_URL);
    }

    @AfterClass
    public static void closeDriver() {
        closeWebDriver();
    }
}
