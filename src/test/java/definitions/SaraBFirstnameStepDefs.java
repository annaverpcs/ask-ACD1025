package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.*;

import static support.TestContext.getDriver;

public class SaraBFirstnameStepDefs {
    @Given("SB navigate to {string}")
    public void sbNavigateTo(String sURL) {
        getDriver().navigate().to(SaraBXPathLibrary.sURLXpath);

    }

    @Then("SB click on {string} button")
    public void sbClickOnButton(String sRegstrNow) {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sRegisterNowButtonXpath)).click();

    }

    @Then("SB should see {string} page")
    public void sbShouldSeePage(String sRegstrnpage) {
        String title = getDriver().getTitle();
        assertThat(title).isEqualTo(sRegstrnpage);
    }

    @And("SB should see the form Registration")
    public void sbShouldSeeTheFormRegistration() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sRegistrationXpath)).isDisplayed();

    }

    @Then("SB click {string} button")
    public void sbClickButton(String sRegistrMe) {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sRegisterMeButtonXpath)).click();
    }

    @Then("SB should see error message {string}")
    public void sbShouldSeeErrorMessage(String sErrMsg) {
      //  getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).isDisplayed();
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sErrorMessageXpath)).isDisplayed();
    }

    @When("SB type {string} in the first name filed")
    public void sbTypeInTheFirstNameFiled(String sfirstname) {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sFirstNameXpath)).sendKeys(sfirstname);

    }

    @Then("error message field should not be displayed")
    public void errorMessageFieldShouldNotBeDisplayed() {
        /*
        This assertion verifies that there are no matching elements in the DOM and returns the value of Zero,
        so the assertion passes when the element is not present. Also it would fail if it was present.
         */

       // assertThat(getDriver().findElement(By.xpath(SaraBXPathLibrary.sErrorMessageXpath)).isDisplayed()).isFalse();
        Assert.assertEquals(0, getDriver().findElements(By.xpath(SaraBXPathLibrary.sErrorMessageXpath)).size());
    }

    @Then("SB clicks on {string} button")
    public void sbClicksOnButton(String sBacktoLoginBtn) {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sBackToLoginBtnXpath)).click();

    }

    @Then("find firstname field")
    public void findFirstnameField() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sFirstNameXpath));

    }

    @And("SB click {string} field")
    public void sbClickField(String sfirstName) {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sFirstNameXpath)).click();
    }

    @Then("SB click on LastName field")
    public void sbClickOnLastNameField() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.SLastNameXpath)).click();

    }


    @And("SB wait for {int} sec")
    public void sbWaitForSec(long iSec) throws InterruptedException {
        Thread.sleep(1000*iSec);
    }

    @Then("SB clears all the field")
    public void sbClearsAllTheField() {
        getDriver().navigate().refresh();
    }

    @Then("error message should not be displayed")
    public void errorMessageShouldNotBeDisplayed() {
        Assert.assertEquals(0, getDriver().findElements(By.xpath(SaraBXPathLibrary.sErrorMessage2Xpath)).size());

    }

    @Then("error message should  be displayed")
    public void errorMessageShouldBeDisplayed() {
        Assert.assertEquals(1, getDriver().findElements(By.xpath(SaraBXPathLibrary.sErrorMessage2Xpath)).size());
    }

}

