package talrise.pages.superadmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class SuperAdminCandidateProcessPage extends CommonPageElements {
    @FindBy(xpath = "(//span[@class='sc-dNsVcS dmEeqb'])[5]")
    public WebElement ActivityButton;
    @FindBy(xpath = "(//span[@class='sc-dNsVcS dmEeqb'])[8]")
    public WebElement CandidateProcessButton;
}
