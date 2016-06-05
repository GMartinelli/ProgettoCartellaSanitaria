package it.unibs.fp.progetto;

public class EsamiPeriodiciMisurabili extends Esame {
	
	//Attributi
	private double valoreMin;
	private double valoreMax;
	private double sogliaErrore;
	
	
	
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
	
	//Costruttori
	public EsamiPeriodiciMisurabili(String nome, String raccomandazioni, double valoreMin, double valoreMax, double sogliaErrore){
			super(nome, raccomandazioni);
			this.valoreMin = valoreMin;
			this.valoreMax = valoreMax;
			this.sogliaErrore = sogliaErrore;
	}
	
	public EsamiPeriodiciMisurabili(String nome, double valoreMin, double valoreMax, double sogliaErrore){
		super(nome);
		this.valoreMin = valoreMin;
		this.valoreMax = valoreMax;
		this.sogliaErrore = sogliaErrore;
	}
	
	//Metodi
	
	

}
