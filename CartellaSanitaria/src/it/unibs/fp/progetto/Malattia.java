package it.unibs.fp.progetto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import it.unibs.fp.mylib.MyTime;

/**
 * Classe che rappresenta una malattia, attraverso diversi attributi ritenuti significativi per identificarla:
 * nome
 * data di inizio
 * data di termine (eventuale)
 * sintomi
 * diagnosi
 * elenco degli esami associati a quella malattia
 * terapia
 * 
 * @author Valtulini Claudio
 */

public class Malattia  implements Serializable{
	//attributi
	private String nome;
	private Date dataInizio;
	private Date dataTermine;
	private String sintomi;
	private String diagnosi;
	private ArrayList<Esame> elencoEsamiAssociati;
	private String terapia;
	
	//getters
	/**
	 * Ritorna la Stringa rappresentante l'attributo nome
	 * 
	 * @return <strong>nome</strong> il nome della malattia
	 * 
	 * @author Valtulini Claudio
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Ritorna l'attributo dataInizio
	 * 
	 * @return <strong>dataInizio</strong> la data in cui la malattia e' iniziata
	 * 
	 * @author Valtulini Claudio
	 */
	public Date getDataInizio() {
		return dataInizio;
	}
	/**
	 * Ritorna l'attributo dataTermine
	 * 
	 * @return <strong>dataTermine</strong> la data (eventuale) in cui la malattia e' finita
	 * 
	 * @author Valtulini Claudio
	 */
	public Date getDataTermine() {
		return dataTermine;
	}
	/**
	 * Ritorna la Stringa rappresentante l'attributo sintomi
	 * 
	 * @return <strong>sintomi</strong> i sintomi della malattia
	 * 
	 * @author Valtulini Claudio
	 */
	public String getSintomi() {
		return sintomi;
	}
	/**
	 * Ritorna la Stringa rappresentante l'attributo diagnosi
	 * 
	 * @return <strong>diagnosi</strong> la diagnosi fatta per la malattia
	 * 
	 * @author Valtulini Claudio
	 */
	public String getDiagnosi() {
		return diagnosi;
	}
	/**
	 * Ritorna l'ArrayList di oggetti della classe Esame contenente l'elenco degli esami associati alla malattia
	 * 
	 * @return <strong>elencoEsamiAssociati</strong> gli esami per cui la malattia può essere richiesta
	 * 
	 * @author Valtulini Claudio
	 */
	public ArrayList<Esame> getElencoEsamiAssociati() {
		return elencoEsamiAssociati;
	}
	/**
	 * Ritorna la Stringa contenente l'attributo terapia
	 * 
	 * @return <strong>terapia</strong> la terapia suggerita per guarire dalla malattia
	 * 
	 * @author Valtulini Claudio
	 */
	public String getTerapia() {
		return terapia;
	}
	
	//setters
	/**
	 * Permette di cambiare il nome della malattia
	 * 
	 * @param <strong>nome</strong> il nuovo nome da impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Permette di cambiare la data di inizio della malattia
	 * 
	 * @param <strong>dataInizio</strong> la nuova data da impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	/**
	 * Permette di cambiare la data di termine della malattia
	 * 
	 * @param <strong>dataTermine</strong> la nuova data da impostare
	 * 
	 * @author Valtulini Claudio
	 */
	public void setDataTermine(Date dataTermine) {
		this.dataTermine = dataTermine;
	}
	/**
	 * Permette di cambiare i sintomi della malattia
	 * 
	 * @param <strong>sintomi</strong> la stringa contenente i nuovi sintomi
	 * 
	 * @author Valtulini Claudio
	 */
	public void setSintomi(String sintomi) {
		this.sintomi = sintomi;
	}
	/**
	 * Permette di cambiare la diagnosi della malattia
	 * 
	 * @param <strong>diagnosi</strong> la nuova diagnosi
	 * 
	 * @author Valtulini Claudio
	 */
	public void setDiagnosi(String diagnosi) {
		this.diagnosi = diagnosi;
	}
	/**
	 * Permette di cambiare l'elenco di esami associati
	 * 
	 * @param <strong>elencoEsamiAssociati</strong> il nuovo elenco
	 * 
	 * @author Valtulini Claudio
	 */
	public void setElencoEsamiAssociati(ArrayList<Esame> elencoEsamiAssociati) {
		this.elencoEsamiAssociati = elencoEsamiAssociati;
	}
	/**
	 * Permette di cambiare la terapia consigliata
	 * 
	 * @param <strong>terapia</strong> la nuova terapia
	 * 
	 * @author Valtulini Claudio
	 */
	public void setTerapia(String terapia) {
		this.terapia = terapia;
	}
	
	//costruttori
	/**
	 * Costruttore vuoto che imposta tutti i riferimenti a null
	 * 
	 * @author Valtulini Claudio
	 */
	public Malattia(){
		this.nome = null;
		this.dataInizio = null;
		this.dataTermine = null;
		this.sintomi = null;
		this.diagnosi = null;
		this.terapia = null;
		this.elencoEsamiAssociati = null;
	}
	
	/**
	 * Permette di creare una nuova malattia impostando i valori di nome, dataInizio, sintomi, diagnosi, terapia
	 * 
	 * @param <strong>nome</strong> il nome della malattia
	 * @param <strong>dataInizio</strong> la data di inizio
	 * @param <strong>sintomi</strong> i sintomi
	 * @param <strong>diagnosi</strong> la diagnosi
	 * @param <strong>terapia</strong> la terapia
	 * 
	 * @author Valtulini Claudio
	 */
	public Malattia(String nome, Date dataInizio, String sintomi, String diagnosi, String terapia){
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.dataTermine = null;
		this.sintomi = sintomi;
		this.diagnosi = diagnosi;
		this.terapia = terapia;
	}
	
	/**
	 * Permette di creare una nuova malattia impostando i valori di nome, dataInizio, sintomi, diagnosi, terapia e l'elenco degli esami associati
	 * 
	 * @param <strong>nome</strong> il nome della malattia
	 * @param <strong>dataInizio</strong> la data di inizio
	 * @param <strong>sintomi</strong> i sintomi
	 * @param <strong>diagnosi</strong> la diagnosi
	 * @param <strong>elencoEsamiAssociati</strong> l'elenco di esami che è possibile richiedere per questa malattia
	 * @param <strong>terapia</strong> la terapia
	 * 
	 * @author Valtulini Claudio
	 */
	public Malattia(String nome, Date dataInizio, String sintomi, String diagnosi, ArrayList<Esame> elencoEsamiAssociati, String terapia){
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.dataTermine = null;
		this.sintomi = sintomi;
		this.diagnosi = diagnosi;
		this.elencoEsamiAssociati = new ArrayList<Esame>();
		this.elencoEsamiAssociati = elencoEsamiAssociati;
		this.terapia = terapia;
	}
	
	/**
	 * Permette di creare una nuova malattia impostando i valori di nome, dataInizio, dataTermine, sintomi, diagnosi, terapia e l'elenco degli esami associati
	 * 
	 * @param <strong>nome</strong> il nome della malattia
	 * @param <strong>dataInizio</strong> la data di inizio
	 * @param <strong>dataTermine</strong> la data di termine
	 * @param <strong>sintomi</strong> i sintomi
	 * @param <strong>diagnosi</strong> la diagnosi
	 * @param <strong>elencoEsamiAssociati</strong> l'elenco di esami che è possibile richiedere per questa malattia
	 * @param <strong>terapia</strong> la terapia
	 * 
	 * @author Valtulini Claudio
	 */
	public Malattia(String nome, Date dataInizio, Date dataTermine, String sintomi, String diagnosi, ArrayList<Esame> elencoEsamiAssociati, String terapia){
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.dataTermine = dataTermine;
		this.sintomi = sintomi;
		this.diagnosi = diagnosi;
		this.elencoEsamiAssociati = new ArrayList<Esame>();
		this.elencoEsamiAssociati = elencoEsamiAssociati;
		this.terapia = terapia;
	}
	
	//metodi	
	/**
	 * Metodo che, dato il nome di un esame, permette di sapere se questo è presente nella lista di esami associati ad una malattia
	 * 
	 * @param <strong>nomeEsame</strong> il nome dell'esame da cercare
	 *
	 * @return </strong>true se l'esame è presente nell'elenco di esami associati, <strong>false</strong> altrimenti
	 *
	 * @author Valtulini Claudio
	 */
	public boolean isAssociato(String nomeEsame){
		for(Esame elemento: elencoEsamiAssociati){
			if(elemento.getNome()==nomeEsame)
				return true;
		}
		return false;
	}
	
	/**
	 * Ritorna una rappresentazione della malattia data da:
	 * 
	 * @return <strong>descrizione</strong> la descrizione sintetica della malattia (Nome, dataInizio, (se presente) dataTermine)
	 * 
	 * @author Valtulini Claudio
	 */
	public String toString(){
		String descrizione = nome + "%n   Iniziata: " + MyTime.toStringData(dataInizio);
		if(dataTermine != null) descrizione += ("%n   Terminata:  " + MyTime.toStringData(dataTermine)); 
		
		return descrizione;
	}
	
	/**
	 * Ritorna una rappresentazione completa della malattia
	 * 
	 * @return <strong>stringaDescrittivaCompleta</strong> formata da toString di Malattia, (se presenti) sintomi, diagnosi, elenco degli esami associati
	 * terapia
	 *
	 * @author Valtulini Claudio
	 */
	public String toStringCompleto(){
		String stringaDescrittivaCompleta =
				this.toString() + "%n";
			if(this.getSintomi() != null){ stringaDescrittivaCompleta +=
				"  Sintomi: " + this.getSintomi();
			}
			if(this.getDiagnosi() != null){ stringaDescrittivaCompleta +=
				" Diagnosi: "+ this.getDiagnosi();
			}
			if(this.getElencoEsamiAssociati().size() > 0 && this.getElencoEsamiAssociati() != null){ stringaDescrittivaCompleta +=
				"  Elenco delle tipologie di esame associate: " + "%n";
				for(Esame elemento: this.getElencoEsamiAssociati()){ stringaDescrittivaCompleta +=
				"   " + elemento.toString();
				}
			}
			if(this.getTerapia() != null){ stringaDescrittivaCompleta +=
				"  Terapia: " + this.getTerapia();
			}
		return stringaDescrittivaCompleta;
	}
}
