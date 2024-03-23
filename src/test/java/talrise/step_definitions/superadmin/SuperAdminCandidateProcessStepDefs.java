package talrise.step_definitions.superadmin;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import static talrise.utilities.CommonSteps.*;
import static talrise.utilities.Driver.driver;

public class SuperAdminCandidateProcessStepDefs {
    @Given("user clicks on Activity then Candidate Process button at sidebar")
    public void user_clicks_on_activity_then_candidate_process_button_at_sidebar() {
        waitFor(3);
        //NO SUCH ELEMENT HANDLING-FIRST METHOD
        //DISADVANTAGE: IT CHECKS THE ELEMENT WITH IMPLICIT WAIT FOR 10 SECONDS. UNNECESSARILY TAKING LONG TIME
        /*
        if(superAdminCandidateProcessPage.ActivityButtonList.size()!=0){
            superAdminCandidateProcessPage.ActivityButtonList.get(0).click();
        }

        if(superAdminCandidateProcessPage.CandidateProcessButtonList.size()!=0){
            superAdminCandidateProcessPage.CandidateProcessButtonList.get(0).click();
        }
         */

        //NO SUCH ELEMENT HANDLING-SECOND METHOD
        //REQUIRES BY LOCATOR PARAMETER:
        By activityButtonLocator = By.xpath("//span[.='Activity']");
        By processButtonLocator = By.xpath("//span[.='Candidate Process']");

        if(isElementAvailableByLocator(activityButtonLocator)){
            driver.findElement(activityButtonLocator).click();
        }
        if(isElementAvailableByLocator(processButtonLocator)){
            driver.findElement(processButtonLocator).click();
        }
    }
}
