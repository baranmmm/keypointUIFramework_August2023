package talrise.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import talrise.pages.CommonPageElements;
import talrise.utilities.CommonSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PersonalInfoStepDef extends CommonSteps {

    Faker faker=new Faker();

    @When("User on the {string} page,sees {string} menu available")
    public void user_on_the_page_sees_menu_available(String profile, String PersonalInformation) {
     personalInfoPage.profileSideMenu.click();
     waitForPageToLoad(3);

//     Assert.assertEquals("http://20.108.75.9/profile",driver.getCurrentUrl());
//     Assert.assertEquals(PersonalInformation,personalInfoPage.personalInfoDropdown.getText());


     for (WebElement menu : personalInfoPage.menus) {
            if(menu.getText().equals(PersonalInformation)){
                Assert.assertEquals(PersonalInformation,menu.getText());
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
    public void userSeesAndElementsDropdowns(String country, String city, String countryCode) {
        waitFor(2);
        List<String>personalInfoDropdowns=Arrays.asList(personalInfoPage.countryDropdown.getText(),
                personalInfoPage.city.getText(),personalInfoPage.countryCode.getText());
        List<String>parameters=Arrays.asList(country,city,countryCode);
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
    public void dropdownMenuShouldBeOpenedAndIncludesOptions(String Country, String None,
                                                             String England, String Wales, String NorthernIreland, String Scotland, String UK )  {
        List<String > countryDropdownsExpected=Arrays.asList(None,England,Wales,NorthernIreland,Scotland,UK);

        for (int i = 0; i < personalInfoPage.countryDropdowns.size(); i++) {
            waitFor(1);
            Assert.assertEquals(countryDropdownsExpected.get(i),personalInfoPage.countryDropdowns.get(i).getText());
            String text=personalInfoPage.countryDropdowns.get(i).getText();
            waitFor(1);


        }
    }

    @And("User selects None option,City input box is not clickable")
    public void userSelectsNoneOptionCityInputBoxIsNotClickable() {
         personalInfoPage.noneOption.click();
         waitFor(1);
         Assert.assertTrue(personalInfoPage.cityInput.getAttribute("disabled"),true);

        }

    @And("User  leaves Country input box  empty City input box is not clickable")
    public void userLeavesCountryInputBoxEmptyCityInputBoxIsNotClickable() {

         personalInfoPage.countryInputBox.click();
         personalInfoPage.noneOption.click();

        Assert.assertTrue(personalInfoPage.cityInput.getAttribute("disabled"),true);
        }

    @And("User clicks the England option {string} and {int} cities should be available to select in City dropdown.")
    public void userClicksTheEnglandOptionAndCitiesShouldBeAvailableToSelectInCityDropdown(String none, int cityAmount) {
        personalInfoPage.countryInputBox.click();
        personalInfoPage.englandOption.click();
        waitForClickability(personalInfoPage.cityInput, 2);
        personalInfoPage.cityInput.click();
        int actualCitySize=personalInfoPage.cityDropdowns.size();
        int expectedCitySize=cityAmount+1;
        Assert.assertEquals(expectedCitySize,actualCitySize);
        }

    @And("User clicks the Wales option {string} and {int} cities should be available to select in City dropdown.")
    public void userClicksTheWalesOptionAndCitiesShouldBeAvailableToSelectInCityDropdown(String none, int cityAmount){
        personalInfoPage.noneOption.click();
        waitFor(1);
        personalInfoPage.countryInputBox.click();
        waitFor(1);
        personalInfoPage.walesOption.click();
        personalInfoPage.cityInput.click();
        int actualSizeOfWalesCity = personalInfoPage.cityDropdowns.size();
        int expectedSizeOfWalesCity=cityAmount+1;

        Assert.assertEquals(expectedSizeOfWalesCity,actualSizeOfWalesCity);
        }

    @And("User clicks the Northern Ireland option {string} and {int} cities should be available to select in City dropdown.")
    public void userClicksTheNorthernIrelandOptionAndCitiesShouldBeAvailableToSelectInCityDropdown(String none, int numberOfCity) {

        personalInfoPage.noneOption.click();
        waitFor(1);
        personalInfoPage.countryInputBox.click();
        waitFor(1);
        personalInfoPage.northernIrelandOption.click();
        personalInfoPage.cityInput.click();
       int actualSizeOfNorthernIrelandCity = personalInfoPage.cityDropdowns.size();
       int expectedSizeOfNorthernIcelandCity=numberOfCity+1;
       Assert.assertEquals(expectedSizeOfNorthernIcelandCity,actualSizeOfNorthernIrelandCity);
    }

    @And("User clicks the Scotland option {string} and {int} cities should be available to select in City dropdown.")
    public void userClicksTheScotlandOptionAndCitiesShouldBeAvailableToSelectInCityDropdown(String none, int numberOfCity) {

            personalInfoPage.noneOption.click();
            waitFor(1);
            personalInfoPage.countryInputBox.click();
            waitFor(1);
            personalInfoPage.scotlandOption.click();
            personalInfoPage.cityInput.click();
            int actualSizeOfScotlandCity = personalInfoPage.cityDropdowns.size();
            int expectedSizeOfScotlandCity =numberOfCity+1;
            Assert.assertEquals(expectedSizeOfScotlandCity,actualSizeOfScotlandCity);
        }


    @And("User  clicks the UK option {string} and {int} city should be available to select in City dropdown.")
    public void userClicksTheUKOptionAndCityShouldBeAvailableToSelectInCityDropdown(String none, int amountOfCity) {

        personalInfoPage.noneOption.click();
        waitFor(1);
        personalInfoPage.countryInputBox.click();
        waitFor(1);
        personalInfoPage.uKOption.click();
        personalInfoPage.cityInput.click();
        int actualSizeOfUKCity = personalInfoPage.cityDropdowns.size();
        int expectedSizeOfUkCity = amountOfCity + 1;
        Assert.assertEquals(expectedSizeOfUkCity, actualSizeOfUKCity);

    }


    @When("user clicks on Country Code input box")
    public void userClicksOnCountryCodeInputBox() {

       personalInfoPage.countryCode.click();

    }

@And("user sees {string} and {string} options")
public void userSeesAndOptions(String none, String ukCode) {

        List<String> parameters=Arrays.asList(none,ukCode);
        for (int i = 0; i < personalInfoPage.countryCodeDropdownOptions.size(); i++) {
            Assert.assertEquals(parameters.get(i),personalInfoPage.countryCodeDropdownOptions.get(i).getText());


        }

    }


    @When("User enter {string}digits less than seven and more than fourteen or Mobile number must include only digits.non-numeric  sees {string}")
    public void user_enter_digits_less_than_seven_and_more_than_fourteen_or_mobile_number_must_include_only_digits_non_numeric_sees(String invalidCredential, String warningMessage)
    {

        waitFor(2);
        actions.doubleClick(personalInfoPage.mobileInputBox).perform();
        personalInfoPage.mobileInputBox.sendKeys(Keys.BACK_SPACE);
        personalInfoPage.mobileInputBox.clear();
        personalInfoPage.mobileInputBox.sendKeys(invalidCredential);
        waitFor(1);
        String actualWarningMessage=personalInfoPage.warningMessage.getAttribute("textContent");

        String expectedWarningMessage=warningMessage;
        assert expectedWarningMessage.equals(actualWarningMessage);


    }


    @And("User enter {string}digits between seven and fourteen in mobile input box and click save button")
    public void userEnterDigitsBetweenSevenAndFourteenInMobileInputBoxAndClickSaveButton(String validCredentials) {

        waitFor(2);
        actions.doubleClick(personalInfoPage.mobileInputBox).perform();
        personalInfoPage.mobileInputBox.sendKeys(Keys.BACK_SPACE);
        personalInfoPage.mobileInputBox.clear();
        personalInfoPage.mobileInputBox.sendKeys(validCredentials);
        waitFor(2);
        personalInfoPage.saveButton.click();


    }
    @When("User sees {string}")
    public void user_sees(String successMessage) {

        waitFor(1);
        String actualSuccessMessage=personalInfoPage.successMessage.getAttribute("textContent");
        String expectedSuccessMessage=successMessage;
        Assert.assertTrue(expectedSuccessMessage.equals(actualSuccessMessage));


    }

    @Then("User sees new saved information on the overview page")
    public void userSeesNewSavedInformationOnTheOverviewPage() {
        String phoneNumberOnPersonalInfPage = personalInfoPage.countryCodeDropdown.
                getAttribute("innerText")+" "+ personalInfoPage.mobileInputBox.getAttribute("value");

        scrollToElement(personalInfoPage.overviewButton);
        personalInfoPage.overviewButton.click();

        waitFor(1);
        String phoneNumberOnOverviewPage = overviewPage.phoneNumber.getText();

        Assert.assertEquals(phoneNumberOnOverviewPage, phoneNumberOnPersonalInfPage);


    }
    String cityAndCountryOnPersonalInfo;
    String phoneNumberOnPersonalInfPage;

    @And("User sees saved information on the personal information page and validates")
    public void userSeesSavedInformationOnThePersonalInformationPageAndValidates() {
        waitForPageToLoad(7);
        String fullNameOnPersonalInfo=personalInfoPage.firstName.getAttribute("value")+" "+
                personalInfoPage.lastName.getAttribute("value");
        String linkedinOnPersonalInfo=personalInfoPage.linkedIn.getAttribute("value");
          cityAndCountryOnPersonalInfo= personalInfoPage.cityInput.getAttribute("innerText")+"/"+personalInfoPage.countryInputBox
                        .getAttribute("innerText");
        String emailOnPersonalInfo=personalInfoPage.email.getAttribute("value");

          phoneNumberOnPersonalInfPage = personalInfoPage.countryCodeDropdown.getAttribute("textContent").trim()
                 +"  "+personalInfoPage.mobileInputBox.getAttribute("value").trim();


//        System.out.println("fullNameOnPersonalInfo = " + fullNameOnPersonalInfo);
//        System.out.println("linkedinOnPersonalInfo = " + linkedinOnPersonalInfo);
//        System.out.println("cityAndCountryOnPersonalInfo = " + cityAndCountryOnPersonalInfo);
//        System.out.println("emailOnPersonalInfo = " + emailOnPersonalInfo);
//        System.out.println("phoneNumberOnPersonalInfPage = " + phoneNumberOnPersonalInfPage);

        scrollToElement(personalInfoPage.overviewButton);
        personalInfoPage.overviewButton.click();

        waitFor(1);
        String fullNameOnOverviewPage = overviewPage.fullName.getText();
        String linkedinOnOverviewPage = overviewPage.linkedin.getText();
        String cityAndCountryOnOverviewPage = overviewPage.cityAndCountry.getText();
        String emailOnOnOverviewPage = overviewPage.email.getText();
        String phoneNumberOnOverviewPage = (overviewPage.phoneNumber.getAttribute("textContent")).trim();

        waitFor(2);

        Assert.assertEquals(fullNameOnPersonalInfo,fullNameOnOverviewPage);
        Assert.assertEquals(linkedinOnPersonalInfo,linkedinOnOverviewPage);
        Assert.assertEquals(cityAndCountryOnPersonalInfo,cityAndCountryOnOverviewPage);
        Assert.assertEquals(emailOnPersonalInfo,emailOnOnOverviewPage);
         Assert.assertEquals(phoneNumberOnPersonalInfPage,phoneNumberOnOverviewPage);




    }


    @And("User is back to the personal information page")
    public void userIsBackToThePersonalInformationPage() {

        CommonPageElements.clickOnButton("BACK");
        personalInfoPage.personalInfoDropdown.click();



    }

    @And("User change country,city,country code and mobile information")
    public void userChangeCountryCityCountryCodeAndMobileInformation() {


        waitFor(1);
        personalInfoPage.countryInputBox.click();
        waitFor(1);
        personalInfoPage.getRandomCountry().click();
        waitFor(1);

        personalInfoPage.cityInput.click();
         waitFor(1);

        List<WebElement> cityDropdownsWithoutNone = personalInfoPage.getCityDropdownsWithoutNone(personalInfoPage.cityDropdowns);
        personalInfoPage.getRandomData(cityDropdownsWithoutNone).click();
        waitFor(1);

        personalInfoPage.countryCodeDropdown.click();
        waitFor(1);
        personalInfoPage.uKCountryCode.click();

        waitFor(1);
        actions.doubleClick(personalInfoPage.mobileInputBox).perform();
        personalInfoPage.mobileInputBox.sendKeys(Keys.BACK_SPACE);
        personalInfoPage.mobileInputBox.clear();
        personalInfoPage.mobileInputBox.sendKeys(faker.number().digits(8));


    }

    @And("User click on save button and get success message {string}")
    public void userClickOnSaveButtonAndGetSuccessMessage(String expectedSuccessMessage) {

        clickWithJS(personalInfoPage.saveButton);
        waitFor(1);
        String actualSuccessMessage=personalInfoPage.successMessage.getAttribute("textContent");

        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);


    }


    @And("User on the personal information page")
    public void userOnThePersonalInformationPage() {
        driver.navigate().refresh();
        personalInfoPage.personalInfoDropdown.click();
    }

    @And("User click on cancel button")
    public void userClickOnCancelButton() {
        personalInfoPage.canselButton.click();



    }


    @And("User sees and validate that country,city,country code and mobile information changes turns to last saved version")
    public void userSeesAndValidateThatCountryCityCountryCodeAndMobileInformationChangesTurnsToLastSavedVersion() {
        String cityAndCountryOnPersonalInfoAfterClickingCancel= personalInfoPage.cityInput.getAttribute("innerText")+"/"+personalInfoPage.countryInputBox
                .getAttribute("innerText");
        String phoneNumberOnPersonalInfPageAfterClickingCancel=personalInfoPage.countryCodeDropdown.getAttribute("textContent").trim()
                +"  "+personalInfoPage.mobileInputBox.getAttribute("value").trim();
//        System.out.println("............................");
//        System.out.println("phoneNumberOnPersonalInfPage = " + phoneNumberOnPersonalInfPage);
//        System.out.println("phoneNumberOnPersonalInfPageAfterClickingCancel = " + phoneNumberOnPersonalInfPageAfterClickingCancel);
//        System.out.println("cityAndCountryOnPersonalInfo = " + cityAndCountryOnPersonalInfo);
//        System.out.println("cityAndCountryOnPersonalInfoAfterClickingCancel = " + cityAndCountryOnPersonalInfoAfterClickingCancel);
//


        Assert.assertEquals(cityAndCountryOnPersonalInfoAfterClickingCancel,cityAndCountryOnPersonalInfo);

        Assert.assertEquals(phoneNumberOnPersonalInfPageAfterClickingCancel,phoneNumberOnPersonalInfPage);



    }





}










