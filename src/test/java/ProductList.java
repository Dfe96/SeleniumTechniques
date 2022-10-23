
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ProductList {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
            Assertion assertion = new Assertion();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


            //Thread.sleep(2000);
            List<WebElement> list=driver.findElements(By.cssSelector("h4.product-name"));
            List<WebElement> vegetables=driver.findElements(By.xpath("//div/h4"));
            Duration duration = Duration.ofSeconds(1);

            System.out.println("BUCLE FOR");
            int counter=0;
            for (WebElement i:list
                 ) {
                String txt=i.getText();
                if(txt.contains("Cucumber")){
                    System.out.println("LISTO");
                    driver.findElements(By.cssSelector("a.increment")).get(counter).click();
                    driver.findElements(By.xpath("//div/button[@type='button']")).get(counter).click();

                }
                counter++;
            }
            System.out.println("2parte");
            driver.findElement(By.cssSelector("img[alt*='Cart']")).click();

            driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();

            driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
            driver.findElement(By.cssSelector("button.promoBtn")).click();
            WebDriverWait a= new WebDriverWait(driver,duration);
            a.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
            System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
            driver.quit();

//            Iterator vegetablesIterator= vegetables.listIterator();
//            System.out.println("BUCLE while");
//            while (vegetablesIterator.hasNext()){
//
//                WebElement item =(WebElement) vegetablesIterator.next();
//                System.out.println(item.getText());
//            }


//
        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
