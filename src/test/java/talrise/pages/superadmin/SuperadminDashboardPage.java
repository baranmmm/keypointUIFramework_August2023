package talrise.pages.superadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class SuperadminDashboardPage extends CommonPageElements {

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
    @FindBy(xpath = "//h3[contains(text(),'Browse applicants list')]")
    public WebElement browseApplicationListLabel;
    @FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[2]")
    public WebElement rowsDropDown;
    @FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[2]//div//div")
    public WebElement rowsDropDownGetText;
    @FindBy(xpath = "(//span[contains(@class,'MuiTypography')])[3]")
    public WebElement currentPage;
    @FindBy(xpath = "//span[@title='Next Page']")
    public WebElement nextPageButton;
    @FindBy(xpath = "(//select[@name='jobStatus'])[1]")
    public WebElement dropDownButton;

    public String getDashboardPageTopMenuItemInfo(String topMenuItem) {
        return driver.findElement(By.xpath("(//*[.=\"" + topMenuItem + "\"]//..//div)[2]")).getText();
    }

    public String getDashboardPageTopMenuItemName(String topMenuItemName) {
        return driver.findElement(By.xpath("//*[text()='" + topMenuItemName + "']")).getText();
    }

    public String getDashboardPageBrowseApplicationListColumnName(String columnName) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + columnName + "')]")).getText();
    }

    public void getRowsValue(Integer rowsValue) {
        driver.findElement(By.xpath("//li[@data-value='" + rowsValue + "']")).click();
    }

    public void getChangePage(String pageName) {
        driver.findElement(By.xpath("//span[@title='" + pageName + "']")).click();
    }

    public void clickButton(String buttonName) {
        driver.findElement(By.xpath("//span[.='" + buttonName + "']")).click();
    }


}
