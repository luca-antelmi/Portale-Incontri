package org.corso.portaleIncontri;

import java.util.*;

public class Database {

    private Map<Utente, Preferenza> database;

    public Database() {
        this.database = new HashMap<>();
    }

    public void persist(Utente utente, Preferenza preferenza) {
        this.database.put(utente, preferenza);
    }

    public boolean containsUser(Utente utente) {
        return this.database.containsKey(utente);
    }

}
