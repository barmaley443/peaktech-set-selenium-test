package peaktech.set.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserDriver {
    private static WebDriver mDriver;

    public synchronized static WebDriver getCurrentDriver() {
        if (mDriver == null) {
            try {
                mDriver = BrowserFactory.getBrowser();
            } catch (UnreachableBrowserException e) {
                System.err.println("UnreachableBrowserException: " + e.getMessage());
                mDriver = BrowserFactory.getBrowser();
            } catch (WebDriverException e) {
                System.err.println("WebDriverException: " + e.getMessage());
                mDriver = BrowserFactory.getBrowser();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return mDriver;
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            mDriver = null;
        } catch (UnreachableBrowserException e) {
            System.err.println("UnreachableBrowserException: " + e.getMessage());
        }
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

    public static void loadPage(String url) {
        getCurrentDriver();
        getCurrentDriver().get(url);
    }

    public static void reopenAndLoadPage(String url) {
        mDriver = null;
        getCurrentDriver();
        loadPage(url);
    }

    public static WebElement waitForElement(WebElement elementToWaitFor) {
        return waitForElement(elementToWaitFor, null);
    }

    public static WebElement waitForElement(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
        if (waitTimeInSeconds == null) {
            waitTimeInSeconds = 10;
        }

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), waitTimeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }

    public static WebElement getParent(WebElement element) {
        return element.findElement(By.xpath(".."));
    }

    public static List<WebElement> getDropDownOptions(WebElement webElement) {
        Select select = new Select(webElement);
        return select.getOptions();
    }

    public static WebElement getDropDownOption(WebElement webElement, String value) {
        WebElement option = null;
        List<WebElement> options = getDropDownOptions(webElement);
        for (WebElement element : options) {
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                option = element;
                break;
            }
        }
        return option;
    }
}

