package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;

    public static void initializeDriver() throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//resources//GlobalData.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
    }

    public static void logOut() {
        boolean profileButton = driver.findElement(By.xpath("//div[@aria-label='Your profile']")).isDisplayed();
        Assert.assertTrue(profileButton);
        driver.findElement(By.xpath("//div[@aria-label='Your profile']")).click();
        driver.findElement(By.xpath("//span[text()='Log out']")).click();
        driver.quit();
    }

    public static void selectTheElementByValue(WebElement ele, String value) {
        Select select = new Select(ele);
        select.selectByValue(value);
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }
}
