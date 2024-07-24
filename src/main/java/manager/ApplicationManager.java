package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver driver;
    private ChromeOptions chromeOptions;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    public WebDriver getDriver(){
        return driver;
    }
    @BeforeMethod
    public void setUp(){
        chromeOptions = new ChromeOptions().addArguments("--lang=en");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //задержка для всех элементов
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        //задержка для javascript (wait for script for finish execution)
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        // дожидаться загрузки страницы (wait for loading page)
    }
    @AfterMethod
    public void tearDown(){
       //if(driver !=null)
         //  driver.quit();
    }
}
