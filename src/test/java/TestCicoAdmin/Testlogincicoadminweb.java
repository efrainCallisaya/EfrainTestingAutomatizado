package TestCicoAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.FileStore;
import java.util.List;

public class Testlogincicoadminweb {


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
        Thread.sleep(3000);
        Assert.assertEquals("https://testing.cicoadmin.goiar.com/#/login", driver.getCurrentUrl());
        WebElement USEName = driver.findElement(By.xpath("//*[@placeholder='Usuario']"));
        USEName.sendKeys("admin@cico.com");
        WebElement USEPassword = driver.findElement(By.xpath("//*[@placeholder='Contraseña']"));
        USEPassword.sendKeys("cicO2020");
        WebElement bottonsession = driver.findElement(By.xpath("//*[@id=\"root\"]/section/main/div/div/form/div[3]/div"));
        bottonsession.click();

        Thread.sleep(3000);
        //Buscamos el elemento de  tags modificar lo que hay en las "" para buscar otros tags

        List<WebElement> searchelemts = driver.findElements(By.tagName("span"));
        Assert.assertNotNull(searchelemts);
        Assert.assertNotEquals(searchelemts.size(), 0);

        boolean searchelementActividadreciente = false;
        for (WebElement elementos : searchelemts) {
            //System.out.println("los elementos son:" + elementos.getText());
            if (elementos.getText().equals("Actividad reciente")) {
                searchelementActividadreciente = true;
            }
        }

        boolean searchelementtransacciones = false;
        for (WebElement elementos : searchelemts) {

            if (elementos.getText().equals("Transacciones")) {
                searchelementtransacciones = true;
            }
        }

        //Lista de elementos Tablero, Logs de proveedores, Configuracion, Usuarios
        List<WebElement> searchelemtsection = driver.findElements(By.tagName("a"));

        boolean searchelementtheTABLERO =false;
        for (WebElement listherf :searchelemtsection) {
            if(listherf.getText().equals("TABLERO")){
                searchelementtheTABLERO=true;
            }
        }

        boolean searchelementtheLogsdeproveedores =false;
        for (WebElement listherf :searchelemtsection) {

            if(listherf.getText().equals("LOGS DE PROVEEDOR")){
                searchelementtheLogsdeproveedores=true;
            }
        }

        boolean searchelementtheCONFIGURACIÓN =false;
        for (WebElement listherf :searchelemtsection) {
            if(listherf.getText().equals("CONFIGURACIÓN")){
                searchelementtheCONFIGURACIÓN=true;
            }
        }
        boolean searchelementtheUSUARIOS =false;
        for (WebElement listherf :searchelemtsection) {
            if(listherf.getText().equals("USUARIOS")){
                searchelementtheUSUARIOS=true;
            }
        }

        //validar la URL
        //validacion los objetos dentro de las listas.

        Assert.assertTrue(searchelementtheTABLERO);
        Assert.assertTrue(searchelementtheLogsdeproveedores);
        Assert.assertTrue(searchelementtheCONFIGURACIÓN);
        Assert.assertTrue(searchelementtheUSUARIOS);
        Assert.assertTrue(searchelementActividadreciente);
        Assert.assertTrue(searchelementtransacciones);

    }
    @AfterMethod
    public void FinishTest(){
        driver.quit();
    }
    }







