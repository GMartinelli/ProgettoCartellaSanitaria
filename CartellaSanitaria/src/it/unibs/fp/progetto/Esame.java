package it.unibs.fp.progetto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Esame che definisce un <u>esame</u>.
 * 
 * Un esame ha le seguenti caratteristiche:
 * nome del paziente;
 * raccomandazioni in merito all'esame specifico;
 * 
 * @author Manenti Gabriele
 */
public class Esame  implements Serializable{
	//Attributi
	private String nome;
	private String raccomandazioni;
	
	//Costruttori
	/**
	 * Costruttore di default
	 * 
	 * @author Manenti Gabriele
	 */
	public Esame(){
		nome = null;
		raccomandazioni = null;
	}
	
	/**
	 * Costruttore che definisce l'oggetto impostando il nome senza raccomandazioni.
	 * @param nome nome dell'esame
	 * 
	 * @author Manenti Gabriele
	 */
	public Esame(String nome){
		this.nome = nome;
		raccomandazioni = null;
	} 
	
	/**
	 * Costruttore che definisce l'oggetto impostando il nome del paziente con le raccomandazioni relative all'esame da effettuare.
	 * 
	 * @param nome nome dell'esame
	 * @param raccomandazioni raccomandazioni dell'esame
	 * 
	 * @author Manenti Gabriele
	 */
	public Esame(String nome, String raccomandazioni){
		this.nome = nome;
		this.raccomandazioni = raccomandazioni;
	}
	
	//Getters
	/**
	 *Ritorna il nome del paziente 
	 *@return nome del paziente
	 *
	 *@author Manenti Gabriele
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Ritorna le raccomandazioni in merito all'esame da effettuare.
	 * @return raccomandazioni dell'esame
	 * 
	 * @author Manenti Gabriele
	 */
	public String getRaccomandazioni() {
		return raccomandazioni;
	}
	
	//Setters
	/**
	 * Metodo che imposta il nome del paziente.
	 * 
	 * @param nome il nome del paziente
	 * 
	 * @author Manenti Gabriele
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo che imposta le raccomandazioni relative all'esame da effettuare 
	 *
	 * @param raccomandazioni le raccomandazioni dell'esame da effettuare
	 * 
	 * @author Manenti Gabriele
	 */
	public void setRaccomandazioni(String raccomandazioni) {
		this.raccomandazioni = raccomandazioni;
	}
	
	//Metodi
	/**
	 * Ritorna una stringa contenente le informazioni dell'oggetto
	 * @return il nome dell'oggetto
	 * 
	 * @author Valtulini Claudio
	 */
	public String toString(){
		return nome;
	}

}
