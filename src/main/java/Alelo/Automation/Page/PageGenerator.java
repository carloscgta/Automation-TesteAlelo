package Alelo.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {

public WebDriver driver;
	
	public PageGenerator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	//JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) throws Exception {
        try {
        	
        	
           //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
