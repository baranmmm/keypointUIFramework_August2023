package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> master
import java.util.Random;

import static org.junit.Assert.*;

public class PositionStepDefs extends CommonSteps {

<<<<<<< HEAD
    Random random = new Random();
    public String randomPositionTitle;
=======
    public String randomPositionTitle;
    public String addedOptionTitle;
>>>>>>> master

    @Then("verifies * icon is visible upon Position")
    public void verifiesIconIsVisibleUponPosition() {
        assertTrue(positionPage.positionHeader.getText().contains("*"));
    }

    @And("types {string} in the Position Search Box")
    public void typesInThePositionSearchBox(String position) {
        profileSectionPage.searchBox.sendKeys(position);
        waitFor(2);
    }

<<<<<<< HEAD
    @When("clicks on a {string} position inside the Suggested Positions list")
    public void clicksOnAPositionInsideTheSuggestedPositionsList(String position) {
       int randomPositionIndex = random.nextInt(positionPage.suggestedList.size());
       WebElement randomPosition = positionPage.suggestedList.get(randomPositionIndex);
        randomPositionTitle = randomPosition.getText();
        randomPosition.click();
=======
    @When("clicks on a position inside the Suggested Positions list")
    public void clicksOnAPositionInsideTheSuggestedPositionsList() {
       randomPositionTitle = profileSectionPage.clickAndGetTitleFromSuggestedList();
>>>>>>> master
       waitFor(2);
    }

    @Then("verifies the selected position is no longer visible inside the list")
    public void verifiesTheSelectedPositionIsNoLongerVisibleInsideTheList() {
<<<<<<< HEAD
        for (WebElement w : positionPage.suggestedList){
=======
        for (WebElement w : profileSectionPage.suggestedList){
>>>>>>> master
            assertNotEquals(randomPositionTitle,w.getText());
        }
    }

    @Then("verifies the selected position is visible under the page")
    public void verifiesTheSelectedPositionIsVisibleUnderThePage() {
        boolean foundMatch = false;

<<<<<<< HEAD
        for (WebElement w : positionPage.selectedOptionList) {
=======
        for (WebElement w : profileSectionPage.selectedList) {
>>>>>>> master
            if (randomPositionTitle.equals(w.getText())) {
                assertEquals(randomPositionTitle, w.getText());
                foundMatch = true;
                break; // Exit the loop once a match is found
            }
        }

<<<<<<< HEAD

    }
=======
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
>>>>>>> master
}
