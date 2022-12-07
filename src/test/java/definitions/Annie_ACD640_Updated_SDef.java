package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;
import java.lang.Integer;
import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class Annie_ACD640_Updated_SDef {
    private Integer userId;
    private String activationCode;
    String email,url;

    @Given("I open the application using the {string}")
    public void iOpenTheApplicationUsingThe(String url) {
        getDriver().get(url);
        this.url = url;
    }

    @Then("I must see page title as {string}")
    public void iMustSeePageTitleAs(String expectedTitle) {
        String actualTitle = getDriver().getTitle();
        assertEquals(actualTitle,expectedTitle);
    }

    @Then("I click on the Register Now button")
    public void iClickOnTheRegisterNowButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
    }

    @Then("I should see the Registration Form")
    public void iShouldSeeTheRegistrationForm() {
        assert(getDriver().findElement(By.xpath("//h4[contains(text(),'Registration')]"))).isDisplayed();
    }

    //***********Wait*******************************************

    @Then("I wait for few seconds")
    public void iWaitForFewSeconds() throws InterruptedException{
        Thread.sleep(2000);
    }
    //*******************Registration Form Fill In *********************
    @Then("I enter {string} in the first name field")
    public void iEnterInTheFirstNameField(String fName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fName);
    }

    @And("I enter {string} in the last name field")
    public void iEnterInTheLastNameField(String lName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lName);
    }

    @And("I enter {string} in the email field")
    public void iEnterInTheEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        this.email=email;
    }

    @And("I enter {string} in the group code field")
    public void iEnterInTheGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @And("I enter {string} in the password field")
    public void iEnterInThePasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I enter {string} in confirm password field")
    public void iEnterInConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Then("I click on the Register-me button")
    public void iClickOnTheRegisterMeButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    //******************Successful registration page************************
    @Then("I should see the Registration Confirmed Page")
    public void iShouldSeeTheRegistrationConfirmedPage() {
        assert(getDriver().findElement(By.xpath("//ac-registration-confirmation-page")).isDisplayed());
    }

    //*************Activation Code **************************************
    @Then("I retrieve the activation code")
    public void iRetrieveTheActivationCode() throws SQLException {
        String res = Helpers.getAccessToken(email);
        System.out.println("The result from DB: " + res);
        String[] val = res.split(";");
        userId = Integer.valueOf(val[0]);
        activationCode = val[1];
        System.out.println("Separated values: " + val[0] + " and " + val[1]);
    }

    @And("I activate the account")
    public void iActivateTheAccount() throws IOException {
            Helpers.activateUser(userId, activationCode);
    }

//***************Home Page and Authentication********************
    @Then("I must be able to see the home page")
    public void iMustBeAbleToSeeTheHomePage() {
        assert(getDriver().findElement(By.xpath("//ac-home-page")).isDisplayed());
    }

    @Then("I should see the Authentication-Failed message")
    public void iShouldSeeTheAuthenticationFailedMessage() {
        assert(getDriver().findElement(By.xpath("//*[@aria-live='assertive'][contains (text(),'Authentication failed')]")).isDisplayed());
    }

    @And("I must NOT be able to see the home page")
    public void iMustNOTBeAbleToSeeTheHomePage() {
        assert(!(getDriver().getCurrentUrl().equals(this.url)));
    }
}
