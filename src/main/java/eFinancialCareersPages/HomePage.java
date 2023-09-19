package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By signIn = By.xpath("//button[@class='btn btn-secondary btn-medium ng-star-inserted']");
    private By overLayText = By.xpath("//span[text()='Welcome to your next opportunity']");
    private By emailInput = By.xpath("//input[@placeholder='Email']");
    private By continueButton = By.xpath("//button[text() = 'Continue']");
    private By passwordInput = By.xpath("//input[@name='password']");
    private By submitCredentialsButton = By.xpath("//button[text()='Submit']");
    private By profileButton = By.xpath("//div[@id='button-basic']");
    private By profileName = By.xpath("//*[@id=\"dropdown-avatar-container\"]/div/span[1]");
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
}