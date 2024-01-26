package talrise.pages.candidate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class OverviewPage extends CommonPageElements {

    @FindBy(xpath = "//h1")
    public WebElement fullName;

    @FindBy(xpath = "//h2[1]")
    public WebElement occupation;


}
