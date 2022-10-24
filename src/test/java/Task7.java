import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            driver.findElement(By.id("autocomplete")).sendKeys("ire");
            Duration duration = Duration.ofSeconds(1);
            WebDriverWait wait= new WebDriverWait(driver,duration);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ui-menu-item-wrapper")));
            List<WebElement> listElements= driver.findElements(By.cssSelector("div.ui-menu-item-wrapper"));

            for (WebElement element:listElements
                 ) {
                if (element.getText().equals("Ireland")){
                    element.click();
                }
            }



        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
