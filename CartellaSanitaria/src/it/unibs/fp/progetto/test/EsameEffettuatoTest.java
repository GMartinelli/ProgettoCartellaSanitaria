package it.unibs.fp.progetto.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.progetto.EPeriodicoMisurabileEffettuato;
import it.unibs.fp.progetto.Esame;
import it.unibs.fp.progetto.EsamePeriodicoMisurabile;
import it.unibs.fp.progetto.Malattia;
import it.unibs.fp.progetto.EsameEffettuato;

public class EsameEffettuatoTest {
	
	@Test
	public void isCoerenteMalattiaTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");
			associati.add(glicemia);
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete);
			assertTrue(e1.isCoerenteMalattia());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void setEsameCorrettoTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");
			associati.add(glicemia);
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete);
			e1.setEsame(glicemia);
			assertEquals(glicemia,e1.getEsame());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void toStringTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");
			associati.add(glicemia);
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete,"Seriate",MyTime.creaData("10/04/1968"),"08:30");
			
			String provaToString = e1.toString();
			String prova = glicemia.getNome() + "%nData: " + MyTime.toStringData(e1.getData()) + "%nOra: " + e1.getOra() + "%nLuogo: " + e1.getLuogo();
			assertEquals(provaToString, prova);		
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
}
