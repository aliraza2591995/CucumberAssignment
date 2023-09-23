package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobSearchPage {
    private final WebDriver driver;
    private final By searchResultText = By.xpath("//h1[contains(text(), 'QA Engineer')]");
    private final By jobSearchField = By.xpath("//input[@placeholder='Job title, keyword or company']");
    private final By locationField = By.xpath("//input[@placeholder='Location']");
    public JobSearchPage(WebDriver driver){
        this.driver = driver;
    }
    public String getJobSearchResultText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultText));
        return searchResultElement.getText();
    }

    public void jobSearch(String jobTitle, String location) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement jobSearchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobSearchField));
        jobSearchElement.sendKeys(jobTitle);
        driver.findElement(locationField).sendKeys(location + Keys.ENTER);
    }
    public JobPage page(){
        return new JobPage(driver);
    }
}