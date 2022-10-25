import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) {
        try {
            SoftAssert assertion = new SoftAssert();
            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);//Este código es muy interesante! abre una nueva página
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            List<WebElement> listUrl = driver.findElements(By.cssSelector("table a"));
            //STEP 1- get all URLs


            for (WebElement element : listUrl
            ) {
                String url = element.getAttribute("href");
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
//                System.out.println(conn.getResponseCode());
                if (conn.getResponseCode() > 400) {
                    assertion.assertTrue(false);
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                }

            }
            assertion.assertAll();

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
