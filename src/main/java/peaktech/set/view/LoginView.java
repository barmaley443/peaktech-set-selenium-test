package peaktech.set.view;

import org.openqa.selenium.support.PageFactory;
import peaktech.set.LoginPageContainer;
import peaktech.set.utils.BrowserDriver;

import java.util.logging.Logger;

public class LoginView {
    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());
    private static final LoginPageContainer loginContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginPageContainer.class);

    public static void isDisplayedCheck() {
        LOGGER.info("Checking login page is displayed");
        BrowserDriver.waitForElement(loginContainer.loginPageWelcomeString);
        loginContainer.loginPageWelcomeString.isDisplayed();
    }

    public static void login(String username, String password) {
        LOGGER.info("Logging in with username:" + username + " password:" + password);
        loginContainer.emailInput.sendKeys(username);
        loginContainer.passwordInput.sendKeys(password);
        loginContainer.submitButton.click();
        LOGGER.info("Login submitted");
    }

    public static void checkLoginSuccess() {
        LOGGER.info("Check login was successful");
        HomeView.isDisplayedCheck();
    }

    public static void checkLoginErrors() {
        LOGGER.info("Check login errors displayed");
        BrowserDriver.waitForElement(loginContainer.getUsernameValidationDiv());
        BrowserDriver.waitForElement(loginContainer.getPasswordValidationDiv());
    }
}
