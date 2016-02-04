package peaktech.set.view;


import org.openqa.selenium.support.PageFactory;
import peaktech.set.HomePageContainer;
import peaktech.set.utils.BrowserDriver;

public class HomeView {
    private static final HomePageContainer homePageContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomePageContainer.class);

    public static void isDisplayedCheck() {
        BrowserDriver.waitForElement(homePageContainer.homePageTenantName);
        homePageContainer.homePageTenantName.isDisplayed();
    }
}
