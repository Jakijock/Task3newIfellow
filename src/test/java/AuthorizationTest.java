import hooks.Hooks;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import service.AuthorizationService;

public class AuthorizationTest extends Hooks {

    private AuthorizationService authorizationService = new AuthorizationService();

    @Test
    public void authorization(){
        SoftAssertions softAssertions = new SoftAssertions();
        authorizationService.isAllRequiredFieldsAreVisible(softAssertions);
        authorizationService.performAuthorization("esirozh", "123Qwerty");
        authorizationService.isSignInButtonVisible(softAssertions);
        authorizationService.pressSignInButton();
    }
}
