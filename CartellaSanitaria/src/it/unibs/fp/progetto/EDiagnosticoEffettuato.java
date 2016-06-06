/**
 * EDiagnosticoEffettuato estende la classe EsameEffettuato per poter creare oggetti EsameEffettuato che contengano i dati di esami
 * diagnostici
 * 
 * @author Valtulini Claudio
 */
package it.unibs.fp.progetto;
import it.unibs.fp.mylib.*;

public class EDiagnosticoEffettuato extends EsameEffettuato{
	//attributi
	private String esito;
	
	//getter
	public String getEsito() {
		return esito;
	}

	//setter
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

	public void setData(String data){
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
