package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
public class AnnieMockStepDefs {
    @Given("I open URL {string}")
    public void iOpenURL(String url) {
        getDriver().get(url);
    }

      @And("I type {string} as email")
    public void iTypeAsEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as password")
    public void iTypeAsPassword(String passwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(passwd);
    }
/*
    @Then("I should see the page title as {string}")
    public void iShouldSeeThePageTitleAs(String expectedTitle) {
      String actualTitle= getDriver().getTitle();
      if(actualTitle.equalsIgnoreCase(expectedTitle))
          System.out.println("Title Matched");
      else
          System.out.println("Title did not match");
    }

    @Then("I should be logged into the {string}")
    public void iShouldBeLoggedIntoThe(String url) {
        getDriver().get(url);
    }
 */
    @And("I click on the Sign In button")
    public void iClickOnTheSignInButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }



    @Then("I wait for {int} sec")
    public void iWaitForSec(int t) throws InterruptedException{
        Thread.sleep(t*1000);
    }
}
