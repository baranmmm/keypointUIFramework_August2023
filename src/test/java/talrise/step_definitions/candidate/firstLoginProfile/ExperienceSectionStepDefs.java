package talrise.step_definitions.candidate.firstLoginProfile;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talrise.pages.candidate.firstLoginProfile.FirstLoginExperiencePage;
import talrise.pages.candidate.firstLoginProfile.FirstLoginLanguagePage;
import talrise.utilities.CommonSteps;

public class ExperienceSectionStepDefs extends CommonSteps {

    String text;
    Faker faker;
    String text2;
    @Then("the candidate sees {string} request")
    public void theCandidateSeesRequest(String request) {
        Assert.assertEquals(request, firstLoginExperiencePage.experienceRequestK.getText());
    }
    @Then("the candidate sees {string} request, Title, Company checkboxes, Contract Type, Workplace, Start Date, End Date dropdowns, skill sets dropdown, currently working text, Text field, and ADD MORE EXPERIENCE button")
    public void theCandidateSeesRequestTitleCompanyCheckboxesContractTypeWorkplaceStartDateEndDateDropdownsSkillSetsDropdownCurrentlyWorkingTextTextFieldAndADDMOREEXPERIENCEButton(String request) {

        Assert.assertEquals(request, firstLoginExperiencePage.experienceRequestK.getText());

    }

    @And("the candidate clicks on the Next button without completing all the required fields")
    public void theCandidateClicksOnTheNextButtonWithoutCompletingAllTheRequiredFields() {
        clickWithJS(firstLoginExperiencePage.deleteButtonK);
        clickWithJS(firstLoginLanguagePage.nextButtonK);

    }

    @Then("verifies the warning messages for Title, Company, Start Date, End Date and Skill Set")
    public void verifiesTheWarningMessagesForTitleCompanyStartDateEndDateAndSkillSet() {

        String titleMessage= firstLoginExperiencePage.titleWarningMessageK.getText();
        Assert.assertEquals(titleMessage, "Please enter a title.");

        String companyMessage= firstLoginExperiencePage.companyWarningMessageK.getText();
        Assert.assertEquals(companyMessage, "Please enter a company name.");


        Assert.assertTrue(firstLoginExperiencePage.warningSkillSetMessageK.isDisplayed());
    }

    @When("the candidate clicks on the currently working button")
    public void theCandidateClicksOnTheCurrentlyWorkingButton() {
        firstLoginExperiencePage.currentlyWorkingCheckboxK.click();
    }

    @Then("verifies the End Date is not enabled and the Notice Period dropdown appears")
    public void verifiesTheEndDateIsNotEnabledAndTheNoticePeriodDropdownAppears() {
        Assert.assertFalse(firstLoginExperiencePage.endDateDropdownK.isEnabled());
    }

    @And("verifies visibility of Notice Period options by clicking on it")
    public void verifiesVisibilityOfNoticePeriodOptionsByClickingOnIt() {
        Assert.assertTrue(firstLoginExperiencePage.noticePeriodDropdownK.isDisplayed());
    }

//    @When("the candidate clicks on the Next button without selecting an option from the Notice Period dropdown")
//    public void theCandidateClicksOnTheNextButtonWithoutSelectingAnOptionFromTheNoticePeriodDropdown() {
//        clickWithJS(firstLoginExperiencePage.nextButtonK);
//        waitFor(1);
//    }
//
//    @Then("verifies {string} warning message is displayed")
//    public void verifiesWarningMessageIsDisplayed(String warnText) {
//
//        Assert.assertEquals(warnText, firstLoginExperiencePage.noticePeriodWarningMessageK.getText());
//    }

    @And("the candidate clicks on the currently working button to activate the end date dropdown")
    public void theCandidateClicksOnTheCurrentlyWorkingButtonToActivateTheEndDateDropdown() {
        doubleClickWithActions(firstLoginExperiencePage.selectedWorkingCheckboxK);

            waitFor(1);


    }


    @When("the candidate clicks on the Title and types {string}")
    public void theCandidateClicksOnTheTitleAndTypes(String title) {
       clickWithActions(firstLoginExperiencePage.titleCheckboxK);
        firstLoginExperiencePage.titleCheckboxK.sendKeys(title);
        waitFor(1);

    }

    @And("the candidate clicks on the Company and types {string}")
    public void theCandidateClicksOnTheCompanyAndTypes(String company) {
        firstLoginExperiencePage.companyCheckboxK.click();
        firstLoginExperiencePage.companyCheckboxK.sendKeys(company);
        waitFor(1);
    }

    @And("the candidate clicks on the Start Date and types {string}")
    public void theCandidateClicksOnTheStartDateAndTypes(String startDate) {
        firstLoginExperiencePage.startDateDropdownK.click();
        firstLoginExperiencePage.startDateDropdownK.sendKeys(startDate);
        waitFor(1);

    }

    @And("the candidate clicks on the End Date and types {string}")
    public void theCandidateClicksOnTheEndDateAndTypes(String endDate) throws InterruptedException {
        waitForClickability(firstLoginExperiencePage.endDateDropdownLabelK, 2);

        // Click on the end date dropdown and enter the date
        clickWithJS(firstLoginExperiencePage.endDateDropdownLabelK);
        Thread.sleep(3);
        firstLoginExperiencePage.emptyEndDateAfterClick.sendKeys(endDate);
        waitFor(1);
    }
    @And("the candidate clicks on the skill sets button and selects Tools")
    public void theCandidateClicksOnTheSkillSetsButtonAndSelectsTools() {

        firstLoginExperiencePage.skillSetDropdownK.click();
        waitFor(1);
        clickWithJS(firstLoginLanguagePage.proficiencyListK.get(1));
        waitFor(1);
        //firstLoginExperiencePage.selectBack4app.click();
        clickWithActions(firstLoginExperiencePage.skillSetDropdownK);
        waitFor(1);
    }

    @And("the candidate clicks on the Add More Experience button to see the additional fields")
    public void theCandidateClicksOnTheAddMoreExperienceButtonToSeeTheAdditionalFields() {
        firstLoginExperiencePage.addMoreButtonK.click();
        waitFor(1);
    }

    @Then("verifies the additional experience {string}")
    public void verifiesTheAdditionalExperience(String fieldsName) {

        Assert.assertTrue(firstLoginExperiencePage.additionalTitle.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.additionalCompany.isDisplayed());
    }



    @And("after typing or selecting some options, verifies the visibility of the DELETE button")
    public void afterTypingOrSelectingSomeOptionsVerifiesTheVisibilityOfTheDELETEButton() {
        Assert.assertTrue(firstLoginExperiencePage.deleteButton2.isDisplayed());
        waitFor(1);
    }

    @And("clicks on the DELETE button to delete all entered data")
    public void clicksOnTheDELETEButtonToDeleteAllEnteredData() {
        firstLoginExperiencePage.deleteButton2.click();
        waitFor(1);
    }

//    @When("the candidate clicks on the Add More Experience button while the mandatory fileds are not filled")
//    public void theCandidateClicksOnTheAddMoreExperienceButtonWhileTheMandatoryFiledsAreNotFilled() {
//    }
//
//    @Then("verifies the warning messages {string}, {string} , {string} , {string} , {string}")
//    public void verifiesTheWarningMessages(String arg0, String arg1, String arg2, String arg3, String arg4) {
//    }
//
//    @When("the candidate clicks on the Title to type {string}")
//    public void theCandidateClicksOnTheTitleToType(String arg0) {
//    }
//
//    @And("the candidate clicks on the Company to type {string}")
//    public void theCandidateClicksOnTheCompanyToType(String arg0) {
//    }
//
//    @And("the candidate clicks on the Start Date to type {string}")
//    public void theCandidateClicksOnTheStartDateToType(String arg0) {
//    }
//
//    @And("the candidate clicks on the End Date to type {string}")
//    public void theCandidateClicksOnTheEndDateToType(String arg0) {
//    }
//
//    @And("the candidate clicks on the skillsets button to selects Tools")
//    public void theCandidateClicksOnTheSkillsetsButtonToSelectsTools() {
//    }
//
//    @And("clicks on the add more experience button to see the additional fields")
//    public void clicksOnTheAddMoreExperienceButtonToSeeTheAdditionalFields() {
//    }
//
//    @Then("verifies the additional experience fields are visible")
//    public void verifiesTheAdditionalExperienceFieldsAreVisible() {
//    }
//
//    @When("The candidate clicks on the Workplace dropdown")
//    public void theCandidateClicksOnTheWorkplaceDropdown() {
//    }
//
//    @And("The candidate selects the one option from the Workplace dropdown")
//    public void theCandidateSelectsTheOneOptionFromTheWorkplaceDropdown() {
//    }
//
//    @Then("The candidate verifies all the Workplace dropdown options")
//    public void theCandidateVerifiesAllTheWorkplaceDropdownOptions() {
//    }
//
//    @When("The candidate selects the {string} option from the Workplace dropdown")
//    public void theCandidateSelectsTheOptionFromTheWorkplaceDropdown(String arg0) {
//    }
//
//    @Then("The candidate verifies that the Workplace dropdown is empty")
//    public void theCandidateVerifiesThatTheWorkplaceDropdownIsEmpty() {
//    }
//
//    @When("The candidate clicks on the Contract Type dropdown")
//    public void theCandidateClicksOnTheContractTypeDropdown() {
//    }
//
//    @And("The candidate selects one option from the Contract Type dropdown")
//    public void theCandidateSelectsOneOptionFromTheContractTypeDropdown() {
//    }
//
//    @Then("The candidate verifies all the Contract Type dropdown's options")
//    public void theCandidateVerifiesAllTheContractTypeDropdownSOptions() {
//    }
//
//    @When("The candidate clicks on the {string} textbox to add more information")
//    public void theCandidateClicksOnTheTextboxToAddMoreInformation(String arg0) {
//    }
//
//    @And("The candidate types that {string} in there")
//    public void theCandidateTypesThatInThere(String arg0) {
//    }
//
//    @Then("Verifies that {string} in the textbox")
//    public void verifiesThatInTheTextbox(String arg0) {
//    }
//
//    @When("The candidate clicks on the {string} textbox to type max characters in there")
//    public void theCandidateClicksOnTheTextboxToTypeMaxCharactersInThere(String arg0) {
//    }
//
//    @And("The candidate types {int} characters in this textbox")
//    public void theCandidateTypesCharactersInThisTextbox(int arg0) {
//    }
//
//    @Then("Verifies that {int} characters are in the textbox")
//    public void verifiesThatCharactersAreInTheTextbox(int arg0) {
//    }
//
//    @When("The candidate clicks on the {string} textbox to type more than max character in there")
//    public void theCandidateClicksOnTheTextboxToTypeMoreThanMaxCharacterInThere(String arg0) {
//    }
//
//    @And("The candidate types {int} characters as more than max character")
//    public void theCandidateTypesCharactersAsMoreThanMaxCharacter(int arg0) {
//    }
//
//    @Then("Verifies that {int} characters can not be seen in the textbox")
//    public void verifiesThatCharactersCanNotBeSeenInTheTextbox(int arg0) {
//    }




}
