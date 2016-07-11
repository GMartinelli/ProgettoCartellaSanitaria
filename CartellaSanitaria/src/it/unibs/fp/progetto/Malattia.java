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
 *
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
	 * @return nome il nome della malattia
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Ritorna l'attributo dataInizio
	 * @return dataInizio la data in cui la malattia e' iniziata
	 */
	public Date getDataInizio() {
		return dataInizio;
	}
	/**
	 * Ritorna l'attributo dataTermine
	 * @return dataTermine la data (eventuale) in cui la malattia e' finita
	 */
	public Date getDataTermine() {
		return dataTermine;
	}
	/**
	 * Ritorna la Stringa rappresentante l'attributo sintomi
	 * @return sintomi i sintomi della malattia
	 */
	public String getSintomi() {
		return sintomi;
	}
	/**
	 * Ritorna la Stringa rappresentante l'attributo diagnosi
	 * @return diagnosi la diagnosi fatta per la malattia
	 */
	public String getDiagnosi() {
		return diagnosi;
	}
	/**
	 * Ritorna l'ArrayList di oggetti della classe Esame contenente l'elenco degli esami associati alla malattia
	 * @return elencoEsamiAssociati gli esami per cui la malattia può essere richiesta
	 */
	public ArrayList<Esame> getElencoEsamiAssociati() {
		return elencoEsamiAssociati;
	}
	/**
	 * Ritorna la Stringa contenente l'attributo terapia
	 * @return terapia la terapia suggerita per guarire dalla malattia
	 */
	public String getTerapia() {
		return terapia;
	}
	
	//setters
	/**
	 * Permette di cambiare il nome della malattia
	 * @param nome il nuovo nome da impostare
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Permette di cambiare la data di inizio della malattia
	 * @param dataInizio la nuova data da impostare
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	/**
	 * Permette di cambiare la data di termine della malattia
	 * @param dataTermine la nuova data da impostare
	 */
	public void setDataTermine(Date dataTermine) {
		this.dataTermine = dataTermine;
	}
	/**
	 * Permette di cambiare i sintomi della malattia
	 * @param sintomi la stringa contenente i nuovi sintomi
	 */
	public void setSintomi(String sintomi) {
		this.sintomi = sintomi;
	}
	/**
	 * Permette di cambiare la diagnosi della malattia
	 * @param diagnosi la nuova diagnosi
	 */
	public void setDiagnosi(String diagnosi) {
		this.diagnosi = diagnosi;
	}
	/**
	 * Permette di cambiare l'elenco di esami associati
	 * @param elencoEsamiAssociati il nuovo elenco
	 */
	public void setElencoEsamiAssociati(ArrayList<Esame> elencoEsamiAssociati) {
		this.elencoEsamiAssociati = elencoEsamiAssociati;
	}
	/**
	 * Permette di cambiare la terapia consigliata
	 * @param terapia la nuova terapia
	 */
	public void setTerapia(String terapia) {
		this.terapia = terapia;
	}
	
	//costruttori
	/**
	 * Permette di creare una nuova malattia
	 * 
	 * @param nome il nome della malattia
	 * @param dataInizio la data di inizio
	 * @param sintomi i sintomi
	 * @param diagnosi la diagnosi
	 * @param terapia la terapia
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
	 * Permette di creare una nuova malattia con elenco degli esami associati
	 * 
	 * @param nome il nome della malattia
	 * @param dataInizio la data di inizio
	 * @param sintomi i sintomi 
	 * @param diagnosi la diagnosi
	 * @param elencoEsamiAssociati l'elenco di esami che è possibile richiedere per questa malattia
	 * @param terapia la terapia
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
	 * Permette di creare una nuova malattia con elenco degli esami associati e data di termine
	 * @param nome il nome della malattia
	 * @param dataInizio la data di inizio
	 * @param dataTermine la data di termine
	 * @param sintomi i sintomi 
	 * @param diagnosi la diagnosi
	 * @param elencoEsamiAssociati l'elenco di esami che è possibile richiedere per questa malattia
	 * @param terapia la terapia
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
	 * @param nomeEsame il nome dell'esame da cercare
	 * @return true se l'esame è presente nell'elenco di esami associati, false altrimenti
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
	 * Nome, dataInizio, (se presente) dataTermine
	 * 
	 * @return descrizione la descrizione sintetica della malattia
	 */
	public String toString(){ /*Modificato Metodo to String nell'acquisizione data(aggiunto MyTime.toStringData)*/
		String descrizione = nome + "%n   Iniziata: " + MyTime.toStringData(dataInizio);
		if(dataTermine != null) descrizione += ("%n   Terminata:  " + MyTime.toStringData(dataTermine)); 
		
		return descrizione;
	}
	
	public String toStringCompleto(){
		String stringaDescrittivaCompleta =
				this.toString() + "%n";
			if(this.getSintomi() != null){ stringaDescrittivaCompleta +=
				"  Sintomi: " + this.getSintomi();
			}
			if(this.getDiagnosi() != null){ stringaDescrittivaCompleta +=
				" Diagnosi: "+ this.getDiagnosi();
			}
			if(this.getElencoEsamiAssociati().size() > 0){ stringaDescrittivaCompleta +=
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
