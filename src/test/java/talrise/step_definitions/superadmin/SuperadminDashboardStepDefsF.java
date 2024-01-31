package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import talrise.utilities.CommonSteps;

public class SuperadminDashboardStepDefsF extends CommonSteps {
    Integer totalPostedJobs;

    @Then("verify the Status Role is visible")
    public void verifyTheStatusRoleIsVisible() {
        Assert.assertTrue(superadminDashboardPage.profileStatusRole.isDisplayed());
    }

    @And("verify the Profile Name is visible")
    public void verifyTheProfileNameIsVisible() {
        Assert.assertTrue(superadminDashboardPage.profileNameBtn.isDisplayed());
    }

    @Given("the user clicks on the profile name")
    public void theUserClicksOnTheProfileName() {
        superadminDashboardPage.profileNameBtn.click();
    }

    @Then("verify the Log Out is visible")
    public void verifyTheLogOutIsVisible() {
        Assert.assertTrue(superadminDashboardPage.logoutBtn.isDisplayed());
    }

    @And("verify the Log Out items is clickable")
    public void verifyTheLogOutItemsIsClickable() {
        Assert.assertTrue(superadminDashboardPage.logoutBtn.isEnabled());
    }

    @Then("verify the {string} is visible")
    public void verifyTheIsVisible(String title) {
        Assert.assertTrue(superadminDashboardPage.dashboardLabel.isDisplayed());
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

    @Then("verify the Browse applicants list is visible")
    public void verify_the_browse_applicants_list_is_visible() {
        Assert.assertTrue(superadminDashboardPage.browseApplicationListLabel.isDisplayed());
    }

    @Then("Verify the {string} is visible")
    public void VerifyTheIsVisible(String columnName) {
        Assert.assertEquals(columnName, superadminDashboardPage.getDashboardPageBrowseApplicationListColumnName(columnName));
    }

    @When("user clicks on the three dots \\(under the candidate info)")
    public void user_clicks_on_the_three_dots_under_the_candidate_info() {
        superadminDashboardPage.threeDotUnderJobDetails.click();
    }

    @Then("user verifies that the relevant {string} page has been opened")
    public void user_verifies_that_the_relevant_job_details_page_has_been_opened(String jobDetails) {
        Assert.assertEquals(jobDetails, superadminDashboardPage.jobDetailsPage.getText());
    }


}
