package EducacionIT.Educacion;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Laboratorio2 {
String url = "http://automationpractice.com";
String ChromeDriverPath = "..\\Educacion\\Drivers\\chromedriver.exe";
String geckoDriverPath = "..\\Educacion\\Drivers\\geckodriver.exe";


@Test

public void buscarPalabraEnChrome() {

	System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
	
	
	WebDriver driver = new ChromeDriver(); 
	driver.get(url);
	driver.manage();
	
	WebElement txtBuscador = driver.findElement(By.id("Search_query_top"));
	txtBuscador.sendKeys("dress");
	txtBuscador.sendKeys(Keys.ENTER);
	




}

}
