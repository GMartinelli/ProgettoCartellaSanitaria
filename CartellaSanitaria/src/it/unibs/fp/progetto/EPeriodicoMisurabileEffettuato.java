package it.unibs.fp.progetto;

/**
 * estende la classe EsameEffettuato per poter creare oggetti EsameEffettuato che contengano i dati di esami periodici, quindi con esito misurabile
 * 
 * @author Valtulini Claudio
 */

import it.unibs.fp.mylib.*;
import java.util.Date;


public class EPeriodicoMisurabileEffettuato extends EsameEffettuato{
	//costanti
	private final static double DEFAULT_NE = -1; //NE = non effettuato
	
	public final static String COMPRESO_ECC = "Il valore è nel range accettabile";
	
	//avvisi
	private final static String COMPRESO = "L'esito dell'esame è conforme ai valori accettabili";
	private final static String SUPERIORE = "Attenzione! L'esito dell'esame è superiore al valore massimo accettabile";
	private final static String INFERIORE = "Attenzione! L'esito dell'esame è inferiore al valore massimo accettabile";
	private final static String SOGLIA_SUPERIORE = "URGENZA! L'esito dell'esame è MOLTO superiore al valore massimo accettabile";
	private final static String SOGLIA_INFERIORE = "URGENZA! L'esito dell'esame è MOLTO inferiore al valore massimo accettabile";
	
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
	 * @param esame la tipologia di esame da prenotare
	 * @param malattia la malattia per il quale viene richiesto
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
	 * @param esame la tipologia di esame da prenotare
	 * @param malattia la malattia per il quale viene richiesto
	 * @param luogo il luogo in cui effettuare l'esame
	 * @param data la data in cui effettuare l'esame
	 * @param ora l'ora in cui effettuare l'esame
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
	 * @param esame la tipologia di esame da prenotare
	 * @param malattia la malattia per il quale viene richiesto
	 * @param luogo il luogo in cui effettuare l'esame
	 * @param data la data in cui effettuare l'esame
	 * @param ora l'ora in cui effettuare l'esame
	 * @param esito l'esito dell'esame
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
	 * @return esito l'esito dell'esame
	 */
	public double getEsito() {
		return esito;
	}
	/**
	 * Ritorna il valore di avvisi
	 * 
	 * se l'esito non è stato impostato e di conseguenza viene lanciata IllegalAccessException ritorna il suo getMessage() 
	 * 
	 * @return avvisi impostati in base all'esito
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
	 * Permette di impostare la tipologia di esame
	 * 
	 * @param esame la tipologia di esame che si vuole impostare
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
	 * @param esito l'esito da impostare
	 */
	public void setEsito(double esito) {
		this.esito = esito;
	}
	
	/**
	 * Metodo che genera gli avvisi a seconda dell'esito dell'esame
	 * 
	 * @throws IllegalAccessException se non e' stato impostato un esito
	 */
	//ANNOTAZIONE metodo con un po' di controlli, controllare se corretto
	public void setAvvisi() throws IllegalAccessException{
		if(isEffettuato()){
			if(isInRange()) this.avvisi = COMPRESO;
			else{
				if(isOltreSoglia() && isSuperioreRange()) this.avvisi = SOGLIA_SUPERIORE;
				else if(isOltreSoglia() && !isSuperioreRange()) this.avvisi = SOGLIA_INFERIORE;
				else{
					if(isSuperioreRange()) this.avvisi = SUPERIORE;
					else this.avvisi = INFERIORE;
				}
			}
		}
		else{
			throw new IllegalAccessException(ESITO_MANCANTE);
		}
	}
		
	//setters overridden
	/**
	 * Sovrascrive setLuogo di EsameEffettuato e controlla che non sia gia' stato effettuato l'esame
	 * 
	 * @param luogo il luogo in cui effettuare l'esame
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
	 * @param ora l'ora in cui si vuole effettuare l'esame
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
	 * @param data la data in cui si vuole effettuare l'esame
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
	 * @return true se il valore dell'esito e' all'interno dei valori definiti, false altrimenti
	 */
	public boolean isInRange(){
		if(esito > this.esame.getValoreMin() && esito < this.esame.getValoreMax()) return true;
		else return false;
	}
	
	/**
	 * Controlla se il valore e' oltre ai valori di soglia impostati nella tipologia di esame
	 * 
	 * @return true se il valore dell'esito e' oltre i valori di soglia, false altrimenti
	 */
	//ANNOTAZIONE come gestire il caso di valore calcolato <0 ?
	/*
	 * ES: Max = 50 , Min = 15 , Soglia = 20
	 * SogliaMin = -5 , quindi "non posso" avere valori oltre soglia min
	 * per ora se si scende calcolo che sono oltre soglia 
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
	 * Controlla se il valore dell'esito e' superiore al range definito dalla tipologia di esame o inferiore
	 * 
	 * @return true se il valore dell'esito e' superiore a quello di range, false se inferiore
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
	 * @return true se l'esito e' stato impostato, false se l'esito e' quello impostato di default dal costruttore
	 */
	private boolean isEffettuato(){
		if(Double.compare(esito, DEFAULT_NE) == 0) return false;
		else return true;
	}
		
}
