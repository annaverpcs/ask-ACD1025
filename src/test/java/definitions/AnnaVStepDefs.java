package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;

import static support.TestContext.getDriver;

public class AnnaVStepDefs {
    private Integer userId;
    private String activationCode;


    @Given("AV navigate to {string}")
    public void iNavigateTo(String sURL) {
        getDriver().get(sURL);
    }

    @Then("AV type {string} as firstname")
    public void avTypeAsFirstname(String sFirstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(sFirstName);
    }

    @Then("AV type {string} as lastname")
    public void avTypeAsLastname(String sLastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(sLastName);
    }


    @Then("AV type {string} as email")
    public void avTypeAsEmail(String sEmailAddress) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmailAddress);
    }

    @Then("AV type {string} as group code")
    public void avTypeAsGroupCode(String sGroup) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(sGroup);
    }
    @Then("AV type {string} as password")
    public void oavTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @Then("AV type {string} as confirm password")
    public void oavTypeAsConfirmPassword(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(sConfirmPassword);
    }
    @And("AV click on signup button")
    public void oavClickOnSignupButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("AV get activation token for user {string}")
    public void avGetActivationTokenForUser(String sEmail) throws SQLException {
        String res = Helpers.getAccessToken(sEmail);
        System.out.println("The result from DB: " + res);
        String[] val = res.split(";");
        userId = Integer.valueOf(val[0]);
        activationCode = val[1];
        System.out.println("Separated values: " + val[0] + " and " + val[1]);
    }

    @And("AV send activation request")
    public void avSendActivationRequest() throws IOException {
        Helpers.activateUser(userId, activationCode);
    }

    @Then("AV type {string} as Email Address")
    public void avTypeAsEmailAddress(String sEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
    }
    @And("AV type {string} as Password")
    public void avTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @And("AV click on {string} button")
    public void avClickOnButton(String sButtonName) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("AV wait for {int} seconds")
    public void avWaitForSeconds(long iSec) throws InterruptedException {
        Thread.sleep(1000*iSec);
        }


    @Then("AV click on {string} menu item")
    public void avClickOnMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+sMenuItem+"')]")).click();
    }

    @Then("AV click on the {string} button")
    public void avClickOnTheButton(String sButtonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sButtonName+"')]")).click();
    }

    @Then("AV type {string} as Quiz Title")
    public void avTypeAsQuizTitle(String sQuizTitle) {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(sQuizTitle);

    }

    @Then("AV add a question")
    public void avAddAQuestion() {
        //mat-icon[contains(text(),'add_circle')]
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("AV choose {string} question type")
    public void avChooseQuestionType(String sQuestionChoice) {

        getDriver().findElement(By.xpath("//*[contains(text(),'"+sQuestionChoice+"')]")).click();
    }

     @Then("AV type {string} as {string}")
    public void avTypeAs(String sFieldValue, String sFieldPosition) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+sFieldPosition+"*']")).sendKeys(sFieldValue);
         //textarea[@placeholder='Question *']
         //textarea[@placeholder='Option 1*']
         //textarea[@placeholder='Option 2*']
    }
}


