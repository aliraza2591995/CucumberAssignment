package steps;

import baseStep.Base;
import eFinancialCareersPages.HomePage;
import eFinancialCareersPages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class EfcDeleteCVsteps extends Base{
    private WebDriver driver = Base.setup();
    private final HomePage homePage = new HomePage(driver);
    private ProfilePage profilePage;
    String pattern = "\\d+";
    Pattern regex;
    Matcher matcher;
    String resumesCount;
    String newResumesCount;
    int resumeCount;
    int newResumeCount;
    @Given("User is logged in on eFinancialCareers")
    public void userIsLoggedInOnEFinancialCareers() {
        homePage.clickSignIn();
        homePage.enterEmail("aliomessi.19@gmail.com");
        homePage.enterPassword("Aliraza.10");
    }

    @And("User is on homepage")
    public void userIsOnHomepage() {
        assertTrue(homePage.getHomePageText().contains("Empower your") || homePage.getHomePageText().contains("Build your") || homePage.getHomePageText().contains("Find your"), "User is not on Home page");

        homePage.clickProfileButton();
        homePage.clickMyProfile();

        profilePage = homePage.ProfilePage();
        profilePage.clickDocumentButton();

        resumesCount = profilePage.getResumesCount();
        regex = Pattern.compile(pattern);
        matcher = regex.matcher(resumesCount);
        matcher.find();
        resumeCount = Integer.parseInt(matcher.group());
    }

    @When("User tries to delete a CV document from their profile")
    public void userTriesToDeleteACVDocumentFromTheirProfile() {
        profilePage.clickRemoveButton();
        profilePage.clickDeleteButton();
    }

    @Then("The CV document should be deleted successfully")
    public void theCVDocumentShouldBeDeletedSuccessfully() throws InterruptedException{
        Thread.sleep(5000);

        newResumesCount = profilePage.getResumesCount();
        regex = Pattern.compile(pattern);
        matcher = regex.matcher(newResumesCount);
        matcher.find();
        newResumeCount = Integer.parseInt(matcher.group());

        assertTrue(((resumeCount - newResumeCount) == 1), "Resume deletion unsuccessful");

        driver = Base.teardown();
    }
}