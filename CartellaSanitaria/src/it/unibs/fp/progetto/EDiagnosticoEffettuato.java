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
	 * Verra' percio' esplicitato, per miglior comprensione, l'uso di this.esame ogni qualvolta
	 * nella classe sara' utilizzato questo attributo
	 */
	private String esito;
	
	//costruttori
	/**
	 * Costruttore vuoto che crea un oggetto con tutti i riferimenti null
	 * 
	 * @author Valtulini Claudio
	 */
	public EDiagnosticoEffettuato(){
		super();
		esito = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame e malattia definiti
	 * 
	 * Se malattia ed esame non sono coerenti viene lanciata <strong>IllegalArgumentException</strong>
	 * 
	 * @param <strong>esame</strong> la tipologia di esame da prenotare
	 * @param <strong>malattia</strong> la malattia per il quale viene richiesto
	 * 
	 * @author Valtulini Claudio
	 */
	public EDiagnosticoEffettuato(EsameDiagnostico esame, Malattia malattia) throws IllegalAccessException, IllegalArgumentException{
		super(esame, malattia);
		this.esame = esame;
		esito = null;
	}
	
	/**
	 * Costruttore che crea un oggetto con i parametri esame, malattia, luogo, data e ora definiti
	 * 
	 * Se malattia ed esame non sono coerenti viene lanciata <strong>IllegalArgumentException</strong>
	 * 
	 * @param <strong>esame</strong> la tipologia di esame da prenotare
	 * @param <strong>malattia</strong> la malattia per il quale viene richiesto
	 * @param <strong>luogo</strong> il luogo in cui effettuare l'esame
	 * @param <strong>data</strong> la data in cui effettuare l'esame
	 * @param <strong>ora</strong> l'ora in cui effettuare l'esame
	 * 
	 * @author Valtulini Claudio
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
	 * Se malattia ed esame non sono coerenti viene lanciata <strong>IllegalArgumentException</strong>
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
	 * @return <strong>esame</strong> la tipologia di esame
	 * 
	 * @author Valtulini Claudio
	 */
	public EsameDiagnostico getEsame() {
		return this.esame;
	}
	/**
	 * Ritorna l'esito dell'esame
	 * 
	 * @return <strong>esito</strong> l'esito impostato
	 * 
	 * @author Valtulini Claudio
	 */
	public String getEsito() {
		return esito;
	}

	//setter
	/**
	 * Permette di impostare la tipologia di esame gestendo il caso in cui l'esito sia gia' stato impostato o l'esame e la malattia indicati non siano compatibili
	 * 
	 * @param <strong>esame</strong> la tipologia di esame che si vuole impostare
	 * 
	 * @throws <strong>IllegalArgumentException</strong> se l'esame che si vuole impostare e la malattia indicata non sono compatibili
	 * @throws <strong>TooLateException</strong> se l'esito e' gia' stato impostato
	 * 
	 * @author Valtulini Claudio
	 */
	public void setEsame(EsameDiagnostico esame) throws IllegalArgumentException{
		if(!isEffettuato()){
			EsameDiagnostico oldEsame = this.esame;
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
	 * @param <strong>esito</strong> l'esito che si vuole impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setEsito(String esito) {
		this.esito = esito;
	}
		
	//setter overridden
	/**
	 * Sovrascrive setLuogo di EsameEffettuato, chiamandolo e controllando che non sia gia' stato effettuato l'esame
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
	 * Controlla che l'esame non sia gia' stato effettuato
	 * (se il riferimento di esito e' null (impostato dal costruttore se non viene specificato un esito)
	 * 
	 * @return <strong>false</strong> se esito == null, </strong>true</strong> altrimenti
	 * 
	 * @author Valtulini Claudio
	 */
	public boolean isEffettuato(){
		if(esito == null) return false;
		else return true;
	}
	
	/**
	 * Restituisce una stringa contenente le informazioni complete dell'esame effettuato
	 * 
	 * @return <strong>stringaDescrittivaCompleta</strong> la stringa contenente le informazioni
	 * (il toStringCompleto di EsameEffettuato, l'area interessata (se impostata), l'esito (se impostato)
	 * 
	 * @author Valtulini Claudio
	 */
	public String toStringCompleto(){
		String stringaDescrittivaCompleta = super.toStringCompleto();
		if(esame.getAreaInteressata() != null){ stringaDescrittivaCompleta +=
			"Area Interessata: " + esame.getAreaInteressata();
		}
		if(esito != null){ stringaDescrittivaCompleta +=
			"Esito: " + esito + "\n";
		}
		return stringaDescrittivaCompleta;
	}
}
