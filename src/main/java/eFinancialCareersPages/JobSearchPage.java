package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobSearchPage {
    private WebDriver driver;
    private By searchResultText = By.xpath("//h1[contains(text(), 'QA Engineer')]");
    private By jobLink = By.xpath("//*[@id=\"rbVRgNtRyil1iTia\"]/h3");
    public JobSearchPage(WebDriver driver){
        this.driver = driver;
    }
    public String getJobSearchResultText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultText));
        return searchResultElement.getText();
    }
    public JobPage clickJobLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement jobLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobLink));
        jobLinkElement.click();
        return new JobPage(driver);
    }
}