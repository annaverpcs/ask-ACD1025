package definitions;

import cucumber.api.java.en.Given;
import pages.IHasURL;
import pages.LoginPage;


public class EmmaW_Generic_Stepdefs {
    @Given("I go to {string} page")
    public void iGoToPage(String pageName) {
        IHasURL iHasURL = null;
        switch (pageName){
            case "Assessment Control":

                iHasURL = new LoginPage();
                break;

            default:
                throw new Error("Unsupported page " + pageName);
        }
        iHasURL.openUrl();
    }



}
