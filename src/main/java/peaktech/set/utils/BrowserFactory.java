package peaktech.set.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.awt.*;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static final String BROWSER_PROP_KEY = "browser";

    public static WebDriver getBrowser() {
        WebDriver driver;
        String browser = System.getProperty(BROWSER_PROP_KEY);
        if (browser == null) {
            driver = createFirefoxDriver();
        } else {
            switch (browser) {
                case "chrome":
                    driver = createChromeDriver();
                    break;
                case "safari":
                    driver = createSafariDriver();
                    break;
                case "opera":
                    driver = createOperaDriver();
                    break;
                case "firefox":
                default:
                    driver = createFirefoxDriver();
                    break;
            }
        }
        addAllBrowserSetup(driver);
        return driver;
    }

    private static WebDriver createSafariDriver() {
        System.setProperty("webdriver.safari.noinstall", "true");
        SafariOptions options = new SafariOptions();
        options.setUseCleanSession(true);
        return new SafariDriver(options);
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "lib/chrome/mac32/chromedriver");
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile firefoxProfile = profile.getProfile("default");
        return new FirefoxDriver(firefoxProfile);
    }

    private static WebDriver createOperaDriver() {
        System.setProperty("webdriver.opera.driver", "lib/opera/mac64/operadriver");
        return new OperaDriver();
    }

    private static void addAllBrowserSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(dimension);
    }

}
