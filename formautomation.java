package org.example;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class formautomation {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        driver.findElement(By.id("name")).sendKeys("Jaya");

        driver.findElement(By.id("email")).sendKeys("jaya@gmail.com");

        driver.findElement(By.id("phone")).sendKeys("9876543210");

        driver.findElement(By.id("textarea")).sendKeys("Ulhasnagar");

        driver.findElement(By.id("female")).click();

        driver.findElement(By.id("monday")).click();

        driver.findElement(By.id("wednesday")).click();

        Select country = new Select(driver.findElement(By.id("country")));

        country.selectByVisibleText("India");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertBtn")));

        driver.findElement(By.id("alertBtn")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

        driver.quit();
    }
}
