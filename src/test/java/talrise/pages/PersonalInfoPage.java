package talrise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class PersonalInfoPage extends CommonPageElements{

    @FindBy(xpath ="//span[.=\"Profile\"]" )
    public WebElement profileSideMenu;

    @FindBy(css = "[class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiAccordion-root MuiAccordion-rounded css-pcn5tp\"]")
    public List<WebElement>menus;

    @FindBy(css ="[class=\"MuiCollapse-root MuiCollapse-vertical MuiCollapse-hidden css-a0y2e3\"]")
    public List<WebElement>profileMenuPenIcons;

    @FindBy(xpath ="(//div[@class=\"expandIconWrapper\"])[1]")
    public WebElement personalInfoPenIcon;

    @FindBy(xpath ="//span[.='Personal Information']")
    public WebElement personalInfoDropdown;

    @FindBy(xpath = "//h2[text()=\"Personal Information\"]")
    public WebElement personalInfoText;

    @FindBy(xpath ="(//div[@class=\"collapseIconWrapper\"])[1]")
    public WebElement personalInfoSideArrow;

    @FindBy(css ="[class=\"MuiFormControl-root MuiTextField-root sc-kdBSHD fwoIiI css-i44wyl\"]")
    public List<WebElement> personalInfoInputs;

    @FindBy(xpath = "//h2[.='Personal Information']//..//label[contains(@id,':-label')]")
    public List<WebElement> personalInfoInputLabels;

    @FindBy(xpath ="")
    public List<WebElement> personalInfoInputDropdowns;

    @FindBy(xpath ="//label[.=\"Country\"]")
    public  WebElement countryDropdown;

    @FindBy(xpath ="//label[.=\"City\"]")
    public  WebElement city;

    @FindBy(xpath ="//label[.=\"Country Code\"]")
    public  WebElement countryCode;

    @FindBy(css ="input[id=':r3:']")
    public  WebElement firstName;

    @FindBy(css ="input[id=':r4:']")
    public  WebElement lastName;

    @FindBy(css = "input[id=':r5:']")
    public  WebElement linkedIn;

    @FindBy(css = "input[id=':r6:']")
    public  WebElement email;

    @FindBy(id = "countryId-select-input-id")
    public WebElement countryInputBox;

    @FindBy(css ="[class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-11oatdh\"]")
    public List<WebElement>countryDropdowns;

    @FindBy(id="cityId-select-input-id")
    public WebElement cityInput;

    @FindBy(xpath = "//li[.=\"None\"]")
    public WebElement noneOption;

    @FindBy(xpath = "//li[.=\"England\"]")
    public WebElement englandOption;

    @FindBy(css ="[class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-11oatdh\"]")
    public List<WebElement>cityOfEnglandDropdowns;

    @FindBy(xpath = "//li[.=\"Wales\"]")
    public WebElement walesOption;

    @FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]//li")
    public List<WebElement>cityOfWalesDropdowns;

    @FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiSelect-icon MuiSelect-iconOutlined css-1636szt\"])[1]")
    public WebElement countryDropDownArrow;

    @FindBy(xpath = "//li[.=\"Northern Ireland\"]")
    public WebElement northernIrelandOption;

    @FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]//li")
    public List<WebElement>cityOfNorthernIcelandDropdowns;

    @FindBy(xpath = "//li[.=\"Scotland\"]")
    public WebElement scotlandOption;

    @FindBy(xpath = "//li[.=\"UK\"]")
    public WebElement uKOption;

    @FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]//li")
    public List<WebElement>scotlandDropdowns;

    @FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]//li")
    public List<WebElement>uKDropdowns;

    public   List <WebElement> registeredInfo =Arrays.asList(firstName,lastName,linkedIn,email);













}











