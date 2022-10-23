import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Task3 {

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");

            //-----------------------------------------------------------------------------------------
            //Este código es muy interesante! abre una nueva página
            //
            //String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            //driver.findElement(By.cssSelector("a[href*='/windows']")).sendKeys(selectLinkOpeninNewTab);
            //--------------------------------------------------------------------------------------------
            driver.findElement(By.cssSelector("a[href*='/windows']")).click();
            driver.findElement(By.cssSelector("a[href$='/windows/new']")).click();
            Set<String> windows = driver.getWindowHandles();//[parent_id, child_id,child_child_id]
            Iterator<String> windowsIterator = windows.iterator();
            String parent_id = windowsIterator.next();
            String child_id = windowsIterator.next();
            driver.switchTo().window(child_id);


            String sol1 = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
            System.out.println(sol1);
            driver.switchTo().window(parent_id);
            String sol2 = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
            System.out.println(sol2);
            driver.quit();

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
