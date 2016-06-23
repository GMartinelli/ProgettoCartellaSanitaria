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
	public void isNotCoerenteMalattiaTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");


			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			boolean v=false;
			try{
				EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete);
				try{
					e1.isCoerenteMalattia();
				}
				catch(IllegalArgumentException e){
					v=true;
					e.printStackTrace();
				}
			}
			catch(IllegalArgumentException e ){
				e.printStackTrace();
				v=true;
			}
			
			assertTrue(v);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void setEsameNonCorrettoTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");
			Esame radiografia = new Esame("Radiografia");
			associati.add(glicemia);
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			boolean v=false;
			try{
				EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete);
				try{
					e1.setEsame(radiografia);
				}
				catch(IllegalArgumentException e){
					e.printStackTrace();
					v=true;
				}
			}
			catch(IllegalArgumentException e){
				e.printStackTrace();
				v=true;
			}
			
			assertTrue(v);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void setEsameErratoTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");
			Esame radiografia = new Esame("Radiografia");
			associati.add(glicemia);
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete);
			e1.setEsame(radiografia);
			assertEquals(radiografia,e1.getEsame());
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
