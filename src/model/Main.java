package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Parkhaus initialisieren
        Parkhaus parkhaus = new Parkhaus(100);

        // Schranken erstellen und zum Parkhaus hinzufügen
        Schranke einfahrt = new Schranke();
        Schranke ausfahrt = new Schranke();
        parkhaus.setEinfahrtsschranke(einfahrt);
        parkhaus.setAusfahrtsschranke(ausfahrt);

        // Kasse erstellen und zum Parkhaus hinzufügen
        Kasse kasse = new Kasse(2.5); // 2.5 CHF pro Minute
        parkhaus.addKasse(kasse);

        Scanner scanner = new Scanner(System.in);
        List<Auto> autos = new ArrayList<>();
        int autoCounter = 1;

        // Switch zur Auswahl der Interaktionen
        while (true) {
            System.out.println("\nFreie Plätze: " + parkhaus.getFreiePlaetze());
            System.out.println("Wählen Sie eine Option:");
            System.out.println("1. Neues Auto einfahren");
            System.out.println("2. Bezahlen");
            System.out.println("3. Auto ausfahren");
            System.out.println("4. Liste der Autos anzeigen");
            System.out.println("5. Beenden");

            int wahl = getIntInput(scanner, "Ihre Auswahl:");

            switch (wahl) {
                case 1:
                    if (parkhaus.getFreiePlaetze() > 0) {
                        Auto auto = new Auto(autoCounter++);
                        autos.add(auto);
                        if (parkhaus.einfahren(auto)) {
                            einfahrt.oeffnen();
                            System.out.println("Auto " + auto.getTicketNummer() + " fährt in das Parkhaus.");
                            einfahrt.schliessen();
                        }
                    } else {
                        System.out.println("Kein freier Parkplatz verfügbar.");
                    }
                    break;

                case 2:
                    if (!autos.isEmpty()) {
                        Autoliste(autos);
                        int ticketNummer = getIntInput(scanner, "Wählen Sie ein Auto zum Bezahlen aus (Ticketnummer eingeben):");
                        Auto autoToPay = findAutoByTicketNummer(autos, ticketNummer);
                        if (autoToPay != null && !autoToPay.isBezahlt()) {
                            kasse.kassiere(autoToPay);
                            System.out.println("Auto " + autoToPay.getTicketNummer() + " wurde bezahlt.");
                        } else if (autoToPay == null) {
                            System.out.println("Auto mit dieser Ticketnummer nicht gefunden.");
                        } else {
                            System.out.println("Dieses Auto hat bereits bezahlt.");
                        }
                    } else {
                        System.out.println("Es gibt keine Autos im Parkhaus.");
                    }
                    break;

                case 3:
                    if (!autos.isEmpty()) {
                        Autoliste(autos);
                        int ticketNummer = getIntInput(scanner, "Wählen Sie ein Auto zum Ausfahren aus (Ticketnummer eingeben):");
                        Auto autoToExit = findAutoByTicketNummer(autos, ticketNummer);
                        if (autoToExit != null && autoToExit.isBezahlt()) {
                            if (parkhaus.ausfahren(autoToExit)) {
                                ausfahrt.oeffnen();
                                System.out.println("Auto " + autoToExit.getTicketNummer() + " fährt aus dem Parkhaus.");
                                ausfahrt.schliessen();
                                autos.remove(autoToExit);
                            }
                        } else if (autoToExit == null) {
                            System.out.println("Auto mit dieser Ticketnummer nicht gefunden.");
                        } else {
                            System.out.println("Das Auto muss zuerst bezahlen, bevor es ausfahren kann.");
                        }
                    } else {
                        System.out.println("Es gibt keine Autos im Parkhaus.");
                    }
                    break;

                case 4:
                    Autoliste(autos);
                    break;

                case 5:
                    System.out.println("Programm beendet.");
                    return;

                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                    break;
            }
        }
    }

    // Methode zur Input Kontrolle
    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
                scanner.next();
            }
        }
    }

    // Methode zum Auto suchen
    private static Auto findAutoByTicketNummer(List<Auto> autos, int ticketNummer) {
        for (Auto auto : autos) {
            if (auto.getTicketNummer() == ticketNummer) {
                return auto;
            }
        }
        return null;
    }

    // Methode zum Anzeigen der Autoliste
    private static void Autoliste(List<Auto> autos) {
        if (!autos.isEmpty()) {
            System.out.println("Liste der Autos im Parkhaus:");
            autos.forEach(a -> System.out.println("Auto " + a.getTicketNummer() + " - Bezahlt: " + (a.isBezahlt() ? "Ja" : "Nein")));
        } else {
            System.out.println("Es gibt keine Autos im Parkhaus.");
        }
    }
}
