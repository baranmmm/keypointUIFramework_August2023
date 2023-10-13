package talrise.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;
import java.util.List;


public class ExperienceStepDefs extends CommonSteps {

    int amountOfTitle;

    @And("the ExperienceS module should be visible among other Profile modules")
    public void theExperienceSModuleShouldBeVisibleAmongOtherProfileModules() {

        waitFor(5);
        CommonSteps.verifyElementDisplayed(experiencePage.moduleEditIconList.get(6));

    }

    @When("the userS clicks on the Experience module")
    public void theUsersClicksOnTheExperienceModule() {
        experiencePage.moduleEditIconList.get(6).click();
    }

    @Then("the ExperienceS module should be expanded")
    public void theExperiencesModuleShouldBeExpanded() {
        int profileModuleListSize = experiencePage.profileModuleList.size();
        int pencilIconListSize = experiencePage.moduleEditIconList.size();
        Assert.assertEquals(profileModuleListSize - 1, pencilIconListSize);
    }



    @Then("verifyS that all module items are collapsed when the page first opened")
    public void verifySThatAllModuleItemsAreCollapsedWhenThePageFirstOpened() {
        int profileModuleListSize = experiencePage.profileModuleList.size();
        int pencilIconListSize = experiencePage.moduleEditIconList.size();

        Assert.assertEquals(profileModuleListSize, pencilIconListSize);


    }

    @Given("The user on the {string} module")
    public void theUserOnTheModule(String experience) {

        experiencePage.moduleEditIconList.get(6).click();
        waitFor(2);
        assert experiencePage.isExperienceFieldsContainsText(experience);

    }

    @And("The user clicks to the {string} and type text")
    public void theUserClicksToTheAndTypeText(String title){


        amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;

        }

        actions.scrollToElement(experiencePage.experienceText).keyDown(Keys.PAGE_DOWN).perform();
        if (experiencePage.deleteButton.isDisplayed()) {
            waitFor(2);

            for (int i = 0; i < amountOfTitle; i++) {
                experiencePage.deleteButton.click();
            }
            experiencePage.titleInputBox.sendKeys(title);
        }

    }

    @When("The user verifies that should see the {string} input box")
    public void theUserVerifiesThatShouldSeeTheInputBox(String title) {
        assert experiencePage.isExperienceFieldsContainsText(title);

    }

    @And("The user clicks to the {string} and type company")
    public void theUserClicksToTheAndTypeCompany(String company)  {

        experiencePage.companyInputBox.sendKeys(company);

    }

    @And("The user clicks to the {string} and type startDate")
    public void theUserClicksToTheAndTypeStartDate(String startDate) {

        experiencePage.startDateInputBox.sendKeys(startDate);
        waitFor(2);

    }

    @And("The user clicks to the {string} and type endDate")
    public void theUserClicksToTheAndTypeEndDate(String endDate)  {

        experiencePage.endDateInputBox.sendKeys(endDate);
        waitFor(2);

    }

    @And("The user verifies that should see the {string} dropdown")
    public void theUserVerifiesThatShouldSeeTheDropdown(String dropdownText) {
        assert experiencePage.isExperienceFieldsContainsText(dropdownText);

    }

    @And("The user clicks to the {string} and select an option")
    public void theUserClicksToTheAndSelectAnOption(String contractTypeOption) {
        experiencePage.contractTypeDropDown.click();
        experiencePage.contractTypeList.get(1).click();

    }
    @And("The user clicks to {string} and select an option")
    public void theUserClicksToAndSelectAnOption(String str) {
        experiencePage.workplaceDropDown.click();
        experiencePage.workplaceList.get(2).click();
    }

    @And("The user verifies should see {string} dropdown")
    public void theUserVerifiesShouldSeeDropdown(String str) {
        assert experiencePage.skillSetDropDownText.getText().contains(str);
    }

    @And("The user clicks to the {string} module and select an option")
    public void theUserClicksToTheModuleAndSelectAnOption(String skillSet) {

        experiencePage.skillSetDropDown.click();
        getRandomId( experiencePage.skillSetList).click();
        getRandomId( experiencePage.skillSetList).click();
        waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).doubleClick().perform();

    }


    @And("The user clicks to the save button")
    public void theUserClicksToTheSaveButton() {

        waitFor(2);
        scrollToElement(experiencePage.experienceSaveButton);
        clickWithJS(experiencePage.experienceSaveButton);
        waitFor(3);

    }


    @Then("The user verifies the success message is displayed")
    public void theUserVerifiesTheSuccessMessageIsDisplayed() {
        assert experiencePage.successMessage.getText().contains("Your experience info has been submitted successfully.");
    }

    @Then("The user verifies the {string} is displayed")
    public void theUserVerifiesTheIsDisplayed(String message) {
        waitFor(5);
        assert experiencePage.skillSetWarningMsg.isDisplayed();
        assert experiencePage.skillSetWarningMsg.getText().contains(message);

    }



    @When("The user clicks to the Title,Company,StartDate,and EndDate input boxes and types {string},{string},{string},and {string}")
    public void theUserClicksToTheTitleCompanyStartDateAndEndDateInputBoxesAndTypesAnd(String title, String company, String startDate, String endDate)  {
         amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;

        }

        actions.scrollToElement(experiencePage.experienceText).keyDown(Keys.PAGE_DOWN).perform();
        if (experiencePage.deleteButton.isDisplayed()) {
            waitFor(2);

            for (int i = 0; i < amountOfTitle; i++) {
                experiencePage.deleteButton.click();
            }
            experiencePage.titleInputBox.click();
            experiencePage.titleInputBox.sendKeys(title);
            experiencePage.companyInputBox.click();
            experiencePage.companyInputBox.sendKeys(company);
            experiencePage.startDateInputBox.click();
            experiencePage.startDateInputBox.sendKeys(startDate);
            experiencePage.endDateInputBox.click();
            experiencePage.endDateInputBox.sendKeys(endDate);
        }
    }




    @When("The user clicks and types to the {string} in the experience module.")
    public void theUserClicksAndTypesToTheInTheExperienceModule(String inputboxes) {
        amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;
            System.out.println(" TitleElements= " + titleTextElement.getText());

        }


        actions.scrollToElement(experiencePage.experienceText).keyDown(Keys.PAGE_DOWN).perform();
        if (experiencePage.deleteButton.isDisplayed()) {
            waitFor(2);

            for (int i = 0; i < amountOfTitle; i++) {
                experiencePage.deleteButton.click();
            }
            experiencePage.titleInputBox.click();
            experiencePage.titleInputBox.sendKeys(inputboxes);
            experiencePage.companyInputBox.click();
            experiencePage.companyInputBox.sendKeys(inputboxes);
            experiencePage.startDateInputBox.click();
            experiencePage.startDateInputBox.sendKeys(inputboxes);
            experiencePage.endDateInputBox.click();
            experiencePage.endDateInputBox.sendKeys(inputboxes);
        }

    }

    @And("The user clicks to the Skill Set dropdown in the experience module and not select any options")
    public void theUserClicksToTheSkillSetDropdownInTheExperienceModuleAndNotSelectAnyOptions() {
        waitFor(3);
        experiencePage.skillSetDropDown.click();
        waitFor(3);
        actions.doubleClick(experiencePage.skillSetList.get(0)).perform();
        actions.sendKeys(Keys.ESCAPE).perform();


    }

    @When("The user clicks {string} checkbox")
    public void theUserClicksCheckbox(String arg0) {

        if(!experiencePage.ICWITPCheckBox.isSelected()){
            waitFor(2);
            experiencePage.ICWITPCheckBox.click();
        }else{
            System.out.println("Notice Period dropdown menuden secim yapiniz!");
        }

    }

    @And("The user verifies that should see the {string} checkbox.")
    public void theUserVerifiesThatShouldSeeTheCheckbox(String str) {
        assert experiencePage.ICWINTPText.getText().contains(str);
    }

    @And("The user should see {string} dropdown  menu")
    public void theUserShouldSeeDropdownMenu(String str) {
        assert experiencePage.isExperienceFieldsContainsText(str);
    }

    @And("The user should click {string} dropdown  menu")
    public void theUserShouldClickDropdownMenu(String noticePeriod) {
        waitFor(3);
        experiencePage.noticePeriodDropDown.click();

    }

    @And("the {string} field should be mandatory to select")
    public void theFieldShouldBeMandatoryToSelect(String str) {

        waitFor(2);
        experiencePage.noticePeriodList.get(3).click();
    }

    @When("The user clicks the {string} checkbox")
    public void theUserClicksTheCheckbox(String arg0) {
        experiencePage.ICWITPCheckBox.click();
    }

    @Then("The user should not see the {string} input box")
    public void theUserShouldNotSeeTheInputBox(String arg0) {
        assert (!experiencePage.endDateInputBox.isEnabled());
        System.out.println("!experiencePage.endDateInputBox.isEnabled() = " + !experiencePage.endDateInputBox.isEnabled());
    }

    @And("The user should not be able to select the {string} input box")
    public void theUserShouldNotBeAbleToSelectTheInputBox(String arg0) {
        assert (!experiencePage.endDateInputBox.isSelected());
        System.out.println("!experiencePage.endDateInputBox.isSelected() = " + !experiencePage.endDateInputBox.isSelected());
    }

    @Then("the ADD MORE EXPERIENCE, CANCEL and SAVE buttons should be visible")
    public void theADDMOREEXPERIENCECANCELAndSAVEButtonsShouldBeVisible() {
        assert experiencePage.addMoreExpBtn.isDisplayed();
        assert experiencePage.cancelBtn.isDisplayed();
        assert experiencePage.saveBtn.isDisplayed();
    }

    @And("the ADD MORE EXPERIENCE, CANCEL and SAVE buttons should be clickable")
    public void theADDMOREEXPERIENCECANCELAndSAVEButtonsShouldBeClickable() {
        assert experiencePage.addMoreExpBtn.isEnabled();
        assert experiencePage.cancelBtn.isEnabled();
        assert experiencePage.saveBtn.isEnabled();
    }

    @When("The user clicks the ADD MORE EXPERIENCE button")
    public void theUserClicksTheADDMOREEXPERIENCEButton() {
        actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        waitFor(3);
        experiencePage.addMoreExpBtn.click();
        waitFor(5);

    }
    @Then("Verify that user should add more experiences")
    public void verifyThatUserShouldAddMoreExperiences() {
        amountOfTitle=0;
        for (WebElement titleTextElement : experiencePage.titleTextElements) {
            amountOfTitle++;
        }

        if(amountOfTitle>0){
            Assert.assertTrue(experiencePage.addMoreExpBtn.isDisplayed());
        }else{
            System.out.println("Add more button could not been added!");
        }

    }

    @When("The user selects items from the dropdowns and typed text into the input boxes")
    public void theUserSelectsItemsFromTheDropdownsAndTypedTextIntoTheInputBoxes() {

    }
    @Then("Verify that Delete button should be visible")
    public void verifyThatDeleteButtonShouldBeVisible() {
        assert experiencePage.deleteButton.isDisplayed();

    }



    @And("The user clicks {string} button")
    public void theUserClicksButton(String arg0) {
        experiencePage.deleteButton.click();
        waitFor(4);
    }
    @Then("Verify that Delete button should be clickable")
    public void verifyThatDeleteButtonShouldBeClickable() {

        assert experiencePage.deleteButton.isEnabled();

    }





    @When("The user has not selected any items from the dropdowns or typed any text into the input boxes")
    public void theUserHasNotSelectedAnyItemsFromTheDropdownsOrTypedAnyTextIntoTheInputBoxes() {
        amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;
        }

        actions.scrollToElement(experiencePage.experienceText).keyDown(Keys.PAGE_DOWN).perform();
        if (experiencePage.deleteButton.isDisplayed()) {
            waitFor(2);

            for (int i = 0; i < amountOfTitle; i++) {
                experiencePage.deleteButton.click();
            }
        }

        waitFor(3);

    }

    @Then("Verify that {string} button should not be visible")
    public void verifyThatButtonShouldNotBeVisible(String arg0) {
        assert !experiencePage.deleteButton.isDisplayed();


    }

    @When("The user fills up the Experience fields")
    public void theUserFillsUpTheExperienceFields() {


    }

    @And("The user clicks the {string} button at the top right of the Experience module")
    public void theUserClicksTheButtonAtTheTopRightOfTheExperienceModule(String arg0) {
        waitFor(2);
        experiencePage.deleteButton.click();
        waitFor(4);
    }

    @Then("Verify that the experience fields should be deleted")
    public void verifyThatTheExperienceFieldsShouldBeDeleted() {
        assert experiencePage.titleInputBox.getAttribute("value").isEmpty();
        assert experiencePage.companyInputBox.getAttribute("value").isEmpty();
        assert experiencePage.startDateInputBox.getAttribute("value").isEmpty();
        assert experiencePage.endDateInputBox.getAttribute("value").isEmpty();
        assert !experiencePage.skillSetDropDown.isSelected();

    }

    @When("The user selects the one option randomly from the Workplace dropdown")
    public void theUserSelectsTheOneOptionRandomlyFromTheWorkplaceDropdown() {

        waitFor(3);
        getRandomId(experiencePage.workplaceList).click();
        waitFor(3);



    }

    @Then("Verify that user sees all the Workplace dropdown options")
    public void verifyThatUserSeesAllTheWorkplaceDropdownOptions(DataTable dataTable) {

        experiencePage.workplaceDropDown.click();
        waitFor(2);
       List<String> workPlaceList = dataTable.column(0);
       waitFor(2);
        for (int i = 0; i <workPlaceList.size() ; i++) {

            WebElement element= driver.findElement(By.xpath("//li[text()='"+workPlaceList.get(i)+"']"));
            waitFor(3);
            assert element.isDisplayed();

        }

    }

    @When("The user selects the {string} option from the Workplace dropdown")
    public void theUserSelectsTheOptionFromTheWorkplaceDropdown(String arg0) {
        experiencePage.workplaceDropDown.click();
        waitFor(2);
        experiencePage.workplaceList.get(0).click();
        waitFor(2);

    }

    @Then("Verify that the Workplace dropdown should be empty")
    public void verifyThatTheWorkplaceDropdownShouldBeEmpty() {
        assert experiencePage.workplaceDropDown.getText().isEmpty();
    }

    @When("The user clicks to the Contract Type dropdown menu")
    public void theUserClicksToTheContractTypeDropdownMenu() {
        experiencePage.contractTypeDropDown.click();
    }

    @And("The user clicks on one option randomly from the Contract Type dropdown menu")
    public void theUserClicksOnOneOptionRandomlyFromTheContractTypeDropdownMenu() {
        getRandomId(experiencePage.contractTypeList).click();
        waitFor(2);
    }

    @Then("Verify that user sees all the Contract Type dropdown menu")
    public void verifyThatUserSeesAllTheContractTypeDropdownMenu(DataTable contractType) {
        actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        experiencePage.contractTypeDropDown.click();
        List<String> contractTypeDataTable = contractType.column(0);
        for (int i = 0; i <contractTypeDataTable.size() ; i++) {
            waitFor(2);
            WebElement contractTypeElement= driver.findElement(By.xpath("//li[text()='"+contractTypeDataTable.get(i)+"']"));
            waitFor(2);
            assert contractTypeElement.isDisplayed();

        }

    }

    @When("The user clicks to the Notice Period dropdown menu")
    public void theUserClicksToTheNoticePeriodDropdownMenu() {
    }

    @And("The user clicks on one option randomly from the Notice Period dropdown menu")
    public void theUserClicksOnOneOptionRandomlyFromTheNoticePeriodDropdownMenu() {
    }

    @Then("Verify that user sees all the Notice Period dropdown menu")
    public void verifyThatUserSeesAllTheNoticePeriodDropdownMenu() {
    }

    @When("The user cliks the {string} textbox")
    public void theUserCliksTheTextbox(String arg0) {
    }

    @And("The user types {string} in the Type to add more information textbox")
    public void theUserTypesInTheTypeToAddMoreInformationTextbox(String arg0) {
    }

    @And("The user press the Enter key")
    public void theUserPressTheEnterKey() {
    }

    @Then("Verify that user should see the {string} text in the Type to add more information textbox")
    public void verifyThatUserShouldSeeTheTextInTheTypeToAddMoreInformationTextbox(String arg0) {

    }

    @And("The user enters {int} characters in the text box")
    public void theUserEntersCharactersInTheTextBox(int arg0) {
    }

    @Then("Verify that user sees to type Max {int} characters")
    public void verifyThatUserSeesToTypeMaxCharacters(int arg0) {
    }

    @Then("Verify that user sees not to type {int} characters")
    public void verifyThatUserSeesNotToTypeCharacters(int arg0) {
    }

    @When("The user clicks to the {string},{string},{string},{string},{string},and {string} input boxes,dropdowns and types")
    public void theUserClicksToTheAndInputBoxesDropdownsAndTypes(String Title, String Company, String ContractType, String Workplace, String StartDate, String EndDate) {
        amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;
        }

        actions.scrollToElement(experiencePage.experienceText).keyDown(Keys.PAGE_DOWN).perform();
        if (experiencePage.deleteButton.isDisplayed()) {
            waitFor(2);

            for (int i = 0; i < amountOfTitle; i++) {
                experiencePage.deleteButton.click();
            }
        }

        experiencePage.titleInputBox.sendKeys(Title,Keys.TAB,Company);
    }

    @When("The user clicks to the {string},{string},{string},{string},{string},{string},{string} input boxes,dropdowns and types")
    public void theUserClicksToTheAndInputBoxesDropdownsAndTypes(String Title, String Company, String ContractType, String Workplace, String StartDate, String EndDate, String SkillSet) {
        amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;
        }

        actions.scrollToElement(experiencePage.experienceText).keyDown(Keys.PAGE_DOWN).perform();
        if (experiencePage.deleteButton.isDisplayed()) {
            waitFor(2);

            for (int i = 0; i < amountOfTitle; i++) {
                experiencePage.deleteButton.click();
            }
        }

        experiencePage.titleInputBox.sendKeys(Title,Keys.TAB,Company,Keys.ENTER,ContractType,Keys.ENTER,Workplace,Keys.ENTER,StartDate,Keys.ENTER,
                EndDate,Keys.ENTER,SkillSet,Keys.ENTER);
    }

}
