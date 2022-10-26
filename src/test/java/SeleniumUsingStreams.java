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
import java.util.stream.Collectors;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class SeleniumUsingStreams {


    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(2));

            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            Assertion assertion = new Assertion();
            List<WebElement>list;
            List<String>result;
            int counter=1;
            do{
                list= driver.findElements(By.xpath("//tr/td[1]"));
                result=list.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
                result.stream().forEach(s-> System.out.println(s));
                //wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("a[aria-label='Next']")))).click();
                if(result.size()<1){
                    driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
                }
                counter++;
            }while (result.size()<1 &&counter<5);

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }

    private static String getPrice(WebElement element) {
        String res= element.findElement(By.xpath("following-sibling::td[1]")).getText();

        return res;
    }
}
