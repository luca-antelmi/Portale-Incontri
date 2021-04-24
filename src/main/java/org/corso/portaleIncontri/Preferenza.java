package org.corso.portaleIncontri;

public class Preferenza {

    private Integer likeEtaMin;
    private Integer likeEtaMax;
    private String likeGenere;
    private String likeColoreOcchi;
    private Integer likeAltezzaMin;
    private Integer likeAltezzaMax;

    public Preferenza(Integer etaMin, Integer etaMax, String genere, String coloreOcchi, Integer altezzaMin,
            Integer altezzaMax) {
        this.likeEtaMin = etaMin;
        this.likeEtaMax = etaMax;
        this.likeGenere = genere;
        this.likeColoreOcchi = coloreOcchi;
        this.likeAltezzaMin = altezzaMin;
        this.likeAltezzaMax = altezzaMax;

    }

    public Integer getLikeEtaMin() {
        return likeEtaMin;
    }

    public Integer getLikeEtaMax() {
        return likeEtaMax;
    }

    public Integer getLikeAltezzaMin() {
        return likeAltezzaMin;
    }

    public Integer getLikeAltezzaMax() {
        return likeAltezzaMax;
    }

    public String getLikeGenere() {
        return likeGenere;
    }

    public String getLikeColoreOcchi() {
        return likeColoreOcchi;
    }

}
