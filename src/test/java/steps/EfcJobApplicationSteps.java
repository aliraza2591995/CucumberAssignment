package steps;

import baseStep.Base;
import eFinancialCareersPages.HomePage;
import eFinancialCareersPages.JobPage;
import eFinancialCareersPages.JobSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EfcJobApplicationSteps extends Base{
    private WebDriver driver = Base.setup();
    private final HomePage homePage = new HomePage(driver);
    private JobPage jobPage;
    private JobSearchPage jobSearchPage;
    @Given("User is on job search page, logged in and enters valid {string} and {string}")
    public void userIsOnJobSearchPageLoggedInAndEntersValidJobTitleAndLocation(String jobTitle, String location) {
        homePage.clickSignIn();

        homePage.enterEmail("aliomessi.19@gmail.com");
        homePage.enterPassword("Aliraza.10");

        jobSearchPage = homePage.page();
        jobSearchPage.jobSearch(jobTitle, location);
        assertTrue(jobSearchPage.getJobSearchResultText().contains(jobTitle + " jobs"), "Job search failed");
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

    @Then("User completes the application process")
    public void userCompletesTheApplicationProcess() {
        jobPage.apply();
        driver = Base.teardown();
    }
}