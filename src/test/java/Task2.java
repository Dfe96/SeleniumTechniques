import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("   https://rahulshettyacademy.com/loginpagePractise/");
            driver.findElement(By.cssSelector("a.blinkingText")).click();
            Set<String> windows =driver.getWindowHandles();//[parent_id, child_id]
            Iterator<String> windowsIterator=windows.iterator();
            String parent_id= windowsIterator.next();
            String child_id= windowsIterator.next();
            driver.switchTo().window(child_id);
            String[] mail= driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ");
            String[] mail2= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at");
            System.out.println(mail[4]);
            driver.switchTo().window(parent_id);

            Assertion assertion = new Assertion();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //LOGIN PAGE

            String a=driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();

            a= a.replace("(","");
            a= a.replace(")","");
            String[] splited=a.split(" ");

            driver.findElement(By.id("username")).sendKeys(mail[4]);
            driver.findElement(By.id("password")).sendKeys(splited[2]);
            driver.findElement(By.xpath("//div[@class='form-check-inline']//label[2]/span[@class='checkmark']")).click();
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("okayBtn")))).click();

            driver.findElement(By.id("okayBtn")).click();
            List<WebElement>list= driver.findElements(By.cssSelector("select.form-control option"));
            int counter=0;
            for (WebElement element:list
                 ) {

                if(element.getText().equals("Consultant")){
                    element.click();
                    System.out.println("ready!");
                }
                counter++;
            }
            driver.findElement(By.id("terms")).click();
            driver.findElement(By.id("signInBtn")).click();

            ;

            driver.quit();

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }





}
