package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EducationPage extends CommonPageElements{


    @FindBy(xpath = "//label[.='University*']")
    public WebElement UniversityLabel;
    @FindBy(xpath = "//label[.='Degree*']")
    public WebElement DegreeLabel;
    @FindBy(xpath = "//label[.='Department*']")
    public WebElement DepartmentLabel;
    @FindBy(xpath = "//label[.='Start Year*']")
    public WebElement StartYearLabel;
    @FindBy(xpath = "//label[.='End Year']")
    public WebElement EndYearLabel;
    @FindBy(xpath = "//span[.='+ ADD EDUCATION']")
    public WebElement AddEducationButton;

    @FindBy(xpath = "(//span[text()='Delete'])[1]")
    public List<WebElement> deleteButton;

    @FindBy(xpath = "(//input[@id='university'])[1]")
    public WebElement UniversityButton;
    @FindBy(xpath = "//div[@id='educations[0].degreeId-select-input-id']")
    public WebElement DegreeButton;

    @FindBy(xpath = "//div[@id='educations[0].departmentId-select-input-id']")
    public WebElement DepartmentButton;

    @FindBy(xpath = "//div[@id='educations[0].startYear-select-input-id']")
    public WebElement StartYearButton;

    @FindBy(xpath = "//div[@id='educations[0].endYear-select-input-id']")
    public WebElement EndYearButton;

    @FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth Mui-focused MuiInputBase-formControl MuiInputBase-adornedEnd MuiAutocomplete-inputRoot css-segi59']")
    public List<WebElement> UniverstList;

    @FindBy(xpath = "//li")
    public List<WebElement> DropDownContext;
    public void DropDownContext(String value){
        driver.findElement(By.xpath("//li[.='"+value+"']")).click();

    }



    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium layout-button layout-save css-1hw9j7s'])[8]")
    public WebElement saveButton;




    public boolean warningMessages(String message){

      return   driver.findElement(By.xpath("//p[text()='"+message+"']")).isDisplayed();

    }

    public WebElement fields(String message){

        return driver.findElement(By.xpath("//p[text()='"+message+"']"));

    }

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[8]")
    public WebElement TypeToAddSearchButton;


    @FindBy(xpath = "//span[text()='ADD']")
    public WebElement AddButton;

    @FindBy(xpath = "//div[text()='Your Certificate has been saved successfully.']")
    public WebElement addButtonMessage;

    @FindBy(xpath = "//span[.='See More >']")
    public WebElement seeMoreText;

    @FindBy(xpath = "//span[.='See Less >']")
    public WebElement seeLessText;

    @FindBy(xpath = "//div[@class='sc-jdkBTo bGMLBu cert']")
    public List<WebElement> educationCertificates;

    @FindBy(xpath = "//div[@class='sc-jdkBTo bGMLBu containerAddedList']/div")
    public List<WebElement> educationSelectedCertificates;

    @FindBy(xpath = "//span[.='X']")
    public List<WebElement> xButton;


//    @FindBy(xpath = "(//div[@class='sc-SrznA fNcrbv'])[8]/div[2]/button[2]")
//    public WebElement educationSave;
//
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium layout-button layout-save css-1hw9j7s'])[8]")
    public WebElement educationSave;

    @FindBy(xpath = "(//div[.='Your education info has been added successfully.'])[6]")
    public WebElement addEducationMessage;



}
