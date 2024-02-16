package talrise.step_definitions.superadmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.hotkey.Keys;
import talrise.utilities.CommonSteps;

public class SettingsPageStepDefs extends CommonSteps {

    int firstRecordOfTotalLookUpNumber = -10;
    int secondRecordOfTotalLookUpNumber = -10;
    int idOfTopLookUp;
    int idOfEditedLookUp;
    int rowOfEditedLookUp;
    String infoOfEditedLookUp;
    int rowSize;

    @Then("verifies that it is on the settings page")
    public void verifiesThatItIsOnTheSettingsPage() {
        String expectedUrlContent = "/settings";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlContent));
    }
    @Then("verifies that {string} table title is displayed")
    public void verifiesThatTableTitleIsDisplayed(String expectedTableTitle) {
        Assert.assertEquals(expectedTableTitle, settingsPage.lookUpTableTitle.getText());
    }
    @Then("verifies that the page is designed on Figma requirements")
    public void verifiesThatThePageIsDesignedOnFigmaRequirements() {
    }
    @Then("verifies that ADD LOOK UP button is visible and clickable")
    public void verifiesThatADDLOOKUPButtonIsVisibleAndClickable() {
        verifyElementDisplayed(settingsPage.addLookUpBtn);
        waitForClickability(settingsPage.addLookUpBtn, 10);
    }
    @And("clicks on ADD LOOK UP button")
    public void clicksOnADDLOOKUPButton() {
        settingsPage.addLookUpBtn.click();
    }
    @And("verifies that {string} page head is displayed")
    public void verifiesThatPageHeadIsDisplayed(String expectedPageHead) {
        Assert.assertEquals(expectedPageHead, settingsPage.addLookUpPageHead.getText());
    }
    @Then("verifies that BACK button is visible and clickable")
    public void verifiesThatBACKButtonIsVisibleAndClickable() {
        verifyElementDisplayed(settingsPage.backBtn);
        waitForClickability(settingsPage.backBtn, 10);
    }
    @When("clicks on BACK button")
    public void clicksOnBACKButton() {
        settingsPage.backBtn.click();
    }
    @And("enters {string} to parent id")
    public void entersToParentId(String parentId) {
        sendText(settingsPage.parentIdInputBox, parentId);
    }
    @And("selects {string} type from the list")
    public void selectsTypeFromTheList(String type) {
        type = settingsPage.prepareTypeForDropdownSelect(type);
        settingsPage.typeInputDropdown.click();
        WebElement typeElement = driver.findElement(By.xpath("//li[contains(text(),'" + type + "')]"));
        scrollToElement(typeElement);
        waitFor(1);
        typeElement.click();
        waitFor(1);
    }
    @And("enters {string} to name")
    public void entersToName(String name) {
        sendText(settingsPage.nameInputBox, name);
    }
    @And("clicks on SAVE LOOK UP FILES button")
    public void clicksOnSAVELOOKUPFILESButton() {
        scrollToElement(settingsPage.saveLookUpBtn);
        settingsPage.saveLookUpBtn.click();
    }
    @Then("verifies that total number of look ups is visible")
    public void verifiesThatTotalNumberOfLookUpsIsVisible() {
        waitFor(1);
        int totalNumberOfLookUps = settingsPage.getTotalNumberOfLookUps();
        Assert.assertTrue(totalNumberOfLookUps>=0);
    }
    @And("notes the total number of look ups")
    public void notesTheTotalNumberOfLookUps() {
        waitFor(1);
        if(firstRecordOfTotalLookUpNumber<0) {
            firstRecordOfTotalLookUpNumber=settingsPage.getTotalNumberOfLookUps();
        } else {
            secondRecordOfTotalLookUpNumber=settingsPage.getTotalNumberOfLookUps();
        }
    }
    @Then("verifies that the second record of total look ups is equal to one more than the first record")
    public void verifiesThatTheSecondRecordOfTotalLookUpsIsEqualToOneMoreThanTheFirstRecord() {
        Assert.assertEquals(firstRecordOfTotalLookUpNumber+1,secondRecordOfTotalLookUpNumber);
    }
    @Then("verifies that the second record of total look ups is equal to one less than the first record")
    public void verifiesThatTheSecondRecordOfTotalLookUpsIsEqualToOneLessThanTheFirstRecord() {
        waitFor(1);
        Assert.assertEquals(firstRecordOfTotalLookUpNumber-1,secondRecordOfTotalLookUpNumber);
    }
    @And("notes the id of the look up which is top of the list")
    public void notesTheIdOfTheLookUpWhichIsTopOfTheList() {
        waitFor(1);
        idOfTopLookUp=settingsPage.getIntValueOfLookUp(1,1);
    }
    @And("verifies that the id of the look up top of the list is different from the noted before")
    public void verifiesThatTheIdOfTheLookUpTopOfTheListIsDifferentFromTheNotedBefore() {
        waitFor(1);
        Assert.assertNotEquals(idOfTopLookUp,settingsPage.getIntValueOfLookUp(1,1));
    }
    @When("clicks on delete button for look up which is on the {int} row of the list")
    public void clicksOnDeleteButtonForLookUpWhichIsOnTheRowOfTheList(int rowNumber) {
        scrollToElement(settingsPage.deleteBtns.get(rowNumber-1));
        settingsPage.deleteBtns.get(rowNumber-1).click();
    }
    @And("verifies that the id of the look up top of the list is same as the noted before")
    public void verifiesThatTheIdOfTheLookUpTopOfTheListIsSameAsTheNotedBefore() {
        waitFor(1);
        Assert.assertEquals(idOfTopLookUp,settingsPage.getIntValueOfLookUp(1,1));
    }
    @Then("verifies that {string} prompt message is displayed under type field")
    public void verifiesThatPromptMessageIsDisplayedUnderTypeField(String expectedPromptMessage) {
        waitFor(1);
        Assert.assertEquals(expectedPromptMessage,settingsPage.typePromptMessage.getText());
    }
    @Then("verifies that {string} prompt message is displayed under name field")
    public void verifiesThatPromptMessageIsDisplayedUnderNameField(String expectedPromptMessage) {
        waitFor(1);
        Assert.assertEquals(expectedPromptMessage,settingsPage.namePromptMessage.getText());
    }
    @Then("verifies that {string} prompt message is displayed under parent id field")
    public void verifiesThatPromptMessageIsDisplayedUnderParentIdField(String expectedPromptMessage) {
        waitFor(1);
        Assert.assertEquals(expectedPromptMessage,settingsPage.parentIdPromptMessage.getText());
    }
    @Then("verifies that the alert message is {string}")
    public void verifiesThatTheAlertMessageIs(String expectedAlertMessage) {
        waitForVisibility(settingsPage.alertMessage,5);
        Assert.assertEquals(expectedAlertMessage,settingsPage.alertMessage.getText());
    }
    @And("selects {string} from the list size options")
    public void selectsFromTheListSizeOptions(String sizeOfList) {
        waitFor(1);
        scrollToElement(settingsPage.selectRowSizeDropdown);
        settingsPage.selectRowSizeDropdown.click();
        driver.findElement(By.xpath("//li[@data-value='"+sizeOfList+"']")).click();
    }
    @And("enters {string} to search field and press enter")
    public void entersToSearchFieldAndPressEnter(String searchKeyword) {
        scrollToElement(settingsPage.searchInputBox);
        settingsPage.searchInputBox.sendKeys(searchKeyword+ Keys.ENTER);
    }
    @Then("verifies that number of filtered look ups is less than noted total number of look ups")
    public void verifiesThatNumberOfFilteredLookUpsIsLessThanNotedTotalNumberOfLookUps() {
        Assert.assertTrue(firstRecordOfTotalLookUpNumber>settingsPage.getTotalNumberOfLookUps());
    }
    @And("verifies that names of filtered look ups contain {string} without case sensitivity")
    public void verifiesThatNamesOfFilteredLookUpsContainWithoutCaseSensitivity(String expectedKeyword) {
        for (int i = 0; i < settingsPage.nameColumn.size(); i++) {
            Assert.assertTrue(settingsPage.nameColumn.get(i).getText().toLowerCase().contains(expectedKeyword.toLowerCase()));
        }
    }
    @Then("verifies that edit \\(pencil) buttons are visible and clickable")
    public void verifiesThatEditPencilButtonsAreVisibleAndClickable() {
        for (int i = 0; i < settingsPage.editBtns.size(); i++) {
            verifyElementDisplayed(settingsPage.editBtns.get(i));
            waitForClickability(settingsPage.editBtns.get(i), 10);
        }

    }
    @And("clicks on edit button for row {int} and notes the id of that look up")
    public void clicksOnEditButtonForRowAndNotesTheIdOfThatLookUp(int rowNumber) {
        waitFor(1);
        idOfEditedLookUp=settingsPage.getIntValueOfLookUp(rowNumber,1);
        rowOfEditedLookUp=rowNumber;
        scrollToElement(settingsPage.editBtns.get(rowNumber-1));
        settingsPage.editBtns.get(rowNumber-1).click();
    }
    @Then("verifies that row {int} is on update mode")
    public void verifiesThatRowIsOnUpdateMode(int rowNumber) {
        Assert.assertTrue(driver.findElement(By.xpath("//tbody/tr["+rowNumber+"]")).getAttribute("mode").equalsIgnoreCase("update"));
    }
    @And("clicks on cancel button")
    public void clicksOnCancelButton() {
        actions.release().perform();
        scrollToElement(settingsPage.cancelAfterEditBtn);
        settingsPage.cancelAfterEditBtn.click();
    }
    @Then("verifies that row {int} is not on update mode")
    public void verifiesThatRowIsNotOnUpdateMode(int rowNumber) {
        Assert.assertTrue(driver.findElement(By.xpath("//tbody/tr["+rowNumber+"]")).getAttribute("level").equals("0"));
    }
    @When("enters {string} to name field for edit")
    public void entersToNameFieldForEdit(String newName) {
        actions.doubleClick(settingsPage.editingNameInputBox).sendKeys(Keys.BACKSPACE).perform();
        settingsPage.editingNameInputBox.sendKeys(newName);
    }
    @And("clicks on save button")
    public void clicksOnSaveButton() {
        scrollToElement(settingsPage.saveAfterEditBtn);
        settingsPage.saveAfterEditBtn.click();
        waitFor(3);
    }
    @When("selects {string} type from the list for edit")
    public void selectsTypeFromTheListForEdit(String newType) {
        newType = settingsPage.prepareTypeForDropdownSelect(newType);
        settingsPage.editingTypeInputDropdown.click();
        WebElement typeElement = driver.findElement(By.xpath("//li[contains(text(),'" + newType + "')]"));
        scrollToElement(typeElement);
        typeElement.click();
        waitFor(2);
    }
    @Then("verifies that the {string} of look up has id noted before is changed as {string}")
    public void verifiesThatTheOfLookUpHasIdNotedBeforeIsChangedAs(String column, String expectedInfo) {
        waitFor(2);
        int columnNumber=settingsPage.getIndexOfColumn(column);
        String actualInfo=settingsPage.getValueOfLookUp(settingsPage.findRowOfLookUpById(idOfEditedLookUp),settingsPage.getIndexOfColumn(column));
        if(columnNumber==2) {
            actualInfo=actualInfo.replaceAll("_"," ").toUpperCase();
            expectedInfo=expectedInfo.replaceAll("i","I").toUpperCase();
        }
        Assert.assertEquals(expectedInfo,actualInfo);
    }
    @And("notes the {string} of edited look up")
    public void notesTheOfEditedLookUp(String column) {
        infoOfEditedLookUp=settingsPage.getValueOfEditingLookUp(rowOfEditedLookUp,settingsPage.getIndexOfColumn(column));
    }
    @When("enters {string} to parent id field for edit")
    public void entersToParentIdFieldForEdit(String newParentId) {
        actions.doubleClick(settingsPage.editingParentIdInputBox).sendKeys(Keys.BACKSPACE).perform();
        settingsPage.editingParentIdInputBox.sendKeys(newParentId);
    }
    @Then("verifies that the {string} of look up has id noted before is not changed")
    public void verifiesThatTheOfLookUpHasIdNotedBeforeIsNotChanged(String column) {
        String actualInfo=settingsPage.getValueOfLookUp(rowOfEditedLookUp, settingsPage.getIndexOfColumn(column));
        Assert.assertEquals(infoOfEditedLookUp,actualInfo);
    }
    @Then("verifies that number of row which includes look up id is {int}")
    public void verifiesThatNumberOfRowWhichIncludesLookUpIdIs(int expectedRowNumber) {
        Assert.assertEquals(expectedRowNumber,settingsPage.countRowHasLookUpId());
    }
    @And("clicks on {string} page button")
    public void clicksOnPageButton(String navigationType) {
        navigationType=navigationType.toUpperCase().charAt(0)+navigationType.toLowerCase().substring(1);
        WebElement navigationBtn=driver.findElement(By.xpath("//span[@title='"+navigationType+" Page']"));
        scrollToElement(navigationBtn);
        waitFor(1);
        navigationBtn.click();
    }
    @And("notes the row size selection")
    public void notesTheRowSizeSelection() {
        waitFor(1);
        rowSize=Integer.parseInt(settingsPage.selectedRowSize.getAttribute("value"));
    }
    @Then("verifies that the last page is being viewed by using table information")
    public void verifiesThatTheLastPageIsBeingViewedByUsingTableInformation() {
        waitFor(1);
        settingsPage.verifyTableDisplayInfoForLastPage(rowSize);
    }
    @Then("verifies that the first page is being viewed by using table information")
    public void verifiesThatTheFirstPageIsBeingViewedByUsingTableInformation() {
        waitFor(1);
        settingsPage.verifyTableDisplayInfo(rowSize);
    }
    @Then("verifies that the next page is being viewed by using table information")
    public void verifiesThatTheNextPageIsBeingViewedByUsingTableInformation() {
        waitFor(1);
        settingsPage.verifyTableDisplayInfo(rowSize);
    }
    @Then("verifies that the previous page is being viewed by using table information")
    public void verifiesThatThePreviousPageIsBeingViewedByUsingTableInformation() {
        waitFor(1);
        settingsPage.verifyTableDisplayInfo(rowSize);
    }
    @And("verifies that {string} button is not active anymore")
    public void verifiesThatButtonIsNotActiveAnymore(String buttonName) {
        actions.release().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@title='"+buttonName+"']/button")).getAttribute("class").contains("disabled"));
    }
    @And("verifies that {string} button is active")
    public void verifiesThatButtonIsActive(String buttonName) {
        actions.release().perform();
        Assert.assertFalse(driver.findElement(By.xpath("//span[@title='"+buttonName+"']/button")).getAttribute("class").contains("disabled"));
    }
    @When("clicks on arrow button next to {string}")
    public void clicksOnArrowButtonNextTo(String column) {
        settingsPage.getSortDirectionBtn(column).click();
    }
    @When("double clicks on arrow button next to {string}")
    public void doubleClicksOnArrowButtonNextTo(String column) {
        settingsPage.getSortDirectionBtn(column).click();
        waitForPageToLoad(2);
        settingsPage.getSortDirectionBtn(column).click();
    }
    @Then("verifies that {string} arrow is displayed next to {string}")
    public void verifiesThatArrowIsDisplayedNextTo(String sortDirection, String column) {
        waitFor(2);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+column.toUpperCase()+"']//../span")).getAttribute("class").contains(sortDirection));
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+column.toUpperCase()+"']//..")).getAttribute("class").contains("active"));
    }
    @Then("verifies that the table is sorted in {string} order by the {string} column")
    public void verifiesThatTheTableIsSortedInOrderByTheColumn(String sortDirection, String column) {
        waitFor(2);
        Assert.assertTrue(settingsPage.verifySorting(sortDirection,column));
    }
}