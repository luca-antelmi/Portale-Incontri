package org.corso.portaleIncontri;

import org.corso.portaleIncontri.exceptions.ErroreRegistrazioneException;
import org.corso.portaleIncontri.exceptions.ErroreUtenteGiaPresenteException;

public class PortaleIncontri {
    private Database database;
    private GestoreRegistrazione gestoreRegistrazione;
    private GestoreMatching gestoreMatching;

    public PortaleIncontri() {
        this.database = new Database();
        this.gestoreRegistrazione = new GestoreRegistrazione();
        this.gestoreMatching = new GestoreMatching();
    }

    public void registrazione(String userName, String nome, String cognome, String eta, String genere,
            String coloreOcchi, String altezza, String likeEtaMin, String likeEtaMax, String likeGenere,
            String likeColoreOcchi, String likeAltezzaMin, String likeAltezzaMax) throws ErroreRegistrazioneException {
        if (userName == null | nome == null | cognome == null | eta == null | genere == null | coloreOcchi == null
                | altezza == null)
            throw new ErroreRegistrazioneException();
        try {
            gestoreRegistrazione.registra(database, userName, nome, cognome, eta, genere, coloreOcchi, altezza,
                    likeEtaMin, likeEtaMax, likeGenere, likeColoreOcchi, likeAltezzaMin, likeAltezzaMax);
        } catch (ErroreUtenteGiaPresenteException e) {
            e.printStackTrace();
        }
    }

}
