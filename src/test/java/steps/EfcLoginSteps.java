package steps;

import baseStep.Base;
import com.fasterxml.jackson.databind.ObjectMapper;
import eFinancialCareersPages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import readData.User;
import readData.UserData;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class EfcLoginSteps extends Base {
    private List<User> users;
    private WebDriver driver = Base.setup();
    private final HomePage homePage = new HomePage(driver);

    // Scenario: Login Successful

    @Given("User is on the SignIn page of eFinancialCareers")
    public void userIsOnTheSignInPageOfEFinancialCareers() {
        homePage.clickSignIn();
        assertEquals(homePage.getOverlayText(), "Welcome to your next opportunity", "Didn't clicked login button correctly");
    }
//    @When("User enters email and password")
//    public void userEntersEmailAndPassword() {
//        for (User user : users) {
//            homePage.enterEmail(user.getEmail());
//            homePage.enterPassword(user.getPassword());
//        }
//    }
    @When("User enters {string} and {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                homePage.enterEmail(user.getEmail());
                homePage.enterPassword(user.getPassword());
            }
        }
    }
    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        homePage.clickProfileButton();
        assertEquals(homePage.checkLoginStatus(), "Ali Raza", "Login failed");
        driver = Base.teardown();
    }
    @Before
    public void jsonSetup() throws IOException {
        // Read JSON data and load it into the 'users' list
        ObjectMapper objectMapper = new ObjectMapper();
        UserData userData = objectMapper.readValue(new File("C:\\Users\\Emumba\\IdeaProjects\\CucumberAssignment\\src\\test\\resources\\testData\\credentials.json"), UserData.class);
        users = userData.getUsers();
    }
}