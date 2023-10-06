package talrise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;

import java.util.*;

public class PersonalInfoStepDef extends CommonSteps {


    @When("User on the {string} page,sees {string} menu available")
    public void user_on_the_page_sees_menu_available(String profile, String PersonalInformation) {
     personalInfoPage.profileSideMenu.click();
     waitForPageToLoad(3);

     for (WebElement menu : personalInfoPage.menus) {
            System.out.println("menu = " + menu.getText());

            if(menu.getText().equals("Personal Information")){
                Assert.assertEquals(menu.getText(),"Personal Information");
            }
        }


   }
    @When("User click on the pen icon,the menu expends")
    public void user_click_on_the_pen_icon_the_menu_expends() {

waitForPageToLoad(3);
        int size1 = personalInfoPage.profileMenuPenIcons.size();
        System.out.println("size1 = " + size1);
        waitFor(3);
        personalInfoPage.personalInfoPenIcon.click();
        int size2 = personalInfoPage.profileMenuPenIcons.size();
        System.out.println("size2 = " + size2);
        Assert.assertTrue(size1==(size2+1));


    }
    @When("User clicks on arrow,the menu collapse")
    public void user_clicks_on_arrow_the_menu_collapse() {
        int size3 = personalInfoPage.profileMenuPenIcons.size();
        System.out.println("size3 = " + size3);
        personalInfoPage.personalInfoSideArrow.click();
        waitFor(3);
        int size4 = personalInfoPage.profileMenuPenIcons.size();
        System.out.println("size4 = " + size4);




    }
    @Then("User clicks on {string} menu expands again")
    public void user_clicks_on_menu_expands_again(String PersonalInformation) {

        personalInfoPage.personalInfoDropdown.click();

        Assert.assertEquals(PersonalInformation, personalInfoPage.personalInfoText.getText());
    }




    @Then("User sees {string}, {string}, {string},{string},{string}  elements")
    public void userSeesElements(String arg0, String arg1, String arg2, String arg3, String arg4) {

        List<String>args= Arrays.asList(arg0,arg1,arg2,arg3,arg4);

        for (int i = 0; i < personalInfoPage.personalInfoInputLabels.size(); i++) {
            String actualElement=personalInfoPage.personalInfoInputLabels.get(i).getText();
            waitFor(1);
            System.out.println("personalInfoPage.personalInfoInputLabels = " + personalInfoPage.personalInfoInputLabels.
                    get(i).getText());
            String expectedElement=args.get(i);
            System.out.println("expectedElement = " + expectedElement);
            Assert.assertEquals(expectedElement,actualElement);

        }

    }


    @Then("User sees {string},{string}and {string} elements dropdowns")
    public void userSeesAndElementsDropdowns(String arg0, String arg1, String arg2) {
        waitFor(2);
       // System.out.println(personalInfoPage.countryDropdown.getText());

       List<String>personalInfoDropdowns=Arrays.asList(personalInfoPage.countryDropdown.getText(),
              personalInfoPage.city.getText(),personalInfoPage.countryCode.getText());

        System.out.println("personalInfoDropdowns = " + personalInfoDropdowns);

        List<String>parameters=Arrays.asList(arg0,arg1,arg2);

        System.out.println("parameters = " + parameters);

       for (int i = 0; i < personalInfoDropdowns.size(); i++) {
            String actualElement=personalInfoDropdowns.get(i);
            System.out.println("actualElement = " + actualElement);
            waitFor(1);
            String expectedElement=parameters.get(i);
            System.out.println("expectedElement = " + expectedElement);

           Assert.assertEquals(expectedElement,actualElement);


        }


   }


    @And("User sees firstName,lastName,LinkedIn and E_mail information already given")
    public void userSeesFirstNameLastNameLinkedInAndEMailInformationAlreadyGiven(Map<String, String> userDatas) {

        scrollToElement(personalInfoPage.linkedIn);

        System.out.println("personalInfoPage.registeredInfo.get(1).getAttribute() = " +
                "" + personalInfoPage.registeredInfo.get(1).getAttribute("value"));

        List<String> userDatass = new ArrayList<>(userDatas.values());
        System.out.println("userDatass = " + userDatass);


        for (int i = 0; i < personalInfoPage.registeredInfo.size(); i++) {
         //  String actualValue= personalInfoPage.registeredInfo.get(i).getAttribute("value");
                    waitFor(1);
        Assert.assertEquals(userDatass.get(i),personalInfoPage.registeredInfo.get(i).getAttribute("value"));

      }


}



//
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

        System.out.println("personalInfoPage.linkedIn.getAttribute(\"readonly\") = "
                + personalInfoPage.linkedIn.getAttribute("readonly"));


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
        //personalInfoPage.countryInputBox.click(); see the warning element is not intractable
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

            System.out.println("personalInfoPage.cityDropdowns.size() = " + personalInfoPage.cityOfEnglandDropdowns.size());


        }

        @And("User clicks the Wales option {string} and {int} cities should be available to select in {string}dropdown.")
        public void userClicksTheWalesOptionAndCitiesShouldBeAvailableToSelectInDropdown (String arg0,int arg1, String
        arg2){
        personalInfoPage.noneOption.click();
        waitFor(1);

        doubleClickWithActions(personalInfoPage.countryDropDownArrow);

        waitFor(1);
        personalInfoPage.walesOption.click();
        personalInfoPage.cityInput.click();
            int actualSizeOfWalesCity = personalInfoPage.cityOfWalesDropdowns.size();
            System.out.println("actualSizeOfWalesCity = " + actualSizeOfWalesCity);

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
        System.out.println("actualSizeOfNorthernIcelandCity = " + actualSizeOfNorthernIrelandCity);

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
            System.out.println(actualSizeOfScotlandCity);

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
        System.out.println(actualSizeOfUKCity);

        int expectedSizeOfUkCity = arg1 + 1;
        Assert.assertEquals(expectedSizeOfUkCity, actualSizeOfUKCity);

    }

    }

