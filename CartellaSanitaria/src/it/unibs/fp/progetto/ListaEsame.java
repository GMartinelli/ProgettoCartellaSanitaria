package it.unibs.fp.progetto;
import java.io.Serializable;
/**
 * La classe ListaEsame permette di creare una lista in cui inserire un elenco di Esami.
 * 
 * @author Manenti Gabriele
 */
import java.util.ArrayList;

public class ListaEsame implements Serializable{
	//Attributi
	private ArrayList<Esame> lista;

	//Costruttore
	/**
	 * Costruttore che permette di impostare una ArrayList che contiene un elenco di esami.
	 * 
	 * @param lista l'ArrayList che contiene un elenco di esami
	 * 
	 * @author Manenti Gabriele
	 */
	public ListaEsame(ArrayList<Esame> lista){
		this.lista = new ArrayList<Esame>();
		this.lista = lista;
	}
	
	//Getters
	/**
	 * Ritorna l'ArrayList lista che contiene un elenco di esami
	 * 
	 * @return lista l'ArrayList che contiene un elenco di esami
	 * 
	 * @author Manenti Gabriele
	 */
	public ArrayList<Esame> getLista() {
		return lista;
	}
	
	//Setters
	/**
	 * Metodo che imposta una lista di esami
	 * 
	 * @param lista l'ArrayList che contiene un elenco di esami
	 * 
	 * @author Manenti Gabriele
	 */
	public void setLista(ArrayList<Esame> lista) {
		this.lista = lista;
	}
	
	//Metodi
	/**
	 * Metodo che ricerca per nome un esame all'interno di un'ArrayList.
	 * @param nomeEsame il nome dell'esame da cercare.
	 * 
	 * @return true se l'esame � stato trovato, altrimenti ritorna false.
	 * 
	 * @author Manenti Gabriele
	 */
	public boolean isEsistente(String nomeEsame){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome() == nomeEsame)
				return true;
		}
		return false;
	}
	/**
	 * Metodo che ricerca per nome un esame all'interno di un'ArrayList.
	 * 
	 * @param nomeEsame il nome dell'esame da cercare.
	 * 
	 * @return Esame se l'esame viene trovato, altrimenti ritorna null.
	 */
	public Esame cercaEsame(String nomeEsame){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome() == nomeEsame)
				return lista.get(i);
		}
		return null;
	}
	
	/**
	 * Permette di aggiungere un'esame all'ArrayList che li contiene
	 * @param <strong>esame</strong> l'esame da aggiungere
	 * 
	 * @author Valtulini Claudio
	 */
	public void aggiungiEsame(Esame esame){
		lista.add(esame);
	}
	
	/**
	 * Permette di rimuovere un'esame all'ArrayList che li contiene
	 * @param <strong>esame</strong> l'esame da rimuovere
	 * 
	 * @author Valtulini Claudio
	 */
	public void rimuoviEsame(Esame esame){
		lista.remove(esame);
	}
}
