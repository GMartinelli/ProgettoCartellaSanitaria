package it.unibs.fp.progetto;

import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class CSMain implements Serializable{
	// Costanti
	private static final String MEX_BENVENUTO = "Benvenuto nell'applicazione per la gestione della cartella sanitaria di un paziente";
	private static final String MEX_USCITA = "Grazie per avere utilizzato la nostra applicazione! Arrivederci!";

	//Intestazioni menu'
	private static final String MODIFICA_INFO_P = "Modifica informazioni utente";
	private static final String MODIFICA_INFO_M = "Modifica informazioni malattia";
	private static final String MODIFICA_INFO_E_EFFETTUATO = "Modifica informazioni esame effettuato";
	private static final String MODIFICA_INFO_E = "Modifica informazioni esame effettuato";
	
	// Opzioni menu'
	private static final String[] OPZIONI_I={"Crea Cartella Sanitaria", "Visualizzazione e operazioni su oggetti"};
	private static final String[] OPZIONI_D={"Visualizzazione completa cartella / Modifica dati cartella", "Aggiungi tipologia", "Modifica tipologia", "Elimina tipologia"};
	private static final String[] OPZIONI_RICHIESTE = {"Visualizzazione completa dati anagrafici", "Visualizzazione completa di un esame tra quelli mostrati nella lista", "Visualizzazione completa di una malattia tra quelle mostrate nella lista", "Scelta di una tipologia di esame di cui visualizzare le statistiche", "Modifica Cartella Sanitaria"};
	
	private static final String[] P_OPZIONI_MODIFICA = {"Modifica nome","Modifica cognome","Modifica indirizzo","Modifica telefono","Modifica email", "Modifica luogo di nascita", "Modifica data di nascita", "Modifica genere", "Modifica codice fiscale", "Modifica gruppo sanguigno", "Aggiungi esame effettuato", "Aggiungi malattia", "Modifica esame effettuato", "Modifica malattia","Rimuovi esame effettuato", "Rimuovi malattia"};
	
	// Esame
	private static final String E_MEX_RIMUOVI_TIP="Inserisci la tipologia dell'esame che vuoi eliminare: ";
	private static final String E_MEX_RIC_RIMUOVI="Esame trovato. Vuoi eliminare l'esame %s? ";
	private static final String[] E_OPZIONI_MODIFICA = {"Modifica nome", "Modifica raccomandazioni"};
	private static final String[] E_OPZIONI_MODIFICA_EFFETTUATO = {"Modifica data", "Modifica esame", "Modifica luogo", "Modifica malattia", "Modifica ora", "Modifica esito", "Modifica avvisi (se l'esame e' di tipologia misurabile"};
	private static final String[] E_OPZIONI_SCEGLI_TIPO = {"Diagnostico", "Periodico Misurabile"};
	private static final String[] E_OPZIONI_CREA_CERCA = {"Crea una nuova tipologia di esame", "Cerca una tipologia esistente"};
	
	private static final String[] M_OPZIONI_MODIFICA = {"Modifica nome", "Modifica data di inizio", "Modifica data di termine", "Modifica sintomi", "Modifica diagnosi", "Modifica terapia"};
	
	// Gestione File
	private static final String PATH = "cartella_sanitaria.txt";
	private static final String MEX_SOVRASCIVERE="E' gia' presente una cartella sanitaria, desidera sovrasciverla e crearne una nuova?";
	
	// Inserimento Paziente
	private static final String P_MEX_INS_NOME = "Inserisci il nome del paziente: ";
	private static final String P_MEX_INS_COGNOME = "Inserisci il cognome del paziente: ";
	private static final String P_MEX_INS_INDIRIZZO = "Inserisci l'indirizzo del paziente: ";
	private static final String P_MEX_INS_TELEFONO = "Inserisci il numero di telefono del paziente: ";
	private static final String P_MEX_INS_MAIL = "Inserisci l'indirizzo e-mail del paziente: ";
	private static final String P_MEX_INS_DATAN = "Inserisci la data di nascita del paziente nel formato gg/mm/aaaa: ";
	private static final String P_MEX_INS_LUOGON = "Inserisci il luogo di nascita del paziente: ";
	private static final String P_MEX_INS_CODICEF = "Inserisci il codice fiscale del paziente: ";
	private static final String P_MEX_INS_GENERE = "Inserisci il genere del paziente: ";
	private static final String P_MEX_INS_GSANGUIGNO = "Inserisci il gruppo sanguigno del paziente: ";
	
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
	private static final String E_MEX_INS_MRELATIVO = "Inserisci il nome della malattia a cui e' associato: ";
	private static final String E_MEX_CANCELLA_NOME = "Inserisci il nome dell'esame da cancellare: ";
	private static final String E_MEX_PIU_ESAMI = "Attenzione, sono presenti piu' esami di questo tipo: ";
	private static final String E_MEX_CANCELLA_DATA = "Inserire la data dell'esame da cancellare: ";
	private static final String E_MEX_CERCA = "Inserire il nome dell'esame che si desidera cercare: ";
	private static final String E_MEX_MODIFICA = "Inserire il nome dell'esame che si desidera modificare: ";
	private static final String E_MEX_INS_TIPOLOGIA = "Inserisci il nome della tipologia di cui visualizzare le statistiche: ";
	
	private static final String E_SCELTA_CREA_CERCA = "Si desidera creare una tipologia di esame o cercarne una già esistente?";
	private static final String E_SCELTA_TIPO = "Si desidera inserire un nuovo Esame Effettuato Diagnostico o Periodico Misurabile?";
	private static final String E_SCELTA_VISUALIZZA = "Quale esame vuoi visualizzare?";
	
	// Inserimento Malattia
	private static final String M_MEX_INS_NOME = "Inserisci il nome della malattia: ";
	private static final String M_MEX_INS_DATAI = "Inserisci la data di inizio della malattia: ";
	private static final String M_MEX_INS_DATAT = "Inserisci la data di termine della malattia: ";
	private static final String M_MEX_INS_SINTOMI = "Inserisci i sintomi della malattia: ";
	private static final String M_MEX_INS_DIAGNOSI = "Inserisci la diagnosi effettuata dal medico: ";
	private static final String M_MEX_INS_TERAPIA = "Inserisci la terapia consigliata: ";
	private static final String M_MEX_CANCELLA = "Inserisci il nome della malattia che desideri eliminare: ";
	private static final String M_MEX_RIC_RIMUOVI="Malattia trovata. Vuoi eleiminare la malattia %s? ";
	private static final String M_MEX_PIU_MALATTIE = "Attenzione, sono presenti piu' malattie con questo nome: ";
	private static final String M_MEX_CANCELLA_DATAI = "Inserire la data di inizio della malattia da cancellare: ";
	
	private static final String M_SCELTA_INS_DATAT = "Si desidera inserire una data di termine?";
	private static final String M_SCELTA_INS_ASSOCIATO = "Si desidera inserire un esame associato?";
	private static final String M_SCELTA_INS_ALTRO_ASSOCIATO = "Si desidera inserire un altro esame associato?";
	private static final String M_SCELTA_VISUALIZZA = "Quale malattia vuoi visualizzare?";
	
	// Avvisi
	private static final String NON_MODIFICA = "Attenzione, non verrà chiesto di inserire alcun dato.";
	private static final String AVVISI_IMPOSTATI_CORRETTAMENTE = "Gli avvisi sono stati impostati correttamente. Operazione finita.";
	
	// Errori
	private static final String ERRORE_INS = "Errore! Dato inserito non valido!";
	private static final String ERRORE_TIPOLOGIA_INESISTENTE = "Attenzione! La tipologia di esame specificata non esiste!";
	private static final String ERRORE_MALATTIA_INESISTENTE = "Attenzione! La malattia specificata non esiste!";
	private static final String ERRORE_OPERAZIONE_ND_TIPO = "Attenzione, operazione non disponibile per il tipo di esame scelto."; //ND = NON DISPONIBILE
	private static final String ERRORE_ESAME_NON_TROVATO = "Attenzione! Non e' presente alcun esame con quel nome!";
	private static final String ERRORE_MALATTIA_NON_TROVATA = "Attenzione! Non e' presente alcuna malattia con quel nome!";
	private static final String ERRORE_MANCA_ESAME_MALATTIA = "Attenzione! Non ci sono esami o malattie nella cartella sanitaria!";
	
	//metodi
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

	// Crea
	/**
	 * Metodo che crea un oggetto della classe esame in base alla tipologia scelta nel menu presente nel metodo
	 * @return l'<strong>esame</strong> creato dall'utente
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
				stampaMex(ERRORE_INS);
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
	 * @return l'<strong>esame</strong> creato
	 */
	public static Esame creaEsame(int scelta){
		String nome = MyInput.leggiStringaNonVuota(P_MEX_INS_NOME);
		String raccomandazioni = MyInput.leggiStringa(E_MEX_INS_RACCOMANDAZIONI);
		
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
				stampaMex(ERRORE_INS);
				break;
			}
		
		Esame esame = null;
		return esame;
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la creazione di un esame effettuato
	 * @param <strong>listaE</strong> la lista delle tipologie di esame create
	 * @param <strong>listaM</strong> la lista delle malattie dell'utente
	 * 
	 * @return <strong>EsameEffettuato</strong> se non si incontrano eccezioni, <strong>null</strong> altrimenti
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
				stampaMex(ERRORE_INS);
		}
		return null;
	}
	
	/**
	 * Overload di creaEsameEffettuato che permette di essere chiamato da altri metodi o dall'utente preimpostando la scelta della
	 * tipologia di esame da creare
	 * 
	 * @param <strong>listaE</strong> la lista delle tipologie di esame create
	 * @param <strong>listaM</strong> la lista delle malattie create
	 * @param scelta <strong>1</strong> se si preimposta di creare un esame diagnostico <strong>2</strong> se periodico misurabile
	 * 
	 * @return l'<strong>esame</strong> creato se non si generano eccezioni, <strong>null</strong> altrimenti
	 */
	public static EsameEffettuato creaEsameEffettuato(ListaEsame listaE, ArrayList<Malattia> listaM, int scelta){
		boolean valido = false;
		
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
				stampaMex(ERRORE_INS);
		}
		return null;
	}
	
	/**
	 * Overload di creaEsameEffettuato che permette di essere chiamato da altri metodi o dall'utente preimpostando la scelta della
	 * tipologia di esame da creare e passando la tipologia di esame
	 * 
	 * @param <strong>listaE</strong> la lista delle tipologie di esame create
	 * @param <strong>listaM</strong> la lista delle malattie create
	 * @param scelta <strong>1</strong> se si preimposta di creare un esame diagnostico <strong>2</strong> se periodico misurabile
	 * 
	 * @return l'<strong>esame</strong> creato se non si generano eccezioni, <strong>null</strong> altrimenti
	 */
	public static EsameEffettuato creaEsameEffettuato(Esame esameTipo, ArrayList<Malattia> listaM, int scelta){
		boolean valido = false;
		
		switch(scelta){
			case 1:	//Diagnostico
				EsameDiagnostico eAss = (EsameDiagnostico) esameTipo;
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
				EsamePeriodicoMisurabile eAssP = (EsamePeriodicoMisurabile) esameTipo;
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
				stampaMex(ERRORE_INS);
		}
		return null;
	}
	
	/**
	 * Overload di creaEsameEffettuato che crea un oggetto EsameEffettuato di tipo basato su quello dell'oggetto Esame 
	 *
	 * @param <strong>esame</strong> il tipo di esame
	 * @param <strong>listaM</strong> la lista delle malattie create
	 * @return l'<strong>esame effettuato</strong> se non si generano eccezioni, <strong>null</strong> altrimenti
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
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la creazione di un esame prenotato (effettuato senza esito)
	 * @param <strong>listaE</strong> la lista delle tipologie di esame create
	 * @param <strong>listaM</strong> la lista delle malattie dell'utente
	 * 
	 * @return <strong>Esame Prenotato</strong> se non si incontrano eccezioni, <strong>null</strong> altrimenti
	 * @author Martinelli Giuseppe
	 */
	public static EsameEffettuato creaEsamePrenotato(ListaEsame listaE, ArrayList<Malattia> listaM){
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
				String esito = MyInput.leggiStringaNonVuota(E_MEX_INS_ESITO);
				
				EDiagnosticoEffettuato ed1 = null;
				try{
					ed1 = new EDiagnosticoEffettuato(eAss, mAss, luogo, data, ora, esito);
				}
				catch(IllegalAccessException e){
					e.printStackTrace();
					return null;
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
				double esitoP = MyInput.leggiDoubleConMinimo(E_MEX_INS_ESITO,0);
				
				EPeriodicoMisurabileEffettuato ep1 = null;
				try{
					ep1 = new EPeriodicoMisurabileEffettuato(eAssP, mAssP, luogoP, dataP, oraP, esitoP);
				}
				catch(IllegalAccessException e){
					e.printStackTrace();
					return null;
				}
				return ep1;
			default:
				stampaMex(ERRORE_INS);
		}
		return null;
	}
	
	/**
	 * Metodo che crea un oggetto di tipo Malattia permettendo all'utente di inserire i dati desiderati
	 * 
	 * @param <strong>listaE</strong> la lista delle tipologie di esame create
	 * @return la <strong>malattia</strong> creata
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
	 * Metodo che crea un oggetto della classe cartellaSanitaria
	 * @return la <strong>Cartella Sanitaria</strong> creata
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
				stampaMex(ERRORE_INS);
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
				stampaMex(ERRORE_INS);
				stampaMex(" ");
			}
		}while(!valido);
		
		String luogoN = MyInput.leggiStringaNonVuota(P_MEX_INS_LUOGON);
		
		//Controlla se la data di nascita inserita dall'utente risulta valida o meno
		valido = false;
		Date dataN = null;
		do{
			String data = MyInput.leggiStringaNonVuota(P_MEX_INS_DATAN);
			dataN = MyTime.creaData(data);
			if((dataN != null) && CartellaSanitaria.checkDataNascita(data))
				valido = true;
			else{
				stampaMex(ERRORE_INS);
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
				stampaMex(ERRORE_INS);
				stampaMex(" ");
			}
		}while(!valido);
		
		//Controlla il gruppo sanguigno
		valido = false;
		String gruppoS = "";
		do{
			gruppoS = MyInput.leggiStringaNonVuota(P_MEX_INS_GSANGUIGNO);
			if(CartellaSanitaria.checkGruppoSanguigno(gruppoS))
				valido = true;
			else{
				stampaMex(ERRORE_INS);
				stampaMex(" ");
			}
		}while(!valido);
		
		CartellaSanitaria cs = new CartellaSanitaria(nome, cognome, indirizzo, telefono, mail, dataN, luogoN, genereP, codiceF, gruppoS);
		return cs;
	}
	
	// Modifica
	/** 
	 * Crea, mostra ed esegue le opzioni relative ad un menu' per la modifica dei dati di un esame
	 * @param <strong>esame</strong> l'esame da modificare
	 * @param <strong>listaE</strong> la lista delle tipologie di esame create
	 * 
	 * @author Martinelli Giuseppe
	 */
	public static void modificaEsame(Esame esame){
		int scelta = 0;
		MyMenu menuModificaEsame = new MyMenu(MODIFICA_INFO_E, E_OPZIONI_MODIFICA);
		do{
			scelta = menuModificaEsame.scegli();
		
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
					stampaMex(ERRORE_INS);
			}
		}while(scelta != 0);
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati di un esame effettuato
	 * @param <strong>esame</strong> l'esame effettuato da modificare
	 * @param <strong>listaE</strong> la lista delle tipologie di esame create
	 * @param <strong>CS</strong> la cartella sanitaria della quale fa parte l'esame
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaEsameEffettuato(EsameEffettuato esame, ListaEsame listaE, CartellaSanitaria CS){
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
					stampaMex(ERRORE_INS);
			}
		}while(scelta != 0);
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati di una malattia
	 * @param <strong>malattia</strong> la malattia da modificare
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaMalattia(Malattia malattia){
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
					stampaMex(ERRORE_INS);
			}
		}while(scelta != 0);
	}
	
	/** 
	 * Crea, mostra ed effettua le opzioni relative ad un menu' per la modifica dei dati utente della cartella sanitaria
	 * che permette di modificare tutti i dati anagrafici ma anche di aggiungere/modificare/togliere un esame effettuato o una malattia
	 * 
	 * @param <strong>CS</strong> la cartella sanitaria da modificare
	 * 
	 * @author Valtulini Claudio
	 */
	public static void modificaCartellaSanitaria(CartellaSanitaria CS, ListaEsame listaE){
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
							stampaMex(ERRORE_INS);
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
							stampaMex(ERRORE_INS);
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
							stampaMex(ERRORE_INS);
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
							stampaMex(ERRORE_INS);
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
							stampaMex(ERRORE_INS);
						}
					}while(!valido);
					CS.setGruppoSanguigno(gruppoS);
					break;
				case 11: //aggiungi effettuato
					aggiungiEffettuato(CS, listaE);
					break;
				case 12: //aggiungi malattia
					creaMalattia(listaE);
					break;
				case 13: //modifica effettuato
					String nomeModificaE = MyInput.leggiStringaNonVuota(E_MEX_CANCELLA_NOME);
					if(CS.isEsameEsistente(nomeModificaE)){
						if(CS.contaEsame(nomeModificaE) > 1){
							Date dataEsame = MyInput.leggiData(E_MEX_PIU_ESAMI + " " + E_MEX_CANCELLA_DATA);
							modificaEsameEffettuato(CS.cercaEsame(nomeModificaE, dataEsame), listaE, CS);
						}
						else{
							modificaEsameEffettuato(CS.cercaEsame(nomeModificaE), listaE, CS);
						}
					}
					break;
				case 14: //modifica malattia
					String nomeModificaM = MyInput.leggiStringaNonVuota(M_MEX_CANCELLA);
					if(CS.isMalattiaEsistente(nomeModificaM)){
						if(CS.contaMalattiaEsistente(nomeModificaM) > 1){
							Date dataInizio = MyInput.leggiData(M_MEX_PIU_MALATTIE + " " + M_MEX_CANCELLA_DATAI);
							modificaMalattia(CS.cercaMalattia(nomeModificaM, dataInizio));
						}
						else{
							modificaMalattia(CS.cercaMalattia(nomeModificaM));
						}
					}
					break;
				case 15: //rimuovi effettuato
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
				case 16: //rimuovi malattia
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
				stampaMex(ERRORE_INS);
			}
		}while(scelta != 0);
	}
	
	// Aggiungi
	/**
	 * Crea un oggetto di tipo EsameEffettuato e lo aggiunge alla lista di esami della cartella sanitaria passata come parametro
	 * permette di scegliere se creare un esame diagnostico o periodico misurabile (effettuati) creando un nuovo oggetto Esame
	 * o cercandolo tra quelli esistenti
	 * 
	 * @param <strong>CS</strong> la cartella sanitaria alla quale va aggiunto l'esame effettuato
	 * @param <strong>listaE</strong> la lista di tipologie di esame create
	 * 
	 * @author Valtulini Claudio
	 */
	public static void aggiungiEffettuato(CartellaSanitaria CS, ListaEsame listaE){
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
						case 1: //Diagnostico
							EsameDiagnostico esameD = (EsameDiagnostico) creaEsame(scelta2);
							listaE.aggiungiEsame(esameD);
							CS.getEsamiEffettuati().add(creaEsameEffettuato(esameD, CS.getElencoMalattia(), scelta2));
							break;
						case 2: //Periodico Misurabile
							EsamePeriodicoMisurabile esamePM = (EsamePeriodicoMisurabile) creaEsame(scelta2);
							listaE.aggiungiEsame(esamePM);
							CS.getEsamiEffettuati().add(creaEsameEffettuato(esamePM, CS.getElencoMalattia(), scelta2));
							break;
						default:
							stampaMex(ERRORE_INS);
					}
					break;
				case 2:
					String daCercare = null;
					Esame esame = null;
					do{
						daCercare = MyInput.leggiStringaNonVuota(E_MEX_CERCA);
						esame = listaE.cercaEsame(daCercare);
					}while(esame == null);
				
					CS.getEsamiEffettuati().add(creaEsameEffettuato(esame, CS.getElencoMalattia()));
					break;
				case 0:
					break;
				default:
					stampaMex(ERRORE_INS);
			}
		}while(scelta != 0);
	}
	
	// Statistiche Periodico Misurabile FORSE da spostare in EsamEffettuato / EPeriodicoEffettuato ?
	
	
	/* Oggetti da pre-creare salvati per esame
	 * 4 tipologie di esami
	 * 6 esami misurabili dello stesso tipo (6 effettuati)
	 * 3 esami diagnostici dello stesso tipo (3 effettuati)
	 * 3 esami prenotati (senza esito)
	*/
	/**
	 * Creazione guidata di 4 tipologie di esami, 6 esami misurabili effettuati dello stesso tipo, 3 esami diagnostici effettuuati dello stesso tipo, 3 esami prenotati nella cartella sanitaria
	 * @param CS Cartella Sanitaria nella quale verrano prese le informazioni degli utenti
	 * @param listaE lista tipologie esami
	 * @param listaEE lista esami effettuati/prenotati
	 * @param listaM lista malattia
	 */
	public static void creazioneGuidata(CartellaSanitaria CS, ListaEsame listaE){
		/*CREAZIONE 4 TIPOLOGIE ESAME*/
		ArrayList<EsameEffettuato> listaEE = CS.getEsamiEffettuati();
		ArrayList<Malattia> listaM = CS.getElencoMalattia();
		for(int i=0; i<4; i++){
			Esame e1 = creaEsame();
			listaE.aggiungiEsame(e1);
		}
		
		/*CREAZIONE 6 ESAMI MISURABILI EFFETTUATI DELLO STESSO TIPO EFFETTUATI*/
		//Prima scelgo il tipo di esame su cui creare gli effettuati
		ArrayList<EsamePeriodicoMisurabile> listaEPM = EsamePeriodicoMisurabile.selezionaEsamePMisurabili(listaE);
		int DIM = listaEPM.size();
		String[] nomiEsami = new String [DIM];
		for(int i=0; i<listaEPM.size(); i++){
			nomiEsami[i] = listaEPM.get(i).getNome();
		}
		MyMenu menuEME = new MyMenu("Scegli un esame misurabile di cui creare 6 esami effettuati", nomiEsami);
		int sceltaEME = menuEME.scegli(); 
		if(sceltaEME!=0){//E' stato scelto un esame misurabile su cui creare i 6 effettuati
			EsamePeriodicoMisurabile esameScelto = listaEPM.get(sceltaEME);
			for(int j=0; j<6; j++){
				boolean valido = false;
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
				double esito = MyInput.leggiDoubleConMinimo(E_MEX_INS_ESITO,0);
				
				try{
					EPeriodicoMisurabileEffettuato eInserito= new EPeriodicoMisurabileEffettuato(esameScelto, mAss, luogo, data, ora, esito);
					//EPM CREATO, ADESSO LO AGGIUNGO ALLA LISTA DEGLI ESAMI
					listaEE.add(eInserito);
				}
				catch(IllegalAccessException e){
					e.printStackTrace();
				}
			}
		}
		
		
		/*CREAZIONE 3 ESAMI DIAGNOSTICI EFFETTUATI DELLO STESSO TIPO EFFETTUATI*/
		//Prima scelgo il tipo di esame su cui creare gli effettuati
				ArrayList<EsameDiagnostico> listaD = EsameDiagnostico.selezionaEsameDiagnostico(listaE);
				int DIMD = listaD.size();
				String[] nomiEsamiD = new String [DIMD];
				for(int i=0; i<listaD.size(); i++){
					nomiEsami[i] = listaD.get(i).getNome();
				}
				MyMenu menuED = new MyMenu("Scegli un esame diagnostico di cui creare 3 esami effettuati", nomiEsamiD);
				int sceltaED = menuED.scegli(); 
				if(sceltaED!=0){//E' stato scelto un esame misurabile su cui creare i 6 effettuati
					EsameDiagnostico esameSceltoD = listaD.get(sceltaED);
					for(int j=0; j<6; j++){
						boolean valido = false;
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
						String esito = MyInput.leggiStringaNonVuota(E_MEX_INS_ESITO);
						try{
							EDiagnosticoEffettuato eInserito = new EDiagnosticoEffettuato(esameSceltoD, mAss, luogo, data, ora, esito);
							listaEE.add(eInserito);
						}
						catch(IllegalAccessException e){
							e.printStackTrace();
						}
					}
				}
				
		/*3 ESAMI PRENOTATI (SENZA ESITO)*/
		for(int i=0; i<3;i++){
			EsameEffettuato eIns = creaEsamePrenotato(listaE, listaM);
			listaEE.add(eIns);
		}
		
		//SALVO TUTTO NELLA CARELLA SANITARIA
		CS.setElencoMalattia(listaM);
		CS.setEsamiEffettuati(listaEE);
	}
	
	/* Cosa si dovrebbe fare nel main secondo la traccia (mia interpretazione V)
	 * (partendo dalla visualizzazione dell'utente, no scelte, no operazioni di caricamento)
	 * Visualizzo nome e cognome
	 * 	con elenco esami
	 * 		nome e data, se periodici valore esito
	 * 	con elenco malattie
	 * 
	 * Dopo chiedo se
	 * 	Main
	 * 		Richieste Cartella
	 * 			visualizzare tutti i dati anagrafici
	 * 				visualizzacompleto()
	 *  		scegliere un esame e visualizzarlo completamente
	 *  			visualizzacompleto()
	 *  		scegliere una malattia e visualizzarla completamente
	 *  			visualizzacompleto()
	 * 			Scegliere una tipologia di esame e
	 * 				visualizzare tutte le misurazioni data + esito
	 * 				visualizzare valore max e min e superamenti di soglia + date
	 * 					gestire max e min multipli (presumo si intenda più valori uguali in date diverse) (fatto)
	 * 				visualizzare valore medio (media dei valori o valore più vicino alla media? presumo la prima)
	 *  		Modifica Cartella
	 *  			Aggiungi/Modifica/Rimuovi Effettuato
	 *  			Aggiungi/Modifica/Rimuovi Malattia
	 *  Main
	 *  	Aggiungi Tipologia Esame
	 *  	Modifica Tipologia Esame
	 *  	Rimuovi Tipologia Esame
	 * 
	 */
	
	public static void richiesteCartellaSanitaria(CartellaSanitaria CS, ListaEsame listaE, ArrayList<Malattia> listaM){
		
		int scelta = 0;
		MyMenu menuRichieste = new MyMenu("Cosa si desidera fare?", OPZIONI_RICHIESTE);
		
		do{
			scelta = menuRichieste.scegli();
			
			switch(scelta){
				case 1:
					if(CS.getEsamiEffettuati() != null && CS.getElencoMalattia() != null){
						stampaMex(CS.toStringCompleto());
					}
					else{
						stampaMex(ERRORE_MANCA_ESAME_MALATTIA);
					}
					break;
				case 2:
					//scelgo e visualizzo esame
					int visualizzaE = MyInput.leggiInteroConMinimo(E_SCELTA_VISUALIZZA, 1);
					if((visualizzaE - 1) < CS.getEsamiEffettuati().size()){
						CS.getEsamiEffettuati().get(visualizzaE - 1).toStringCompleto();
					}
					else{
						stampaMex(ERRORE_INS);
					}
					break;
				case 3:
					//scelgo e visualizzo malattia
					int visualizzaM = MyInput.leggiInteroConMinimo(M_SCELTA_VISUALIZZA, 1);
					if((visualizzaM - 1) < CS.getElencoMalattia().size()){
						CS.getElencoMalattia().get(visualizzaM - 1).toStringCompleto();
					}
					else{
						stampaMex(ERRORE_INS);
					}
					break;
				case 4:
					//controllare i toString se visualizzano le richieste
					String tipologia = null;
					ArrayList<EsameEffettuato> simili = null;
					do{
						tipologia = MyInput.leggiStringaNonVuota(E_MEX_INS_TIPOLOGIA);
						simili = EsameEffettuato.selezionaTipologiaEsame(CS.getEsamiEffettuati(), tipologia);
						if(simili.size() == 0){
							stampaMex(ERRORE_TIPOLOGIA_INESISTENTE);
						}
					}while(simili.size() == 0);
					
					//+ date i seguenti ?? (controllare se si visualizzano le date)
					stampaMex("Esito massimo: ");
					for(EPeriodicoMisurabileEffettuato elemento: EPeriodicoMisurabileEffettuato.esameEsitoMax(simili)){
						stampaMex(elemento.toString());
					}
					
					stampaMex("Esito minimo: ");
					for(EPeriodicoMisurabileEffettuato elemento: EPeriodicoMisurabileEffettuato.esameEsitoMin(simili)){
						stampaMex(elemento.toString());
					}
					
					stampaMex("Esami con esito oltre soglia: ");
					for(EPeriodicoMisurabileEffettuato elemento: EPeriodicoMisurabileEffettuato.esameOltreSoglia(simili)){
						stampaMex(elemento.toString());
					}
					
					stampaMex("Esito Medio: " + EPeriodicoMisurabileEffettuato.esameEsitoMedio(simili));
					break;
				case 5:
					modificaCartellaSanitaria(CS, listaE);
					break;
				case 0:
					break;
				default:
					stampaMex(ERRORE_INS);
			}
		}while(scelta != 0);
	}
	
	/**
	 * Metodo che elimina un'esame all'interno di una listaEsame ricercato per nome. Se inesistente viene viusalizzato un messaggio di errore
	 * 
	 * @param listaE la lista in cui ricercare l'esame da eliminare
	 * 
	 * @author Manenti Gabriele
	 */
	public static void eliminaEsame(ListaEsame listaE){
		String nomeEsame = MyInput.leggiStringaNonVuota(E_MEX_CANCELLA_NOME);
		if(listaE.isEsistente(nomeEsame)){
			boolean rimuovi = MyInput.yesOrNo(String.format(E_MEX_RIC_RIMUOVI, nomeEsame));
			if(rimuovi){
				listaE.rimuoviEsame(listaE.cercaEsame(nomeEsame));
			}
		}
		else{
			System.out.println(ERRORE_ESAME_NON_TROVATO);
		}
	}

	/*Main*/
	public static void main(String[] args) {
		stampaMex(MEX_BENVENUTO);
		
		boolean visualizzato = false;
		boolean caricato = false;
		boolean valido = false;
		CartellaSanitaria CS = null;

		ArrayList<Esame> lista = new ArrayList<Esame>();
		ArrayList<Malattia> listaM = new ArrayList<Malattia>();
		ListaEsame listaE = new ListaEsame(lista);

		File file = new File(PATH);
		
		//SE ESISTE IL FILE LO CARICO
		if (file.exists()){
			CS = (CartellaSanitaria) MyServizioFile.caricaSingoloOggetto(file);
			caricato = true;
		}
		
		/*INIZIO CON I MENU: PRIMO MENU PER SCEGLIERE SE CREARE CARTELLA O FARE RICHIESTE TRACCIA (VISUALIZZAZIONE ECC.) */
		int sceltaI=0;
		
		do{
			MyMenu menuGenerale = new MyMenu("Cartella Sanitaria", OPZIONI_I);
			sceltaI = menuGenerale.scegli();
			switch(sceltaI){
				case 1:	/*CREARE CARTELLA SANITARIA*/
					/*PRIMA OPERAZIONE DA EFFETTUARE: CONTROLLO SE ESISTE GIA' UN FILE OPPURE NO*/
					if (CS != null){
						// FILE ESISTENTE, CHIEDO SE SI VUOLE SOVRASCRIVERE OPPURE CARICARE I DATI PRECEDENTI
						boolean scelta = MyInput.yesOrNo(MEX_SOVRASCIVERE);
						if(scelta){	//SOVRASCIVO
							CS = creaCartellaSanitaria();
							//FINITO DI RICREARE IL FILE
							MyServizioFile.salvaSingoloOggetto(file, CS);
						}
						else{//CARICO I DATI PRECEDENTI
							CS = (CartellaSanitaria) MyServizioFile.caricaSingoloOggetto(file);
							caricato = true;
						}
					}
					else{
						MyServizioFile.creaFile(PATH);
						CS = creaCartellaSanitaria();
					}
					break;
					
				case 2:	/*RICHIESTE/ (Tipologia Esame) AGGIUNGI / MODIFICA / ELIMINA*/
					int sceltaD = 0;
					
					do{
						if((caricato == true) && (visualizzato == false) && ((CS.getEsamiEffettuati() != null) || (CS.getElencoMalattia() != null))){
							CS.toString();
							visualizzato = true;
						}
						else if((caricato == true) && !visualizzato && ((CS.getEsamiEffettuati() == null) || (CS.getElencoMalattia() == null))){
							stampaMex(ERRORE_MANCA_ESAME_MALATTIA);
						}
						
						MyMenu menuD = new MyMenu("Operazioni possibili", OPZIONI_D);
						sceltaD = menuD.scegli();
						switch(sceltaD){
							case 1: //richieste
								richiesteCartellaSanitaria(CS, listaE, listaM);
								break;
							case 2:	/*AGGIUNGI tipologia esame*/
								creaEsame();
								break;
							case 3: /*Modifica tipologia esame*/
								String nomeModifica = null;
								valido = false;
								do{
									nomeModifica = MyInput.leggiStringaNonVuota(E_MEX_MODIFICA);
									if(listaE.isEsistente(nomeModifica)){
										modificaEsame(listaE.cercaEsame(nomeModifica));
										valido = true;
									}
									else{
										stampaMex(ERRORE_ESAME_NON_TROVATO);
									}
								}while(!valido);
								break;
							case 4: /*ELIMINA tipologia esame*/
								eliminaEsame(listaE);
								break;
							default:
								/*ERRORE*/
								stampaMex(ERRORE_INS);
						}
					}while(sceltaD!=0);
					break;
				default:
					/*ERRORE SCELTA NON VALIDA*/
				}
		}while(sceltaI!=0);
		stampaMex(MEX_USCITA);
	}
}
