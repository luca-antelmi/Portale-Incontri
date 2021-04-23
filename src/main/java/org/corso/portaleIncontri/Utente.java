package org.corso.portaleIncontri;

public class Utente {

    private String userName;
    private String nome;
    private String cognome;
    private String eta;
    private String genere;
    private String coloreOcchi;
    private String altezza;

    public Utente(String userName, String nome, String cognome, String eta, String genere, String coloreOcchi,
            String altezza) {
        this.userName = userName;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.genere = genere;
        this.coloreOcchi = coloreOcchi;
        this.altezza = altezza;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utente other = (Utente) obj;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }

    public String getUserName() {
        return userName;
    }

}
