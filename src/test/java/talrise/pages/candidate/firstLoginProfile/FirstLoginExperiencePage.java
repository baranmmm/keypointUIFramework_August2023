package talrise.pages.candidate.firstLoginProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class FirstLoginExperiencePage extends CommonPageElements {
    @FindBy(xpath = "//h2[text()='Experience']")
    public WebElement experienceHeaderK;

    @FindBy(xpath = "//span[text()='Please add your work experience.']")
    public WebElement experienceRequestK;

    // Delete Button
    @FindBy(xpath = "//span[normalize-space()='Delete']")
    public WebElement deleteButtonK;

    // Title Section
    @FindBy(xpath = "//label[text()='Title*']")
    public WebElement titleCheckboxLabelK;

    @FindBy(xpath = "//input[@name='experiences[0].title']")
    public WebElement titleCheckboxK;

    @FindBy(xpath = "//input[@value='QA']")
    public WebElement filledTitleCheckbox;

    // Company Section
    @FindBy(xpath = "//label[text()='Company*']")
    public WebElement companyCheckboxLabelK;

    @FindBy(xpath = "//input[@name='experiences[0].company']")
    public WebElement companyCheckboxK;

    @FindBy(xpath = "//input[@value='ABC']")
    public WebElement filledCompanyCheckboxK;

    // Dropdown Section
    @FindBy(xpath = "//div[@id='experiences[0].contractTypeId-select-input-id']")
    public WebElement contractTypeDropdownK;

    @FindBy(xpath = "//label[text()='Contract Type']")
    public WebElement contractTypeDropdownLabelK;

    @FindBy(xpath = "//div[text()='Permanent']")
    public WebElement contractTypeOptionK;

    @FindBy(xpath = "//div[@id='experiences[0].workPlaceId-select-input-id']")
    public WebElement workplaceDropdownK;

    @FindBy(xpath = "//label[text()='Workplace']")
    public WebElement workplaceDropdownLabelK;

    @FindBy(xpath = "//div[text()='Hybrid']")
    public WebElement workplaceOptionK;

    @FindBy(xpath = "//label[@id=':r2:-label']")
    public WebElement startDateDropdownK;

    @FindBy(xpath = "//label[text()='Start Date*']")
    public WebElement startDateDropdownLabelK;

    @FindBy(xpath = "//input[@value='01.1980']")
    public WebElement filledStartDateDropdownK;

    @FindBy(xpath = "//button[@tabindex='-1']")
    public WebElement endDateDropdownK;

    @FindBy(xpath = "//label[text()='End Date*']")
    public WebElement endDateDropdownLabelK;

    @FindBy(xpath = "//*[@value='11.2023']")
    public WebElement filledEndDateDropdownK;

    // Calendar
    @FindBy(xpath = "//*[@data-testid='CalendarIcon']")
    public WebElement startDateCalendarK;

    @FindBy(xpath = "//*[@data-testid='CalendarIcon']")
    public WebElement endDateCalendarK;

    @FindBy(xpath = "//*[@class='MuiInputBase-input MuiOutlinedInput-input Mui-disabled MuiInputBase-inputAdornedEnd css-1uvydh2']")
    public WebElement inactivatedEndDateK;

    @FindBy(xpath="//p[text()='Please choose at least one tool you used while working in this position.']")
    public WebElement warningSkillSetMessageK;

    @FindBy(xpath="(//div[text()='ML Models'])[2]")
    public WebElement selectedMLModelsK;

    // Radio Buttons
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement currentlyWorkingCheckboxK;

    @FindBy(xpath="//span[text()='I am currently working in this position.']")
    public WebElement currentlyWorkingCheckboxWordsK;

    @FindBy(xpath = "//input[@value='true']")
    public WebElement tickedRadioButtonK;

    // Notice Period Section
    @FindBy(xpath = "//div[@class='MuiFormControl-root sc-bbSZdi drVfln noticePeriodId css-13sljp9']")
    public WebElement noticePeriodDropdownK;

    @FindBy(xpath = "//div[text()='1 week']")
    public WebElement noticePeriodOptionK;

    // Skill Set Section
    @FindBy(xpath = "//span[text()='Please choose all the skill sets you used while working in this position.*']")
    public WebElement skillSetRequestK;

    @FindBy(xpath = "//div[@id='experiences[0].toolIds-select-input-id']")
    public WebElement skillSetDropdownK;

    @FindBy(xpath = "(//div[text()='Entity Developer'])[2]")
    public WebElement skillSetOptionK;

    @FindBy(xpath = "//*[@class='sc-aXZVg kFhKFl sc-dPZUQH cVdrNd close']")
    public WebElement closeSkillSetOptionK;

    // Additional Information
    @FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorSecondary MuiInputBase-formControl MuiInputBase-multiline MuiInputBase-adornedEnd css-nwmo74']")
    public WebElement additionalInformationInputK;

    // Add More Experience Button
    @FindBy(xpath = "//*[text()='ADD MORE EXPERIENCE']")
    public WebElement addMoreButtonK;

    public String getAdditionalFieldsLabel(String fieldsName){
        return driver.findElement(By.xpath("(//label[contains(text(),'"+fieldsName+"')])[2]")).getText();
    }

    //@FindBy(xpath="(//label[text()='Title*'])[2]")
    //public WebElement additionalTitle;
    // @FindBy(xpath="(//label[text()='Company*'])[2]")
    // public WebElement additionalCompany;


    // Warning Messages
    @FindBy(xpath = "//*[text()='Please enter a title.']")
    public WebElement titleWarningMessageK;

    @FindBy(xpath = "//*[text()='Please enter a company name.']")
    public WebElement companyWarningMessageK;

    //@FindBy(xpath = "//p[text()='Please enter the start date.']")
    // @FindBy(xpath = "//p[contains(text(),'Please enter the start date.')]")
    //@FindBy(xpath="(//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-v7esy'])[3]")
    // @FindBy(xpath ="//div[@class='sc-cVzyXs bSXOCv']")
    @FindBy(xpath="//p[@id=':r59:-helper-text']")
    public WebElement startDateWarningMessageK;

    //@FindBy(xpath = "//p[text()='Please enter the end date.']")
    @FindBy(xpath="//p[@id=':r5a:-helper-text']")
    public WebElement endDateWarningMessageK;

    @FindBy(xpath = "//p[text()='Please choose at least one tool you used while working in this position.']")
    public WebElement chooseToolWarnMessageK;

    @FindBy(xpath = "//*[text()='Please indicate the notice period.']")
    public WebElement noticePeriodWarningMessageK;

    // After Completion
    @FindBy(xpath = "(//input[@id='title'])[2]")
    public WebElement secondTitleInputK;

    @FindBy(xpath = "(//input[@id='company'])[2]")
    public WebElement secondCompanyInputK;

    @FindBy(xpath = "(//div[@class='sc-YysOf howfXN'])[5]")
    public WebElement secondContractWorkplaceSectionK;

    // Navigation Buttons
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement exitButtonK;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement nextButtonK;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement backButtonK;
}




