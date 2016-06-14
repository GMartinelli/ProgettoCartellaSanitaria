package it.unibs.fp.progetto;

public class EsamePeriodicoMisurabile extends Esame {
	//costanti
	public final static String MIN_ZERO = "Un esame non può avere esito minore di zero";
	
	//Attributi
	private double valoreMin;
	private double valoreMax;
	private double sogliaErrore;
	
	//Costruttori
	public EsamePeriodicoMisurabile(String nome, double valoreMin, double valoreMax, double sogliaErrore){
		super(nome);
		this.valoreMin = valoreMin;
		this.valoreMax = valoreMax;
		this.sogliaErrore = sogliaErrore;
	}

	public EsamePeriodicoMisurabile(String nome, String raccomandazioni, double valoreMin, double valoreMax, double sogliaErrore){
			super(nome, raccomandazioni);
			this.valoreMin = valoreMin;
			this.valoreMax = valoreMax;
			this.sogliaErrore = sogliaErrore;
	}
	
	//Getters
	public double getValoreMin() {
		return valoreMin;
	}
	
	public double getValoreMax() {
		return valoreMax;
	}
	
	public double getSogliaErrore() {
		return sogliaErrore;
	}
	
	/*Lancio l'eccezione perchè un esame non può avere esito < 0*/
	public double getValoreSogliaMin() throws IllegalStateException{
		double sogliaMin = valoreMin - sogliaErrore;
		if(sogliaMin <= 0){
			throw new IllegalStateException(MIN_ZERO);
		}
		return sogliaMin;
	}
	
	public double getValoreSogliaMax(){
		return valoreMax + sogliaErrore;
	}
	
	//Setters
	public void setValoreMin(double valoreMin) {
		this.valoreMin = valoreMin;
	}
	public void setValoreMax(double valoreMax) {
		this.valoreMax = valoreMax;
		
	}
	public void setSogliaErrore(double sogliaErrore) {
		this.sogliaErrore = sogliaErrore;
	}
	
	//Metodi
	
	

}