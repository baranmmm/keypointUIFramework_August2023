package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import talrise.utilities.CommonSteps;
import talrise.utilities.ConfigurationReader;

import static org.junit.Assert.assertTrue;

public class ProfileSectionStepDefs extends CommonSteps {
    @And("the user clicks on {string} button on the left hand side menu")
    public void theUserClicksOnButtonOnTheLeftHandSideMenu(String section) {
        profileSectionPage.getLeftMenuOptionElement(section).click();
    }

    @And("clicks on {string} button")
    public void clicksOnButton(String button) {
        profileSectionPage.clickOnButton(button);
        waitFor(2);
}

    @Then("verifies landing on {string} page")
    public void verifiesLandingOnPage(String page) {
        page = page.toLowerCase().replace(" ","-");
        assertTrue(driver.getCurrentUrl().contains(page));

    }

    @Then("verifies {string} alert is seen")
    public void verifiesAlertIsSeen(String message) {
        assertTrue(profileSectionPage.alertMessage.getText().contains(message));
        waitFor(4);

    }

    @And("navigates to Profile Sections page")
    public void navigatesToProfileSectionsPage() {
        driver.get(ConfigurationReader.get("firstLoginUrl"));
        waitFor(2);
    }

    @Given("user goes to Home Page")
    public void userGoesToHomePage() {
        driver.get(ConfigurationReader.get("firstLoginUrl"));
    }

    @And("navigates to {string} page")
    public void navigatesToPage(String page) {
        page = page.toLowerCase().replace(" ","-");
        driver.get(ConfigurationReader.get("firstLoginUrl")+page);
    }



}
