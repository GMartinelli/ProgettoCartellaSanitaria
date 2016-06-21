package it.unibs.fp.progetto;

/**
 * estende la classe EsameEffettuato per poter creare oggetti EsameEffettuato che contengano i dati di esami diagnostici
 * 
 * @author Valtulini Claudio
 */

import it.unibs.fp.mylib.*;
import java.util.Date;

public class EDiagnosticoEffettuato extends EsameEffettuato{
	//attributi
	private EsameDiagnostico esame;
	/*
	 * Shadowing utilizzato in assenza di altre soluzioni progettuali/implementative
	 * Verrà  percio' esplicitato, per miglior comprensione, l'uso di this.esame ogni qualvolta
	 * nella classe sarà utilizzato questo attributo
	 */
	private String esito;
	
	//costruttori
	/**
	 * Costruttore vuoto che crea un oggetto con tutti i riferimenti null
	 */
	public EDiagnosticoEffettuato(){
		super();
		esito = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame e malattia definiti
	 * 
	 * Se malattia ed esame non sono coerenti viene lanciata IllegalArgumentException
	 * 
	 * @param esame la tipologia di esame da prenotare
	 * @param malattia la malattia per il quale viene richiesto
	 */
	public EDiagnosticoEffettuato(EsameDiagnostico esame, Malattia malattia) throws IllegalAccessException, IllegalArgumentException{
		super(esame, malattia);
		this.esame = esame;
		esito = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame, malattia, luogo, data e ora definiti
	 * 
	 * Se malattia ed esame non sono coerenti viene lanciata IllegalArgumentException
	 * 
	 * @param esame la tipologia di esame da prenotare
	 * @param malattia la malattia per il quale viene richiesto
	 * @param luogo il luogo in cui effettuare l'esame
	 * @param data la data in cui effettuare l'esame
	 * @param ora l'ora in cui effettuare l'esame
	 */
	public EDiagnosticoEffettuato(EsameDiagnostico esame, Malattia malattia, String luogo, Date data, String ora)
			throws IllegalAccessException, IllegalArgumentException{
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		esito = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame, malattia, luogo, data, ora ed esito definiti
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
	public EDiagnosticoEffettuato(EsameDiagnostico esame, Malattia malattia, String luogo, Date data, String ora, String esito)
			throws IllegalAccessException, IllegalArgumentException{
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		this.esito = esito;
	}
	
	//getter
	/**
	 * Ritorna l'esame impostato
	 * 
	 * @return esame la tipologia di esame
	 */
	public EsameDiagnostico getEsame() {
		return this.esame;
	}
	/**
	 * Ritorna l'esito dell'esame
	 * 
	 * @return esito l'esito impostato
	 */
	public String getEsito() {
		return esito;
	}

	//setter
	/**
	 * Permette di impostare la tipologia di esame
	 * 
	 * @param esame la tipologia di esame che si vuole impostare
	 */
	public void setEsame(EsameDiagnostico esame) throws IllegalAccessException, IllegalArgumentException{
		this.esame = esame;
		super.setEsame(esame);
	}
	
	/**
	 * Permette di impostare l'esito dell'esame
	 * 
	 * @param esito l'esito che si vuole impostare
	 */
	public void setEsito(String esito) {
		this.esito = esito;
	}
		
	//setter overridden
	/**
	 * Sovrascrive setLuogo di EsameEffettuato, chiamandolo e controllando che non sia gia' stato effettuato l'esame
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
	 * Controlla che l'esame non sia gia' stato effettuato
	 * 
	 * (Il criterio e' che il valore di esito sia null (impostato dal costruttore se non viene specificato un esito)
	 * 
	 * @return false se esito == null, true altrimenti
	 */
	public boolean isEffettuato(){
		if(esito == null) return false;
		else return true;
	}
}
