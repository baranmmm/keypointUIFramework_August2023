package talrise.step_definitions.superadmin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static talrise.pages.PageInitializer.superAdminCandidateProcessPage;
import static talrise.utilities.CommonSteps.waitFor;

public class SuperAdminCandidateProcessStepDefs {
    @Given("user clicks on Activity then Candidate Process button at sidebar")
    public void user_clicks_on_activity_then_candidate_process_button_at_sidebar() {
        waitFor(3);
        superAdminCandidateProcessPage.ActivityButton.click();
        waitFor(1);
        superAdminCandidateProcessPage.CandidateProcessButton.click();
        waitFor(1);
    }
    @Then("verify the Browse applicants list title is visible")
    public void verifyTheElementIsVisible() {
        assertTrue(superAdminCandidateProcessPage.BrowseApplicantsListTitle.isDisplayed());
    }
    @Then("verify the column of {string} is visible")
    public void verifyTheElementIsVisible(String columnHeader) {
        assertEquals(columnHeader, superAdminCandidateProcessPage.getTableColumnHeader(columnHeader));
    }
}
