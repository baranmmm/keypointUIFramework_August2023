package talrise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonPageElements{


    @FindBy(xpath = "//button[text()='SIGN UP']")
    public WebElement signUp;

    @FindBy(xpath="//input[@name='firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath="//input[@name='linkedIn']")
    public WebElement linkedinBox;

    @FindBy(xpath="//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath="//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath="//input[@name='confirmPassword']")
    public WebElement confirmPasswordBox;

    @FindBy(xpath="//input[@name='checkbox']")
    public WebElement registerCheckBox;

    @FindBy(xpath = "//span[text()='CREATE MY ACCOUNT']")
    public WebElement createNewAcountButton;

    @FindBy(xpath = "//div[text()='Registered successfully!']")
    public WebElement resgisteredSuccAlertMessage;

    @FindBy(xpath = "(//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-v7esy'])[1]")
    public WebElement firstNameNegativeEmpty;

    @FindBy(xpath = "(//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained MuiFormHelperText-filled css-v7esy'])[1]")
    public WebElement firstNameNegative2;

    @FindBy(xpath = "(//div[@role='alert']/div)[2]")
    public WebElement alertNegative;

    @FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorSecondary Mui-focused MuiInputBase-formControl css-7srjgk']")
    public WebElement popupNegative;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw'])[1]")
    public WebElement eyeIcon;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement activeEyeIcon;

    @FindBy(xpath = "//p[@class='MuiFormHelperText-root Mui-error css-j7o63n']")
    public WebElement privacyText;







}
