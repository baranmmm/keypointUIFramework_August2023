package talrise.pages.candidate.firstLoginProfile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

import java.util.List;

public class FirstLoginPersonalInfoPage extends CommonPageElements {
    @FindBy(xpath = "//input[contains(@class,'readOnly')]") public List<WebElement> personalInfoReadOnlyFields;

    @FindBy(id = ":r0:-label") public WebElement firstNameLabel;

    @FindBy(id = ":r1:-label") public WebElement lastNameLabel;

    @FindBy(id = ":r2:-label") public WebElement linkedinLabel;

    @FindBy(id = ":r3:-label") public WebElement emailLabel;

    @FindBy(id = ":r4:") public WebElement mobile;

    @FindBy(xpath = "//p[contains(@class,'error')]") public WebElement mobileWarningMessage;

    @FindBy(css = "#menu-cityId") public WebElement cityBackDropDown;

}
