package talrise.step_definitions.candidate.firstLoginProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import talrise.utilities.CommonSteps;

import java.util.Random;

import static org.junit.Assert.*;

public class PersonalInfoStepDefs extends CommonSteps {

    Random random = new Random();

    @Then("verifies * icon is visible upon First Name,Last Name,Linkedin and Email address fields")
    public void verifiesIconIsVisibleUponFirstNameLastNameLinkedinAndEmailAddressFields() {
        assertTrue(firstLoginPersonalInfoPage.firstNameLabel.getText().contains("*"));
        assertTrue(firstLoginPersonalInfoPage.lastNameLabel.getText().contains("*"));
        assertTrue(firstLoginPersonalInfoPage.linkedinLabel.getText().contains("*"));
        assertTrue(firstLoginPersonalInfoPage.emailLabel.getText().contains("*"));

    }

    @Then("verifies First Name,Last Name,Linkedin and Email address fields are automatically filled in.")
    public void verifiesFirstNameLastNameLinkedinAndEmailAddressFieldsAreAutomaticallyFilledIn() {
        for(WebElement w : firstLoginPersonalInfoPage.personalInfoReadOnlyFields){
            assertNotNull(w.getAttribute("value"));
        }
    }

    @Then("verifies First Name,Last Name,Linkedin and Email address fields are non-editable.")
    public void verifiesFirstNameLastNameLinkedinAndEmailAddressFieldsAreNonEditable() {
        for(WebElement w : firstLoginPersonalInfoPage.personalInfoReadOnlyFields){
            //System.out.println(w.getAttribute("readonly"));//true  placeholder readonly type=text ??
            //assertTrue(personalInfoPage.firstName.getAttribute("readonly"),true);
            assertNotNull(w.getAttribute("readonly"));
            //If the "readonly" attribute is present and has a value, it returns that value as a String.
            //If the "readonly" attribute is present but has no value (empty string), it returns an empty String.
            //If the "readonly" attribute is not present on the element, it returns null.
        }
    }

    @And("clicks on Country menu and selects {string}")
    public void clicksOnCountryMenuAndSelects(String country) {
        personalInfoPage.countryInputBox.click();
        waitFor(2);
        if(country.equals("None")){
            personalInfoPage.noneOption.click();
        }else {
            int randomCountryIndex = random.nextInt(personalInfoPage.countryDropdowns.size());
            personalInfoPage.countryDropdowns.get(randomCountryIndex).click();
        }
        waitFor(2);
    }

    @Then("verifies that City dropdown menu does not activate")
    public void verifiesThatCityDropdownMenuDoesNotActivate() {
        assertTrue(Boolean.parseBoolean(personalInfoPage.cityInput.getAttribute("aria-disabled")));//sadece disabled yeterli mi?
    }

    @Then("verifies City menu activates")
    public void verifiesCityMenuActivates() {
        personalInfoPage.cityInput.click();
        waitFor(1);
        assertTrue(Boolean.parseBoolean(personalInfoPage.cityInput.getAttribute("aria-expanded")));
        firstLoginPersonalInfoPage.cityBackDropDown.click();
        waitFor(1);
    }

    @And("clicks on City menu and selects {string}")
    public void clicksOnCityMenuAndSelects(String city) {
        personalInfoPage.cityInput.click();
        waitFor(1);
        if(city.equals("None")){
            personalInfoPage.noneOption.click();
        }else{
            int randomCityIndex = random.nextInt(personalInfoPage.cityDropdowns.size());
            personalInfoPage.cityDropdowns.get(randomCityIndex).click();
        }
        waitFor(2);
    }

    @And("clicks on Country Code menu and selects {string}")
    public void clicksOnCountryCodeMenuAndSelects(String countryCode) {
        personalInfoPage.countryCodeDropdown.click();
        waitFor(1);
        if(countryCode.equals("None")){
            personalInfoPage.noneOption.click();
        }else {
            personalInfoPage.countryCodeDropdownOptions.get(1).click();
        }
    }
    @And("enters {string} in Mobile field")
    public void entersInMobileField(String phoneNumber) {
        personalInfoPage.mobileInputBox.sendKeys(Keys.CONTROL, "a",Keys.BACK_SPACE);
        waitFor(1);
        if(phoneNumber.equals("7-digit mobile phone number")){
            personalInfoPage.mobileInputBox.sendKeys("1234567");
        } else if (phoneNumber.equals("14-digit mobile phone number")) {
            personalInfoPage.mobileInputBox.sendKeys("12345671234567");
        }else {
            personalInfoPage.mobileInputBox.sendKeys(phoneNumber);
        }
    }

    @Then("verifies {string} is seen")
    public void verifiesIsSeen(String warningMessage) {
        assertEquals(firstLoginPersonalInfoPage.mobileWarningMessage.getText(),warningMessage);
    }

    @And("leaves Mobile Phone field blank")
    public void leavesMobilePhoneFieldBlank() {
        personalInfoPage.mobileInputBox.sendKeys(Keys.CONTROL, "a",Keys.BACK_SPACE);
        waitFor(1);
    }

    @Then("verifies circle next to {string} on the left menu has a tick symbol")

    public void verifiesCircleNextToHasATickSymbol(String option) {

       String actualSymbol = firstLoginPersonalInfoPage.getLeftMenuOptionElement(option).getAttribute("data-testid");

       assertTrue(actualSymbol.contains("CheckCircleIcon")); //commonSteps

    }

    @Then("verifies circle next to {string} with green tick symbol is visible")
    public void verifiesCircleNextToWithGreenTickSymbolIsVisible(String arg0) {
    }

}
