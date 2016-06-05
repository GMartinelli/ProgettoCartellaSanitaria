package it.unibs.fp.progetto;

public class EsamiDiagnostici extends Esame {
	
	//Attributi
	private String esitoAcc;
	private String areaInteressata;
	
	
	//Getters
	public String getEsitoAcc() {
		return esitoAcc;
	}
	public String getAreaInteressata() {
		return areaInteressata;
	}
	//Setters
	public void setEsitoAcc(String esitoAcc) {
		this.esitoAcc = esitoAcc;
	}
	
	public void setAreaInteressata(String areaInteressata) {
		this.areaInteressata = areaInteressata;
	}
	//Costruttori
	public EsamiDiagnostici(String nome, String raccomandazioni, String esitoAcc, String areaInteressata){
		super(nome, raccomandazioni);
		this.esitoAcc = esitoAcc;
		this.areaInteressata = areaInteressata;
	}
	
	public EsamiDiagnostici(String nome, String esitoAcc, String areaInteressata){
		super(nome);
		this.esitoAcc = esitoAcc;
		this.areaInteressata = areaInteressata;
	}
	//Metodi
	

}
