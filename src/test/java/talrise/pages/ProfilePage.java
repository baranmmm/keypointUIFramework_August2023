package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends CommonPageElements{

    public void clickOnProfileSectionPencilIcon(String profileSection){
        driver.findElement(By.xpath("//span[.='"+profileSection+"']//..//../div//div[@class=\"expandIconWrapper\"]")).click();
    }

    public boolean isProfileSectionHeaderVisible(String profileSection){
        return driver.findElement(By.xpath("//h2[contains(.,'"+profileSection+"')]")).isDisplayed();
    }

    // ...... Aynur un calismalari asagida

    @FindBy(xpath = "//span[text()='Profile']")
    public WebElement profile;

    @FindBy(xpath = "//h1[text()='Profile']")
    public WebElement profileText;

    @FindBy(xpath = "//div[@class='expandIconWrapper']")
    public List<WebElement> iconPencilList;

    @FindBy(css = "[class=\"sc-jXbUNg esKOjA text-example\"]")
    public List<WebElement> profileModuleList;

    @FindBy(css = "[class=\"MuiAccordionSummary-expandIconWrapper css-1fx8m19\"]")
    public List<WebElement> moduleEditIconList;

    public WebElement moduls(String modules){
        WebElement moduls=driver.findElement(By.xpath("//span[text()='"+modules+"']"));
        return moduls;
    }

    @FindBy(xpath = "//div[contains(@class, 'MuiAvatar-root')]")
    public List<WebElement> initialOfName;

    @FindBy(xpath = "//span[@style='text-transform: capitalize;']")
    public WebElement profilePageNameLastName;

    @FindBy(xpath = "//span[@class='sc-jXbUNg eQSfg'][2]")
    public WebElement profileJobTitle;

    @FindBy(xpath = "//span[@class='sc-dhKdcB kQLVTS']")
    public WebElement locationNameAndIcon;

    @FindBy(xpath = "//span[@class='sc-dhKdcB hjJqLG text-example']")
    public WebElement OffTheMarketText;

    @FindBy(xpath = "//span[@class='MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorDefault PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorDefault Mui-checked css-1g3pnk5']")
    public WebElement OffTheMarketButton;

    @FindBy(xpath = "//span[text()='Profile complete rate']")
    public WebElement profileCompleteRateText;

    @FindBy(xpath = "//div[@class='MuiBox-root css-pazuet']")
    public WebElement percentageRate;

    @FindBy(xpath = "//span[@role='progressbar']")
    public WebElement percentageLine;

    @FindBy(xpath = "(//button[@label='save'])[5]")
    public WebElement saveButtonInIndustry;

    @FindBy(xpath = "//span[text()='Industry']")
    public WebElement industryModule;

    @FindBy(xpath = "//span[@class='sc-dhKdcB hjJqLG text']")
    public WebElement lastLoginText;

    @FindBy(xpath = "//span[@class='sc-dhKdcB hjJqLG text2']")
    public WebElement lastLoginDate;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium download-pdf layout-button layout-save css-1hw9j7s']")
    public WebElement overviewButton;

    @FindBy(xpath = "//div[@class='sc-iapWAC fNQdCK']")
    public List<WebElement> profileModuleList2;

    @FindBy(xpath = "//div[contains(@class, 'MuiAccordionSummary-root')]")
    public List<WebElement> getProfileModuleList ;

    @FindBy(xpath = "//div[@class='MuiCollapse-wrapperInner MuiCollapse-vertical css-8atqhb']")
    public List<WebElement> getProfileCollapsedOpenList ;

    @FindBy(css = "[class= \"collapseIconWrapper\"]")
    public List<WebElement> moduleEditIconListForClosed;

    @FindBy(xpath = "(//div[@class='sc-hCPjZK cTBSCn'][1])[3]/button[1]")
    public WebElement industryModuleFirstField;

    @FindBy(xpath = "(//span[.='Industry']//../*)[1]")
    public WebElement greenTickIndustry;
}
