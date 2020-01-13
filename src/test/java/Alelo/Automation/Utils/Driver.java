package Alelo.Automation.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public final class Driver {

	public static WebDriver driver;
	
	public static ChromeOptions chromeOptions;
	public static WebDriverWait wait;
		
	
	private static final String HOME_PAG = "https://www.phptravels.net/admin";
	
	//Classe responsável por criar o Driver
	private static WebDriver setDriver() {
		System.setProperty("webdriver.chrome.driver","./src/main/drivers/chromedriver.exe");
		chromeOptions = new ChromeOptions();

		//chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("window-size=1920,1080");
		driver = new ChromeDriver(chromeOptions);
        
        
        //Create a wait. All Test classes use this.
        wait = new WebDriverWait(driver,15);
         
        //Maximize Window
        driver.manage().window().maximize();
		
        //Go to Portal do Contribuinte AGT
        driver.get("http://www.google.com.br/");
		return driver;
		
		//Instantiate the Page Class
	
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			driver = setDriver();
		}		
		return driver;
	}
	
	//Classe responsável por iniciar o Driver do Google Chrome e logar na página inicial
	public static void setUpWebDriver() {
		
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(HOME_PAG);
	}

	//Método para encerrar o Driver depois da execução
	public static void finaliza() {
			getDriver().quit();
			 
		}
	}