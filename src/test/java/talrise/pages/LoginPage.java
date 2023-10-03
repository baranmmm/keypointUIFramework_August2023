package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.utilities.ConfigurationReader;

public class LoginPage extends CommonPageElements{

    @FindBy(id = "email")
    public WebElement emailTxtbox;

    @FindBy(id = "password")
    public WebElement passwordTxtbox;

    @FindBy(css = "[type=\"submit\"]")
    public WebElement loginBtn;

    @FindBy(xpath = "//div[text()='Username or password not correct']")
    public WebElement loginInValidAlertMessage;

    @FindBy(xpath = "//div[text()='Logged in successfully.']")
    public WebElement LoggedInSuccessfullyMessage;

    @FindBy(xpath = "//div[text()='Username or password not correct']")
    public WebElement usernameOrPasswordNotCorrectMessage;

    @FindBy(xpath = "//p[text()='Please enter a valid e-mail address.']")
    public WebElement pleaseEnterAvalidEmailAddressMessage;

    @FindBy(xpath = "//p[text()='Please enter your e-mail address.']")
    public WebElement pleaseEnterYourEmailAddressMessage;

    @FindBy(xpath = "//p[text()='Please enter your password.']")
    public WebElement pleaseEnterYourPasswordMessage;

    @FindBy(xpath = "//p[text()='Password must be at least 8 characters long.']")
    public WebElement paswordMustBeAtLeast8charactersLongMessage;

    public WebElement getElement(String message) {
        return driver.findElement(By.xpath("//p[text()='" + message + "']"));
    }

    @FindBy(xpath = "//label[text()='Email']")
    public WebElement emailTextInTheBox;

    @FindBy(xpath = "//label[text()='Password']")
    public WebElement passwordTextInTheBox;

    @FindBy(xpath = "//span[text()='Need An Account? ']")
    public WebElement NeedAnAccount;

    @FindBy(xpath = "//span[text()='Forgot password?']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//button[text()='SIGN UP']")
    public WebElement signUpButton;

    @FindBy(xpath = "//button[@aria-label='toggle password visibility']")
    public WebElement eyeIcon;

    public void login(){
        emailTxtbox.sendKeys(ConfigurationReader.get("email"));
        passwordTxtbox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

}
