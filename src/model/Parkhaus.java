package model;

import java.util.*;

public class Parkhaus {
    private int gesamtPlaetze;
    private int freiePlaetze;
    private List<Auto> parkplaetze;
    private List<Kasse> kassen;
    private Schranke einfahrtsschranke;
    private Schranke ausfahrtsschranke;

    public Parkhaus(int gesamtPlaetze) {
        this.gesamtPlaetze = gesamtPlaetze;
        this.freiePlaetze = gesamtPlaetze;
        this.parkplaetze = new ArrayList<>(gesamtPlaetze);
        this.kassen = new ArrayList<>();
    }
    public boolean einfahren(Auto auto) {
        if (freiePlaetze > 0) {
            parkplaetze.add(auto);
            freiePlaetze--;
            return true;
        } else {
            return false;
        }
    }

    public boolean ausfahren(Auto auto) {
        if (parkplaetze.remove(auto)) {
            freiePlaetze++;
            return true;
        } else {
            return false;
        }
    }

    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    public void addKasse(Kasse kasse) {
        kassen.add(kasse);
    }

    public void setEinfahrtsschranke(Schranke schranke) {
        einfahrtsschranke = schranke;
    }

    public void setAusfahrtsschranke(Schranke schranke) {
        ausfahrtsschranke = schranke;
    }

}