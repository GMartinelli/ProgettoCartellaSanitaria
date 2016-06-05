package it.unibs.fp.progetto;
import java.util.ArrayList;

public class ListaEsame{
	//Attributi
	ArrayList<Esame> lista;
	
	//Getters
	public ArrayList<Esame> getLista() {
		return lista;
	}
	
	//Setters
	public void setLista(ArrayList<Esame> lista) {
		this.lista = lista;
	}
	//Costruttore
	public ListaEsame(ArrayList<Esame> lista){
		lista = new ArrayList<Esame>();
		this.lista = lista;
	}
	//Metodi
	public boolean cercaEsame(String nomeEsame){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNome() == nomeEsame)
				return true;
		}
		return false;
	}
	

}
