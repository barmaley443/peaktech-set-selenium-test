package peaktech.set;


import peaktech.set.constants.CredentialsType;
import peaktech.set.constants.Outcome;
import peaktech.set.utils.BrowserDriver;
import peaktech.set.view.LoginView;

public class Navigation {
    private User user;

    public void given_I_navigate_to_the_landing_page() {
        BrowserDriver.loadPage("http://127.0.0.1:1337");
        LoginView.isDisplayedCheck();
    }

    public void when_I_try_to_login(String credentialsType) {
        CredentialsType ct = CredentialsType.credentialsTypeForName(credentialsType);
        switch (ct) {
            case VALID:
                user = Users.createValidUser();
                break;
            case INVALID:
                user = Users.createInvalidUser();
                break;
        }
        LoginView.login(user.getEmail(), user.getPassword());
    }

    public void then_I_login(String outcomeString) {
        Outcome outcome = Outcome.outcomeForName(outcomeString);
        switch (outcome) {
            case SUCCESS:
                LoginView.checkLoginSuccess();
                break;
            case FAILURE:
                LoginView.checkLoginErrors();
                break;
        }
    }
}
