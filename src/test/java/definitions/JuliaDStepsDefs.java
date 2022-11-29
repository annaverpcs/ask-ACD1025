package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class JuliaDStepsDefs {
    @Given("I open URL {string}")
    public void iOpenURL(String sURL) {
        getDriver().get(sURL);
    }
}
