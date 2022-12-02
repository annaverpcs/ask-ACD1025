package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;

public class HomePage_Teacher extends GenericPage{

    @FindBy(xpath = "//*[contains(text(), 'TEACHER')]")
    private WebElement teacherHeader;

    @FindBy(xpath = "//*[contains(text(),'User')]")
    private WebElement userManagement;

    @FindBy(xpath = "//*[contains(text(),'Students')]")
    private WebElement studentList;

    public WebElement getTeacherHeader(){
        getWait().until(ExpectedConditions.visibilityOf(teacherHeader));
        return teacherHeader;
    }

    public void getUserManagement(){
        userManagement.click();
    }

    public void waitForList(){
        waitUntilVisible(studentList);
    }

    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    //js.executeScript()



}
