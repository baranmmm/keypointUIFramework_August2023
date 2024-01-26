package talrise.pages.superadmin;

import org.openqa.selenium.By;
import talrise.pages.CommonPageElements;

public class SuperadminDashboardPage extends CommonPageElements {

    public String getDashboardPageTopMenuItemInfo(String topMenuItem){
        return driver.findElement(By.xpath("(//*[.=\""+topMenuItem+"\"]//..//div)[2]")).getText();
    }
}
