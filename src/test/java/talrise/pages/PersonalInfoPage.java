package talrise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonalInfoPage extends CommonPageElements{

    Random random = new Random();

    @FindBy(xpath ="//span[.=\"Profile\"]" )
    public WebElement profileSideMenu;

    @FindBy(xpath ="//span[@class=\"sc-jXbUNg esKOjA text-example\"]")
    public List<WebElement>menus;

    @FindBy(xpath ="//*[contains(@class,\"MuiAccordionSummary-content css-1n11r91\")]")
    public List<WebElement>profileMenuPenIcons;


    @FindBy(xpath ="(//div[@class=\"expandIconWrapper\"])[1]")
    public WebElement personalInfoPenIcon;

    @FindBy(xpath ="//span[.='Personal Information']")
    public WebElement personalInfoDropdown;

    @FindBy(xpath = "//h2[text()=\"Personal Information\"]")
    public WebElement personalInfoText;

    @FindBy(xpath ="(//div[@class=\"collapseIconWrapper\"])[1]")
    public WebElement personalInfoSideArrow;



    @FindBy(xpath = "//h2[.='Personal Information']//..//label[contains(@id,':-label')]")
    public List<WebElement> personalInfoInputLabels;


    @FindBy(xpath ="//label[.=\"Country\"]")
    public  WebElement countryDropdown;

    @FindBy(xpath ="//label[.=\"City\"]")
    public  WebElement city;

    @FindBy(xpath ="//label[.=\"Country Code\"]")
    public  WebElement countryCode;

    @FindBy(css ="[name=\"firstName\"]")
    public  WebElement firstName;

    @FindBy(css ="[name=\"lastName\"]")
    public  WebElement lastName;

    @FindBy(css = "[name=\"linkedIn\"]")
    public  WebElement linkedIn;

    @FindBy(css = "[name=\"email\"]")
    public  WebElement email;

    @FindBy(id=("countryId-select-input-id"))
    public WebElement countryInputBox;

    @FindBy(xpath ="//*[@id=\"menu-countryId\"]//li")
    public List<WebElement>countryDropdowns;

    @FindBy(id="cityId-select-input-id")
    public WebElement cityInput;

    @FindBy(xpath = "//em[.=\"None\"]")
    public WebElement noneOption;

    @FindBy(xpath = "//li[.=\"England\"]")
    public WebElement englandOption;



    @FindBy(xpath = "//li[.=\"Wales\"]")
    public WebElement walesOption;



    @FindBy(xpath = "//li[.=\"Northern Ireland\"]")
    public WebElement northernIrelandOption;



    @FindBy(xpath = "//li[.=\"Scotland\"]")
    public WebElement scotlandOption;

    @FindBy(xpath = "//li[.=\"UK\"]")
    public WebElement uKOption;

    List<WebElement> countries=Arrays.asList
            (englandOption,walesOption,northernIrelandOption,scotlandOption,uKOption);

    @FindBy(xpath = "//*[@id=\"menu-cityId\"]//li")
    public List<WebElement>cityDropdowns;


//all countries cities and none option include



    public List<WebElement> getCityDropdownsWithoutNone(List<WebElement> cityDropdowns) {
        List<WebElement> cityDropdownWithoutNone = new ArrayList<>();

        for (int i = 0; i < cityDropdowns.size(); i++) {
            if (i > 0) {
                cityDropdownWithoutNone.add(cityDropdowns.get(i));
            }
        }

        return cityDropdownWithoutNone;
    }




    public   List <WebElement> registeredInfo =Arrays.asList(firstName,lastName,linkedIn,email);

    @FindBy(id = "countryPhoneCode-select-input-id")
    public WebElement countryCodeDropdown;


    @FindBy(xpath = "//div[@id=\"menu-countryPhoneCode\"]//li")
    public List<WebElement> countryCodeDropdownOptions;


    @FindBy(name = "mobile")
  public WebElement mobileInputBox;

  @FindBy(id =":r7:-helper-text")
    public WebElement warningMessage;

    @FindBy(xpath = "(//button[@label='save'])[1]")
    public WebElement saveButton;

  @FindBy(xpath ="//*[contains(@class,'Toastify__toast-body')]")
    public WebElement successMessage;


  @FindBy(xpath ="//button[.='OVERVIEW']")
    public WebElement overviewButton;

    @FindBy(css="[data-value=\"+44\"]")
    public WebElement uKCountryCode;

    public WebElement getRandomCountry() {

        int randomCountry = random.nextInt(countries.size());
        return countries.get(randomCountry);

    }


    public WebElement getRandomData(List<WebElement> listOfWebElement) {

        int randomData = random.nextInt(listOfWebElement.size());
        return listOfWebElement.get(randomData);

    }




//    @FindBy(xpath = "(//button[@label='cancel'])[1]")
//    public WebElement canselButton;







}











