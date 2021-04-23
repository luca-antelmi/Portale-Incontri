package org.corso.portaleIncontri;

import java.util.*;
import org.corso.portaleIncontri.exceptions.ErroreUtenteGiaPresenteException;

public class GestoreRegistrazione {

    public GestoreRegistrazione() {

    }

    public void registra(Map<String, Utente> utenti, String userName, String nome, String cognome, int eta,
            String genere, String coloreOcchi, int altezza) throws ErroreUtenteGiaPresenteException {
        if (utenti.containsKey(userName))
            throw new ErroreUtenteGiaPresenteException();
        Utente utente = new Utente(userName, nome, cognome, eta, genere, coloreOcchi, altezza);
        utenti.put(userName, utente);

    }

    public void inserisciPreferenza(Utente utente, int etaMin, int etaMax, String genere, String coloreOcchi,
            int altezzaMin, int altezzaMax) {
        Preferenza preferenza = new Preferenza(etaMin, etaMax, genere, coloreOcchi, altezzaMin, altezzaMax);
        utente.setPreferenza(preferenza);
    }

}
