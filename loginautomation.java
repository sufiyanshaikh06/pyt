import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginautomation {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");

        driver.findElement(By.id("password")).sendKeys("Password123");

        driver.findElement(By.id("submit")).click();

        assert (driver.getTitle().equals("Logged In Successfully | Practice Test Automation"));

        driver.findElement(By.linkText("Log out")).click();

        driver.quit();
    }
}
