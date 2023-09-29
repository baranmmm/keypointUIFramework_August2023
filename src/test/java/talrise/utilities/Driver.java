package talrise.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import talrise.pages.PageInitializer;

import java.time.Duration;

public class Driver {
    public static WebDriver driver;
    public static Actions actions;

    /*
     * This method will create a driver and return it
     * @return WebDriver driver
     */
    public static WebDriver getDriver() {

        String browser = ConfigurationReader.get("browser");
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
//                driver = new ChromeDriver();
                break;
            case "chrome-headless":
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "firefox-headless":
                driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                break;
            case "ie":
                if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                    throw new WebDriverException("Your OS doesn't support Internet Explorer");
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                    throw new WebDriverException("Your OS doesn't support Safari");
                driver = new SafariDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        PageInitializer.initialize();
        actions = new Actions(driver);
        return driver;
    }
    /*
     * This method quits the browser
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}