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
	public void testIsEsistentePresente() {
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
	public void testIsEsistenteAssente() {
		Esame esame1 = new Esame("Radiografia");
		Esame esame2 = new Esame("Ecografia");
		ArrayList<Esame> array1 = new ArrayList<Esame>();
		array1.add(esame1);
		array1.add(esame2);
		ListaEsame lista1 = new ListaEsame(array1);
		boolean trovato = lista1.isEsistente("Esame del sangue"); 
		assertEquals(false, trovato);
	}

	@Test
	public void testCercaMalattiaPresente() {
		Esame esame1 = new Esame("Radiografia");
		Esame esame2 = new Esame("Ecografia");
		ArrayList<Esame> array1 = new ArrayList<Esame>();
		array1.add(esame1);
		array1.add(esame2);
		ListaEsame lista1 = new ListaEsame(array1);
		Esame trovato = lista1.cercaEsame("Radiografia"); 
		assertEquals(esame1, trovato);
	}
	
	@Test
	public void testCercaMalattiaAssente() {
		Esame esame1 = new Esame("Radiografia");
		Esame esame2 = new Esame("Ecografia");
		ArrayList<Esame> array1 = new ArrayList<Esame>();
		array1.add(esame1);
		array1.add(esame2);
		ListaEsame lista1 = new ListaEsame(array1);
		Esame trovato = lista1.cercaEsame("Esame del sangue"); 
		assertEquals(null, trovato);
	}
}
