import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowNavigate {
    public static void main(String[] args) {
        try {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            driver.manage().window().maximize();//configuración del Webdriver.
            //el metodo navigate().to() va a acceder a la página directamente, esté o no 100*100 cargada
            driver.navigate().to("https://www.w3schools.com/java/tryjava.asp?filename=demo_helloworld");
            driver.navigate().back();
            driver.navigate().forward();
            driver.navigate().refresh();
            driver.navigate().back();
            //---------------------------------------------------------------------------------------------------------
//            //Navigate with Iterator list
//            driver.switchTo().newWindow(WindowType.WINDOW);
//            Set<String> handles = driver.getWindowHandles();
//            Iterator<String> iter = handles.iterator();
//            String parent = iter.next();
//            String child = iter.next();
//            driver.switchTo().window(child);
//            driver.switchTo().window(parent);
            //---------------------------------------------------------------------------------------------------------
            List<WebElement> listUrl = driver.findElements(By.cssSelector("table a"));
            //code for open a list of url an check all the codes


            for (WebElement element : listUrl
            ) {
                String url = element.getAttribute("href");
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
//                System.out.println(conn.getResponseCode());
                if (conn.getResponseCode() > 400) {
                    System.out.println("there is a broken link!");
                }

            }

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }

    }
}
