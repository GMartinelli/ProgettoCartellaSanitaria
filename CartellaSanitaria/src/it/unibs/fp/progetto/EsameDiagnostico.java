package it.unibs.fp.progetto;
/**
 * La classe EsameDiagnostico estende la classe Esame per poter creare oggetti EsameDiagnostico.
 * Rispetto alla classe madre permette inoltre di definire:  
 * l'esito dell'esame;
 * l'area del corpo interessata in merito all'esame.
 * 
 * @author Manenti Gabriele
 */
public class EsameDiagnostico extends Esame {
	
	//Attributi
	private String areaInteressata;
	

	//Costruttori
	/**
	 * Costruttore di default
	 * 
	 * @author Manenti Gabriele
	 */
	public EsameDiagnostico(){
		super();
		this.areaInteressata = null;
	}
	
	/**
	 * Costruttore che richiama il costruttore della classe Madre e inserisce gli attributi passati dall'utente.
	 * 
	 * @param nome il nome del paziente
	 * @param esitoAcc l'esito dell'esame Diagnostico
	 * @param areaInteressata l'area del corpo Interessata in merito all'esame
	 * 
	 * @author Manenti Gabriele
	 */
	public EsameDiagnostico(String nome, String areaInteressata){
		super(nome);
		this.areaInteressata = areaInteressata;
	}
	
	/**
	 * Costruttore uguale al precedente con l'aggiunta dell'attributo raccomandazioni.
	 * 
	 * @param nome il nome del paziente
	 * @param raccomandazioni le raccomandazioni dell'esame diagnostico
	 * @param esitoAcc l'esito dell'esame diagnostico
	 * @param areaInteressata l'area del corpo interessata in merito all'esame
	 * 
	 * @author Manenti Gabriele
	 */
	public EsameDiagnostico(String nome, String raccomandazioni,String areaInteressata){
		super(nome, raccomandazioni);
		this.areaInteressata = areaInteressata;
	}
	
	//Getters
	/**
	 * Ritorna l'area del corpo interessata in merito all'esame.
	 * 
	 * @return areaInteressata l'area del corpo interessata
	 * 
	 * @author Manenti Gabriele
	 */
	public String getAreaInteressata() {
		return areaInteressata;
	}
	//Setters
	/**
	 * Metodo che imposta l'area del corpo interessata in merito all'esame
	 * 
	 * @param areaInteressata l'area del corpo interessata
	 * 
	 * @author Manenti Gabriele
	 */
	public void setAreaInteressata(String areaInteressata) {
		this.areaInteressata = areaInteressata;
	}
	//Metodi
	

}
