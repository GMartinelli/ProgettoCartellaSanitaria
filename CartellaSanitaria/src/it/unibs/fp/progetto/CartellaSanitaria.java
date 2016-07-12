package it.unibs.fp.progetto;

import java.io.Serializable;
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


public class CartellaSanitaria implements Serializable{
	/*Costanti*/
	private static final String CHAR_NON_VALIDO= "Il carattere inserito deve essere M/m o F/f";
	
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
	 * @return indirizzo del paziente
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
	/**
	 * Metodo che permette di impostare il nome del paziente
	 * @param nome nome del paziente
	 * 
	 * @author Martinelli Giuseppe
	 */
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
	 * Dato un carattere in ingresso ritorna il valore booleano assegnabile al genere per quel carattere
	 * @param dato il carattere da passare al metodo
	 * @return <strong>false</strong> se e' stato inserito M/m <strong>true</strong> se e' stato inserito F/f
	 * 
	 * @author Valtulini Claudio
	 */
	public static boolean ritornaBoolGenere(char dato){
		if(dato == 'M' || dato == 'm'){
			return false;
		}
		else if(dato == 'F' || dato == 'f'){
			return true;
		}
		else{
			throw new IllegalArgumentException(CHAR_NON_VALIDO);
		}
	}
	
	/**
	 * A seconda del genere impostato come attributo ritorna una stringa
	 * 
	 * @return <strong> "Maschio" </strong> se genere == false <strong> "Femmina" </strong> se genere == true
	 * 
	 * @author Valtulini Claudio
	 */
	public String getStringaGenere(){
		String genere = null;
		if(this.genere == false){
			genere = "Maschio";
		}
		else{
			genere = "Femmina";
		}
		return genere;
	}
	
	/**
	 * Controlla se la stringa passata e' un codice fiscale valido oppure no
	 * 
	 * @param codiceF stringa che rappresenta il codice fiscale che si vuole controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un codice fiscale valido, <strong>false</strong> se la stringa inserita non rappresenta un codice fiscale valido
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static boolean checkValiditaCF(String codiceF){
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
	 * 
	 * @param nTelefono stringa che rappresenta il numero di telefono da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un numero di telefono valido, <strong>false</strong> se la stringa inserita non rappresenta un numero di telefono valido
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static boolean checkValiditaTelefono(String nTelefono){
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
	 * 
	 * @param eMail indirizzo e-mail da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un indirzzo e-mail valido, <strong>false</strong> se la stringa inserita non rappresenta un'email valida
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static boolean checkValiditaEMail(String eMail){
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
	 * 
	 * @param dNascita data di nascita da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta una data di nascita valida, <strong>false</strong> se la stringa inserita non rappresenta una data di nascita valida
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static boolean checkDataNascita(String dNascita){
		boolean controlla=true;	//Variabile per capire se bisngna controllare o meno la stringa, il controllo si fa solo se i caratteri nella stringa sono tutti numeri o /, in caso contrario la stringa non � una data accettabile
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
	 * 
	 * @param gSanguigno gruppo sanguigno da controllare
	 * @return <strong>true</strong> se la stringa inserita rappresenta un gruppo sanguigno valido, <strong>false</strong> se la stringa inserita non rappresenta un gruppo sanguigno valido
	 *  
	 * @author Martinelli Giuseppe
	 */
	public static boolean checkGruppoSanguigno(String gSanguigno){
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
	 * 
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
		return codiceSanitario.toUpperCase();
	}
	
	/**
	 * Controlla se esiste almeno un esame effettuato il cui nome ha valore uguale alla stringa passata
	 * all'interno dell'ArrayList esamiEffettuati
	 * 
	 * @param <strong>nomeEsame</strong> il nome di tipologia di esame da cercare
	 * @return <strong>true</strong> se e' presente <strong>false</strong> se non e' presente
	 * 
	 * @author Valtulini Claudio
	 */
	public boolean isEsameEsistente(String nomeEsame){
		for(EsameEffettuato elemento: esamiEffettuati){
			if(elemento.getEsame().getNome() == nomeEsame)
				return true;
		}
		return false;
	}
	
	
	/**
	 * Metodo che cerca l'esame tra quelli effettuati dall'utente
	 * @param nomeEsame nome dell'esame da cercare
	 * @return <strong>esameEffettuato</strong> se esiste un esame il cui nome equivale alla stringa inserita, <strong>null</strong> in caso contrario
	 * 
	 * @author Martinelli Giuseppe
	 */
	public EsameEffettuato cercaEsame(String nomeEsame){
		for(int i=0; i<esamiEffettuati.size();i++){
			if(esamiEffettuati.get(i).getEsame().getNome()==nomeEsame)
				return esamiEffettuati.get(i);
		}
		return null;
	}
	
	/**
	 * Controlla se esiste almeno un esame effettuato il cui nome ha valore uguale alla stringa passata
	 * all'interno dell'ArrayList esamiEffettuati e lo ritorna se anche la data dell'esame corrisponde a quella passata
	 * 
	 * @param <strong>nomeEsame</strong> il nome della tipologia di esame da cercare
	 * @param <strong>dataEsame</strong> la data in cui deve essere stato effettuato l'esame
	 * @return l'<strong>esame</strong> se i due parametri corrispondono, <strong>null</strong> altrimenti
	 * 
	 * @author Valtulini Claudio
	 */
	public EsameEffettuato cercaEsame(String nomeEsame, Date dataEsame){
		for(EsameEffettuato elemento: esamiEffettuati){
			if(elemento.getEsame().getNome() == nomeEsame && elemento.getData() == dataEsame)
				return elemento;
		}
		return null;
	}
	
	
	/**
	 * Conta il numero di occorrenze di una certa tipologia di esame all'interno dell'ArrayList esamiEffettuati
	 * 
	 * @param <strong>nomeEsame</strong> stringa contenente il nome della tipologia di esame di cui contare le occorrenze
	 * @return un intero contenente il numero di occorrenze riscontrate
	 * 
	 * @author Valtulini Claudio
	 */
	public int contaEsame(String nomeEsame){
		int nCorrispondenze = 0;
		for(EsameEffettuato elemento: esamiEffettuati){
			if(elemento.getEsame().getNome() == nomeEsame)
				nCorrispondenze++;
		}
		return nCorrispondenze;
	}
	
	/**
	 * Controlla se esiste almeno una malattia il cui nome ha valore uguale alla stringa passata
	 * all'interno dell'ArrayList elencoMalattia
	 * 
	 * @param <strong>nomeMalattia</strong> il nome della malattia da cercare
	 * @return <strong>true</strong> se e' presente <strong>false</strong> se non e' presente
	 * 
	 * @author Valtulini Claudio
	 */
	public boolean isMalattiaEsistente(String nomeMalattia){
		for(Malattia elemento: elencoMalattia){
			if(elemento.getNome() == nomeMalattia)
				return true;
		}
		return false;
	}
	
	/**
	 * Conta il numero di occorrenze di una certa malattia all'interno dell'ArrayList esamiEffettuati
	 * 
	 * @param <strong>nomeMalattia</strong> stringa contenente il nome della malattia di cui contare le occorrenze
	 * @return un intero contenente il numero di occorrenze riscontrate
	 * 
	 * @author Valtulini Claudio
	 */
	public int contaMalattiaEsistente(String nomeMalattia){
		int nCorrispondenze = 0;
		for(Malattia elemento: elencoMalattia){
			if(elemento.getNome() == nomeMalattia)
				nCorrispondenze++;
		}
		return nCorrispondenze;
	}
	
	/**
	 * Metodo che cerca la malattia passata come argomento tra quelle del paziente 
	 * 
	 * @param nomeMalattia nome della malattia da cercare
	 * @return <strong>malattia</strong> se esiste una malattia il cui nome equivale alla stringa inserita, <strong>null</strong> in caso contrario
	 * 
	 * @author Martinelli Giuseppe
	 */
	public Malattia cercaMalattia(String nomeMalattia){
		for(int i=0; i<elencoMalattia.size();i++){
			if(elencoMalattia.get(i).getNome()==nomeMalattia)
				return elencoMalattia.get(i);
		}
		return null;
	}
	
	/**
	 * Metodo che cerca la malattia tra quelle avute/in corso dall'utente
	 * @param nomeMalattia nome della malattia da cercare
	 * @param dataInizio la data di inizio della malattia da cercare
	 * @return la <strong>malattia cercata</strong> se esiste una il cui nome e data di inizio equivalgono a quelle passate, <strong>null</strong> altrimenti
	 * 
	 * @author Valtulini Claudio
	 */
	public Malattia cercaMalattia(String nomeMalattia, Date dataInizio){
		for(Malattia elemento: elencoMalattia){
			if(elemento.getNome() == nomeMalattia && elemento.getDataInizio() == dataInizio)
				return elemento;
		}
		return null;
	}
	
	/**
	 * Metodo che restituisce una descrizione ridotta in forma di stringa della classe
	 * 
	 * @return descrizione della cartella sanitaria in forma ridotta (nome, cognome, esami effettuati e malattie)
	 * 
	 * @author Martinelli Giuseppe
	 */
	public String toString(){
		int c = 0;
		String descrizione="Nome: " + nome + "%nCognome: " + cognome + "%nElenco esami: %n";
		for(int i=0; i<esamiEffettuati.size();i++){
			c = i + 1;
			descrizione+= c + ". " + esamiEffettuati.get(i).toString()+"%n";
		}
		descrizione+="Elenco malattie: %n";
		for(int i=0; i<elencoMalattia.size();i++){
			c = i + 1;
			descrizione+= c + ". " + elencoMalattia.get(i).toString()+"%n";
		}
		return descrizione;
	}
	
	/**
	 * Metodo che restituisce una descrizione completa in forma di stringa della classe
	 * @return descrizione della cartella sanitaria in forma completa (esami effettuati e malattie sono riportati in forma ridotta)
	 * 
	 * @author Valtulini Claudio
	 */
	public String toStringCompleto(){
		String stringaDescrittivaCompleta = "Cartella sanitaria di " + this.getNome() + " " + this.getCognome() + "%n" +
				"Residente in: " + this.getIndirizzo() + "%n" +
				"Contatti: " + "%n" +
				"  Numero Telefonico: " + this.getTelefono() + "%n";
			if(this.getEmail() != null){ stringaDescrittivaCompleta += 
				"  Indirizzo E-Mail: " + this.getEmail() + "%n";
			}
			stringaDescrittivaCompleta +=
				"Nato il: " + this.getDataNascita().toString() + "%n" +
				"A: " + this.getLuogoNascita() + "%n" +
				"Genere: " + this.getStringaGenere() + "%n" +
				"Gruppo Sanguigno: " + this.getGruppoSanguigno() + "%n" +
				"Codice Fiscale: " + this.getCodiceFiscale() + "%n";
			this.generaCodiceSanitario();
			stringaDescrittivaCompleta +=
				"Codice Sanitario: " + this.getCodiceSanitario() + "%n" +
				"Esami Effettuati: " + "%n";
			int i = 1;
			for(EsameEffettuato elemento: this.getEsamiEffettuati()){ stringaDescrittivaCompleta +=
				"  " + i + ". " + elemento.toString();
				i++;
			}
			stringaDescrittivaCompleta +=
				"Malattie: " + "%n";
			i = 1;
			for(Malattia elemento: this.getElencoMalattia()){ stringaDescrittivaCompleta +=
				"  " + i + ". " + elemento.toString();
				i++;
			}
			
			return stringaDescrittivaCompleta;
	}
}
