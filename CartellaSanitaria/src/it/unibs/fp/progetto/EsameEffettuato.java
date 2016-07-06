package it.unibs.fp.progetto;

import java.util.ArrayList;

/**
 * EsameEffettuato fornisce lo scheletro per costruire un oggetto che contiene i dati di un esame da effettuare/effettuato
 * 
 * @author Valtulini Claudio
 * 
 */

import java.util.Date;
import it.unibs.fp.mylib.MyTime;

public class EsameEffettuato {
	//costanti
	public static final String GIA_EFFETTUATO = "Impossibile modificare il dato, l'esame è già stato effettuato"; 
	public static final String ESITO_MANCANTE = "Non è ancora stato impostato un esito";
	private static final String ES_MAL_NON_COERENTE = "L'esame richiesto non è coerente con la malattia indicata";
	private static final String MALATTIA_NON_IMPOSTATA = "Il valore di malattia non e' stato impostato";
	private static final String ERRORE_TIPO = "Attenzione! Il tipo di esame passato non e' corretto!";
	
	//attributi
	private Esame esame;
	private Date data;
	private String ora;
	private String luogo;
	private Malattia malattia;
	
	//Metodi importati da main
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un double contenente il valore
	 * medio degli esiti
	 * 
	 * @param listaEPME la lista di esami dei quali trovare l'esito medio
	 * @return vMedio il valore medio degli esiti
	 * 
	 * @author Valtulini Claudio
	 */
	 //Stessa cosa riguardante esito max e min
	 //decidere se controllare se la dimensione dell'arraylist passato sia maggiore di 0
	 public static double esameEsitoMedio(ArrayList<EsameEffettuato> listaEPME){
		if(listaEPME.get(0) instanceof EPeriodicoMisurabileEffettuato){
			ArrayList<EPeriodicoMisurabileEffettuato> listaCopia = new ArrayList<>();
		
			for(EsameEffettuato elemento: listaEPME){
				listaCopia.add((EPeriodicoMisurabileEffettuato) elemento);
			}
			
			double somma = 0.0;
			int nEsami = 0;
		
			for(EPeriodicoMisurabileEffettuato elemento: listaCopia){
				somma += elemento.getEsito();
				nEsami++;
			}
		
			double vMedio = somma / nEsami;
		
			return vMedio;
		}
		else{
			throw new IllegalArgumentException(ERRORE_TIPO);
		}
	}
	
	/**
	 * Passata una lista di EsamiEffettuati ne trova quelli il cui nome dell'esame corrispondente equivale a quello della stringa passata
	 * 
	 * @param listaEE la lista di EsamiEffettuati
	 * @param nomeTipologia una stringa contenente il nome della tipologia di esami che si vuole isolare
	 * @return listaStessaTipologia un ArrayList di esami effettuati tutti della stessa tipologia
	 * 
	 * @author Valtulini Claudio
	 */
	//nome non molto significativo
	public static ArrayList<EsameEffettuato> selezionaTipologia(ArrayList<EsameEffettuato> listaEE, String nomeTipologia){
		ArrayList<EsameEffettuato> listaStessaTipologia = new ArrayList<>();
		
		for(EsameEffettuato elemento: listaEE){
			if(elemento.getEsame().getNome() == nomeTipologia){
				listaStessaTipologia.add(elemento);
			}
		}
		
		return listaStessaTipologia;
	}
	
	
	//costruttori
	/**
	 * Costruttore di default, imposta tutti i riferimenti a null
	 */
	public EsameEffettuato(){
		esame = null;
		data = null;
		ora = null;
		luogo = null;
		malattia = null;
	}
	
	/**
	 * Imposta i riferimenti di esame e malattia
	 * 
	 * Se l'esame non è presente nella lista degli esami effettuabili per la malattia specificata lancia IllegalArgumentException
	 * 
	 * @param esame la tipologia di esame
	 * @param malattia la malattia per cui l'esame è richiesto
	 */
	public EsameEffettuato(Esame esame, Malattia malattia) throws IllegalAccessException, IllegalArgumentException{
		this.esame = esame;
		this.malattia = malattia;
		if(!isCoerenteMalattia()){
			throw new IllegalArgumentException(ES_MAL_NON_COERENTE);
		}
		data = null;
		ora = null;
		luogo = null;
	}
	
	/**
	 * Imposta i riferimenti di esame, malattia, luogo, data e ora
	 * 
	 * Se l'esame non è presente nella lista degli esami effettuabili per la malattia specificata lancia IllegalArgumentException
	 * 
	 * @param esame la tipologia di esame
	 * @param malattia la malattia per cui l'esame è richiesto
	 */
	public EsameEffettuato(Esame esame, Malattia malattia, String luogo, Date data, String ora) throws IllegalAccessException, IllegalArgumentException{
		this.esame = esame;
		this.malattia = malattia;
		if(!isCoerenteMalattia()){
			throw new IllegalArgumentException(ES_MAL_NON_COERENTE);
		}
		this.data = data;
		this.ora = ora;
		this.luogo = luogo;
	}
	
	//getters
	/**
	 * Ritorna il riferimento dell'attributo esame
	 * 
	 * @return esame la tipologia di esame
	 */
	public Esame getEsame() {
		return esame;
	}
	/**
	 * Ritorna la data impostata
	 * 
	 * @return data la data in cui l'esame viene effettuato
	 */
	public Date getData() {
		return data;
	}
	/**
	 * Ritorna l'ora impostata
	 * 
	 * @return ora l'ora in cui l'esame viene effettuato
	 */
	public String getOra() {
		return ora;
	}
	/**
	 * Ritorna il luogo impostato
	 * 
	 * @return luogo il luogo in cui l'esame viene effettuato
	 */
	public String getLuogo() {
		return luogo;
	}
	/**
	 * Ritorna la malattia impostata
	 * @return malattia la malattia per la quale e' richiesto l'esame
	 */
	public Malattia getMalattia() {
		return malattia;
	}
	
	//setters
	/**
	 * Permette di impostare la tipologia di esame
	 * 
	 * se la tipologia impostata non e' presente nella lista di esami associati alla malattia, lancia IllegalArgumentException
	 * 
	 * @param esame la tipologia di esame da impostare
	 */
	public void setEsame(Esame esame) throws IllegalArgumentException{
		try{
			Esame oldEsame = this.esame;
			this.esame = esame;
			if(!isCoerenteMalattia()){
				this.esame = oldEsame;
				throw new IllegalArgumentException(ES_MAL_NON_COERENTE);
			}
		}
		catch(IllegalAccessException e){
			//ignoro perchè tutto a posto, l'assegnamento è comunque valido dato che non è stata impostata una malattia
		}
	}
	/**
	 * Permette di impostare la data in cui effettuare l'esame
	 * 
	 * @param data la data che si vuole impostare
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * Permette di impostare l'ora in cui effettuare l'esame
	 * 
	 * @param ora l'ora che si vuole impostare
	 */
	public void setOra(String ora) {
		this.ora = ora;
	}
	/**
	 * Permette di impostare il luogo in cui effettuare l'esame
	 * 
	 * @param luogo il luogo che si vuole impostare
	 */
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	/**
	 * Permette di impostare la malattia per cui si richiede l'esame
	 * 
	 * @param malattia la malattia che si vuole impostare
	 */
	public void setMalattia(Malattia malattia) {
		this.malattia = malattia;
	}
	
	//metodi
	/**
	 * Controlla se l'esame richiesto è presente nella lista di quelli associati alla malattia
	 *
	 * @return true se l'esame è presente nella lista, false se l'esame non è nella lista
	 * 
	 * @throws IllegalAccessException se la malattia non e' stata impostata
	 */
	public boolean isCoerenteMalattia() throws IllegalAccessException{
		if(malattia != null){
			if(malattia.isAssociato(esame.getNome())) return true;
			else return false;
		}
		else{
			throw new IllegalAccessException(MALATTIA_NON_IMPOSTATA);
		}
	}
	
	/**
	 * Ritorna una stringa rappresentativa contenente il nome della tipologia di esame, data, ora e luogo
	 */
	public String toString(){/*Modificato Metodo to String nell'acquisizione data(aggiunto MyTime.toStringData)*/
		return esame.getNome() + "%n   Data: " + MyTime.toStringData(data);
	}
	
	
	/**
	 * Ritorna una stringa contenente le informazioni complete relative all'esame effettuato
	 * @return <strong>stringaDescrittivaCompleta</strong> la stringa contenente le informazioni
	 */
	public String toStringCompleto(){/*Modificato Metodo to String nell'acquisizione data(aggiunto MyTime.toStringData)*/
		String stringaDescrittivaCompleta =
			"Tipologia Esame: " + esame.getNome() + "%n" +
			"Raccomandazioni: " + esame.getRaccomandazioni() + "%n";
		if(data != null){ stringaDescrittivaCompleta +=
			"Data: " + MyTime.toStringData(data) + "%n";
		}
		if(ora != null){ stringaDescrittivaCompleta +=
			"Ora: " + ora + "%n";
		}
		if(luogo != null){ stringaDescrittivaCompleta +=
			"Luogo: " + luogo + "%n";
		}
		if(malattia != null){ stringaDescrittivaCompleta +=
			"Malattia associata: " + malattia.toString() + "%n";
		}
		return stringaDescrittivaCompleta;
	}
}
