package talrise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import talrise.utilities.CommonSteps;
import talrise.utilities.ConfigurationReader;

public class RegisterStepDefs extends CommonSteps {

    @Given("The user goes to talrise homepage")
    public void theUserGoesToTalriseHomepage() {
        driver.get(ConfigurationReader.get("environmentUrl"));
    }

    @When("the user clicks SIGN UP button")
    public void theUserClicksSIGNUPButton() {

        registerPage.signUp.click();
    }

    @And("the user enters valid {string},{string},{string},{string},{string}")
    public void theUserEntersValid(String firstName, String lasttName, String linkedin, String email, String password) {
        registerPage.firstName.sendKeys(firstName,Keys.TAB,lasttName,Keys.TAB,linkedin,Keys.TAB,email,Keys.TAB,password,Keys.TAB,Keys.TAB,password);
    }

    @And("the user clicks on button that {string}")
    public void theUserClicksOnButtonThat(String arg0) {
        registerPage.registerCheckBox.click();
    }


    @And("the clicks on button that {string}")
    public void theClicksOnButtonThat(String arg0) {
        clickWithJS(registerPage.createNewAcountButton);
        //registerPage.createNewAcountButton.click();
    }

    @Then("the user should be able to see Registered successfully! message")
    public void theUserShouldBeAbleToSeeRegisteredSuccessfullyMessage() {
        waitForVisibility(registerPage.resgisteredSucc,10);
        Assert.assertEquals("Registered successfully!",registerPage.resgisteredSucc.getText());
    }

    @And("the user enters empty {string},{string},{string},{string},{string}")
    public void theUserEntersEmpty(String firstName, String lasttName, String linkedin, String email, String password) {
        registerPage.firstName.sendKeys(firstName,Keys.TAB,lasttName,Keys.TAB,linkedin,Keys.TAB,email,Keys.TAB,password,Keys.TAB,Keys.TAB,password);
    }


    @And("the user enters invalid {string},{string},{string},{string},{string}")
    public void theUserEntersInvalid(String firstName, String lasttName, String linkedin, String email, String password) {

        registerPage.firstName.sendKeys(firstName,Keys.TAB,lasttName,Keys.TAB,linkedin,Keys.TAB,email,Keys.TAB,password,Keys.TAB,Keys.TAB,password);

    }
    @Then("the user should be able to see {string} message")
    public void theUserShouldBeAbleToSeeMessage(String message) {
        registerPage.createNewAcountButton.click();
        Assert.assertEquals(message,registerPage.firstNameNegative2.getText());
    }

    @Then("the user should be able to see {string} messages")
    public void theUserShouldBeAbleToSeeMessages(String message) {

        registerPage.createNewAcountButton.click();

        Assert.assertEquals(message,registerPage.firstNameNegativeEmpty.getText());



    }


    @Then("the user should be able to see alert {string} message")
    public void theUserShouldBeAbleToSeeAlertMessage(String message) {
        registerPage.createNewAcountButton.click();
        waitFor(1);
        Assert.assertEquals(message,registerPage.alertNegative.getText());
    }

    @Then("the user should be able to see popup {string} message")
    public void theUserShouldBeAbleToSeePopupMessage(String message) {
        registerPage.createNewAcountButton.click();
        Assert.assertTrue(registerPage.popupNegative.isDisplayed());
    }

    @And("the user enters valid {string},{string},{string},{string},{string},{string}")
    public void theUserEntersValid(String firstName, String lastName, String linkedin, String email, String password, String confirmPassword) {
        registerPage.firstName.sendKeys(firstName,Keys.TAB,lastName,Keys.TAB,linkedin,Keys.TAB,email,Keys.TAB,password,Keys.TAB,Keys.TAB,confirmPassword);

    }

    @And("the user enters invalid {string},{string},{string},{string},{string},{string}")
    public void theUserEntersInvalid(String firstName, String lastName, String linkedin, String email, String password, String confirmPassword) {
        registerPage.firstName.sendKeys(firstName,Keys.TAB,lastName,Keys.TAB,linkedin,Keys.TAB,email,Keys.TAB,password,Keys.TAB,Keys.TAB,confirmPassword);

    }

    @And("the user enters empty {string},{string},{string},{string},{string},{string}")
    public void theUserEntersEmpty(String firstName, String lastName, String linkedin, String email, String password, String confirmPassword) {
        registerPage.firstName.sendKeys(firstName,Keys.TAB,lastName,Keys.TAB,linkedin,Keys.TAB,email,Keys.TAB,password,Keys.TAB,Keys.TAB,confirmPassword);
    }


    @And("The user clicks eye icon")
    public void theUserClicksEyeIcon() {

        waitFor(2);
        registerPage.eyeIcon.click();
    }

    @And("The user enter password")
    public void theUserEnterPassword() {

        registerPage.passwordField.sendKeys("Test1234!");
    }



    @Then("The user should be able to see visibility of password")
    public void theUserShouldBeAbleToSeeVisibilityOfPassword() {
        Assert.assertTrue(registerPage.activeEyeIcon.isDisplayed());
    }


    @When("The user clicks checkBox")
    public void theUserClicksCheckBox() {
        registerPage.checkBox.click();
    }

    @And("The user should be able to select check box")
    public void theUserShouldBeAbleToSelectCheckBox() {
        Assert.assertTrue(registerPage.checkBox.isSelected());
    }

    @And("The user deselect checkBox")
    public void theUserDeselectCheckBox() {
        registerPage.checkBox.click();
    }

    @And("The user clicks create my account")
    public void theUserClicksCreateMyAccount() {
        registerPage.createNewAcountButton.click();
    }

    @Then("When the user diselect check box , {string} is seen")
    public void whenTheUserDiselectCheckBoxIsSeen(String message) {

        Assert.assertEquals(message,registerPage.privacyText.getText());

    }


}
