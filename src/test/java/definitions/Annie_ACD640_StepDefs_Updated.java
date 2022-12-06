package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import support.Helpers;

import java.io.IOException;
import java.sql.SQLException;

import static support.TestContext.getDriver;


//************************ Registration *********************************************
public class Annie_Annie640_StepDefs {
    private Integer userId;
    private String activationCode;
    public String email,url;
    @Given("I open the application {string}")
    public void iOpenTheApplication(String url) {
        getDriver().get(url);
    }

    @Then("I click on the Register Now button")
    public void iClickOnTheRegisterNowButton() {
        getDriver().findElement(By.xpath(" //span[contains(text(),'Register Now')]")).click();
    }

    @Then("I should see the Registration Form")
    public void iShouldSeeTheRegistrationForm() {
        assert(getDriver().findElement(By.xpath("//h4[contains(text(),'Registration')]"))).isDisplayed();
    }


    @Then("I enter {string} as the firstname")
    public void iEnterAsTheFirstname(String fName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fName);
    }

    @And("I enter {string} as the last name")
    public void iEnterAsTheLastName(String lName) {
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

        //assert(getDriver().findElement(By.xpath("//button[@class='mat-button mat-primary']")).isDisplayed());
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

     //******************Successful registeration message************************
    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String message) {
        assert(getDriver().findElement(By.xpath("//ac-registration-confirmation-page")).isDisplayed());
    }

    // ****************Log In before Activation - Valid Credentials - Unsuccessful Attempt*********
    @Then("I click on Back-To-LogIn button")
    public void iClickOnBackToLogInButton() {
        assert(getDriver().findElement(By.xpath("//span[contains(text(),'Back to Login Page')]")).isDisplayed());
        getDriver().findElement(By.xpath("//span[contains(text(),'Back to Login Page')]")).click();
    }


    @Then("I must see page title as {string}")
    public void iMustSeePageTitleAs(String expectedTitle) {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Then("I {string} in Email and {string} in Password field")
    public void iInEmailAndInPasswordField(String email, String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click on the Sign-IN button")
    public void iClickOnTheSignINButton() {
        assert(getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).isDisplayed());
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("I should see the Authentication-Failed message")
    public void iShouldSeeTheAuthenticationFailedMessage() {
        assert(getDriver().findElement(By.xpath("//*[@aria-live='assertive'][contains (text(),'Authentication failed')]")).isDisplayed());
    }


    //******** Account Activation*****************************************

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
    public void iActivateTheAccount() throws IOException{
        Helpers.activateUser(userId, activationCode);
    }

//Log In after Activation - Valid Credentials (Email and Password) - SUCCESS
//Same methods re-used for entering credentials
    @Then("I must be able to see the home page")
    public void iMustBeAbleToSeeTheHomePage() {
        assert(getDriver().findElement(By.xpath("//ac-home-page")).isDisplayed());
    }

    //Logging In using Invalid Credentials (Email/Password)
    @Then("I must NOT be able to see the home page")
    public void iMustNOTBeAbleToSeeTheHomePage() {
        assert(!(getDriver().getCurrentUrl().equals(this.url)));
    }
//********************** Wait **************************************

    @Then("I wait for {int} seconds")
    public void iWaitForSeconds(int n) throws InterruptedException{
        Thread.sleep(n*1000);
    }
}

