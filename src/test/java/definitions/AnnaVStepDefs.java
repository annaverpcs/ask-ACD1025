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
}

