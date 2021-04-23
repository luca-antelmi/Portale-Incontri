package org.corso.portaleIncontri;

public class Preferenza {

    private int likeEtaMin;
    private int likeEtaMax;
    private String likeGenere;
    private String likeColoreOcchi;
    private int likeAltezzaMin;
    private int likeAltezzaMax;

    public Preferenza(int etaMin, int etaMax, String genere, String coloreOcchi, int altezzaMin,
            int altezzaMax) {
        this.likeEtaMin = etaMin;
        this.likeEtaMax = etaMax;
        this.likeGenere = genere;
        this.likeColoreOcchi = coloreOcchi;
        this.likeAltezzaMin = altezzaMin;
        this.likeAltezzaMax = altezzaMax;

    }

    public int getLikeEtaMin() {
        return likeEtaMin;
    }

    public int getLikeEtaMax() {
        return likeEtaMax;
    }

    public int getLikeAltezzaMin() {
        return likeAltezzaMin;
    }

    public int getLikeAltezzaMax() {
        return likeAltezzaMax;
    }

    public String getLikeGenere() {
        return likeGenere;
    }

    public String getLikeColoreOcchi() {
        return likeColoreOcchi;
    }

}
