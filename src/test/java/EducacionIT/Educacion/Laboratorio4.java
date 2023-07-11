package EducacionIT.Educacion;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Laboratorio4 {
String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account\r\n";
String firefoxDriverPath = "..\\Educacion\\Drivers\\geckodriver.exe";
		
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("incognito"); //abrir el navegador en incognito
		
		WebDriver driver = new FirefoxDriver(options);
		driver.navigate().to(url);  //abre el navegador en la pagina indicada 
		driver.manage().window().maximize();  //maximiza la pagina 
		//primera parte escribo el correo y le doy click
		
		driver.findElement(By.id("email_create")).sendKeys("correo"+ Math.random() + "@gmail.com"); 
		driver.findElement(By.name("SubmitCreate")).click();
		
		//Espera explicita con un tiempo máximo y una condicion de salida
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		
		//formulario - 2da parte
		
		driver.findElement(By.cssSelector("#id_gender1")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Luis");
		driver.findElement(By.id("customer_lastname")).sendKeys("Perez"); // Last Name
		driver.findElement(By.name("passwd")).sendKeys("1q3w4r5t");
		Select days = new Select(driver.findElement(By.cssSelector("#days")));
		days.selectByValue("18");
		
		Select months = new Select(driver.findElement(By.xpath("//select[@id='months']"))); // Lista de months
		months.selectByVisibleText("June ");
		
		Select years = new Select(driver.findElement(By.id("years"))); // Lista de years
		years.selectByIndex(30);

		
        driver.findElement(By.name("newsletter")).click(); // check Newsletter
		
		WebElement chkOffers = driver.findElement(By.cssSelector("#optin")); // check Offers
		chkOffers.click();

		
		//Tercera parte- formulario 
		driver.findElement(By.cssSelector("#company")).sendKeys("Empresa ABC C.A");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Micalle 123 5B");
		driver.findElement(By.id("address2")).sendKeys("Entre Calles 1 y 2"); // Address 2
		driver.findElement(By.name("city")).sendKeys("Tucuman");
		Select states = new Select(driver.findElement(By.cssSelector("#id_state"))); // State
		states.selectByVisibleText("California");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("90210"); // Zip Code
		driver.findElement(By.id("other")).sendKeys("Comentarios del Usuario que se está registrando"); // Addition Information
		driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("55448647"); // Addition Information
		
		WebElement txtAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		txtAlias.clear();
		txtAlias.sendKeys("casa");
		
		driver.findElement(By.id("submitAccount")).click();
		
		
		
		
		
		
		
		
		
		
			
		
		
		
		
		
		//formulario- 3era parte
		
		
	}
}
