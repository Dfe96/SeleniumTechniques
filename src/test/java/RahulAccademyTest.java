import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RahulAccademyTest {
    public static void main(String[] args) {

        try {
            String password = "";
            String txt = "";
            String username = "Diego";
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.linkText("Forgot your password?")).click();//a[contains(text(),'Forgot your password?')]

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            driver.findElement(By.cssSelector("input[placeholder*='Name']")).sendKeys("Estoy");
            driver.findElement(By.cssSelector("input[placeholder*='Email']")).sendKeys("probando");
            driver.findElement(By.cssSelector("input[placeholder*='Phone']")).sendKeys("esto");
            Thread.sleep(1000);//
            driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
            txt = driver.findElement(By.cssSelector("p[class*=infoMs]")).getText();

            password = txt.split(" ")[4];

            String tmppassword = password.replace("\'", "");//hay que eliminar los char ''
            System.out.println("user is: " + username + "\n");
            System.out.println("pass is: " + tmppassword);

            driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")).click();
            Thread.sleep(1000);//
            driver.findElement(By.id("inputUsername")).sendKeys(username);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(tmppassword);
            driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
            System.out.println(driver.getTitle());

            //driver.quit();

        } catch (Exception exception) {
            System.out.println("-------------------------------ERROR-----------------------------------------------------------------------------------");
            System.out.println(exception);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }
    }
}
