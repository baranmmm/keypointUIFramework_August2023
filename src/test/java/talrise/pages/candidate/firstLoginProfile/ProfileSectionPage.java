package talrise.pages.candidate.firstLoginProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

import java.util.List;

import java.util.Random;


public class ProfileSectionPage extends CommonPageElements {

    @FindBy(xpath = "//div[@class='navigate']")
    public WebElement talriseLogo;

    @FindBy(xpath ="//*[contains(@class,'Toastify__toast-body')]")
    public WebElement alertMessage;


    @FindBy(name = "searchText")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class = 'sc-gmPhUn ebnDlO']//button") public List<WebElement> suggestedList;

    @FindBy(xpath = "//div[@class='sc-hRJfrW dIHHed']//button") public List<WebElement> selectedList;

    public String clickAndGetTitleFromSuggestedList( ) {
        try {
            driver.findElement(By.xpath("//button[text()='See More >']")).click();
        } catch (Exception e) {
            System.out.println("All options are listed");
        }

        WebElement randomOption = suggestedList.get(new Random().nextInt(suggestedList.size()));
        boolean flag = true;
        while(flag){
            if(randomOption.getText().equals("See Less >")){
                randomOption = suggestedList.get(new Random().nextInt(suggestedList.size()));
            }else{
                flag =false;
            }
        }
        String randomOptionTitle = randomOption.getText();
        randomOption.click();
        return randomOptionTitle;
    }

    public String deleteAndGetTitleFromSelectedList(){
        WebElement randomOption = selectedList.get(new Random().nextInt(selectedList.size()));
        String randomOptionTitle = randomOption.getText();
        randomOption.click();
        return randomOptionTitle;

    }








}
