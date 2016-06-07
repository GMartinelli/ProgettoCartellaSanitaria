/**
 * EPeriodicoMisurabileEffettuato estende la classe EsameEffettuato per poter creare oggetti EsameEffettuato che contengano i dati di esami
 * periodici, quindi con esito misurabile
 * 
 * @author Valtulini Claudio
 */
package it.unibs.fp.progetto;

import it.unibs.fp.mylib.*;
import java.util.Date;


public class EPeriodicoMisurabileEffettuato extends EsameEffettuato{
	//costanti
	public final static String COMPRESO_ECC = "Il valore è nel range accettabile";
	
	public final static String COMPRESO = "L'esito dell'esame è conforme ai valori accettabili";
	public final static String SUPERIORE = "Attenzione! L'esito dell'esame è superiore al valore massimo accettabile";
	public final static String INFERIORE = "Attenzione! L'esito dell'esame è inferiore al valore massimo accettabile";
	public final static String SOGLIA_SUPERIORE = "URGENZA! L'esito dell'esame è MOLTO superiore al valore massimo accettabile";
	public final static String SOGLIA_INFERIORE = "URGENZA! L'esito dell'esame è MOLTO inferiore al valore massimo accettabile";
	
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
	public EPeriodicoMisurabileEffettuato(){
		super();
		esito = -1;
		avvisi = null;
	}
	
	public EPeriodicoMisurabileEffettuato(EsamePeriodicoMisurabile esame, Malattia malattia){
		super(esame, malattia);
		this.esame = esame;
		esito = -1;
		avvisi = null;
	}
	
	public EPeriodicoMisurabileEffettuato(EsamePeriodicoMisurabile esame, Malattia malattia, String luogo, Date data, String ora){
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		esito = -1;
		avvisi = null;
	}
	
	public EPeriodicoMisurabileEffettuato(EsamePeriodicoMisurabile esame, Malattia malattia, String luogo, Date data, String ora, double esito){
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		this.esito = esito;
		try{
			setAvvisi();
		}
		catch(IllegalAccessException e){
			/*
			 * Non si sta ignorando l'eccezione,
			 * 	semplicemente so che esito è già stato settato quindi non corro il rischio che venga lanciata l'eccezione
			 */
		}
	}
	
	//getters	
	public double getEsito() {
		return esito;
	}
	public String getAvvisi() {
		return avvisi;
	}
		
	//setters
	public void setEsito(double esito) {
		this.esito = esito;
	}
	
	//ANNOTAZIONE metodo con un po' di controlli, controllare se corretto e riferire, lasciare all'autore la responsabilità di togliere l'annotazione
	public void setAvvisi() throws IllegalAccessException{
		if(esito != -1){
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
	public void setLuogo(String luogo){
		if(!isEffettuato()){
			super.setLuogo(luogo);
		}
		else{
			throw new TooLateException(GIA_EFFETTUATO);
		}
	}
		
	public void setOra(String ora){
		if(!isEffettuato()){
			super.setOra(ora);
		}
		else{
			throw new TooLateException(GIA_EFFETTUATO);
		}
	}

	public void setData(Date data){
		if(!isEffettuato()){
			super.setData(data);
		}
		else{
			throw new TooLateException(GIA_EFFETTUATO);
		}
	}
	
	//metodi
	public boolean isInRange(){
		if(esito > this.esame.getValoreMin() && esito < this.esame.getValoreMax()) return true;
		else return false;
	}
	
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
	
	public boolean isSuperioreRange(){
		if(isInRange()) throw new IllegalStateException(COMPRESO_ECC);
		else{
			if(esito > this.esame.getValoreMax()) return true;
			else return false;
		}
	}
	
	private boolean isEffettuato(){
		if(Double.compare(esito, -1) == 0) return false;
		else return true;
	}
		
}
