package talrise.pages.candidate.normalProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

import java.util.List;
<<<<<<< HEAD:src/test/java/talrise/pages/ExperiencePage.java
import java.util.Random;

import static talrise.pages.PageInitializer.experiencePage;
import static talrise.utilities.CommonSteps.waitFor;

public class ExperiencePage extends CommonPageElements {

    @FindBy(xpath = "//span[text()='complete now']")
    public WebElement completeNowButton;
=======

public class ExperiencePage extends CommonPageElements {

    @FindBy(css = "[class='sc-jXbUNg esKOjA text-example']")
    public List<WebElement> profileModuleList;
>>>>>>> master:src/test/java/talrise/pages/candidate/normalProfile/ExperiencePage.java
    @FindBy(css = "[class='MuiButtonBase-root MuiAccordionSummary-root css-1uaukoe']")
    public List<WebElement> moduleEditIconList;
    @FindBy(xpath = "//div[@class='sc-deXhhX eHpwUw']")
    public WebElement experienceText;
<<<<<<< HEAD:src/test/java/talrise/pages/ExperiencePage.java

    //*******************************Generated a method is in order verify that the text of the input boxes in the Experience Module are available**********************************
    public boolean isExperienceFieldsContainsText(String fieldText) {
        return driver.findElement(By.xpath("(//*[text()='" + fieldText + "'])[1]")).getText().contains(fieldText);
    }

=======
>>>>>>> master:src/test/java/talrise/pages/candidate/normalProfile/ExperiencePage.java
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
    @FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined MuiSelect-multiple MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[1]")
    public WebElement skillSetDropDown;
    @FindBy(xpath = "(//input[@class='MuiSelect-nativeInput css-1k3x8v3'])[9]")
    public WebElement skillSetDropDown1;
    @FindBy(xpath = "//span[text()='Please choose all the skill sets you used while working in this position.*']")
    public WebElement skillSetDropDownText;
    @FindBy(xpath = "(//ul//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-11oatdh'])[1]")
    public WebElement skillSetOption;
    @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-11oatdh']")
    public List<WebElement> skillSetList;
    @FindBy(xpath = "(//button[@label='save'])[7]")
    public WebElement experienceSaveButton;
    @FindBy(xpath = "//div[text()='Your experience info has been submitted successfully.']")
    public WebElement successMessage;
    @FindBy(css = "ArrowDropDownIcon")
    public WebElement skillSetArrow;
    @FindBy(xpath = "(//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-v7esy'])[2]")
    public WebElement skillSetWarningMsg;
<<<<<<< HEAD:src/test/java/talrise/pages/ExperiencePage.java

    public Boolean experienceWarningMessage(String message) {
        return driver.findElement(By.xpath("//*[text()='" + message + "']")).isDisplayed();
    }

    @FindBy(xpath = "//div[text()='Request failed with status code 406']")
    public WebElement popupMsg;

    ////div[@role='alert']//div[text()='Request failed with status code 406']
    @FindBy(xpath = "//div[@id='experiences[0].noticePeriodId-select-input-id']")
    public WebElement noticePeriodDropDown;

    @FindBy(xpath = "(//ul[@role='listbox'])//li")
=======
    @FindBy(xpath = "//div[@id='experiences[0].noticePeriodId-select-input-id']")
    public WebElement noticePeriodDropDown;
    @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-11oatdh']")
>>>>>>> master:src/test/java/talrise/pages/candidate/normalProfile/ExperiencePage.java
    public List<WebElement> noticePeriodList;
    @FindBy(xpath = "//span[.='ADD MORE EXPERIENCE']")
    public WebElement addMoreExpBtn;
    @FindBy(xpath = "(//button[text()='Cancel'])[7]")
    public WebElement cancelBtn;
    @FindBy(xpath = "(//button[text()='SAVE'])[7]")
    public WebElement saveBtn;
    @FindBy(xpath = "//span[text()='complete now']")
    public WebElement completeNowButton;
    @FindBy(xpath = "//span[text()='Experience']")
    public WebElement experienceSection;
    @FindBy(xpath = "//div[text()='Request failed with status code 406']")
    public WebElement popupMsg;
    @FindBy(id = "explanationText")
    public WebElement experienceTextBox;
    @FindBy(xpath = "(//div[contains(@class,'toolsSelected')])")
    public List<WebElement> selectedToolsList;
    @FindBy(xpath = "((//div[contains(@class,'toolsSelected')])//span)")
    public List<WebElement> crossBtnList;

    public void experienceWarningMessage(String message) {
        driver.findElement(By.xpath("//*[contains(.,'" + message + "')]//..//p")).isDisplayed();
    }

    //*******************************Generated a method is in order verify that the text of the input boxes in the Experience Module are available**********************************
    public boolean isExperienceFieldsContainsText(String fieldText) {
        return driver.findElement(By.xpath("//label[contains(text())='Title']")).getText().contains(fieldText);
    }


//    public void clickAndSendInputBox(String title, String company, String startDate, String endDate) {
//
//        int amountOfTitle = 0;
//
//        for (WebElement titleTextElement : titleTextElements) {
//
//            amountOfTitle++;
//            System.out.println(" TitleElements= " + titleTextElement.getText());
//
//        }
//        System.out.println("amountOfTitle = " + amountOfTitle);
//
//        actions.scrollToElement(experienceText).keyDown(Keys.PAGE_DOWN).perform();
//        if (deleteButton.isDisplayed()) {
//            waitFor(2);
//
//            for (int i = 0; i < amountOfTitle; i++) {
//                deleteButton.click();
//            }
//            driver.findElement(By.xpath("//*[contains(.,'" + title + "')]//..//input")).click();
//            waitFor(2);
//            driver.findElement(By.xpath("//*[contains(.,'" + title + "')]//..//input")).sendKeys(title);
//
//            driver.findElement(By.xpath("//*[contains(.,'" + company + "')]//..//input")).click();
//            waitFor(2);
//            driver.findElement(By.xpath("//*[contains(.,'" + company + "')]//..//input")).sendKeys(company);
//
//            driver.findElement(By.xpath("//*[contains(.,'" + startDate + "')]//..//input")).click();
//            waitFor(2);
//            driver.findElement(By.xpath("//*[contains(.,'" + startDate + "')]//..//input")).sendKeys(startDate);
//
//            driver.findElement(By.xpath("//*[contains(.,'" + endDate + "')]//..//input")).click();
//            waitFor(2);
//            driver.findElement(By.xpath("//*[contains(.,'" + endDate + "')]//..//input")).sendKeys(endDate);
//
//
//        }
//    }




}