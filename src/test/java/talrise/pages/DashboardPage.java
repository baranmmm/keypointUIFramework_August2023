package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class DashboardPage extends CommonPageElements{

    public void dismissPopUpMessage() {

        try {
            driver.findElement(By.xpath("//*[contains(@class,'sc-cmaqmh')]")).click();
        }catch (NoSuchElementException e){
            System.out.println("profile completed");
        }


    }


}
