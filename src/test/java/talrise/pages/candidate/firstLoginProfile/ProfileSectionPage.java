package talrise.pages.candidate.firstLoginProfile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

import java.util.List;

public class ProfileSectionPage extends CommonPageElements {

    @FindBy(xpath = "//div[@class='navigate']")
    public WebElement talriseLogo;

    @FindBy(xpath ="//*[contains(@class,'Toastify__toast-body')]")
    public WebElement alertMessage;

    @FindBy(name = "searchText")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class = 'sc-gmPhUn ebnDlO']//button") public List<WebElement> suggestedList;

    @FindBy(xpath = "//div[@class='sc-hRJfrW dIHHed']//button") public List<WebElement> selectedOptionList;



}
