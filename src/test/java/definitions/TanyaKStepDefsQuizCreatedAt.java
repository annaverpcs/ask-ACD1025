package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static support.TestContext.getDriver;


public class TanyaKStepDefsQuizCreatedAt {
    @Given("TK navigate to {string}")
    public void tkNavigateTo(String sURL) {getDriver().get(sURL);
    }

    @Then("TK type {string} as Email Address")
    public void tkTypeAsEmailAddress(String sEmailAddress) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmailAddress);
    }

    @And("TK type {string} as Password")
    public void tkTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);

    }

    @And("TK click on Sign In button")
    public void tkClickOnSignInButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("TK wait for {int} seconds")
    public void avWaitForSeconds(long iSec) throws InterruptedException {
        Thread.sleep(1000*iSec);
    }

    @Then("TK click on {string} menu item")
    public void avClickOnMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+sMenuItem+"')]")).click();
    }

    @Then("TK click on {string} button")
    public void tkClickOnButton(String sButtonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sButtonName+"')]")).click();
    }

    @Then("TK type {string} as Quiz Title")
    public void tkTypeAsQuizTitle(String sQuizeTitle) {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(sQuizeTitle);
    }

    @Then("TK add a question")
    public void tkAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();

    }

    @Then("TK choose {string} question type")
    public void avChooseQuestionType(String sQuestionChoice) {

        getDriver().findElement(By.xpath("//*[contains(text(),'"+sQuestionChoice+"')]")).click();
    }

    @Then("TK type {string} as {string}")
    public void avTypeAs(String sFieldValue, String sFieldPosition) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + sFieldPosition + "*']")).sendKeys(sFieldValue);
    }

    @Then("TK click on List of Quizzes")
    public void tkClickOnListOfQuizzes() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Where we can find a Xpath?')]")).click();
    }

    @Then("TK validate created at value")
    public void tkValidateCreatedAtValue() {
        org.openqa.selenium.WebElement el = getDriver().findElement(By.xpath("/html[1]/body[1]/ac-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/main[1]/ac-quizzes-list[1]/mat-card[1]/div[1]/mat-accordion[1]/mat-expansion-panel[129]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        String el_value = el.getText();
        System.out.println(el_value);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(el_value);
        } catch (ParseException pe) {
            System.out.println("Oi!!");
            return;
        }
        System.out.println("Good!");
    }
}