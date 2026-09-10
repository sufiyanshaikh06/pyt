import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropdown {

    public static void main(String[] args) {

        WebDriver wd = new ChromeDriver();

        wd.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement dropdown = wd.findElement(By.name("my-select"));

        Select select = new Select(dropdown);

        List<WebElement> options = select.getOptions();

        System.out.println("TOTAL NUMBER OF ITEMS : " + options.size());

        System.out.println("DROPDOWN ITEMS:");

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        WebElement defaultOption = select.getFirstSelectedOption();

        System.out.println("DEFAULT SELECTED VALUE : "
                + defaultOption.getText());

        select.selectByVisibleText("Two");

        String selectedValue = select.getFirstSelectedOption().getText();

        System.out.println("AFTER SELECTION : " + selectedValue);

        if (selectedValue.equals("Two")) {
            System.out.println("SELECTION TEST PASSED");
        } else {
            System.out.println("SELECTION TEST FAILED");
        }

        wd.quit();
    }
}
