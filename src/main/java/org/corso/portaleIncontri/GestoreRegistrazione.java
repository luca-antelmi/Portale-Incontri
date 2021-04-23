package org.corso.portaleIncontri;

import org.corso.portaleIncontri.exceptions.ErroreUtenteGiaPresenteException;

public class GestoreRegistrazione {

    public GestoreRegistrazione() {

    }

    public void registra(Database database, String userName, String nome, String cognome, String eta, String genere,
            String coloreOcchi, String altezza, String likeEtaMin, String likeEtaMax, String likeGenere,
            String likeColoreOcchi, String likeAltezzaMin, String likeAltezzaMax)
            throws ErroreUtenteGiaPresenteException {

        Utente utente = new Utente(userName, nome, cognome, eta, genere, coloreOcchi, altezza);
        Preferenza preferenza = new Preferenza(likeEtaMin, likeEtaMax, likeGenere, likeColoreOcchi, likeAltezzaMin,
                likeAltezzaMax);
        if (database.containsUser(utente))
            throw new ErroreUtenteGiaPresenteException();
        database.persist(utente, preferenza);

    }
}
