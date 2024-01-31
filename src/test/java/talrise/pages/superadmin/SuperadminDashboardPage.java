package talrise.pages.superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class SuperadminDashboardPage extends CommonPageElements {

    public String getDashboardPageTopMenuItemInfo(String topMenuItem){
        return driver.findElement(By.xpath("(//*[.=\""+topMenuItem+"\"]//..//div)[2]")).getText();
    }
    public String getDashboardPageTopMenuItemName(String topMenuItemName){
        return driver.findElement(By.xpath("//*[text()='"+topMenuItemName+"']")).getText();
    }
    public String getDashboardPageBrowseApplicationListColumnName(String columnName){
        return driver.findElement(By.xpath("//div[contains(text(),'"+columnName+"')]")).getText();
    }
    @FindBy(xpath = "//p[contains(@class,'MuiTypography')]")
    public WebElement profileStatusRole;
    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    public WebElement dashboardLabel;
    @FindBy(xpath = "//h1[contains(text(),'Job Details')]")
    public WebElement jobDetailsPage;
    @FindBy(xpath = "//h2[contains(text(),'Contact Details')]")
    public WebElement contactDetailsPage;
    @FindBy(xpath = "(//tr[@index='0']//td)[7]")
    public WebElement plusforCreatingJob;
    @FindBy(xpath = "(//tr[@index='0']//td)[6]")
    public WebElement threeDotUnderJobDetails;
    @FindBy(xpath = "((//tr[@index='0']//td)[1]//div//div)[2]")
    public WebElement threeDotUnderCandidateInfo;
    @FindBy(xpath = "//span[text()='NEXT']")
    public WebElement nextButtonForJobCreate;
    @FindBy(xpath = "//h3[contains(text(),'Browse applicants list')]")
    public WebElement browseApplicationListLabel;

}
