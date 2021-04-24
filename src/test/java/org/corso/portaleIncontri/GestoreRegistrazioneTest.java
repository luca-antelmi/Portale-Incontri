package org.corso.portaleIncontri;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.corso.portaleIncontri.exceptions.ErroreParametriInIngressoException;
import org.corso.portaleIncontri.exceptions.ErroreUtenteGiaPresenteException;
import org.junit.Before;
import org.junit.Test;

public class GestoreRegistrazioneTest {

    private Map<String, Utente> mappaDiTest;
    private GestoreRegistrazione gestoreRegistrazioneTest;
    private Utente utenteGiaPresente;
    private Preferenza preferenzaGiaPresente;

    @Before
    public void setUp() {
        mappaDiTest = new HashMap<>();
        gestoreRegistrazioneTest = new GestoreRegistrazione();
        utenteGiaPresente = new Utente("pippo", "goofy", "goofy", 36, "M", "nero", 138);
        mappaDiTest.put("pippo", utenteGiaPresente);
        preferenzaGiaPresente = new Preferenza(20, 50, "F", "azzurro", 120, 200);
        utenteGiaPresente.setPreferenza(preferenzaGiaPresente);
    }

    @Test
    public void verificaCorrettaRegistrazioneUtente()
            throws ErroreUtenteGiaPresenteException, ErroreParametriInIngressoException {
        assertNull(mappaDiTest.get("paperino"));
        gestoreRegistrazioneTest.registra(mappaDiTest, "paperino", "donald", "duck", 24, "M", "nero", 150);

        // verifica corretto inserimento dell'utente
        assertNotNull(mappaDiTest.get("paperino"));

        // verifica corretta creazione della preferenza di default associata all'utente
        assertNotNull(mappaDiTest.get("paperino").getPreferenza());

        // verifica esistenza di alcuni valori della preferenza di default
        assertEquals("all", mappaDiTest.get("paperino").getPreferenza().getLikeGenere());
        assertEquals((Integer) 999, mappaDiTest.get("paperino").getPreferenza().getLikeEtaMax());
    }

    @Test(expected = ErroreUtenteGiaPresenteException.class)
    public void erroreInserimentoUtenteGiaPresente()
            throws ErroreUtenteGiaPresenteException, ErroreParametriInIngressoException {
        gestoreRegistrazioneTest.registra(mappaDiTest, "pippo", "anotherPippo", "anotherPippo", 45, "M", "blu", 170);
    }

    @Test(expected = ErroreParametriInIngressoException.class)
    public void erroreInserimentoUtenteConParametriNull()
            throws ErroreUtenteGiaPresenteException, ErroreParametriInIngressoException {
        gestoreRegistrazioneTest.registra(mappaDiTest, "paperino", "donald", null, 20, "M", "nero", null);
    }

    @Test
    public void verificaCorrettoInserimentoNuovaPreferenza() {
        // verifico i dati della presenza attuale
        assertNotNull(utenteGiaPresente.getPreferenza());
        assertEquals((Integer) 20, utenteGiaPresente.getPreferenza().getLikeEtaMin());
        assertEquals((Integer) 50, utenteGiaPresente.getPreferenza().getLikeEtaMax());
        assertEquals("F", utenteGiaPresente.getPreferenza().getLikeGenere());
        assertEquals("azzurro", utenteGiaPresente.getPreferenza().getLikeColoreOcchi());
        assertEquals((Integer) 120, utenteGiaPresente.getPreferenza().getLikeAltezzaMin());
        assertEquals((Integer) 200, utenteGiaPresente.getPreferenza().getLikeAltezzaMax());
        try {
            // inserisco la nuova presenza e ne verifico i dati
            gestoreRegistrazioneTest.inserisciNuovaPreferenza(utenteGiaPresente, 40, 78, "M", "nero", 124, 189);
            assertEquals((Integer) 40, utenteGiaPresente.getPreferenza().getLikeEtaMin());
            assertEquals((Integer) 78, utenteGiaPresente.getPreferenza().getLikeEtaMax());
            assertEquals("M", utenteGiaPresente.getPreferenza().getLikeGenere());
            assertEquals("nero", utenteGiaPresente.getPreferenza().getLikeColoreOcchi());
            assertEquals((Integer) 124, utenteGiaPresente.getPreferenza().getLikeAltezzaMin());
            assertEquals((Integer) 189, utenteGiaPresente.getPreferenza().getLikeAltezzaMax());
        } catch (ErroreParametriInIngressoException e) {
            // NOTHING
        }
    }

    @Test(expected = ErroreParametriInIngressoException.class)
    public void erroreInserimentoNuovaPreferenzaConParametriNonValidi() throws ErroreParametriInIngressoException {
        gestoreRegistrazioneTest.inserisciNuovaPreferenza(utenteGiaPresente, -2, 78, "M", "nero", 124, 140);
    }

    @Test(expected = ErroreParametriInIngressoException.class)
    public void erroreInserimentoNuovaPreferenzaConParametriNull() throws ErroreParametriInIngressoException {
        gestoreRegistrazioneTest.inserisciNuovaPreferenza(utenteGiaPresente, null, 78, "M", null, 124, 189);
    }
}
