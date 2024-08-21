package model;

public class Schranke {
    private boolean offen;

    public Schranke() {
        this.offen = false;
    }

    public void oeffnen() {
        offen = true;
        System.out.println("Schranke öffnet sich.");
    }

    public void schliessen() {
        offen = false;
        System.out.println("Schranke schließt sich.");
    }

}
