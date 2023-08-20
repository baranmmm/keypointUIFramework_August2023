package talrise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPageElements{

    @FindBy(id = "email")
    public WebElement emailTxtbox;

    @FindBy(id = "password")
    public WebElement passwordTxtbox;

    @FindBy(css = "[type=\"submit\"]")
    public WebElement loginBtn;

}
