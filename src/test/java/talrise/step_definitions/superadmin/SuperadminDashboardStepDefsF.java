package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import talrise.utilities.CommonSteps;

import static org.junit.Assert.assertTrue;

public class SuperadminDashboardStepDefsF extends CommonSteps {
    Integer totalPostedJobs;

    @Then("verify the Status Role is visible")
    public void verifyTheStatusRoleIsVisible() {
        assertTrue(superadminDashboardPage.profileStatusRole.isDisplayed());
    }

    @And("verify the Profile Name is visible")
    public void verifyTheProfileNameIsVisible() {
        assertTrue(superadminDashboardPage.profileNameBtn.isDisplayed());
    }

    @Given("the user clicks on the profile name")
    public void theUserClicksOnTheProfileName() {
        superadminDashboardPage.profileNameBtn.click();
    }

    @Then("verify the Log Out is visible")
    public void verifyTheLogOutIsVisible() {
        assertTrue(superadminDashboardPage.logoutBtn.isDisplayed());
    }

    @And("verify the Log Out items is clickable")
    public void verifyTheLogOutItemsIsClickable() {
        assertTrue(superadminDashboardPage.logoutBtn.isEnabled());
    }

    @Then("verify the {string} is visible")
    public void verifyTheIsVisible(String title) {
        assertTrue(superadminDashboardPage.dashboardLabel.isDisplayed());
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
        superadminDashboardPage.clickButton("NEXT");
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
        assertTrue(superadminDashboardPage.browseApplicationListLabel.isDisplayed());
    }

    @Then("Verify the {string} is visible")
    public void VerifyTheIsVisible(String columnName) {
        Assert.assertEquals(columnName, superadminDashboardPage.getDashboardPageBrowseApplicationListColumnName(columnName));
    }

    @When("user clicks on the three dots \\(under the candidate info)")
    public void user_clicks_on_the_three_dots_under_the_candidate_info() {
        superadminDashboardPage.threeDotUnderCandidateInfo.click();
        waitFor(4);
    }

    @Then("user verifies that the relevant {string} page opened")
    public void user_verifies_that_the_relevant_page_opened(String candidateInfo) {
        Assert.assertEquals(candidateInfo, superadminDashboardPage.contactDetailsPage.getText());
    }

    @When("user clicks on the three dots \\(under the job details)")
    public void user_clicks_on_the_three_dots_under_the_job_details() {
        superadminDashboardPage.threeDotUnderJobDetails.click();
    }

    @Then("user verifies that the relevant {string} page has been opened")
    public void user_verifies_that_the_relevant_job_details_page_has_been_opened(String jobDetails) {
        Assert.assertEquals(jobDetails, superadminDashboardPage.jobDetailsPage.getText());
    }

    @When("user clicks on the rows")
    public void click_on_the_rows() {
        waitFor(1);
        scrollToElement(superadminDashboardPage.rowsDropDown);
        superadminDashboardPage.rowsDropDown.click();
    }

    @When("user selects {int}")
    public void select(Integer rowsValue) {
        superadminDashboardPage.getRowsValue(rowsValue);
        waitFor(1);
        // waitForVisibility(superadminDashboardPage.rowsDropDownGetText,2);
    }

    @Then("verify the size is {string}")
    public void verify_the_size_is(String txt) {
        Assert.assertEquals(txt, superadminDashboardPage.rowsDropDownGetText.getText());
    }

    @When("user clicks on the {string}")
    public void clicks_on_the_next_page(String page) {
        superadminDashboardPage.getChangePage(page);
        waitFor(4);
    }

    @Then("user verify page size is bigger than {int} \\({int}-{int} )")
    public void verify_page_size_is_bigger_than(Integer pageNumber, Integer int2, Integer int3) {
        int newPageNumber = pageNumber + 1;
        String newPageNumberString = String.valueOf(newPageNumber);
        Assert.assertTrue(superadminDashboardPage.currentPage.getText().contains(newPageNumberString));
    }

    @Then("user verify the {string} \\(>) is not clickable")
    public void user_verify_the_is_not_clickable(String page) {
        Assert.assertFalse(superadminDashboardPage.nextPageButton.isSelected());
    }

    @Then("user verify the page size is {string}")
    public void user_verify_the_page_size_is(String page) {
        Assert.assertTrue(superadminDashboardPage.currentPage.getText().contains(page));
    }

    @Given("user clicks on the {string} button")
    public void user_clicks_on_the_button(String buttonName) {
        superadminDashboardPage.clickButton(buttonName);
    }

    @Then("user verify that relevant page open")
    public void user_verify_that_relevant_page_open() {
        Assert.assertEquals("http://20.108.75.9/jobs", driver.getCurrentUrl());
    }
}
