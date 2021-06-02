package testcicopersonal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class test1 {


    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        String siteURL = "https://testing.cicoadmin.goiar.com/#/admin/dashboard";
        driver.get(siteURL);
        Assert.assertEquals("https://testing.cicoadmin.goiar.com/#/login", driver.getCurrentUrl());
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@placeholder='Usuario']")).sendKeys("admin@cico.com");
        driver.findElement(By.xpath("//*[@placeholder='Contraseña']")).sendKeys("cicO2020");
        System.out.println("la URL es: " + driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"root\"]/section/main/div/div/form/div[3]/div")).click();

        Thread.sleep(3000);
        //Buscamos el elemento de  tags modificar lo que hay en las "" para buscar otro tags

        List<WebElement> searchelemts = driver.findElements(By.tagName("span"));
        Assert.assertNotNull(searchelemts);
        Assert.assertNotEquals(searchelemts.size(), 0);

        boolean elementovalido = false;
        for(WebElement elementos: searchelemts){
            System.out.println("Los elementos son: "+ elementos.getText());
            if (elementos.getText().equals("Actividad reciente")){
                elementovalido = true;
            }
        }
        boolean elementovalidos = false;
        for(WebElement elementos: searchelemts){
            if (elementos.getText().equals("Transacciones")){
                elementovalidos = true;
            }
        }
        Assert.assertTrue(elementovalidos);
        //debo seguir con las validaciones
        driver.quit();
    }

}



