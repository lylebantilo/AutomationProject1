import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.SQLOutput;


public class AutomationProject1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lyleb\\Downloads\\Drivers\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Duotify!";
        Assert.assertEquals(actualTitle,expectedTitle);

        Thread.sleep(1000);
        driver.findElement(By.id("hideLogin")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("lyleb");
        driver.findElement(By.name("firstName")).sendKeys("Lyle");
        driver.findElement(By.name("lastName")).sendKeys("Bantilo");
        driver.findElement(By.name("email")).sendKeys("lylebcastos@gmail.com");
        driver.findElement(By.name("email2")).sendKeys("lylebcastos@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1518462");
        driver.findElement(By.name("password2")).sendKeys("1518462");
        driver.findElement(By.name("registerButton")).click();

        Thread.sleep(1000);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        Assert.assertEquals(currentURL,expectedURL);

        System.out.println(driver.findElement(By.id("nameFirstAndLast")).getText());

        Thread.sleep(1000);
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("rafael")).click();

        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        driver.findElement(By.name("loginUsername")).sendKeys("lyleb");
        driver.findElement(By.name("loginPassword")).sendKeys("1518462" + Keys.ENTER);

        Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));

//        Thread.sleep(2000);
//        String currentURL = driver.getCurrentUrl();
//        String expectedURL = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
//        Assert.assertEquals(currentURL,expectedURL);

        Thread.sleep(1000);
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("rafael")).click();

         driver.close();

    }
}
