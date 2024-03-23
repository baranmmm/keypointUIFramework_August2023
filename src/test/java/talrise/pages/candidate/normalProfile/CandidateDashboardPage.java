package talrise.pages.candidate.normalProfile;

import org.openqa.selenium.By;
import talrise.pages.CommonPageElements;

public class CandidateDashboardPage extends CommonPageElements {
    public void dismissPopUpMessage() {

        try {
            driver.findElement(By.xpath("//*[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")).click();
        }catch (Exception e){
            System.out.println("profile completed");
        }


    }
}
