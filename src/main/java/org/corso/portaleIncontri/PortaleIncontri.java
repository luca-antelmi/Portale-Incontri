package org.corso.portaleIncontri;

import java.util.*;

import org.corso.portaleIncontri.exceptions.ErroreParametriInIngressoException;
import org.corso.portaleIncontri.exceptions.ErroreRegistrazioneException;
import org.corso.portaleIncontri.exceptions.ErroreUtenteGiaPresenteException;
import org.corso.portaleIncontri.exceptions.ErroreUtenteInestenteException;

public class PortaleIncontri {
    private Map<String, Utente> utenti;
    private GestoreRegistrazione gestoreRegistrazione;
    private GestoreMatching gestoreMatching;

    public PortaleIncontri() {
        this.utenti = new HashMap<>();
        this.gestoreRegistrazione = new GestoreRegistrazione();
        this.gestoreMatching = new GestoreMatching();
    }

    public void registrazioneUtente(String userName, String nome, String cognome, int eta, String genere,
            String coloreOcchi, int altezza) throws ErroreRegistrazioneException {
        if (userName == null | nome == null | cognome == null | eta == 0 | genere == null | coloreOcchi == null
                | altezza == 0)
            throw new ErroreRegistrazioneException();
        try {
            gestoreRegistrazione.registra(utenti, userName, nome, cognome, eta, genere, coloreOcchi, altezza);
        } catch (ErroreUtenteGiaPresenteException e) {
            e.printStackTrace();
        }
    }

    public void nuovaPreferenza(Utente utente, int etaMin, int etaMax, String genere, String coloreOcchi,
            int altezzaMin, int altezzaMax) throws ErroreUtenteInestenteException {
        if (!utenti.containsKey(utente.getUserName()))
            throw new ErroreUtenteInestenteException();
        gestoreRegistrazione.inserisciPreferenza(utente, etaMin, etaMax, genere, coloreOcchi, altezzaMin, altezzaMax);
    }

    public List<Utente> doMatch(Utente utente) throws ErroreUtenteInestenteException {
        List<Utente> result = null;
        if (utente == null)
            throw new ErroreUtenteInestenteException();
        try {
            result = gestoreMatching.match(utente, utenti);
        } catch (ErroreParametriInIngressoException e) {
            e.printStackTrace();
        }
        return result;
    }
}