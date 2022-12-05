package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static support.TestContext.getDriver;

public class Annie_AssignmentDate_StepDefs{

    //**************************ACD- 197 LOGIN SCENARIO METHODS*************************

    @Given("I open the ASK application {string}")
    public void iOpenTheASKApplication(String url) {
        getDriver().get(url);
    }

    @Then("I type the email as {string} and password in {string} fields")
    public void iTypeTheEmailAsAndPasswordInFields(String email, String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click on Sign-IN button")
    public void iClickOnSignINButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("I must see the page title as {string}")
    public void iMustSeeThePageTitleAs(String expectedTitle) {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Then("I click on Assignments from the menu")
    public void iClickOnAssignmentsFromTheMenu() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains (text(),'Assignments')]")).click();
    }

    @And("see the list of Assignments")
    public void seeTheListOfAssignments() {
        assert(getDriver().findElement(By.xpath("//*[@class='mat-accordion']")).isDisplayed());
    }

    //**********************ACD-210 Create Assignment to confirm Assignment Date is present  ********

    @Then("I click on Create-Assignment button")
    public void iClickOnCreateAssignmentButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @Then("I select the Group-Filter {string}")
    public void iSelectTheGroupFilter(String S) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@formcontrolname='groupFilter']")).click();
        S = "//span[@class='mat-option-text'][contains(text(),'" + S + "')]";
        iWait();
        getDriver().findElement(By.xpath(S));
        getDriver().findElement(By.xpath(S)).click();
    }


    @And("I select the quiz name {string}")
    public void iSelectTheQuizName(String Q) throws InterruptedException {
        Q = "//span[contains(text(),'" + Q + "')]";
        getDriver().findElement(By.xpath("//mat-select[@formcontrolname='quizId']")).click();
        iWait();
        getDriver().findElement(By.xpath(Q)).click();
    }


    @Then("I select all the students")
    public void iSelectAllTheStudents() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select All')]")).click();
    }


    @And("click on Give-Assignment button")
    public void clickOnGiveAssignmentButton() {
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper'][contains(text(),'Give Assignment')]")).click();
    }
//********************ACD 300 ***************************************************
    @Then("I check that the most recent assignment on top has the current date")
    public void iCheckThatTheMostRecentAssignmentOnTopHasTheCurrentDate() {
        String assignmentDate = getDriver().findElement(By.xpath("//*[contains (text(),'Assignment Date')]")).getText();
        String arr[] = assignmentDate.split(":");
        String actualDate=arr[1].trim();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        String currentDate=formatter.format(new Date());
        System.out.println(currentDate);
        Assert.assertEquals(currentDate, actualDate);
        System.out.println("Assignment Date asserted");
    }
  //***********************ACD-302 Assignment Date in Detailed View*************************************
    @Then("I click on the topmost Assignment")
    public void iClickOnTheTopmostAssignment(){
        getDriver().findElement(By.xpath("//*[contains (text(),'Assignment Date')]")).click();
    }

    @And("I confirm that Assignment Date is present in detailed view")
    public void iConfirmThatAssignmentDateIsPresentInDetailedView() {
        assert(getDriver().findElement(By.xpath("//*[@class='mat-expansion-panel-body']")).isDisplayed());
        assert(getDriver().findElement(By.xpath("//*[contains (text(),'Assignment Date')]")).isDisplayed());
    }


    //*********************WAIT *******************************************
    @And("I wait")
    public void iWait() throws InterruptedException {
        Thread.sleep(2000);
    }

}
