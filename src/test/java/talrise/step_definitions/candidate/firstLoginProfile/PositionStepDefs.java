package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class PositionStepDefs extends CommonSteps {

    public String randomPositionTitle;
    public String addedOptionTitle;

    @Then("verifies * icon is visible upon Position")
    public void verifiesIconIsVisibleUponPosition() {
        assertTrue(positionPage.positionHeader.getText().contains("*"));
    }

    @And("types {string} in the Position Search Box")
    public void typesInThePositionSearchBox(String position) {
        profileSectionPage.searchBox.sendKeys(position);
        waitFor(2);
    }

    @When("clicks on a position inside the Suggested Positions list")
    public void clicksOnAPositionInsideTheSuggestedPositionsList() {
       randomPositionTitle = profileSectionPage.clickAndGetTitleFromSuggestedList();
       waitFor(2);
    }

    @Then("verifies the selected position is no longer visible inside the list")
    public void verifiesTheSelectedPositionIsNoLongerVisibleInsideTheList() {
        for (WebElement w : profileSectionPage.suggestedList){
            assertNotEquals(randomPositionTitle,w.getText());
        }
    }

    @Then("verifies the selected position is visible under the page")
    public void verifiesTheSelectedPositionIsVisibleUnderThePage() {
        boolean foundMatch = false;

        for (WebElement w : profileSectionPage.selectedList) {
            if (randomPositionTitle.equals(w.getText())) {
                assertEquals(randomPositionTitle, w.getText());
                foundMatch = true;
                break; // Exit the loop once a match is found
            }
        }

    }

    @And("deletes the added position")
    public void deletesTheAdded() {
        addedOptionTitle = profileSectionPage.deleteAndGetTitleFromSelectedList();
    }


    @Then("verifies the deleted position is no longer visible under the page")
    public void verifiesTheDeletedPositionIsNoLongerVisibleUnderThePage() {
        //hic bir position eklenmediyse list bos olacak??

    }

    @Then("verifies the deleted positions is seen inside the Suggested Position list")
    public void verifiesTheDeletedPositionsIsSeenInsideTheSuggestedPositionList() {
        List<String> suggestedPositionTitles = new ArrayList<>();
        for (WebElement w : profileSectionPage.suggestedList){
            suggestedPositionTitles.add(w.getText());
        }
        assertTrue(suggestedPositionTitles.contains(addedOptionTitle));
    }
}
