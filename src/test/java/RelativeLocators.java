import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            driver.get("https://rahulshettyacademy.com/angularpractice/");
            WebElement target=driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']"));
            System.out.println(target.getText());
            System.out.println(driver.findElement(with(By.tagName("label")).above(target)).getText());

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }
    }
}
