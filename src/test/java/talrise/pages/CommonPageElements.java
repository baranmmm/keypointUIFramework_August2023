package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import talrise.utilities.CommonSteps;
import talrise.utilities.Driver;

import java.time.Duration;

public abstract class CommonPageElements extends Driver {
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "demo-customized-button")
    public WebElement profileNameBtn;

    @FindBy(css = "[data-testid=\"LogoutIcon\"]")
    public WebElement logoutBtn;


    public void goToLeftMenuOption(String leftMenuOption){
        driver.findElement(By.xpath("//span[.='"+leftMenuOption+"']")).click();
    }

    public WebElement getLeftMenuOptionElement(String option){
        return driver.findElement(By.xpath("//span[text()='"+option+"']"));
    }

    public static void clickOnButton(String buttonText){
        try{
            driver.findElement(By.xpath("//button[.='"+buttonText+"']".toUpperCase())).click();
        }catch (Exception e){
            String buttonTextInitial = buttonText.charAt(0)+"";
            buttonTextInitial = buttonTextInitial.toUpperCase();
            String buttonTextRemaining = buttonText.substring(1).toLowerCase();
            buttonText = buttonTextInitial+buttonTextRemaining;
            String buttonLocator = "//button[text()='"+buttonText+"']";
            CommonSteps.scrollToElement(driver.findElement(By.xpath(buttonLocator)));
            driver.findElement(By.xpath(buttonLocator)).click();

        }

    }

    public void changeTablePage(String pageName){
        try {
            WebElement tableNavigationBtn = getTableNavigationBtn(pageName);
            CommonSteps.scrollToElement(tableNavigationBtn);
            CommonSteps.waitFor(2);
            tableNavigationBtn.click();
        }catch (Exception e){
            WebElement tableNavigationBtn2 = getTableNavigationBtn(pageName);
            CommonSteps.scrollToElement(tableNavigationBtn2);
            CommonSteps.waitFor(2);
            tableNavigationBtn2.click();
        }
    }

    public WebElement getTableNavigationBtn(String buttonName){
        return driver.findElement(By.xpath("//span[@title='"+buttonName+"']"));
    }



}
