package talrise.pages.superadmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

import java.util.List;

public class SuperAdminCandidateProcessPage extends CommonPageElements {
    @FindBy(xpath = "(//span[@class='sc-dNsVcS dmEeqb'])[5]")
    public List<WebElement> ActivityButtonList;
    @FindBy(xpath = "(//span[@class='sc-dNsVcS dmEeqb'])[8]")
    public List<WebElement> CandidateProcessButtonList;
}
