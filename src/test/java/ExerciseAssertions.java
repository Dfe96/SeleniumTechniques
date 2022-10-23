import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import java.util.Iterator;
import java.util.List;

public class ExerciseAssertions {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            Assertion assertion = new Assertion();
            driver.findElement(By.id("checkBoxOption1")).click();
            assertion.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
            driver.findElement(By.id("checkBoxOption1")).click();
            assertion.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());


            //go through WebElements list with for Loop
            List<WebElement> branchOfCheckBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
            int i = 0;
            System.out.println("List Length is: " + i);
            for (WebElement checkbox : branchOfCheckBox) {
                i++;
                System.out.println("a");
            }
            System.out.println("i is =" + i);
            //WITH ITERATOR
            List<WebElement> iteratorCheckbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
            Iterator testIter = iteratorCheckbox.listIterator();
            while (testIter.hasNext()) {

                System.out.println("aaaa");
                System.out.println(testIter.next());

            }

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }


    }
}
