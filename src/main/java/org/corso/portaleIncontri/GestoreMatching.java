package org.corso.portaleIncontri;

import java.util.*;

import org.corso.portaleIncontri.exceptions.ErroreParametriInIngressoException;

public class GestoreMatching {

    public GestoreMatching() {

    }

    public List<Utente> match(Utente utente, Map<String, Utente> utenti) throws ErroreParametriInIngressoException {
        if(utente == null | utenti == null)
            throw new ErroreParametriInIngressoException();
        List<Utente> utentiPositiveMatch = new ArrayList<>();
        List<Utente> utentiDaMatchare = new ArrayList<>();
        utentiDaMatchare.addAll(utenti.values());
        Iterator<Utente> iteratore1 = utentiDaMatchare.iterator();
        while (iteratore1.hasNext())
            if (iteratore1.next().getUserName().equals(utente.getUserName()))
                iteratore1.remove();
        int positiveMatchThreshold = 3;
        Iterator<Utente> iteratore2 = utentiDaMatchare.iterator();
        while (iteratore2.hasNext()) {
            int actualPositiveMatch = 0;
            Utente utenteComparato = iteratore2.next();
            if (utenteComparato.getAltezza() >= utente.getPreferenza().getLikeAltezzaMin()
                    && utenteComparato.getAltezza() <= utente.getPreferenza().getLikeAltezzaMax())
                actualPositiveMatch++;
            if (utenteComparato.getGenere().equals(utente.getPreferenza().getLikeGenere()))
                actualPositiveMatch++;
            if (utenteComparato.getColoreOcchi().equals(utente.getPreferenza().getLikeColoreOcchi()))
                actualPositiveMatch++;
            if (utenteComparato.getEta() >= utente.getPreferenza().getLikeEtaMin()
                    && utenteComparato.getEta() <= utente.getPreferenza().getLikeEtaMax())
                actualPositiveMatch++;
            if (actualPositiveMatch >= positiveMatchThreshold)
                utentiPositiveMatch.add(utenteComparato);

        }

        return utentiPositiveMatch;
    }

}
