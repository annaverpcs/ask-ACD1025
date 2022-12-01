// Author: Anastasiia Sokolova
package definitions;

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
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class AnastasiiaSokolovaStepDefs {
    @Given("AS open url {string}")
    public void asOpenUrl(String sURL) {
            getDriver().get(sURL);
        }

    @Then("AS element with {string} should be present")
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

    @Then("AS check role of user is {string}")
    public void asCheckRoleOfUserIs(String sRole) {
        String sInfoRole = getDriver().findElement(By.xpath("//div[@class='info']/p")).getText();
        assertThat(sInfoRole.equals(sRole)).isTrue();
    }
    @Then("AS wait for {int} sec")
    public void waitForSec(int iTime) throws Exception {
        Thread.sleep(iTime*1000);
    }

}

