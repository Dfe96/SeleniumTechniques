import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class WindowNavigate {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();//configuración del Webdriver.
        //el metodo navigate().to() va a acceder a la página directamente, esté o no 100*100 cargada
        driver.navigate().to("https://www.w3schools.com/java/tryjava.asp?filename=demo_helloworld");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}
