package it.unibs.fp.progetto.test;

/**
 * Classe contenente Test JUnit per il controllo della correttezza della Classe CartellaSanitaria
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
			int c = 0;
			String stringaMia = "Nome: " + CS1.getNome() + "\nCognome: "+ CS1.getCognome() + "\nElenco esami: \n"; 
			for(int i=0; i<esamiEffettuati.size();i++){
						c = i + 1;
						stringaMia+= c + ". " + esamiEffettuati.get(i).toString()+"\n";
					}
			stringaMia += "Elenco malattie: \n";
			for(int i=0; i<elencoMalattia.size();i++){
				c = i + 1;
				stringaMia += c + ". " + elencoMalattia.get(i).toString()+"\n";
			}
			
			assertEquals(stringaMetodo, stringaMia);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void toStringCompletoTest(){
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
			CS1.generaCodiceSanitario();
			
			
			String stringaMetodo = CS1.toStringCompleto();
			int c = 0;
			String stringaMia = "Cartella sanitaria di " + CS1.getNome() + " "+ CS1.getCognome() + "\n" + "Residente in: " + CS1.getIndirizzo() + "\n" + 
								"Contatti: " + "\n" + "  Numero Telefonico: " + CS1.getTelefono() + "\n" +
								"  Indirizzo E-Mail: " + CS1.getEmail() + "\n" + "Nato il: " + CS1.getDataNascita().toString() + "\n" +
								"A: " + CS1.getLuogoNascita() + "\n" +
								"Genere: " + CS1.getStringaGenere() + "\n" +
								"Gruppo Sanguigno: " + CS1.getGruppoSanguigno() + "\n" +
								"Codice Fiscale: " + CS1.getCodiceFiscale() + "\n"+
								"Codice Sanitario: " + CS1.getCodiceSanitario() + "\n" +
								"Esami Effettuati: " + "\n";
								int i = 1;
								for(EsameEffettuato elemento: CS1.getEsamiEffettuati()){ 
									stringaMia += "  " + i + ". " + elemento.toString() + "\n";
									i++;
								}
								stringaMia += "Malattie: " + "\n";
								i = 1;
								for(Malattia elemento: CS1.getElencoMalattia()){ 
									stringaMia += "  " + i + ". " + elemento.toString() + "\n";
									i++;
								}
								
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
		
		assertTrue(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErratoLunghezza(){
		String CF = "RSIRM85D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato16_1(){
		String CF = "R3IROM85D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato16_2(){
		String CF = "RSIRO385D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato78_1(){
		String CF = "RSIROMA5D18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato78_2(){
		String CF = "RSIROM8SD18X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato9(){
		String CF = "RSIROM85418X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1011_1(){
		String CF = "RSIROM85DG8X999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1011_2(){
		String CF = "RSIROM85D1LX999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato12(){
		String CF = "RSIROM85D188999B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1315_1(){
		String CF = "RSIROM85D18XW99B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato1315_2(){
		String CF = "RSIROM85D18X99WB";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaCFErrato16(){
		String CF = "RSIROM85D18X9990";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", "000000000", "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaCF(CS1.getCodiceFiscale()));
	}
	
	@Test
	public void checkValiditaTelefonoCorretto(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertTrue(CartellaSanitaria.checkValiditaTelefono(CS1.getTelefono()));
	}
	
	@Test
	public void checkValiditaTelefonoErratoLunghezza(){
		String CF = "RSIROM85D18X999B";
		String telefono = "";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaTelefono(CS1.getTelefono()));
	}
	
	@Test
	public void checkValiditaTelefonoErrato(){
		String CF = "RSIROM85D18X999B";
		String telefono = "00000D000";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, "ab@cd.ef", MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaTelefono(CS1.getTelefono()));
	}
	
	@Test
	public void checkValiditaMailCorretto(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertTrue(CartellaSanitaria.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoLunghezza(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "@d.f";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoInverto(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab.cd@ef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoMancante1(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "abcd.ef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoMancante2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cdef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaMailErratoMancante3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "abcdef";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData("22/09/1985"), "Iseo", false, CF, "+A");
		
		assertFalse(CartellaSanitaria.checkValiditaEMail(CS1.getEmail()));
	}
	
	@Test
	public void checkValiditaDataNascitaCorretto(){
		String data = "22/09/1985";
		
		assertTrue(CartellaSanitaria.checkDataNascita(data));
	}
	
	@Test
	public void checkValiditaDataNascitaErrato(){
		String data = "1985/09/22";

		assertFalse(CartellaSanitaria.checkDataNascita(data));
	}
	
	@Test
	public void checkValiditaDataNascitaErrato2(){
		String data = "22/1985/09";

		assertFalse(CartellaSanitaria.checkDataNascita(data));
	}
	
	@Test
	public void checkValiditaDataNascitaErrato3(){
		String data = "22/029/1985";

		assertFalse(CartellaSanitaria.checkDataNascita(data));
	}
	
	@Test
	public void checkValiditaDataNascitaErrato4(){
		String data = "22//09/1985";

		assertFalse(CartellaSanitaria.checkDataNascita(data));
	}
	
	@Test
	public void checkValiditaDataNascitaErrato5(){
		String data = "22/09//1985";

		assertFalse(CartellaSanitaria.checkDataNascita(data));
	}
	
	@Test
	public void checkValiditaDataNascitaErrato6(){
		String data = "22/09/19Z85";

		assertFalse(CartellaSanitaria.checkDataNascita(data));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoCorrettoL2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "+A";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertTrue(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoCorrettoInversoL2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "A+";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertTrue(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoCorrettoL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "+AB";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertTrue(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoCorrettoInversoL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "AB+";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertTrue(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErratoVuoto(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErratoLungo(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "+ABCD";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato1CarattereL2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "SA";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato2CarattereL2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "-G";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErratoInverso1CarattereL2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "1-";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErratoInverso2CarattereL2(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "B3";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato1CarattereL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "gAB";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato2CarattereL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "+0B";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato3CarattereL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "+AA";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato1CarattereInversoL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "BB+";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato2CarattereInversoL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "AL+";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkValiditaGruppoSanguignoErrato3CarattereInversoL3(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "ABc";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);

		assertFalse(CartellaSanitaria.checkGruppoSanguigno(CS1.getGruppoSanguigno()));
	}
	
	@Test
	public void checkGeneraCodiceSanitario(){
		String CF = "RSIROM85D18X999B";
		String telefono = "000000000";
		String mail = "ab@cd.ef";
		String data = "22/09/19Z85";
		String gS = "+AB";
		CartellaSanitaria CS1 = new CartellaSanitaria("Mario", "Rossi", "Via Mario Rossi", telefono, mail, MyTime.creaData(data), "Iseo", false, CF, gS);
		
		String stringaMetodo = CS1.generaCodiceSanitario();
		String stringaMia = "MARROS0IS" + CS1.getDataNascita().toString().substring(0,2).toUpperCase();
		
		assertEquals(stringaMetodo, stringaMia);
	}
	
	@Test
	public void cercaEsameTestCorretto(){
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
			
			assertEquals(CS1.cercaEsame("Colesterolo"), esamiEffettuati.get(0));
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void cercaEsameTestErrato(){
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
			
			assertEquals(CS1.cercaEsame("Radiografia"), null);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void cercaMalattiaTestCorretto(){
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
			
			assertEquals(CS1.cercaMalattia("Raffreddore"), malattia1);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void cercaMalattiaTestErrato(){
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
			
			assertEquals(CS1.cercaMalattia("Mononucleosi"), null);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void ritornaBoolGenereTestCorrettoM(){
		char genere = 'M';
		
		boolean risultatoAtteso = false;
		boolean risultato = CartellaSanitaria.ritornaBoolGenere(genere);
		
		assertEquals(risultatoAtteso, risultato);
	}
	
	@Test
	public void ritornaBoolGenereTestCorretto2m(){
		char genere = 'm';
		
		boolean risultatoAtteso = false;
		boolean risultato = CartellaSanitaria.ritornaBoolGenere(genere);
		
		assertEquals(risultatoAtteso, risultato);
	}
	
	@Test
	public void ritornaBoolGenereTestCorrettoF(){
		char genere = 'F';
		
		boolean risultatoAtteso = true;
		boolean risultato = CartellaSanitaria.ritornaBoolGenere(genere);
		
		assertEquals(risultatoAtteso, risultato);
	}
	
	@Test
	public void ritornaBoolGenereTestCorretto2f(){
		char genere = 'f';
		
		boolean risultatoAtteso = true;
		boolean risultato = CartellaSanitaria.ritornaBoolGenere(genere);
		
		assertEquals(risultatoAtteso, risultato);
	}
	
	@Test
	public void ritornaBoolGenereTestErratoEccezione(){
		char genere = 's';
		boolean thrown = false;
		
		try{
			CartellaSanitaria.ritornaBoolGenere(genere);
		}
		catch(IllegalArgumentException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
}
