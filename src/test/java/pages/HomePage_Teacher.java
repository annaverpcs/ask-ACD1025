package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static support.TestContext.getDriver;

public class HomePage_Teacher extends GenericPage{

    @FindBy(xpath = "//*[contains(text(), 'TEACHER')]")
    private WebElement teacherHeader;

    @FindBy(xpath = "//*[contains(text(),'User')]")
    private WebElement userManagement;

    @FindBy(xpath = "//*[contains(text(),'Students')]")
    private WebElement studentListHeader;

    //    private List<WebElement> studentNames(){
//        return getDriver().findElements(By.xpath("//mat-list-option"));
//    }
    private List<WebElement> studentNames(){
        return getDriver().findElements(By.xpath("//h4[@class='mat-line']"));
    }

    @FindBy (xpath = "//button")
    private WebElement optionsButton;

    @FindBy(xpath = "//*[text()='User Role']")
    private WebElement userRole;

    public void clickOptions(){
        getWait().until(ExpectedConditions.visibilityOf(userRole));

        optionsButton.click();
    }

    public void getMyStudent(String name){
        //List<WebElement> studentNames = getDriver().findElements(By.xpath("//mat-list-option"));
        for(WebElement item : studentNames()){
            if(item.getText().contains(name)){
                item.click();
            }
        }
    }



    public WebElement getTeacherHeader(){
        getWait().until(ExpectedConditions.visibilityOf(teacherHeader));
        return teacherHeader;
    }

    public void getUserManagement(){
        getWait().until(ExpectedConditions.visibilityOf(userManagement));
        userManagement.click();
    }

    public void waitForList(){
        waitUntilVisible(studentListHeader);
    }




}
