package talrise.pages.candidate.firstLoginProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class ProfileSectionPage extends CommonPageElements {

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
