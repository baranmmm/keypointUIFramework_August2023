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
        return driver.findElement(By.xpath("//*[text()='Total Applications']")).getText();
    }
    @FindBy(xpath = "//p[contains(@class,'MuiTypography')]")
    public WebElement profileStatusRole;
}
