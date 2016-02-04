package peaktech.set.view;

import org.openqa.selenium.support.PageFactory;
import peaktech.set.LoginPageContainer;
import peaktech.set.utils.BrowserDriver;

public class LoginView {
    private static final LoginPageContainer loginContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginPageContainer.class);

    public static void isDisplayedCheck() {
        BrowserDriver.waitForElement(loginContainer.loginPageWelcomeString);
        loginContainer.loginPageWelcomeString.isDisplayed();
    }

    public static void login(String username, String password) {
        loginContainer.emailInput.sendKeys(username);
        loginContainer.passwordInput.sendKeys(password);
        loginContainer.submitButton.click();
    }

    public static void checkLoginSuccess() {
        HomeView.isDisplayedCheck();
    }

    public static void checkLoginErrors() {
        BrowserDriver.waitForElement(loginContainer.getUsernameValidationDiv());
        BrowserDriver.waitForElement(loginContainer.getPasswordValidationDiv());
    }
}
