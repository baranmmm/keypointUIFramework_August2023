package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import talrise.utilities.CommonSteps;

public class SuperadminDashboardStepDefsF extends CommonSteps {
    Integer totalPostedJobs;

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

    @Then("verify the {string} is visible")
    public void verifyTheIsVisible(String title) {
        superadminDashboardPage.dashboardLabel.isDisplayed();
    }

    @Then("verify the {string} title is visible")
    public void verifyTheTitleIsVisible(String title) {
        waitFor(1);
        Assert.assertEquals(title, superadminDashboardPage.getDashboardPageTopMenuItemName(title));
    }

    @Given("get the {string}")
    public void getThe(String title) {
        waitFor(1);
        String totalPostedJobsString = superadminDashboardPage.getDashboardPageTopMenuItemInfo(title);
        totalPostedJobs = Integer.parseInt(totalPostedJobsString);
        System.out.println("totalPostedJobs = " + totalPostedJobs);
    }

    @And("click on the {string}")
    public void clickOnThe(String module) {
        waitFor(1);
        superadminDashboardPage.goToLeftMenuOption(module);
    }

    @And("clicks on the {string} symbol")
    public void clickOnTheSymbol(String module) {
        waitFor(1);
        superadminDashboardPage.plusforCreatingJob.click();
        ;
    }

    @Given("enter the required information into the form")
    public void enter_the_required_information_into_the_form() {
        superadminDashboardPage.nextButtonForJobCreate.click();
        waitFor(3);
    }

    @Given("click on the create button")
    public void click_on_the_create_button() {

    }
    @Then("verify that {string} increased by {int}")
    public void verify_that_increased_by(String string, Integer int1) {

    }
}
