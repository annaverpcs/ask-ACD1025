package definitions;

import cucumber.api.java.en.Given;

import static support.TestContext.getDriver;

public class AnnaVStepDefs {

    @Given("AV navigate to {string}")
    public void iNavigateTo(String sURL) {
        getDriver().get(sURL);
    }
}

