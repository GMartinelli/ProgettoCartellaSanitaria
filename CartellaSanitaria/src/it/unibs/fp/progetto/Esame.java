package it.unibs.fp.progetto;

public class Esame {
	//Attributi
	private String nome;
	private String raccomandazioni;

	//Costruttori
	public Esame(){
		nome = null;
		raccomandazioni = null;
	}
	
	public Esame(String nome){
		this.nome = nome;
		raccomandazioni = null;
	} 
	
	public Esame(String nome, String raccomandazioni){
		this.nome = nome;
		this.raccomandazioni = raccomandazioni;
	}
	
	//Getters
	public String getNome() {
		return nome;
	}
	public String getRaccomandazioni() {
		return raccomandazioni;
	}
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRaccomandazioni(String raccomandazioni) {
		this.raccomandazioni = raccomandazioni;
	}
	
	//Metodi
	

}
