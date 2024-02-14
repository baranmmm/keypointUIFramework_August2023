package talrise.pages.superadmin.CreateJobsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

import java.util.List;

public class CreateJobsPage extends CommonPageElements {
    @FindBy( xpath = "//span[.= 'Activity']")
    public WebElement ActivityButton;

    @FindBy(xpath = "//span[.= 'Jobs']")
   // @FindBy( xpath = "//*[@class=\"sc-bdOgaJ kKjqUS active\"]")
    public WebElement JobsButton;

   @FindBy(xpath = "//span[.= 'Create Jobs']")
   public WebElement JobsCreateButton;

    @FindBy( xpath = "//td[7]")
    public List<WebElement> addButtons;

    @FindBy( id = "positionId-select-input-id")
    public WebElement positionName;

    @FindBy( id = "employmentTypeId-select-input-id")
    public WebElement employmentType;

    @FindBy(css=  "input[name*='jobTitle']")
    public WebElement jobTitle;

    @FindBy( id = "countryId-select-input-id")
    public WebElement countryId;

    @FindBy( id = "cityId-select-input-id")
    public WebElement cityId;

    @FindBy( id = "contractTypeId-select-input-id")
    public WebElement contractTypeId;

    @FindBy( id = "salaryPreferenceId-select-input-id")
    public WebElement salaryPreferenceId;

    @FindBy( id = "workPlaceIds-select-input-id")
    public WebElement workPlaceId;

    @FindBy( id = "salaryAmountId-select-input-id")
    public WebElement salaryAmountId;

    @FindBy( id = "currencyId-select-input-id")
    public WebElement currencyId;

    @FindBy( id = "currency")
    public WebElement LanguageId;

    @FindBy( xpath = "(//input[@type='tel'])[1]")
    public WebElement ApplicationClosingDate;

    @FindBy( xpath = "(//input[@type='tel'])[2]")
    public WebElement ExpectedStartDate;

    @FindBy( xpath = "//span[.='NEXT']")
    public WebElement nextButton;

    @FindBy( xpath = "//div[3]//li[4]")
    public WebElement QaDeveloperPositionName;

    @FindBy( xpath = "//div/ul/li[2]")
    public WebElement EmploymentTypeFullT;

    @FindBy( xpath = "//div//li[5]")
    public WebElement CountryUk;

    @FindBy(xpath = "//div//ul//li")
    public WebElement cityIdLondon;

    @FindBy( xpath = "//div//li[1]")
    public WebElement ContractTypePermanent;

    @FindBy(xpath = "//div/ul/li[2]")
    public WebElement WorkPlaceRemote;

    @FindBy( xpath = "//div//li[3]")
    public WebElement SalaryAmount;

    @FindBy(xpath = "//div/ul/li[3]")
    public WebElement salaryPreferenceMonth;
}
