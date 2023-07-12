package tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.apache.log4j.Logger;


public class BaseTest {
    public static Logger logger;
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        DOMConfigurator.configure("log4j.xml");
        logger = Logger.getLogger(BaseTest.class.getName());
        driver = new ChromeDriver();
        driver.get("https://www.beymen.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
