package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;

import java.util.Random;

import static org.junit.Assert.*;

public class PositionStepDefs extends CommonSteps {

    Random random = new Random();
    public String randomPositionTitle;

    @Then("verifies * icon is visible upon Position")
    public void verifiesIconIsVisibleUponPosition() {
        assertTrue(positionPage.positionHeader.getText().contains("*"));
    }

    @And("types {string} in the Position Search Box")
    public void typesInThePositionSearchBox(String position) {
        profileSectionPage.searchBox.sendKeys(position);
        waitFor(2);
    }

    @When("clicks on a {string} position inside the Suggested Positions list")
    public void clicksOnAPositionInsideTheSuggestedPositionsList(String position) {
       int randomPositionIndex = random.nextInt(positionPage.suggestedList.size());
       WebElement randomPosition = positionPage.suggestedList.get(randomPositionIndex);
        randomPositionTitle = randomPosition.getText();
        randomPosition.click();
       waitFor(2);
    }

    @Then("verifies the selected position is no longer visible inside the list")
    public void verifiesTheSelectedPositionIsNoLongerVisibleInsideTheList() {
        for (WebElement w : positionPage.suggestedList){
            assertNotEquals(randomPositionTitle,w.getText());
        }
    }

    @Then("verifies the selected position is visible under the page")
    public void verifiesTheSelectedPositionIsVisibleUnderThePage() {
        boolean foundMatch = false;

        for (WebElement w : positionPage.selectedOptionList) {
            if (randomPositionTitle.equals(w.getText())) {
                assertEquals(randomPositionTitle, w.getText());
                foundMatch = true;
                break; // Exit the loop once a match is found
            }
        }


    }
}
