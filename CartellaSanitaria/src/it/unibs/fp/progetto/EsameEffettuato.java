package it.unibs.fp.progetto;

/**
 * EsameEffettuato fornisce lo scheletro per costruire un oggetto che contiene i dati di un esame da effettuare/effettuato
 * 
 * @author Valtulini Claudio
 * 
 */

import java.util.Date;

public class EsameEffettuato {
	//costanti
	public static final String GIA_EFFETTUATO = "Impossibile modificare il dato, l'esame è già stato effettuato"; 
	public static final String ESITO_MANCANTE = "Non è ancora stato impostato un esito";
	public static final String ES_MAL_NON_COERENTE = "L'esame richiesto non è coerente con la malattia indicata";
	
	//attributi
	private Esame esame;
	private Date data;
	private String ora;
	private String luogo;
	private Malattia malattia;
	
	//costruttori
	public EsameEffettuato(){
		esame = null;
		data = null;
		ora = null;
		luogo = null;
		malattia = null;
	}
	
	public EsameEffettuato(Esame esame, Malattia malattia){
		this.esame = esame;
		this.malattia = malattia;
		if(!isCoerenteMalattia()){
			throw new IllegalArgumentException(ES_MAL_NON_COERENTE);
		}
		data = null;
		ora = null;
		luogo = null;
	}
	
	public EsameEffettuato(Esame esame, Malattia malattia, String luogo, Date data, String ora){
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
	public Esame getEsame() {
		return esame;
	}
	public Date getData() {
		return data;
	}
	public String getOra() {
		return ora;
	}
	public String getLuogo() {
		return luogo;
	}
	public Malattia getMalattia() {
		return malattia;
	}
	
	//setters
	public void setEsame(Esame esame) {
		this.esame = esame;
		if(!isCoerenteMalattia()) throw new IllegalArgumentException(ES_MAL_NON_COERENTE);
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public void setMalattia(Malattia malattia) {
		this.malattia = malattia;
	}
	
	//metodi
	/**
	 * Controlla se l'esame richiesto è presente nella lista di quelli associati alla malattia
	 *
	 * @return true se l'esame è presente nella lista, false se l'esame non è nella lista
	 */
	public boolean isCoerenteMalattia(){
		if(malattia.isAssociato(esame.getNome())) return true;
		else return false;
	}
	
	public String toString(){
		return esame.getNome() + "%nData: " + data + "%nOra: " + ora + "%nLuogo: " + luogo;
	}
}
