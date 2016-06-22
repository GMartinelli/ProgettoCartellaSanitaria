package it.unibs.fp.progetto.test;

import static org.junit.Assert.*;
import it.unibs.fp.progetto.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.mylib.TooLateException;
import it.unibs.fp.progetto.EDiagnosticoEffettuato;
import it.unibs.fp.progetto.Esame;
import it.unibs.fp.progetto.EsameDiagnostico;
import it.unibs.fp.progetto.Malattia;

public class EPeriodicoMisurabileEffettuatoTest {


	@Test
	public void setAvvisiCompresoTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",5.00);
		
		assertEquals("L'esito dell'esame e' conforme ai valori accettabili", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setAvvisiInferioreTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",0.00);
		
                                   		
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setAvvisiSuperioreTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",18.00);
		
		assertEquals("Attenzione! L'esito dell'esame e' superiore al valore massimo accettabile", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setAvvisiFuoriSogliaMaxTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",66.00);
		
		assertEquals("URGENZA! L'esito dell'esame e' MOLTO superiore al valore massimo accettabile", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setAvvisiFuoriSogliaMinTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",-60.00);
		
		assertEquals("URGENZA! L'esito dell'esame e' MOLTO inferiore al valore massimo accettabile", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void setLuogoPossibileTest(){
		try{
			ArrayList<Esame> associati = new ArrayList<>();
			EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
			associati.add(glicemia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
			elencoMalattia.add(diabete);
		
			EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50");
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
			EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
			associati.add(glicemia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
			elencoMalattia.add(diabete);
		
			EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50");
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
			EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
			associati.add(glicemia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
			elencoMalattia.add(diabete);
		
			EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50");
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
			EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
			associati.add(glicemia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
			elencoMalattia.add(diabete);
		    
			EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",66.00);
			
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
			EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
			associati.add(glicemia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
			elencoMalattia.add(diabete);
		    
			EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",66.00);

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
			EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
			associati.add(glicemia);
		
			ArrayList<Malattia> elencoMalattia = new ArrayList<>();
			Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
			elencoMalattia.add(diabete);
		    
			EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",66.00);

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
	
	
}
