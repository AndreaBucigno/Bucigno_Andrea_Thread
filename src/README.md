# Produzione Camicie - Bucigno Andrea
Simulatore di processo per la produzione di camicie in Java, che utilizza thread paralleli per rappresentare le diverse fasi della catena di produzione.

## Descrizione

Questo progetto implementa una simulazione realistica del processo di produzione di camicie utilizzando i thread Java. Ogni fase della produzione viene eseguita da un thread separato, con sincronizzazione tra le fasi per garantire il corretto flusso del processo di produzione.

## Fasi di Produzione

Il processo è suddiviso in 3 fasi principali:

1. **Taglio del Tessuto** - Preparazione e taglio del tessuto secondo i cartamodelli
2. **Cucitura** - Assemblaggio di corpo, maniche, colletto e applicazione bottoni
3. **Controllo Qualità** - Ispezione finale, confezionamento ed etichettatura

Ogni fase attende il completamento della fase precedente (tramite `join()`) prima di iniziare.

## Funzionalità

- **Produzione simulata**: Avvia un ciclo completo di produzione con tutte le fasi
- **Sincronizzazione**: Le fasi si susseguono in ordine corretto grazie a `Thread.join()`
- **Temporizzazione realistica**: Ogni fase utilizza `Thread.sleep()` per simulare il tempo di lavorazione
- **Statistiche**: Visualizza il numero totale di camicie prodotte

## Struttura del Progetto

```
src/
├── ProduzioneCamicie.java       # Classe principale con menu e coordinamento
├── TagliatoreTessuto.java       # Thread fase 1: taglio tessuto
├── CucitoreCamicie.java         # Thread fase 2: cucitura
└── ControlloQualita.java        # Thread fase 3: controllo qualità
```

## Componenti Principali

### ProduzioneCamicie.java
Classe principale che gestisce:
- Menu interattivo a console
- Coordinamento delle fasi di produzione
- Sincronizzazione tra i thread tramite `join()`
- Statistiche di produzione

### Thread di Produzione
Ogni thread rappresenta una fase specifica:
- **TagliatoreTessuto**: Taglia il tessuto secondo i cartamodelli (300ms per camicia)
- **CucitoreCamicie**: Cuce corpo, maniche, colletto e applica bottoni (700ms per camicia)
- **ControlloQualita**: Controlla e confeziona le camicie (400ms per camicia)

## Come Usare

### Menu Opzioni

1. **Avvia produzione**: Inserisci il numero di camicie da produrre e avvia il ciclo
2. **Visualizza statistiche**: Mostra il totale delle camicie prodotte nella sessione
3. **Pulisci lo schermo** : pulische lo schermo della bash andando a capo di 50 righe
4.  **Esci**: Chiude il programma

### Esempio di Utilizzo

```
1. Seleziona "Avvia produzione"
2. Inserisci il numero di camicie (es: 5)
3. Osserva l'avanzamento di ogni fase
4. Visualizza le statistiche per il totale sessione
```

## Output di Esempio

```
FASE 1 - TAGLIO =>  Inizio taglio tessuto per 3 camicie...
FASE 1 - TAGLIO =>  Postazione di taglio pronta, cartamodelli posizionati
FASE 1 - TAGLIO =>  Tessuto tagliato per camicia n.1 (1/3)
FASE 1 - TAGLIO =>  Tessuto tagliato per camicia n.2 (2/3)
FASE 1 - TAGLIO =>  Tessuto tagliato per camicia n.3 (3/3)
FASE 1 - TAGLIO =>  Fase di taglio completata! Totale: 3 set di pezzi pronti

FASE 2 - CUCITURA => Inizio cucitura camicie...
FASE 2 - CUCITURA => Macchine da cucire pronte
FASE 2 - CUCITURA => Camicia n.1 cucita (corpo, maniche, colletto, bottoni) - (1/3)
FASE 2 - CUCITURA => Camicia n.2 cucita (corpo, maniche, colletto, bottoni) - (2/3)
FASE 2 - CUCITURA => Camicia n.3 cucita (corpo, maniche, colletto, bottoni) - (3/3)
FASE 2 - CUCITURA => Fase di cucitura completata! Totale: 3 camicie cucite

FASE 3 - Controllo QUALITÀ => Inizio controllo qualità finale...
FASE 3 - Controllo QUALITÀ => Postazione di controllo pronta
FASE 3 - Controllo QUALITÀ => Camicia n.1 controllata e confezionata (1/3)
FASE 3 - Controllo QUALITÀ => Camicia n.2 controllata e confezionata (2/3)
FASE 3 - Controllo QUALITÀ => Camicia n.3 controllata e confezionata (3/3)
FASE 3 - Controllo QUALITÀ => Tutte le camicie hanno superato il controllo qualità!
FASE 3 - Controllo QUALITÀ => Fase finale completata! 3 camicie pronte per la spedizione

=================================================================
    PRODUZIONE COMPLETATA CON SUCCESSO!
=================================================================
Camicie prodotte: 3
Tempo totale: 5 secondi
Totale camicie completate nella sessione: 3
=================================================================
```

## Requisiti

- Java JDK 8 o superiore

## Dettagli Tecnici

### Threading e Sincronizzazione
Ogni camicia passa attraverso tutte le fasi in sequenza. La sincronizzazione è gestita tramite:
- `Thread.start()` per avviare ogni fase
- `Thread.join()` per attendere il completamento della fase precedente
- `Thread.sleep()` per simulare i tempi di lavorazione (RICHIESTO dalla consegna)

### Flusso di Esecuzione
```
Taglio → join() → Cucitura → join() → Controllo → Fine
```

Ogni thread padre attende il completamento del thread figlio prima di procedere, garantendo che le fasi vengano eseguite nell'ordine corretto.

## Licenza

Progetto a scopo didattico