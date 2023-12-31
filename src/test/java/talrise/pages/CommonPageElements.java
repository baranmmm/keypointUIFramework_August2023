package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import talrise.utilities.CommonSteps;
import talrise.utilities.Driver;

import java.util.Locale;

public abstract class CommonPageElements extends Driver {
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }

    public void goToLeftMenuOption(String leftMenuOption){
        driver.findElement(By.xpath("//span[.='"+leftMenuOption+"']")).click();
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


}
