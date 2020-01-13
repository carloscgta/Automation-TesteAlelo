package Alelo.Automation.Steps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Alelo.Automation.ObjetoFilme.Filme;
import Alelo.Automation.Page.Google;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test  {
	public WebDriver driver;
	//public static PageGenerator page;
	public ChromeOptions chromeOptions;
	public WebDriverWait wait;
	public Google google;
	public Filme filme = new Filme((long) 2009, "Quentin");
	
	List<Filme> listaFilmes = new ArrayList<Filme>();
	
	
	public List<Filme> getListaFilmes() {
		return listaFilmes;
	}
	
	public void setListaFilmes(List<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}
	
	
	
		
	public Test() {
		// TODO Auto-generated constructor stub
	}

	@Given("^Estou na pagina do Google$")
	public void estou_na_pagina_do_Google() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  System.out.println("Ir para pagina do google");
	  
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
	  
      google = new Google(driver);
	  
	  	}

	@Given("^Insiro o nome \"([^\"]*)\" do diretor$")
	public void insiro_o_nome_do_diretor(String nomeDiretor) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		filme.setAno_lancamento((long) 2009);
		filme.setNome_Filme("Kill Bill");
		
		listaFilmes.add(filme);
		
		google.escrever(listaFilmes.get(0).getNome_Filme().toString());
		
		
		
	    
	}

	@When("^clico em Pesquisar$")
	public void clico_em_Pesquisar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		google.clicar();
		
		
	}

	@When("^Busca e realizada$")
	public void busca_e_realizada() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Busca Realizada");
	}

	@Then("^retorna o numero total dos resultados do paramento da busca$")
	public void retorna_o_numero_total_dos_resultados_do_paramento_da_busca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Busca Realizada");
		
		google.validarQuantidadeResultadorBuscaDiretorFilme("Quentin");
		
		for (int i = 0; i < listaFilmes.size(); i++) {
			System.out.println(listaFilmes.get(i));

		}
		
		driver.quit();
		
	}
	
	}
