package org.example;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class gridtest {

    public static void main(String[] args) throws Exception {

        // Chrome Test
        ChromeOptions chrome = new ChromeOptions();

        WebDriver driver1 = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                chrome);

        driver1.get("https://www.google.com");

        System.out.println("Chrome Title : " + driver1.getTitle());

        driver1.quit();


        // Firefox Test

        FirefoxOptions firefox = new FirefoxOptions();

        WebDriver driver2 = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                firefox);

        driver2.get("https://www.google.com");

        System.out.println("Firefox Title : " + driver2.getTitle());

        driver2.quit();

    }
}
