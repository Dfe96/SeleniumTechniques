import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;


public class Alerts {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            Assertion assertion = new Assertion();
            driver.findElement(By.id("alertbtn")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            driver.findElement(By.id("confirmbtn")).click();
            Thread.sleep(1000);
            driver.switchTo().alert().dismiss();
        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
