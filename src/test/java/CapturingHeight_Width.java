import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class CapturingHeight_Width {
    public static void main(String[] args) {
        try {
            //-------------------------------------ConfigVar--------------------------------------------//
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(2));
            driver.get("https://rahulshettyacademy.com/angularpractice/");
            //-----------------------------------------------------------------------------------------//

            WebElement name= driver.findElement(By.cssSelector("[name='name']"));
            name.sendKeys("coursename");
            System.out.println(name.getRect().getDimension().getHeight());
            System.out.println(name.getRect().getHeight());
            System.out.println(name.getRect().getDimension().getWidth());

            driver.quit();
        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
