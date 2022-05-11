package service;

import pages.AuthorizationPage;
import org.assertj.core.api.SoftAssertions;

import static utils.Assertions.isVisible;

public class AuthorizationService extends AuthorizationPage {

    public void performAuthorization(
            String email,
            String password
    ) {
        getEmailInput().clearAndType(email);
        getPasswordInput().clearAndType(password);
    }

    public void pressSignInButton() {
        getSignInButton().click();
    }

    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getEmailInput(), "Email");
        isVisible(softAssertion, getPasswordInput(), "Password");
    }

    public void isSignInButtonVisible(SoftAssertions softAssertion) {
        isVisible(softAssertion, getSignInButton(), "Enter");
    }

}

