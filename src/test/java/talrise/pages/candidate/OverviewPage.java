package talrise.pages.candidate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;

public class OverviewPage extends CommonPageElements {

    @FindBy(xpath = "//h1")
    public WebElement fullName;

    @FindBy(xpath = "//h2[1]")
    public WebElement occupation;

    @FindBy(xpath = "(//*[@class=\"contact-item\"]//span)[1]")
    public WebElement email;

    @FindBy(xpath = "(//*[@class=\"contact-item\"]//span)[2]")
    public WebElement linkedin;

    @FindBy(xpath = "(//*[@class=\"contact-item\"]//span)[3]")
    public WebElement phoneNumber;

    @FindBy(xpath = "(//*[@class=\"contact-item\"]//span)[4]")
    public WebElement cityAndCountry;




}
