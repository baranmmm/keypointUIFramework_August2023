package talrise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import talrise.utilities.CommonSteps;
import talrise.utilities.ConfigurationReader;

public class ProfileStepDefs extends CommonSteps {

    @Given("the {string} logs in successfully")
    public void theLogsInSuccessfully(String role) throws Exception {
        driver.get(ConfigurationReader.get("environmentUrl"));
        if(role.equalsIgnoreCase("candidate") || role.equalsIgnoreCase("superadmin")){
            role = role+ "_email";
            loginPage.emailTxtbox.sendKeys(ConfigurationReader.get(role));
        }
        else{
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
        waitForVisibility(driver.findElement(By.xpath("//h2[contains(.,'"+profileSection+"')]")),15);
        Assert.assertTrue(profilePage.isProfileSectionHeaderVisible(profileSection));
    }
}
