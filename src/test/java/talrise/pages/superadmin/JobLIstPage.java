package talrise.pages.superadmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobLIstPage {
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

    @FindBy(xpath = "(//span[.='arrow_downward'])[1]")
    public WebElement arrowForCompanyName;

    @FindBy(xpath = "(//span[.='arrow_downward'])[2]")
    public WebElement arrowForJobTitle;

    @FindBy(xpath = "(//span[.='arrow_downward'])[3]")
    public WebElement arrowForPublishedDate;

    @FindBy(xpath = "(//span[.='arrow_downward'])[4]")
    public WebElement arrowForClosingDate;

    @FindBy(xpath = "(//span[.='arrow_downward'])[5]")
    public WebElement arrowForEmploymentType;

    @FindBy(xpath = "(//span[.='arrow_downward'])[6]")
    public WebElement arrowForSalary;

    @FindBy(xpath = "(//span[.='arrow_downward'])[7]")
    public WebElement arrowForStatus;

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


}
