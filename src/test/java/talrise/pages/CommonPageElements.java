package talrise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import talrise.utilities.Driver;

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

}
