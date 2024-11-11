package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage extends BaseTest {


    public LoginPage() throws IOException {
        initializeDriver();
    }

    public void LoginToTheApp()
    {
        driver.findElement(By.id("email")).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.id("pass")).sendKeys(prop.getProperty("Password"));
        driver.findElement(By.name("login")).click();
        boolean homeIcon = driver.findElement(By.xpath("//a[@aria-label='Home']")).isDisplayed();
        Assert.assertTrue(homeIcon);
        driver.findElement(By.xpath("//a[@aria-label='Home']")).click();
    }

    public void createAPost(){
        driver.findElement(By.xpath("(//div[contains(@class,'x1i10hfl x1ejq31n xd10rxx')])[1]")).click();
        boolean CreatePostText = driver.findElement(By.xpath("//span[text()='Create post']")).isDisplayed();
        Assert.assertTrue(CreatePostText);
        driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']")).click();
        driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']")).sendKeys(generateRandomString(12));
        driver.findElement(By.xpath("//span[contains(text(),'Post')]")).click();
        boolean postMessage = driver.findElement(By.xpath("(//div[@data-ad-rendering-role='message'])[1]")).isDisplayed();
        Assert.assertTrue(postMessage);
    }
}
