package model;

public class Main {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(100);

        Schranke einfahrt = new Schranke();
        Schranke ausfahrt = new Schranke();
        parkhaus.setEinfahrtsschranke(einfahrt);
        parkhaus.setAusfahrtsschranke(ausfahrt);

        Kasse kasse = new Kasse(2.5);
        parkhaus.addKasse(kasse);

        Auto auto = new Auto(1);
        if (parkhaus.einfahren(auto)) {
            einfahrt.oeffnen();
            System.out.println("Auto fährt in das Parkhaus.");
            einfahrt.schliessen();
        } else {
            System.out.println("Kein freier Parkplatz verfügbar.");
        }

        kasse.kassiere(auto);

        if (auto.isBezahlt() && parkhaus.ausfahren(auto)) {
            ausfahrt.oeffnen();
            System.out.println("Auto fährt aus dem Parkhaus.");
            ausfahrt.schliessen();
        } else {
            System.out.println("Bezahlung nicht abgeschlossen oder Auto nicht im Parkhaus.");
        }
    }
}
