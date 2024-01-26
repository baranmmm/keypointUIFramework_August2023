package talrise.step_definitions.candidate;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;

import java.util.List;

public class PreferencesStepDefs extends CommonSteps {

    int deleteNumber;
    @Then("User should be see following fields")
    public void userShouldBeSeeFollowingFields() {
        scrollToElement(preferencesPage.preferencesAddButton);

         waitFor(3);
        Assert.assertTrue(preferencesPage.preferencesCountry.isDisplayed());
        Assert.assertTrue(preferencesPage.preferencesCity.isDisplayed());
        Assert.assertTrue(preferencesPage.preferencesWorkPlace.isDisplayed());
        Assert.assertTrue(preferencesPage.preferencesContractType.isDisplayed());
        Assert.assertTrue(preferencesPage.preferencesSalaryPreferences.isDisplayed());
        Assert.assertTrue(preferencesPage.preferencesMinExpectedAmount.isDisplayed());
        Assert.assertTrue(preferencesPage.preferencesCurrency.isDisplayed());
        Assert.assertTrue(preferencesPage.preferencesVisaStatus.isDisplayed());


    }
    @When("User clicks and select fills related dropdown fields")
    public void userClicksAndSelectFillsRelatedDropdownFields(DataTable dataTable) {
        deleteNumber=preferencesPage.preferencesAllDeletes.size();
        waitFor(2);


        //tüm workplaceleri silip sıfırdan doldurmak için while loop kullandık

        if (!(deleteNumber==0)) {

            while(deleteNumber>0){
                preferencesPage.deleteb.click();
                deleteNumber--;}

            waitFor(2);

            scrollToElement(preferencesPage.preferencesAddButton);

            //workplace bilgisi girilir
            List<String> preferencesDropBox = dataTable.column(0);
            List<String> preferencesDropBoxVariable = dataTable.column(1);

            for (int i = 0; i <preferencesDropBox.size(); i++) {

                waitFor(2);


                if(preferencesDropBox.get(i).equals("Minimum Expected Salary")){
                    actions.doubleClick(preferencesPage.preferencesMinExpectedAmount).perform();
                    preferencesPage.preferencesMinExpectedAmount.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
                    preferencesPage.preferencesMinExpectedAmount.sendKeys(preferencesDropBoxVariable.get(5));

                }else{
                    preferencesPage.DropDownBox(preferencesDropBox.get(i)).get(0).click();
                    waitFor(1);
                    preferencesPage.DropDownContext(preferencesDropBoxVariable.get(i)).click();
                    waitFor(1);
                    if (preferencesDropBox.get(i).equals("Workplace")){
                        waitFor(2);
                        doubleClickWithActions(preferencesPage.DropDownBox(preferencesDropBox.get(i)).get(0));
                    }
                }

            }
        }else{
            waitFor(2);

            scrollToElement(preferencesPage.preferencesAddButton);

            //workplace bilgisi girilir
            List<String> preferencesDropBox = dataTable.column(0);
            List<String> preferencesDropBoxVariable = dataTable.column(1);

            for (int i = 0; i <preferencesDropBox.size(); i++) {

                waitFor(2);


                if(preferencesDropBox.get(i).equals("Minimum Expected Salary")){
                    actions.doubleClick(preferencesPage.preferencesMinExpectedAmount).perform();
                    preferencesPage.preferencesMinExpectedAmount.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
                    preferencesPage.preferencesMinExpectedAmount.sendKeys(preferencesDropBoxVariable.get(5));

                }else{
                    preferencesPage.DropDownBox(preferencesDropBox.get(i)).get(0).click();
                    waitFor(1);
                    preferencesPage.DropDownContext(preferencesDropBoxVariable.get(i)).click();
                    waitFor(1);
                    if (preferencesDropBox.get(i).equals("Workplace")){
                        waitFor(2);
                        doubleClickWithActions(preferencesPage.DropDownBox(preferencesDropBox.get(i)).get(0));
                    }
                }

            }
        }}



    @And("User clicks save button")
    public void userClicksSaveButton() {
        preferencesPage.preferencesSaveButton.click();


    }

    @Then("The user should be able to see  {string} message in the alert section")
    public void theUserShouldBeAbleToSeeMessageInTheAlertSection(String arg0) {
        waitForVisibility(preferencesPage.preferencesSaveAlertMessage,10);
        Assert.assertTrue(preferencesPage.preferencesSaveAlertMessage.isDisplayed());

    }

    @When("User clicks minimum expected salary box and send {string} values")
    public void userClicksMinimumExpectedSalaryBoxAndSendValues(String str) {
        waitFor(1);
        actions.doubleClick(preferencesPage.preferencesMinExpectedAmount).perform();
        preferencesPage.preferencesMinExpectedAmount.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);

        waitFor(1);
        //scrollToElement(preferencesPage.preferencesMinExpectedAmount);
        preferencesPage.preferencesMinExpectedAmount.sendKeys(str);
        waitFor(1);
        clickWithJS(preferencesPage.preferencesSaveButton);
    }

    @Then("User should see warning {string} under the box")
    public void userShouldSeeWarningUnderTheBox(String arg0) {
        waitFor(2);
        Assert.assertEquals(arg0,preferencesPage.preferencesMinSalaryMessage.getText());

    }

    @When("User should  click the add button")
    public void userShouldClickTheAddButton() {
        waitFor(1);
        scrollToElement(preferencesPage.preferencesAddButton);
        waitFor(1);
        preferencesPage.preferencesAddButton.click();

    }

    @Then("User should see the country city and work place areas that open after clicking the button")
    public void userShouldSeeTheCountryCityAndWorkPlaceAreasThatOpenAfterClickingTheButton() {
        waitFor(2);
        List<WebElement> countries=preferencesPage.DropDownBox("Country");


        deleteNumber=preferencesPage.preferencesAllDeletes.size();
        Assert.assertEquals( preferencesPage.preferencesAllDeletes.size(),countries.size());
    }

    @And("User should fill in the country city and work place fields")
    public void userShouldFillInTheCountryCityAndWorkPlaceFields() {
    }

    @Then("User should see that the fields are filled")
    public void userShouldSeeThatTheFieldsAreFilled() {
    }

    @And("User should click delete")
    public void userShouldClickDelete() {
        deleteNumber=preferencesPage.preferencesAllDeletes.size();
        waitFor(2);
        preferencesPage.preferencesAllDeletes.get(deleteNumber-1).click();


    }

    @Then("User should see that the country city and work place fields are deleted after clicking delete")
    public void userShouldSeeThatTheCountryCityAndWorkPlaceFieldsAreDeletedAfterClickingDelete() {
        deleteNumber=preferencesPage.preferencesAllDeletes.size();
        List<WebElement> countriesBoxes=preferencesPage.DropDownBox("Country");
        int CountrySize=countriesBoxes.size();
        Assert.assertEquals(CountrySize,deleteNumber);
    }

    @And("User should click on the cancel button")
    public void userShouldClickOnTheCancelButton() {


    }

    @Then("User should see the last saved information")
    public void userShouldSeeTheLastSavedInformation() {
    }

    @When("User clicks workplace box and select  three options step by step")
    public void userClicksWorkplaceBoxAndSelectThreeOptionsstepbystep() {
        waitFor(2);
        scrollToElement(preferencesPage.preferencesWorkPlace);
        preferencesPage.deleteb.click();
        preferencesPage.preferencesWorkPlace.click();
        waitFor(1);
        preferencesPage.DropDownContext.get(0).click();
        waitFor(1);
        preferencesPage.DropDownContext.get(1).click();
        waitFor(1);
        preferencesPage.DropDownContext.get(2).click();
        waitFor(1);
        clickWithJS(preferencesPage.preferencesWorkPlace);




    }

    @Then("User should be able to see  selected three workplace options on the box")
    public void userShouldBeAbleToSeeSelectedThreeWorkplaceOptionsOnTheBox() {
        Assert.assertEquals(preferencesPage.preferencesWorkPlace.getText(),"Hybrid, Remote, Onsite");
    }



    @When("Test that {string} module is visible.")
    public void testThatModuleIsVisible(String modules) {

        waitFor(2);
        clickWithJS(profilePage.moduls(modules));
    }
    @And("the user on the homepage and user clicks to Profile button")
    public void theUserOnTheHomepageAndUserClicksToProfileButton() {
        waitFor(2);
        profilePage.profile.click();

    }
}
