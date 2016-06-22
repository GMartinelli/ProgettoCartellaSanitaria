package it.unibs.fp.progetto.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.progetto.*;

/**
 * Classe contenente Test JUnit per il controllo della correttezza della Classe ListaMalattia
 * 
 * 
 * @author Martinelli Giuseppe
 */

public class ListaMalattiaTest {

	@Test
	public void testIsEsistentePresente() {
		ArrayList<Esame> associati = new ArrayList<>();
		Esame esame1 = new Esame("Colesterolo");
		Esame esame2 = new Esame("Sangue");
		associati.add(esame1);
		associati.add(esame2);
		
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia malattia1 = new Malattia("Raffreddore", MyTime.creaData("01/01/2009"), "Catarro", "Malato", associati, "Soffia");
		Malattia malattia2 = new Malattia("Bronchite", MyTime.creaData("01/02/2009"), MyTime.creaData("15/02/2009"), "Catarro", "Malato", associati, "Soffia");
		elencoMalattia.add(malattia1);
		elencoMalattia.add(malattia2);
		
		ListaMalattia lista1 = new ListaMalattia(elencoMalattia);
		boolean trovato = lista1.isEsistente("Raffreddore"); 
		assertEquals(true, trovato);
	}
	
	@Test
	public void testIsEsistenteAssente() {
		ArrayList<Esame> associati = new ArrayList<>();
		Esame esame1 = new Esame("Colesterolo");
		Esame esame2 = new Esame("Sangue");
		associati.add(esame1);
		associati.add(esame2);
		
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia malattia1 = new Malattia("Raffreddore", MyTime.creaData("01/01/2009"), "Catarro", "Malato", associati, "Soffia");
		Malattia malattia2 = new Malattia("Bronchite", MyTime.creaData("01/02/2009"), MyTime.creaData("15/02/2009"), "Catarro", "Malato", associati, "Soffia");
		elencoMalattia.add(malattia1);
		elencoMalattia.add(malattia2);
		
		ListaMalattia lista1 = new ListaMalattia(elencoMalattia);
		boolean trovato = lista1.isEsistente("Polmonite"); 
		assertEquals(false, trovato);
	}
	
	@Test
	public void testCercaMalattiaPresente() {
		ArrayList<Esame> associati = new ArrayList<>();
		Esame esame1 = new Esame("Colesterolo");
		Esame esame2 = new Esame("Sangue");
		associati.add(esame1);
		associati.add(esame2);
		
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		Malattia malattia1 = new Malattia("Raffreddore", MyTime.creaData("01/01/2009"), "Catarro", "Malato", associati, "Soffia");
		Malattia malattia2 = new Malattia("Bronchite", MyTime.creaData("01/02/2009"), MyTime.creaData("15/02/2009"), "Catarro", "Malato", associati, "Soffia");
		elencoMalattia.add(malattia1);
		elencoMalattia.add(malattia2);
		
		ListaMalattia lista1 = new ListaMalattia(elencoMalattia);
		Malattia trovato = lista1.cercaMalattia("Raffreddore"); 
		assertEquals(malattia1, trovato);
	}

}
