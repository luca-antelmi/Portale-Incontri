package org.corso.portaleIncontri;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corso.portaleIncontri.exceptions.ErroreParametriInIngressoException;
import org.corso.portaleIncontri.exceptions.ErroreRegistrazioneException;
import org.corso.portaleIncontri.exceptions.ErroreUtenteInestenteException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PortaleIncontriTest {

    @InjectMocks
    private PortaleIncontri portaleIncontriTest;
    @Mock
    private GestoreMatching gestoreMatchingMock;
    @Mock
    private GestoreRegistrazione gestoreRegistrazioneMock;

    @Before
    public void setUp() {
        gestoreMatchingMock = mock(GestoreMatching.class);
        gestoreRegistrazioneMock = mock(GestoreRegistrazione.class);
        portaleIncontriTest = new PortaleIncontri();
        MockitoAnnotations.openMocks(this);

    }

    @Test(expected = ErroreRegistrazioneException.class)
    public void verificaErroreRegistrazioneUtenteSeParametriNull() throws ErroreRegistrazioneException {

        portaleIncontriTest.registrazioneUtente("paperino", "donald", "duck", null, "M", null, 140);
    }

    @Test(expected = ErroreParametriInIngressoException.class)
    public void verificaErroreNuovaPreferenzaSeParametriNull() throws ErroreParametriInIngressoException {
        try {
            portaleIncontriTest.nuovaPreferenza(null, 20, 26, null, "nero", 140, null);
        } catch (ErroreUtenteInestenteException e) {
            e.printStackTrace();
        }
    }

    /*
     * come testare errore utente inesistente del metodo nuovaPreferenza? quindi che
     * un utente non esistente nella mappa provi a cambiare la sua preferenza
     */

    @Test
    public void verificaCorrettaCreazioneListaDiMatching() throws ErroreUtenteInestenteException {
        Utente utenteTest = new Utente("paperino", "donald", "duck", 20, "M", "verde", 170);
        Map<String, Utente> mappaTest = new HashMap<>();
        List<Utente> utenti = new ArrayList<>();
        try {
            when(gestoreMatchingMock.match(utenteTest, mappaTest)).thenReturn(utenti);
            assertNotNull(portaleIncontriTest.doMatch(utenteTest));
        } catch (ErroreParametriInIngressoException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = ErroreUtenteInestenteException.class)
    public void verificaErroreDiMatchingSeUtenteNull() throws ErroreUtenteInestenteException {
        portaleIncontriTest.doMatch(null);
    }
}
