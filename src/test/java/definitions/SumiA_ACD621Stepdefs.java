package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class SumiA_ACD621Stepdefs {
    @Given("SA navigate to  {string}")
    public void saNavigateTo(String sURL) {
        getDriver().get(sURL);
    }

    @Then("SA type {string} as email address")
    public void saTypeAsEmailAddress(String sEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
    }

    @Then("SA type {string} as password")
    public void saTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @Then("SA click on sign on Button")
    public void saClickOnSignOnButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("SA wait for {int} seconds")
    public void saWaitForSeconds(int Itime)throws InterruptedException {
        Thread.sleep(5000);

    }


    @Then("SA click on Submissions MenuItem")
    public void saClickOnSubmissionsMenuItem() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Submissions')]")).click();
    }

    @Then("SA click on ForGrade MenuItem")
    public void saClickOnForGradeMenuItem() {
        getDriver().findElement(By.xpath("//div[contains(text(),'For Grade')]")).click();
    }

    @Then("SA Should see SubmittedAt")
    public void saShouldSeeSubmittedAt() {
        getDriver().findElement(By.xpath("//th[contains(text(),'Submitted At')]")).isDisplayed();
    }

    @Then("SA click on AutomaticallyGraded  MenuItem")
    public void saClickOnAutomaticallyGradedMenuItem() {
        getDriver().findElement(By.xpath("//div[contains(text(),'Automatically Graded')]")).click();
    }



    @Then("SA click on Reviewed MenuItem")
    public void saClickOnReviewedMenuItem() {
        getDriver().findElement(By.xpath("//div[contains(text(),'Reviewed')]")).click();
    }


    @Then("SA Should see GradedAT")
    public void saShouldSeeGradedAT() {
        getDriver().findElement(By.xpath("//th[contains(text(),'Graded At')]")).isDisplayed();
    }
}
