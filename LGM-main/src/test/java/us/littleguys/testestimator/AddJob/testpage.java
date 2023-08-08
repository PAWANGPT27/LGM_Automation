package us.littleguys.testestimator.AddJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class testpage {
	
	{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        // Instantiate a ChromeDriver class.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);       // WebDriver driver = new FirefoxDriver();
        
  
        // Maximize the browser
        driver.manage().window().maximize();
  
        // Launch Website
        driver.get("https://testestimator.littleguys.us/");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("pawangpt2050@gmail.com");
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("12345678");
        String s= driver.findElement(By.xpath("/html//div[@id='generated-captcha']")).getText();
        driver.findElement(By.xpath("/html//input[@id='entered-captcha']")).sendKeys(s);
        driver.findElement(By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div/div//form[@class='pt-3']//button[@title='Sign In']")).click();
       
        driver.findElement(By.cssSelector(".mdi.mdi-plus")).click();
        driver.findElement(By.xpath("//li[@class='nav-item']/span[contains(text(),'Address')]")).click();
        driver.findElement(By.xpath("//*[@class='room-nav']/i[@title='Add Room']")).click();
        
        
        /*driver.findElement(By.xpath("//nav[@id='sidebar']/ul[@class='nav']//div/span[@class='menu-title']")).click();
        driver.findElement(By.xpath("//nav[@id='sidebar']/ul[@class='nav']/li[9]/ul//a[@href='/LHCConstant']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html//input[@id='standardRate']")).clear();
        driver.findElement(By.xpath("/html//input[@id='standardRate']")).sendKeys("10");
        driver.findElement(By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//button[@title='Save']")).click();
        */
    
	}
    }