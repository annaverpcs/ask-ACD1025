package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static support.TestContext.getDriver;

public class IrinaTStepDefs {
    @Given("IT navigate to {string}")
    public void itNavigateTo(String sURL) {
        getDriver().get(sURL);
    }

    @Then("IT type {string} as Email Address")
    public void itTypeAsEmailAddress(String sEmail) {
        getDriver().findElement(By.xpath(XPathLibrary.sEmailXpath)).sendKeys(sEmail);
    }

    @And("IT type {string} as Password")
    public void itTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath(XPathLibrary.sPasswordXpath)).sendKeys(sPassword);
    }

    @And("IT click on Sign In button")
    public void itClickOnSignInButton(){
        getDriver().findElement(By.xpath(XPathLibrary.sSubmitButtonXpath)).click();
    }

    @Then("IT wait for {int} seconds")
    public void itWaitForSeconds(long iSec) throws InterruptedException {
        Thread.sleep(1000*iSec);
    }

    @Then("IT click on {string} menu item")
    public void itClickOnMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+sMenuItem+"')]")).click();
    }

    @Then("IT click on {string} button")
    public void itClickOnButton(String sButtonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sButtonName+"')]")).click();
    }

    @Then("IT type {string} as Quiz Title")
    public void itTypeAsQuizTitle(String sQuizTitle) {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(sQuizTitle);

    }

    @Then("IT add a question")
    public void itAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("IT choose {string} question type")
    public void itChooseQuestionType(String sQuestionChoice) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+sQuestionChoice+"')]")).click();
    }

    @Then("IT type {string} as {string}")
    public void itTypeAs(String sFieldValue, String sFieldPosition) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+sFieldPosition+"']")).sendKeys(sFieldValue);
    }

    @Then("IT select correct {int} answer")
    public void itSelectCorrectAnswer(int sCorrectAnswer) {
        getDriver().findElement(By.xpath("//mat-radio-button[@class='mat-radio-button mat-accent']["+sCorrectAnswer+"]")).click();
    }

    @Then("IT click on quiz title {string}")
    public void itClickOnQuizTitle(String sQuizTitle) {
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(), '"+sQuizTitle+"')])[last()]")).click();
    }

    @Then("IT click on {string} button inside last created quiz with title {string}")
    public void itClickOnButtonInsideLastCreatedQuizWithTitle(String sButtonName, String sQuizTitle) {
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(), '"+sQuizTitle+"')])[last()]/../../..//span[contains(text(), '"+sButtonName+"')]")).click();
    }

    @Then("IT click on {string} question")
    public void itClickOnQuestion(String sQuestionTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+sQuestionTitle+"')]")).click();
    }

    @Then("IT compare that Created At is not equal to Updated At inside quiz with title {string}")
    public void itCompareThatCreatedAtIsNotEqualToUpdatedAt(String sQuizTitle) {
        org.openqa.selenium.WebElement createdAt = getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(), '"+sQuizTitle+"')])[last()]/../../..//td[contains(text(), 'Created At:')]/..//td[2]"));
        org.openqa.selenium.WebElement updatedAt = getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(), '"+sQuizTitle+"')])[last()]/../../..//td[contains(text(), 'Updated At:')]/..//td[2]"));

        String createdAtValue = createdAt.getText();
        String updatedAtValue = updatedAt.getText();

        assertNotEquals(createdAtValue, updatedAtValue);
    }

    @Then("IT delete Quiz {string}")
    public void itDeleteQuiz(String sQuizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sQuizTitle+"')]/../../..//span[contains(text(),'Delete')]")).click();
    }

    @Then("IT clear input value for {string} field")
    public void itClearInputValueForField(String sFieldPosition) {
        getDriver().findElement(By.xpath("//input[@placeholder='"+sFieldPosition+"']")).clear();
    }

    @Then("IT type in {string} field input {string}")
    public void itTypeInFieldInput(String sFieldPosition, String sFieldValue) {
        getDriver().findElement(By.xpath("//input[@placeholder='"+sFieldPosition+"']")).sendKeys(sFieldValue);
    }

    @Then("IT alert {string} should be visible")
    public void itAlertShouldBeVisible(String sAlert) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+sAlert+"')]"));
    }

    @Then("{string} button should be disabled")
    public void buttonShouldBeDisabled(String sButtonName) {
        getDriver().findElement(By.xpath("//button[@disabled]/span[contains(text(),'"+sButtonName+"')]"));
    }

    @Then("IT find {string} as user name")
    public void itFindAsUserName(String sName) {
        getDriver().findElement(By.xpath("//h4[contains(text(), 'Settings')]/..//td[contains(text(), 'USER:')]/..//td[2][contains(text(), '"+sName+"')]"));
    }

    @Then("IT click on {string} button inside form")
    public void itClickOnButtonInsideForm(String sButtonName) {
        getDriver().findElement(By.xpath("//form//span[contains(text(),'"+sButtonName+"')]")).click();
    }
}

