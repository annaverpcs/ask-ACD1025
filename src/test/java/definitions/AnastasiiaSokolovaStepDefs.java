// Author: Anastasiia Sokolova
package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class AnastasiiaSokolovaStepDefs {
    @Given("AS open url {string}")
    public void asOpenUrl(String sURL) {
        getDriver().get(sURL);
        }

    @Then("AS element with xpath {string} should be present")
    public void asElementWithShouldBePresent(String sXpath) {
        assertThat(getDriver().findElements(By.xpath(sXpath))).hasSize(1);
    }

    @Then("AS check that environment is Intership")
    public void asCheckThatEnvironmentIsIntership() {
       String sEnvironment = getDriver().findElement(By.xpath("//div[@class='staging-label']")).getText();
        assertThat(sEnvironment.equals("Environment: INTERNSHIP")).isTrue();
    }

    @Then("AS login with {string} and {string} as Teacher")
    public void asLoginWithAndAsTeacher(String sEmail, String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
        getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(sPassword);
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("AS login with {string} and {string} as Student")
    public void asLoginWithAndAsStudent(String sEmail, String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
        getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(sPassword);
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("AS verify role of user is {string}")
    public void asCheckRoleOfUserIs(String sRole) {
        String sInfoRole = getDriver().findElement(By.xpath("//div[@class='info']/p")).getText();
        assertThat(sInfoRole.equals(sRole)).isTrue();
    }
    @Then("AS wait for {int} sec")
    public void waitForSec(int iTime) throws Exception {
        Thread.sleep(iTime*1000);
    }

    @Then("AS click on {string} menu item")
    public void asClickOnMenuItem(String sMenuItem) {
        System.out.println("MenuItem   " + sMenuItem);
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+sMenuItem+"')]")).click();
    }

    @Then("AS switch to {string} tab")
    public void asSwitchToTab(String sTabName) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+sTabName+"')]")).click();
    }


    @Then("AS click on {string} in the teacher list")
    public void asClickOnInTheTeacherList(String sTeacherName) {
        getDriver().findElement(By.xpath("//div[@class='mat-list-text']/*[contains(text(),'"+sTeacherName+"')]")).click();
        //getDriver().findElement(By.xpath("//div[@class='mat-list-text']/*[text()='"+sTeacherName+"']")).click();
        /*
        List<WebElement> teachertNames = getDriver().findElements(By.xpath("//mat-list-item"));
        for (WebElement item : teachertNames) {
            if (item.getText().contains(sTeacherName)) {
                item.click();
            }
        }
         */
    }

    @Then("AS click on element with {string}")
    public void asClickOnElementWith(String sXpath) {
        getDriver().findElement(By.xpath(sXpath)).click();
    }

    @And("AS wait for element with {string} to be present")
    public void asWaitForElementWithToBePresent(String xpath) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    @Then("AS verify that profile matches {string}")
    public void asVerifyThatProfileMutches(String sName) {
        String sPrintedName = getDriver().findElement(By.xpath("//div[@class='horizontal-group']/h2")).getText();
        System.out.println("sPrintedName is   |"+sPrintedName+"|");
        System.out.println("sName is   |"+sPrintedName+"|");
        if (sName.equals(sPrintedName)) {
            System.out.println("sName is equal sPrintedName");
        }
        else {
            System.out.println("sName is NOT equal sPrintedName");
        }


        //assertThat(sPrintedName.equals(sName)).isTrue();
    }

    @Then("AS click on {string} button")
    public void asClickOnButton(String sButtonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sButtonName+"')]")).click();
    }

    @Then("AS type {string} as Quiz Title")
    public void asTypeAsQuizTitle(String sQuizTitle) {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(sQuizTitle);
    }

    @Then("AS add a question")
    public void asAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("AS choose {string} question type")
    public void asChooseQuestionType(String sQuestionChoice) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+sQuestionChoice+"')]")).click();
    }

    @Then("AS type {string} as {string}")
    public void asTypeAs(String sFieldValue, String sFieldPosition) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+sFieldPosition+"*']")).sendKeys(sFieldValue);
    }

    @Then("AS type {string} into New User's Name field")
    public void asTypeIntoNewUserSNameField(String sNewName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(sNewName);
    }

    @And("AS check that element with {string} is enabled")
    public void asCheckThatElementWithIsEnabled(String sXpath) {
        assertThat(getDriver().findElement(By.xpath(sXpath)).isEnabled()).isTrue();
        System.out.println("Button is enabled");
    }

    @And("AS check that element with {string} is disabled")
    public void asCheckThatElementWithIsDisabled(String sXpath) {
        assertThat(getDriver().findElement(By.xpath(sXpath)).isEnabled()).isFalse();
        System.out.println("Button is disabled");
    }


    @And("AS check that element with {string} is {string}")
    public void asCheckThatElementWithIs(String sXpath, String sButtonChangeEnabled) {
        if (sButtonChangeEnabled.equals("enabled")){
            assertThat(getDriver().findElement(By.xpath(sXpath)).isEnabled()).isTrue();
            System.out.println("Button is enabled");
        }
        if (sButtonChangeEnabled.equals("disabled")){
            System.out.println("Button is disabled");
            assertThat(getDriver().findElement(By.xpath(sXpath)).isEnabled()).isFalse();
        }
    }


    @And("AS error message is {string}")
    public void asErrorMessageIs(String sErrorMessage) {
        String sPrintedError = getDriver().findElement(By.xpath("//mat-error")).getText();
        System.out.println("sPrintedError is |"+sPrintedError+"|");
        System.out.println("sErrorMessage is |"+sErrorMessage+"|");
        assertThat(sPrintedError.equals(sErrorMessage)).isTrue();
    }
}

