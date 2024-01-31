package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import talrise.utilities.CommonSteps;

import javax.swing.text.Utilities;

public class SuperadminDashboardStepDefs extends CommonSteps {
    Integer totalApplications;


    @And("{string} number is retrieved")
    public void numberIsRetrieved(String topMenuItem) {
        waitFor(1);
        String totalApplicationsString = superadminDashboardPage.getDashboardPageTopMenuItemInfo(topMenuItem);
        totalApplications = Integer.parseInt(totalApplicationsString);
        System.out.println("totalApplicationsString = " + totalApplicationsString);
    }
}
