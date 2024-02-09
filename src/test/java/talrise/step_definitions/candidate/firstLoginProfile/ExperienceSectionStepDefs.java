package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import talrise.pages.candidate.firstLoginProfile.FirstLoginExperiencePage;
import talrise.pages.candidate.firstLoginProfile.FirstLoginLanguagePage;
import talrise.utilities.CommonSteps;

public class ExperienceSectionStepDefs extends CommonSteps {


    @Then("the candidate sees {string} request, Title, Company checkboxes, Contract Type, Workplace, Start Date, End Date dropdowns, skill sets dropdown, currently working text, Text field, and ADD MORE EXPERIENCE button")
    public void theCandidateSeesRequestTitleCompanyCheckboxesContractTypeWorkplaceStartDateEndDateDropdownsSkillSetsDropdownCurrentlyWorkingTextTextFieldAndADDMOREEXPERIENCEButton(String request) {

        Assert.assertEquals(request, firstLoginExperiencePage.experienceRequestK.getText());
        Assert.assertTrue(firstLoginExperiencePage.titleCheckboxLabelK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.companyCheckboxLabelK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.contractTypeDropdownLabelK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.workplaceDropdownLabelK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.startDateDropdownLabelK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.endDateDropdownLabelK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.skillSetDropdownK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.currentlyWorkingCheckboxWordsK.isDisplayed());
        Assert.assertTrue(firstLoginExperiencePage.addMoreButtonK.isDisplayed());
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

        Assert.assertTrue(firstLoginExperiencePage.startDateWarningMessageK.isDisplayed());

        Assert.assertTrue(firstLoginExperiencePage.endDateWarningMessageK.isDisplayed());

        Assert.assertTrue(firstLoginExperiencePage.warningSkillSetMessageK.isDisplayed());
    }

    @Then("verifies {string} for the skillset dropdown")
    public void verifiesForTheSkillsetDropdown(String dropdown) {
        Assert.assertTrue(firstLoginExperiencePage.skillSetDropdownK.isDisplayed());
    }



//    @When("the candidate clicks on the currently working button")
//    public void theCandidateClicksOnTheCurrentlyWorkingButton() {
//        firstLoginExperiencePage.currentlyWorkingCheckbox.click();
//    }
//
//    @Then("verifies the End Date is not enabled and the Notice Period dropdown appears")
//    public void verifiesTheEndDateIsNotEnabledAndTheNoticePeriodDropdownAppears() {
//        Assert.assertFalse(firstLoginExperiencePage.endDateDropdown.isEnabled());
//    }
//
//    @And("verifies visibility of Notice Period options by clicking on it")
//    public void verifiesVisibilityOfNoticePeriodOptionsByClickingOnIt() {
//        Assert.assertTrue(firstLoginExperiencePage.noticePeriodDropdown.isDisplayed());
//    }
//
//    @When("the candidate clicks on the Next button without selecting an option from the Notice Period dropdown")
//    public void theCandidateClicksOnTheNextButtonWithoutSelectingAnOptionFromTheNoticePeriodDropdown() {
//        firstLoginExperiencePage.nextButton.click();
//    }
//
//    @Then("verifies {string} warning message is displayed")
//    public void verifiesWarningMessageIsDisplayed(String arg0) {
//        Assert.assertTrue(firstLoginExperiencePage.noticePeriodWarningMessage.isDisplayed());
//    }
//
//    @When("the candidate clicks on the Title and types {string}")
//    public void theCandidateClicksOnTheTitleAndTypes(String title) {
//        firstLoginExperiencePage.titleCheckbox.sendKeys(title);
//
//    }
//
//    @And("the candidate clicks on the Company and types {string}")
//    public void theCandidateClicksOnTheCompanyAndTypes(String company) {
//        firstLoginExperiencePage.titleCheckbox.sendKeys(company);
//    }
//
//    @And("the candidate clicks on the Start Date and types {string}")
//    public void theCandidateClicksOnTheStartDateAndTypes(String startDate) {
//        firstLoginExperiencePage.titleCheckbox.sendKeys(startDate);
//    }
//
//    @And("the candidate clicks on the End Date and types {string}")
//    public void theCandidateClicksOnTheEndDateAndTypes(String endDate) {
//        firstLoginExperiencePage.titleCheckbox.sendKeys(endDate);
//    }
//
//    @And("the candidate selects {string} from the Contract Type dropdown")
//    public void theCandidateSelectsFromTheContractTypeDropdown(String arg0) {
//
//    }
//
//    @And("the candidate selects {string} from the Workplace dropdown")
//    public void theCandidateSelectsFromTheWorkplaceDropdown(String arg0) {
//    }
//
//    @And("the candidate clicks on the skill sets button and selects {string}")
//    public void theCandidateClicksOnTheSkillSetsButtonAndSelects(String arg0) {
//    }
//
//    @And("after typing or selecting some options, verifies the visibility of the DELETE button")
//    public void afterTypingOrSelectingSomeOptionsVerifiesTheVisibilityOfTheDELETEButton() {
//    }
//
//    @And("clicks on the DELETE button to delete all entered data")
//    public void clicksOnTheDELETEButtonToDeleteAllEnteredData() {
//    }
//
//    @And("verifies that all data are cleared")
//    public void verifiesThatAllDataAreCleared() {
//    }

}
