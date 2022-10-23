import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SeleniumDemo {
    public static void main(String[] args) {

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            WebDriver driver2 = new ChromeDriver();
            driver.get("https://www.neowin.net/software/google-chrome-10605249119-offline-installer/");
            System.out.println(driver.getTitle());
            //driver.findElement(By.id("comment ")).sendKeys("Selenium info");
            //driver.findElement(By.id("email ")).sendKeys("JustAkey"); css-47sehv
            driver.findElement(By.className("css-47sehv")).click();
            driver.quit();
            driver2.get("http://www.seleniumframework.com/Practiceform/");
            driver2.findElement(By.name("email")).sendKeys("hola");
            driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //<button style="background-color:DarkGreen" id="doubleClick" ondblclick="ColorChanged()" xpath="1">Change Color</button>
            driver2.findElement(By.cssSelector("button[style='background-color:DarkGreen']")).click();

            //<a xpath="1">Find me I have nothing in me!!</a>
            // String a=driver2.findElement(By.cssSelector("a[xpath='1']")).getText();

            System.out.println(driver2.findElement(By.xpath("//a[normalize-space()='Find me I have nothing in me!!']")));
            driver2.quit();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
