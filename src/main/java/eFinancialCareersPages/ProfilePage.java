package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    private final By documents = By.xpath("//*[@id=\"content\"]/div/div/dhi-candidate-profile/div/div[1]/dhi-nav/div/nav/a[2]");
    private final By deleteButton = By.xpath("//button[text()=' Delete ']");
    private final By removeButton = By.xpath("//*[@id=\"cv-list\"]/section/div[1]/div/dhi-resume-item/div/div/div[2]/dhi-remove-button");
    private final By resumesCount = By.xpath("//*[@id=\"cv-list\"]/section/h3");
    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickDocumentButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(documents));
        driver.findElement(documents).click();
    }
    public void clickRemoveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        driver.findElement(removeButton).click();
    }
    public void clickDeleteButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        driver.findElement(deleteButton).click();
    }
    public String getResumesCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resumesCount));
        return driver.findElement(resumesCount).getText();
    }
}