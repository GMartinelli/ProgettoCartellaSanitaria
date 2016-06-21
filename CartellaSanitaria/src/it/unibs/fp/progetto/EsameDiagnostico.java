package it.unibs.fp.progetto;

public class EsameDiagnostico extends Esame {
	
	//Attributi
	private String areaInteressata;
	

	//Costruttori
	public EsameDiagnostico(){
		super();
		this.areaInteressata = null;
	}
	
	public EsameDiagnostico(String nome, String raccomandazioni, String areaInteressata){
		super(nome, raccomandazioni);
		this.areaInteressata = areaInteressata;
	}
	
	//Getters
	public String getAreaInteressata() {
		return areaInteressata;
	}
	
	//Setters
	public void setAreaInteressata(String areaInteressata) {
		this.areaInteressata = areaInteressata;
	}
	//Metodi
	

}
