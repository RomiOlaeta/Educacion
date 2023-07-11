package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Paginas.PaginaHome;
import Paginas.PaginaLogin;
import Utilidades.DatosExcel;

public class Laboratorio8 {
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


@Test(dataProvider="Datos Login Excel")

public void login (String email, String password) {
	
	PaginaHome home = new PaginaHome(driver);
	home.hacerClicEnSignIn();
	
	//completar las credenciales para iniciar sesion 
	
	PaginaLogin login = new PaginaLogin(driver);
	login.escribirEmail("email");
	login.escribirContrasenia("password");
	login.hacerClicEnElBotonLogin(); 
		
		} 
/**
 * @return
 * @throws Exception
 */
@DataProvider(name="Datos Login Excel")
public Object[][] obtenerDatosExcel() throws Exception {
	return DatosExcel.leerExcel("..//EducacionIT//Educacion//ExcelDataProvider.xlsx");
}

@DataProvider(name="Datos Login Excel")
public Object[][] obtenerDatos() {
	Object[][] datos = new Object[3][2]; // 3 set de datos para probar el login
	
	datos[0][0] = "abc@gmail.com"; // Correo
	datos[0][1] = "12we32e"; // Contraseña

	datos[1][0] = "def@gmail.com"; // Correo
	datos[1][1] = "r3r3wrq3"; // Contraseña
	
	datos[2][0] = "ghi@gmail.com"; // Correo
	datos[2][1] = "r43r43w"; // Contraseña
	
	return datos;
} }


