package it.unibs.fp.progetto;

/**
 * estende la classe EsameEffettuato per poter creare oggetti EsameEffettuato che contengano i dati di esami periodici, quindi con esito misurabile
 * 
 * @author Valtulini Claudio
 */

import it.unibs.fp.mylib.*;

import java.util.ArrayList;
import java.util.Date;


public class EPeriodicoMisurabileEffettuato extends EsameEffettuato{
	//costanti
	private final static double DEFAULT_NE = -1; //NE = non effettuato
	
	public final static String COMPRESO_ECC = "Il valore e' nel range accettabile";
	
	//avvisi
	private final static String COMPRESO = "L'esito dell'esame e' conforme ai valori accettabili";
	private final static String SUPERIORE = "Attenzione! L'esito dell'esame e' superiore al valore massimo accettabile";
	private final static String INFERIORE = "Attenzione! L'esito dell'esame e' inferiore al valore massimo accettabile";
	private final static String SOGLIA_SUPERIORE = "URGENZA! L'esito dell'esame e' MOLTO superiore al valore massimo accettabile";
	private final static String SOGLIA_INFERIORE = "URGENZA! L'esito dell'esame e' MOLTO inferiore al valore massimo accettabile";
	private static final String ERRORE_TIPO = "Attenzione! Il tipo di esame passato non e' corretto!";
	
	//attributi
	private EsamePeriodicoMisurabile esame;
	/*
	 * Shadowing utilizzato in assenza di altre soluzioni progettuali/implementative
	 * Verrà perciò esplicitato, per miglior comprensione l'uso di this.esame ogni qualvolta
	 * nella classe sarà utilizzato questo attributo
	 */
	private double esito;
	private String avvisi;
		
	//costruttori
	/**
	 * Costruttore vuoto che crea un oggetto con tutti i riferimenti null ed esito uguale al valore di default per esame non effettuato
	 * 
	 * @author Valtulini Claudio
	 */
	public EPeriodicoMisurabileEffettuato(){
		super();
		esito = DEFAULT_NE;
		avvisi = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame e malattia definiti ed esito uguale al valore di default per esame non effettuato
	 * 
	 * Se malattia ed esame non sono coerenti viene lanciata IllegalArgumentException
	 * 
	 * @param <strong>esame</strong> la tipologia di esame da prenotare
	 * @param <strong>malattia</strong> la malattia per il quale viene richiesto
	 * 
	 * @author Valtulini Claudio
	 */
	public EPeriodicoMisurabileEffettuato(EsamePeriodicoMisurabile esame, Malattia malattia)
			throws IllegalAccessException, IllegalArgumentException{
		super(esame, malattia);
		this.esame = esame;
		esito = DEFAULT_NE;
		avvisi = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame, malattia, luogo, data e ora definiti ed esito uguale al valore di default per esame non effettuato
	 * 
	 * Se malattia ed esame non sono coerenti viene lanciata IllegalArgumentException
	 * 
	 * @param <strong>esame</strong> la tipologia di esame da prenotare
	 * @param <strong>malattia</strong> la malattia per il quale viene richiesto
	 * @param <strong>luogo</strong> il luogo in cui effettuare l'esame
	 * @param <strong>data</strong> la data in cui effettuare l'esame
	 * @param <strong>ora</strong> l'ora in cui effettuare l'esame
	 * 
	 * @author Valtulini Claudio
	 */
	public EPeriodicoMisurabileEffettuato(EsamePeriodicoMisurabile esame, Malattia malattia, String luogo, Date data, String ora)
			throws IllegalAccessException, IllegalArgumentException{
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		esito = DEFAULT_NE;
		avvisi = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame, malattia, luogo, data, ora ed esito definiti
	 * inoltre, per impostare il valore avvisi chiama il metodo setAvvisi()
	 * 
	 * Se malattia ed esame non sono coerenti viene lanciata IllegalArgumentException
	 * 
	 * @param <strong>esame</strong> la tipologia di esame da prenotare
	 * @param <strong>malattia</strong> la malattia per il quale viene richiesto
	 * @param <strong>luogo</strong> il luogo in cui effettuare l'esame
	 * @param <strong>data</strong> la data in cui effettuare l'esame
	 * @param <strong>ora</strong> l'ora in cui effettuare l'esame
	 * @param <strong>esito</strong> l'esito dell'esame
	 * 
	 * @author Valtulini Claudio
	 */
	public EPeriodicoMisurabileEffettuato(EsamePeriodicoMisurabile esame, Malattia malattia, String luogo, Date data, String ora, double esito)
			throws IllegalAccessException, IllegalArgumentException{
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		this.esito = esito;
		try{
			setAvvisi();
		}
		catch(IllegalAccessException e){
			/*
			 * Non si sta ignorando l'eccezione,
			 * so che esito è già stato settato quindi non corro il rischio che venga lanciata l'eccezione
			 */
		}
	}
	
	//getters	
	/**
	 * Ritorna il valore di esito
	 * 
	 * @return <strong>esito</strong> l'esito dell'esame
	 * 
	 * @author Valtulini Claudio
	 */
	public double getEsito() {
		return esito;
	}
	/**
	 * Ritorna il valore di avvisi
	 * 
	 * se l'esito non e' stato impostato e di conseguenza viene lanciata IllegalAccessException ritorna il suo getMessage() 
	 * 
	 * @return <strong>avvisi</strong> impostati in base all'esito
	 * 
	 * @author Valtulini Claudio
	 */
	public String getAvvisi() {
		try{
			setAvvisi();
			return avvisi;
		}
		catch(IllegalAccessException e){
			return e.getMessage();
		}
	}
		
	//setters
	/**
	 * Permette di impostare la tipologia di esame e gestisce il caso in cui l'esame sia già stato effettuato o non sia compatibile
	 * con la malattia indicata
	 * 
	 * @param <strong>esame</strong> la tipologia di esame che si vuole impostare
	 * 
	 * @throws <strong>TooLateException<strong> se l'esito e' gia' stato impostato
	 * @throws <strong>IllegalArgumentException<strong> se l'esame e la malattia indicati non sono compatibili
	 * 
	 * @author Valtulini Claudio
	 */
	public void setEsame(EsamePeriodicoMisurabile esame) throws IllegalArgumentException{
		if(!isEffettuato()){
			EsamePeriodicoMisurabile oldEsame = this.esame;
			this.esame = esame;
			try{
			super.setEsame(esame);
			}
			catch(IllegalArgumentException e){
				this.esame = oldEsame;
				throw new IllegalArgumentException(e.getMessage());
			}
		}
		else{
			throw new TooLateException(GIA_EFFETTUATO);
		}
	}
	
	/**
	 * Permette di impostare l'esito dell'esame
	 * 
	 * @param <strong>esito</strong> l'esito da impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setEsito(double esito) {
		this.esito = esito;
	}
	
	/**
	 * Metodo che genera gli avvisi a seconda dell'esito dell'esame
	 * 
	 * @throws <strong>IllegalAccessException</strong> se non e' stato impostato un esito
	 * 
	 * @author Valtulini Claudio
	 */
	public void setAvvisi() throws IllegalAccessException{
		if(isEffettuato()){
			if(isInRange()) this.avvisi = COMPRESO;
			else if(isSuperioreRange() && !isOltreSogliaMax()) this.avvisi = SUPERIORE;
			else if(isInferioreRange() && !isOltreSogliaMin()) this.avvisi = INFERIORE;
			else if(isOltreSogliaMax() ) this.avvisi = SOGLIA_SUPERIORE;
			else if(isOltreSogliaMin()) this.avvisi = SOGLIA_INFERIORE;
			
		}
		else{
			throw new IllegalAccessException(ESITO_MANCANTE);
		}
	}
		
	//setters overridden
	/**
	 * Sovrascrive setLuogo di EsameEffettuato e controlla che non sia gia' stato effettuato l'esame
	 * 
	 * @param <strong>luogo</strong> il luogo in cui effettuare l'esame
	 * 
	 * @throws <strong>TooLateException<strong> se l'esito e' gia' stato impostato
	 * 
	 * @author Valtulini Claudio
	 */
	@Override
	public void setLuogo(String luogo){
		if(!isEffettuato()){
			super.setLuogo(luogo);
		}
		else{
			throw new TooLateException(GIA_EFFETTUATO);
		}
	}
	
	/**
	 * Sovrascrive setOra di EsameEffettuato, chiamandolo e controllando che non sia gia' stato effettuato l'esame
	 * 
	 * @param <strong>ora</strong> l'ora in cui si vuole effettuare l'esame
	 * 
	 * @throws <strong>TooLateException<strong> se l'esito e' gia' stato impostato
	 * 
	 * @author Valtulini Claudio
	 */
	@Override
	public void setOra(String ora){
		if(!isEffettuato()){
			super.setOra(ora);
		}
		else{
			throw new TooLateException(GIA_EFFETTUATO);
		}
	}

	/**
	 * Sovrascrive setData di EsameEffettuato, chiamandolo e controllando che non sia gia' stato effettuato l'esame
	 * 
	 * @param <strong>data</strong> la data in cui si vuole effettuare l'esame
	 * 
	 * @throws <strong>TooLateException<strong> se l'esito e' gia' stato impostato
	 * 
	 * @author Valtulini Claudio
	 */
	@Override
	public void setData(Date data){
		if(!isEffettuato()){
			super.setData(data);
		}
		else{
			throw new TooLateException(GIA_EFFETTUATO);
		}
	}
	
	//metodi
	/**
	 * Controlla se l'esito e' all'interno dei valori di range della tipologia di esame
	 * 
	 * @return <strong>true</strong> se il valore dell'esito e' all'interno dei valori definiti, false altrimenti
	 * 
	 * @author Valtulini Claudio
	 */
	public boolean isInRange(){
		if(esito > this.esame.getValoreMin() && esito < this.esame.getValoreMax()) return true;
		else return false;
	}
	
	/**
	 * Controlla se il valore e' oltre ai valori di soglia impostati nella tipologia di esame
	 * 
	 * @return <strong>true</strong> se il valore dell'esito e' oltre i valori di soglia, <strong>false</strong> altrimenti
	 * 
	 * @author Valtulini Claudio
	 */
	/* Il caso di valore sogliaMin calcolato < 0
	 *
	 * ES: Max = 50 , Min = 15 , Soglia = 20
	 * SogliaMin = -5 
	 * Non posso avere valori oltre soglia min (perche' assumo che gli esiti non possano essere negativi)
	 */
	public boolean isOltreSoglia(){
		try{
			if(esito < this.esame.getValoreSogliaMin() || esito > this.esame.getValoreSogliaMax()) return true;
			else return false;
		}
		catch(IllegalStateException exception){
			return true;
		}
	}
	
	/**
	 * Controlla se il valore e' oltre al valore di soglia minima impostata nella tipologia di esame
	 * 
	 * @return <strong>true</strong> se il valore dell'esito e' oltre al valore di soglia minima, <strong>false</strong> altrimenti
	 * 
	 * @author Manenti Gabriele
	 */
	public boolean isOltreSogliaMin(){
		try{
			if(esito < this.esame.getValoreSogliaMin()&& !isSuperioreRange()) return true;
			else return false;
		}
		catch(IllegalStateException exception){
			return true;
		}
	}
	
	/**
	 * Controlla se il valore e' inferiore al range definito nella tipologia di esame
	 * 
	 * @return <strong>true</strong> se il valore dell'esito e' inferiore a quello di range, <strong>false</strong> altrimenti
	 * 
	 * @author Manenti Gabriele
	 */
	public boolean isInferioreRange(){
		try{
			if(esito < this.esame.getValoreMin()) return true;
			else return false;
		}
		catch(IllegalStateException exception){
			return true;
		}
	}
	
	/**
	 * Controlla se il valore e' oltre al valore di soglia massima impostata nella tipologia di esame
	 * 
	 * @return <strong>true</strong> se il valore dell'esito e' oltre al valore di soglia massima, <strong>false</strong> altrimenti
	 * 
	 * @author Manenti Gabriele
	 */
	public boolean isOltreSogliaMax(){
		try{
			if(esito > this.esame.getValoreSogliaMax() && isSuperioreRange()) return true;
			else return false;
		}
		catch(IllegalStateException exception){
			return true;
		}
	}
	
	/**
	 * Controlla se il valore dell'esito e' superiore al range definito dalla tipologia di esame
	 * 
	 * @return <strong>true</strong> se il valore dell'esito e' superiore a quello di range, <strong>false</strong> altrimenti
	 * 
	 * @throws <strong>IllegalStateException</strong> se il valore e' nei range, perche' in tal caso non ha senso controllare se sia superiore o inferiore ai valori di range
	 * 
	 * @author Valtulini Claudio
	 */
	public boolean isSuperioreRange(){
		if(isInRange()) throw new IllegalStateException(COMPRESO_ECC);
		else{
			if(esito > this.esame.getValoreMax()) return true;
			else return false;
		}
	}
	
	/**
	 * Controlla se l'esame e' stato effettuato
	 * 
	 * @return <strong>true</strong> se l'esito e' stato impostato, <strong>false</strong> se l'esito e' quello impostato di default dal costruttore
	 * 
	 * @author Valtulini Claudio
	 */
	private boolean isEffettuato(){
		if(Double.compare(esito, DEFAULT_NE) == 0) return false;
		else return true;
	}
	
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un ArrayList di EsameEffettuato
	 * contenente quello/quelli (se più di uno con lo stesso esito) con esito minimo
	 * 
	 * @param <strong>listaEPME</strong> la lista di esami in cui cercare quello con esito minore
	 * @return <strong>una lista di esami</strong> contenente quelli con esito minimo
	 * 
	 * @throws <strong>IllegalArgumentException</strong> se gli esami contenuti nella lista non sono di tipo EPeriodicoMisurabileEffettuato
	 * 
	 * @author Valtulini Claudio
	 */
	public static ArrayList<EPeriodicoMisurabileEffettuato> esameEsitoMin(ArrayList<EsameEffettuato> listaEPME){
		if(listaEPME.get(0) instanceof EPeriodicoMisurabileEffettuato){
			ArrayList<EPeriodicoMisurabileEffettuato> listaMin = new ArrayList<>();
			ArrayList<EPeriodicoMisurabileEffettuato> listaCopia = new ArrayList<>();
			
			for(EsameEffettuato elemento: listaEPME){
				listaCopia.add((EPeriodicoMisurabileEffettuato) elemento);
			}
			
			listaMin.add(listaCopia.get(0));
			
			for(EPeriodicoMisurabileEffettuato elemento: listaCopia){
				if(Double.compare(elemento.getEsito(), listaMin.get(0).getEsito()) < 0){
					listaMin.clear();
					listaMin.add(elemento);
				}
				else if(Double.compare(elemento.getEsito(), listaMin.get(0).getEsito()) == 0){
					listaMin.add(elemento);
				}
			}
		
			return listaMin;
		}
		else{
			throw new IllegalArgumentException(ERRORE_TIPO);
		}
	}
	
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un ArrayList di EsameEffettuato
	 * contenente quello/quelli (se più di uno con lo stesso esito) con esito massimo
	 * 
	 * @param <strong>listaEPME</strong> la lista di esami in cui cercare quello con esito maggiore
	 * @return <strong>una lista di esami</strong> contenente quelli con esito massimo
	 *
	 * @throws <strong>IllegalArgumentException</strong> se gli esami contenuti nella lista non sono di tipo EPeriodicoMisurabileEffettuato
	 *
	 * @author Valtulini Claudio
	 */
	public static ArrayList<EPeriodicoMisurabileEffettuato> esameEsitoMax(ArrayList<EsameEffettuato> listaEPME){
		if(listaEPME.get(0) instanceof EPeriodicoMisurabileEffettuato){
			ArrayList<EPeriodicoMisurabileEffettuato> listaMax = new ArrayList<>();
			ArrayList<EPeriodicoMisurabileEffettuato> listaCopia = new ArrayList<>();
			
			for(EsameEffettuato elemento: listaEPME){
				listaCopia.add((EPeriodicoMisurabileEffettuato) elemento);
			}
			
			listaMax.add(listaCopia.get(0));
		
			for(EPeriodicoMisurabileEffettuato elemento: listaCopia){
				if(Double.compare(elemento.getEsito(), listaMax.get(0).getEsito()) > 0){
					listaMax.clear();
					listaMax.add(elemento);
				}
				else if(Double.compare(elemento.getEsito(), listaMax.get(0).getEsito()) == 0){
					listaMax.add(elemento);
				}
			}

			return listaMax;
		}
		else{
			throw new IllegalArgumentException(ERRORE_TIPO);
		}
	}
	
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un ArrayList di EsameEffettuato
	 * contenente quello/quelli (se più di uno con lo stesso esito) oltre soglia
	 * 
	 * @param <strong>listaEPME</strong> la lista di esami in cui cercare quello con esito maggiore
	 * @return <strong>una lista di esami</strong> contenente quelli con esito massimo
	 * 
	 * @throws <strong>IllegalArgumentException</strong> se gli esami contenuti nella lista non sono di tipo EPeriodicoMisurabileEffettuato
	 * 
	 * @author Valtulini Claudio
	 */
	public static ArrayList<EPeriodicoMisurabileEffettuato> esameOltreSoglia(ArrayList<EsameEffettuato> listaEPME){
		if(listaEPME.get(0) instanceof EPeriodicoMisurabileEffettuato){
			ArrayList<EPeriodicoMisurabileEffettuato> listaSoglia = new ArrayList<>();
			ArrayList<EPeriodicoMisurabileEffettuato> listaCopia = new ArrayList<>();
			
			for(EsameEffettuato elemento: listaEPME){
				listaCopia.add((EPeriodicoMisurabileEffettuato) elemento);
			}
			
			for(EPeriodicoMisurabileEffettuato elemento: listaCopia){
				if(elemento.isOltreSogliaMin()){
					listaSoglia.add(elemento);
				}
				else if(elemento.isOltreSogliaMax()){
					listaSoglia.add(elemento);
				}
			}
		
			return listaSoglia;
		}
		else{
			throw new IllegalArgumentException(ERRORE_TIPO);
		}
	}
	
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un double contenente il valore
	 * medio degli esiti
	 * 
	 * @param <strong>listaEPME</strong> la lista di esami dei quali trovare l'esito medio
	 * @return <strong>vMedio</strong> il valore medio degli esiti
	 * 
	 * @throws <strong>IllegalArgumentException</strong> se gli esami contenuti nella lista non sono di tipo EPeriodicoMisurabileEffettuato
	 * 
	 * @author Valtulini Claudio
	 */
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
	 * Metodo toString, mostra una descrizione sintetica dell'esame
	 * 
	 * @return <strong>descrizione</strong> una stringa contenente il toString di EsameEffettuato + l'esito dell'esame
	 * 
	 * @author Valtulini Claudio
	 */
	@Override
	public String toString(){
		String descrizione = super.toString() + "%n  Esito:" + this.esito;
		return descrizione;
	}
		
	/**
	 * Ritorna una stringa contenente tutte le informazioni relative all'esame effettuato
	 * 
	 * @return <strong>stringaDescrittivaCompleta</strong> la stringa contenente le informazioni (il toStringCompleto di Esame effettuato
	 * i valori di riferimento della tipologia di esame, l'esito (se presente) e gli eventuali avvisi)
	 * 
	 * @author Valtulini Claudio
	 */
	public String toStringCompleto(){
		String stringaDescrittivaCompleta = super.toStringCompleto() + 
			"Valori di riferimento: " + "%n" +
			"  -Minimo: " + esame.getValoreMin() + "%n" +
			"  -Massimo: " + esame.getValoreMax() + "%n" +
			"  -Soglia: " + esame.getSogliaErrore() + "%n";
		if(Double.compare(esito, DEFAULT_NE) != 0){ stringaDescrittivaCompleta +=
			"Esito: " + esito + "%n" + 
			"Avvisi: " + getAvvisi();
		}
		return stringaDescrittivaCompleta;
	}
}
