package it.unibs.fp.progetto.test;
/**
 * Classe contenente Test JUnit per il controllo della correttezza della Classe EsameEffettuato.
 * 
 * @author Manenti Gabriele 
 */
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
	public void isNonCoerenteMalattiaTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");
			
			
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			boolean valido = false;
			try{
				EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete);
				try{
					e1.isCoerenteMalattia();
				}
				catch(IllegalArgumentException e){
					valido = true;
					e.printStackTrace();
				}
			}
			catch(IllegalArgumentException e){
				e.printStackTrace();
				valido = true;
			}
			
			assertTrue(valido);
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
	public void setEsameErratoTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia");
			Esame radiografia = new Esame("Radiografia");
			associati.add(glicemia);
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			boolean valido = false;
			try{
				EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete);
				try{
					e1.setEsame(radiografia);
				}
				catch(IllegalArgumentException e){
					valido = true;
					e.printStackTrace();
				}
			}
			catch(IllegalArgumentException e){
				e.printStackTrace();
				valido = true;
			}
			
			assertTrue(valido);
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
			String prova = glicemia.getNome() + "%n   Data: " + MyTime.toStringData(e1.getData()) + "%n   Ora: " + e1.getOra() + "%n   Luogo: " + e1.getLuogo();
			assertEquals(provaToString, prova);		
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void toStrinCompletoTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			Esame glicemia = new Esame("Glicemia","Non bere prima dell'esame");
			associati.add(glicemia);
			
			Malattia diabete = new Malattia("Diabete",MyTime.creaData("10/04/1967"),"Pressione Alta","Malato",associati,"Insulina");
			EsameEffettuato e1 = new EsameEffettuato(glicemia,diabete,"Seriate",MyTime.creaData("10/04/1968"),"08:30");
			
			String provaToString = e1.toStringCompleto();
			String prova = "Tipologia Esame: " + glicemia.getNome() + "%n" +
						   "Raccomandazioni: " + glicemia.getRaccomandazioni() + "%n" +
						   "Data: " + MyTime.toStringData(e1.getData()) + "%n" +
						   "Ora: " + e1.getOra() + "%n" +
						   "Luogo: " + e1.getLuogo() + "%n" +
						   "Malattia associata: " + diabete.toString() + "%n";
			assertEquals(provaToString, prova);		
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
}
