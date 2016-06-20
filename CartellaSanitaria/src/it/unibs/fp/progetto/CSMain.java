package it.unibs.fp.progetto;

import java.util.Date;
import java.util.ArrayList;

import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.MyTime;

public class CSMain{
	/* Costanti */
	private static final String MEX_BENVENUTO = "Benvenuto nell'applicazione per la gestione della cartella sanitaria di un paziente";
	private static final String MEX_USCITA = "Grazie per avere utilizzato la nostra applicazione! Arrivederci!";
	private static final String OPZIONI[]={"Gestione dati paziente","Gestione esami","Gestione malattie"};
	private static final String OPZIONI_ESAME[]={"Inserisci esame","Modifica esame","Visualizza esame","Visualizza lista esami"};
	private static final String OPZIONI_MALATTIA[]={"Inserisci malattia","Modifica malattia","Visualizza malattia","Visualizza lista malattie"};
	private static final String OPZIONI_PAZIENTE[]={"Modifica nome","Modifica cognome","Modifica indirizzo","Modifica telefono","..."};
	
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
	
	/*Main*/
	public static void main(String[] args) {
		System.out.println(MEX_BENVENUTO);
		int scelta=0;
		do{
			MyMenu menuGenerale=new MyMenu("Cartella Sanitaria",OPZIONI);
			scelta = menuGenerale.scegli();
			switch(scelta){
			case 1:
				int scelta2=0;
				do{
					MyMenu menuPaziente = new MyMenu("Gestione informazioni utente",OPZIONI_PAZIENTE);
					scelta2=menuPaziente.scegli();
				}while(scelta2!=0);
				break;
			case 2:
				int scelta3=0;
				do{
					MyMenu menuEsame=new MyMenu("Gestione esami",OPZIONI_ESAME);
					scelta3=menuEsame.scegli();
				}while(scelta3!=0);
				break;
			case 3:
				int scelta4=0;
				do{
					MyMenu menuMalattia= new MyMenu("Gestione malattia", OPZIONI_MALATTIA);
					scelta4= menuMalattia.scegli();
				}while(scelta4!=0);
				break;
			case 0:
				break;
			default:
				System.out.println("Valore inserito non valido");
			}
			System.out.println(" ");
		}while(scelta!=0);
		System.out.println(MEX_USCITA);
	}
}
