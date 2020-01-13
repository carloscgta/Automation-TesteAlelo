package Alelo.Automation.Page;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageGenerator{

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	 Properties prop = new Properties();
	
	//If we need we can use custom wait in BasePage and all page classes
    WebDriverWait wait = new WebDriverWait(this.driver,30);
    
	
  //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click (T elementAttr) throws InterruptedException {
    	 wait.until(ExpectedConditions.elementToBeClickable((WebElement)elementAttr));
    	
    	    	((WebElement) elementAttr).click();
    	  	
    }
    
    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void waitElement (T elementAttr) throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOf((WebElement)elementAttr));
    	
    	  	
    }
    
    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText (T elementAttr, String text) throws InterruptedException {
    	 wait.until(ExpectedConditions.visibilityOf((WebElement)elementAttr));
    	 ((WebElement) elementAttr).sendKeys(text);
    	 
        }
    
    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void clearText (T elementAttr) throws InterruptedException {
    	 wait.until(ExpectedConditions.visibilityOf((WebElement)elementAttr));
    	 ((WebElement) elementAttr).clear();
    	 ((WebElement) elementAttr).sendKeys("");
    	 
        }
    
  //Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText (T elementAttr) {
    	 wait.until(ExpectedConditions.visibilityOf((WebElement)elementAttr));
        if(elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }
    
    
    //Read Text by using JAVA Generics (You can use both By or Webelement)
      public <T> String readTextContains (T elementAttr) {
      	 wait.until(ExpectedConditions.visibilityOf((WebElement)elementAttr));
          if(elementAttr.getClass().getName().contains("By")) {
              return driver.findElement((By) elementAttr).getText();
          } else {
              return ((WebElement) elementAttr).getText();
          }
      }
    
    //Check if the element is visible (You can use both By or Webelement)
    public <T> boolean elementVisible (T elementAttr) {
    	 wait.until(ExpectedConditions.elementToBeClickable((WebElement)elementAttr));
 
    	boolean b = false;
    	try {
 	
        	if(((WebElement) elementAttr).isDisplayed()) {
        		
        		b= true;
            }
            	
		} catch (Exception e) {
			return false;
		}
		return b;
   
    }
 
    public <T> void scrollToElement(T elementAttr) throws InterruptedException{
    	     	 
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ((WebElement) elementAttr));
        
        Actions builder = new Actions(driver);
      
        
        builder.moveToElement((WebElement) elementAttr).build().perform();
       // wait.until(ExpectedConditions.visibilityOf((WebElement)elementAttr));
      
        builder.contextClick((WebElement) elementAttr);
        
        wait.until(ExpectedConditions.elementToBeClickable((WebElement)elementAttr));
        

    }
    
  	
	 public Properties configProp() throws Exception {
		 try {

			 prop.load(new FileReader(".//src//main//resources//config.uat.properties"));
			
	 	} catch (IOException e) {
	 		//Log.error("Fail",e);
	 		throw new Exception(e);
	 	}
		return prop;
		 
	 }

	 /*
	  * @Author: Carlos Almeida
	  * 
	  */
	 
		    
	  //Read Text by using JAVA Generics (You can use both By or Webelement)

		public  <T> void selectElement (T elementAttr, int index) {
	    	 
	    	@SuppressWarnings("unchecked")
			List<WebElement> elements = (List<WebElement>) elementAttr ;
	    	 elements.get(index).click();
	    	
	    }
	
}
