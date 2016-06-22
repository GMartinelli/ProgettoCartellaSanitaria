package it.unibs.fp.progetto;

import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class CSMain{
	/* Costanti */
	private static final String MEX_BENVENUTO = "Benvenuto nell'applicazione per la gestione della cartella sanitaria di un paziente";
	private static final String MEX_USCITA = "Grazie per avere utilizzato la nostra applicazione! Arrivederci!";

	//Menu'
	private static final String[] OPZIONI_BASE = {"Crea cartella sanitaria", "Gestisci cartella sanitaria"};
	private static final String[] OPZIONI = {"Gestione dati paziente","Gestione esami","Gestione malattie"};
	private static final String[] OPZIONI_PAZIENTE = {"Modifica dati paziente","Visualizzazione completa dati paziente","Visualizzazione sintetica dati paziente"};
	private static final String[] OPZIONI_ESAME = {"Inserisci esame","Modifica esame","Visualizza esame","Visualizza lista esami"};
	private static final String[] OPZIONI_MODIFICA_ESAME = {"Modifica nome", "Modifica raccomandazioni"};
	private static final String[] OPZIONI_MODIFICA_ESAME_DIAGNOSTICO = {"Modifica nome", "Modifica raccomandazioni", "Modifica area interessata"};
	private static final String[] OPZIONI_MODIFICA_ESAME_PM = {"Modifica nome", "Modifica raccomandazioni", "Modifica valore minimo", "Modifica valore massimo","Modifica soglia errore"};
	private static final String[] OPZIONI_MODIFICA_E_EFFETTUATO = {"Modifica data", "Modifica esame", "Modifica luogo", "Modifica malattia", "Modifica ora", "Modifica esito", "Modifica avvisi (se l'esame e' di tipologia misurabile"};
	private static final String[] OPZIONI_MALATTIA = {"Inserisci malattia","Modifica malattia","Visualizza malattia","Visualizza lista malattie"};
	private static final String[] OPZIONI_MODIFICA_MALATTIA = {"Modifica nome", "Modifica data di inizio", "Modifica data di termine", "Modifica sintomi", "Modifica diagnosi", "Modifica terapia"};
	private static final String[] OPZIONI_MODIFICA_PAZIENTE = {"Modifica nome","Modifica cognome","Modifica indirizzo","Modifica telefono","Modifica email", "Modifica luogo di nascita", "Modifica data di nascita", "Modifica genere", "Modifica codice fiscale", "Modifica gruppo sanguigno", "Aggiungi esame effettuato", "Aggiungi malattia", "Rimuovi esame effettuato", "Rimuovi malattia"};
	private static final String[] TIPOLOGIA_ESAME = {"Diagnostici","Periodici misurabili"};
	private static final String[] SELEZIONE_ESAME = {"Tutti","Diagnostici","Periodici misurabili"};
	
	private static final String PATH = "cartella_sanitaria.txt";
	
	//Intestazioni menu'
	private static final String MODIFICA_INFO_UTENTE = "Modifica informazioni utente";
	private static final String MODIFICA_INFO_MALATTIA = "Modifica informazioni malattia";
	private static final String MODIFICA_INFO_E_EFFETTUATO = "Modifica informazioni esame effettuato";
	private static final String MODIFICA_INFO_ESAME = "Modifica informazioni esame effettuato";
	
	//Paziente
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
	
	//Esame
	private static final String MEX_INSERIMENTO_NOME_ESAME = "Inserisci il nome dell'esame: ";
	private static final String MEX_INSERIMENTO_RACCOMANDAZIONI = "Inserisci eventuali raccomandazioni: ";
	private static final String MEX_INSERIMENTO_AREA_INTERESSATA = "Inserisci l'area interessata: ";
	private static final String MEX_INSERIMENTO_DATA = "Inserisci la data: ";
	private static final String MEX_INSERIMENTO_LUOGO = "Inserisci il nome del luogo: ";
	private static final String MEX_INSERIMENTO_MALATTIA = "Inserisci il nome della malattia: ";
	private static final String MEX_INSERIMENTO_ORA = "Inserisci l'ora: ";
	private static final String MEX_ESITO_PERIODICO = "Inserisci l'esito dell'esame (>= 0): ";
	private static final String MEX_ESITO_DIAGNOSTICO = "Inserisci l'esito dell'esame: ";
	private static final String MEX_VALORE_MIN = "Inserisci il valore minimo: ";
	private static final String MEX_VALORE_MAX = "Inserisci il valore massimo: ";
	private static final String MEX_SOGLIA_ERRORE = "Inserisci la soglia di errore: ";
	private static final String MEX_INSERIMENTO_ESITO = "Inserisci un esito: ";
	private static final String MEX_INSERIMENTO_ERELATIVO = "Inserisci il nome dell'esame a cui e' associato: ";
	private static final String MEX_INSERIMENTO_MRELATIVO = "Inserisci il nome della malttia a cui e' associato: ";
	
	//Scelta aggiungi rimuovi
	private static final String MEX_CREA_CERCA_TIPOLOGIA_ESAME = "Si desidera creare la tipologia di esame o cercarne una nuova?";
	private static final String[] MEX_SCEGLI_CREA_CERCA_TIPOLOGIA = {"Crea una nuova tipologia di esame", "Cerca una tipologia di esame"};
	
	private static final String MEX_TIPO_ESAME = "Si desidera inserire un nuovo Esame Effettuato Diagnostico o Periodico Misurabile?";
	private static final String[] MEX_SCEGLI_TIPO_ESAME = {"Diagnostico", "Periodico Misurabile"};
	
	private static final String MEX_CERCA_ESAME = "Inserire il nome dell'esame che si desidera cercare: ";
	
	private static final String MEX_AGGIUNGI_MALATTIA = "";
	private static final String MEX_RIMUOVI_ESAME = "";
	private static final String MEX_RIMUOVI_MALATTIA = "";
	
	//Malattia
	private static final String MEX_INSERIMENTO_NOME_MALATTIA = "Inserisci il nome della malattia: ";
	private static final String MEX_INSERIMENTO_DATAI = "Inserisci la data di inizio della malattia: ";
	private static final String MEX_INSERIMENTO_DATAT = "Inserisci la data di termine della malattia: ";
	private static final String MEX_INSERIMENTO_SINTOMI = "Inserisci i sintomi della malattia: ";
	private static final String MEX_INSERIMENTO_DIAGNOSI = "Inserisci la diagnosi effettuata dal medico: ";
	private static final String MEX_INSERIMENTO_TERAPIA = "Inserisci la terapia consigliata: ";
	
	//Avvisi
	private static final String NON_MODIFICA = "Attenzione, non verrà scelto di inserire alcun dato.";
	private static final String AVVISI_IMPOSTATI_CORRETTAMENTE = "Gli avvisi sono stati impostati correttamente. Operazione finita.";
	
	//Errori
	private static final String MEX_ERRORE_FILE_ESISTENTE = "Attenzione, esiste gia' un file con questo nome.";
	private static final String MEX_ERRORE_INSERIMENTO = "Errore! Dato inserito non valido!";
	private static final String TIPOLOGIA_INESISTENTE = "Attenzione! La tipologia di esame specificata non esiste!";
	private static final String MALATTIA_INESISTENTE = "Attenzione! La malattia specificata non esiste!";
	private static final String ERRORE_TIPOLOGIA = "Attenzione, operazione non disponibile per la tipologia di esame scelta.";
	private static final String ERRORE_ESAME_NON_TROVATO="Attenzione! Non e' presente alcun esame con quel nome!";
	private static final String ERRORE_MALATTIA_NON_TROVATA="Attenzione! Non e' presente alcuna malattia con quel nome!";
	
	/*
	 * 4 tipologie di esami
	 * 6 esami misurabili dello stesso tipo (6 effettuati)
	 * 3 esami diagnostici dello stesso tipo (3 effettuati)
	 * 3 esami prenotati (senza esito)
	*/
	public static void stampaMex(String messaggio){
		System.out.println(messaggio);
	}
	
	public void salvaOggetto(Object daSalvare, String nomeFile){
		File file = new File(nomeFile);
		if(file.exists()){
			stampaMex(MEX_ERRORE_FILE_ESISTENTE + " L'oggetto non verra'� salvato.");
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
				stampaMex(MEX_ERRORE_INSERIMENTO);
				stampaMex(" ");
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

	/**
	 * Metodo che crea un oggetto della classe esame in base alla tipologia scelta nel menu presente nel metodo
	 * @return esame creato dall'utente
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static Esame creaEsame(){
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
					EsameDiagnostico e1 = new EsameDiagnostico(nome, areaInteressata);
					return e1;
				}
				else{
					EsameDiagnostico e1 = new EsameDiagnostico(nome, raccomandazioni, areaInteressata);
					return e1;	
				}
			case 2:
				int valoreMin= MyInput.leggiInteroConMinimo(MEX_VALORE_MIN, 0);
				int valoreMax = MyInput.leggiInteroConMinimo(MEX_VALORE_MAX, valoreMin+1);
				int sogliaErrore = MyInput.leggiInteroConMinimo(MEX_SOGLIA_ERRORE, 0);
				if(raccomandazioni!=null && BelleStringhe.togliSpazi(raccomandazioni)!=""){
					EsamePeriodicoMisurabile e1 = new EsamePeriodicoMisurabile(nome, valoreMin, valoreMax, sogliaErrore);
					return e1;
				}
				else{
					EsamePeriodicoMisurabile e1 = new EsamePeriodicoMisurabile(nome, raccomandazioni, valoreMin, valoreMax, sogliaErrore);
					return e1;	
				}
			case 0:
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
				break;
			}
		}while(sceltaT!=0);
		
		Esame esame = null;
		return esame;
	}
	
	public static Esame creaEsame(int scelta){
		String nome = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME);
		String raccomandazioni = MyInput.leggiStringa(MEX_INSERIMENTO_RACCOMANDAZIONI);
		int sceltaT=scelta;
		do{
			MyMenu menuTipo = new MyMenu("Tipo esame",TIPOLOGIA_ESAME);
			sceltaT = menuTipo.scegli();
			switch(sceltaT){
			case 1:
				String areaInteressata=MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_AREA_INTERESSATA);
				if(raccomandazioni!=null && BelleStringhe.togliSpazi(raccomandazioni)!=""){
					EsameDiagnostico e1 = new EsameDiagnostico(nome, areaInteressata);
					return e1;
				}
				else{
					EsameDiagnostico e1 = new EsameDiagnostico(nome, raccomandazioni, areaInteressata);
					return e1;	
				}
			case 2:
				int valoreMin= MyInput.leggiInteroConMinimo(MEX_VALORE_MIN, 0);
				int valoreMax = MyInput.leggiInteroConMinimo(MEX_VALORE_MAX, valoreMin+1);
				int sogliaErrore = MyInput.leggiInteroConMinimo(MEX_SOGLIA_ERRORE, 0);
				if(raccomandazioni!=null && BelleStringhe.togliSpazi(raccomandazioni)!=""){
					EsamePeriodicoMisurabile e1 = new EsamePeriodicoMisurabile(nome, valoreMin, valoreMax, sogliaErrore);
					return e1;
				}
				else{
					EsamePeriodicoMisurabile e1 = new EsamePeriodicoMisurabile(nome, raccomandazioni, valoreMin, valoreMax, sogliaErrore);
					return e1;	
				}
			case 0:
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
				break;
			}
		}while(sceltaT!=0);
		
		Esame esame = null;
		return esame;
	}
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la creazione di un esame effettuato
	 * @param listaE la lista delle tipologie di esame create
	 * @param listaM la lista delle malattie create
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static EsameEffettuato creaEsameEffettuato(EsameDiagnostico E, ListaMalattia listaM){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuEffettuato = new MyMenu("Tipologia di esame", TIPOLOGIA_ESAME);
		scelta = menuEffettuato.scegli();
		
		switch(scelta){
			case 1:	//Diagnostico
				EsameDiagnostico eAss=E;
				valido = false;
				Malattia mAss=null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_MRELATIVO);
					if(listaM.isEsistente(nomeMalattiaAss)){
						mAss = listaM.cercaMalattia(nomeMalattiaAss);
						valido= true;
					}
					else{
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				String luogo = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_LUOGO);
				String data = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATA);
				String ora = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_ORA);
				String esito = MyInput.leggiStringa(MEX_INSERIMENTO_ESITO);
				
				EDiagnosticoEffettuato ed1;
				if(esito != null || BelleStringhe.togliSpazi(esito)!="")
					ed1 = new EDiagnosticoEffettuato(eAss,mAss,luogo,MyTime.creaData(data),ora,esito);
				else
					ed1 = new EDiagnosticoEffettuato(eAss,mAss,luogo,MyTime.creaData(data),ora,esito);
				return ed1;
			case 2:	//Periodico Misurabile
				valido = false;
				EsamePeriodico eAssp = E;
				valido = false;
				Malattia mAssp=null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_MRELATIVO);
					if(listaM.isEsistente(nomeMalattiaAss)){
						mAssp = listaM.cercaMalattia(nomeMalattiaAss);
						valido= true;
					}
					else{
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				String luogop = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_LUOGO);
				String datap = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATA);
				String orap = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_ORA);
				double esitop = MyInput.leggiDouble(MEX_INSERIMENTO_ESITO);

				EPeriodicoMisurabileEffettuato ep1 = new EPeriodicoMisurabileEffettuato(eAssp,mAssp,luogo,MyTime.creaData(data),ora,esitop);
				return ep1;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}
		return null;
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati utente della cartella sanitaria
	 * @param CS la cartella sanitaria da modificare
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaDatiPaziente(CartellaSanitaria CS, ListaEsame listaE){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuModificaPaziente = new MyMenu(MODIFICA_INFO_UTENTE, OPZIONI_MODIFICA_PAZIENTE);
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
					data = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATAN);
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
				case 11:
					int sceltaAggiungereEffettuato = 0;
					MyMenu menuAggiungereEffettuato = new MyMenu(MEX_TIPO_ESAME, MEX_SCEGLI_TIPO_ESAME);
					sceltaAggiungereEffettuato = menuAggiungereEffettuato.scegli();
					switch(sceltaAggiungereEffettuato){
						case 1:
							aggiungiEffettuatoDiagnostico(CS, listaE);
							break;
						case 2:
							aggiungiEffettuatoPeriodicoMisurabile(CS, listaE);
							break;
						default:
							stampaMex(MEX_ERRORE_INSERIMENTO);
					}
					break;
				case 12:
					//aggiungi malattia
					break;
				case 13:
					//rimuovi effettuato
					break;
				case 14:
					//rimuovi malattia
					break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}
	}
	
	public static void aggiungiEffettuatoDiagnostico(CartellaSanitaria CS, ListaEsame listaE){
		int scelta = 0;
		MyMenu menuCreaCerca = new MyMenu(MEX_CREA_CERCA_TIPOLOGIA_ESAME, MEX_SCEGLI_CREA_CERCA_TIPOLOGIA);
		scelta = menuCreaCerca.scegli();
		
		switch(scelta){
			case 1:
				listaE.aggiungiEsame(creaEsame(1));
				break;
			case 2:
				String nomeCerca = MyInput.leggiStringaNonVuota(MEX_CERCA_ESAME);
				if(listaE.isEsistente(nomeCerca)){
					if(listaE.cercaEsame(nomeCerca) instanceof EsameDiagnostico){
					
					}
				}
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}
	}
	
	public static void aggiungiEffettuatoPeriodicoMisurabile(CartellaSanitaria CS, ListaEsame listaE){
		int scelta = 0;
		MyMenu menuCreaCerca = new MyMenu(MEX_CREA_CERCA_TIPOLOGIA_ESAME, MEX_SCEGLI_CREA_CERCA_TIPOLOGIA);
		scelta = menuCreaCerca.scegli();
		
		switch(scelta){
			case 1:
				listaE.aggiungiEsame(creaEsame(2));
				break;
			case 2:
				
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}

	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati di un esame
	 * @param EsameEffettuato l'esame da modificare
	 * @param listaE la lista delle tipologie di esame create
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static void modificaDatiEsame(Esame esame, ListaEsame listaE){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuModificaEffettuato = new MyMenu(MODIFICA_INFO_ESAME, OPZIONI_MODIFICA_ESAME);
		scelta = menuModificaEffettuato.scegli();
		
		switch(scelta){
			case 1:
				String nomeMod = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME_ESAME);
				esame.setNome(nomeMod);
				break;
			case 2:
				String raccomandazioniMod = MyInput.leggiStringa(MEX_INSERIMENTO_RACCOMANDAZIONI);
				esame.setNome(raccomandazioniMod);
				break;
			case 0:
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati di un esame effettuato
	 * @param EsameEffettuato l'esame da modificare
	 * @param listaE la lista delle tipologie di esame create
	 * @param listaM la lista delle malattie create
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaDatiEsameEffettuato(EsameEffettuato esame, ListaEsame listaE, ListaMalattia listaM){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuModificaEffettuato = new MyMenu(MODIFICA_INFO_E_EFFETTUATO, OPZIONI_MODIFICA_E_EFFETTUATO);
		scelta = menuModificaEffettuato.scegli();
		
		switch(scelta){
			case 1:
				try{
					String data = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATA);
					esame.setData(MyTime.creaData(data));
				}
				catch(TooLateException e){
					stampaMex(e.getMessage());
				}
				break;
			case 2:
				valido = false;
				do{
					try{
						String nomeEsame = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME);
						if(listaE.isEsistente(nomeEsame)){
							esame.setEsame(listaE.cercaEsame(nomeEsame));
							valido = true;
						}
						else{
							stampaMex(TIPOLOGIA_INESISTENTE);
						}
					}
					catch(TooLateException e){
						stampaMex(e.getMessage());
						valido = true;
					}
					catch(IllegalArgumentException e){ //se l'esame non è coerente con la malattia
						stampaMex(e.getMessage());
					}
				}while(valido = false);
				break;
			case 3:
				try{
					String luogo = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_LUOGO);
					esame.setLuogo(luogo);
				}
				catch(TooLateException e){
					stampaMex(e.getMessage());
				}
				break;
			case 4:
				valido = false;
				do{
					String nomeMalattia = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_MALATTIA);
					if(listaM.isEsistente(nomeMalattia)){
						esame.setMalattia(listaM.cercaMalattia(nomeMalattia));
						valido = true;
					}
					else{
						stampaMex(MALATTIA_INESISTENTE);
					}
				}while(valido == false);
				break;
			case 5:
				try{
					String ora = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_ORA);
					esame.setOra(ora);
				}
				catch(TooLateException e){
					stampaMex(e.getMessage());
				}
				break;
			case 6:
				if(esame instanceof EPeriodicoMisurabileEffettuato){
					double esito = MyInput.leggiInteroNonNegativo(MEX_ESITO_PERIODICO);
					((EPeriodicoMisurabileEffettuato) esame).setEsito(esito);
				}
				else if(esame instanceof EDiagnosticoEffettuato){
					String esito = MyInput.leggiStringaNonVuota(MEX_ESITO_DIAGNOSTICO);
					((EDiagnosticoEffettuato) esame).setEsito(esito);
				}
				break;
			case 7:
				if(esame instanceof EDiagnosticoEffettuato){
					stampaMex(ERRORE_TIPOLOGIA);
				}
				else if(esame instanceof EPeriodicoMisurabileEffettuato){
					try{
						stampaMex(NON_MODIFICA);
						((EPeriodicoMisurabileEffettuato) esame).setAvvisi();
						stampaMex(AVVISI_IMPOSTATI_CORRETTAMENTE);
					}
					catch(IllegalAccessException e){
						stampaMex(e.getMessage());
					}
				}
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati di una malattia
	 * @param malattia la malattia da modificare
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaDatiMalattia(Malattia malattia){
		int scelta = 0;
		//boolean valido = false;
		MyMenu menuModificaMalattia = new MyMenu(MODIFICA_INFO_MALATTIA, OPZIONI_MODIFICA_MALATTIA);
		scelta = menuModificaMalattia.scegli();
		
		switch(scelta){
			case 1:
				String nome = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_NOME_MALATTIA);
				malattia.setNome(nome);
				break;
			case 2:
				String datai = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATAI);
				malattia.setDataInizio(MyTime.creaData(datai));
				break;
			case 3:
				String datat = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DATAT);
				malattia.setDataInizio(MyTime.creaData(datat));
				break;
			case 4:
				String sintomi = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_SINTOMI);
				malattia.setSintomi(sintomi);
				break;
			case 5:
				String diagnosi = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_DIAGNOSI);
				malattia.setDiagnosi(diagnosi);
				break;
			case 6:
				String terapia = MyInput.leggiStringaNonVuota(MEX_INSERIMENTO_TERAPIA);
				malattia.setTerapia(terapia);
				break;
			default:
				stampaMex(MEX_ERRORE_INSERIMENTO);
		}
	}
	
	/*Main*/
	public static void main(String[] args) {
		stampaMex(MEX_BENVENUTO);
		CartellaSanitaria CS = null; //momentaneo per non ricevere errori dall'editor

		ArrayList<Esame> lista = new ArrayList<Esame>();
		ListaEsame listaE = new ListaEsame(lista);

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
						modificaDatiPaziente(CS, listaE);
						break;
					case 2:
						stampaMex(CS.toString());
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
								Esame esame = creaEsame();
								lista.add(esame);
								listaE= new ListaEsame (lista);
								scelta4=0;	//Scelta valida, posso uscire dal ciclo
								break;
							case 2:		//EsameEffettuato
								//creaEsameEffettuato();
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
