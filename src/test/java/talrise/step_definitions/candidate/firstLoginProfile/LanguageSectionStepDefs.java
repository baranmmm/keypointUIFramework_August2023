package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import talrise.pages.CommonPageElements;
import talrise.pages.candidate.firstLoginProfile.FirstLoginLanguagePage;
import talrise.utilities.CommonSteps;

import static org.junit.Assert.assertTrue;

public class LanguageSectionStepDefs extends CommonSteps {

    int firstDropdownNumber;
    @And("the candidate clicks on {string} button on the left-hand side menu")
    public void theCandidateClicksOnButtonOnTheLeftHandSideMenu(String section) {
        waitFor(2);
        profileSectionPage.goToLeftMenuOption(section);
    }

    @Then("the candidate should see {string} under the Language header")
    public void theCandidateShouldSeeUnderTheLanguageHeader(String expectedText) {

        Assert.assertEquals(expectedText, firstLoginLanguagePage.languageRequestK.getText());
        waitFor(2);
    }

    @When("the candidate searches for {string} in the language search bar")
    public void theCandidateSearchesForInTheLanguageSearchBar(String search) {
        waitFor(2);
        firstLoginLanguagePage.languageSearchBarK.sendKeys(search);
    }
    @And("the candidate selects German from the search results")
    public void theCandidateSelectsGermanFromTheSearchResults() {
        waitFor(2);
        firstLoginLanguagePage.germanLanguageOptionK.click();
    }

    @And("the candidate selects an option from the dropdown")
    public void theCandidateSelectsAnOptionFromTheDropdown() {
        waitFor(1);
        firstLoginLanguagePage.elementaryProficiencyOptionK.click();
        waitFor(1);
        firstLoginLanguagePage.proficiencyListK.get(1).click();


    }

    @And("the candidate clicks on the selected language German")
    public void theCandidateClicksOnTheSelectedLanguageGerman() {
        waitFor(2);
        firstDropdownNumber=firstLoginLanguagePage.proficiencyLabelK.size();
        firstLoginLanguagePage.selectedGermanLanguageK.click();
    }

    @Then("the candidate verifies that {string} and its proficiency dropdown are no longer visible")
    public void theCandidateVerifiesThatAndItsProficiencyDropdownAreNoLongerVisible(String landpro) {
        int secondDropdownNumber=firstLoginLanguagePage.proficiencyLabelK.size();
        waitFor(2);
        Assert.assertTrue(secondDropdownNumber<firstDropdownNumber);
    }

    @And("the candidate types {string} in the language search bar")
    public void theCandidateTypesInTheLanguageSearchBar(String language) {
        firstLoginLanguagePage.languageSearchBarK.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE );
        firstLoginLanguagePage.languageSearchBarK.sendKeys(language);
        waitFor(2);
    }

    @And("the candidate selects English from the search results")
    public void theCandidateSelectsEnglishFromTheSearchResults() {

        firstLoginLanguagePage.abletoselectandselectedEnglishOptionK.click();
        waitFor(2);
    }
    @Then("a proficiency dropdown should be displayed with the selected language")
    public void aProficiencyDropdownShouldBeDisplayedWithTheSelectedLanguage() {
        Assert.assertTrue(firstLoginLanguagePage.abletoselectandselectedEnglishOptionK.isDisplayed());
        waitFor(2);
    }

    @Then("a success message {string} should be displayed")
    public void aSuccessMessageShouldBeDisplayed(String message) {
        assertTrue(profileSectionPage.alertMessage.getText().contains(message));
        waitFor(2);
        //Assert.assertEquals(message, firstLoginLanguagePage.successAlert.getText());
    }

    @And("clicks on Exit button")
    public void clicksOnExitButton() {
        firstLoginLanguagePage.saveExitButtonK.click();
    }


//    @And("the candidate clicks on the selected language")
//    public void theCandidateClicksOnTheSelectedLanguage() {
//        firstLoginLanguagePage.abletoselectandselectedEnglishOptionK.click();
//    }
//
//    @Then("verifies the selected language is no longer visible on the page")
//    public void verifiesTheSelectedLanguageIsNoLongerVisibleOnThePage() {
//        Assert.assertFalse(firstLoginLanguagePage.selectedGermanLanguageWithProficiencyK.isDisplayed());
//    }
//
//    @When("the candidate types {string} in the search bar")
//    public void theCandidateTypesInTheSearchBar(String otherlanguage) {
//        firstLoginLanguagePage.languageSearchBarK.sendKeys(otherlanguage);
//
//    }
//
//    @Then("verifies that the suggested Languages under the search bar disappear")
//    public void verifiesThatTheSuggestedLanguagesUnderTheSearchBarDisappear() {
//        Assert.assertFalse(firstLoginLanguagePage.suggestedLanguagesWordK.isDisplayed());
//        //Assert.assertFalse(firstLoginLanguagePage.allSuggestedLanguages);
//    }


}


