package org.corso.portaleIncontri;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corso.portaleIncontri.exceptions.ErroreParametriInIngressoException;
import org.junit.Before;
import org.junit.Test;

public class GestoreMatchingTest {

    private Utente paperino;
    private Utente paperina;
    private Utente topolino;
    private Utente minni;
    private Utente pippo;
    private Preferenza preferenza;
    private Preferenza preferenzaConNull;
    private Preferenza preferenzaDefault;
    private Map<String, Utente> mappaDiTest;
    private GestoreMatching gestoreMatchingTest;

    @Before
    public void setUp() {
        paperino = new Utente("paperino", "donald", "duck", 24, "M", "nero", 150);
        paperina = new Utente("paperina", "daisy", "duck", 25, "F", "azzurro", 140);
        topolino = new Utente("topolino", "mickey", "mouse", 41, "M", "nero", 130);
        minni = new Utente("minni", "minnie", "mouse", 19, "F", "verde", 151);
        pippo = new Utente("pippo", "goofy", "goofy", 36, "M", "nero", 138);
        preferenza = new Preferenza(20, 40, "F", "nero", 120, 160);
        preferenzaConNull = new Preferenza(10, null, "M", "blu", null, 0);
        preferenzaDefault = new Preferenza(0, 999, "all", "all", 0, 9999);
        paperino.setPreferenza(preferenza);
        topolino.setPreferenza(preferenzaConNull);
        minni.setPreferenza(preferenzaDefault);
        mappaDiTest = new HashMap<>();
        mappaDiTest.put("paperino", paperino);
        mappaDiTest.put("paperina", paperina);
        mappaDiTest.put("topolino", topolino);
        mappaDiTest.put("minni", minni);
        mappaDiTest.put("pippo", pippo);
        gestoreMatchingTest = new GestoreMatching();
    }

    @Test
    public void verificaMatchingCorretto() throws ErroreParametriInIngressoException {
        List<Utente> lista = gestoreMatchingTest.match(paperino, mappaDiTest);
        // secondo i parametri di match vengono selezionati solo paperina e pippo
        assertEquals(2, lista.size());
        assertTrue(lista.contains(paperina));
        assertTrue(lista.contains(pippo));

    }

    @Test
    public void verifcaMatchingCorrettoConPreferenzaDefault() throws ErroreParametriInIngressoException{
        List<Utente> lista = gestoreMatchingTest.match(minni, mappaDiTest);
        assertEquals(4, lista.size());
        assertTrue(lista.contains(paperina));
        assertTrue(lista.contains(pippo));
        assertTrue(lista.contains(topolino));
        assertTrue(lista.contains(paperino));

    }

    @Test(expected = ErroreParametriInIngressoException.class)
    public void verificaErroreSeUtenteNull() throws ErroreParametriInIngressoException {
        gestoreMatchingTest.match(null, mappaDiTest);

    }

    @Test(expected = ErroreParametriInIngressoException.class)
    public void verificaErroreSePreferenzaHaParametriNull() throws ErroreParametriInIngressoException {
        gestoreMatchingTest.match(topolino, mappaDiTest);
    }

    @Test(expected = ErroreParametriInIngressoException.class)
    public void verificaErroreSeMappaNull() throws ErroreParametriInIngressoException {
        gestoreMatchingTest.match(paperino, null);

    }
}
