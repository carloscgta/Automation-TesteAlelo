package Alelo.Automation.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.deps.difflib.DiffException;

public class Google {

	public Google(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	
	}
	
	 @FindBy(how = How.XPATH, using = "//input[@name='q']")
	   public WebElement googleSearch_Input;
	   
	   @FindBy(how = How.XPATH, using = "//*[@id='tsf']/div[2]/div[1]/div[2]/button")
	   public WebElement googleSearch_Button;

	   @FindBy(how = How.XPATH, using = ".//h1[text()='texto aqui']")
	   public WebElement h1labelgoogle;
	 
	 

	   @FindBy(how = How.XPATH, using = "//*[@id='rso']/div")
	   public WebElement googlePageResult_Div;
	   
	   @FindBy(how = How.XPATH, using = "//*[@id='resultStats']")
	   public WebElement googleResultStatus_Div;
	   
	   
	   //*********Page Methods*********
	   //Go to LoginPage
	   
	 //*********Page Methods*********
	   
	   public void escrever(String texto) throws InterruptedException {
		   
		   googleSearch_Input.sendKeys(texto);
	   }
	   
   public void clicar() throws InterruptedException {
		  
	   googleSearch_Input.sendKeys(Keys.ENTER);
	   }
	   
   
	   public boolean validarQuantidadeResultadorBuscaDiretorFilme (String nomeDiretorFilme) throws DiffException, Exception{
	       
		   boolean result = false;
		   String content = googlePageResult_Div.getText().toString();
		 if(content.contains("quentin"))
			result=true;
		 else 
			 result= false;
		 
		 return result;
	   }

}
