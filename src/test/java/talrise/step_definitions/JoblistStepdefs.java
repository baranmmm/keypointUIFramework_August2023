package talrise.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Wait;
import talrise.utilities.CommonSteps;
import talrise.utilities.ConfigurationReader;

public class JoblistStepdefs extends CommonSteps {

    @Given("User {string} logs in successfully")
    public void userLogsInSuccessfully(String superadminEmail) {
        driver.get(ConfigurationReader.get("environmentUrl"));
        jobListPage.adminEmail.sendKeys(ConfigurationReader.get(superadminEmail));
        jobListPage.password.sendKeys(ConfigurationReader.get("password"));
        jobListPage.loginButton.click();
    }


    @When("User navigates to jobList")
    public void userNavigatesToJobList() throws InterruptedException {
        jobListPage.activity.click();
        jobListPage.jobs.click();
        jobListPage.jobsList.click();
        waitFor(2);
    }


    @Then("Verify the page url contains {string}")
    public void verifyThePageUrlContains(String pageUrl){
       String joblistUrl = driver.getCurrentUrl();
        System.out.println(joblistUrl);
        Assert.assertTrue(joblistUrl.contains(pageUrl));
    }

    @Then("Column names should be displayed")
    public void columnNamesShouldBeDisplayed() {
        Assert.assertTrue(jobListPage.companyName.isDisplayed());
        Assert.assertTrue(jobListPage.jobTitle.isDisplayed());
        Assert.assertTrue(jobListPage.salary.isDisplayed());
        Assert.assertTrue(jobListPage.publishedDate.isDisplayed());
        Assert.assertTrue(jobListPage.closingDate.isDisplayed());
        Assert.assertTrue(jobListPage.jobDetails.isDisplayed());
        Assert.assertTrue(jobListPage.employmentType.isDisplayed());
        Assert.assertTrue(jobListPage.jobDetails.isDisplayed());

    }

    @Then("Verify the text contains {string}")
    public void verifyTheTextContains(String pagination) {
      String paginationText =  jobListPage.pagination.getText();
      Assert.assertTrue(paginationText.contains(pagination));

    }

    @Then("Default page size should be {int}")
    public void defaultPageSizeShouldBe(int rowCount) {
        jobListPage.VerifyRowCounts(rowCount);
    }

    @And("Clicks on the {string}")
    public void clicksOnThe(String chevron) {
        jobListPage.ClicksOnTheChevron(chevron);
        waitFor(1);
    }
}
