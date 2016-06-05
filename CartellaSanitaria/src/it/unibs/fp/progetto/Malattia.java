package it.unibs.fp.progetto;
import java.util.ArrayList;

public class Malattia {
	/*Attributi*/
	private String nome;
	private String dataInizio;
	private String dataTermine;
	private String sintomi;
	private String diagnosi;
	private ArrayList<Esame> elencoEsamiAssociati;
	private String terapia;
	
	/*Getters*/
	public String getNome() {
		return nome;
	}
	public String getDataInizio() {
		return dataInizio;
	}
	public String getDataTermine() {
		return dataTermine;
	}
	public String getSintomi() {
		return sintomi;
	}
	public String getDiagnosi() {
		return diagnosi;
	}
	public ArrayList<Esame> getElencoEsamiAssociati() {
		return elencoEsamiAssociati;
	}
	public String getTerapia() {
		return terapia;
	}
	
	/*Setters*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public void setDataTermine(String dataTermine) {
		this.dataTermine = dataTermine;
	}
	public void setSintomi(String sintomi) {
		this.sintomi = sintomi;
	}
	public void setDiagnosi(String diagnosi) {
		this.diagnosi = diagnosi;
	}
	public void setElencoEsamiAssociati(ArrayList<Esame> elencoEsamiAssociati) {
		this.elencoEsamiAssociati = elencoEsamiAssociati;
	}
	public void setTerapia(String terapia) {
		this.terapia = terapia;
	}
	
	/*Costruttori*/
	public Malattia(String nome, String dataInizio, String sintomi, String diagnosi, ArrayList<Esame> elencoEsamiAssociati, String terapia){
		this.nome=nome;
		this.dataInizio=dataInizio;
		this.dataTermine="";
		this.sintomi=sintomi;
		this.diagnosi=diagnosi;
		this.elencoEsamiAssociati=new ArrayList<Esame>();
		this.elencoEsamiAssociati=elencoEsamiAssociati;
		this.terapia=terapia;
	}
	
	public Malattia(String nome, String dataInizio, String dataTermine, String sintomi, String diagnosi, ArrayList<Esame> elencoEsamiAssociati, String terapia){
		this.nome=nome;
		this.dataInizio=dataInizio;
		this.dataTermine=dataTermine;
		this.sintomi=sintomi;
		this.diagnosi=diagnosi;
		this.elencoEsamiAssociati=new ArrayList<Esame>();
		this.elencoEsamiAssociati=elencoEsamiAssociati;
		this.terapia=terapia;
	}
	
	/*Metodi*/
	public String toString(){
		String descrizione="";
		descrizione+="Nome: "+nome+"\n";
		descrizione+="Data Inizio: "+dataInizio+"\n";
		if(dataTermine!="")
			descrizione+="Data Termine: "+dataTermine+"\n";
		descrizione+="Sintomi: "+sintomi+"\n";
		descrizione+="Diagnosi: "+diagnosi+"\n";
		descrizione+="Eleno esami associato: \n";
		for(int i=0; i<elencoEsamiAssociati.size();i++)
			descrizione=elencoEsamiAssociati.get(i).getNome()+"\n";
		descrizione+="Terapia: "+terapia+"\n";
		return descrizione;
	}
	public boolean isAssociato(String nomeEsame){
		for(int i=0; i<elencoEsamiAssociati.size(); i++){
			if(elencoEsamiAssociati.get(i).getNome()==nomeEsame)
				return true;
		}
		return false;
	}
}
