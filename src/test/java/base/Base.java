package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    private static WebDriver driver;

    public static WebDriver setup(){
        System.setProperty("webdriver.chrome.driver", "A:\\Em\\CucumberAssignment\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.efinancialcareers.com/");
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver teardown(){
        driver.quit();
        return driver;
    }
}