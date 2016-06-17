package it.unibs.fp.progetto;

import java.text.*;
import it.unibs.fp.mylib.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe che definisce una <i>Cartella Sanitaria</i>.
 * 
 * Una cartella sanitaria contiene i dati riguardanti il paziente:
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
 * @author Martinelli Giuseppe
 * 
 * @version 1.0 1 Giugno 2016
 *
 */


public class CartellaSanitaria {
	/*Costanti*/
	private static final int LUNGHEZZA_CF=16;
	
	/*Attributi*/
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String email;
	private Date dataNascita;
	private String luogoNascita;
	private boolean genere; //FALSE-M / TRUE-F
	private String codiceFiscale;
	private String gruppoSanguigno;
	private ArrayList<EsameEffettuato> esamiEffettuati;
	private ArrayList<Malattia> elencoMalattia;
	private String codiceSanitario;
	
	/*Costruttori*/
	/**
	 * Una cartella sanitaria e' costituita da nome, cognome, indirizzo, numero di telefono, 
	 * e-mail, data e luogo di nascita, genere, codice fiscale e gruppo sanguigno riguardante il paziente.
	 * 
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
	 * 
	 * @author Martinelli Giuseppe
	 */
	public CartellaSanitaria(String nome, String cognome, String indirizzo, String telefono, String email, Date dataNascita, String luogoNascita, boolean genere, String codiceFiscale, String gruppoSanguigno){
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
		this.codiceSanitario=null;
	}
	
	/*Getters*/
	/**
	 * Ritorna il nome del paziente
	 * @return nome del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Ritorna il cognome del paziente
	 * @return cognome del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * Ritorna l'indirizzo del paziente
	 * @return <strong>indirizzo</strong> indirizzo del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	/**
	 * Ritorna il numero di telefono del paziente
	 * @return numero di telefono del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Ritorna l'indirizzo e-mail del paziente
	 * @return indirizzo e-mail del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Ritorna la data di nascita del paziente
	 * @return data di nascita del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public Date getDataNascita() {
		return dataNascita;
	}
	/**
	 * Ritorna il luogo di nascita del paziente
	 * @return luogo di nascita del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}
	/**
	 * Ritorna il genere del paziente
	 * @return genere del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public boolean getGenere() {
		return genere;
	}
	/**
	 * Ritorna il codice fiscale del paziente
	 * @return codice fiscale del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	/**
	 * Ritorna il gruppo sanguigno del paziente
	 * @return gruppo sanguigno del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getGruppoSanguigno() {
		return gruppoSanguigno;
	}
	/**
	 * Ritorna il codice sanitario del paziente
	 * @return codice sanitario del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String getCodiceSanitario() {
		return codiceSanitario;
	}
	/**
	 * Ritorna un arrayList degli esami effettuati
	 * @return arrayList degli esami effettuati dal paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public ArrayList<EsameEffettuato> getEsamiEffettuati() {
		return esamiEffettuati;
	}
	/**
	 * Ritorna un arrayList delle malattie del paziente
	 * @return arrayList delle malattie del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public ArrayList<Malattia> getElencoMalattia() {
		return elencoMalattia;
	}
	
	/*Setters*/
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public void setGenere(boolean genere) {
		this.genere = genere;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setGruppoSanguigno(String gruppoSanguigno) {
		this.gruppoSanguigno = gruppoSanguigno;
	}

	public void setEsamiEffettuati(ArrayList<EsameEffettuato> esamiEffettuati) {
		this.esamiEffettuati = esamiEffettuati;
	}

	public void setElencoMalattia(ArrayList<Malattia> elencoMalattia) {
		this.elencoMalattia = elencoMalattia;
	}

	public void setCodiceSanitario(String codiceSanitario) {
		this.codiceSanitario = codiceSanitario;
	}

	/*Metodi*/
	/**
	 * Metodo che restituisce una descrizione ridotta in forma di stringa della classe
	 * @return descrizione della cartella sanitaria in forma ridotta (nome, cognome, esami effettuati e malattie)
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String toString(){
		String descrizione="Nome: " + nome + "%nCognome: " + cognome + "%nElenco esami: %n";
		for(int i=0; i<esamiEffettuati.size();i++)
			descrizione+=esamiEffettuati.get(i).toString()+"%n";
		descrizione+="Elenco malattie: %n";
		for(int i=0; i<elencoMalattia.size();i++)
			descrizione+=elencoMalattia.get(i).toString()+"%n";
		return descrizione;
	}
	
	/**
	 * Controlla se la stringa passata e' un codice fiscale valido oppure no
	 * @param codiceF stringa che rappresenta il codice fiscale che si vuole controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un codice fiscale valido, <strong>false</strong> se la stringa inserita non &egrave; un codice fiscale valido
	 * 
	 * @author Martinelli Giuseppe
	 */
	public boolean checkValiditaCF(String codiceF){
		if(codiceF.length()==LUNGHEZZA_CF){	//Controllo la prima condizione, che il codice fiscale sia lungo 16 caratteri
			for(int i=0;i<codiceF.length();i++){
				if(i<6){			//I primi sei caratteri devono essere lettere
					if(!MyCheck.checkLettera(codiceF.charAt(i))){//Se non e' un carattere restituisco false, codice fiscale errato
						return false;
					}
				}
				if(i>=6 && i<8){	//Dopo le prime 6 lettere ci devono essere 2 cifre
					if(!MyCheck.checkNumero(codiceF.charAt(i))){
						return false;
					}
				}
				if(i==8){			//Il nono carattere deve essere una lettera
					if(!(MyCheck.checkLettera(codiceF.charAt(i)))){
						return false;
					}
				}
				if(i>=9 && i<11){	//Decimo e Undicesimo carattere devono essere numeri
					if(!MyCheck.checkNumero(codiceF.charAt(i))){
						return false;
					}
				}
				if(i==11){			//Il dodicesimo carattere deve essere una lettera
					if(!MyCheck.checkLettera(codiceF.charAt(i))){
						return false;
					}
				}
				if(i>=12 && i<15){	//Dal tredicesimo al quindicesimo devono essere numeri
					if(!MyCheck.checkNumero(codiceF.charAt(i))){
						return false;
					}
				}
				if(i==15){			//L'ultimo carattere deve essere una lettera
					if(!MyCheck.checkLettera(codiceF.charAt(i))){
						return false;
					}
				}
			}
			return true; //Se non si e' verificata nessuna delle condizioni che faceva invalidare il Codice Fiscale, possiamo dire che il codice fiscale e' valido
		}
		else{
			return false;
		}
	}
	
	/**
	 * Controlla se la stringa passata e' un numero di telefono valido
	 * @param nTelefono stringa che rappresenta il numero di telefono da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un numero di telefono valido, <strong>false</strong> se la stringa inserita non &egrave; un codice fiscale valido
	 * 
	 * @author Martinelli Giuseppe
	 */
	public boolean checkValiditaTelefono(String nTelefono){
		if(nTelefono.length()>0){
			for(int i=0; i<nTelefono.length();i++){
				if(!MyCheck.checkNumero(nTelefono.charAt(i))){
					return false;
				}
			}
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Controlla se la stringa inserita e' un indirzzo e-mail valido
	 * @param eMail indirizzo e-mail da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un indirzzo e-mail valido, <strong>false</strong> se la stringa inserita non &egrave; un codice fiscale valido
	 * 
	 * @author Martinelli Giuseppe
	 */
	public boolean checkValiditaEMail(String eMail){
		if(eMail.length()>4){
			if(eMail.matches(MyCheck.EMAIL_PATTERN)){
				return true;
			}
			else 
				return false;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Controlla se la data di nascita inserita e' valida nel formato utilizzato
	 * @param dNascita data di nascita da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta una data di nascita valida, <strong>false</strong> se la stringa inserita non &egrave; una data di nascita valido
	 * 
	 * @author Martinelli Giuseppe
	 */
	public boolean checkDataNascita(String dNascita){
		boolean controlla=true;	//Variabile per capire se bisngna controllare o meno la stringa, il controllo si fa solo se i caratteri nella stringa sono tutti numeri o /, in caso contrario la stringa non è una data accettabile
		for(int i=0; i<dNascita.length();i++){
			if(!MyCheck.checkNumero(dNascita.charAt(i)) && dNascita.charAt(i)!='/'){
				controlla=false;
			}
		}
		if(controlla){
			MyTime.DATE_FORMAT.setLenient(false);
			try {
				MyTime.DATE_FORMAT.parse(dNascita);
				return true;
			} 
			catch (ParseException e) {
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	/**
	 * Controlla se la stringa passata rappresenta un valido gruppo sanguigno
	 * @param gSanguigno gruppo sanguigno da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un gruppo sanguigno valido, <strong>false</strong> se la stringa inserita non &egrave; un gruppo sanguigno valido
	 *  
	 * @author Martinelli Giuseppe
	 */
	public boolean checkGruppoSanguigno(String gSanguigno){
		//Tolgo tutti gli eventuali spazi dalla stringa
		String gS=BelleStringhe.togliSpazi(gSanguigno);
		if(gS.length()>0 && gS.length()<4){	//Un gruppo sanguigno puo' essere composto al massimo da tre caratteri, nel caso AB- e AB+
			if(gS.charAt(0)=='+'||gS.charAt(0)=='-'){	//Controllo se ha inserito prima il valore rh o prima il gruppo
				if(gS.length()==2){
					if(gS.charAt(1)=='A' || gS.charAt(1)=='B' || gS.charAt(1)=='0'){
						return true;
					}
				}
				else if(gS.length()==3){
					if(gS.charAt(1)=='A' && gS.charAt(2)=='B'){
						return true;
					}
				}
			}
			else if(gS.charAt(0)=='0' && gS.length()==2){
				if(gS.charAt(1)=='-' || gS.charAt(1)=='+'){
					return true;
				}
			}
			else if(gS.charAt(0)=='B' && gS.length()==2){
				if(gS.charAt(1)=='-' || gS.charAt(1)=='+'){
					return true;
				}
			}
			else if (gS.charAt(0)=='A'){
				if(gS.length()==2){//Controllo se e' un gruppo sanguigno A con il suo relativo rh
					if(gS.charAt(1)=='-' || gS.charAt(1)=='+'){
						return true;
					}
				}
				else if(gS.length()==3){	//Oppure un gruppo sanguigno AB con il relativo rh
					if(gS.charAt(1)=='B'){
						if(gS.charAt(2)=='-' || gS.charAt(2)=='+'){
							return true;
						}
					}
				}
			}
		}	
		return false;
	}
	
	/**
	 * Metodo che genera il codice sanitario 
	 * @return codice sanitario generato in base ai dati dell'utente
	 * 
	 * @author Martinelli Giuseppe 
	 */
	public String generaCodiceSanitario(){
		String codiceSanitario="";
		
		//Creo stringhe senza spazi per avere un codice sanitario privo di eventuali spazi
		String n=BelleStringhe.togliSpazi(nome);
		String c=BelleStringhe.togliSpazi(cognome);
		String l=BelleStringhe.togliSpazi(luogoNascita);
		
		codiceSanitario=codiceSanitario+n.substring(0,3);
		codiceSanitario=codiceSanitario+c.substring(0,3);
		if(genere){
			codiceSanitario=codiceSanitario+"1";
		}
		else{
			codiceSanitario=codiceSanitario+"0";
		}
		codiceSanitario=codiceSanitario+l.substring(0,2);
		codiceSanitario=codiceSanitario+dataNascita.toString().substring(0,2);
		return codiceSanitario;
	}
	
	/**
	 * Metodo che cerca l'esame tra quelli effettuati dall'utente
	 * @param nomeEsame nome dell'esame da cercare
	 * @return <strong>esameEffettuato</strong> se esiste un esame il cui nome equivale alla stringa inserita, <strong>null</strong> in caso contrario
	 */
	public EsameEffettuato cercaEsame(String nomeEsame){
		for(int i=0; i<esamiEffettuati.size();i++){
			if(esamiEffettuati.get(i).getEsame().getNome()==nomeEsame)
				return esamiEffettuati.get(i);
		}
		return null;
	}
	
	/**
	 *Metodo che cerca la malattia passata come argomento tra quelle del paziente 
	 * @param nomeMalattia nome della malattia da cercare
	 * @return <strong>malattia</strong> se esiste una malattia il cui nome equivale alla stringa inserita, <strong>null</strong> in caso contrario
	 */
	public Malattia cercaMalattia(String nomeMalattia){
		for(int i=0; i<elencoMalattia.size();i++){
			if(elencoMalattia.get(i).getNome()==nomeMalattia)
				return elencoMalattia.get(i);
		}
		return null;
	}
}
