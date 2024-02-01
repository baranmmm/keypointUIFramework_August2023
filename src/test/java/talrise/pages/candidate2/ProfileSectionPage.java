package talrise.pages.candidate2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileSectionPage {
    @FindBy(xpath="//span[text()='Language']")
    public WebElement profileLanguageButton;

    @FindBy(xpath="//span[text()='Experience']")
    public WebElement profileExperienceButton;

    @FindBy(xpath="//span[text()='Education']")
    public WebElement profileEducationButton;

    @FindBy(xpath="//span[text()='Preferences']")
    public WebElement profilePreferencesButton;

    @FindBy(xpath="//span[text()='Skill Set']")
    public WebElement profileSkillSetButton;

    @FindBy(xpath="//span[text()='Industry']")
    public WebElement profileIndustryButton;

    @FindBy(xpath="//span[text()='Position']")
    public WebElement profilePositionButton;

    @FindBy(xpath = "//div[@class='navigate']")
    public WebElement talriseLogo;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//button[text()='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//button[contains(text(),'Exit')]")
    public WebElement exitButton;

    @FindBy(xpath = "//div[contains(text(),'has been submitted successfully')]")
    public WebElement successAlert;

    @FindBy(xpath = "//div[contains(text(),'Please choose at least')]")
    public WebElement warningChooseAlert;

}
