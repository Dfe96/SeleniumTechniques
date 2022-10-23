import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

public class Task1 {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/angularpractice/");

            //------------------------------------------------------------------
            driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("Test");

            driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("your");

            driver.findElement(By.id("exampleInputPassword1")).sendKeys("page");
            driver.findElement(By.id("exampleCheck1")).click();
            driver.findElement(By.id("exampleFormControlSelect1")).click();
            //driver.findElement(By.xpath("//select/option[contains(.,'Female')]")).click();
            //teacher solution with Select Class
            WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByVisibleText("Female");

            driver.findElement(By.xpath("//div/input[@name='bday']")).sendKeys("1000-01-02");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            Thread.sleep(1000);
            String val=driver.findElement(By.cssSelector("div[class*='alert '] strong")).getText();

            Assertion assertion = new Assertion();
            assertion.assertEquals(val,"Success!");
            driver.quit();
        }catch (Exception exception){
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }





    }
}
