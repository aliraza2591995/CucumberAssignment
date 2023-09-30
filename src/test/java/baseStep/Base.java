package baseStep;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    private static WebDriver driver;

    public static WebDriver setup(){
        WebDriverManager.chromedriver().setup();
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