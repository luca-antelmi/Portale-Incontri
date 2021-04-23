package org.corso.portaleIncontri;

import java.util.ArrayList;
import java.util.*;

public class Preferenza {

    private List<String> likeEta;
    private String likeGenere;
    private String likeColoreOcchi;
    private List<String> likeAltezza;

    public Preferenza(String etaMin, String etaMax, String genere, String coloreOcchi, String altezzaMin,
            String altezzaMax) {
        this.likeEta = new ArrayList<>();
        this.likeEta.add(etaMin);
        this.likeEta.add(etaMax);
        this.likeGenere = genere;
        this.likeColoreOcchi = coloreOcchi;
        this.likeAltezza = new ArrayList<>();
        this.likeAltezza.add(altezzaMin);
        this.likeAltezza.add(altezzaMax);

    }

}
