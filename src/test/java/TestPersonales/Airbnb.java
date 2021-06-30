package TestPersonales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Airbnb {
    String URL = "https://www.airbnb.com";
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void busquedaAirbnb() throws InterruptedException {
        driver.findElement(By.id("bigsearch-query-detached-query")).sendKeys("Budapest");

        WebElement calendario = driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-split-dates-0']/div/div[2]"));
        calendario.click();

        Thread.sleep(2000);

        WebElement fechaInicio = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-07-01']"));
        fechaInicio.click();

        Thread.sleep(2000);
        WebElement fechaFin = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-07-13']"));
        fechaFin.click();

        WebElement huespedes = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']/div/div[2]"));
        huespedes.click();

        WebElement adultosElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[1]"));
        adultosElement.click();
        adultosElement.click();

        WebElement niñosElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[2]"));
        niñosElement.click();

        WebElement bebesElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[3]"));
        bebesElement.click();

        WebElement buscarBtn = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']"));
        buscarBtn.click();

        List<WebElement> tresHuespedesList = driver.findElements(By.xpath("//*[contains(text(),'3 huéspedes')]"));
        Assert.assertNotEquals(0, tresHuespedesList.size());

        boolean encontroElemento = false;
        for (WebElement element: tresHuespedesList){
            if (element.getText().contains("3 huéspedes")){
                encontroElemento = true;
            }
        }

        Assert.assertTrue(encontroElemento);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(30000);
        driver.close();
    }


}