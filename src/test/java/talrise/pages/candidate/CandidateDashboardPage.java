package talrise.pages.candidate;

import org.openqa.selenium.By;
import talrise.pages.CommonPageElements;

public class CandidateDashboardPage extends CommonPageElements {
    public void dismissPopUpMessage() {

        try {
            driver.findElement(By.xpath("//*[contains(@class,'sc-cmaqmh')]")).click();
        }catch (Exception e){
            System.out.println("profile completed");
        }


    }
}
