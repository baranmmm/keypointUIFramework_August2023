package talrise.step_definitions.candidate.firstLoginProfile;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
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
        firstLoginExperiencePage.titleCheckboxK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        waitFor(1);
        firstLoginExperiencePage.companyCheckboxK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        firstLoginExperiencePage.contractTypeDropdownK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(0).click();
        firstLoginExperiencePage.workplaceDropdownK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(0).click();
        waitFor(1);
        firstLoginExperiencePage.filledStartDateDropdownK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        waitFor(1);

        firstLoginExperiencePage.filledEndDateDropdownK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        waitFor(1);

        firstLoginExperiencePage.selectedMLModelsK.click(); //previously saved option to clear it
        firstLoginExperiencePage.nextButtonK.click();

    }

    @Then("verifies the warning messages for Title, Company, Start Date, End Date and Skill Set")
    public void verifiesTheWarningMessagesForTitleCompanyStartDateEndDateAndSkillSet() {

        String titleMessage= firstLoginExperiencePage.titleWarningMessageK.getText();
        Assert.assertEquals(titleMessage, "Please enter a title.");

        String companyMessage= firstLoginExperiencePage.companyWarningMessageK.getText();
        Assert.assertEquals(companyMessage, "Please enter a company name.");

        String startDateMessage=firstLoginExperiencePage.startDateWarningMessageK.getText();
        Assert.assertEquals(startDateMessage, "Please enter the start date." );

        Assert.assertTrue(firstLoginExperiencePage.startDateWarningMessageK.isDisplayed());

        Assert.assertTrue(firstLoginExperiencePage.endDateWarningMessageK.isDisplayed());

        Assert.assertTrue(firstLoginExperiencePage.warningSkillSetMessageK.isDisplayed());
    }

    @Then("verifies {string} for the skillset dropdown")
    public void verifiesForTheSkillsetDropdown(String dropdown) {
        Assert.assertTrue(firstLoginExperiencePage.skillSetDropdownK.isDisplayed());
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

    @When("the candidate clicks on the Next button without selecting an option from the Notice Period dropdown")
    public void theCandidateClicksOnTheNextButtonWithoutSelectingAnOptionFromTheNoticePeriodDropdown() {
        firstLoginExperiencePage.nextButtonK.click();
    }

    @Then("verifies {string} warning message is displayed")
    public void verifiesWarningMessageIsDisplayed(String arg0) {
        Assert.assertTrue(firstLoginExperiencePage.noticePeriodWarningMessageK.isDisplayed());
    }

    @And("the candidate clicks on the currently working button to activate the end date dropdown")
    public void theCandidateClicksOnTheCurrentlyWorkingButtonToActivateTheEndDateDropdown() {
    }

    @Then("verifies activation of the end date dropdown")
    public void verifiesActivationOfTheEndDateDropdown() {
    }

    @When("the candidate clicks on the Title and types {string}")
    public void theCandidateClicksOnTheTitleAndTypes(String title) {
        firstLoginExperiencePage.titleCheckboxK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        waitFor(1);
        firstLoginExperiencePage.companyCheckboxK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        firstLoginExperiencePage.contractTypeDropdownK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(0).click();
        firstLoginExperiencePage.workplaceDropdownK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(0).click();
        waitFor(1);
        firstLoginExperiencePage.filledStartDateDropdownK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        waitFor(2);

        firstLoginExperiencePage.filledEndDateDropdownK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        waitFor(2);

        firstLoginExperiencePage.selectedMLModelsK.click(); //previously saved option to clear it




        firstLoginExperiencePage.titleCheckboxK.sendKeys(title, Keys.ENTER);

    }

    @And("the candidate clicks on the Company and types {string}")
    public void theCandidateClicksOnTheCompanyAndTypes(String company) {
        firstLoginExperiencePage.companyCheckboxK.sendKeys(company, Keys.ENTER);
    }

    @And("the candidate clicks on the Start Date and types {string}")
    public void theCandidateClicksOnTheStartDateAndTypes(String startDate) {
        doubleClickWithActions(firstLoginExperiencePage.currentlyWorkingCheckboxK);

        //firstLoginExperiencePage.currentlyWorkingCheckboxK.click();

        firstLoginExperiencePage.startDateDropdownK.sendKeys(startDate, Keys.ENTER);
    }

    @And("the candidate clicks on the End Date and types {string}")
    public void theCandidateClicksOnTheEndDateAndTypes(String endDate) {
        firstLoginExperiencePage.endDateDropdownK.sendKeys(endDate, Keys.ENTER);
    }

    @And("the candidate selects a ContractType option from the Contract Type dropdown")
    public void theCandidateSelectsAContractTypeOptionFromTheContractTypeDropdown() {


        firstLoginExperiencePage.contractTypeDropdownK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(1).click();


    }

    @And("the candidate selects a Workplace option from the Workplace dropdown")
    public void theCandidateSelectsAWorkplaceOptionFromTheWorkplaceDropdown() {


        firstLoginExperiencePage.workplaceDropdownK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(2).click();
        waitFor(1);
    }

    @And("the candidate clicks on the skill sets button and selects Tools")
    public void theCandidateClicksOnTheSkillSetsButtonAndSelectsTools() {

        firstLoginExperiencePage.skillSetDropdownK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(1).click();
        waitFor(1);
    }

    @And("the candidate clicks on the Add More Experience button to see the additional fields")
    public void theCandidateClicksOnTheAddMoreExperienceButtonToSeeTheAdditionalFields() {
    }

    @Then("verifies the additional experience fields")
    public void verifiesTheAdditionalExperienceFields() {
    }



    @And("after typing or selecting some options, verifies the visibility of the DELETE button")
    public void afterTypingOrSelectingSomeOptionsVerifiesTheVisibilityOfTheDELETEButton() {
    }

    @And("clicks on the DELETE button to delete all entered data")
    public void clicksOnTheDELETEButtonToDeleteAllEnteredData() {
    }

    @And("verifies that all data are cleared")
    public void verifiesThatAllDataAreCleared() {
    }


    @When("the candidate clicks on the Add More Experience button while the mandatory fileds are not filled")
    public void theCandidateClicksOnTheAddMoreExperienceButtonWhileTheMandatoryFiledsAreNotFilled() {
    }

    @Then("verifies the warning messages {string}, {string} , {string} , {string} , {string}")
    public void verifiesTheWarningMessages(String arg0, String arg1, String arg2, String arg3, String arg4) {
    }

    @When("the candidate clicks on the Title to type {string}")
    public void theCandidateClicksOnTheTitleToType(String arg0) {
    }

    @And("the candidate clicks on the Company to type {string}")
    public void theCandidateClicksOnTheCompanyToType(String arg0) {
    }

    @And("the candidate clicks on the Start Date to type {string}")
    public void theCandidateClicksOnTheStartDateToType(String arg0) {
    }

    @And("the candidate clicks on the End Date to type {string}")
    public void theCandidateClicksOnTheEndDateToType(String arg0) {
    }

    @And("the candidate clicks on the skillsets button to selects Tools")
    public void theCandidateClicksOnTheSkillsetsButtonToSelectsTools() {
    }

    @And("clicks on the add more experience button to see the additional fields")
    public void clicksOnTheAddMoreExperienceButtonToSeeTheAdditionalFields() {
    }

    @Then("verifies the additional experience fields are visible")
    public void verifiesTheAdditionalExperienceFieldsAreVisible() {
    }

    @When("The candidate clicks on the Workplace dropdown")
    public void theCandidateClicksOnTheWorkplaceDropdown() {
    }

    @And("The candidate selects the one option from the Workplace dropdown")
    public void theCandidateSelectsTheOneOptionFromTheWorkplaceDropdown() {
    }

    @Then("The candidate verifies all the Workplace dropdown options")
    public void theCandidateVerifiesAllTheWorkplaceDropdownOptions() {
    }

    @When("The candidate selects the {string} option from the Workplace dropdown")
    public void theCandidateSelectsTheOptionFromTheWorkplaceDropdown(String arg0) {
    }

    @Then("The candidate verifies that the Workplace dropdown is empty")
    public void theCandidateVerifiesThatTheWorkplaceDropdownIsEmpty() {
    }

    @When("The candidate clicks on the Contract Type dropdown")
    public void theCandidateClicksOnTheContractTypeDropdown() {
    }

    @And("The candidate selects one option from the Contract Type dropdown")
    public void theCandidateSelectsOneOptionFromTheContractTypeDropdown() {
    }

    @Then("The candidate verifies all the Contract Type dropdown's options")
    public void theCandidateVerifiesAllTheContractTypeDropdownSOptions() {
    }

    @When("The candidate clicks on the {string} textbox to add more information")
    public void theCandidateClicksOnTheTextboxToAddMoreInformation(String arg0) {
    }

    @And("The candidate types that {string} in there")
    public void theCandidateTypesThatInThere(String arg0) {
    }

    @Then("Verifies that {string} in the textbox")
    public void verifiesThatInTheTextbox(String arg0) {
    }

    @When("The candidate clicks on the {string} textbox to type max characters in there")
    public void theCandidateClicksOnTheTextboxToTypeMaxCharactersInThere(String arg0) {
    }

    @And("The candidate types {int} characters in this textbox")
    public void theCandidateTypesCharactersInThisTextbox(int arg0) {
    }

    @Then("Verifies that {int} characters are in the textbox")
    public void verifiesThatCharactersAreInTheTextbox(int arg0) {
    }

    @When("The candidate clicks on the {string} textbox to type more than max character in there")
    public void theCandidateClicksOnTheTextboxToTypeMoreThanMaxCharacterInThere(String arg0) {
    }

    @And("The candidate types {int} characters as more than max character")
    public void theCandidateTypesCharactersAsMoreThanMaxCharacter(int arg0) {
    }

    @Then("Verifies that {int} characters can not be seen in the textbox")
    public void verifiesThatCharactersCanNotBeSeenInTheTextbox(int arg0) {
    }




}
