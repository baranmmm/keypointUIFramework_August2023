package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends CommonPageElements{

    public void clickOnProfileSectionPencilIcon(String profileSection){
        driver.findElement(By.xpath("//span[.='"+profileSection+"']//..//../div//div[@class=\"expandIconWrapper\"]")).click();
    }

    public boolean isProfileSectionHeaderVisible(String profileSection){
        return driver.findElement(By.xpath("//h2[contains(.,'"+profileSection+"')]")).isDisplayed();
    }


}
