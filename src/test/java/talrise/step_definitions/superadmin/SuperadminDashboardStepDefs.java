package talrise.step_definitions.superadmin;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import talrise.utilities.CommonSteps;
import talrise.utilities.Driver;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SuperadminDashboardStepDefs extends CommonSteps {
    Integer totalApplications;
    Integer totalPostedJobs;
    String email;
    String cellValue;
    String cellChangedValue;
    String cellChangedValue2;

    @And("{string} number is retrieved")
    public void numberIsRetrieved(String topMenuItem) {
        waitFor(1);
        String totalApplicationsString = superadminDashboardPage.getDashboardPageTopMenuItemInfo(topMenuItem);
        totalApplications = Integer.parseInt(totalApplicationsString);
    }

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
        waitFor(1);
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

    @When("user clicks on the {string} arrow button")
    public void clicks_on_the_next_page_arrow_button(String page) {
        superadminDashboardPage.changeTablePage(page);
        waitFor(1);
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

    @Given("the user clicks {string} link")
    public void the_user_clicks_link(String signUp) {
        registerPage.signUp.click();
    }

    @Given("the user get the {string}")
    public void the_user_get_the(String title) {
        waitFor(1);
        String registeredCandidatesString = superadminDashboardPage.getDashboardPageTopMenuItemInfo(title);
        System.out.println("registeredCandidatesString = " + registeredCandidatesString);
    }

    @Given("the User enters valid {string},{string},{string},{string}")
    public void the_user_enters_valid(String firstName, String lastName, String password, String confirmPassword) {
        registerPage.firstNameBox.sendKeys(firstName);
        registerPage.lastNameBox.sendKeys(lastName);
        registerPage.linkedinBox.sendKeys("https://linkedin.com/in/" + Faker.instance().name().firstName() + Faker.instance().name().lastName());
        Random random = new Random();
        int emailNum = random.nextInt(200);
        email = firstName + emailNum + "@yopmail.com";
        registerPage.emailBox.sendKeys(email);
        registerPage.passwordBox.sendKeys(password);
        registerPage.confirmPasswordBox.sendKeys(confirmPassword);
    }

    @Then("the user Confirm Email and registered candidates")
    public void the_user_confirm_email_and_registered_candidates() {
        driver.get("https://yopmail.com/en/");
        superadminDashboardPage.consentButtonForYopmail.click();
        superadminDashboardPage.inputYopmailEmail.sendKeys(email);
        superadminDashboardPage.enterYopmailButton.click();
        switchToFrame(superadminDashboardPage.iframeYopmailForVerify);
        superadminDashboardPage.verifyYopmailAddress.click();
    }

    @Then("the user verify that {string} increased by {int}")
    public void the_user_verify_that_increased_by(String string, Integer int1) {

    }

    @Given("the user clicks on the {string}")
    public void the_user_clicks_on_the(String leftMenuAct) {
        superadminDashboardPage.goToLeftMenuOption(leftMenuAct);
    }

    @Given("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String buttonName) {
        superadminDashboardPage.clickButton(buttonName);
    }

    @Given("the user clicks on the plus item of the second Job under the {string}")
    public void the_user_clicks_on_the_plus_item_of_the_second_job_under_the(String plusForApplyJob) {
        Random random = new Random();
        int selectJob = random.nextInt(superadminDashboardPage.plusForApplyJobList.size());
        System.out.println("selectJob = " + selectJob);
        superadminDashboardPage.plusForApplyJobList.get(selectJob).click();

    }

    @Then("the user clicks on the three dot item of the first Job under DETAILS")
    public void the_user_clicks_on_the_three_dot_item_of_the_first_job_under_DETAILS() {
        superadminDashboardPage.lastAppliedJob.click();
    }

    @Then("the user verify the {string} decreased {int}")
    public void the_user_verify_the_decreased(String string, Integer int1) {

    }

    @Then("the user verify the {string} increased {int}")
    public void the_user_verify_the_increased(String string, Integer int1) {

    }

    @When("the user clicks on {string} in {string}")
    public void the_user_clicks_on_in(String columnName,String columnNumber ) {
        waitFor(1);
        cellValue=superadminDashboardPage.getTableCellValue(columnNumber).getText();
        superadminDashboardPage.getTableColumnName(columnName).click();
    }
    @Then("the user verifies that the {string} is sorted ascending")
    public void the_user_verifies_that_the_is_sorted_ascending(String columnNumber) {
        waitFor(1);
        cellChangedValue = superadminDashboardPage.getTableCellValue(columnNumber).getText();
        System.out.println("cellChangedValue = " + cellChangedValue);
        Assert.assertNotEquals(cellValue, cellChangedValue);
    }
    @Then("the user verifies that the {string} is sorted descending")
    public void the_user_verifies_that_the_is_sorted_descending(String columnNumber) {
        waitFor(1);
        cellChangedValue2 = superadminDashboardPage.getTableCellValue(columnNumber).getText();
        System.out.println("cellChangedValue2 = " + cellChangedValue2);
        Assert.assertNotEquals(cellValue, cellChangedValue2);
    }
    @Then("the user verifies that the {string} is sorted descending by id")
    public void the_user_verifies_that_the_is_sorted_descending_by_id(String columnNumber) {
        waitFor(1);
        cellChangedValue = superadminDashboardPage.getTableCellValue(columnNumber).getText();
        System.out.println("cellChangedValue = " + cellChangedValue);
        Assert.assertNotEquals(cellValue, cellChangedValue);
    }


}
