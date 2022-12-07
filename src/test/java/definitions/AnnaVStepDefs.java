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

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class AnnaVStepDefs {
    private Integer userId;
    private String activationCode;
    private String isFieldPosition;

    @Given("AV navigate to {string}")
    public void iNavigateTo(String sURL) {
        getDriver().get(sURL);
    }

    @Then("AV type {string} as firstname")
    public void avTypeAsFirstname(String sFirstName) {
        getDriver().findElement(By.xpath(XPathLibrary.sFirstNameXpath)).sendKeys(sFirstName);
    }

    @Then("AV type {string} as lastname")
    public void avTypeAsLastname(String sLastName) {
        getDriver().findElement(By.xpath(XPathLibrary.sLastNameXpath)).sendKeys(sLastName);
    }


    @Then("AV type {string} as email")
    public void avTypeAsEmail(String sEmailAddress) {
        getDriver().findElement(By.xpath(XPathLibrary.sEmailXpath)).sendKeys(sEmailAddress);
    }

    @Then("AV type {string} as group code")
    public void avTypeAsGroupCode(String sGroup) {
        getDriver().findElement(By.xpath(XPathLibrary.sGroupXpath)).sendKeys(sGroup);
    }

    @Then("AV type {string} as confirm password")
    public void avTypeAsConfirmPassword(String sConfirmPassword) {
        getDriver().findElement(By.xpath(XPathLibrary.sConfirmPasswordXpath)).sendKeys(sConfirmPassword);
    }

    @And("AV click on signup button")
    public void avClickOnSignupButton() {
        getDriver().findElement(By.xpath(XPathLibrary.sSubmitButtonXpath)).click();
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
        getDriver().findElement(By.xpath(XPathLibrary.sEmailXpath)).sendKeys(sEmail);
    }
    @And("AV type {string} as Password")
    public void avTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath(XPathLibrary.sPasswordXpath)).sendKeys(sPassword);
    }

    @And("AV click on Sign In button")
    public void avClickOnSignInButton(){
        getDriver().findElement(By.xpath(XPathLibrary.sSubmitButtonXpath)).click();
    }

    @Then("AV wait for {int} seconds")
    public void avWaitForSeconds(long iSec) throws InterruptedException {
        Thread.sleep(1000*iSec);
        }


    @Then("AV click on {string} menu item")
    public void avClickOnMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+sMenuItem+"')]")).click();
    }

    @Then("AV click on {string} button")
    public void avClickOnButton(String sButtonName) {
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

    @Then("AV select correct {int} answer")
    public void avSelectCorrectAnswer(int sCorrectAnswer) {

        getDriver().findElement(By.xpath("//mat-radio-button[@class='mat-radio-button mat-accent']["+sCorrectAnswer+"]")).click();
    }

    @Then("AV click on Quiz Title {string}")
    public void avClickOnQuizTitle(String sQuizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sQuizTitle+"')]")).click();
    }


    @Then("AV delete Quiz {string}")
    public void avDeleteQuiz(String sQuizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sQuizTitle+"')]/../../..//span[contains(text(),'Delete')]")).click();
    }
    @Then("AV click on {string} link")
    public void avClickOnLink(String sLinkName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To Users Management')]")).click();

    }

    @Then("AV click on {string} and {string} student link")
    public void avClickOnAndStudentLink(String sFirstName, String sLastName) {
        String sFullName = sFirstName+" "+sLastName+" ";
        getDriver().findElement(By.xpath("//mat-tab-body/..//mat-list-item/..//div[@class='mat-list-text']/h4[text()= '"+sFullName+"']")).click();

    }

    @Then("AV click on Options button")
    public void avClickOnOptionsButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-accent']")).click();
        }


    @Then("AV click on Delete User option")
    public void avClickOnDeleteUserOption() {
       //getDriver().findElement(By.xpath("//button/..//mat-icon[contains(text(),'delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class = 'mat-menu-content ng-trigger ng-trigger-fadeInItems']/button[4]")).click();

        if (getDriver().findElement(By.xpath("//mat-dialog-container[@role='dialog']")).isDisplayed()){
            getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")).click();

        }
    }

    @Then("AV validate that {string} and {string} student is deleted")
    public void avValidateThatAndStudentIsDeleted(String sFirstName, String sLastName) {
        String sFullName = sFirstName+" "+sLastName+" ";
        System.out.println(sFullName);
        String sXpath = "//mat-tab-body/..//mat-list-item/..//div[@class='mat-list-text']/h4[text()= '"+sFullName+"']";
        System.out.println(sXpath);
        //assertThat(getDriver().findElement(By.xpath(sXpath)).isDisplayed()).isFalse(); wrong approach

        assertThat(getDriver().getPageSource().contains(sFullName)).isFalse();
    }


}


