import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task6 {

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");

            js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
            List<WebElement> elementList = driver.findElements(By.cssSelector(".table-display tr"));
            List<WebElement> elementList1 = driver.findElements(By.cssSelector(".table-display th"));
            System.out.println(elementList.size());
            System.out.println(elementList1.size());
            String compare=driver.findElement(By.cssSelector(".table-display tr:nth-child(2)")).getText();
            for (WebElement element :elementList
                 ) {
                if(compare.equals(element.getText()))
                System.out.println(element.getText());


            }


        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
