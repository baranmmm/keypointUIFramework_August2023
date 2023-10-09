package talrise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import talrise.utilities.CommonSteps;
import talrise.utilities.ConfigurationReader;

public class LoginStepDefs extends CommonSteps {

    @Given("the user provides valid credentials")
    public void theUserProvidesValidCredentials() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.emailTxtbox.sendKeys(ConfigurationReader.get("email"));
        loginPage.passwordTxtbox.sendKeys(ConfigurationReader.get("password"));
    }

    @When("the user clicks on login button")
    public void theUserClicksOnLoginButton() {
        waitForClickability(loginPage.loginBtn,10);
        loginPage.loginBtn.click();
    }

    @Then("the user should be able to logged in successfully")
    public void theUserShouldBeAbleToLoggedInSuccessfully() {
        String expectedUrl= "http://20.77.188.234/dashboard";
        waitFor(2);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Given("the user enters invalid {string},{string}")
    public void the_user_enters_invalid(String Email, String Password) {
        driver.get(ConfigurationReader.get("url"));
        loginPage.emailTxtbox.sendKeys(Email, Keys.TAB,Password);
    }

    @Then("the user should see {string}")
    public void the_user_should_see(String message) {
        Assert.assertEquals(message, loginPage.getElement(message).getText());
    }

    @Then("the user should see {string} message")
    public void theUserShouldSeeMessage(String message) {
        CommonSteps.waitFor(2);
        Assert.assertEquals(message, loginPage.usernameOrPasswordNotCorrectMessage.getText());
    }

    @Then("the user should see {string} text in the email box")
    public void theUserShouldSeeTextInTheEmailBox(String emailText) {
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(emailText, loginPage.emailTextInTheBox.getText());
    }

    @Then("the user should see {string} text in the password box")
    public void theUserShouldSeeTextInThePasswordBox(String passwordText) {
        Assert.assertEquals(passwordText, loginPage.passwordTextInTheBox.getText());
    }

    @Then("the user should see {string} text")
    public void theUserShouldSeeText(String text) {
        driver.get(ConfigurationReader.get("url"));
        Assert.assertTrue(loginPage.NeedAnAccount.getText().contains(text));
    }

    @When("user clicks Forgot Password link")
    public void userClicksForgotPasswordLink() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.forgotPassword.click();
    }

    @Then("user should navigate to forgot-password page")
    public void userShouldNavigateToForgotPasswordPage() {
        String URL = driver.getCurrentUrl();
        waitFor(2);
        Assert.assertEquals(URL, "http://20.77.188.234/forgot-password");
    }

    @Then("user should see {string} text")
    public void userShouldSeeText(String msj) {
        driver.get(ConfigurationReader.get("url"));
        Assert.assertTrue(loginPage.forgotPassword.getText().contains(msj));
        boolean forgotPasswordDisplayed = loginPage.forgotPassword.isDisplayed();
        Assert.assertTrue(forgotPasswordDisplayed);
    }

    @When("the user clicks SIGN UP link")
    public void theUserClicksSIGNUPLink() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.signUpButton.click();
    }

    @Then("the user should navigate to Sign Up page")
    public void theUserShouldNavigateToSignUpPage() {
        String signUpURL=driver.getCurrentUrl();
        waitFor(2);
        Assert.assertEquals(signUpURL, "http://20.77.188.234/register");
    }

    @Then("the user should see SIGN UP message")
    public void theUserShouldSeeSIGNUPMessage() {
        driver.get(ConfigurationReader.get("url"));
        boolean signUpVisible = loginPage.signUpButton.isDisplayed();
        Assert.assertTrue(signUpVisible);
    }

    @Then("the user should see an eye icon in the password textbox")
    public void theUserShouldSeeAnEyeIconInThePasswordTextbox() {
        driver.get(ConfigurationReader.get("url"));
        boolean eyeIcon = loginPage.eyeIcon.isDisplayed();
        Assert.assertTrue(eyeIcon);
    }

    @When("the user clicks on password")
    public void theUserClicksOnPassword() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.passwordTxtbox.click();
    }

    @And("the user enters {string}")
    public void theUserEnters(String sifre) {
        loginPage.passwordTxtbox.sendKeys(sifre);
    }

    @And("the user clicks the eye icon in the password box")
    public void theUserClicksTheEyeIconInThePasswordBox() {
        loginPage.eyeIcon.click();
    }

    @Then("the user should see {string} as the password")
    public void theUserShouldSeeAsThePassword(String sifre) {
        boolean sifreVisible = loginPage.passwordTxtbox.isDisplayed();
        Assert.assertTrue(sifreVisible);
        Assert.assertEquals(sifre, loginPage.passwordTxtbox.getAttribute("value") );
    }

}
