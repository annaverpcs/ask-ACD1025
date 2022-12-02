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
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
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


    @Then("JD I type {string} as First Name")
    public void jdITypeAsFirstName(String sFirstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys(sFirstName);

    }

    @Then("JD I type {string} as Last NAme")
    public void jdITypeAsLastNAme(String sLastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).sendKeys(sLastName);

    }

    @Then("JD I type {string} as email")
    public void jdITypeAsEmail(String sEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(sEmail);
    }

    @Then("JD I type {string} as group code")
    public void jdITypeAsGroupCode(String sGroupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"group\"]")).sendKeys(sGroupCode);
    }

    @Then("JD I type {string} as password")
    public void jdITypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(sPassword);
    }

    @Then("JD I type {string} as confirm password")
    public void jdITypeAsConfirmPassword(String sConfPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"confirmPassword\"]")).sendKeys(sConfPassword);
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

    @Then("JD I click on Quizzes link")
    public void avClickOnMenuItem() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @Then("JD click on {string} button")
    public void avClickOnMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + sMenuItem + "')]")).click();
    }
}
