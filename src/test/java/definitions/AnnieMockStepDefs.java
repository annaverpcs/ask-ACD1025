package definitions;
import cucumber.api.java.en.Given;
import static support.TestContext.getDriver;
public class AnnieMockStepDefs {
    @Given("I open URL {string}")
    public void iOpenURL(String url) {
        getDriver().get(url);
    }
}
