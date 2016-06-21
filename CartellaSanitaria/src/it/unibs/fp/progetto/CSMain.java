package it.unibs.fp.progetto;

import java.util.Date;
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
	private static final String [] OPZIONI_PAZIENTE_2 = {"Modifica nome","Modifica cognome","Modifica indirizzo","Modifica telefono","Modifica email", "Modifica luogo di nascita", "Modifica data di nascita", "Modifica genere", "Modifica codice fiscale", "Modifica gruppo sanguigno"};
	private static final String [] TIPOLOGIA_ESAME = {"Diagnostici","Periodici misurabili"};
	private static final String [] SELEZIONE_ESAME = {"Tutti","Diagnostici","Periodici misurabili"};
	
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
	
	private static final String MEX_INSERIMENTO_NOME_EASAME="Inserisci il nome dell'esame: ";
	private static final String MEX_INSERIMENTO_RACCOMANDAZIONI="Inserisci eventuali raccomandazioni: ";
	private static final String MEX_INSERIMENTO_AREA_INTERESSATA="Inserisci l'area interessata: ";
	private static final String MEX_VALORE_MIN="Inserisci il valore minimo: ";
	private static final String MEX_VALORE_MAX="Inserisci il valore massimo: ";
	private static final String MEX_SOGLIA_ERRORE="Inserisci la soglia di errore: ";
	
	
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
	/**
	 * Metodo che crea un oggetto della classe cartellaSanitaria
	 * @return oggetto della classe cartella sanitaria
	 * 
	 * @author Martinelli Giuseppe 
	 */
	private static CartellaSanitaria creaCartellaSanitaria(){
		String nome = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME);
		String cognome = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_COGNOME);
		String indirizzo = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_INDIRIZZO);
		
		//Controllo se il numero di telefono inserito dall'utente risulta valido o meno
		boolean valido = false;
		String telefono = "";
		do{
			telefono = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_TELEFONO);
			if(CartellaSanitaria.checkValiditaTelefono(telefono))
				valido = true;
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla se l'indirizzo e-mail inserito dall'utente risulta valido o meno
		valido = false;
		String mail = "";
		do{
			mail = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_MAIL);
			if(CartellaSanitaria.checkValiditaEMail(mail))
				valido = true;
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		String luogoN = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_LUOGON);
		
		//Controlla se la data di nascita inserita dall'utente risulta valida o meno
		valido = false;
		Date dataN = null;
		do{
			String data = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATAN);
			MyTime.creaData(data);
			if((dataN != null) && CartellaSanitaria.checkDataNascita(data))
				valido = true;
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla il genere inserito dall'utente
		valido = false;
		boolean genereP = false;
		do{
			char genere = MyInput.leggiChar(MEX_INSERIMENTO_GENERE);
			if(genere == 'M' || genere == 'm'){
				genereP = false;
			}
			else if(genere == 'f' || genere == 'F'){
				genereP = false;
			}
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla il codice fiscale
		valido=false;
		String codiceF="";
		do{
			codiceF = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_CODICEF);
			if(CartellaSanitaria.checkValiditaCF(codiceF))
				valido = true;
			else{
				System.out.println(MEX_ERRORE_INSERIMENTO);
				System.out.println(" ");
			}
		}while(!valido);
		
		//Controlla il gruppo sanguigno
		valido = false;
		String gruppoS = "";
		do{
			gruppoS = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_GSANGUIGNO);
			if(CartellaSanitaria.checkValiditaCF(gruppoS))
				valido = true;
			else{
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		CartellaSanitaria cs = new CartellaSanitaria(nome, cognome, indirizzo, telefono, mail, dataN, luogoN, genereP, codiceF, gruppoS);
		return cs;
	}
	
	public static void modificaDatiPaziente(CartellaSanitaria CS){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuModificaPaziente = new MyMenu("Modifica informazioni utente", OPZIONI_PAZIENTE_2);
		scelta = menuModificaPaziente.scegli();
		
		switch(scelta){
			case 1:
				CS.setNome(MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME));
				break;
			case 2:
				CS.setCognome(MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_COGNOME));
				break;
			case 3:
				CS.setIndirizzo(MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_INDIRIZZO));
				break;
			case 4:
				valido = false;
				String telefono = null;
				do{
					telefono = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_TELEFONO);
					if(CartellaSanitaria.checkValiditaTelefono(telefono)){
						valido = true;
					}
					else{
						stampaMex(MEX_ERRORE_INSERIMENTO);
					}
				}while(valido == false);
				CS.setTelefono(telefono);
				break;
			case 5:
				valido = false;
				String mail = null;
				do{
					mail = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_MAIL);
					if(CartellaSanitaria.checkValiditaEMail(mail)){
						valido = true;
					}
					else{
						stampaMex(MEX_ERRORE_INSERIMENTO);
					}
				}while(valido == false);
				CS.setEmail(mail);
				break;
			case 6:
				valido = false;
				String data = null;
				do{
					data = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_TELEFONO);
					if(CartellaSanitaria.checkDataNascita(data)){
						valido = true;
					}
					else{
						stampaMex(MEX_ERRORE_INSERIMENTO);
					}
				}while(valido == false);
				CS.setDataNascita(MyTime.creaData(data));
				break;
			case 7:
				CS.setLuogoNascita(MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_LUOGON));
				break;
			case 8:
				valido = false;
				char genereInserito;
				boolean genere = true;
				do{
					genereInserito = MyInput.leggiChar(MEX_INSERIMENTO_GENERE);
					try{
						genere = CartellaSanitaria.ritornaBoolGenere(genereInserito);
					}
					catch(IllegalArgumentException e){
						stampaMex(e.getMessage());
					}
				}while(valido == false);
				CS.setGenere(genere);
				break;
			case 9:
				valido = false;
				String codiceF = null;
				do{
					codiceF = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_CODICEF);
					if(CartellaSanitaria.checkValiditaCF(codiceF)){
						valido = true;
					}
					else{
						stampaMex(MEX_ERRORE_INSERIMENTO);
					}
				}while(valido == false);
				CS.setCodiceFiscale(codiceF);
				break;
			case 10:
				valido = false;
				String gruppoS = null;
				do{
					gruppoS = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_GSANGUIGNO);
					if(CartellaSanitaria.checkGruppoSanguigno(gruppoS)){
						valido = false;
					}
					else{
						stampaMex(MEX_ERRORE_INSERIMENTO);
					}
				}while(valido == false);
				CS.setGruppoSanguigno(gruppoS);
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}
	}
	
	/*Metodo che permette la creazione di un nuovo esame*/
	public Esame void creaEsame(){
		String nome = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME);
		String raccomandazioni = MyInput.leggiStringa(MEX_INSERIMENTO_RACCOMANDAZIONI);
		int sceltaT=0;
		do{
			MyMenu menuTipo = new MyMenu("Tipo esame",TIPOLOGIA_ESAME);
			sceltaT = menuTipo.scegli();
			switch(sceltaT){
			case 1:
				String areaInteressata=MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_AREA_INTERESSATA);
				if(raccomandazioni!=null && BelleStringhe.togliSpazi(raccomandazioni)!=""){
					
				}
				break;
			case 2:
				break;
			case 0:
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
				break;
			}
		}while(sceltaT!=0);
		
		
		
	}
	
	/*Main*/
	public static void main(String[] args) {
		stampaMex(MEX_BENVENUTO);
		CartellaSanitaria CS = null; //momentaneo per non ricevere errori dall'editor
		File file = new File(PATH);
		if (file.exists()){
			// Il file esiste, devo caricare le informazioni contenute
		}
		else{
			//a seconda se sto creando la cartella o caricandola
			
			MyServizioFile.creaFile(PATH);
			CS = creaCartellaSanitaria();
		}
		
		int scelta = 0;
		do{
			MyMenu menuGenerale = new MyMenu("Cartella Sanitaria", OPZIONI);
			scelta = menuGenerale.scegli();
			switch(scelta){
			case 1:
				int scelta2 = 0;
				MyMenu menuPaziente = new MyMenu("Gestione informazioni utente", OPZIONI_PAZIENTE);
				scelta2 = menuPaziente.scegli();
				switch(scelta2){
					case 1:
						modificaDatiPaziente(CS);
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						stampaMex(MEX_ERRORE_INSERIMENTO);
					}
				break;
			case 2:
				int scelta3 = 0;
				do{
					MyMenu menuEsame = new MyMenu("Gestione esami", OPZIONI_ESAME);
					scelta3 = menuEsame.scegli();
					switch(scelta3){
					case 1:	//Si vuole inserire un nuovo esame
						int scelta4 = 0; 
						do{
							MyMenu menuTipo = new MyMenu("Tipo esame", TIPOLOGIA_ESAME);
							scelta4 = menuTipo.scegli();
							switch(scelta4){	//Faccio scegliere se inserire un nuovo esame o un nuovo esame effettuato
							case 1:		//Esame 
								creaEsame();
								scelta4=0;	//Scelta valida, posso uscire dal ciclo
								break;
							case 2:		//EsameEffettuato
								creaEsameEffettuato();
								scelta4=0;	//Scelta valida, posso uscire dal ciclo
								break;
							default:
								stampaMex(MEX_ERRORE_INSERIMENTO);
							}
						}while(scelta4!=0);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default:
						stampaMex(MEX_ERRORE_INSERIMENTO);
					}
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
				stampaMex(MEX_ERRORE_INSERIMENTO);
			}
			stampaMex(" ");
		}while(scelta != 0);
		stampaMex(MEX_USCITA);
	}
}
