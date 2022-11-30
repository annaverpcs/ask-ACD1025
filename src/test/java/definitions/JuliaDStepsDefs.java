package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class JuliaDStepsDefs {
    @Given("I open URL {string}")
    public void iOpenURL(String sURL) {
        getDriver().get(sURL);
    }



    @And("JD type {string} as Password")
    public void jdTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);
        
    }

    @And("JD I click on {string} button")
    public void jdIClickOnButton(String sButtonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("JD wait for {int} seconds")
    public void jdWaitForSeconds(long iSec) throws InterruptedException {
        Thread.sleep(1000*iSec);
    }

    @Then("JD type {string} as Email Address")
    public void jdTypeAsEmailAddress(String sEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
    }
}
