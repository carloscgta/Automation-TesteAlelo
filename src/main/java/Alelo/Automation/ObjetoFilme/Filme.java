package Alelo.Automation.ObjetoFilme;

public class Filme {

	
	private Long ano_lancamento;
	private String nome_Filme;
	
	public Filme(Long anoNasc, String string2) {
		// TODO Auto-generated constructor stub
		ano_lancamento = anoNasc;
		nome_Filme = string2;
	}

	
	
	public Long getAno_lancamento() {
		return ano_lancamento;
	}
	public void setAno_lancamento(Long ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	public String getNome_Filme() {
		return nome_Filme;
	}
	public void setNome_Filme(String nome_Filme) {
		this.nome_Filme = nome_Filme;
	}
	
	public String nome_Filme(String nome) {
		String text = nome;
		return text;
	}
	
}
