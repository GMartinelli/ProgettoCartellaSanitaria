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
	private char genere;
	private String codiceFiscale;
	private String gruppoSanguigno;
	private ArrayList<EsameEffettuato> esamiEffettuati;
	private ArrayList<Malattia> elencoMalattia;
	private String codiceSanitario;
	
	/*Costruttori*/
	public CartellaSanitaria(String nome, String cognome, String indirizzo, String telefono, String email, String dataNascita, String luogoNascita, char genere, String codiceFiscale, String gruppoSanguigno){
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
		this.codiceSanitario="";
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
	public char getGenere() {
		return genere;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public String getGruppoSanguigno() {
		return gruppoSanguigno;
	}
	public String getCodiceSanitario() {
		return codiceSanitario;
	}
	public ArrayList<EsameEffettuato> getEsamiEffettuati() {
		return esamiEffettuati;
	}
	public ArrayList<Malattia> getElencoMalattia() {
		return elencoMalattia;
	}
	
	/*Metodi*/
	public String toString(){
		String descrizione="";
		descrizione+="Nome: "+nome+"\n";
		descrizione+="Cognome: "+cognome+"\n";
		descrizione+="Indirizzo: "+indirizzo+"\n";
		descrizione+="Telefono: "+telefono+"\n";
		descrizione+="E-Mail: "+email+"\n";
		descrizione+="Data di nascita: "+dataNascita+"\n";
		descrizione+="Luogo di nascita: "+luogoNascita+"\n";
		descrizione+="Genere: "+genere+"\n";
		descrizione+="Codice fiscale: "+codiceFiscale+"\n";
		descrizione+="Gruppo sanguigno: "+gruppoSanguigno+"\n";
		descrizione+="Codice sanitario: "+codiceSanitario+"\n";
		descrizione+="Esami effettuati: \n";
		for(int i=0; i<esamiEffettuati.size();i++)
			descrizione+=esamiEffettuati.get(i).toString()+"\n";
		descrizione+="Elenco malattie: \n";
		for(int i=0; i<elencoMalattia.size();i++)
			descrizione+=elencoMalattia.get(i).toString()+"\n";
		
		return descrizione;
	}
	public String toStringSintetico(){
		String descrizione="";
		descrizione+="Nome: "+nome+"\n";
		descrizione+="Cognome: "+cognome+"\n";
		for(int i=0; i<esamiEffettuati.size();i++)
			descrizione+=esamiEffettuati.get(i).toString()+"\n";
		descrizione+="Elenco malattie: \n";
		for(int i=0; i<elencoMalattia.size();i++)
			descrizione+=elencoMalattia.get(i).toString()+"\n";
		return descrizione;
	}
	public boolean checkValiditaCF(String codiceF){
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
	public EsameEffettuato cercaEsame(String nomeEsame){
		for(int i=0; i<esamiEffettuati.size();i++){
			if(esamiEffettuati.get(i).getNome()==nomeEsame)
				return esamiEffettuati.get(i);
		}
		return null;
	}
	public Malattia cercaMalattia(String nomeMalattia){
		for(int i=0; i<elencoMalattia.size();i++){
			if(elencoMalattia.get(i).getNome()==nomeMalattia)
				return elencoMalattia.get(i);
		}
		return null;
	}
}
