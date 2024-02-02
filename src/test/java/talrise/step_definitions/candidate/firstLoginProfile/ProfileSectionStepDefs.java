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
//        switch (button){
//            case("NEXT"):
//                profileSectionPage.nextButton.click();
//                break;
//            case("BACK"):
//                profileSectionPage.backButton.click();
//                break;
//            case("EXIT"):
//                profileSectionPage.exitButton.click();
//                break;
//    }
}

    @Then("verifies landing on {string} page")
    public void verifiesLandingOnPage(String page) {
        String url = driver.getCurrentUrl();
        assertTrue(url.contains(page.toLowerCase()));

    }

    @Then("verifies {string} alert is seen")
    public void verifiesAlertIsSeen(String message) {
        if(message.contains("successfully")){
            assertTrue(profileSectionPage.successAlert.getText().contains(message));
        }else{
            assertTrue(profileSectionPage.warningChooseAlert.getText().contains(message));
        }
    }

    @And("navigates to Profile Sections page")
    public void navigatesToProfileSectionsPage() {
        driver.get(ConfigurationReader.get("firstLoginUrl"));
    }

    @Given("user goes to Home Page")
    public void userGoesToHomePage() {
        driver.get(ConfigurationReader.get("firstLoginUrl"));
    }
}
