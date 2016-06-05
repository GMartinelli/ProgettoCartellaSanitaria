package it.unibs.fp.progetto;
import java.util.ArrayList;

public class CartellaSanitaria {
	/*Attributi*/
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String email;
	private String dataNascita;
	private String luogoNascita;
	private boolean genere;
	private String codiceFiscale;
	private String gruppoSanguigno;
	private ArrayList<EsameEffettuato> esamiEffettuati;
	private ArrayList<Malattia> elencoMalattia;
	
	/*Costruttori*/
	public CartellaSanitaria(String nome, String cognome, String indirizzo, String telefono, String email, String dataNascita, String luogoNascita, boolean genere, String codiceFiscale, String gruppoSanguigno){
		this.nome=nome;
		this.cognome=cognome;
		this.indirizzo=indirizzo;
		this.telefono=telefono;
		this.email=email;
		this.dataNascita=dataNascita;
		this.luogoNascita=luogoNascita;
		this.genere=genere;
		this.codiceFiscale=codiceFiscale;
		this.gruppoSanguigno=gruppoSanguigno;
	}
	
	/*Getters*/
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public boolean isGenere() {
		return genere;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public String getGruppoSanguigno() {
		return gruppoSanguigno;
	}
	public ArrayList<EsameEffettuato> getEsamiEffettuati() {
		return esamiEffettuati;
	}
	public ArrayList<Malattia> getElencoMalattia() {
		return elencoMalattia;
	}
	
	/*Metodi*/
	public String toString(){
		//Da Fare
		String s="";
		return s;
	}
	public String toAnagrafica(){
		//Da Fare
		String s="";
		return s;
	}
	public boolean checkValiditaCF(){
		//Da Fare
		boolean valido=false;
		return valido;
	}
	public boolean checkValiditaTelefono(){
		//Da Fare
		boolean valido=false;
		return valido;
	}
	public boolean checkValiditaEMail(){
		//Da Fare
		boolean valido=false;
		return valido;
	}
	public boolean checkDataNascita(){
		//Da Fare
		boolean valido=false;
		return valido;		
	}
	public boolean checkGruppoSanguigno(){
		//Da Fare
		boolean valido=false;
		return valido;		
	}
	public boolean checkIndirizzo(){
		//Da Fare
		boolean valido=false;
		return valido;		
	}
	public String generaCodiceSanitario(){
		//Da Fare
		String codiceSanitario="";
		return codiceSanitario;
	}
	public Esame cercaEsame(String nomeEsame){
		//Da Fare 
		Esame e=new Esame();
		return e;
	}
	public Malattia cercaMalattia(String nomeMalattia){
		//Da Fare 
		Malattia m=new Malattia();
		return m;
	}
}
