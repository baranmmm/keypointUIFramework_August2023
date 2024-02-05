package talrise.step_definitions.candidate.normalProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import talrise.utilities.CommonSteps;

public class LanguageStepDefs extends CommonSteps {
    int suggestedFieldsSize2;//Whileda sifirlama olmasin diye 2 olusturduk

    int savedBeforeSize;//onceden save edilenlerin size'ini aldik

    int selectedSize2;//Whileda sifirlama olmasin diye 2 olusturduk

    @When("Select all language field")
    public void selectAllLanguageField() {

        int suggestedFieldsSize=languagePage.languageSuggestedFields.size();
        savedBeforeSize =languagePage.languageSelectedFields.size();
        suggestedFieldsSize2=languagePage.languageSuggestedFields.size();

        while(suggestedFieldsSize>0){
            for (int i = 0; i <languagePage.languageSuggestedFields.size() ; i++) {
                clickWithJS(languagePage.languageSuggestedFields.get(i));
                suggestedFieldsSize--;
            }
        }
    }

    @Then("Verify that all language fields are displayed on the selected screen")
    public void verifyThatAllLanguageFieldsAreDisplayedOnTheSelectedScreen() {

        Assert.assertEquals(suggestedFieldsSize2,languagePage.languageSelectedFields.size()- savedBeforeSize);

    }

    @When("press the language cross button above all fields")
    public void pressTheLanguageCrossButtonAboveAllFields() {
        int selectedSize =languagePage.languageSelectedFields.size();
        selectedSize2 =languagePage.languageSelectedFields.size();

        while(selectedSize >0) {
            for (int i = 0; i <languagePage.languageSelectedFields.size() ; i++) {

                clickWithJS( languagePage.languageSelectedFields.get(i));
                selectedSize--;
            }
        }}




    @Then("Verify that you have retrieved all language fields")
    public void verifyThatYouHaveRetrievedAllLanguageFields() {

        Assert.assertEquals(selectedSize2,suggestedFieldsSize2+ savedBeforeSize);




    }

    @When("The user comes to Type to search  box area and write {string} in it \\(language)")
    public void theUserComesToTypeToSearchBoxAreaAndWriteInItLanguage(String arg0) {

        languagePage.languageTypeToSearchButton.sendKeys(arg0);



    }

    @Then("Verify that it retrieve all related data {string} about language fields")
    public void verifyThatItRetrieveAllRelatedDataAboutLanguageFields(String arg0) {


        for (int i = 0; i <languagePage.languageSuggestedFields.size() ; i++) {

            Assert.assertTrue(languagePage.languageSuggestedFields.get(i).getText().toUpperCase().contains(arg0.toUpperCase()));
        }

    }

    @Then("Verify that it retrieve empty data about language fields")
    public void verifyThatItRetrieveEmptyDataAboutLanguageFields() {

        Assert.assertEquals("",languagePage.languageEmptySuggestedFields.getText());

    }

    @When("The user select one of the language field")
    public void theUserSelectOneOfTheLanguageField() {

        if (languagePage.languageSuggestedFields.size()==0){

            clickWithJS(languagePage.languageSelectedFields.get(0));

        }
        languagePage.languageSuggestedFields.get(0).click();


    }



    @And("The user clicks save button")
    public void theUserClicksSaveButton() {
        waitFor(3);
        clickWithJS(languagePage.languageSaveButton);
        savedBeforeSize=languagePage.languageSelectedFields.size();
    }

    @Then("The user see  alert {string}")
    public void theUserSeeAlert(String arg0) {
        waitForVisibility(languagePage.languageAlertMessage,10);
        Assert.assertEquals(arg0,languagePage.languageAlertMessage.getText());

    }

    @And("The user change  proficiency")
    public void theUserChangeProficiency() {
        languagePage.languageProficienciesBoxes.get(0).click();
        clickWithJS(languagePage.languageProficienciesFields.get(1));
        waitFor(2);
        clickWithJS(languagePage.languageSaveButton);
    }

    @Then("The user see after saved proficiency")
    public void theUserSeeAfterSavedProficiency() {
        waitForVisibility(languagePage.languageAlertMessage,10);
        String messages="Your language data has been submitted successfully.";
        Assert.assertEquals(messages,languagePage.languageAlertMessage.getText());



    }

    @And("The user select one of the proficiency")
    public void theUserSelectOneOfTheProficiency() {

        languagePage.languageProficienciesBoxes.get(0).click();
        clickWithJS(languagePage.languageProficienciesFields.get(4));
    }

    @And("The user click language CANCEL button")
    public void theUserClickLanguageCANCELButton() {
        clickWithJS(languagePage.languageCancelButton);

    }

    @Then("the user should see until language saved fields")
    public void theUserShouldSeeUntilLanguageSavedFields() {



        Assert.assertEquals(savedBeforeSize,languagePage.languageSelectedFields.size());

    }

    @And("the user clicks on <{string}> button")
    public void theUserClicksOnButton(String modules) {

        waitFor(2);
        clickWithJS(languagePage.moduls(modules));

    }
}
