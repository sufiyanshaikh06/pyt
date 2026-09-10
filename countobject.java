package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class countobject {

    public static void main(String[] args) {

        WebDriver wd = new ChromeDriver();

        wd.get("https://programiz.com");

        List<WebElement> elements = wd.findElements(By.xpath("//*"));

        System.out.println("TOTAL ELEMENTS COUNT : " + elements.size());

        wd.quit();
    }
}
