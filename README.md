# progetto-siw-2017
- Autori del Progetto: Nicholas Napolitano - Simone Pellegrini 
         (Contatti --> file "contatti_Sviluppatori")
- Sistema informativo su Web per la gestione di una piccola galleria d’arte.
- Possono accedere al sistema utenti generici e un amministratore.
- L’amministratore,  previa  autenticazione, può  inserire  e  rimuovere  le  informazioni  relative alle opere d’arte presenti nella galleria.
- Un utente non autenticato può visionare la lista delle opere della galleria
- Un utente registrato, previa autenticazione, può visionare le opere d'arte in toto oppure visionare tutti gli autori della galleria e per ognuno di essi visionarne i quadri. Inoltre, di ogni quadro può avere una schermata di dettaglio in cui se ne può vedere l'immagine
- Per semplicità, supponiamo che l'amministratore abbia solo il compito di manipolare le informazioni di quadri ed autori della Galleria e che gli utenti invece abbiano la sola possibilità di visionarli.
- Per semplicità supponiamo che le opere d’arte siano quadri e che per ciascuno di essi siano di interesse il titolo, l’anno in cui è stato realizzato, la tecnica, le  dimensioni,  l’autore.  
- Dell’autore  sono  di  interesse  nome,  cognome,  nazionalità  data  di nascita e data di morte.
- L’utente  generico  può  accedere  alle  informazioni  della  galleria  attraverso  diversi  percorsi  di navigazione, opportunamente predisposti.
- Ogni operazione del sistema corrisponde ad un caso d'uso (Autenticazione, registrazione, visualizzazione quadri etc). Per una descrizione più dettagliata dei Casi d'Uso e degli sviluppi futuri degli stessi e dell'intera piattaforma, si prega di visionare il file testuale "Casi d'Uso".
- Gestione della persistenza tramite Base di Dati (monitorata attraverso PgAdmin)
- Implementazione di algoritmo di cifratura delle password di Amministratore ed Utenti
- Implementazione delle pagine Web tramite HTML
- FrameWork utilizzato: JSF
- Linguaggio di stile utilizzato: CSS
- Implementazione grafica tramite Bootstrap
- Pre visualizzare lo Schema della Base di Dati e le Politiche di Fetch e Cascade utilizzate per le classi modello visionare il file pdf     "schema_basi_dati.pdf"
- Per visionare il Class Diagram delle classi modello visionare il file "class_diagram"
- Deploy (funzionante) su server Cloud AWS: 
       indirizzo -> http://34.210.163.175:8080/siw-progetto-2017/    
       Database gestito da istanza RDS
