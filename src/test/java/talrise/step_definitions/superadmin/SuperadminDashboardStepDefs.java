package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import talrise.utilities.CommonSteps;

public class SuperadminDashboardStepDefs extends CommonSteps {
    Integer totalApplications;


    @And("{string} number is retrieved")
    public void numberIsRetrieved(String topMenuItem) {
        String totalApplicationsString = superadminDashboardPage.getDashboardPageTopMenuItemInfo(topMenuItem);
        totalApplications = Integer.parseInt(totalApplicationsString);
    }
}
