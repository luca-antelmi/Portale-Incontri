package org.corso.portaleIncontri;

import java.util.*;

import org.corso.portaleIncontri.exceptions.ErroreParametriInIngressoException;

public class GestoreMatching {

    public GestoreMatching() {

    }

    public List<Utente> match(Utente utente, Map<String, Utente> utenti) throws ErroreParametriInIngressoException {
        if (utente == null | utenti == null)
            throw new ErroreParametriInIngressoException();
        if (utente.getPreferenza().getLikeAltezzaMin() == null | utente.getPreferenza().getLikeAltezzaMax() == null
                | utente.getPreferenza().getLikeColoreOcchi() == null | utente.getPreferenza().getLikeGenere() == null
                | utente.getPreferenza().getLikeEtaMin() == null | utente.getPreferenza().getLikeEtaMax() == null)
            throw new ErroreParametriInIngressoException();
        List<Utente> utentiPositiveMatch = new ArrayList<>();
        List<Utente> utentiDaMatchare = new ArrayList<>();

        // rimozione dell'utente che sta facendo il match dall'insieme dei matchabili
        utentiDaMatchare.addAll(utenti.values());
        Iterator<Utente> iteratore1 = utentiDaMatchare.iterator();
        while (iteratore1.hasNext())
            if (iteratore1.next().getUserName().equals(utente.getUserName()))
                iteratore1.remove();

        // il match è positivo se si raggiunge una soglia del 75% di affinità
        int positiveMatchThreshold = 3;

        Iterator<Utente> iteratore2 = utentiDaMatchare.iterator();
        while (iteratore2.hasNext()) {
            int actualPositiveMatch = 0;
            Utente utenteComparato = iteratore2.next();

            // controllo affinità sull'altezza
            if (utenteComparato.getAltezza() >= utente.getPreferenza().getLikeAltezzaMin()
                    && utenteComparato.getAltezza() <= utente.getPreferenza().getLikeAltezzaMax())
                actualPositiveMatch++;

            // controllo affinità sul genere
            if (utente.getPreferenza().getLikeGenere().equals("all")
                    | utenteComparato.getGenere().equals(utente.getPreferenza().getLikeGenere()))
                actualPositiveMatch++;

            // controllo affinità sul colore degli occhi
            if (utente.getPreferenza().getLikeColoreOcchi().equals("all")
                    | utenteComparato.getColoreOcchi().equals(utente.getPreferenza().getLikeColoreOcchi()))
                actualPositiveMatch++;

            // controllo affinità sull'età
            if (utenteComparato.getEta() >= utente.getPreferenza().getLikeEtaMin()
                    && utenteComparato.getEta() <= utente.getPreferenza().getLikeEtaMax())
                actualPositiveMatch++;

            if (actualPositiveMatch >= positiveMatchThreshold)
                utentiPositiveMatch.add(utenteComparato);

        }

        return utentiPositiveMatch;
    }

}
