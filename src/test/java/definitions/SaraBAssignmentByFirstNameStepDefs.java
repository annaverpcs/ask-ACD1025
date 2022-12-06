package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class SaraBAssignmentByFirstNameStepDefs {
    public String studentName;
    public String assignmentStatus;

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
/*
    @And("SB click on quiz name")
    public void sbClickOnQuizName() {
        getDriver().findElement(By.xpath(SaraBXPathLibrary.sSelectQuiz1014Xpath)).click();

    }

 */

    @And("SB click on quiz name {string}")
    public void sbClickOnQuizName(String sQuizname) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sQuizname+"')]")).click();

    }


    @Then("SB click student {string} from the list")
    public void sbClickStudentFromTheList(String sStName) {
        getDriver().findElement(By.xpath("//span[text()='000']")).click();

    }

    @And("SB Check to see the quiz is assigned to the student")
    public void sbCheckToSeeTheQuizIsAssignedToTheStudent() {
        getDriver().findElement(By.xpath("//mat-expansion-panel[1]")).click();


    }

    @Then("SB get name field")
    public void sbGetNameField() {
        studentName = getDriver().findElement(By.xpath("//td[2]")).getText();
    }

    @Then("SB verify that student {string}")
    public void sbVerifyThatStudent(String sName) {
        assertThat(studentName).isEqualTo(sName);
    }

    @And("SB get get assignment status")
    public void sbGetGetAssignmentStatus() {
        assignmentStatus = getDriver().findElement(By.xpath("//td[3]/span")).getText();
    }

    @And("SB Verify that status is {string} pending assignment")
    public void sbVerifyThatStatusIsPendingAssignment(String sStatus) {
        assertThat(assignmentStatus).isEqualTo(sStatus);



    }


    @And("SB click button to remove assignment")
    public void sbClickButtonToRemoveAssignment() {
        getDriver().findElement(By.xpath("//span/mat-panel-title[4]")).click();

    }

    @And("SB remove the assignment")
    public void sbRemoveTheAssignment() {
        // getDriver().findElement(By.xpath("//mat-icon[contains(text(),'delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-menu-content ng-trigger ng-trigger-fadeInItems']")).click();



    }

    @And("SB see pop up window")
    public void sbSeePopUpWindow() {
        assertThat(getDriver().findElement(By.xpath("//ac-modal-confirmation")).isDisplayed()).isTrue();
    }
    @And("SB see delete button is displayed")
    public void sbSeeDeleteButtonIsDisplayed() {
        System.out.println(" I am inside delete button watch");
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")).isDisplayed()).isTrue();
    }

    @And("SB click delete button")
    public void sbClickDeleteButton() {

        // getDriver().findElement(By.xpath("//ac-modal-confirmation//button[2]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//button[2]//span")).click();
    }


    @And("SB click on pop up window")
    public void sbClickOnPopUpWindow() {
        getDriver().findElement(By.xpath("//p[contains(text(),'Are you sure you want to delete an Assignment? All')]")).click();

    }

    @Then("SB click outside the Thanks button")
    public void sbClickOutsideTheThanksButton() {
        getDriver().findElement(By.xpath("//p[contains(text(),'Are you sure you want to delete an Assignment? All')]")).click();


    }
}
