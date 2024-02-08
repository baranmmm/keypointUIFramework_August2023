package talrise.step_definitions.superadmin;

import io.cucumber.java.en.Given;
import talrise.pages.superadmin.SuperAdminCandidateProcessPage;

import static talrise.pages.PageInitializer.superAdminCandidateProcessPage;
import static talrise.utilities.CommonSteps.waitFor;

public class SuperAdminCandidateProcessStepDefs {
    @Given("user clicks on Activity then Candidate Process button at sidebar")
    public void user_clicks_on_activity_then_candidate_process_button_at_sidebar() {
        waitFor(2);
        superAdminCandidateProcessPage.ActivityButton.click();
        waitFor(2);
        superAdminCandidateProcessPage.CandidateProcessButton.click();
        waitFor(1);
    }
}
