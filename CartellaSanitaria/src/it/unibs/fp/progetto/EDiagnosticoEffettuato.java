/**
 * EDiagnosticoEffettuato estende la classe EsameEffettuato per poter creare oggetti EsameEffettuato che contengano i dati di esami
 * diagnostici
 * 
 * @author Valtulini Claudio
 */
package it.unibs.fp.progetto;

import it.unibs.fp.mylib.*;
import java.util.Date;

public class EDiagnosticoEffettuato extends EsameEffettuato{
	//attributi
	private EsameDiagnostico esame;
	/*
	 * Shadowing utilizzato in assenza di altre soluzioni progettuali/implementative
	 * Verrà perciò esplicitato, per miglior comprensione l'uso di this.esame ogni qualvolta
	 * nella classe sarà utilizzato questo attributo
	 */
	private String esito;
	
	//costruttori
	public EDiagnosticoEffettuato(){
		super();
		esito = null;
	}
	
	public EDiagnosticoEffettuato(EsameDiagnostico esame, Malattia malattia){
		super(esame, malattia);
		this.esame = esame;
		esito = null;
	}
	
	public EDiagnosticoEffettuato(EsameDiagnostico esame, Malattia malattia, String luogo, Date data, String ora){
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		esito = null;
	}
	
	public EDiagnosticoEffettuato(EsameDiagnostico esame, Malattia malattia, String luogo, Date data, String ora, String esito){
		super(esame, malattia, luogo, data, ora);
		this.esame = esame;
		this.esito = esito;
	}
	
	//getter
	public EsameDiagnostico getEsame() {
		return esame;
	}
	public String getEsito() {
		return esito;
	}

	//setter
	public void setEsame(EsameDiagnostico esame) {
		this.esame = esame;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}
		
	//setter overridden
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
	
	private boolean isEffettuato(){
		if(esito == null) return false;
		else return true;
	}
}
