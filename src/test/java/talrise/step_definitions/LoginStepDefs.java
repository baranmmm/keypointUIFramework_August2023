package talrise.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        String expectedUrl= "http://azure.talrise.com/dashboard";
        waitFor(2);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
