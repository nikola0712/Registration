package pageobject;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;
public class BaseClass
{
    public WebDriver driver;

    @BeforeClass
    public void setUpRegistration() throws IOException {
        Properties properties = new Properties();
        java.net.URL url = ClassLoader.getSystemResource("data.properties");
        properties.load(url.openStream());

        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(properties.getProperty("registerUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }
}
