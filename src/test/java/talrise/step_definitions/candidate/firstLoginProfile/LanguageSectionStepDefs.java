package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import talrise.utilities.CommonSteps;
import static org.junit.Assert.assertTrue;

public class LanguageSectionStepDefs extends CommonSteps {

    int firstDropdownNumber;
    int secondDropdownNumber;

    @And("the candidate clicks on {string} button on the left-hand side menu")
    public void theCandidateClicksOnButtonOnTheLeftHandSideMenu(String section) {
        profileSectionPage.goToLeftMenuOption(section);
    }

    @Then("the candidate should see {string} under the Language header")
    public void theCandidateShouldSeeUnderTheLanguageHeader(String expectedText) {
        String request = firstLoginLanguagePage.languageRequestK.getText();
        waitFor(1);
        Assert.assertEquals(expectedText, request);
        waitFor(1);
    }

    @And("the candidate removes the selected options to type German in the searchbar")
    public void theCandidateRemovesTheSelectedOptionsToTypeGermanInTheSearchbar() {
        firstLoginLanguagePage.selectedEnglishOptionK.click();

    }

    @When("the candidate searches for {string} in the language search bar")
    public void theCandidateSearchesForInTheLanguageSearchBar(String search) {
        sendText(firstLoginLanguagePage.languageSearchBarK, search);
        waitFor(1);

    }


    @And("the candidate selects German from the search results")
    public void theCandidateSelectsGermanFromTheSearchResults() {
        waitFor(1);
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
        waitFor(1);
        firstDropdownNumber = firstLoginLanguagePage.proficiencyLabelK.size();
        firstLoginLanguagePage.selectedGermanLanguageK.click();
    }

    @Then("the candidate verifies that {string} and its proficiency dropdown are no longer visible")
    public void theCandidateVerifiesThatAndItsProficiencyDropdownAreNoLongerVisible(String landpro) {
        secondDropdownNumber = firstLoginLanguagePage.proficiencyLabelK.size();
        waitFor(1);
        Assert.assertTrue(secondDropdownNumber < firstDropdownNumber);
    }

    @And("the candidate clicks on three language options step by step")
    public void theCandidateClicksOnThreeLanguageOptionsStepByStep() {
        firstLoginLanguagePage.languageSearchBarK.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        waitFor(1);
        firstLoginLanguagePage.selectedTurkishOptionK.click();
        waitFor(1);
        firstLoginLanguagePage.selectedGermanLanguageK.click();
        waitFor(1);
        firstLoginLanguagePage.englishOptionK.click();
        waitFor(1);

    }

    @Then("verifies visibility of the selected options")
    public void verifiesVisibilityOfTheSelectedOptions() {
        firstLoginLanguagePage.selectedTurkishOptionK.isDisplayed();
        waitFor(1);
        firstLoginLanguagePage.selectedGermanLanguageK.isDisplayed();
        waitFor(1);
        firstLoginLanguagePage.englishOptionK.isDisplayed();
        waitFor(1);
    }

    @And("the candidate removes all the language options by clicking on them")
    public void theCandidateRemovesAllTheLanguageOptionsByClickingOnThem() {
        waitFor(1);
        firstLoginLanguagePage.selectedTurkishOptionK.click();
        waitFor(1);
        firstLoginLanguagePage.selectedGermanLanguageK.click();
        waitFor(1);
        firstLoginLanguagePage.englishOptionK.click();
        waitFor(1);
    }

    @And("the candidate types {string} in the language search bar")
    public void theCandidateTypesInTheLanguageSearchBar(String language) {
        firstLoginLanguagePage.languageSearchBarK.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        firstLoginLanguagePage.languageSearchBarK.sendKeys(language);
        waitFor(1);
    }

    @And("the candidate selects the language from the search results")
    public void theCandidateSelectsTheLanguageFromTheSearchResults() {

        clickWithActions(firstLoginLanguagePage.selectedEnglishOptionK);
        waitFor(1);

    }


    @And("clicks on the Next button to complete the action")
    public void clicksOnTheNextButtonToCompleteTheAction() {
        clickWithActions(firstLoginLanguagePage.nextButtonK);

    }

    @Then("a success message {string} should be displayed")
    public void aSuccessMessageShouldBeDisplayed(String message) {
        waitForVisibility(profileSectionPage.alertMessage, 1);
        assertTrue(profileSectionPage.alertMessage.getText().contains(message));
        waitFor(2);

    }

    @And("clicks on Exit button")
    public void clicksOnExitButton() {

        firstLoginLanguagePage.ExitButtonK.click();
    }

    @When("the candidate clicks on the selected language option")
    public void theCandidateClicksOnTheSelectedLanguageOption() {
        if (firstLoginLanguagePage.frenchButtonTextK.isDisplayed()) {
            firstLoginLanguagePage.frenchButtonTextK.click();
            waitFor(1);
        } else if (firstLoginLanguagePage.selectedEnglishOptionK.isDisplayed()) {
            firstLoginLanguagePage.selectedEnglishOptionK.click();
            waitFor(1);
        } else {
            System.out.println("No selected language to remove.");
        }
    }
    @When("the candidate types {string} in the search bar")
    public void theCandidateTypesInTheSearchBar(String irrelevantType) {
        firstLoginLanguagePage.frenchOptionK.click();
        sendText(firstLoginLanguagePage.languageSearchBarK, irrelevantType);
    }

    @Then("verifies that the suggested Languages under the search bar disappear")
    public void verifiesThatTheSuggestedLanguagesUnderTheSearchBarDisappear() {

        int selectedLanguagesSize = firstLoginLanguagePage.allSelectedLanguagesWithProficienciesK.size();
        System.out.println("selectedLanguageSize = " + selectedLanguagesSize);
        while (selectedLanguagesSize > 0) {
            for (int i = 0; i < selectedLanguagesSize; i++) {
                waitFor(2);
                clickWithJS(firstLoginLanguagePage.allSelectedLanguagesWithProficienciesK.get(i));
                selectedLanguagesSize--;
            }

        }

    }



}
