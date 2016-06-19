package it.unibs.fp.progetto;

import java.util.Date;
import java.util.ArrayList;
import it.unibs.fp.mylib.MyTime;

public class CSMain{
	/*
	 * ""Inutile""
	 * 	Creo gli oggetti richiesti dalla traccia
	 */
	public void creaRichieste(){
		//4 tipologie di esami
		//6 esami misurabili dello stesso tipo (6 effettuati)
		//3 esami diagnostici dello stesso tipo (3 effettuati)
		//3 esami prenotati (senza esito)
		
		try{
			String nome = "";
			String cognome = "";
			String indirizzo = "";
			String telefono = "000000000";
			String email = "";
			Date dataNascita = MyTime.creaData("13/05/1984");
			String luogoNascita = "";
			boolean genere = false; //uomo
			String codiceFiscale = "";
			String gruppoSanguigno = "+AB";
			CartellaSanitaria CS1 = new CartellaSanitaria(nome, cognome, indirizzo, telefono, email, dataNascita, luogoNascita, genere, codiceFiscale, gruppoSanguigno);
			
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
			
			CS1.setElencoMalattia(elencoMalattia);
			CS1.setEsamiEffettuati(esamiEffettuati);
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
	}
}
