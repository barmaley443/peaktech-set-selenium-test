package peaktech.set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import peaktech.set.utils.BrowserDriver;

public class LoginPageContainer {
    private String validationContainerCSS = "div.ng-active";

    @FindBy(how = How.CLASS_NAME, using = "md-display-1")
    public WebElement loginPageWelcomeString;

    @FindBy(how = How.NAME, using = "email")
    public WebElement emailInput;

    public WebElement getUsernameValidationDiv() {
        WebElement parent = BrowserDriver.getParent(BrowserDriver.getParent(emailInput));
        return parent.findElement(By.cssSelector(validationContainerCSS));
    }

    @FindBy(how = How.NAME, using = "password")
    public WebElement passwordInput;

    public WebElement getPasswordValidationDiv() {
        WebElement parent = BrowserDriver.getParent(BrowserDriver.getParent(passwordInput));
        return parent.findElement(By.cssSelector(validationContainerCSS));
    }

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement submitButton;
}
