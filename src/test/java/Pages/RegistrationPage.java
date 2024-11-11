package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.By;

import java.io.IOException;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() throws IOException {
        initializeDriver();
    }

    public void createNewAccount(){
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        driver.findElement(By.xpath("//input[@aria-label='First name']")).click();
        driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("Sourav");
        driver.findElement(By.xpath("//input[@aria-label='Surname']")).click();
        driver.findElement(By.xpath("//input[@aria-label='Surname']")).sendKeys("Kumar");

        selectTheElementByValue(driver.findElement(By.id("day")),"5");
        selectTheElementByValue(driver.findElement(By.id("month")),"3");
        selectTheElementByValue(driver.findElement(By.id("year")),"1999");

        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).click();
        driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("9898989897");
        driver.findElement(By.xpath("//input[@data-type='password']")).click();
        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("SOURAV");
    }

}
