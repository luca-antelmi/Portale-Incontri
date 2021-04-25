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

    public void registrazioneUtente(String userName, String nome, String cognome, Integer eta, String genere,
            String coloreOcchi, Integer altezza) throws ErroreRegistrazioneException {
        if (userName == null | nome == null | cognome == null | eta == null | genere == null | coloreOcchi == null
                | altezza == null)
            throw new ErroreRegistrazioneException();
        if (eta < 0 | altezza < 0)
            throw new ErroreRegistrazioneException();

        try {
            gestoreRegistrazione.registra(utenti, userName, nome, cognome, eta, genere, coloreOcchi, altezza);
        } catch (ErroreUtenteGiaPresenteException | ErroreParametriInIngressoException e) {
            e.printStackTrace();
        }
    }

    public void nuovaPreferenza(Utente utente, Integer etaMin, Integer etaMax, String genere, String coloreOcchi,
            Integer altezzaMin, Integer altezzaMax)
            throws ErroreUtenteInestenteException, ErroreParametriInIngressoException {
        if (utente == null | etaMin == null | etaMax == null | genere == null | coloreOcchi == null | altezzaMin == null
                | altezzaMax == null)
            throw new ErroreParametriInIngressoException();
        if (etaMin < 0 | etaMax < 0 | altezzaMin < 0 | altezzaMax < 0)
            throw new ErroreParametriInIngressoException();
        if (!utenti.containsKey(utente.getUserName()))
            throw new ErroreUtenteInestenteException();
        try {
            gestoreRegistrazione.inserisciNuovaPreferenza(utente, etaMin, etaMax, genere, coloreOcchi, altezzaMin,
                    altezzaMax);
        } catch (ErroreParametriInIngressoException e) {
            e.printStackTrace();
        }
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