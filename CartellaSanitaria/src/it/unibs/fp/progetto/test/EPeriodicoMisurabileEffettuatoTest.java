package it.unibs.fp.progetto.test;

import static org.junit.Assert.*;
import it.unibs.fp.progetto.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unibs.fp.mylib.MyTime;
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
	
		String esito = "Malato";
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",5.00);
		
		assertEquals("L'esito dell'esame e' conforme ai valori accettabili", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	public void setAvvisiInferioreTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		String esito = "Malato";
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",0.50);
		
		assertEquals("Attenzione! L'esito dell'esame e' inferiore al valore massimo accettabile", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	public void setAvvisiSuperioreTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		String esito = "Malato";
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",16.00);
		
		assertEquals("Attenzione! L'esito dell'esame e' inferiore al valore massimo accettabile", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	public void setAvvisiFuoriSogliaTest() {
		try{
		ArrayList<Esame> associati = new ArrayList<>();
		EsamePeriodicoMisurabile glicemia = new EsamePeriodicoMisurabile("Glicemia", 1.00,15.00, 50.00);
		associati.add(glicemia);
	
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia diabete = new Malattia("Diabete", MyTime.creaData("01/01/2012"), "Pressione Alta", "Malato", associati, "Insulina");
		elencoMalattia.add(diabete);
	
		String esito = "Malato";
		EPeriodicoMisurabileEffettuato e1 = new EPeriodicoMisurabileEffettuato(glicemia,diabete, "Sarnico", MyTime.creaData("02/01/2012"),"08:50",51.00);
		
		assertEquals("Non bere prima dell'Esame", e1.getAvvisi());
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
}
