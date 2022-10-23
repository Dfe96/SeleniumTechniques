import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

import java.util.List;

public class DropdownsPractique {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            Assertion check = new Assertion();
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            //driver.manage().window().maximize();//configuración del Webdriver.

            WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
            Select dropdown = new Select(staticdropdown);
            dropdown.selectByIndex(3);
            System.out.println(dropdown.getFirstSelectedOption().getText());
            dropdown.selectByValue("INR");

            driver.findElement(By.id("divpaxinfo")).click();
            Thread.sleep(1000);//
            int i = 0;
            while (i < 4) {
                driver.findElement(By.id("hrefIncAdt")).click();
                i++;

            }
            driver.findElement(By.id("btnclosepaxoption")).click();

            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            Thread.sleep(1000);//
            driver.findElement(By.cssSelector("a[text*='Vishakhapatnam ']")).click();
            Thread.sleep(1000);//
            driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click(); //using direct access
            //driver.findElement(By.xpath("( //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='GOP']")).click();  using parents relationship
            driver.findElement(By.id("autosuggest")).sendKeys("ind");
            Thread.sleep(1000);

            //en este ejemplo nos metemos todos los elementos de una lista en Options
            List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
            //y lo recorremos con un for each para que nos imprima cada elemento
            for (WebElement option : options) {
//               System.out.println("aaaa");
//               System.out.println(option.getText());
                if (option.getText().equals("India")) {

                    option.click();
                    break;//usar Break no es buena practica
                }
            }
            //List <WebElement> branchOfCheckBox= driver.findElements(By.cssSelector("div[class*='fleft'] a"));
            List<WebElement> branchOfCheckBox = driver.findElements(By.cssSelector("div[class*='checkboxes']  input[type='checkbox']"));

            for (WebElement checkbox : branchOfCheckBox) {
                checkbox.click();
            }

            check.assertTrue(true);


        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }

    }
}
