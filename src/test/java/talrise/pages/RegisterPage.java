package talrise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonPageElements{


    @FindBy(xpath = "//button[text()='SIGN UP']")
    public WebElement signUp;

    @FindBy(xpath="//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath="//input[@name='checkbox']")
    public WebElement registerCheckBox;

    @FindBy(xpath = "//span[text()='CREATE MY ACCOUNT']")
    public WebElement createNewAcountButton;

    @FindBy(xpath = "//div[text()='Registered successfully!']")
    public WebElement resgisteredSucc;

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

    @FindBy( xpath= "(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2'])[1]")
    public WebElement passwordField;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//p[@class='MuiFormHelperText-root Mui-error css-j7o63n']")
    public WebElement privacyText;







}
