package SuperGaraget_VG;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GarageController {

    private DatabasInterface databas;
    private Garage garage;
    private View view;
    private final Scanner scan = new Scanner(System.in);
    private final LocalDate parkeringsDatum = LocalDate.now();

    private List<FordonInterface> parkeradeFordon = new ArrayList<>();

    public GarageController(DatabasInterface databas, Garage garage, View view) {
        this.databas = databas;
        this.garage = garage;
        this.view = view;
        läsInFordon();
        välkommenOchInfo();
        garage.antalPlatserLediga();
        metoderFrånMain();
    }

    public void metoderFrånMain(){

        try {

            while (true) {
                String s = kundEllerAnställd();
                if (s.equals("1")) {
                    kund();
                } else if (s.equals("2")) {
                    anställd();
                } else {
                    view.printInteBehörigMesage();

                    System.exit(0);
                }
                databas.sparaFordon(garage.getParkeradeFordon());
            }
        } catch (Exception e) {
            databas.sparaFordon(garage.getParkeradeFordon());
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

    public String kundEllerAnställd() {
        System.out.println("Är du anställd eller kund? \nSkriv:  \n- 1 för kund. \n- 2 för anställd.");
        return scan.nextLine().trim().toLowerCase();
    }

    public void kund() {
        System.out.println("Vill du checka in eller checka ut ett fordon? \nAnge: \n- 1 för att checka in \n- 2 för att checka ut" +
                "\n- 3 för att stänga ner programmet.");
        String inEllerUtFråga = scan.nextLine().trim().toLowerCase();
        if (inEllerUtFråga.equals("1")) {
            if (garage.kontrolleraPlats()) {

                System.out.println("Vad har du för registreringsnummer?");
                String regNr = scan.nextLine();
                System.out.println("Vad har du för fordonstyp?");
                String fordonsTyp = scan.nextLine();

                if (garage.checkaInFordon(fordonsTyp, regNr, parkeringsDatum) == null) {
                    System.out.println("Fordonet får inte parkera här.");
                }

            } else {
                System.out.println("Garaget är fullt, vänligen återkom i ett senare skede.");
            }
        } else if (inEllerUtFråga.equals("2")) {
            System.out.println("Vad har du för registreringsnummer?");
            String regNr = scan.nextLine();
            garage.checkaUtFordon(regNr);
            garage.skickaFaktura();
        } else if (inEllerUtFråga.equals("3")) {
            System.out.println("Adjöken!");
            databas.sparaFordon(garage.getParkeradeFordon());
            System.exit(0);
        }
    }

    public void anställd() {
        System.out.println("Vad vill du göra? Ange: \n- 1 för att söka i databas eller\n- 2 för Checka in eller checka ut en kund" +
                "\n- 3 för att skriva ut alla fordon" + " \n- 4 för att kontrollera parkeringstid."
                + " \n- 5 för att stänga ner programmet.");
        String indataAnställd = scan.nextLine().trim().toLowerCase();

        if (indataAnställd.equals("1")) {
            System.out.println("Vilket reg nr?");
            String regNr = scan.nextLine().trim().toUpperCase();
            int parkeringsPlats = garage.hittaFordon(regNr);
            if (parkeringsPlats == -1) {
                System.out.println("Bilen är inte parkerad här!");
            } else {
                System.out.println(garage.getParkeradeFordon().get(parkeringsPlats).toString());
            }
        } else if (indataAnställd.equals("2")) {
            kund();
        } else if (indataAnställd.equals("3")) {
            garage.skrivUtIncheckadeBilar();
        } else if (indataAnställd.equals("4")) {
            garage.kontrollerBegränsningParkeradeDagar();
        } else if (indataAnställd.equals("5")) {
            System.out.println("Adjöken!");
            databas.sparaFordon(garage.getParkeradeFordon());
            System.exit(0);
        } else {
            System.out.println("Adjöken");
        }
    }

    public void välkommenOchInfo() {
        System.out.println("Välkommen till Super Garaget!");
        System.out.println("Om något inte fungerar kontakta oss på Supergaraget AB: 076 123 45 67" + "\n" +
                "\n Garaget är öppet: Måndag-Söndag 00:00 - 23:59." +
                "\n - Obemannat 16:00 - 23:59.");
    }

    public void läsInFordon() {
        //parkeradeFordon = databas.läsInFordon();
        List<FordonInterface> test123 = databas.läsInFordon();
        garage.setParkeradeFordon(test123);
    }

}
