package talrise.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import talrise.pages.PageInitializer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommonSteps extends PageInitializer {

    public static void click(WebElement element) {
        waitForClickability(element, 10);
        element.click();
    }

    public static void clickWithActions(WebElement element) {
        waitForClickability(element,10);
        actions.click(element).build().perform();
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void clickOnImage(String imageName){
        String userDir = System.getProperty("user.dir");
        String imageAddress = userDir+"\\src\\test\\resources\\images\\"+imageName+".png";
        Screen screen = new Screen();
        Pattern pattern = new Pattern(imageAddress);
        try {
            screen.wait(pattern,5000);
            screen.click(pattern);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            if (element.isDisplayed()){
                element.click();
                break;
            }else{
                waitFor(1);
            }
        }
    }

    public static void clickOnACoordinate(int xCoordinate, int yCoordinate){
        Robot robot = null;
        try {
            robot = new Robot();
            moveMouseToACoordinate(xCoordinate,yCoordinate);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public static void doubleClickWithActions(WebElement element) {
        waitForClickability(element,10);
        actions.doubleClick(element).build().perform();
    }

    public static void rightClickWithActions(WebElement element) {
        waitForClickability(element,10);
        actions.contextClick(element).build().perform();
    }

    public static void clickAndHold(WebElement element) {
        actions.clickAndHold(element).build().perform();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        actions.sendKeys(element,text).build().perform();
    }

    public static void sendKeysOnImage(String imageName, String text) {
        String userDir = System.getProperty("user.dir");
        String imageAddress = userDir+"\\src\\test\\resources\\images\\"+imageName+".png";
        Screen screen = new Screen();
        Pattern pattern = new Pattern(imageAddress);
        try {
            screen.wait(pattern,5000);
            screen.type(text);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }

    public static void dragAndDropWithActions(WebElement sourceElement, WebElement targetElement) {
        actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
    }

    public static void releaseElement(WebElement element){
        actions.release(element).build().perform();
    }

    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element is visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }

    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element is not visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element is visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }

    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            Assert.assertFalse("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static JavascriptExecutor getJSObject() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        return js;
    }

    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);

    }

    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command);

    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollDownByPixels(int pixel) {
        getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
    }

    public static void scrollUpByPixels(int pixel) {
        getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
    }

    public static void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void hoverOverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    //Highlighs an element by changing its background and border color
    public static void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public static void selectRadioOrCheckbox(List<WebElement> listElement, String value) {
        String actualValue;

        for (WebElement el : listElement) {
            actualValue = el.getAttribute("value").trim();
            if (el.isEnabled() && actualValue.equals(value)) {
                el.click();
                break;
            }
        }
    }

    public static void selectDropdownByText(WebElement dropdownElement, String textToSelect) {
        try {
            Select select = new Select(dropdownElement);

            List<WebElement> options = select.getOptions();

            for (WebElement el : options) {
                if (el.getText().equals(textToSelect)) {
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }

    }

    public static void selectDropdownByIndex(WebElement dropdownElement, int index) {

        try {
            Select select = new Select(dropdownElement);

            int size = select.getOptions().size();

            if (size > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }

    }

    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public static void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public static String getAlertText() {
        String alertText = null;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        return alertText;
    }

    public static void sendAlertText(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }

    }

    public static void switchToChildWindow() {
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
            }
        }

    }

    public static String getCurrentDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    /**
     * this method take format of date/time (yyyy-MM-dd or hh:mm a)(yyyy-MM-dd hh:mm:ss a)
     * two date as a string and return
     * two date in date list as date format
     *  @param format/type
     *  @param date1/time
     *  @param date2/time
     */
    public static List<Date> convertStringToDate(String format,String date1,String date2) throws ParseException {
        List<Date> dates= new ArrayList<>();
        DateFormat df = new SimpleDateFormat(format);
        Date d1 = df.parse(date1);
        Date d2 = df.parse(date2);
        dates.add(d1);
        dates.add(d2);
        return dates;
    }

    public static String getTimeStamp() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

        return sdf.format(date.getTime());

    }

    public static String getValidationErrorMessage(WebElement element){
        String message =element.getAttribute("validationMessage");
        return message;
    }

    public static boolean isImageAvailable(String imageName) throws FindFailed {
        String userDir = System.getProperty("user.dir");
        String imageAddress = userDir + "\\src\\test\\resources\\images\\" + imageName + ".png";
        Screen screen = new Screen();
        try{
            Pattern pattern = new Pattern(imageAddress).exact();
            if (screen.find(pattern)!= null) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            System.out.println("Image not found");
            return false;
        }
    }

    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        File file = ts.getScreenshotAs(OutputType.FILE);
        // create destination as : filepath + filename + timestamp + .png
        String destination = System.getProperty("user.dir") + "/test-output/Screenshots/" + filename + date + ".png";

        try {
            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static BufferedImage partialImageCreator(String imageName, int xStartPoint, int yStartPoint, int width, int height) {

        File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage Image = null;
        BufferedImage ImagePartial = null;
        try {
            Image = ImageIO.read(Screenshot);
            ImagePartial = Image.getSubimage(xStartPoint, yStartPoint-115, width, height);
            ImageIO.write(ImagePartial, "png", Screenshot);
            FileUtils.copyFile(Screenshot, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\" + imageName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ImagePartial;
    }

    public static BufferedImage readImageFile(String imageName) throws IOException {
        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\"+imageName+".png"));
        return image;
    }

    public static boolean isSimilar(BufferedImage actual, BufferedImage expectedImage) {
        double percentage = 1000;
        int w1 = actual.getWidth();
        int w2 = expectedImage.getWidth();
        int h1 = actual.getHeight();
        int h2 = expectedImage.getHeight();
        if ((w1 != w2) || (h1 != h2)) {
            System.out.println("Both images should have same dimensions");
        } else {
            long diff = 0;
            for (int j = 0; j < h1; j++) {
                for (int i = 0; i < w1; i++) {
                    //Getting the RGB values of a pixel
                    int pixel1 = actual.getRGB(i, j);
                    Color color1 = new Color(pixel1, true);
                    int r1 = color1.getRed();
                    int g1 = color1.getGreen();
                    int b1 = color1.getBlue();
                    int pixel2 = expectedImage.getRGB(i, j);
                    Color color2 = new Color(pixel2, true);
                    int r2 = color2.getRed();
                    int g2 = color2.getGreen();
                    int b2 = color2.getBlue();
                    //sum of differences of RGB values of the two images
                    long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
                    diff = diff + data;
                }
            }
            double avg = diff / (w1 * h1 * 3);
            percentage = (avg / 255) * 100;
            //System.out.println("Difference: " + percentage);
        }
        if (percentage > 3) {
            return false;
        } else return true;
    }

    public static void moveMouseToACoordinate(int x, int y) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(x, y);
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.visibilityOf(element));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebElement locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    /**
     * this method bring return message that is not exist in HTML
     *
     * @param inputBox
     * @return
     */
    public static String getPlease_fill_in_this_field_Message(WebElement inputBox) {
        String message = inputBox.getAttribute("validationMessage");
        return message;
    }

}