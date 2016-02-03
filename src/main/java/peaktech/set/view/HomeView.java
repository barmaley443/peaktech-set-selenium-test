package peaktech.set.view;


import org.openqa.selenium.support.PageFactory;
import peaktech.set.HomePageContainer;
import peaktech.set.utils.BrowserDriver;

import java.util.logging.Logger;

public class HomeView {
    private static final Logger LOGGER = Logger.getLogger(HomeView.class.getName());
    private static final HomePageContainer homePageContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomePageContainer.class);

    public static void isDisplayedCheck() {
        LOGGER.info("Checking login page is displayed");
        BrowserDriver.waitForElement(homePageContainer.homePageTenantName);
        homePageContainer.homePageTenantName.isDisplayed();
    }
}
