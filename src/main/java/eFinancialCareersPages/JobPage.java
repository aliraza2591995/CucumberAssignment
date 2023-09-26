package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobPage {
    private final WebDriver driver;
    private final By applyLink = By.xpath("(//button[@class='btn btn-small btn-primary ng-star-inserted'])[1]");
    private final By uploadLink = By.xpath("//button[@class='btn btn-outline btn-medium'][1]");
    private final By fileDropArea = By.xpath("//input[@id='fsp-fileUpload']");
    private final By modalTitle = By.xpath("//h4[@id='modal-title']");
    private final By fileDropAreaText = By.xpath("//div[@class='fsp-drop-area__title fsp-text__title']");
    private final By uploadButton = By.xpath("//*[@id=\"__filestack-picker\"]/div/div/div[1]/div[2]/div[3]/div/span[3]/div/span");
    private final By clearCV = By.cssSelector("body > modal-container > div.efc-standard-modal.modal-dialog > div > efc-job-application-container > div > efc-job-application > div > form > div:nth-child(2) > div.row > efc-form-dropdown-input > div > span > efc-icon.close > span > svg");
    private final By newCVlink = By.xpath("//*[@id=\"dropdown-file-list\"]/li[1]/div");
    private final By jobLink = By.xpath("/html/body/efc-shell-root/efc-job-search-page/div[2]/div/div/div/div/efc-job-search-results/div/div[2]/efc-job-card[1]/div/div[2]/efc-card-details/div[1]/div[2]/a");
    private final By apply = By.xpath("//button[@type='submit']");
    public JobPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyForJob() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement applyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(applyLink));
        applyElement.click();
    }

    public String checkJobPageStatus() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyLink));
        return driver.findElement(applyLink).getText();
    }

    public void clickUploadCV() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadLink));
        uploadElement.click();
    }

    public void uploadCV() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fileDropArea));
        driver.findElement(fileDropArea).sendKeys("A:/Docs/EE CV/Ali's Resume.pdf");
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadButton));
        driver.findElement(uploadButton).click();
    }

    public String fileDropAreaText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fileDropAreaText));
        return driver.findElement(fileDropAreaText).getText();
    }

    public void unhiddenUploadElement(By element) {
        WebElement hiddenInputElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.opacity = 1;", hiddenInputElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.height = 'auto';", hiddenInputElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.width = 'auto';", hiddenInputElement);
    }

    public String checkJobApplicationModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
        return driver.findElement(modalTitle).getText();
    }
    public void clickJobLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement jobLinkElement = wait.until(ExpectedConditions.elementToBeClickable(jobLink));
        jobLinkElement.click();
    }

    public void loadNewCV() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(clearCV));
        driver.findElement(clearCV).click();
        clickUploadCV();
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCVlink));
        driver.findElement(newCVlink).click();
    }
    public void apply(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement applyLink = wait.until(ExpectedConditions.elementToBeClickable(apply));
        applyLink.click();
    }
}