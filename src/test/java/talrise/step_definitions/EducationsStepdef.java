package talrise.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import talrise.utilities.CommonSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EducationsStepdef extends CommonSteps {
    String certificate="";

    @When("Verify that {string} module is visible.")
    public void verifyThatModuleIsVisible(String modules) {

        waitFor(2);
        clickWithJS(profilePage.moduls(modules));
    }
    @Then("Test that education module is expanded after it's clicked on the pencil icon.")
    public void testThatEducationModuleIsExpandedAfterItSClickedOnThePencilIcon() {

        int profileModuleListSize = profilePage.profileModuleList.size();
        int pencilIconListSize = profilePage.moduleEditIconList.size();
        assertEquals(profileModuleListSize - 1, pencilIconListSize);
    }
    @When("user enters {string}, {string}, {string}, {string} fields")
    public void userEntersFields(String uni, String degree, String dep, String start) {
        if(uni.equals("")) {
            educationPage.UniversityButton.sendKeys(uni,Keys.ENTER);
            educationPage.DegreeButton.click();waitFor(1);educationPage.DropDownContext(degree);
            waitFor(1);
            educationPage.DepartmentButton.click();
            waitFor(1);
            educationPage.DropDownContext(dep);
            educationPage.StartYearButton.click();
            waitFor(1);
            educationPage.DropDownContext(start);
            clickWithJS(educationPage.AddEducationButton);
        }
        else if(degree.equals("")) {
            educationPage.UniversityButton.sendKeys(uni,Keys.ENTER);
            //   educationPage.DegreeButton.click();
            //   waitFor(1);
            //   educationPage.DropDownContext(degree);
            waitFor(1);
            educationPage.DepartmentButton.click();
            waitFor(1);
            educationPage.DropDownContext(dep);
            educationPage.StartYearButton.click();
            waitFor(1);
            educationPage.DropDownContext(start);
            clickWithJS(educationPage.AddEducationButton);
        }
        else if(dep.equals("")) {
            educationPage.UniversityButton.sendKeys(uni,Keys.ENTER);
            educationPage.DegreeButton.click();
            waitFor(1);
            educationPage.DropDownContext(degree);
            waitFor(1);
            // educationPage.DepartmentButton.click();
            // waitFor(1);
            // educationPage.DropDownContext(dep);
            educationPage.StartYearButton.click();
            waitFor(1);
            educationPage.DropDownContext(start);
            clickWithJS(educationPage.AddEducationButton);
        }
        else if(start.equals("")) {
            educationPage.UniversityButton.sendKeys(uni,Keys.ENTER);
            educationPage.DegreeButton.click();
            waitFor(1);
            educationPage.DropDownContext(degree);
            waitFor(1);
            educationPage.DepartmentButton.click();
            waitFor(1);
            educationPage.DropDownContext(dep);
            clickWithJS(educationPage.AddEducationButton);
        }
    }

    @And("user clicks the  delete icon")
    public void userClicksTheDeleteIcon() {
        waitFor(2);
        clickWithJS(educationPage.deleteButton);
    }




    @Then("user sees {string} under related fields")
    public void userSeesUnderRelatedFields(String message) {
        scrollToElement(educationPage.UniversityButton);
        waitFor(1);
        // educationPage.warningMessages(message);
        Assert.assertTrue(educationPage.warningMessages(message));
    }



    @And("user clicks + ADD EDUCATION button")
    public void userClicksADDEDUCATIONButton() {
        waitFor(2);
        educationPage.AddEducationButton.click();
    }

    @Then("user verifies following messages")  // datatable comes from selenium library
    public void userVerifiesFollowingMessages(DataTable dataTable) {
        waitFor(2);
        List<String> dataTableMessages = dataTable.column(0);
        for (int i = 0; i< dataTableMessages.size(); i++){
            waitFor(2);
            scrollToElement(educationPage.fields(dataTableMessages.get(i))); // return web element
            waitFor(2);
            //expected comes from feature      // actual comes from UI locate
            assertEquals( dataTableMessages.get(i),educationPage.fields(dataTableMessages.get(i)).getText());
        }

    }

    @Then("Test that + ADD EDUCATION button is clickable.")
    public void testThatADDEDUCATIONButtonIsClickable() {
        // we can use enable instead of clickable
        Assert.assertTrue(educationPage.AddEducationButton.isEnabled());
    }



    @Then("Test that user can add more education info")
    public void testThatUserCanAddMoreEducationInfo() {


    }

    @When("user should be able to write certificate type to add search box")
    public void userShouldBeAbleToWriteCertificateTypeToAddSearchBox() {
        waitFor(1);
        educationPage.TypeToAddSearchButton.sendKeys(Faker.instance().name().title());
    }
    @When("user should be able to write any letters type to add search box")
    public void userShouldBeAbleToWriteAnyLettersTypeToAddSearchBox() {

       // educationPage.TypeToAddSearchButton.sendKeys(Faker.instance().letterify("?"));
        educationPage.TypeToAddSearchButton.sendKeys("admin");

    }

    @And("user click ADD button")
    public void userClickADDButton() {
        waitFor(2);
        educationPage.AddButton.click();
    }

    @Then("Then test that ADD button is clickable")
    public void thenTestThatADDButtonIsClickable() {

        waitFor(2);
        educationPage.AddButton.isEnabled();
    }

    @Then("Test that a filed should be added which is not in suggested fields and should be seen succesfully message {string}")
    public void testThatAFiledShouldBeAddedWhichIsNotInSuggestedFieldsAndShouldBeSeenSuccesfullyMessageYourCertificateHasBeenSavedSuccessfully(String message) {

        waitFor(2);
        Assert.assertTrue(educationPage.addButtonMessage.getText().contains(message));
    }


    @Then("Test that all related certificates are seen")
    public void testThatAllRelatedCertificatesAreSeen() {
        clickWithJS(educationPage.seeMoreText);
        int certificateSize=educationPage.educationCertificates.size();

        while (certificateSize>0)
            for (int i = 0; i <certificateSize ; i++) {
                Assert.assertTrue(educationPage.educationCertificates.get(i).isDisplayed());
                certificateSize--;
            }
    }

    @When("user should click one of the suggested certificates")
    public void userShouldClickOneOfTheSuggestedCertificates() {
       // scrollToElement(educationPage.educationCertificates.get(0));
        waitFor(2);
       certificate=educationPage.educationCertificates.get(0).getText();

        System.out.println(certificate);
       clickWithJS(educationPage.educationCertificates.get(0));
    }

    @Then("Test that it is seen as greened in below")
    public void testThatItIsSeenAsGreenedInBelow() {
       scrollToElement(educationPage.educationSelectedCertificates.get(0));
        waitFor(2);

    assertTrue(educationPage.educationSelectedCertificates.get(educationPage.educationSelectedCertificates.size()-1).getText().contains(certificate));
    }

    @And("user should delete selected fields using the x button")
    public void userShouldDeleteSelectedFieldsUsingTheXButton() {
clickWithJS(educationPage.xButton.get(educationPage.xButton.size()-1));
    }

    @Then("Test that selected certificates are deleted clicking the button.")
    public void testThatSelectedCertificatesAreDeletedClickingTheButton() {
        Assert.assertFalse(educationPage.educationSelectedCertificates.get(educationPage.educationSelectedCertificates.size()-1).getText().contains(certificate));
    }
    @Then("Test that See More button should be seen under the Suggested certificates options.")
    public void testThatSeeMoreButtonShouldBeSeenUnderTheSuggestedCertificatesOptions() {
        scrollToElement(educationPage.seeMoreText);
        assertTrue(educationPage.seeMoreText.isEnabled());
    }

    @When("User should click SEE MORE button")
    public void userShouldClickSEEMOREButton() {
        clickWithJS(educationPage.seeMoreText);
    }

    @Then("Test that user should see the See Less button end of the Suggested certificates options")
    public void testThatUserShouldSeeTheSeeLessButtonEndOfTheSuggestedCertificatesOptions() {
        assertTrue(educationPage.seeLessText.isDisplayed());
    }
    @Then("Test that {string} button should be seen under the {string} options.")
    public void testThatButtonShouldBeSeenUnderTheOptions(String arg0, String arg1) {
    }

    @When("User should click {string} button")
    public void userShouldClickButton(String arg0) {


    }

    @Then("Test that {string} button should be visible and clickable")
    public void testThatButtonShouldBeVisibleAndClickable(String arg0) {
    }

    @Then("Test that user should see the {string} button end of the {string} options")
    public void testThatUserShouldSeeTheButtonEndOfTheOptions(String arg0, String arg1) {
    }


    @Then("Test that SAVE button is clickable")
    public void testThatSAVEButtonIsClickable() {

        Assert.assertTrue(educationPage.educationSave.isEnabled());

    }

    @Then("Test that user should see screen with {string} message alert on the page .")
    public void testThatUserShouldSeeScreenWithMessageAlertOnThePage(String arg0) {
    }

    @Then("Test that user sould be able to see saved education info on the screen")
    public void testThatUserSouldBeAbleToSeeSavedEducationInfoOnTheScreen() {
    }

    @And("user click CANCEL button")
    public void userClickCANCELButton() {
    }

    @Then("Test that CANCEL button is clickable")
    public void testThatCANCELButtonIsClickable() {
    }

    @Then("Test that user cancel the last changes before the saving")
    public void testThatUserCancelTheLastChangesBeforeTheSaving() {
    }

    @Then("user verifies University,Degree,Department ,Start Year ,End Year fields are visable")
    public void userVerifiesUniversityDegreeDepartmentStartYearEndYearFieldsAreVisable() {
        waitFor(1);
        Assert.assertTrue(educationPage.DegreeLabel.isDisplayed());
        waitFor(1);
        Assert.assertTrue(educationPage.StartYearLabel.isDisplayed());
        waitFor(1);
        Assert.assertTrue(educationPage.EndYearLabel.isDisplayed());
        waitFor(1);
        Assert.assertTrue(educationPage.UniversityLabel.isDisplayed());
        waitFor(1);
        Assert.assertTrue(educationPage.DepartmentLabel.isDisplayed());
    }





    @When("user clicks SAVE button")
    public void userClicksSAVEButton() {
        clickWithJS(educationPage.educationSave);
    }


    @And("user clicks the  delete icon if delete icon is seen")
    public void userClicksTheDeleteIconIfDeleteIconIsSeen() {

        if(educationPage.deleteButton.isEnabled()){
            waitFor(2);
            clickWithJS(educationPage.deleteButton);
        }
    }

    @When("user enters {string}, {string}, {string}, {string},{string} fields")
    public void userEntersFields(String university, String degree, String department, String startYear, String endYear){
        if(educationPage.deleteButton.isEnabled()){
            waitFor(2);
            clickWithJS(educationPage.deleteButton);
        }
        educationPage.UniversityButton.sendKeys(university,Keys.ENTER);
        educationPage.DegreeButton.click();
        waitFor(1);
        educationPage.DropDownContext(degree);
        waitFor(1);
        educationPage.DepartmentButton.click();
        waitFor(1);
        educationPage.DropDownContext(department);
        educationPage.StartYearButton.click();
        waitFor(1);
        educationPage.DropDownContext(startYear);
        educationPage.EndYearButton.click();
        waitFor(1);
        educationPage.DropDownContext(endYear);
      //  clickWithJS(educationPage.AddEducationButton);
}


    @Then("Test that user should see screen with {string} alert message")
    public void testThatUserShouldSeeScreenWithAlertMessage(String message) {
        waitFor(2);
       scrollToElement(educationPage.addEducationMessage);
        waitFor(2);
        System.out.println("educationPage.addEducationMessage.getText() = " + educationPage.addEducationMessage.getText());

        Assert.assertEquals(message, educationPage.addEducationMessage.getText());


    }
}