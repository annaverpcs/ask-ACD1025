package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;

import static support.TestContext.getDriver;

public class JuliaDStepsDefs {
    private Integer userId;
    private String activationCode;
    private String isFieldPosition;

    @Given("JD I open URL {string}")
    public void jdIOpenURL(String sURL) {
        getDriver().get(sURL);
    }

    @Then("JD type {string} as Email Address")
    public void jdTypeAsEmailAddress(String sEmail) {
        getDriver().findElement(By.xpath(XPathLibrary.sEmailXpath)).sendKeys(sEmail);
    }

    @And("JD type {string} as Password")
    public void jdTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath(XPathLibrary.sPasswordXpath)).sendKeys(sPassword);
    }

    @And("JD I click on {string} button")
    public void jdIClickOnButton(String sButtonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("JD wait for {int} seconds")
    public void jdWaitForSeconds(long iSec) throws InterruptedException {
        Thread.sleep(1000 * iSec);
    }


    @Then("JD I type {string} as First Name")
    public void jdITypeAsFirstName(String sFirstName) {
        getDriver().findElement(By.xpath(XPathLibrary.sFirstName)).sendKeys(sFirstName);

    }

    @Then("JD I type {string} as Last NAme")
    public void jdITypeAsLastNAme(String sLastName) {
        getDriver().findElement(By.xpath(XPathLibrary.sLastName)).sendKeys(sLastName);

    }

    @Then("JD I type {string} as email")
    public void jdITypeAsEmail(String sEmail) {
        getDriver().findElement(By.xpath(XPathLibrary.sEmailXpath)).sendKeys(sEmail);
    }

    @Then("JD I type {string} as group code")
    public void jdITypeAsGroupCode(String sGroupCode) {
        getDriver().findElement(By.xpath(XPathLibrary.sGroupCode)).sendKeys(sGroupCode);
    }

    @Then("JD I type {string} as password")
    public void jdITypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath(XPathLibrary.sPasswordXpath)).sendKeys(sPassword);
    }

    @Then("JD I type {string} as confirm password")
    public void jdITypeAsConfirmPassword(String sConfPassword) {
        getDriver().findElement(By.xpath(XPathLibrary.sConfPassword)).sendKeys(sConfPassword);
    }

    @Then("JD I click on Register Me button")
    public void jdIClickOnRegisterMeButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Then("JD I get activation code for User {string}")
    public void jdIGetActivationCodeForUser(String sEmail) throws SQLException {
        String res = Helpers.getAccessToken(sEmail);
        System.out.println("The result from DB: " + res);
        String[] val = res.split(";");
        userId = Integer.valueOf(val[0]);
        activationCode = val[1];
        System.out.println("Separated values: " + val[0] + " and " + val[1]);
    }

    @Then("JD I send activation request")
    public void jdISendActivationRequest() throws IOException {
        Helpers.activateUser(userId, activationCode);
    }

    //@Then("JD I click on Quizzes link")
    //public void avClickOnMenuItem() 
    //{getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    //}


    @Then("JD I click on {string} menu item")
    public void jdIClickOnMenuItem(String sMenueItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + sMenueItem + "')]")).click();
    }

    @Then("JD click on {string} button")
    public void jdClickOnButton(String arg0) {
    }

    @Then("JD click on the {string} button")
    public void jdClickOnTheButton(String sButtonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + sButtonName + "')]")).click();
    }

    @Then("JD I type {string} for Quiz Title")
    public void jdITypeForQuizTitle(String sQuizTitle) {
        getDriver().findElement(By.xpath("//input[@placeholder=\"Title Of The Quiz *\"]")).sendKeys(sQuizTitle);
    }

    @Then("JD I add a question")
    public void jdIAddAQuestion() {
        ////mat-icon[contains(text(),'add_circle')]
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("JD pick {string} question type")
    public void jdPickQuestionType(String sQuestionChoice) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + sQuestionChoice + "')]")).click();
    }


    @Then("JD I type {string} as {string}")
    public void avTypeAs(String sFieldValue, String sFieldPosition) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + sFieldPosition + "*']")).sendKeys(sFieldValue);

        //textarea[@placeholder='Question *']
        //textarea[@placeholder='Question 1*']
        //textarea[@placeholder='Question 2*']
    }


    @Then("JD add option by click on the {string} button")
    public void jdAddOptionByClickOnTheButton(String sAddOption) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + sAddOption + "')]")).click();
    }

    @Then("JD I click on the Add Option button several times")
    public void jdIClickOnTheAddOptionButtonSeveralTimes() {
        WebElement buttonElement = getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]"));
        int i;
        for (i = 0; i <= 13; i++) {
            buttonElement.click();
        }
    }
}

  
    