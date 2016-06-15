package it.unibs.fp.progetto.test;

import static org.junit.Assert.*;

import it.unibs.fp.mylib.MyTime;
import it.unibs.fp.progetto.*;
import java.util.ArrayList;

import org.junit.Test;
public class CartellaSanitariaTest {

	@Test
	public void testCodiceFiscale1() {
		ArrayList<EsameEffettuato> esamiEffettuati = new ArrayList<>();
		
		ArrayList<Malattia> elencoMalattia = new ArrayList<>();
		
		ArrayList<Esame> associati = new ArrayList<>();
		Esame esame1 = new Esame("Colesterolo");
		Esame esame2 = new Esame("Sangue");
		associati.add(esame1);
		associati.add(esame2);
		
		Malattia malattia1 = new Malattia("Raffreddore", MyTime.creaData("01/01/2009"), "Catarro", "Malato", associati, "Soffia");
		Malattia malattia2 = new Malattia("Bronchite", MyTime.creaData("01/02/2009"), MyTime.creaData("15/02/2009"), "Catarro", "Malato", associati, "Soffia");
		
		esamiEffettuati.add(new EsameEffettuato(esame1, malattia1, "Sarnico", MyTime.creaData(28/01/2009), "15:30"));
		
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", );
	}

}
