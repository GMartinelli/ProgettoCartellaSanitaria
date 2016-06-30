package it.unibs.fp.progetto;

import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class CSMain{
	// Costanti
	private static final String MEX_BENVENUTO = "Benvenuto nell'applicazione per la gestione della cartella sanitaria di un paziente";
	private static final String MEX_USCITA = "Grazie per avere utilizzato la nostra applicazione! Arrivederci!";

	//Intestazioni menu'
	private static final String MODIFICA_INFO_P = "Modifica informazioni utente";
	private static final String MODIFICA_INFO_M = "Modifica informazioni malattia";
	private static final String MODIFICA_INFO_E_EFFETTUATO = "Modifica informazioni esame effettuato";
	private static final String MODIFICA_INFO_E = "Modifica informazioni esame effettuato";
	
	// Opzioni menu'
	private static final String[] G_OPZIONI = {"Gestione dati paziente","Gestione esami","Gestione malattie"}; // G = GESTIONE
	
	private static final String[] P_OPZIONI = {"Modifica dati paziente","Visualizzazione sintetica dati paziente","Visualizzazione completa dati paziente"};
	private static final String[] P_OPZIONI_MODIFICA = {"Modifica nome","Modifica cognome","Modifica indirizzo","Modifica telefono","Modifica email", "Modifica luogo di nascita", "Modifica data di nascita", "Modifica genere", "Modifica codice fiscale", "Modifica gruppo sanguigno", "Aggiungi esame effettuato", "Aggiungi malattia", "Rimuovi esame effettuato", "Rimuovi malattia"};
	
	private static final String[] E_OPZIONI = {"Inserisci esame","Modifica esame","Visualizza esame","Visualizza lista esami"};
	private static final String[] E_OPZIONI_MODIFICA = {"Modifica nome", "Modifica raccomandazioni"};
	private static final String[] E_OPZIONI_MODIFICA_DIAGNOSTICO = {"Modifica nome", "Modifica raccomandazioni", "Modifica area interessata"};
	private static final String[] E_OPZIONI_MODIFICA_PERIODICO = {"Modifica nome", "Modifica raccomandazioni", "Modifica valore minimo", "Modifica valore massimo","Modifica soglia errore"};
	private static final String[] E_OPZIONI_MODIFICA_EFFETTUATO = {"Modifica data", "Modifica esame", "Modifica luogo", "Modifica malattia", "Modifica ora", "Modifica esito", "Modifica avvisi (se l'esame e' di tipologia misurabile"};
	private static final String[] E_OPZIONI_SCEGLI_TIPO = {"Diagnostico", "Periodico Misurabile"};
	private static final String[] E_OPZIONI_SELEZIONE = {"Tutti","Diagnostici","Periodici misurabili"};
	private static final String[] E_OPZIONI_CREA_CERCA = {"Crea un nuovo esame", "Cerca un esame esistente"};
	
	private static final String[] M_OPZIONI = {"Inserisci malattia","Modifica malattia","Visualizza malattia","Visualizza lista malattie"};
	private static final String[] M_OPZIONI_MODIFICA = {"Modifica nome", "Modifica data di inizio", "Modifica data di termine", "Modifica sintomi", "Modifica diagnosi", "Modifica terapia"};
	
	// Gestione File
	private static final String PATH = "cartella_sanitaria.txt";
	
	// Inserimento Paziente
	private static final String P_MEX_INS_NOME = "Inserisci il nome del paziente: ";
	private static final String P_MEX_INS_COGNOME = "Inserisci il cognome del paziente: ";
	private static final String P_MEX_INS_INDIRIZZO = "Inserisci l'indirizzo del paziente: ";
	private static final String P_MEX_INS_TELEFONO = "Inserisci il numero di telefono del paziente: ";
	private static final String P_MEX_INS_MAIL = "Inserisci l'indirizzo e-mail del paziente: ";
	private static final String P_MEX_INS_DATAN = "Inserisci la data di nascita del paziente nel formato gg/mm/aaaa: ";
	private static final String P_MEX_INS_LUOGON = "Inserisci il lugo di nascita del paziente: ";
	private static final String P_MEX_INS_CODICEF = "Inserisci il codice fiscale del paziente: ";
	private static final String P_MEX_INS_GENERE = "Inserisci il genere del paziente: ";
	private static final String P_MEX_INS_GSANGUIGNO = "Inserisci il guppo sanguigno del paziente: ";
	
	// Inserimento Esame
	private static final String E_MEX_INS_NOME = "Inserisci il nome dell'esame: ";
	private static final String E_MEX_INS_RACCOMANDAZIONI = "Inserisci eventuali raccomandazioni: ";
	private static final String E_MEX_INS_AREAI = "Inserisci l'area interessata: ";
	private static final String E_MEX_INS_DATA = "Inserisci la data: ";
	private static final String E_MEX_INS_LUOGO = "Inserisci il nome del luogo: ";
	private static final String E_MEX_INS_MALATTIAN = "Inserisci il nome della malattia: ";
	private static final String E_MEX_INS_ORA = "Inserisci l'ora: ";
	private static final String E_MEX_INS_ESITO_PERIODICO = "Inserisci l'esito dell'esame (>= 0): ";
	private static final String E_MEX_INS_ESITO_DIAGNOSTICO = "Inserisci l'esito dell'esame: ";
	private static final String E_MEX_INS_VALORE_MIN = "Inserisci il valore minimo: ";
	private static final String E_MEX_INS_VALORE_MAX = "Inserisci il valore massimo: ";
	private static final String E_MEX_INS_SOGLIA = "Inserisci la soglia di errore: ";
	private static final String E_MEX_INS_ESITO = "Inserisci un esito: ";
	private static final String E_MEX_INS_ERELATIVO = "Inserisci il nome dell'esame a cui e' associato: ";
	private static final String E_MEX_INS_MRELATIVO = "Inserisci il nome della malttia a cui e' associato: ";
	private static final String E_MEX_CANCELLA_NOME = "Inserisci il nome dell'esame da cancellare: ";
	private static final String E_MEX_PIU_ESAMI = "Attenzione, sono presenti piu' esami di questo tipo: ";
	private static final String E_MEX_CANCELLA_DATA = "Inserire la data dell'esame da cancellare: ";
	private static final String E_MEX_CERCA = "Inserire il nome dell'esame che si desidera cercare: ";
	
	private static final String E_SCELTA_CREA_CERCA = "Si desidera creare un esame o cercarne uno già esistente?";
	private static final String E_SCELTA_TIPO = "Si desidera inserire un nuovo Esame Effettuato Diagnostico o Periodico Misurabile?";
	
	// Inserimento Malattia
	private static final String M_MEX_INS_NOME = "Inserisci il nome della malattia: ";
	private static final String M_MEX_INS_DATAI = "Inserisci la data di inizio della malattia: ";
	private static final String M_MEX_INS_DATAT = "Inserisci la data di termine della malattia: ";
	private static final String M_MEX_INS_SINTOMI = "Inserisci i sintomi della malattia: ";
	private static final String M_MEX_INS_DIAGNOSI = "Inserisci la diagnosi effettuata dal medico: ";
	private static final String M_MEX_INS_TERAPIA = "Inserisci la terapia consigliata: ";
	private static final String M_MEX_CANCELLA = "Inserisci il nome della malattia che desideri eliminare: ";
	private static final String M_MEX_PIU_MALATTIE = "Attenzione, sono presenti piu' malattie con questo nome: ";
	private static final String M_MEX_CANCELLA_DATAI = "Inserire la data di inizio della malattia da cancellare: ";
	
	private static final String M_SCELTA_INS_DATAT = "Si desidera inserire una data di termine?";
	private static final String M_SCELTA_INS_ASSOCIATO = "Si desidera inserire un esame associato?";
	private static final String M_SCELTA_INS_ALTRO_ASSOCIATO = "Si desidera inserire un altro esame associato?";
	
	// Avvisi
	private static final String NON_MODIFICA = "Attenzione, non verrà chiesto di inserire alcun dato.";
	private static final String AVVISI_IMPOSTATI_CORRETTAMENTE = "Gli avvisi sono stati impostati correttamente. Operazione finita.";
	
	// Errori
	private static final String ERRORE_FILE_ESISTENTE = "Attenzione, esiste gia' un file con questo nome.";
	private static final String ERRORE_INSERIMENTO = "Errore! Dato inserito non valido!";
	private static final String ERRORE_TIPOLOGIA_INESISTENTE = "Attenzione! La tipologia di esame specificata non esiste!";
	private static final String ERRORE_MALATTIA_INESISTENTE = "Attenzione! La malattia specificata non esiste!";
	private static final String ERRORE_OPERAZIONE_ND_TIPO = "Attenzione, operazione non disponibile per il tipo di esame scelto."; //ND = NON DISPONIBILE
	private static final String ERRORE_ESAME_NON_TROVATO = "Attenzione! Non e' presente alcun esame con quel nome!";
	private static final String ERRORE_MALATTIA_NON_TROVATA = "Attenzione! Non e' presente alcuna malattia con quel nome!";
	
	/**
	 * Stampa un messaggio nella console attraverso System.out.println
	 * Usato per poter modificare velocemente la visualizzazione di un messaggio se per esempio nel progetto venisse implementata
	 * un interfaccia grafica
	 * 
	 * @param <strong>messaggio</strong> il messaggio da stampare
	 * 
	 * @author Valtulini Claudio
	 */
	public static void stampaMex(String messaggio){
		System.out.println(messaggio);
	}
	
	public void salvaOggetto(Object daSalvare, String nomeFile){
		File file = new File(nomeFile);
		if(file.exists()){
			stampaMex(ERRORE_FILE_ESISTENTE + " L'oggetto non verra'� salvato.");
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
		String nome = MyInput.leggiStringaNonVuota(P_MEX_INS_NOME);
		String cognome = MyInput.leggiStringaNonVuota(P_MEX_INS_COGNOME);
		String indirizzo = MyInput.leggiStringaNonVuota(P_MEX_INS_INDIRIZZO);
		
		//Controllo se il numero di telefono inserito dall'utente risulta valido o meno
		boolean valido = false;
		String telefono = "";
		do{
			telefono = MyInput.leggiStringaNonVuota(P_MEX_INS_TELEFONO);
			if(CartellaSanitaria.checkValiditaTelefono(telefono))
				valido = true;
			else{
				stampaMex(ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla se l'indirizzo e-mail inserito dall'utente risulta valido o meno
		valido = false;
		String mail = "";
		do{
			mail = MyInput.leggiStringaNonVuota(P_MEX_INS_MAIL);
			if(CartellaSanitaria.checkValiditaEMail(mail))
				valido = true;
			else{
				stampaMex(ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		String luogoN = MyInput.leggiStringaNonVuota(P_MEX_INS_LUOGON);
		
		//Controlla se la data di nascita inserita dall'utente risulta valida o meno
		valido = false;
		Date dataN = null;
		do{
			String data = MyInput.leggiStringaNonVuota(P_MEX_INS_DATAN);
			MyTime.creaData(data);
			if((dataN != null) && CartellaSanitaria.checkDataNascita(data))
				valido = true;
			else{
				stampaMex(ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla il genere inserito dall'utente
		valido = false;
		boolean genereP = false;
		do{
			try{
				genereP = CartellaSanitaria.ritornaBoolGenere(MyInput.leggiChar(P_MEX_INS_GENERE));
				valido = true;
			}
			catch(IllegalArgumentException e){
				stampaMex(e.getMessage());
			}
		}while(!valido);
		
		//Controlla il codice fiscale
		valido = false;
		String codiceF = "";
		do{
			codiceF = MyInput.leggiStringaNonVuota(P_MEX_INS_CODICEF);
			if(CartellaSanitaria.checkValiditaCF(codiceF))
				valido = true;
			else{
				stampaMex(ERRORE_INSERIMENTO);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla il gruppo sanguigno
		valido = false;
		String gruppoS = "";
		do{
			gruppoS = MyInput.leggiStringaNonVuota(P_MEX_INS_GSANGUIGNO);
			if(CartellaSanitaria.checkValiditaCF(gruppoS))
				valido = true;
			else{
				stampaMex(ERRORE_INSERIMENTO);
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
		String nome = MyInput.leggiStringaNonVuota(P_MEX_INS_NOME);
		String raccomandazioni = MyInput.leggiStringa(E_MEX_INS_RACCOMANDAZIONI);
		int sceltaT = 0;
		do{
			MyMenu menuTipo = new MyMenu("Tipo esame", E_OPZIONI_SCEGLI_TIPO);
			sceltaT = menuTipo.scegli();
			switch(sceltaT){
			case 1:
				String areaInteressata = MyInput.leggiStringaNonVuota(E_MEX_INS_AREAI);
				if(raccomandazioni != null && BelleStringhe.togliSpazi(raccomandazioni) != ""){
					EsameDiagnostico e1 = new EsameDiagnostico(nome, areaInteressata);
					return e1;
				}
				else{
					EsameDiagnostico e1 = new EsameDiagnostico(nome, raccomandazioni, areaInteressata);
					return e1;	
				}
			case 2:
				int valoreMin = MyInput.leggiInteroConMinimo(E_MEX_INS_VALORE_MIN, 0);
				int valoreMax = MyInput.leggiInteroConMinimo(E_MEX_INS_VALORE_MAX, valoreMin+1);
				int sogliaErrore = MyInput.leggiInteroConMinimo(E_MEX_INS_SOGLIA, 0);
				if(raccomandazioni != null && BelleStringhe.togliSpazi(raccomandazioni) != ""){
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
				stampaMex(ERRORE_INSERIMENTO);
				break;
			}
		}while(sceltaT!=0);
		
		Esame esame = null;
		return esame;
	}
	
	/**
	 * Overload di creaEsame che permette di essere chiamato da altri metodi o dall'utente preimpostando la scelta della
	 * tipologia di esame da creare
	 * 
	 * @param scelta <strong>1</strong> se si preimposta di creare un esame diagnostico <strong>2</strong> se periodico misurabile
	 * @return l'esame creato
	 */
	public static Esame creaEsame(int scelta){
		String nome = MyInput.leggiStringaNonVuota(P_MEX_INS_NOME);
		String raccomandazioni = MyInput.leggiStringa(E_MEX_INS_RACCOMANDAZIONI);
		
		MyMenu menuTipo = new MyMenu("Tipo esame", E_OPZIONI_SCEGLI_TIPO);
		switch(scelta){
			case 1:
				String areaInteressata = MyInput.leggiStringaNonVuota(E_MEX_INS_AREAI);
				if(raccomandazioni != null && BelleStringhe.togliSpazi(raccomandazioni) != ""){
					EsameDiagnostico e1 = new EsameDiagnostico(nome, areaInteressata);
					return e1;
				}
				else{
					EsameDiagnostico e1 = new EsameDiagnostico(nome, raccomandazioni, areaInteressata);
					return e1;	
				}
			case 2:
				int valoreMin = MyInput.leggiInteroConMinimo(E_MEX_INS_VALORE_MIN, 0);
				int valoreMax = MyInput.leggiInteroConMinimo(E_MEX_INS_VALORE_MAX, valoreMin+1);
				int sogliaErrore = MyInput.leggiInteroConMinimo(E_MEX_INS_SOGLIA, 0);
				if(raccomandazioni != null && BelleStringhe.togliSpazi(raccomandazioni) != ""){
					EsamePeriodicoMisurabile e1 = new EsamePeriodicoMisurabile(nome, valoreMin, valoreMax, sogliaErrore);
					return e1;
				}
				else{
					EsamePeriodicoMisurabile e1 = new EsamePeriodicoMisurabile(nome, raccomandazioni, valoreMin, valoreMax, sogliaErrore);
					return e1;	
				}
			default:
				stampaMex(ERRORE_INSERIMENTO);
				break;
			}
		
		Esame esame = null;
		return esame;
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la creazione di un esame effettuato
	 * @param listaE la lista delle tipologie di esame create
	 * @param listaM la lista delle malattie create
	 * 
	 * @return EsameEffettuato se non si incontrano eccezioni, altrimenti null
	 * @author Martinelli Giuseppe
	 */
	public static EsameEffettuato creaEsameEffettuato(ListaEsame listaE, ArrayList<Malattia> listaM){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuEffettuato = new MyMenu("Tipologia di esame", E_OPZIONI_SCEGLI_TIPO);
		scelta = menuEffettuato.scegli();
		
		switch(scelta){
			case 1:	//Diagnostico
				valido = false;
				EsameDiagnostico eAss = null;
				do{
					String nomeEsameAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					if(listaE.isEsistente(nomeEsameAss)){
						eAss = (EsameDiagnostico) listaE.cercaEsame(nomeEsameAss);
						valido = true;
					}
					else{
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				valido = false;
				Malattia mAss = null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					for(int i = 0; i < listaM.size() && valido == false; i++){
						if(listaM.get(i).getNome().equals(nomeMalattiaAss)){
							mAss = listaM.get(i);
							valido = true;
						}
					}
					if(!valido){
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				
				String luogo = MyInput.leggiStringaNonVuota(E_MEX_INS_LUOGO);
				Date data = MyInput.leggiData(E_MEX_INS_DATA);
				String ora = MyInput.leggiStringaNonVuota(E_MEX_INS_ORA);
				String esito = MyInput.leggiStringa(E_MEX_INS_ESITO);
				
				EDiagnosticoEffettuato ed1 = null;
				if(esito != null || BelleStringhe.togliSpazi(esito) != ""){
					try{
						ed1 = new EDiagnosticoEffettuato(eAss, mAss, luogo, data, ora, esito);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				else{
					try{
						ed1 = new EDiagnosticoEffettuato(eAss, mAss, luogo, data, ora);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				return ed1;
			case 2:	//Periodico Misurabile
				valido = false;
				EsamePeriodicoMisurabile eAssP=null;
				do{
					String nomeEsameAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					if(listaE.isEsistente(nomeEsameAss)){
						eAssP = (EsamePeriodicoMisurabile) listaE.cercaEsame(nomeEsameAss);
						valido = true;
					}
					else{
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				valido = false;
				Malattia mAssP = null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					for(int i = 0; i<listaM.size() && valido == false; i++){
						if(listaM.get(i).getNome().equals(nomeMalattiaAss)){
							mAssP = listaM.get(i);
							valido = true;
						}
					}
					if(!valido){
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				
				String luogoP = MyInput.leggiStringaNonVuota(E_MEX_INS_LUOGO);
				Date dataP = MyInput.leggiData(E_MEX_INS_DATA);
				String oraP = MyInput.leggiStringaNonVuota(E_MEX_INS_ORA);
				double esitoP = MyInput.leggiDouble(E_MEX_INS_ESITO);
				
				EPeriodicoMisurabileEffettuato ep1 = null;
				if(esitoP > 0){ //Ritengo l'esito inserito valido solo se >0, se <=0 lo considero come non inserito
					try{
						ep1 = new EPeriodicoMisurabileEffettuato(eAssP, mAssP, luogoP, dataP, oraP, esitoP);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				else{
					try{
						ep1 = new EPeriodicoMisurabileEffettuato(eAssP, mAssP, luogoP, dataP, oraP);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				return ep1;
			default:
				stampaMex(ERRORE_INSERIMENTO);
		}
		return null;
	}
	
	/**
	 * Overload di creaEsameEffettuato che permette di essere chiamato da altri metodi o dall'utente preimpostando la scelta della
	 * tipologia di esame da creare
	 * 
	 * @param listaE la lista delle tipologie di esame create
	 * @param listaM la lista delle malattie create
	 * @param scelta <strong>1</strong> se si preimposta di creare un esame diagnostico <strong>2</strong> se periodico misurabile
	 * @return l'esame creato se non si generano eccezioni, altrimenti null
	 */
	public static EsameEffettuato creaEsameEffettuato(ListaEsame listaE, ArrayList<Malattia> listaM, int scelta){
		boolean valido = false;
		MyMenu menuEffettuato = new MyMenu("Tipologia di esame", E_OPZIONI_SCEGLI_TIPO);
		
		switch(scelta){
			case 1:	//Diagnostico
				valido = false;
				EsameDiagnostico eAss = null;
				do{
					String nomeEsameAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					if(listaE.isEsistente(nomeEsameAss)){
						eAss = (EsameDiagnostico) listaE.cercaEsame(nomeEsameAss);
						valido = true;
					}
					else{
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				valido = false;
				Malattia mAss = null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					for(int i = 0; i < listaM.size() && valido == false; i++){
						if(listaM.get(i).getNome().equals(nomeMalattiaAss)){
							mAss = listaM.get(i);
							valido = true;
						}
					}
					if(!valido){
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				
				String luogo = MyInput.leggiStringaNonVuota(E_MEX_INS_LUOGO);
				Date data = MyInput.leggiData(E_MEX_INS_DATA);
				String ora = MyInput.leggiStringaNonVuota(E_MEX_INS_ORA);
				String esito = MyInput.leggiStringa(E_MEX_INS_ESITO);
				
				EDiagnosticoEffettuato ed1 = null;
				if(esito != null || BelleStringhe.togliSpazi(esito) != ""){
					try{
						ed1 = new EDiagnosticoEffettuato(eAss, mAss, luogo, data, ora, esito);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				else{
					try{
						ed1 = new EDiagnosticoEffettuato(eAss,mAss,luogo,data,ora);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				return ed1;
			case 2:	//Periodico Misurabile
				valido = false;
				EsamePeriodicoMisurabile eAssP = null;
				do{
					String nomeEsameAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					if(listaE.isEsistente(nomeEsameAss)){
						eAssP = (EsamePeriodicoMisurabile) listaE.cercaEsame(nomeEsameAss);
						valido = true;
					}
					else{
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				valido = false;
				Malattia mAssP = null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					for(int i = 0; i < listaM.size() && valido == false; i++){
						if(listaM.get(i).getNome().equals(nomeMalattiaAss)){
							mAssP = listaM.get(i);
							valido = true;
						}
					}
					if(!valido){
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				String luogoP = MyInput.leggiStringaNonVuota(E_MEX_INS_LUOGO);
				Date dataP = MyInput.leggiData(E_MEX_INS_DATA);
				String oraP = MyInput.leggiStringaNonVuota(E_MEX_INS_ORA);
				double esitoP = MyInput.leggiDouble(E_MEX_INS_ESITO);
				
				EPeriodicoMisurabileEffettuato ep1 = null;
				if(esitoP > 0){ //Ritengo l'esito inserito valido solo se >0, se <=0 lo considero come non inserito
					try{
						ep1 = new EPeriodicoMisurabileEffettuato(eAssP, mAssP, luogoP, dataP, oraP, esitoP);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				else{
					try{
						ep1 = new EPeriodicoMisurabileEffettuato(eAssP,mAssP,luogoP,dataP,oraP);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				return ep1;
			default:
				stampaMex(ERRORE_INSERIMENTO);
		}
		return null;
	}
	
	/**
	 * Overload di creaEsameEffettuato che crea un oggetto EsameEffettuato di tipo basato su quello dell'oggetto Esame 
	 *
	 * @param esame il tipo di esame
	 * @param listaM la lista delle malattie create
	 * @return l'esame effettuato se non si generano eccezioni, altrimenti null
	 */
	//modificato non so se funziona
	public static EsameEffettuato creaEsameEffettuato(Esame esame, ArrayList<Malattia> listaM){
		boolean valido = false;
			if(esame instanceof EsameDiagnostico){//Diagnostico
				valido = false;
				Malattia mAss = null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					for(int i = 0; i < listaM.size() && valido == false; i++){
						if(listaM.get(i).getNome().equals(nomeMalattiaAss)){
							mAss = listaM.get(i);
							valido = true;
						}
					}
					if(!valido){
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				
				String luogo = MyInput.leggiStringaNonVuota(E_MEX_INS_LUOGO);
				Date data = MyInput.leggiData(E_MEX_INS_DATA);
				String ora = MyInput.leggiStringaNonVuota(E_MEX_INS_ORA);
				String esito = MyInput.leggiStringa(E_MEX_INS_ESITO);
				
				EDiagnosticoEffettuato ed1 = null;
				if(esito != null || BelleStringhe.togliSpazi(esito) != ""){
					try{
						ed1 = new EDiagnosticoEffettuato((EsameDiagnostico) esame, mAss, luogo, data, ora, esito);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				else{
					try{
						ed1 = new EDiagnosticoEffettuato((EsameDiagnostico) esame, mAss, luogo, data, ora);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				return ed1;
			}
			else if(esame instanceof EsamePeriodicoMisurabile){	//Periodico Misurabile
				valido = false;
				Malattia mAssP = null;
				do{
					String nomeMalattiaAss = MyInput.leggiStringaNonVuota(E_MEX_INS_MRELATIVO);
					for(int i = 0; i < listaM.size() && valido == false; i++){
						if(listaM.get(i).getNome().equals(nomeMalattiaAss)){
							mAssP = listaM.get(i);
							valido = true;
						}
					}
					if(valido = false){
						stampaMex(ERRORE_MALATTIA_NON_TROVATA);
					}
				}while(!valido);
				
				String luogoP = MyInput.leggiStringaNonVuota(E_MEX_INS_LUOGO);
				Date dataP = MyInput.leggiData(E_MEX_INS_DATA);
				String oraP = MyInput.leggiStringaNonVuota(E_MEX_INS_ORA);
				double esitoP = MyInput.leggiDouble(E_MEX_INS_ESITO);
				
				EPeriodicoMisurabileEffettuato ep1 = null;
				if(esitoP > 0){ //Ritengo l'esito inserito valido solo se >0, se <=0 lo considero come non inserito
					try{
						ep1 = new EPeriodicoMisurabileEffettuato((EsamePeriodicoMisurabile) esame, mAssP, luogoP, dataP, oraP, esitoP);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				else{
					try{
						ep1 = new EPeriodicoMisurabileEffettuato((EsamePeriodicoMisurabile) esame, mAssP, luogoP, dataP, oraP);
					}
					catch(IllegalAccessException e){
						e.printStackTrace();
						return null;
					}
				}
				return ep1;
		}
		return null;
	}
	
	/**
	 * Metodo che crea un oggetto di tipo Malattia permettendo all'utente di inserire i dati desiderati
	 * 
	 * @param listaE la lista delle tipologie di esame create
	 * @return la malattia creata
	 * 
	 * @author Valtulini Claudio
	 */
	public static Malattia creaMalattia(ListaEsame listaE){
		String nome = null;
		Date dataInizio = null;
		Date dataTermine = null;
		String sintomi = null;
		String diagnosi = null;
		ArrayList<Esame> listaAssociati = new ArrayList<Esame>();
		String terapia = null;
		
		nome = MyInput.leggiStringaNonVuota(M_MEX_INS_NOME);
		dataInizio = MyInput.leggiData(M_MEX_INS_DATAI);
		
		boolean scegliTermine = MyInput.yesOrNo(M_SCELTA_INS_DATAT);
		if(scegliTermine) dataTermine = MyInput.leggiData(M_MEX_INS_DATAT);
		
		sintomi = MyInput.leggiStringaNonVuota(M_MEX_INS_SINTOMI);
		diagnosi = MyInput.leggiStringaNonVuota(M_MEX_INS_DIAGNOSI);
		terapia = MyInput.leggiStringaNonVuota(M_MEX_INS_DIAGNOSI);
		
		boolean inserisciEsame = MyInput.yesOrNo(M_SCELTA_INS_ASSOCIATO);
		String nomeAssociato = null;
		while(inserisciEsame){
			nomeAssociato = MyInput.leggiStringaNonVuota(E_MEX_INS_NOME);
			if(listaE.isEsistente(nomeAssociato)){
				listaAssociati.add(listaE.cercaEsame(nomeAssociato));
			}
			else{
				stampaMex(ERRORE_ESAME_NON_TROVATO);
			}
			inserisciEsame = MyInput.yesOrNo(M_SCELTA_INS_ALTRO_ASSOCIATO);
		}
		
		return new Malattia(nome, dataInizio, dataTermine, sintomi, diagnosi, listaAssociati, terapia);
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati utente della cartella sanitaria
	 * @param CS la cartella sanitaria da modificare
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaDatiPaziente(CartellaSanitaria CS, ListaEsame listaE, ArrayList<Malattia> listaM){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuModificaPaziente = new MyMenu(MODIFICA_INFO_P, P_OPZIONI_MODIFICA);
		do{
			scelta = menuModificaPaziente.scegli();
		
			switch(scelta){
				case 1:
					CS.setNome(MyInput.leggiStringaNonVuota(P_MEX_INS_NOME));
					break;
				case 2:
					CS.setCognome(MyInput.leggiStringaNonVuota(P_MEX_INS_COGNOME));
					break;
				case 3:
					CS.setIndirizzo(MyInput.leggiStringaNonVuota(P_MEX_INS_INDIRIZZO));
					break;
				case 4:
					valido = false;
					String telefono = null;
					do{
						telefono = MyInput.leggiStringaNonVuota(P_MEX_INS_TELEFONO);
						if(CartellaSanitaria.checkValiditaTelefono(telefono)){
							valido = true;
						}
						else{
							stampaMex(ERRORE_INSERIMENTO);
						}
					}while(!valido);
					CS.setTelefono(telefono);
					break;
				case 5:
					valido = false;
					String mail = null;
					do{
						mail = MyInput.leggiStringaNonVuota(P_MEX_INS_MAIL);
						if(CartellaSanitaria.checkValiditaEMail(mail)){
							valido = true;
						}
						else{
							stampaMex(ERRORE_INSERIMENTO);
						}
					}while(!valido);
					CS.setEmail(mail);
					break;
				case 6:
					valido = false;
					String data = null;
					do{
						data = MyInput.leggiStringaNonVuota(P_MEX_INS_DATAN);
						if(CartellaSanitaria.checkDataNascita(data)){
							valido = true;
						}
						else{
							stampaMex(ERRORE_INSERIMENTO);
						}
					}while(!valido);
					CS.setDataNascita(MyTime.creaData(data));
					break;
				case 7:
					CS.setLuogoNascita(MyInput.leggiStringaNonVuota(P_MEX_INS_LUOGON));
					break;
				case 8:
					valido = false;
					char genereInserito;
					boolean genere = true;
					do{
						genereInserito = MyInput.leggiChar(P_MEX_INS_GENERE);
						try{
							genere = CartellaSanitaria.ritornaBoolGenere(genereInserito);
						}
						catch(IllegalArgumentException e){
							stampaMex(e.getMessage());
						}
					}while(!valido);
					CS.setGenere(genere);
					break;
				case 9:
					valido = false;
					String codiceF = null;
					do{
						codiceF = MyInput.leggiStringaNonVuota(P_MEX_INS_CODICEF);
						if(CartellaSanitaria.checkValiditaCF(codiceF)){
							valido = true;
						}
						else{
							stampaMex(ERRORE_INSERIMENTO);
						}
					}while(!valido);
					CS.setCodiceFiscale(codiceF);
					break;
				case 10:
					valido = false;
					String gruppoS = null;
					do{
						gruppoS = MyInput.leggiStringaNonVuota(P_MEX_INS_GSANGUIGNO);
						if(CartellaSanitaria.checkGruppoSanguigno(gruppoS)){
							valido = false;
						}
						else{
							stampaMex(ERRORE_INSERIMENTO);
						}
					}while(!valido);
					CS.setGruppoSanguigno(gruppoS);
					break;
					case 11: //aggiungi esame
						aggiungiEffettuato(CS, listaE, listaM);
						break;
					case 12: //aggiungi malattia
						creaMalattia(listaE);
						break;
					case 13: //rimuovi effettuato
						//Forse non corretto non sono convinto del confronto della data nel metodo cerca con i due parametri
						String nomeEsame = MyInput.leggiStringaNonVuota(E_MEX_CANCELLA_NOME);
						if(CS.isEsameEsistente(nomeEsame)){
							if(CS.contaEsame(nomeEsame) > 1){
								Date dataEsame = MyInput.leggiData(E_MEX_PIU_ESAMI + " " + E_MEX_CANCELLA_DATA);
								CS.getEsamiEffettuati().remove(CS.cercaEsame(nomeEsame, dataEsame));
							}
							else{
								CS.getEsamiEffettuati().remove(CS.cercaEsame(nomeEsame));
							}
						}
						break;
					case 14: //rimuovi malattia
						String nomeMalattia = MyInput.leggiStringaNonVuota(M_MEX_CANCELLA);
						if(CS.isMalattiaEsistente(nomeMalattia)){
							if(CS.contaMalattiaEsistente(nomeMalattia) > 1){
								Date dataInizio = MyInput.leggiData(M_MEX_PIU_MALATTIE + " " + M_MEX_CANCELLA_DATAI);
								CS.getElencoMalattia().remove(CS.cercaMalattia(nomeMalattia, dataInizio));
							}
							else{
								CS.getElencoMalattia().remove(CS.cercaMalattia(nomeMalattia));
							}
						}
						break;
					case 0:
						break;
					default:
						stampaMex(ERRORE_INSERIMENTO);
			}
		}while(scelta != 0);
	}
	
	/**
	 * Crea un oggetto di tipo EsameEffettuato e lo aggiunge alla lista di esami della cartella sanitaria passata come parametro
	 * permette di scegliere se creare un esame diagnostico o periodico misurabile (effettuati) creando un nuovo oggetto Esame
	 * o cercandolo tra quelli esistenti
	 * 
	 * @param CS la cartella sanitaria alla quale va aggiunto l'esame effettuato
	 * @param listaE la lista di tipologie di esame create
	 * @param listaM la lista di malattie create
	 * 
	 * @author Valtulini Claudio
	 */
	public static void aggiungiEffettuato(CartellaSanitaria CS, ListaEsame listaE, ArrayList<Malattia> listaM){
		int scelta = 0;
		MyMenu creaCerca = new MyMenu(E_SCELTA_CREA_CERCA, E_OPZIONI_CREA_CERCA);
		scelta = creaCerca.scegli();
		
		do{
			switch(scelta){
				case 1:
					int scelta2 = 0;
					MyMenu scegliTipo = new MyMenu(E_SCELTA_TIPO, E_OPZIONI_SCEGLI_TIPO);
					scelta2 = scegliTipo.scegli();
				
					switch(scelta2){
						case 1:
							CS.getEsamiEffettuati().add(creaEsameEffettuato(listaE, listaM, scelta2));
							break;
						case 2:
							CS.getEsamiEffettuati().add(creaEsameEffettuato(listaE, listaM, scelta2));
							break;
						default:
							stampaMex(ERRORE_INSERIMENTO);
					}
					break;
				case 2:
					String daCercare = null;
					Esame esame = null;
					do{
						daCercare = MyInput.leggiStringaNonVuota(E_MEX_CERCA);
						esame = listaE.cercaEsame(daCercare);
					}while(esame == null);
				
					CS.getEsamiEffettuati().add(creaEsameEffettuato(esame, listaM));
					break;
				case 0:
					break;
				default:
					stampaMex(ERRORE_INSERIMENTO);
			}
		}while(scelta != 0);
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
		MyMenu menuModificaEffettuato = new MyMenu(MODIFICA_INFO_E, E_OPZIONI_MODIFICA);
		do{
			scelta = menuModificaEffettuato.scegli();
		
			switch(scelta){
				case 1:
					String nomeMod = MyInput.leggiStringaNonVuota(E_MEX_INS_NOME);
					esame.setNome(nomeMod);
					break;
				case 2:
					String raccomandazioniMod = MyInput.leggiStringa(E_MEX_INS_RACCOMANDAZIONI);
					esame.setNome(raccomandazioniMod);
					break;
				case 0:
					break;
				default:
					stampaMex(ERRORE_INSERIMENTO);
			}
		}while(scelta != 0);
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati di un esame effettuato
	 * @param EsameEffettuato l'esame da modificare
	 * @param listaE la lista delle tipologie di esame create
	 * @param listaM la lista delle malattie create
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaDatiEsameEffettuato(EsameEffettuato esame, ListaEsame listaE, CartellaSanitaria CS){
		int scelta = 0;
		boolean valido = false;
		MyMenu menuModificaEffettuato = new MyMenu(MODIFICA_INFO_E_EFFETTUATO, E_OPZIONI_MODIFICA_EFFETTUATO);
		
		do{
			scelta = menuModificaEffettuato.scegli();
		
			switch(scelta){
				case 1:
					try{
						String data = MyInput.leggiStringaNonVuota(E_MEX_INS_DATA);
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
							String nomeEsame = MyInput.leggiStringaNonVuota(P_MEX_INS_NOME);
							if(listaE.isEsistente(nomeEsame)){
								esame.setEsame(listaE.cercaEsame(nomeEsame));
								valido = true;
							}
							else{
								stampaMex(ERRORE_TIPOLOGIA_INESISTENTE);
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
						String luogo = MyInput.leggiStringaNonVuota(E_MEX_INS_LUOGO);
						esame.setLuogo(luogo);
					}
					catch(TooLateException e){
						stampaMex(e.getMessage());
					}
					break;
				case 4:
					valido = false;
					do{
						String nomeMalattia = MyInput.leggiStringaNonVuota(E_MEX_INS_MALATTIAN);
						if(CS.isMalattiaEsistente(nomeMalattia)){
							esame.setMalattia(CS.cercaMalattia(nomeMalattia));
							valido = true;
						}
						else{
							stampaMex(ERRORE_MALATTIA_INESISTENTE);
						}
					}while(valido == false);
					break;
				case 5:
					try{
						String ora = MyInput.leggiStringaNonVuota(E_MEX_INS_ORA);
						esame.setOra(ora);
					}
					catch(TooLateException e){
						stampaMex(e.getMessage());
					}
					break;
				case 6:
					if(esame instanceof EPeriodicoMisurabileEffettuato){
						double esito = MyInput.leggiInteroNonNegativo(E_MEX_INS_ESITO_PERIODICO);
						((EPeriodicoMisurabileEffettuato) esame).setEsito(esito);
					}
					else if(esame instanceof EDiagnosticoEffettuato){
						String esito = MyInput.leggiStringaNonVuota(E_MEX_INS_ESITO_DIAGNOSTICO);
						((EDiagnosticoEffettuato) esame).setEsito(esito);
					}
					break;
				case 7:
					if(esame instanceof EDiagnosticoEffettuato){
						stampaMex(ERRORE_OPERAZIONE_ND_TIPO);
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
				case 0:
					break;
				default:
					stampaMex(ERRORE_INSERIMENTO);
			}
		}while(scelta != 0);
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
		MyMenu menuModificaMalattia = new MyMenu(MODIFICA_INFO_M, M_OPZIONI_MODIFICA);
		do{
			scelta = menuModificaMalattia.scegli();
		
			switch(scelta){
				case 1:
					String nome = MyInput.leggiStringaNonVuota(M_MEX_INS_NOME);
					malattia.setNome(nome);
					break;
				case 2:
					Date datai = MyInput.leggiData(M_MEX_INS_DATAI);
					malattia.setDataInizio(datai);
					break;
				case 3:
					Date datat = MyInput.leggiData(M_MEX_INS_DATAT);
					malattia.setDataInizio(datat);
					break;
				case 4:
					String sintomi = MyInput.leggiStringaNonVuota(M_MEX_INS_SINTOMI);
					malattia.setSintomi(sintomi);
					break;
				case 5:
					String diagnosi = MyInput.leggiStringaNonVuota(M_MEX_INS_DIAGNOSI);
					malattia.setDiagnosi(diagnosi);
					break;
				case 6:
					String terapia = MyInput.leggiStringaNonVuota(M_MEX_INS_TERAPIA);
					malattia.setTerapia(terapia);
					break;
				default:
					stampaMex(ERRORE_INSERIMENTO);
			}
		}while(scelta != 0);
	}
	
	/**
	 * Permette la visualizzazione completa dei dati di una cartella sanitaria
	 * 
	 * @param CS la cartella sanitaria di cui visualizzare i dati
	 *
	 * @author Valtulini Claudio
	 */
	public static void visualizzaDatiUtenteCompleta(CartellaSanitaria CS){
		String stringaDescrittivaCompleta = "Cartella sanitaria di " + CS.getNome() + " " + CS.getCognome() + "%n" +
			"Residente in: " + CS.getIndirizzo() + "%n" +
			"Contatti: " + "%n" +
			"  Numero Telefonico: " + CS.getTelefono() + "%n";
		if(CS.getEmail() != null){ stringaDescrittivaCompleta += 
			"  Indirizzo E-Mail: " + CS.getEmail() + "%n";
		}
		stringaDescrittivaCompleta +=
			"Nato il: " + CS.getDataNascita().toString() + "%n" +
			"A: " + CS.getLuogoNascita() + "%n" +
			"Genere: " + CS.getStringaGenere() + "%n" +
			"Gruppo Sanguigno: " + CS.getGruppoSanguigno() + "%n" +
			"Codice Fiscale: " + CS.getCodiceFiscale() + "%n";
		CS.generaCodiceSanitario();
		stringaDescrittivaCompleta +=
			"Codice Sanitario: " + CS.getCodiceSanitario() + "%n" +
			"Esami Effettuati: " + "%n";
		for(EsameEffettuato elemento: CS.getEsamiEffettuati()){ stringaDescrittivaCompleta +=
			"  " + elemento.toString();
		}
		stringaDescrittivaCompleta +=
			"Malattie: " + "%n";
		for(Malattia elemento: CS.getElencoMalattia()){ stringaDescrittivaCompleta +=
			"  " + elemento.toString();
		}
				
		stampaMex(stringaDescrittivaCompleta);
	}
	
	/**
	 * Permette la visualizzazione competa dei dati di un EsameEffettuato
	 * @param esame l'esame di cui visualizzare i dati
	 * 
	 * @author Valtulini Claudio
	 */
	public static void visualizzaEsameCompleta(EsameEffettuato esame){
		String stringaDescrittivaCompleta =
			esame.toStringCompleto();
		stampaMex(stringaDescrittivaCompleta);
	}
	
	/**
	 * Permette la visualizzazione completa dei dati di una malattia
	 * @param malattia la malattia di cui visualizzare i dati
	 * 
	 * @author Valtulini Claudio
	 */
	public static void visualizzaMalattiaCompleta(Malattia malattia){
		String stringaDescrittivaCompleta =
			malattia.toString() + "%n";
		if(malattia.getSintomi() != null){ stringaDescrittivaCompleta +=
			"  Sintomi: " + malattia.getSintomi();
		}
		if(malattia.getDiagnosi() != null){ stringaDescrittivaCompleta +=
			" Diagnosi: "+ malattia.getDiagnosi();
		}
		if(malattia.getElencoEsamiAssociati().size() > 0){ stringaDescrittivaCompleta +=
			"  Elenco delle tipologie di esame associate: " + "%n";
			for(Esame elemento: malattia.getElencoEsamiAssociati()){ stringaDescrittivaCompleta +=
			"   " + elemento.toString();
			}
		}
		if(malattia.getTerapia() != null){ stringaDescrittivaCompleta +=
			"  Terapia: " + malattia.getTerapia();
		}
		
		stampaMex(stringaDescrittivaCompleta);
	}
	
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un ArrayList di EsameEffettuato
	 * contenente quello/quelli (se più di uno con lo stesso esito) con esito massimo
	 * 
	 * @param listaEPME la lista di esami in cui cercare quello con esito maggiore
	 * @return una lista di esami contenente quelli con esito massimo
	 * 
	 * @author Valtulini Claudio
	 */
	//da decidere se ignorare i valori oltre soglia, in tal caso va modificato
	public static ArrayList<EPeriodicoMisurabileEffettuato> esameEsitoMax(ArrayList<EPeriodicoMisurabileEffettuato> listaEPME){
		ArrayList<EPeriodicoMisurabileEffettuato> listaMax = new ArrayList<>();
		listaMax.add(listaEPME.get(0));
		
		for(EPeriodicoMisurabileEffettuato elemento: listaEPME){
			if(Double.compare(elemento.getEsito(), listaMax.get(0).getEsito()) > 0){
				listaMax.clear();
				listaMax.add(elemento);
			}
			else if(Double.compare(elemento.getEsito(), listaMax.get(0).getEsito()) == 0){
				listaMax.add(elemento);
			}
		}
		
		return listaMax;
	}
	
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un ArrayList di EsameEffettuato
	 * contenente quello/quelli (se più di uno con lo stesso esito) con esito minimo
	 * 
	 * @param listaEPME la lista di esami in cui cercare quello con esito minore
	 * @return una lista di esami contenente quelli con esito minimo
	 * 
	 * @author Valtulini Claudio
	 */
	//come sopra
	public static ArrayList<EPeriodicoMisurabileEffettuato> esameEsitoMin(ArrayList<EPeriodicoMisurabileEffettuato> listaEPME){
		ArrayList<EPeriodicoMisurabileEffettuato> listaMin = new ArrayList<>();
		listaMin.add(listaEPME.get(0));
		
		for(EPeriodicoMisurabileEffettuato elemento: listaEPME){
			if(Double.compare(elemento.getEsito(), listaMin.get(0).getEsito()) < 0){
				listaMin.clear();
				listaMin.add(elemento);
			}
			else if(Double.compare(elemento.getEsito(), listaMin.get(0).getEsito()) == 0){
				listaMin.add(elemento);
			}
		}
		
		return listaMin;
	}
	
	/**
	 * Partendo da un ArrayList (che dovrebbe essere di esami della stessa tipologia) restituisce un double contenente il valore
	 * medio degli esiti
	 * 
	 * @param listaEPME la lista di esami dei quali trovare l'esito medio
	 * @return vMedio il valore medio degli esiti
	 * 
	 * @author Valtulini Claudio
	 */
	 //Stessa cosa riguardante esito max e min
	 //decidere se controllare se la dimensione dell'arraylist passato sia maggiore di 0
	public static double esameEsitoMedio(ArrayList<EPeriodicoMisurabileEffettuato> listaEPME){
		double somma = 0.0;
		int nEsami = 0;
		
		for(EPeriodicoMisurabileEffettuato elemento: listaEPME){
			somma += elemento.getEsito();
			nEsami++;
		}
		
		double vMedio = somma / nEsami;
		
		return vMedio;
	}
	
	/**
	 * Passata una lista di EsamiEffettuati ne trova quelli il cui nome dell'esame corrispondente equivale a quello della stringa passata
	 * 
	 * @param listaEE la lista di EsamiEffettuati
	 * @param nomeTipologia una stringa contenente il nome della tipologia di esami che si vuole isolare
	 * @return listaStessaTipologia un ArrayList di esami effettuati tutti della stessa tipologia
	 * 
	 * @author Valtulini Claudio
	 */
	//nome non molto significativo
	public static ArrayList<EsameEffettuato> esameStessaTipologia(ArrayList<EsameEffettuato> listaEE, String nomeTipologia){
		ArrayList<EsameEffettuato> listaStessaTipologia = new ArrayList<>();
		
		for(EsameEffettuato elemento: listaEE){
			if(elemento.getEsame().getNome() == nomeTipologia){
				listaStessaTipologia.add(elemento);
			}
		}
		
		return listaStessaTipologia;
	}
	
	/**
	 * Menu per la gestione delle info di utente Modifica/Visualizza/Visualizza Completo
	 * @param CS la cartella sanitaria da gestire
	 * @param listaE la lista delle tipologie di esami creati
	 * @param listaM la lista delle malattie create
	 * 
	 * @author Martinelli Giuseppe
	 */
	// probabilmente da riscrivere secondo le richieste traccia
	public static void gestioneInfoUtente(CartellaSanitaria CS, ListaEsame listaE, ArrayList<Malattia> listaM){
		int scelta = 0;
		MyMenu menuPaziente = new MyMenu("Gestione informazioni utente", P_OPZIONI);
		scelta = menuPaziente.scegli();
		switch(scelta){
			case 1:
				modificaDatiPaziente(CS, listaE, listaM);
				break;
			case 2:
				stampaMex(CS.toString());
				break;
			case 3:
				visualizzaDatiUtenteCompleta(CS);
				break;
			default:
				stampaMex(ERRORE_INSERIMENTO);
		}
	}
	
	/* Oggetti da pre-creare salvati per esame
	 * 4 tipologie di esami
	 * 6 esami misurabili dello stesso tipo (6 effettuati)
	 * 3 esami diagnostici dello stesso tipo (3 effettuati)
	 * 3 esami prenotati (senza esito)
	*/
	/* Cosa si dovrebbe fare nel main secondo la traccia (mia interpretazione V)
	 * (partendo dalla visualizzazione dell'utente, no scelte, no operazioni di caricamento)
	 * Visualizzo nome e cognome
	 * 	con elenco esami
	 * 		nome e data, se periodici valore esito
	 * 	con elenco malattie
	 * 
	 * Dopo chiedo se
	 * 	visualizzare tutti i dati anagrafici
	 * 		visualizzacompleto()
	 *  scegliere un esame e visualizzarlo completamente
	 *  	visualizzacompleto()
	 *  scegliere una malattia e visualizzarla completamente
	 *  	visualizzacompleto()
	 *  
	 * Scegliere una tipologia di esame e
	 * 	visualizzare tutte le misurazioni data + esito
	 * 	visualizzare valore max e min e superamenti di soglia + date
	 * 		gestire max e min multipli (presumo si intenda più valori uguali in date diverse)
	 * 	visualizzare valore medio (media dei valori o valore più vicino alla media? presumo la prima)
	 * 	altre statistiche a scelta (ci si può non incasinare ed evitare)
	 */
	/*Main*/
	public static void main(String[] args) {
		stampaMex(MEX_BENVENUTO);
		CartellaSanitaria CS = null; //momentaneo per non ricevere errori dall'editor

		ArrayList<Esame> lista = new ArrayList<Esame>();
		ArrayList<Malattia> listaM = new ArrayList<Malattia>();
		ArrayList<EsameEffettuato> listaEffettuati = new ArrayList<EsameEffettuato>();
		
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
			MyMenu menuGenerale = new MyMenu("Cartella Sanitaria", G_OPZIONI);
			scelta = menuGenerale.scegli();
			switch(scelta){
			case 1: //Modifica Visualizza utente
				gestioneInfoUtente(CS, listaE, listaM);
				break;
			case 2: //Modifica visualizza esame
				int scelta3 = 0;
				do{
					MyMenu menuEsame = new MyMenu("Gestione esami", E_OPZIONI);
					scelta3 = menuEsame.scegli();
					switch(scelta3){
					case 1:	//Si vuole inserire un nuovo esame
						int scelta4 = 0; 
						do{
							MyMenu menuTipo = new MyMenu("Tipo esame", E_OPZIONI_SCEGLI_TIPO);
							scelta4 = menuTipo.scegli();
							switch(scelta4){	//Faccio scegliere se inserire un nuovo esame o un nuovo esame effettuato
							case 1:		//Esame 
								Esame esame = creaEsame();
								if(esame != null)
									listaE.aggiungiEsame(esame);
								scelta4 = 0;	//Scelta valida, posso uscire dal ciclo
								break;
							case 2:		//EsameEffettuato
								EsameEffettuato eF = creaEsameEffettuato(listaE, listaM);
								if(eF != null)
									listaEffettuati.add(eF);
								
								scelta4 = 0;	//Scelta valida, posso uscire dal ciclo
								break;
							case 0:
								break;
							default:
								stampaMex(ERRORE_INSERIMENTO);
							}
						}while(scelta4 != 0);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default:
						stampaMex(ERRORE_INSERIMENTO);
					}
				}while(scelta3 != 0);
				break;
			case 3://Modifica visualizza malattia
				int scelta4 = 0;
				do{
					MyMenu menuMalattia = new MyMenu("Gestione malattia", M_OPZIONI);
					scelta4 = menuMalattia.scegli();
				}while(scelta4 != 0);
				break;
			case 0:
				break;
			default:
				stampaMex(ERRORE_INSERIMENTO);
			}
			stampaMex(" ");
		}while(scelta != 0);
		stampaMex(MEX_USCITA);
	}
}
