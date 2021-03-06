package it.unibs.fp.progetto.test;
/**
 * Classe contenente Test JUnit per il controllo della correttezza della Classe EdiagnosticoEffettuato.
 * 
 * @author Manenti Gabriele 
 */

import static org.junit.Assert.*;

import org.junit.Test;
import it.unibs.fp.progetto.*;
import java.util.ArrayList;

import it.unibs.fp.mylib.*;


public class EDiagnosticoEffettuatoTest {

	@Test
	public void isEffettuatoTestCorretto() {
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
			
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre","Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
		
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			assertFalse(e1.isEffettuato());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setLuogoPossibileTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
			
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
			
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			e1.setLuogo("Bergamo");
			
			assertEquals("Bergamo", e1.getLuogo());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setOraPossibileTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
			
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
			
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			e1.setOra("09:51");
			
			assertEquals("09:51", e1.getOra());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setDataPossibileTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
			
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
			
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			e1.setData(MyTime.creaData("10/01/2012"));
			
			String attesa = MyTime.creaData("10/01/2012").toString();
			String effettiva = e1.getData().toString();
			
			assertEquals(attesa, effettiva);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setLuogoImpossibile(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
		
			String esito = "Malato";
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			e1.setEsito(esito);

			boolean thrown = false;
			
			try{
				e1.setLuogo("nomePaese");
			}
			catch(TooLateException e){
				thrown = true;
			}
			assertTrue(thrown);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void setOraImpossibile(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
		
			String esito = "Malato";
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			e1.setEsito(esito);

			boolean thrown = false;
			
			try{
				e1.setOra("09:51");
			}
			catch(TooLateException e){
				thrown = true;
			}
			assertTrue(thrown);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void setDataImpossibile(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
		
			String esito = "Malato";
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			e1.setEsito(esito);

			boolean thrown = false;
			
			try{
				e1.setData(MyTime.creaData("10/01/2012"));
			}
			catch(TooLateException e){
				thrown = true;
			}
			assertTrue(thrown);
		
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void setEsamePossibileTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
	
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
	
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			e1.setEsame(radiografia);
			
			assertEquals(radiografia,e1.getEsame());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void setEsameImpossibileTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsameDiagnostico radiografia = new EsameDiagnostico("Radiografia", "Focolaio", "Torace");
			associati.add(radiografia);
	
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia polmonite = new Malattia("Polmonite", MyTime.creaData("01/01/2012"), "Dolori al petto e febbre", "Malato", associati, "Penicillina");
			elencoMalattia.add(polmonite);
	
			EDiagnosticoEffettuato e1 = new EDiagnosticoEffettuato(radiografia, polmonite);
			String esito = "Malato";
			e1.setEsito(esito);
			
			boolean thrown = false;
			try{
				e1.setEsame(radiografia);
			}
			catch(TooLateException e){
				thrown = true;
			}
			assertTrue(thrown);
			
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
}
