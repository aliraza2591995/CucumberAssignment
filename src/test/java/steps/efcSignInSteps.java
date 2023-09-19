package steps;

import eFinancialCareersPages.HomePage;
import eFinancialCareersPages.JobPage;
import eFinancialCareersPages.JobSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class efcSignInSteps {

    private WebDriver driver;
    private HomePage homePage;
    private JobSearchPage jobSearchPage;
    private JobPage jobPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.efinancialcareers.com/");
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }
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
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    @Given("User is on job search page, logged in and enters valid {string} and {string}")
    public void userIsOnJobSearchPageLoggedInAndEntersValidJobTitleAndLocation(String jobTitle, String location) {
        homePage.clickSignIn();

        homePage.enterEmail("aliomessi.19@gmail.com");
        homePage.enterPassword("Aliraza.10");

        jobSearchPage = homePage.page();
        jobSearchPage.jobSearch(jobTitle, location);
        assertTrue(jobSearchPage.getJobSearchResultText().contains("QA Engineer jobs"), "Job search failed");
    }

    @When("User clicks a job link, the user should be taken to job page")
    public void userClicksAJobLinkTheUserShouldBeTakenToJobPage() {
        jobPage = jobSearchPage.page();
        jobPage.clickJobLink();
        assertEquals(jobPage.checkJobPageStatus(), "Apply now", "Click job link failed");
    }

    @Then("User clicks Apply now")
    public void userClicksApplyNow() {
        jobPage.applyForJob();
        assertEquals(jobPage.checkJobApplicationModal(), "Your application", "Job application modal not found");
    }

    @And("User uploads CV")
    public void userUploadsCV() {
        By hiddenElement = By.xpath("//*[@id=\"fsp-fileUpload\"]");
        jobPage.loadNewCV();
        assertEquals(jobPage.fileDropAreaText(), "Select Files to Upload", "File drop area not found");
        jobPage.unhiddenUploadElement(hiddenElement);
        jobPage.uploadCV();
    }
}