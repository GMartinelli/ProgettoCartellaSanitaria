package it.unibs.fp.progetto;

import java.util.Date;
import java.util.ArrayList;
import java.io.*;

import it.unibs.fp.mylib.*;

public class CSMain{
	/* Costanti */
	private static final String MEX_BENVENUTO = "Benvenuto nell'applicazione per la gestione della cartella sanitaria di un paziente";
	private static final String MEX_USCITA = "Grazie per avere utilizzato la nostra applicazione! Arrivederci!";
	private static final String MEX_SCELTA = "Cosa desideri fare?";
	
	private static final String [] OPZIONI_BASE = {"Crea cartella sanitaria", "Gestisci cartella sanitaria"};
	private static final String [] OPZIONI = {"Gestione dati paziente","Gestione esami","Gestione malattie"};
	private static final String [] OPZIONI_ESAME = {"Inserisci esame","Modifica esame","Visualizza esame","Visualizza lista esami"};
	private static final String [] OPZIONI_MALATTIA = {"Inserisci malattia","Modifica malattia","Visualizza malattia","Visualizza lista malattie"};
	private static final String [] OPZIONI_PAZIENTE = {"Modifica nome","Modifica cognome","Modifica indirizzo","Modifica telefono","..."};
	
	private static final String PATH = "cartella_sanitaria.txt";
	
	private static final String MEX_INSERIMENTO_NOME = "Inserisci il nome del paziente: ";
	private static final String MEX_INSERIMENTO_COGNOME = "Inserisci il cognome del paziente: ";
	private static final String MEX_INSERIMENTO_INDIRIZZO = "Inserisci l'indirizzo del paziente: ";
	private static final String MEX_INSERIMENTO_TELEFONO = "Inserisci il numero di telefono del paziente: ";
	private static final String MEX_INSERIMENTO_MAIL = "Inserisci l'indirizzo e-mail del paziente: ";
	private static final String MEX_INSERIMENTO_DATAN = "Inserisci la data di nascita del paziente nel formato gg/mm/aaaa: ";
	private static final String MEX_INSERIMENTO_LUOGON = "Inserisci il lugo di nascita del paziente: ";
	private static final String MEX_INSERIMENTO_CODICEF = "Inserisci il codice fiscale del paziente: ";
	private static final String MEX_INSERIMENTO_GENERE = "Inserisci il genere del paziente: ";
	private static final String MEX_INSERIMENTO_GSANGUIGNO = "Inserisci il guppo sanguigno del paziente: ";
	
	private static final String MEX_ERRORE_FILE_ESISTENTE = "Attenzione, esiste gia' un file con questo nome.";
	private static final String MEX_ERRORE_INSERIMENTO = "Errore! Dato inserito non valido!";
	
		//4 tipologie di esami
		//6 esami misurabili dello stesso tipo (6 effettuati)
		//3 esami diagnostici dello stesso tipo (3 effettuati)
		//3 esami prenotati (senza esito)
	
	public static void stampaMex(String messaggio){
		System.out.println(messaggio);
	}
	
	public void salvaOggetto(Object daSalvare, String nomeFile){
		File file = new File(nomeFile);
		if(file.exists()){
			stampaMex(MEX_ERRORE_FILE_ESISTENTE + " L'oggetto non verrà salvato.");
		}
		else{
			MyServizioFile.salvaSingoloOggetto(file, daSalvare);
		}
	}
	
	/*Metodo che crea la cartella sanitaria*/
	private CartellaSanitaria creaCartellaSanitaria(){
		String nome = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME);
		String cognome = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_COGNOME);
		String indirizzo = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_INDIRIZZO);
		
		//Controllo se il numero di telefono inserito dall'utente risulta valido o meno
		boolean valido=false;
		do{
			String telefono = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_TELEFONO);
			if(CartellaSanitaria.checkValiditaTelefono(telefono))
				valido = true;
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla se l'indirizzo e-mail inserito dall'utente risulta valido o meno
		valido=false;
		do{
			String mail = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_MAIL);
			if(CartellaSanitaria.checkValiditaEMail(mail))
				valido = true;
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		String luogoN=MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_LUOGON);
		
		//Controlla se la data di nascita inserita dall'utente risulta valida o meno
		valido=false;
		do{
			String dataN = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATAN);
			MyTime.creaData(dataN);
			if(dataN != null && CartellaSanitaria.checkDataNascita(dataN))
				valido = true;
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla il genere inserito dall'utente
		valido=false;
		boolean genereP;
		do{
			char genere = MyInput.leggiChar(MEX_INSERIMENTO_GENERE);
			if(genere=='M' || genere =='m'){
				genereP = false;
			}
			else if(genere =='f' || genere=='F'){
				genereP = false;
			}
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla il codice fiscale
		CartellaSanitaria cs = new CartellaSanitaria();
		return cs;
	}
	
	public void menuPaziente(CartellaSanitaria CS){
		//conterrà il menu paziente
	}
	
	public void menuEsamiEffettuati(CartellaSanitaria CS){
		//conterrà il menu esami effettuati
	}
	
	public void menuEsame(){
		//conterrà il menu delle tipologie di esame
	}
	
	public void menuMalattia(){
		//conterra il menu delle malattie
	}
	
	/*Main*/
	public static void main(String[] args) {
		stampaMex(MEX_BENVENUTO);
		
		File file = new File(PATH);
		if (file.exists()){
			// Il file esiste, devo caricare le informazioni contenute
			
		}
		else{
			//a seconda se sto creando la cartella o caricandolaaa
			
		}
		
		int scelta = 0;
		do{
			MyMenu menuGenerale = new MyMenu("Cartella Sanitaria",OPZIONI);
			scelta = menuGenerale.scegli();
			switch(scelta){
			case 1:
				int scelta2 = 0;
				do{
					MyMenu menuPaziente = new MyMenu("Gestione informazioni utente",OPZIONI_PAZIENTE);
					scelta2 = menuPaziente.scegli();
				}while(scelta2 != 0);
				break;
			case 2:
				int scelta3 = 0;
				do{
					MyMenu menuEsame = new MyMenu("Gestione esami",OPZIONI_ESAME);
					scelta3 = menuEsame.scegli();
				}while(scelta3 != 0);
				break;
			case 3:
				int scelta4 = 0;
				do{
					MyMenu menuMalattia = new MyMenu("Gestione malattia", OPZIONI_MALATTIA);
					scelta4 = menuMalattia.scegli();
				}while(scelta4 != 0);
				break;
			case 0:
				break;
			default:
				stampaMex("Valore inserito non valido");
			}
			stampaMex(" ");
		}while(scelta != 0);
		stampaMex(MEX_USCITA);
	}
}
