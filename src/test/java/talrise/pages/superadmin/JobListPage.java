package talrise.pages.superadmin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import talrise.pages.CommonPageElements;
import talrise.utilities.ConfigurationReader;
import talrise.utilities.Log;

public class JobListPage extends CommonPageElements {
    @FindBy(id="email")
    public WebElement adminEmail;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.= 'Activity']")
    public WebElement activity;

    @FindBy(xpath = "//span[.= 'Jobs']")
    public WebElement jobs;

    @FindBy(xpath = "//span[.= 'Jobs List']")
    public WebElement jobsList;

    @FindBy(xpath = "//div[text()='COMPANY NAME']")
    public WebElement companyName;

    @FindBy(xpath = "//div[text()='JOB TITLE']")
    public WebElement jobTitle;

    @FindBy(xpath = "//div[text()='JOB DETAILS']")
    public WebElement jobDetails;

    @FindBy(xpath = "//div[text()='STATUS]")
    public WebElement status;

    @FindBy(xpath = "//div[text()='SALARY']")
    public WebElement salary;

    @FindBy(xpath = "//div[text()='EMPLOYMENT TYPE']")
    public WebElement employmentType;

    @FindBy(xpath = "//div[text()='PUBLISHED DATE']")
    public WebElement publishedDate;

    @FindBy(xpath = "//div[text()='CLOSING DATE']")
    public WebElement closingDate;

    @FindBy(xpath = "(//div/button/img)[1]")
    public WebElement kambanIcon;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath = "//span[.='search']")
    public WebElement searchIcon;

    @FindBy(xpath = "(//li[@role='option'])[1]")
    public WebElement option5;

    @FindBy(xpath = "(//li[@role='option'])[2]")
    public WebElement option10;

    @FindBy(xpath = "(//li[@role='option'])[3]")
    public WebElement option20;

    @FindBy(xpath = "//*[@role='presentation']")
    public WebElement selectIcon;

    @FindBy(xpath = "//span[text()='chevron_right']")
    public WebElement nextPageIcon;

    @FindBy(xpath = "//span[@title='Previous Page']")
    public WebElement previousPage;

    @FindBy(xpath = "(//span[.='last_page'])[1]")
    public WebElement lastPage;

    @FindBy(xpath = "//span[@title='First Page']")
    public WebElement firstPage;

    @FindBy(xpath = "//span[text()='CREATE A NEW JOB']")
    public WebElement createNewJobButton;

    @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-caption']")
    public WebElement pagination;

    @FindBy(xpath = "//tbody[@class='MuiTableBody-root']")
    public WebElement table;

    public void VerifyRowCounts(int expectedRowCount){
        int actualRowCount = table.findElements(By.tagName("tr")).size();
        Assert.assertEquals(expectedRowCount,actualRowCount);
        System.out.println("actualRowCount = " + actualRowCount); // actualRowCount = 5

    }
    public void ClicksOnTheChevron(String page){
        WebElement chevron = driver.findElement(By.xpath("//span[text()='"+page+"']"));
        chevron.click();
    }


}
