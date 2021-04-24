package org.corso.portaleIncontri;

import java.util.*;

import org.corso.portaleIncontri.exceptions.ErroreParametriInIngressoException;
import org.corso.portaleIncontri.exceptions.ErroreUtenteGiaPresenteException;

public class GestoreRegistrazione {

    public GestoreRegistrazione() {

    }

    public void registra(Map<String, Utente> utenti, String userName, String nome, String cognome, Integer eta,
            String genere, String coloreOcchi, Integer altezza)
            throws ErroreUtenteGiaPresenteException, ErroreParametriInIngressoException {
        if (utenti.containsKey(userName))
            throw new ErroreUtenteGiaPresenteException();
        if (utenti == null | userName == null | nome == null | cognome == null | eta == null | genere == null
                | coloreOcchi == null | altezza == null)
            throw new ErroreParametriInIngressoException();
        Utente utente = new Utente(userName, nome, cognome, eta, genere, coloreOcchi, altezza);

        // creazione di una preferenza di default che accetta tutto
        Preferenza preferenza = new Preferenza(0, 999, "all", "all", 0, 9999);
        utente.setPreferenza(preferenza);
        utenti.put(userName, utente);

    }

    public void inserisciNuovaPreferenza(Utente utente, Integer etaMin, Integer etaMax, String genere,
            String coloreOcchi, Integer altezzaMin, Integer altezzaMax) throws ErroreParametriInIngressoException {
        if (utente == null | etaMin == null | etaMax == null | genere == null | coloreOcchi == null | altezzaMin == null
                | altezzaMax == null)
            throw new ErroreParametriInIngressoException();
        if (etaMin < 0 | etaMax < 0 | altezzaMin < 0 | altezzaMax < 0)
            throw new ErroreParametriInIngressoException();
        Preferenza preferenza = new Preferenza(etaMin, etaMax, genere, coloreOcchi, altezzaMin, altezzaMax);
        utente.setPreferenza(preferenza);
    }

}
