package TestPersonales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class scriptparaloguearhorasjira {


    WebDriver driver ;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
    }

    @Test
    public void login() throws InterruptedException {
        String siteURL = "https://knowsys.atlassian.net/browse/AA-5";
        driver.get(siteURL);
        driver.findElement(By.id("username")).sendKeys("ecallisaya@goiar.com");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(Long.parseLong("3000"));
        driver.findElement(By.id("password")).sendKeys("efrain2015");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(Long.parseLong("15000"));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/span[2]/div/div/button[1]")).click();
        List<WebElement> elements = driver.findElements(By.tagName("h1"));

        ////*[@id="tempoIssueViewPanel"]/div[1]/span[2]/div/div
       // river.findElement(By.xpath("//*[@id='tempoIssueViewPanel']/div[1]/span[2]/div/div")).click();
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/span[2]/div/div/button[1]"));

    }
}
