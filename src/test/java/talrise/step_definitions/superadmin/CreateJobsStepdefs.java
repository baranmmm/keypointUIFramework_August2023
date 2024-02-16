package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import talrise.pages.superadmin.CreateJobsPages.CreateJobsPage;
import talrise.step_definitions.LoginStepDefs;
import talrise.utilities.CommonSteps;

import java.util.Random;

public class CreateJobsStepdefs extends CommonSteps {
    @Given("Super Admin logs in as {string}")
    public void superAdminLogsInAs(String role) throws Exception {
        LoginStepDefs loginStepDefs = new LoginStepDefs();
        loginStepDefs.theUserLogsInAs(role);
    }

    @And("Super Admin navigates {string} left menu option")
    public void superAdminNavigatesLeftMenuOption(String arg0) {
        waitFor(1);
        createJobsPage.ActivityButton.click();
    }

    @And("Super Admin on the {string} and {string} module")
    public void superAdminOnTheModule(String arg0, String arg1) {
        waitFor(1);
        createJobsPage.JobsButton.click();
        waitFor(1);
        createJobsPage.JobsCreateButton.click();
    }
    @Then("Super Admin chooses a company and clicks the {string} button to create a new job")
    public void superAdminChoosesACompanyAndClicksTheButtonToCreateANewJob(String arg0) {
        waitFor(1);
       int addButtonSize = createJobsPage.addButtons.size();
       Random random = new Random();
       int randomButton = random.nextInt(addButtonSize); // sinirladik, bu araliktaki int lerden sececek.
        createJobsPage.addButtons.get(randomButton).click();
        //kisaca asagidaki gibi yapabilirdik.
        //  createJobsPage.addButtons.get(new Random().nextInt(addButtonSize)).click();


    }

    @When("Super Admin should be able to see the Page Title as a {string}")
    public void superAdminShouldBeAbleToSeeThePageTitleAsA(String arg0) {

    }

    @And("Super Admin click {string} button")
    public void superAdminClickButton(String arg0) {
    }

    @And("Super Admin clicks {string} on the required fields")
    public void superAdminClicksOnTheRequiredFields(String arg0) {
    }

    @And("Super Admin writes {string} on the required fields")
    public void superAdminWritesOnTheRequiredFields(String arg0) {
    }

    @And("Super Admin clicks {string} and {string}Second Round Interview\" check boxes from Interview Process")
    public void superAdminClicksAndSecondRoundInterviewCheckBoxesFromInterviewProcess(String arg0, String arg1) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }

    @And("Super Admin clicks on {string} check box from Benefits")
    public void superAdminClicksOnCheckBoxFromBenefits(String arg0) {
    }

    @And("Super Admin clicks {string} and super admin should be able to see the section title")
    public void superAdminClicksAndSuperAdminShouldBeAbleToSeeTheSectionTitle(String arg0) {
    }

    @When("Super Admin clicks the {string} Super admin should see the {string}")
    public void superAdminClicksTheSuperAdminShouldSeeThe(String arg0, String arg1) {
    }

    @When("Super Admin clicks the Basics section icon")
    public void superAdminClicksTheBasicsSectionIcon() {
    }

    @And("Super Admin changed job title  as {string}")
    public void superAdminChangedJobTitleAs(String arg0) {
    }

    @And("Super Admin clicks on save button")
    public void superAdminClicksOnSaveButton() {
    }

    @Then("Super Admin should be able to see {string}")
    public void superAdminShouldBeAbleToSee(String arg0) {
    }

    @And("Super Admin clicks on Create button")
    public void superAdminClicksOnCreateButton() {
    }

    @Then("Super Admin should be able to see {string} message")
    public void superAdminShouldBeAbleToSeeMessage(String arg0) {
    }

    @And("Super Admin should see the {string} button")
    public void superAdminShouldSeeTheButton(String arg0) {
    }

    @And("Super Admin clicks {string}")
    public void superAdminClicks(String arg0) {
    }

    @Then("Super Admin should be on the {string} page")
    public void superAdminShouldBeOnThePage(String arg0) {
    }

    @And("Super Admin clicks and write on the search button Job Title and see the new job on the job list board")
    public void superAdminClicksAndWriteOnTheSearchButtonJobTitleAndSeeTheNewJobOnTheJobListBoard() {
    }

    @Then("Admin should see Job Details page")
    public void adminShouldSeeJobDetailsPage() {
    }


    @And("User clicks and select fills related dropdown fields in Basics")
    public void userClicksAndSelectFillsRelatedDropdownFieldsInBasics() {
        createJobsPage.positionName.sendKeys("QA Developer");

    }
}
