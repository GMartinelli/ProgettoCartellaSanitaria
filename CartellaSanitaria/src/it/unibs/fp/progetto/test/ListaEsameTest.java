package it.unibs.fp.progetto.test;

import static org.junit.Assert.*;
import it.unibs.fp.progetto.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Classe contenente Test JUnit per il controllo della correttezza della Classe ListaEsame
 * 
 * 
 * @author Martinelli Giuseppe
 */


public class ListaEsameTest{

	@Test
	public void testCercaEsamePresente() {
		Esame esame1 = new Esame("Radiografia");
		Esame esame2 = new Esame("Ecografia");
		ArrayList<Esame> array1 = new ArrayList<Esame>();
		array1.add(esame1);
		array1.add(esame2);
		ListaEsame lista1 = new ListaEsame(array1);
		boolean trovato = lista1.isEsistente("Radiografia"); 
		assertEquals(true, trovato);
	}
	
	@Test
	public void testCercaEsameAssente() {
		Esame esame1 = new Esame("Radiografia");
		Esame esame2 = new Esame("Ecografia");
		ArrayList<Esame> array1 = new ArrayList<Esame>();
		array1.add(esame1);
		array1.add(esame2);
		ListaEsame lista1 = new ListaEsame(array1);
		boolean trovato = lista1.isEsistente("Esame del sangue"); 
		assertEquals(false, trovato);
	}

}
