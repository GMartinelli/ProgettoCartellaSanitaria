package it.unibs.fp.progetto.test;

/**
 * Classe contenente Test JUnit per il controllo della correttezza della Classe CartellaSanitaria
 * 
 * 
 * @author Valtulini Claudio
 */

import static org.junit.Assert.*;

import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.progetto.*;
import java.util.ArrayList;

import org.junit.Test;
public class CartellaSanitariaTest {

	@Test
	public void toStringTest(){
		try{
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

			ArrayList<EsameEffettuato> esamiEffettuati = new ArrayList<>();
			esamiEffettuati.add(new EsameEffettuato(esame1, malattia1, "Sarnico", MyTime.creaData("18/01/2009"), "15:30"));
			esamiEffettuati.add(new EsameEffettuato(esame2, malattia2, "Sarnico", MyTime.creaData("18/01/2009"), "17:30"));
			
			CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, "RSIROM85D18X999B", "+A");
			CS1.setElencoMalattia(elencoMalattia);
			CS1.setEsamiEffettuati(esamiEffettuati);
			
			String stringaMetodo = CS1.toString();
			String stringaMia = "Nome: " + CS1.getNome() + "%nCognome: " + CS1.getCognome() + "%nElenco esami: %n" + esamiEffettuati.get(0).toString() +
					"%n" + esamiEffettuati.get(1).toString() + "%nElenco malattie: %n" + malattia1.toString() + "%n" + malattia2.toString() + "%n";
			
			assertEquals(stringaMetodo, stringaMia);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkValiditaCFCorretto(){
		String CF = "RSIROM85D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertTrue(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErratoLunghezza(){
		String CF = "RSIRM85D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato16_1(){
		String CF = "R3IROM85D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato16_2(){
		String CF = "RSIRO385D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato78_1(){
		String CF = "RSIROMA5D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato78_2(){
		String CF = "RSIROM8SD18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato9(){
		String CF = "RSIROM85418X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1011_1(){
		String CF = "RSIROM85DG8X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1011_2(){
		String CF = "RSIROM85D1LX999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato12(){
		String CF = "RSIROM85D188999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1315_1(){
		String CF = "RSIROM85D18XW99B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1315_2(){
		String CF = "RSIROM85D18X99WB";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato16(){
		String CF = "RSIROM85D18X9990";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaTelefonoCorretto(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertTrue(CS1.checkValiditaTelefono(CS1.getTelefono()));
	}
	
	@Test
	public void checkValiditaTelefonoErratoLunghezza(){
		String CF = "RSIROM85D18X999B";
		String telefono = "";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaTelefono(CS1.getTelefono()));
	}
	
	@Test
	public void checkValiditaTelefonoErrato(){
		String CF = "RSIROM85D18X999B";
		String telefono = "00000D000";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaTelefono(CS1.getTelefono()));
	}
	
	@Test
	public void checkValiditaMailCorretto(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertTrue(CS1.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoLunghezza(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "@d.f";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoInverto(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab.cd@ef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoMancante1(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "abcd.ef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoMancante2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cdef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoMancante3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "abcdef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CS1.checkValiditaEMail(CS1.getEmail()));
	}
}
