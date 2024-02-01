package talrise.step_definitions.candidate2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import talrise.utilities.CommonSteps;

import static org.junit.Assert.assertTrue;

public class ProfileCommonSteps extends CommonSteps {
    @And("the user clicks on {string} button on the left hand side menu")
    public void theUserClicksOnButtonOnTheLeftHandSideMenu(String section) {
        switch (section){
            case("Position"):
                profileSectionPage.profilePositionButton.click();
                break;
            case("Skill Set"):
                profileSectionPage.profileSkillSetButton.click();
                break;
            case("Language"):
                profileSectionPage.profileLanguageButton.click();
                break;
            case ("Experience"):
                profileSectionPage.profileExperienceButton.click();
                break;
            case("Preferences"):
                profileSectionPage.profilePreferencesButton.click();
                break;
            case("Industry"):
                profileSectionPage.profileIndustryButton.click();
                break;
            case("Education"):
                profileSectionPage.profileEducationButton.click();
                break;
        }

    }

    @And("clicks on {string} button")
    public void clicksOnButton(String button) {
        switch (button){
            case("NEXT"):
                profileSectionPage.nextButton.click();
                break;
            case("BACK"):
                profileSectionPage.backButton.click();
                break;
            case("EXIT"):
                profileSectionPage.exitButton.click();
                break;
    }
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
        driver.get("http://20.108.75.9/candidate/personal-info");
    }
}
