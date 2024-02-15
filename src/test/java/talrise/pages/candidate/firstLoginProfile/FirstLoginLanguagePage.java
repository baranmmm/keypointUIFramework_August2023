package talrise.pages.candidate.firstLoginProfile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;
import org.openqa.selenium.By;

import java.util.List;


public class FirstLoginLanguagePage extends CommonPageElements {

    @FindBy(xpath = "//h2[text()='Language*']")
    public WebElement languageHeaderK;

    // @FindBy(xpath = "//span[text()='Please add all the languages you know.']")
    //  public WebElement languageRequest;
    @FindBy(xpath="//span[@class='sc-imWYAI dvnhrG sc-gFAWRd fwbxvL']")
    public WebElement languageRequestK;

    @FindBy(css = "input[name='searchText']")
    public WebElement languageSearchBarK;

    @FindBy(xpath="//span[text()='Suggested Languages']")
    public WebElement suggestedLanguagesWordK;

    @FindBy(xpath="//*[@class='sc-hRJfrW hzBipc']")
    public List<WebElement> suggestedLanguagesListK;

    @FindBy(xpath="(//button[@type='button'])[2]")
    public WebElement englishButtonK;

    @FindBy(xpath="(//button[@type='button'])[4]")
    public WebElement frenchButtonK;

    @FindBy(xpath="(//button[@type='button'])[5]")
    public WebElement germanButtonK;

    @FindBy(xpath="(//button[@type='button'])[6]")
    public WebElement tuskishButtonK;


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

    @FindBy(xpath="//li[text()=\'Limited working proficiency\']")
    public WebElement limitedWorkingProficienyK;

    @FindBy(xpath="//button[text()='English']")
    public WebElement abletoselectandselectedEnglishOptionK;

    @FindBy(xpath="//div[@class='sc-iHbSHJ ghlOOI']")
    public List<WebElement> allSelectedLanguagesWithProficienciesK;

    // @FindBy(xpath="//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']")
    //  public List<WebElement> allProficiencies;
    @FindBy(xpath="//ul[@role='listbox']//li")
    public List<WebElement> proficiencyListK;


    @FindBy(xpath = "//div[contains(text(),'Please choose at least one language')]")
    public WebElement warningMessageK;

    @FindBy(xpath = "//div[contains(text(),'Your language data has been submitted successfully')]")
    public WebElement successAlertK;

    @FindBy(xpath="//button[text()='Save & Exit']")
    public WebElement saveExitButtonK;

}
