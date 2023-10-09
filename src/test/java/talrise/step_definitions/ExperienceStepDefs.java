package talrise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;

import java.awt.*;


public class ExperienceStepDefs extends CommonSteps {


    Robot robot;


    @And("the Experience module should be visible among other Profile modules")
    public void theExperienceModuleShouldBeVisibleAmongOtherProfileModules() {
        //  Assert.assertTrue(experiencePage.moduleEditIconList.get(6).getText().contains("Experience"));
        waitFor(5);
        CommonSteps.verifyElementDisplayed(experiencePage.moduleEditIconList.get(6));


    }

    @When("the user clicks on the Experience module")
    public void theUserClicksOnTheExperienceModule() {
        experiencePage.moduleEditIconList.get(6).click();
    }

    @Then("the Experience module should be expanded")
    public void theExperienceModuleShouldBeExpanded() {
        int profileModuleListSize = experiencePage.profileModuleList.size();
        int pencilIconListSize = experiencePage.moduleEditIconList.size();
        Assert.assertEquals(profileModuleListSize - 1, pencilIconListSize);
    }



    @Then("verify that all module items are collapsed when the page first opened")
    public void verifyThatAllModuleItemsAreCollapsedWhenThePageFirstOpened() {
        int profileModuleListSize = experiencePage.profileModuleList.size();
        int pencilIconListSize = experiencePage.moduleEditIconList.size();
        System.out.println("profileModuleListSize = " + profileModuleListSize);
        System.out.println("pencilIconListSize = " + pencilIconListSize);
        Assert.assertEquals(profileModuleListSize, pencilIconListSize);


    }

    @Given("The user on the {string} module")
    public void theUserOnTheModule(String experience) {

        experiencePage.moduleEditIconList.get(6).click();
        waitFor(2);
        assert experiencePage.isExperienceFieldsContainsText(experience);
//        Assert.assertTrue(experiencePage.experienceText.getText().contains(experience));
        System.out.println("experienceText = " + experiencePage.experienceText.getText());
    }

    @And("The user clicks to the {string} and type text")
    public void theUserClicksToTheAndTypeText(String title){


        int amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;
            System.out.println(" TitleElements= " + titleTextElement.getText());

        }
        System.out.println("amountOfTitle = " + amountOfTitle);


        System.out.println("**************************************************");
        System.out.println(amountOfTitle);

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
       // assert experiencePage.contractTypeText.getText().contains(dropdownText);
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
        experiencePage.getRandomSkill().click();
        experiencePage.getRandomSkill().click();
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

//    @And("The user clicks to the {string} module and not select")
//    public void theUserClicksToTheModuleAndNotSelect(String skillSet) {
//        experiencePage.skillSetDropDown.click();
//        experiencePage.getRandomSkill().click();
//        waitFor(3);
//        actions.sendKeys(Keys.PAGE_DOWN).doubleClick().perform();
//    }


    @When("The user clicks to the Title,Company,StartDate,and EndDate input boxes and types {string},{string},{string},and {string}")
    public void theUserClicksToTheTitleCompanyStartDateAndEndDateInputBoxesAndTypesAnd(String title, String company, String startDate, String endDate)  {
        int amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;
            System.out.println(" TitleElements= " + titleTextElement.getText());

        }
        System.out.println("amountOfTitle = " + amountOfTitle);


        System.out.println("**************************************************");
        System.out.println(amountOfTitle);

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
        int amountOfTitle = 0;

        for (WebElement titleTextElement : experiencePage.titleTextElements) {

            amountOfTitle++;
            System.out.println(" TitleElements= " + titleTextElement.getText());

        }
        System.out.println("amountOfTitle = " + amountOfTitle);


        System.out.println("**************************************************");
        System.out.println(amountOfTitle);

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
}
