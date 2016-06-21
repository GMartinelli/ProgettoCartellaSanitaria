
package it.unibs.fp.progetto;
/**
 * La classe EsamePeriodicoMisurabile estende la classe Esame per poter creare oggetti EsamePeriodicoMisurabile.
 * Rispetto alla classe madre permette inoltre di definire i risultati di un esame Periodico/Misurabile.
 * In particolare definisce:
 * valoreMin, il valore minimo del range di riferimento di un campo dell'esame;
 * valoreMax, il valore massimo del range di riferimento di un campo dell'esame;
 * sogliaErrore, la soglia(troppo BASSA o troppo ALTA) per cui sicuramente è avvenuta un'anomalia durante l'analisi in merito all'esame.
 * 
 * @author Manenti Gabriele
 */
public class EsamePeriodicoMisurabile extends Esame {
	//Costanti
	public final static String MIN_ZERO = "Un esame non puo' avere esito minore di zero";
	
	//Attributi
	private double valoreMin;
	private double valoreMax;
	private double sogliaErrore;
	
	//Costruttori
	/**
	 * 
	 * @param nome
	 * @param valoreMin
	 * @param valoreMax
	 * @param sogliaErrore
	 * @author Manenti Gabriele
	 */
	public EsamePeriodicoMisurabile(String nome, double valoreMin, double valoreMax, double sogliaErrore){
		super(nome);
		this.valoreMin = valoreMin;
		this.valoreMax = valoreMax;
		this.sogliaErrore = sogliaErrore;
	}

	/**
	 * 
	 * @param nome
	 * @param raccomandazioni
	 * @param valoreMin
	 * @param valoreMax
	 * @param sogliaErrore
	 * @author Manenti Gabriele
	 */
	public EsamePeriodicoMisurabile(String nome, String raccomandazioni, double valoreMin, double valoreMax, double sogliaErrore){
			super(nome, raccomandazioni);
			this.valoreMin = valoreMin;
			this.valoreMax = valoreMax;
			this.sogliaErrore = sogliaErrore;
	}
	
	//Getters
	/**
	 * Ritorna il valoreMin del range di un campo dell'esame Periodico/Misurabile.
	 * 
	 * @return valoreMin il valoreMin del range di un campo dell'esame
	 * 
	 * @author Manenti Gabriele
	 */
	public double getValoreMin() {
		return valoreMin;
	}
	
	/**
	 * Ritorna il valoreMax del range di un campo dell'esame Periodico/Misurabile.
	 * 
	 * @return valoreMax il valoreMax del range di un campo dell'esame
	 * 
	 * @author Manenti Gabriele
	 */
	public double getValoreMax() {
		return valoreMax;
	}
	
	/**
	 * Ritorna la sogliaErrore dell'esame PeriodicoMisurabile
	 * @return sogliaErrore la soglia di errore dell'esame PeriodicoMisurabile
	 * 
	 * @author Manenti Gabriele
	 */
	public double getSogliaErrore() {
		return sogliaErrore;
	}
	
	/**
	 * Ritorna il valore di sogliaMin(= valoreMin - sogliaErrore).
	 * Se l'esito di un campo dell'esame è < 0,lancia IllegalStateException.
	 * 
	 * @return sogliaMin la soglia minima accettabile
	 * @throws IllegalStateException
	 * 
	 * @author Manenti Gabriele
	 */
	public double getValoreSogliaMin() throws IllegalStateException{
		double sogliaMin = valoreMin - sogliaErrore;
		if(sogliaMin <= 0){
			throw new IllegalStateException(MIN_ZERO);
		}
		return sogliaMin;
	}
	
	/**
	 * Ritorna il valoreMax + la sogliaErrore dell'esito dell'esame.
	 * @return valoreMax + sogliaErrore
	 * 
	 * @author Manenti Gabriele
	 */
	public double getValoreSogliaMax(){
		return valoreMax + sogliaErrore;
	}
	
	//Setters
	/**
	 * Metodo che imposta il valore minimo del range di un campo dell'esame.
	 * 
	 * @param valoreMin il valore minimo del range
	 * 
	 * @author Manenti Gabriele
	 */
	public void setValoreMin(double valoreMin) {
		this.valoreMin = valoreMin;
		
	/**
	 * Metodo che imposta il valore massimo del range di un campo dell'esame.
	 * 
	 * @param valoreMax il valore massimo del range
	 * 
	 * @author Manenti Gabriele	
	 */
	}
	public void setValoreMax(double valoreMax) {
		this.valoreMax = valoreMax;
	
	/**
	 * Metodo che imposta la soglia di errore di un campo dell'esame.
	 * 
	 * @param sogliaErrore la soglia di Errore
	 * 
	 * @author Manenti Gabriele	
	 */
	}
	public void setSogliaErrore(double sogliaErrore) {
		this.sogliaErrore = sogliaErrore;
	}
	
	//Metodi
	
	
}