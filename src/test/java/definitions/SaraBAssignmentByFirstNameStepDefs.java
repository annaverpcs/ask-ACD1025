package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class SaraBAssignmentByFirstNameStepDefs {

    @Then("SB click on  Email  field")
    public void sbClickOnEmailField() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sEmailXpath)).click();
    }

    @And("SB enter Email {string} address")
    public void sbEnterEmailAddress(String sEmail) {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sEmailXpath)).sendKeys(sEmail);
    }

    @Then("SB click on password   field")
    public void sbClickOnPasswordField() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sPasswordXpath)).click();
    }

    @And("SB Enter password {string}")
    public void sbEnterPassword(String sPasswrd) {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sPasswordXpath)).sendKeys(sPasswrd);

    }


    @Then("SB click sign in  button")
    public void sbClickSignInButton() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSignInButtonXpath)).click();
    }

    @When("SB click on Assignments on side menu")
    public void sbClickOnAssignmentsOnSideMenu() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sAssignmentsXpath)).click();
    }

    @Then("SB Should see List of Assignments")
    public void sbShouldSeeListOfAssignments() {
        assertThat(getDriver().findElement(By.xpath(SaraBXPathLibrary.sAssignmentListXpath)).isDisplayed()).isTrue();
    }

    @Then("SB click on Create New Assignment button")
    public void sbClickOnCreateNewAssignmentButton() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sCreateNewAssignmentXpath)).click();
    }

    @Then("SB should see page Give Assignment")
    public void sbShouldSeePageGiveAssignment() {
        assertThat(getDriver().findElement(By.xpath(SaraBXPathLibrary.sGiveAssignmentXpath)).isDisplayed()).isTrue();

    }

    @And("SB click Select Quiz To Assign")
    public void sbClickSelectQuizToAssign() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectQuizToAssignXpath)).click();

    }

    @And("SB click on Quiz to assign")
    public void sbClickOnQuizToAssign() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectQuiz1014Xpath)).click();

    }

    @Then("SB click one student from the list")
    public void sbClickOneStudentFromTheList() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectStudentToAssignXpath)).click();

    }

    @Then("SB click on the button Give Assignment")
    public void sbClickOnTheButtonGiveAssignment() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectGiveAssignmentXpath)).click();

    }

    @And("SB click on Select Quiz to Assign")
    public void sbClickOnSelectQuizToAssign() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectQuizToAssignXpath)).click();

    }

    @Then("SB click on Home on the side panel")
    public void sbClickOnHomeOnTheSidePanel() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectHomeXpath)).click();

    }

    @And("SB click on Go To Assignments")
    public void sbClickOnGoToAssignments() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sGoToAssignmentXpath)).click();

    }

    @And("SB click on quiz name")
    public void sbClickOnQuizName() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectQuiz1014Xpath)).click();

    }

    @And("SB Check to see the quiz is assigned to the student")
    public void sbCheckToSeeTheQuizIsAssignedToTheStudent() {
    }
}
