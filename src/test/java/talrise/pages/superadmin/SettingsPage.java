package talrise.pages.superadmin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talrise.pages.CommonPageElements;
import java.text.Collator;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static talrise.utilities.CommonSteps.getElementsText;

public class SettingsPage extends CommonPageElements {

    String displayInfo;
    int beginningNumber;
    int endNumber;
    int totalNumberOfLookUp;
    int rowNumberHasLookUpId;

    // LOOK-UP TABLE
    @FindBy(xpath = "//h3")
    public WebElement lookUpTableTitle;
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchInputBox;
    @FindBy(xpath = "//span[@class='material-icons MuiIcon-root MuiTableSortLabel-icon MuiTableSortLabel-iconDirectionAsc']")
    public List<WebElement> sortDirectionBtns;
    @FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input MuiInputBase-inputSelect']")
    public WebElement selectRowSizeDropdown;
    @FindBy(xpath = "//input[@type='hidden']")
    public WebElement selectedRowSize;
    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> idColumn;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> typeColumn;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> nameColumn;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> parentIdColumn;
    @FindBy(xpath = "//button[@title='Delete']")
    public List<WebElement> deleteBtns;
    @FindBy(xpath = "//button[@title='Edit']")
    public List<WebElement> editBtns;
    @FindBy(xpath = "//button[@title='Save']")
    public WebElement saveAfterEditBtn;
    @FindBy(xpath = "//button[@title='Cancel']")
    public WebElement cancelAfterEditBtn;
    @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-caption']")
    public WebElement displayInfoOfTable;
    @FindBy(xpath = "//input[@placeholder='NAME']")
    public WebElement editingNameInputBox;
    @FindBy(xpath = "//input[@placeholder='PARENT ID']")
    public WebElement editingParentIdInputBox;
    @FindBy(xpath = "//div[@aria-label='TYPE']")
    public WebElement editingTypeInputDropdown;
    // ADD LOOK UP
    @FindBy(xpath = "//span[.='ADD LOOK UP']")
    public WebElement addLookUpBtn;
    @FindBy(xpath = "//span[.='BACK']")
    public WebElement backBtn;
    @FindBy(xpath = "//h2")
    public WebElement addLookUpPageHead;
    @FindBy(xpath = "//*[@id='lookUpParentId']")
    public WebElement parentIdInputBox;
    @FindBy(xpath = "//*[@id='type-select-input-id']")
    public WebElement typeInputDropdown;
    @FindBy(xpath = "//*[@name='type']")
    public WebElement typeInputElement;
    @FindBy(xpath = "//*[@id='lookUpName']")
    public WebElement nameInputBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveLookUpBtn;
    @FindBy(xpath = "//p[contains(text(),'type')]")
    public WebElement typePromptMessage;
    @FindBy(xpath = "//p[contains(text(),'name')]")
    public WebElement namePromptMessage;
    @FindBy(xpath = "//p[contains(text(),'parent')]")
    public WebElement parentIdPromptMessage;
    @FindBy(xpath = "(//div[@role='alert'])/div[2]")
    public WebElement alertMessage;

    public int getTotalNumberOfLookUps() {
        displayInfo=getDisplayInfoOfTable();
        totalNumberOfLookUp=Integer.parseInt(displayInfo.substring(displayInfo.lastIndexOf("of")+3));
        return totalNumberOfLookUp;
    }
    public int getBeginningDisplayInfo() {
        displayInfo=getDisplayInfoOfTable();
        return Integer.parseInt(displayInfo.substring(0,displayInfo.indexOf('-')));
    }
    public int getEndDisplayInfo() {
        displayInfo=getDisplayInfoOfTable();
        return Integer.parseInt(displayInfo.substring(displayInfo.indexOf('-')+1,displayInfo.indexOf(" of")));
    }
    public String getDisplayInfoOfTable() {
        displayInfo=displayInfoOfTable.getText();
        return displayInfo;
    }
    public String getValueOfLookUp(int rowNumber, int columnNumber) {
        return driver.findElement(By.xpath("(//tbody/tr)["+rowNumber+"]/td["+columnNumber+"]")).getText();
    }
    public String getValueOfEditingLookUp(int rowNumber, int columnNumber) {
        return driver.findElement(By.xpath("(//tbody/tr)["+rowNumber+"]/td["+columnNumber+"]//input")).getAttribute("value");
    }
    public String prepareTypeForDropdownSelect(String type) {
        return type.replaceAll("i","I").toUpperCase().replaceAll("\\s", "_");
    }
    public int getIntValueOfLookUp(int rowNumber, int columnNumber) {
        return Integer.parseInt(getValueOfLookUp(rowNumber,columnNumber));
    }
    public int findRowOfLookUpById(int id) {
        for (int i = 0; i < idColumn.size(); i++) {
            if(idColumn.get(i).getText().equals(""+id)) {
                return i+1;
            }
        }
        return -1;
    }
    public int countRowHasLookUpId() {
        int count=0;
        for (int i = 0; i < idColumn.size(); i++) {
            if (Integer.parseInt(idColumn.get(i).getText())>0)
                count++;
        }
        return count;
    }
    public void verifyTableDisplayInfo(int rowSize) {
        beginningNumber=getBeginningDisplayInfo();
        endNumber= getEndDisplayInfo();
        rowNumberHasLookUpId =countRowHasLookUpId();
        Assert.assertEquals(endNumber-beginningNumber+1, rowNumberHasLookUpId);
        if(totalNumberOfLookUp>rowSize)
            Assert.assertEquals(endNumber-beginningNumber+1,rowSize);
    }
    public void verifyTableDisplayInfoForLastPage(int rowSize) {
        verifyTableDisplayInfo(totalNumberOfLookUp);
        Assert.assertEquals(totalNumberOfLookUp,endNumber);
        Assert.assertEquals(totalNumberOfLookUp%rowSize, rowNumberHasLookUpId %rowSize);
    }
    public WebElement getSortDirectionBtn(String column) {
        return driver.findElement(By.xpath("//div[text()='"+column.toUpperCase()+"']//.."));
    }
    public int getIndexOfColumn(String column) {
        if(column.equalsIgnoreCase("id")) {
            return 1;
        } else if(column.equalsIgnoreCase("type")) {
            return 2;
        } else if(column.equalsIgnoreCase("name")) {
            return 3;
        } else if (column.equalsIgnoreCase("parent id")) {
            return 4;
        } else
            return 0;
    }
    public List<String> getValuesOfColumn(int columnIndex) {
        return getElementsText(driver.findElements(By.xpath("//tbody/tr/td["+columnIndex+"]")));
    }
    public boolean verifySorting(String sortDirection, String column) {
        int columnIndex=getIndexOfColumn(column);
        List<String> columnValues=getValuesOfColumn(columnIndex);
        Collections.sort(columnValues, Collator.getInstance(Locale.US));
        if(sortDirection.equalsIgnoreCase("desc")) {
            Collections.reverse(columnValues);
        }
        for (int i = 0; i < columnValues.size(); i++) {
            if(!columnValues.get(i).equals(driver.findElement(By.xpath("(//tbody/tr/td["+columnIndex+"])["+(i+1)+"]")).getText()))
                return false;
        }
        return true;
    }
}