package talrise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import talrise.utilities.CommonSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PersonalInfoStepDef extends CommonSteps {

    @When("User on the {string} page,sees {string} menu available")
    public void user_on_the_page_sees_menu_available(String profile, String PersonalInformation) {
     personalInfoPage.profileSideMenu.click();
     waitForPageToLoad(3);
     for (WebElement menu : personalInfoPage.menus) {
            if(menu.getText().equals("Personal Information")){
                Assert.assertEquals(menu.getText(),"Personal Information");
            }
        }
   }

    @When("User click on the pen icon,the menu expends")
    public void user_click_on_the_pen_icon_the_menu_expends() {
        waitForPageToLoad(3);
        int size1 = personalInfoPage.profileMenuPenIcons.size();
        waitFor(3);
        personalInfoPage.personalInfoPenIcon.click();
        int size2 = personalInfoPage.profileMenuPenIcons.size();
        Assert.assertTrue(size1==(size2+1));
    }

    @When("User clicks on arrow,the menu collapse")
    public void user_clicks_on_arrow_the_menu_collapse() {
        int size3 = personalInfoPage.profileMenuPenIcons.size();
        personalInfoPage.personalInfoSideArrow.click();
        waitFor(3);
        int size4 = personalInfoPage.profileMenuPenIcons.size();
    }

    @Then("User clicks on {string} menu expands again")
    public void user_clicks_on_menu_expands_again(String PersonalInformation) {
        personalInfoPage.personalInfoDropdown.click();
         waitFor(1);
        Assert.assertEquals(PersonalInformation, personalInfoPage.personalInfoText.getText());
    }

    @Then("User sees {string}, {string}, {string},{string},{string}  elements")
    public void userSeesElements(String firstname, String lastname, String linkedIn, String email, String mobile) {
        List<String>args= Arrays.asList(firstname,lastname,linkedIn,email,mobile);
        waitFor(1);
        for (int i = 0; i < personalInfoPage.personalInfoInputLabels.size(); i++) {
            String actualElement=personalInfoPage.personalInfoInputLabels.get(i).getText();
            String expectedElement=args.get(i);
            Assert.assertEquals(expectedElement,actualElement);
        }
    }

    @Then("User sees {string},{string}and {string} elements dropdowns")
    public void userSeesAndElementsDropdowns(String arg0, String arg1, String arg2) {
        waitFor(2);
        List<String>personalInfoDropdowns=Arrays.asList(personalInfoPage.countryDropdown.getText(),
                personalInfoPage.city.getText(),personalInfoPage.countryCode.getText());
        List<String>parameters=Arrays.asList(arg0,arg1,arg2);
        for (int i = 0; i < personalInfoDropdowns.size(); i++) {
            String actualElement=personalInfoDropdowns.get(i);
            waitFor(1);
            String expectedElement=parameters.get(i);
           Assert.assertEquals(expectedElement,actualElement);
        }
   }

    @And("User sees firstName,lastName,LinkedIn and E_mail information already given")
    public void userSeesFirstNameLastNameLinkedInAndEMailInformationAlreadyGiven(Map<String, String> userDatas) {
        scrollToElement(personalInfoPage.linkedIn);
        List<String> userDatass = new ArrayList<>(userDatas.values());
        for (int i = 0; i < personalInfoPage.registeredInfo.size(); i++) {
            waitFor(1);
            Assert.assertEquals(userDatass.get(i),personalInfoPage.registeredInfo.get(i).getAttribute("value"));
        }
    }

//    @And("User sees {string},{string},{string} and {string} information already given")
//    public void userSeesAndInformationAlreadyGiven(String firstName , String lastName, String LinkedIn, String E_mail) {
//
//        Assert.assertEquals(ConfigurationReader.get("firstName"),personalInfoPage.firstName.getAttribute("value"));
//        Assert.assertEquals(ConfigurationReader.get("lastName"),personalInfoPage.lastName.getAttribute("value"));
//        Assert.assertEquals(ConfigurationReader.get("LinkedIn"),personalInfoPage.linkedIn.getAttribute("value"));
//        Assert.assertEquals(ConfigurationReader.get("E_mail"),personalInfoPage.email.getAttribute("value"));
//
//
//    }

    @Then("User cannot change registered information")
    public void userCannotChangeRegisteredInformation() {
        //Boolean firstName=personalInfoPage.firstName.getAttribute("readOnly").
        Assert.assertTrue(personalInfoPage.firstName.getAttribute("readonly"),true);
        Assert.assertTrue(personalInfoPage.lastName.getAttribute("readonly"),true);
        Assert.assertTrue(personalInfoPage.linkedIn.getAttribute("readonly"),true);
        Assert.assertTrue(personalInfoPage.email.getAttribute("readonly"),true);
    }

    @When("User clicks {string} input box")
    public void userClicksInputBox(String Country) {
    scrollToElement(personalInfoPage.countryInputBox);
    personalInfoPage.countryInputBox.click();
    }

    @And("{string} dropdown menu should be opened and includes {string}, {string},{string},{string}, {string}, {string} options.")
    public void dropdownMenuShouldBeOpenedAndIncludesOptions(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)  {
        List<String > countryDropdowns=Arrays.asList(arg1,arg2,arg3,arg4,arg5,arg6);
        for (int i = 0; i < personalInfoPage.countryDropdowns.size(); i++) {
            waitFor(1);
            Assert.assertEquals(countryDropdowns.get(i),personalInfoPage.countryDropdowns.get(i).getText());
        }
    }

    @And("User selects {string} option,{string}input box is not clickable")
    public void userSelectsOptionInputBoxIsNotClickable(String arg0, String arg1) {
            personalInfoPage.noneOption.click();
            waitFor(1);
            Assert.assertTrue(personalInfoPage.cityInput.getAttribute("disabled"),true);
        }

        @And("User  leaves {string} input box  empty {string} input box is not clickable")
        public void userLeavesInputBoxEmptyInputBoxIsNotClickable (String arg0, String arg1){
        personalInfoPage.countryInputBox.click();
        Assert.assertTrue(personalInfoPage.cityInput.getAttribute("disabled"),true);
        }

        @And("User clicks the England option {string} and {int} cities should be available to select in {string}dropdown.")
        public void userClicksTheEnglandOptionAndCitiesShouldBeAvailableToSelectInDropdown (String arg0,int arg1, String
        arg2){
        personalInfoPage.englandOption.click();
        waitForClickability(personalInfoPage.cityInput, 2);
        personalInfoPage.cityInput.click();
        int actualCitySize=personalInfoPage.cityOfEnglandDropdowns.size();
        int expectedCitySize=arg1+1;
        Assert.assertEquals(expectedCitySize,actualCitySize);
        }

        @And("User clicks the Wales option {string} and {int} cities should be available to select in {string}dropdown.")
        public void userClicksTheWalesOptionAndCitiesShouldBeAvailableToSelectInDropdown (String arg0,int arg1, String
        arg2){
        personalInfoPage.noneOption.click();
        waitFor(1);
        personalInfoPage.countryInputBox.click();
        waitFor(1);
        personalInfoPage.walesOption.click();
        personalInfoPage.cityInput.click();
        int actualSizeOfWalesCity = personalInfoPage.cityOfWalesDropdowns.size();
        int expectedSizeOfWalesCity=arg1+1;
        Assert.assertEquals(expectedSizeOfWalesCity,actualSizeOfWalesCity);
        }

    @And("User clicks the Northern Ireland option {string} and {int} cities should be available to select in {string}dropdown.")
    public void userClicksTheNorthernIrelandOptionAndCitiesShouldBeAvailableToSelectInDropdown(String arg0, int arg1, String arg2) {
        personalInfoPage.noneOption.click();
        waitFor(1);
        personalInfoPage.countryInputBox.click();
        waitFor(1);
        personalInfoPage.northernIrelandOption.click();
        personalInfoPage.cityInput.click();
       int actualSizeOfNorthernIrelandCity = personalInfoPage.cityOfNorthernIcelandDropdowns.size();
       int expectedSizeOfNorthernIcelandCity=arg1+1;
       Assert.assertEquals(expectedSizeOfNorthernIcelandCity,actualSizeOfNorthernIrelandCity);
    }

        @And("User clicks the Scotland option {string} and {int} cities should be available to select in {string}dropdown.")
        public void userClicksTheScotlandOptionAndCitiesShouldBeAvailableToSelectInDropdown (String arg0,
        int arg1, String arg2){
            personalInfoPage.noneOption.click();
            waitFor(1);
            personalInfoPage.countryInputBox.click();
            waitFor(1);
            personalInfoPage.scotlandOption.click();
            personalInfoPage.cityInput.click();
            int actualSizeOfScotlandCity = personalInfoPage.scotlandDropdowns.size();
            int expectedSizeOfScotlandCity =arg1+1;
            Assert.assertEquals(expectedSizeOfScotlandCity,actualSizeOfScotlandCity);
        }


    @And("User  clicks the UK option {string} and {int} cities should be available to select in {string}dropdown.")
    public void userClicksTheUKOptionAndCitiesShouldBeAvailableToSelectInDropdown(String arg0, int arg1, String arg2) {
        personalInfoPage.noneOption.click();
        waitFor(1);
        personalInfoPage.countryInputBox.click();
        waitFor(1);
        personalInfoPage.uKOption.click();
        personalInfoPage.cityInput.click();
        int actualSizeOfUKCity = personalInfoPage.uKDropdowns.size();
        int expectedSizeOfUkCity = arg1 + 1;
        Assert.assertEquals(expectedSizeOfUkCity, actualSizeOfUKCity);

    }

    }

