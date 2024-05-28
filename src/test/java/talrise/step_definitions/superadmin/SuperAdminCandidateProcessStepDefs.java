package talrise.step_definitions.superadmin;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import static talrise.utilities.CommonSteps.*;
import static talrise.utilities.Driver.driver;

public class SuperAdminCandidateProcessStepDefs {
    @Given("user clicks on Activity then Candidate Process button at sidebar")
    public void user_clicks_on_activity_then_candidate_process_button_at_sidebar() {
        waitFor(3);
        superAdminCandidateProcessPage.ActivityButton.click();
        waitFor(1);
        superAdminCandidateProcessPage.CandidateProcessButton.click();
        waitFor(1);
    }
}
