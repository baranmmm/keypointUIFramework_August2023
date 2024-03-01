package talrise.pages.candidate.firstLoginProfile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;
import org.openqa.selenium.By;

import java.util.List;


public class FirstLoginLanguagePage extends CommonPageElements {


    @FindBy(xpath="//span[@class='sc-imWYAI dvnhrG sc-gFAWRd fwbxvL']")
    public WebElement languageRequestK;

    @FindBy(css = "input[name='searchText']")
    public WebElement languageSearchBarK;

    @FindBy(xpath="//span[text()='Suggested Languages']")
    public WebElement suggestedLanguagesWordK;

    @FindBy(xpath="//*[@class='sc-hRJfrW hzBipc']")
    public List<WebElement> suggestedLanguagesListK;

    @FindBy(xpath="//button[text()='French']")
    public WebElement frenchButtonTextK;

   @FindBy(xpath="//button[normalize-space()='French']")
   public WebElement frenchOptionK;

    @FindBy(xpath="//button[normalize-space()='English']")
    public WebElement englishOptionK;

    @FindBy(xpath = "//button[text()='German']")
    public WebElement germanLanguageOptionK;

    @FindBy(xpath="(//button[text()='German'])")
    public WebElement selectedGermanLanguageK;

    @FindBy(xpath=":  //div[@label='Proficiency']")
    public List<WebElement> proficiencyDropdownK;

    @FindBy(xpath = "//label[@id='select-label-id']")
    public List<WebElement> proficiencyLabelK;

    @FindBy(xpath = "//div[text()='Elementary proficiency']")
    public WebElement elementaryProficiencyOptionK;

    @FindBy(xpath="//div[text()='Professional working proficiency']")
    public WebElement professionalProficiency;

    @FindBy(xpath="//button[text()='English']")
    public WebElement selectedEnglishOptionK;

    @FindBy(xpath="//button[text()='Turkish']")
    public WebElement selectedTurkishOptionK;

    @FindBy(xpath="//div[@class='sc-iHbSHJ ghlOOI']")
    public List<WebElement> allSelectedLanguagesWithProficienciesK;

    @FindBy(xpath="(//div[@label='Proficiency'])")
    public List<WebElement> allSelectedLanguagesWithProficienciesK2;

    @FindBy(xpath="//ul[@role='listbox']//li")
    public List<WebElement> proficiencyListK;

    @FindBy(xpath="//button[text()='Next']")
    public WebElement nextButtonK;

    @FindBy(xpath = "//div[contains(text(),'Please choose at least one language')]")
    public WebElement warningMessageK;

   @FindBy(xpath="//*[text()='Exit']")
    public WebElement ExitButtonK;
}
