package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.PaginaContactUs;
import Paginas.PaginaHome;
import Paginas.PaginaLogin;

public class Laboratorio7a {
	String url = "http://automationpractice.com\r\n";
	String firefoxDriverPath = "..\\Educacion\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		driver = new FirefoxDriver();
		driver.navigate().to(url); // driver.get(url);
		driver.manage().window().maximize();	
	}

	@Test
	
	public void login () {
		
		PaginaHome home = new PaginaHome(driver);
		home.hacerClicEnSignIn();
		
		//completar las credenciales para iniciar sesion 
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo@gmail.com");
		login.escribirContrasenia("123456romi");
		login.hacerClicEnElBotonLogin(); 
		
		
			} 
	
	@Test 
	public void irAContactanos() {
		PaginaHome home = new PaginaHome(driver);
		home.hacerClicEnContactUs();
		
		PaginaContactUs contacto = new PaginaContactUs(driver);
		contacto.seleccionarSubjet("Webmaster");
		contacto.escribirEmail("correo02@gmail.com");
		contacto.escribirOrder("3B");
		contacto.adjuntarArchivo("..\\EducacionIT\\imagenEducacionIT.jpg");
		contacto.escribirMensaje("Mensaje de contacto");
		contacto.hacerClicEnElBotonSend();
				
	}
	
	
	}
