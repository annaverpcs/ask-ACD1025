package pages_EmmaW;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static support.TestContext.getDriver;

public class GenericPage implements IHasURL{
    protected String url;
    protected String title;

    public GenericPage(){
        PageFactory
                .initElements(getDriver(), this);
    }
    public String getUrl (){
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl;
    }

    public String getTitle (){
        String title = getDriver().getTitle();
        return title;
    }

    public void openUrl(){
        getDriver().get(url);
    }


    //waits:
    public WebDriverWait getWait(){
        //WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebDriverWait wait  = new WebDriverWait(getDriver(),5);
        return wait;
    }

    //customized getWai
    public WebDriverWait customWait(int sec){
        //  wait doesn't work in this framework, so put time out.
         //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sec));
        WebDriverWait wait = new WebDriverWait(getDriver(), sec);
        return wait;
    }

    public void waitUntilVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilInVisible(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    //actions
    Actions actions = new Actions(getDriver());

    //js
    JavascriptExecutor js = (JavascriptExecutor)getDriver();
    //js.executeScript() //probably pom.xml outdated, not finding this method.


}
