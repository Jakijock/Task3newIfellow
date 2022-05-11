package pages;

import elements.*;
import org.openqa.selenium.By;

public class AuthorizationPage {

    private final Input emailInput = new Input(By.id("login-form-username"));
    private final Input passwordInput = new Input(By.id("login-form-password"));
    private final Button signInButton = new Button(By.id("login"));

    public Input getEmailInput() {
        return emailInput;
    }

    public Input getPasswordInput() {
        return passwordInput;
    }

    public Button getSignInButton() {
        return signInButton;
    }

}
