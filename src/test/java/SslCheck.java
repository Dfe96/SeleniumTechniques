import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SslCheck {
    public static void main(String[] args) {
        try {
            ChromeOptions capability = new ChromeOptions();//bypass conexion no segura
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);


//            ChromeOptions options =new ChromeOptions();//esta es la sol del profesor, no funciona
//            options.setAcceptInsecureCerts(true);

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver(capability);
            driver.get("https://expired.badssl.com/");




        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
