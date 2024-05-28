package talrise.pages.superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class SuperAdminCandidateProcessPage extends CommonPageElements {
    @FindBy(xpath = "//span[.='Activity']")
    public WebElement ActivityButton;
    @FindBy(xpath = "//span[.='Candidate Process']")
    public WebElement CandidateProcessButton;
    @FindBy(xpath = "//h3[text()='Browse applicants list']")
    public WebElement BrowseApplicantsListTitle;

    public String getTableColumnHeader(String columnHeader){
        return driver.findElement(By.xpath("//*[text()='"+columnHeader+"']")).getText();
    }
}
