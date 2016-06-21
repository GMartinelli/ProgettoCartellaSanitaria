package it.unibs.fp.progetto;
/**
 * La classe ListaMalattia permette di creare una lista in cui inserire un elenco di Malattie.
 * 
 * @author Manenti Gabriele
 */
import java.util.ArrayList;

public class ListaMalattia {
	
	//Attributi
	private ArrayList<Malattia> lista;
	
	//Costruttore
	/**
	 * Costruttore che permette di impostare una ArrayList che contiene un elenco di malattie.
	 * 
	 * @param lista l'ArrayList che contiene un elenco di malattie
	 * 
	 * @author Manenti Gabriele
	 */
	public ListaMalattia(ArrayList<Malattia> lista){
		this.lista = new ArrayList<Malattia>();
		this.lista = lista;
	}
		
	//Getters
	/**
	 * Ritorna l'ArrayList lista che contiene un elenco di malattie
	 * 
	 * @return lista l'ArrayList che contiene un elenco di malattie
	 * 
	 * @author Manenti Gabriele
	 */
	public ArrayList<Malattia> getLista() {
		return lista;
	}
		
	//Setters
	/**
	 * Metodo che imposta una lista di malattie
	 * 
	 * @param lista l'ArrayList che contiene un elenco di malattie
	 * 
	 * @author Manenti Gabriele
	 */
	public void setLista(ArrayList<Malattia> lista) {
		this.lista = lista;
	}
	
	//Metodi
	/**
	 * Metodo che ricerca per nome una malattia all'interno di un'ArrayList.
	 * @param nomeMalattia il nome della malattia da cercare.
	 * 
	 * @return true se la malattia è stata trovata, altrimenti ritorna false.
	 * 
	 * @author Manenti Gabriele
	 */
	public boolean isEsistente(String nomeMalattia){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome() == nomeMalattia)
				return true;
		}
		return false;
	}
	/**
	 * Metodo che ricerca per nome una malattia all'interno di un'ArrayList.
	 * 
	 * @param nomeMalattia il nome della malattia da cercare.
	 * 
	 * @return Malattia se viene trovata, altrimenti ritorna null.
	 */
	public Malattia cercaEsame(String nomeMalattia){

		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome() == nomeMalattia)
				return lista.get(i);
		}
		return null;
	}

}
