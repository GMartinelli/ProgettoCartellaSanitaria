package it.unibs.fp.progetto.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.progetto.Esame;
import it.unibs.fp.progetto.EsameEffettuato;
import it.unibs.fp.progetto.Malattia;

public class MalattiaTest {

	@Test
	public void toStringBaseTest(){
		
			Malattia sinusite = new Malattia("Sinusite",MyTime.creaData("10/02/1999"),"Mal di testa","Malato","Farmaci");
			String provaToString = sinusite.toString();
			String prova = sinusite.getNome() + "%n   Iniziata: " + MyTime.toStringData(sinusite.getDataInizio());
			assertEquals(provaToString, prova);		
	}
	
	@Test
	public void toStringTerminataTest(){
		
			ArrayList<Esame> associati = new ArrayList<>();
			Esame tac = new Esame("Tac");
			associati.add(tac);
			Malattia sinusite = new Malattia("Sinusite",MyTime.creaData("10/02/1999"),MyTime.creaData("10/02/2000"),"Mal di testa","Malato",associati,"Farmaci");
			String provaToString = sinusite.toString();
			String prova = sinusite.getNome() + "%n   Iniziata: " + MyTime.toStringData(sinusite.getDataInizio()) + "%n   Terminata:  " + MyTime.toStringData(sinusite.getDataTermine());
			assertEquals(provaToString, prova);		
	
	}

	@Test
	public void isAssociatoTrueTest(){
		
			ArrayList<Esame> associati = new ArrayList<>();
			Esame tac = new Esame("Tac");
			associati.add(tac);
			Malattia sinusite = new Malattia("Sinusite",MyTime.creaData("10/02/1999"),MyTime.creaData("10/02/2000"),"Mal di testa","Malato",associati,"Farmaci");
			
			assertTrue(sinusite.isAssociato("Tac"));		
	}
	
	@Test
	public void isAssociatoFalseTest(){
		
			ArrayList<Esame> associati = new ArrayList<>();
			Esame tac = new Esame("Tac");
			
			Malattia sinusite = new Malattia("Sinusite",MyTime.creaData("10/02/1999"),MyTime.creaData("10/02/2000"),"Mal di testa","Malato",associati,"Farmaci");
			
			assertFalse(sinusite.isAssociato("Tac"));		
	}

}
