import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Task5 {

    public static void main(String[] args) {
        try {
            //var config
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            Assertion assertion= new Assertion();
            //step1
            driver.findElement(By.cssSelector("label[for*='honda']")).click();
            String optionSelected = driver.findElement(By.cssSelector("label[for*='honda']")).getText();
            System.out.println(optionSelected);
            //step2
            List<WebElement> list = driver.findElements(By.cssSelector("option[value*='option']"));
            System.out.println("Bucle For");
            //step3
            for (WebElement item : list
            ) {
                if(optionSelected.equals(item.getText())){

                    item.click();
                    System.out.println("ITEM: "+item.getText()+" has been founded and clicked");
                }

            }
            //step4
            driver.findElement(By.id("name")).sendKeys(optionSelected);
            //step5
            driver.findElement(By.id("alertbtn")).click();

            assertion.assertTrue(driver.switchTo().alert().getText().contains(optionSelected));

            driver.switchTo().alert().accept();


            //-----------------------------------------------------------------------------------------
            //Este código es muy interesante! abre una nueva página
            //
            //String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            //driver.findElement(By.cssSelector("a[href*='/windows']")).sendKeys(selectLinkOpeninNewTab);
            //--------------------------------------------------------------------------------------------

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
