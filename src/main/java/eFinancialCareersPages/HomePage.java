package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final By signIn = By.xpath("//button[@class='btn btn-secondary btn-medium ng-star-inserted']");
    private final By overLayText = By.xpath("//span[text()='Welcome to your next opportunity']");
    private final By emailInput = By.xpath("//input[@placeholder='Email']");
    private final By continueButton = By.xpath("//button[text() = 'Continue']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By submitCredentialsButton = By.xpath("//button[text()='Submit']");
    private final By profileButton = By.xpath("//div[@id='button-basic']");
    private final By profileName = By.xpath("//*[@id=\"dropdown-avatar-container\"]/div/span[1]");
    private final By homePageText = By.xpath("/html/body/efc-shell-root/efc-homepage/div[1]/efc-search-section/efc-job-search-headline/div/span[1]");
    private final By myProfileButton = By.xpath("//div[text()='My Profile']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickSignIn(){
        driver.findElement(signIn).click();
    }
    public String getOverlayText(){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement overlayElement = wait.until(ExpectedConditions.visibilityOfElementLocated(overLayText));
        return overlayElement.getText();
    }
    public void enterEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(continueButton).click();
    }
    public void enterPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.sendKeys(password);
        driver.findElement(submitCredentialsButton).click();
    }
    public void clickProfileButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        profile.click();
    }
    public String checkLoginStatus(){
        return driver.findElement(profileName).getText();
    }
    public JobSearchPage page(){
        return new JobSearchPage(driver);
    }
    public String getHomePageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageText));
        return driver.findElement(homePageText).getText();
    }
    public void clickMyProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myProfileButton));
        driver.findElement(myProfileButton).click();
    }
    public ProfilePage ProfilePage() {
        return new ProfilePage(driver);
    }
}