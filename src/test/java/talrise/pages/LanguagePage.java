package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LanguagePage extends CommonPageElements{

    @FindBy(xpath="//div[@class='sc-satoz goHDTn']/div/div[2]/button")
    public List<WebElement> languageSuggestedFields;


    @FindBy(xpath="(//div[@class='sc-Nxspf chrSeZ'])[3]/div/div/button")
    public List<WebElement> languageSelectedFields;


    @FindBy(xpath="//div[@label='Proficiency']//div[2]")
    public List<WebElement> languageProficienciesBoxes;


    @FindBy(xpath="//div[@class='MuiPaper-root MuiMenu-paper MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper css-pwxzbm']//ul//li")
    public List<WebElement> languageProficienciesFields;


    @FindBy(xpath="(//div[@class='sc-SrznA fNcrbv'])[6]/div[2]/button[2]")
    public WebElement languageSaveButton;


    @FindBy(xpath="(//div[@class='sc-SrznA fNcrbv'])[6]/div[2]/button[1]")
    public WebElement languageCancelButton;

    @FindBy(xpath="//input[@id=':rb:']")
    public WebElement languageTypeToSearchButton;


    @FindBy(xpath="//div[@class='sc-satoz goHDTn']/div/div[2]")
    public WebElement languageEmptySuggestedFields;

    @FindBy(xpath="//div[text()='Your language data has been submitted successfully.']")
    public WebElement languageAlertMessage;

    //save yaptıktan sonra locateler değişiyor
    @FindBy(xpath="//div[text()='Your language data has been submitted successfully.']")
    public WebElement languageSaveButtonAfterSave;


    public WebElement moduls(String modules){
        WebElement moduls=driver.findElement(By.xpath("//span[text()='"+modules+"']"));
        return moduls;
    }

}
