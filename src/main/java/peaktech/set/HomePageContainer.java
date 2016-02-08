package peaktech.set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageContainer {
    //TODO: модифицировать элементы на страницах в админ панели, добавить уникальные классы
    @FindBy(how = How.CLASS_NAME, using = "md-display-1")
    public WebElement homePageTenantName;
}
