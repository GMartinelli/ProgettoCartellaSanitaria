package it.unibs.fp.progetto;
import java.util.ArrayList;

/**
 * Classe che definisce una <i>Cartella Sanitaria</i>.
 * Una cartella sanitaria ha al suo interno i dati riguardanti il paziente, che sono:
 * nome;
 * cognome;
 * indirizzo;
 * telefono;
 * email;
 * data e luogo di nascita;
 * genere;
 * codice fiscale;
 * gruppo sangugnio;
 * esami effettuati; 
 * elenco delle malattie di cui soffre;
 * codice sanitario.
 * 
 * @author Giuseppe
 * 
 * @version 1.0 1 Giugno 2016
 *
 */


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
	/**
	 * Costruttore, una cartella sanitaria è costituita da nome, cognome, indirizzo, numero di telefono, 
	 * e-mail, data e luogo di nascita, genere, codice fiscale e gruppo sanguigno riguardante il paziente.
	 * @param nome nome del paaziente
	 * @param cognome cognome del paziente
	 * @param indirizzo	indirizzo del paziente
	 * @param telefono	numero di telefono del paziente
	 * @param email indirizzo e-mail del paziente
	 * @param dataNascita data di nascita del paziente
	 * @param luogoNascita luogo di nascita del paziente
	 * @param genere sesso del paziente
	 * @param codiceFiscale codice fiscale del paziente
	 * @param gruppoSanguigno gruppo sanguigno del paziente
	 */
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
	/**
	 * Ritorna il nome del paziente
	 * @return nome del paziente
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Ritorna il cognome del paziente
	 * @return cognome del paziente
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * Ritorna l'indirizzo del paziente
	 * @return <strong>indirizzo</strong> indirizzo del paziente
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	/**
	 * Ritorna il numero di telefono del paziente
	 * @return numero di telefono del paziente
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Ritorna l'indirizzo e-mail del paziente
	 * @return indirizzo e-mail del paziente
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Ritorna la data di nascita del paziente
	 * @return data di nascita del paziente
	 */
	public String getDataNascita() {
		return dataNascita;
	}
	/**
	 * Ritorna il luogo di nascita del paziente
	 * @return luogo di nascita del paziente
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}
	/**
	 * Ritorna il genere del paziente
	 * @return genere del paziente
	 */
	public char getGenere() {
		return genere;
	}
	/**
	 * Ritorna il codice fiscale del paziente
	 * @return codice fiscale del paziente
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	/**
	 * Ritorna il gruppo sanguigno del paziente
	 * @return gruppo sanguigno del paziente
	 */
	public String getGruppoSanguigno() {
		return gruppoSanguigno;
	}
	/**
	 * Ritorna il codice sanitario del paziente
	 * @return codice sanitario del paziente
	 */
	public String getCodiceSanitario() {
		return codiceSanitario;
	}
	/**
	 * Ritorna un arrayList degli esami effettuati
	 * @return arrayList degli esami effettuati dal paziente
	 */
	public ArrayList<EsameEffettuato> getEsamiEffettuati() {
		return esamiEffettuati;
	}
	/**
	 * Ritorna un arrayList delle malattie del paziente
	 * @return arrayList delle malattie del paziente
	 */
	public ArrayList<Malattia> getElencoMalattia() {
		return elencoMalattia;
	}
	
	/*Metodi*/
	/**
	 * Metodo che restituisce una descrizione ridotta in forma di stringa della classe
	 * @return descrizione della cartella sanitaria in forma ridotta (nome, cognome, esami efffettuati e malattie)
	 */
	public String toString(){
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
	
	/**
	 * Controlla se il carattere passato è una lettera dell'alfabeto
	 * @param carattere carattere da controllare
	 * @return <strong>true</strong> se il carattere inserito è una lettera dell'alfabeto, <strong>false</strong> se il carattere inserito non è una lettera dell'alfabeto
	 */
	private boolean checkLettera(char carattere){
		if((carattere>='A' && carattere<='Z') || (carattere>='a' && carattere<='z'))
			return true;		
		else 
			return false;
	}
	
	/**
	 * Controlla se il carattere passato è un numero
	 * @param carattere carattere da controllare
	 * @return <strong>true</strong> se il carattere inserito è un numero, <strong>false</strong> se il carattere inserito non è un numero
	 */
	private boolean checkNumero(char carattere){
		if(carattere>='0' && carattere<='9')
			return true;		
		else 
			return false;
	}
	
	/**
	 * Controlla se la stringa passata può essere un codice fiscale valido oppure no
	 * @param codiceF stringa che rappresenta il codice fiscale che si vuole controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un codice fiscale valido, <strong>false</strong> se la stringa inserita non &egrave; un codice fiscale valido
	 */
	public boolean checkValiditaCF(String codiceF){
		if(codiceF.length()==16){	//Controllo la prima condizione, cioè che il codice fiscale sia lungo 16 caratteri
			for(int i=0;i<codiceF.length();i++){
				if(i<6){			//I primi sei caratteri devono essere delle lettere per essere valido il CF
					if(!checkLettera(codiceF.charAt(i))){//Se non è un carattere restituisco false, codice fiscale errato
						return false;
					}
				}
				if(i>=6 && i<8){	//Dopo le prime 6 letttere ci devono essere 2 cifre per essere valido il CF
					if(!checkNumero(codiceF.charAt(i))){
						return false;
					}
				}
				if(i==8){			//Il nono carattere deve essere una lettera per essere valido il CF
					if(!(checkLettera(codiceF.charAt(i)))){
						return false;
					}
				}
				if(i>=9 && i<11){	//Decimo e Undicesimo carattere devono essere numeri per essere valido il CF
					if(!checkNumero(codiceF.charAt(i))){
						return false;
					}
				}
				if(i==11){			//Il dodicesimo carattere deve essere una lettera per essere valido il CF
					if(!checkLettera(codiceF.charAt(i))){
						return false;
					}
				}
				if(i>=12 && i<15){	//Dal tredicesimo al quindicesimo devono essere dei numeri per essere valido il CF
					if(!checkNumero(codiceF.charAt(i))){
						return false;
					}
				}
				if(i==15){			//L'ultimo carattere deve essere una lettera per essere valido il CF
					if(!checkLettera(codiceF.charAt(i))){
						return false;
					}
				}
			}
			return true; //Se non si è verificata nessuna delle condizioni che faceva invalidare il Codice Fiscale, possiamo dire che il codice fiscale è valido
		}
		else{
			return false;
		}
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
	
	/**
	 * Metodo che cerca se esiste l'esame da cercare tra quelli effettuati dall'utente
	 * @param nomeEsame nome dell'esame da cercare
	 * @return <strong>esameEffettuato</strong> se esiste un esame che si chiama come la stringa inserita, <strong>null</strong> in caso contrario
	 */
	public EsameEffettuato cercaEsame(String nomeEsame){
		for(int i=0; i<esamiEffettuati.size();i++){
			if(esamiEffettuati.get(i).getEsame().getNome()==nomeEsame)
				return esamiEffettuati.get(i);
		}
		return null;
	}
	
	/**
	 *Metodo che cerca se esiste la malattia cercata tra quelle del paziente 
	 * @param nomeMalattia nome della malattia da cercare
	 * @return <strong>malattia</strong> se esiste una malattia che si chiama come la stringa inserita, <strong>null</strong> in caso contrario
	 */
	public Malattia cercaMalattia(String nomeMalattia){
		for(int i=0; i<elencoMalattia.size();i++){
			if(elencoMalattia.get(i).getNome()==nomeMalattia)
				return elencoMalattia.get(i);
		}
		return null;
	}
}
