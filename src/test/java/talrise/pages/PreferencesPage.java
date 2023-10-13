package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PreferencesPage extends CommonPageElements{
    @FindBy(xpath = "//div[@id='locations[0].countryId-select-input-id']")
    public WebElement preferencesCountry;
    @FindBy(xpath = "//div[@id='locations[1].countryId-select-input-id']")
    public WebElement preferencesCountry2;


    @FindBy(xpath = "//div[@id='locations[1].cityId-select-input-id']")
    public WebElement preferencesCity2;
    @FindBy(xpath = "//div[@id='locations[0].cityId-select-input-id']")
    public WebElement preferencesCity;
    @FindBy(xpath = "//div[@id='locations[0].workPlaceIds-select-input-id']")
    public WebElement preferencesWorkPlace;
    @FindBy(xpath = "//div[@id='locations[1].workPlaceIds-select-input-id']")
    public WebElement preferencesWorkPlace2;
    @FindBy(xpath = "//div[@id='contractTypeId-select-input-id']")
    public WebElement preferencesContractType;
    @FindBy(xpath = "//div[@id='salaryPreferenceId-select-input-id']")
    public WebElement preferencesSalaryPreferences;
    @FindBy(xpath = "//input[@id='minExpectedAmount']")
    public WebElement preferencesMinExpectedAmount;
    @FindBy(xpath = "//div[@id='currencyId-select-input-id']")
    public WebElement preferencesCurrency;
    @FindBy(xpath = "//div[@id='visaStatusId-select-input-id']")
    public WebElement preferencesVisaStatus;

    @FindBy(xpath = "//li")
    public List<WebElement> DropDownContext;
    public WebElement DropDownContext(String value){
        return driver.findElement(By.xpath("//li[.='"+value+"']"));



    }
    public List<WebElement> DropDownBox(String value){
        return driver.findElements(By.xpath("//*[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiAccordion-root MuiAccordion-rounded Mui-expanded css-pcn5tp']//label[.='"+value+"']/.."));

    }
    @FindBy(xpath = "//button[@class='sc-aXZVg dNFTfU sc-dwalKd jzAOMa addLocation']")
    public WebElement preferencesAddButton;
    @FindBy(xpath = "//button[@class='sc-aXZVg jnVozQ sc-dwalKd jzAOMa btn-delete']")
    public WebElement deleteb;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div[3]/div/div[2]/div/div[9]/div[2]/div/div/div/div/div[2]/button[1]")
    public WebElement cancel;

    @FindBy(xpath = "//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//span[.='Delete']")
    public List<WebElement> preferencesAllDeletes;

    @FindBy(xpath = "//div[@class='sc-kbdlSk bDYvMa text-example']")
    public WebElement preferencesText;
    @FindBy(xpath = "(//div[@class='sc-SrznA fNcrbv'])[9]/div[2]/button[2]")
    public WebElement preferencesSaveButton;
    @FindBy(xpath = "//div[text()='Your preferences has been submitted successfully.']")
    public WebElement preferencesSaveAlertMessage;

    @FindBy(xpath = "(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorSecondary MuiInputBase-formControl sc-tagGq OOInL css-j7tdi3'])[15]")
    public WebElement WP;

    @FindBy(xpath = "//p[@id='minExpectedAmount-helper-text']")
    public WebElement preferencesMinSalaryMessage;










}
