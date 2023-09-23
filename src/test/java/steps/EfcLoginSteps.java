package steps;

import base.Base;
import eFinancialCareersPages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


import static org.testng.Assert.assertEquals;

public class EfcLoginSteps extends Base {
    private WebDriver driver = Base.setup();
    private final HomePage homePage = new HomePage(driver);

    // Scenario: Login Successful

    @Given("User is on the SignIn page of eFinancialCareers")
    public void userIsOnTheSignInPageOfEFinancialCareers() {
        homePage.clickSignIn();
        assertEquals(homePage.getOverlayText(), "Welcome to your next opportunity", "Didn't clicked login button correctly");
    }

    @When("User enters valid {string} and {string}")
    public void userEntersValidEmailAndPassword(String email, String password) {
        homePage.enterEmail(email);
        homePage.enterPassword(password);
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        homePage.clickProfileButton();
        assertEquals(homePage.checkLoginStatus(), "Ali Raza", "Login failed");
        driver = Base.teardown();
    }
}