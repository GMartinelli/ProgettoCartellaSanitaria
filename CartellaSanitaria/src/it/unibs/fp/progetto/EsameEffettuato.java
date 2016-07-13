package it.unibs.fp.progetto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * EsameEffettuato fornisce lo scheletro per costruire un oggetto che contiene i dati di un esame da effettuare/effettuato
 * 
 * @author Valtulini Claudio
 */

import java.util.Date;
import it.unibs.fp.mylib.MyTime;

public class EsameEffettuato implements Serializable{
	//costanti
	public static final String GIA_EFFETTUATO = "Impossibile modificare il dato, l'esame è già stato effettuato"; 
	public static final String ESITO_MANCANTE = "Non è ancora stato impostato un esito";
	private static final String E_MAL_NON_COERENTE = "L'esame richiesto non è coerente con la malattia indicata";
	private static final String M_ES_NON_COERENTE = "La malattia richiesta non è coerente con l'esame indicato";
	private static final String MALATTIA_NON_IMPOSTATA = "Il valore di malattia non e' stato impostato";
	//private static final String ERRORE_TIPO = "Attenzione! Il tipo di esame passato non e' corretto!";
	
	//attributi
	private Esame esame;
	private Date data;
	private String ora;
	private String luogo;
	private Malattia malattia;
	
	//costruttori
	/**
	 * Costruttore di default, imposta tutti i riferimenti a null
	 * 
	 * @author Valtulini Claudio
	 */
	public EsameEffettuato(){
		esame = null;
		data = null;
		ora = null;
		luogo = null;
		malattia = null;
	}
	
	/**
	 * Imposta i valori di esame e malattia
	 * 
	 * @param <strong>esame</strong> la tipologia di esame
	 * @param <strong>malattia</strong> la malattia per cui l'esame è richiesto
	 * 
	 * @throws <strong>IllegalArgumentException</strong> e l'esame non e' presente nella lista degli esami effettuabili per la malattia specificata 
	 * 
	 * @author Valtulini Claudio
	 */
	public EsameEffettuato(Esame esame, Malattia malattia) throws IllegalAccessException, IllegalArgumentException{
		this.esame = esame;
		this.malattia = malattia;
		if(!isCoerenteMalattia()){
			throw new IllegalArgumentException(E_MAL_NON_COERENTE);
		}
		data = null;
		ora = null;
		luogo = null;
	}
	
	/**
	 * Imposta i valori di esame, malattia, luogo, data e ora
	 * 
	 * @param <strong>esame</strong> la tipologia di esame
	 * @param <strong>malattia</strong> la malattia per cui l'esame è richiesto
	 * @param <strong>luogo</strong> il luogo in cui l'esame viene effettuato
	 * @param <strong>data</strong> la data in cui l'esame viene effettuato
	 * @param <strong>ora</strong> l'ora in cui l'esame viene effettuato
	 * 
	 * @throws <strong>IllegalArgumentException</strong> e l'esame non e' presente nella lista degli esami effettuabili per la malattia specificata 
	 * 
	 * @author Valtulini Claudio
	 */
	public EsameEffettuato(Esame esame, Malattia malattia, String luogo, Date data, String ora) throws IllegalAccessException, IllegalArgumentException{
		this.esame = esame;
		this.malattia = malattia;
		if(!isCoerenteMalattia()){
			throw new IllegalArgumentException(E_MAL_NON_COERENTE);
		}
		this.data = data;
		this.ora = ora;
		this.luogo = luogo;
	}
	
	//getters
	/**
	 * Ritorna il riferimento dell'attributo esame
	 * 
	 * @return <strong>esame</strong> la tipologia di esame
	 * 
	 * @author Valtulini Claudio
	 */
	public Esame getEsame() {
		return esame;
	}
	/**
	 * Ritorna la data impostata
	 * 
	 * @return <strong>data</strong> la data in cui l'esame viene effettuato
	 * 
	 * @author Valtulini Claudio
	 */
	public Date getData() {
		return data;
	}
	/**
	 * Ritorna l'ora impostata
	 * 
	 * @return <strong>ora</strong> l'ora in cui l'esame viene effettuato
	 * 
	 * @author Valtulini Claudio
	 */
	public String getOra() {
		return ora;
	}
	/**
	 * Ritorna il luogo impostato
	 * 
	 * @return <strong>luogo</strong> il luogo in cui l'esame viene effettuato
	 * 
	 * @author Valtulini Claudio
	 */
	public String getLuogo() {
		return luogo;
	}
	/**
	 * Ritorna la malattia impostata
	 * 
	 * @return <strong>malattia</strong> la malattia per la quale e' richiesto l'esame
	 * 
	 * @author Valtulini Claudio
	 */
	public Malattia getMalattia() {
		return malattia;
	}
	
	//setters
	/**
	 * Permette di impostare la tipologia di esame
	 *
	 * @param <strong>esame</strong> la tipologia di esame da impostare
	 * 
	 * @throws <strong>IllegalArgumentException</strong> se la tipologia impostata non e' presente nella lista di esami associati alla malattia
	 * 
	 * @author Valtulini Claudio
	 */
	public void setEsame(Esame esame) throws IllegalArgumentException{
		try{
			Esame oldEsame = this.esame;
			this.esame = esame;
			if(!isCoerenteMalattia()){ //se non coerente reimposto il valore precedente
				this.esame = oldEsame;
				throw new IllegalArgumentException(E_MAL_NON_COERENTE);
			}
		}
		catch(IllegalAccessException e){
			//ignoro perchè la malattia non e' impostata quindi non ci sono problemi di compatibilità
		}
	}
	/**
	 * Permette di impostare la data in cui effettuare l'esame
	 * 
	 * @param <strong>data</strong> la data che si vuole impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * Permette di impostare l'ora in cui effettuare l'esame
	 * 
	 * @param <strong>ora</strong> l'ora che si vuole impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setOra(String ora) {
		this.ora = ora;
	}
	/**
	 * Permette di impostare il luogo in cui effettuare l'esame
	 * 
	 * @param <strong>luogo</strong> il luogo che si vuole impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	/**
	 * Permette di impostare la malattia per cui si richiede l'esame
	 * 
	 * @param <strong>malattia</strong> la malattia che si vuole impostare
	 * 
	 * @throws <strong>IllegalArgumentException</strong> se la malattia che si vuole inserire e la tipologia indicata non sono coerenti
	 * 
	 * @author Valtulini Claudio
	 */
	public void setMalattia(Malattia malattia) {
		try{
			Malattia oldMalattia = this.malattia;
			this.malattia = malattia;
			if(!isCoerenteMalattia()){ //se non coerente reimposto il valore precedente
				this.malattia = oldMalattia;
				throw new IllegalArgumentException(E_MAL_NON_COERENTE);
			}
		}
		catch(IllegalAccessException e){
			/* Ignoro perche' non puo' essere lanciata dato che ho impostato la malattia prima che l'eccezione (che viene lanciata se la malattia non e' impostata)
			 * venga lanciata */
		}
	}
	
	//metodi
	/**
	 * Controlla se l'esame richiesto è presente nella lista di quelli associati alla malattia
	 *
	 * @return <strong>true</strong> se l'esame è presente nella lista, <strong>false</strong> se l'esame non è nella lista
	 * 
	 * @throws <strong>IllegalAccessException</strong> se la malattia non e' stata impostata
	 * 
	 * @author Valtulini Claudio
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
	 * Passata una lista di EsamiEffettuati ne trova quelli il cui nome dell'esame corrispondente equivale a quello della stringa passata
	 * 
	 * @param <strong>listaEE</strong> la lista di EsamiEffettuati
	 * @param <strong>nomeTipologia</strong> una stringa contenente il nome della tipologia di esami che si vuole isolare
	 * 
	 * @return <strong>listaStessaTipologia</strong> un ArrayList di esami effettuati tutti della stessa tipologia
	 * 
	 * @author Valtulini Claudio
	 */
	public static ArrayList<EsameEffettuato> selezionaTipologiaEsame(ArrayList<EsameEffettuato> listaEE, String nomeTipologia){
		ArrayList<EsameEffettuato> listaStessaTipologia = new ArrayList<>();
		
		for(EsameEffettuato elemento: listaEE){
			if(elemento.getEsame().getNome() == nomeTipologia){
				listaStessaTipologia.add(elemento);
			}
		}
		
		return listaStessaTipologia;
	}
	
	/**
	 * Ritorna una stringa rappresentativa dell'esame effettuato
	 * 
	 * @return <strong>descrizione</strong> stringa contenente il nome della tipologia di esame, la data, l'ora e il luogo
	 * 
	 * @author Valtulini Claudio
	 */
	public String toString(){/*Modificato Metodo to String nell'acquisizione data(aggiunto MyTime.toStringData)*/
		String descrizione = esame.getNome() + "\n   Data: " + MyTime.toStringData(data);
		return descrizione;
	}
	
	
	/**
	 * Ritorna una stringa contenente le informazioni complete relative all'esame effettuato
	 * 
	 * @return <strong>stringaDescrittivaCompleta</strong> la stringa contenente le informazioni (la tipologia dell'esame, le raccomandazioni
	 * (se presenti) la data, l'ora, il luogo, la malattia
	 *
	 * @author Valtulini Claudio
	 */
	public String toStringCompleto(){/*Modificato Metodo to String nell'acquisizione data(aggiunto MyTime.toStringData)*/
		String stringaDescrittivaCompleta =
			"Tipologia Esame: " + esame.getNome() + "\n" +
			"Raccomandazioni: " + esame.getRaccomandazioni() + "\n";
		if(data != null){ stringaDescrittivaCompleta +=
			"Data: " + MyTime.toStringData(data) + "\n";
		}
		if(ora != null){ stringaDescrittivaCompleta +=
			"Ora: " + ora + "\n";
		}
		if(luogo != null){ stringaDescrittivaCompleta +=
			"Luogo: " + luogo + "\n";
		}
		if(malattia != null){ stringaDescrittivaCompleta +=
			"Malattia associata: " + malattia.toString() + "\n";
		}
		return stringaDescrittivaCompleta;
	}
}
