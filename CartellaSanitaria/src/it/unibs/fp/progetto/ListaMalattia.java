package it.unibs.fp.progetto;
import java.util.ArrayList;

public class ListaMalattia {
	
	//Attributi
	private ArrayList<Malattia> lista;
		
	//Getters
	public ArrayList<Malattia> getLista() {
		return lista;
	}
		
	//Setters
	public void setLista(ArrayList<Malattia> lista) {
		this.lista = lista;
	}
	
	//Costruttore
	public ListaMalattia(ArrayList<Malattia> lista){
		lista = new ArrayList<Malattia>();
		this.lista = lista;
	}
	
	//Metodi
	public boolean cercaMalattia(String nomeMalattia){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome() == nomeMalattia)
				return true;
		}
		return false;
	}

}
