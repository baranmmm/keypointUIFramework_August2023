package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.utilities.Driver;

import java.util.List;
import java.util.Random;

import static talrise.utilities.CommonSteps.waitFor;

public class ExperiencePage extends CommonPageElements {
    @FindBy(xpath = "//span[text()='complete now']")
    public WebElement completeNowButton;
    @FindBy(css = "[class='MuiButtonBase-root MuiAccordionSummary-root css-1uaukoe']")
    public List<WebElement> moduleEditIconList;

    @FindBy(xpath = "//span[text()='Experience']")
    public WebElement experienceSection;
    @FindBy(xpath = "//h2[text()='Experience']")
    public WebElement experienceText;

    //*******************************Generated a method is in order verify that the text of the input boxes in the Experience Module are available**********************************
    public boolean isExperienceFieldsContainsText(String fieldText) {
        return driver.findElement(By.xpath("(//*[text()='" + fieldText + "'])[1]")).getText().contains(fieldText);
    }
    @FindBy(xpath = "(//label[text()='Title*'])")
    public List<WebElement> titleTextElements;
    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleInputBox;
    @FindBy(xpath = "//input[@id='company']")
    public WebElement companyInputBox;
    @FindBy(xpath = "(//input[@placeholder='mm.yyyy'])[1]")
    public WebElement startDateInputBox;
    @FindBy(xpath = "(//input[@placeholder='mm.yyyy'])[2]")
    public WebElement endDateInputBox;
    @FindBy(xpath = "(//span[text()='Delete'])[1]")
    public WebElement deleteButton;
    @FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
    public WebElement ICWITPCheckBox;
    @FindBy(xpath = "//span[text()='I am currently working in this position.']")
    public WebElement ICWINTPText;
    @FindBy(xpath = "//li[@role='option']")
    public List<WebElement> contractTypeList;
    @FindBy(xpath = "//div[@id='experiences[0].contractTypeId-select-input-id']")
    public WebElement contractTypeDropDown;
    @FindBy(xpath = "//div[@id='experiences[0].workPlaceId-select-input-id']")
    public WebElement workplaceDropDown;
    @FindBy(xpath = "//li[@role='option']")
    public List<WebElement> workplaceList;
    @FindBy(xpath = "//div[@id='experiences[0].toolIds-select-input-id']")
    public WebElement skillSetDropDown;
    @FindBy(xpath = "//span[text()='Please choose all the skill sets you used while working in this position.*']")
    public WebElement skillSetDropDownText;
    @FindBy(xpath = "(//ul[@role='listbox'])//li")
    public List<WebElement> skillSetList;
    @FindBy(xpath = "(//button[@label='save'])[7]")
    public WebElement experienceSaveButton;
    @FindBy(xpath = "//div[text()='Your experience info has been submitted successfully.']")
    public WebElement successMessage;
    @FindBy(xpath = "//p[text()='Please choose at least one tool you used while working in this position.']")
    public WebElement skillSetWarningMsg;

    public Boolean experienceWarningMessage(String message) {
       return driver.findElement(By.xpath("//*[text()='"+message+"']")).isDisplayed();
    }
    @FindBy(xpath = "//div[text()='Request failed with status code 406']")
    public WebElement popupMsg;

    @FindBy(xpath = "//div[@id='experiences[0].noticePeriodId-select-input-id']")
    public WebElement noticePeriodDropDown;

    @FindBy(xpath="(//ul[@role='listbox'])//li")
    public List<WebElement> noticePeriodList;

    @FindBy(xpath = "//span[.='ADD MORE EXPERIENCE']")
    public WebElement addMoreExpBtn;

    @FindBy(xpath = "(//button[text()='Cancel'])[7]")
    public WebElement cancelBtn;

    @FindBy(xpath = "(//button[text()='SAVE'])[7]")
    public WebElement saveBtn;
    @FindBy(id = "explanationText")
    public WebElement experienceTextBox;
    @FindBy(xpath= "(//div[contains(@class,'toolsSelected')])")
    public List<WebElement>selectedToolsList;
    @FindBy(xpath ="((//div[contains(@class,'toolsSelected')])//span)")
    public List<WebElement> crossBtnList;


}