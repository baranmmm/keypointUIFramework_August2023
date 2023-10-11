package talrise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;
import talrise.utilities.ConfigurationReader;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileStepDefs extends CommonSteps {

    @Given("the {string} logs in successfully")
    public void theLogsInSuccessfully(String role) throws Exception {
        driver.get(ConfigurationReader.get("environmentUrl"));
        if (role.equalsIgnoreCase("candidate") || role.equalsIgnoreCase("superadmin")) {
            role = role + "_email";
            loginPage.emailTxtbox.sendKeys(ConfigurationReader.get(role));
        } else {
            throw new Exception("Role should be either candidate or superadmin");
        }
        loginPage.passwordTxtbox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();
    }

    @And("the user navigates {string} left menu option")
    public void theUserNavigatesLeftMenuOption(String leftMenuOption) {
        waitFor(2);
        dashboardPage.goToLeftMenuOption(leftMenuOption);
    }

    @Then("{string} module is visible and collapsed")
    public void moduleIsVisibleAndCollapsed(String arg0) {
    }

    @When("the user clicks on {string} section pencil icon")
    public void theUserClicksOnSectionPencilIcon(String profileSection) {
        profilePage.clickOnProfileSectionPencilIcon(profileSection);
    }

    @Then("{string} header is visible")
    public void headerIsVisible(String profileSection) {
        waitForVisibility(driver.findElement(By.xpath("//h2[contains(.,'" + profileSection + "')]")), 15);
        Assert.assertTrue(profilePage.isProfileSectionHeaderVisible(profileSection));
    }

    @Then("verify that all module items are collapsed when the page first opened")
    public void verifyThatAllModuleItemsAreCollapsedWhenThePageFirstOpened() {   // 1
        int profileModuleListSize = profilePage.profileModuleList.size();
        int pencilIconListSize = profilePage.moduleEditIconList.size();
        Assert.assertEquals(profileModuleListSize, pencilIconListSize);
    }

    @Then("verify that the user sees the Initials of the name in the red circle")
    public void verifyThatTheUserSeesTheInitialsOfTheNameInTheRedCircle() {     // 2
        waitFor(2);
        System.out.println("profilePage.initialOfName.getText() = " + profilePage.initialOfName.get(1).getText());
        Assert.assertEquals(profilePage.initialOfName.get(1).getText(), "MG");
    }

    @Then("verify that the user sees the candidate's first name, last name, job title")
    public void verifyThatTheUserSeesTheCandidateSFirstNameLastNameJobTitle() {      // 3
        Assert.assertEquals(profilePage.profilePageNameLastName.getText(), "Maizie Garza");
        Assert.assertEquals(profilePage.profileJobTitle.getText(), "Engineering Schmengineering");
    }

    @Then("Verify that the user sees the location icon and city name of the country on the top left side of the page under the first name and last name")
    public void verifyThatTheUserSeesTheLocationIconAndCityNameOfTheCountryOnTheTopLeftSideOfThePageUnderTheFirstNameAndLastName() {
        Assert.assertEquals(profilePage.locationNameAndIcon.getText(), "London");
        Assert.assertTrue(profilePage.locationNameAndIcon.findElements(By.tagName("svg")).size() > 0);
    }

    @Then("Verify that the user sees {string} text and the {string} button")
    public void verifyThatTheUserSeesTextAndTheButton(String arg0, String arg1) {
        Assert.assertEquals(profilePage.OffTheMarketText.getText(), "Off the market");
    }

    @Then("user should click {string} button")
    public void userShouldClickButton(String arg0) {
        profilePage.OffTheMarketButton.click();
    }

    @Then("Verify that the user sees the {string} text")
    public void verifyThatTheUserSeesTheText(String profileCompleteRateText) {
        Assert.assertEquals(profilePage.profileCompleteRateText.getText(), profileCompleteRateText);
    }

    @Then("Verify that the user sees the percentage line and rate")
    public void verifyThatTheUserSeesThePercentageLineAndRate() {
        boolean percentageLineDisplayed = profilePage.percentageLine.isDisplayed();
        boolean percentageRateDisplayed = profilePage.percentageRate.isDisplayed();
        Assert.assertTrue(percentageLineDisplayed);
        Assert.assertTrue(percentageRateDisplayed);
    }

    String firstPercentageRate = "";
    String firstPercentageLine = "";

    @When("user clicks industry module")
    public void userClicksIndustryModule() {
        profilePage.industryModule.click();
        firstPercentageRate = profilePage.percentageRate.getText();
        System.out.println("firstPercentageRate = " + firstPercentageRate);

        firstPercentageLine = profilePage.percentageLine.getAttribute("aria-valuenow");
        System.out.println("firstPercentageLine = " + firstPercentageLine);
    }

    @When("Select all industry field")
    public void selectAllIndustryField() {
        while (driver.findElements(By.xpath("(//div[@class='sc-hCPjZK cTBSCn'][1])[3]/button[1]")).size() > 0) {
            profilePage.industryModuleFirstField.click();
        }
    }

    @And("user should click save button for industry fields")
    public void userShouldClickSaveButtonForIndustryFields() {
        waitFor(2);
        profilePage.saveButtonInIndustry.click();
    }

    @Then("user should see the percentage line and rate changed")
    public void userShouldSeeThePercentageLineAndRateChanged() {

        String percentageLineNow = profilePage.percentageLine.getAttribute("aria-valuenow");
        System.out.println("percentageLineNow = " + percentageLineNow);

        String secondPercentageRateafterSelectedIndustryField = profilePage.percentageRate.getText();   // %100
        Assert.assertNotEquals(secondPercentageRateafterSelectedIndustryField, firstPercentageRate);

        Assert.assertNotEquals(firstPercentageLine, percentageLineNow);
    }

    @When("press the Cross button above all fields")
    public void pressTheCrossButtonAboveAllFields() {
        while (driver.findElements(By.xpath("((((//div[contains(@class, 'sc-SrznA fNcrbv')])[5])//div[@class='sc-Nxspf chrSeZ'])//button)[1]")).size() > 0) {
            driver.findElements(By.xpath("((((//div[contains(@class, 'sc-SrznA fNcrbv')])[5])//div[@class='sc-Nxspf chrSeZ'])//button)[1]")).get(0).click();
        }
    }

    @Then("verify user should see {string} text")
    public void verifyUserShouldSeeText(String lastloginText) {
        String lastLoginText = profilePage.lastLoginText.getText();
        boolean lastLoginTextDisplayed = profilePage.lastLoginText.isDisplayed();
        Assert.assertTrue(lastLoginTextDisplayed);
    }

    @Then("verify user should see last login date and time")
    public void verifyUserShouldSeeLastLoginDateAndTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("d-M-yyyy");
        Date tarih = new Date();
        String bugununTarihi = dateFormat.format(tarih);

        String lastLoginDate = profilePage.lastLoginDate.getText();

        boolean lastLoginDateDisplayed = profilePage.lastLoginDate.isDisplayed();

        int boslukIndeks = lastLoginDate.indexOf(" ");
        lastLoginDate = lastLoginDate.substring(0, boslukIndeks);
        System.out.println("bugununTarihi = " + bugununTarihi);
        System.out.println("lastLoginDate = " + lastLoginDate);
        Assert.assertEquals(lastLoginDate, bugununTarihi);
    }

    @Then("the user sees and clicks the {string} button")
    public void theUserSeesAndClicksTheButton(String arg0) {
        boolean overviewButtonDisplayed = profilePage.overviewButton.isDisplayed();
        Assert.assertTrue(overviewButtonDisplayed);
        profilePage.overviewButton.click();
    }

    @Then("user sees and clicks on the Personal Information, Upload CV, Position, Skill Set, Industry, Language, Experience, Education and Preferences profile subtitles")
    public void userSeesAndClicksOnThePersonalInformationUploadCVPositionSkillSetIndustryLanguageExperienceEducationAndPreferencesProfileSubtitles() {
        for (WebElement element : profilePage.getProfileModuleList) {
            System.out.println(element.getText());
            boolean elementProfile = element.isDisplayed();
            Assert.assertTrue(elementProfile);
            waitFor(2);
            element.click();
            waitFor(2);
            element.click();
        }
    }

    @And("the user navigates to industry module")
    public void theUserNavigatesToIndustryModule() {
        profilePage.industryModule.click();
    }

    @Then("user should see that red cross turns green check sign")
    public void userShouldSeeThatRedCrossTurnsGreenCheckSign() {
       boolean greenCheckIconForIndustry = profilePage.greenTickIndustry.isDisplayed();
        Assert.assertTrue(profilePage.greenTickIndustry.getAttribute("outerHTML").contains("M699"));
    }

    @Then("user should see that green sign turns the red cross")
    public void userShouldSeeThatGreenSignTurnsTheRedCross() {
       boolean redCrossIconForIndustry = profilePage.greenTickIndustry.isDisplayed();
        Assert.assertFalse(profilePage.greenTickIndustry.getAttribute("outerHTML").contains("M699"));
    }

    @When("the user clicks the Edit icons")
    public void theUserClicksTheEditIcons() {
        for (WebElement element : profilePage.moduleEditIconList) {
            element.click();
            waitFor(2);
        }
    }

    @Then("the user should see the module pages opened")
    public void theUserShouldSeeTheModulePagesOpened() {
        for (WebElement element : profilePage.getProfileCollapsedOpenList) {
            boolean profileModuleOpenedAfterClickEdit = element.isDisplayed();
            Assert.assertTrue(profileModuleOpenedAfterClickEdit);
        }
    }

    @When("the user clicks the Edit icons for closed")
    public void theUserClicksTheEditIconsForClosed() {
        for (WebElement element : profilePage.moduleEditIconListForClosed) {
            element.click();
            waitFor(2);
        }
    }

    @Then("the user should see the module pages collapsed")
    public void theUserShouldSeeTheModulePagesCollapsed() {
        for (WebElement element : profilePage.getProfileCollapsedOpenList) {
            boolean profileModuleOpenedAfterClickEdit = element.isDisplayed();
            Assert.assertFalse(profileModuleOpenedAfterClickEdit);
        }
    }

}
