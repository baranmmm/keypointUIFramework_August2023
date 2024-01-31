package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import talrise.utilities.CommonSteps;

public class SuperadminDashboardStepDefsF extends CommonSteps {

    @Then("verify the Status Role is visible")
    public void verifyTheStatusRoleIsVisible() {
        superadminDashboardPage.profileStatusRole.isDisplayed();
    }

    @And("verify the Profile Name is visible")
    public void verifyTheProfileNameIsVisible() {
        superadminDashboardPage.profileNameBtn.isDisplayed();
    }

    @Given("the user clicks on the profile name")
    public void theUserClicksOnTheProfileName() {
        superadminDashboardPage.profileNameBtn.click();
    }

    @Then("verify the Log Out is visible")
    public void verifyTheLogOutIsVisible() {
        superadminDashboardPage.logoutBtn.isDisplayed();
    }

    @And("verify the Log Out items is clickable")
    public void verifyTheLogOutItemsIsClickable() {
        superadminDashboardPage.logoutBtn.isEnabled();
    }
}
