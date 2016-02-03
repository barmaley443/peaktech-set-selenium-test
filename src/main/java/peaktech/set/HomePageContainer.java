package peaktech.set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageContainer {

    @FindBy(how = How.CLASS_NAME, using = "md-display-1")
    public WebElement homePageTenantName;
}
