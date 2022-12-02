package Definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class AnastMaksMyStepdefs {
    @Given("I open URL {string}")
    public void iOpenURL(String sURL) {
        getDriver().get(sURL);
    }

    @Then("Ana type {string} as Email")
    public void anaTypeAsEmail(String sEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
    }

    @Then("Ana type {string} as Password")
    public void anaTypeAsPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @And("Ana click on {string} button")
    public void anaClickOnButton(String sButton) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Ana wait for {int} secs")
    public void anaWaitForSecs(long iSec) throws InterruptedException {
        Thread.sleep(1000*iSec);
    }

    @Then("Ana create a new Quiz")
    public void anaCreateANewQuiz() {
        getDriver().findElement(By.xpath("//*[text()='Create New Quiz']")).click();
    }

    @Then("Ana type {string} as name of the quiz")
    public void anaTypeAsNameOfTheQuiz(String sQuiz) {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(sQuiz);
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("Ana create Multiple Choice question")
    public void anaCreateMultipleChoiceQuestion() {
        getDriver().findElement(By.xpath("//mat-radio-button[@id='mat-radio-4']")).click();
    }

    @Then("I validate that field allows alphanumeric and special characters")
    public void iValidateThatFieldAllowsAlphanumericAndSpecialCharacters() {
        getDriver().findElement(By.xpath("//*[@placeholder='Question *']")).sendKeys("Question45678!@#$");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys("OPTION167890)(*&^%$");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys("Option2!@$%^&65432");

    }

    @Then("Ana navigate to Quizzes")
    public void anaNavigateToQuizzes() {
        getDriver().findElement(By.xpath("//*[text()='Quizzes']")).click();
    }

    @Then("I validate that field is required")
    public void iValidateThatFieldIsRequired() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),' This field is required')]")).isDisplayed()).isTrue();
    }

    @Then("Ana have fields empty")
    public void anaHaveFieldsEmpty() {
        getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys("OPTION167890)(*&^%$");
        getDriver().findElement(By.xpath("//div[@class='controls ng-star-inserted shift']/button[@class='mat-button mat-primary']/span[@class='mat-button-wrapper']")).click();
    }

    @Then("I validate that field allows min {int} char")
    public void iValidateThatFieldAllowsMinChar(int arg0) {
        getDriver().findElement(By.xpath("//*[@placeholder='Question *']")).sendKeys("Q");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys("1");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys("@");
    }

    @Then("I validate that field allows max {int} char")
    public void iValidateThatFieldAllowsMaxChar(int arg0) {
        getDriver().findElement(By.xpath("//*[@placeholder='Question *']")).sendKeys("A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! And... here is the result, hope it helps out! And... here is the result.");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys("A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! And... here is the result, hope it helps out! And... here is the result.");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys("A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! And... here is the result, hope it helps out! And... here is the result.");
    }

    @Then("I validate that field does not accept more than {int} Character")
    public void iValidateThatFieldDoesNotAcceptMoreThanCharacter(int arg0) {
        getDriver().findElement(By.xpath("//*[@placeholder='Question *']")).sendKeys("AA while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! And... here is the result, hope it helps out! And... here is the result.");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys("AAA while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! And... here is the result, hope it helps out! And... here is the result.");
        getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys("AAAA while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet. There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out! And... here is the result, hope it helps out! And... here is the result.");
        getDriver().findElement(By.xpath("//*[text()='Maximum 1000 characters']")).isDisplayed();
    }
}
