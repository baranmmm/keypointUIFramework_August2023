package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import talrise.utilities.CommonSteps;
import talrise.utilities.Driver;

import java.util.List;
import java.util.Locale;

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
        List<WebElement> buttonList=driver.findElements(By.xpath("//button[.='"+buttonText+"']"));
        List<WebElement> spanList=driver.findElements(By.xpath("//span[.='"+buttonText+"']"));
        if (buttonList.size()>0) {
            try {
                driver.findElement(By.xpath("//button[.='" + buttonText + "']".toUpperCase())).click();
            } catch (Exception e) {
                String buttonTextInitial = buttonText.charAt(0) + "";
                buttonTextInitial = buttonTextInitial.toUpperCase();
                String buttonTextRemaining = buttonText.substring(1).toLowerCase();
                buttonText = buttonTextInitial + buttonTextRemaining;
                String buttonLocator = "//button[text()='" + buttonText + "']";
                CommonSteps.scrollToElement(driver.findElement(By.xpath(buttonLocator)));
                driver.findElement(By.xpath(buttonLocator)).click();

            }
        }else if(spanList.size()>0){
            driver.findElement(By.xpath("//span[.='"+buttonText+"']"));
        }

    }



}
