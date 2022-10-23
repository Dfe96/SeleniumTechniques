import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Task4 {

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");
            driver.findElement(By.cssSelector(" a[href='/nested_frames']")).click();
            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name*='frame-top']")));
            System.out.println("1");
            //driver.switchTo().frame(driver.findElement(By.cssSelector("frameset[name='frameset-middle']")));

            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name*='frame-middle']")));
            System.out.println("2");
            System.out.println(driver.findElement(By.id("content")).getText());
            driver.quit();




        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
