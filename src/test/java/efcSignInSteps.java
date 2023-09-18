import eFinancialCareersPages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class efcSignInSteps {
    private WebDriver driver;
    private HomePage homePage;

    @Given("User is on the SignIn page of eFinancialCareers")
    public void userIsOnTheSignInPageOfEFinancialCareers() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.efinancialcareers.com/");
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        homePage.clickSignIn();
        System.out.println(homePage.getOverlayText());
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
        System.out.println(homePage.checkLoginStatus());
        assertEquals(homePage.checkLoginStatus(), "Ali Raza", "Login failed");
    }
}
