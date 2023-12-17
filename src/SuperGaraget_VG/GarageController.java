package SuperGaraget_VG;

import java.time.LocalDate;
import java.util.Scanner;

public class GarageController {

    private DatabasInterface databas;
    private Garage garage;
    private GarageView garageView;
    private final Scanner scan = new Scanner(System.in);
    private final LocalDate parkeringsDatum = LocalDate.now();

   // private List<FordonInterface> parkeradeFordon = new ArrayList<>();

    public GarageController(DatabasInterface databas, Garage garage, GarageView garageView) {
        this.databas = databas;
        this.garage = garage;
        this.garageView = garageView;
        läsInFordon();
        välkommenOchInfo();
        garageView.skrivUtAntaletLedigaPlatser(garage.antalPlatserLediga());
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
                    garageView.skrivUtFelmeddelande("Om du inte är anställd eller kund, vänligen lämna området.");

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
        garageView.skrivUtKundEllerAnställdMeddelande("Är du anställd eller kund? \nSkriv:  \n- 1 för kund. \n- 2 för anställd.");
        return scan.nextLine().trim().toLowerCase();
    }

    public void kund() {
        garageView.skrivUtKundEllerAnställdMeddelande("Vill du checka in eller checka ut ett fordon? \nAnge: \n- 1 för att checka in \n- 2 för att checka ut" +
                "\n- 3 för att stänga ner programmet.");
        String inEllerUtFråga = scan.nextLine().trim().toLowerCase();
        if (inEllerUtFråga.equals("1")) {
            if (garage.kontrolleraPlats()) {

                garageView.skrivUtMeddelandeTillKund("Vad har du för registreringsnummer?");
                String regNr = scan.nextLine();
                garageView.skrivUtMeddelandeTillKund("Vad har du för fordonstyp?");
                String fordonsTyp = scan.nextLine();

                if (garage.checkaInFordon(fordonsTyp, regNr, parkeringsDatum) == null) {
                    garageView.skrivUtMeddelandeTillKund("Fordonet får inte parkera här.");
                }

            } else {
                garageView.skrivUtMeddelandeTillKund("Garaget är fullt, vänligen återkom i ett senare skede.");
            }
        } else if (inEllerUtFråga.equals("2")) {
            garageView.skrivUtMeddelandeTillKund("Vad har du för registreringsnummer?");
            String regNr = scan.nextLine();
            garage.checkaUtFordon(regNr);
            garage.skickaFaktura();
        } else if (inEllerUtFråga.equals("3")) {
            garageView.skrivUtMeddelandeTillKund("Adjöken!");
            databas.sparaFordon(garage.getParkeradeFordon());
            System.exit(0);
        }
    }

    public void anställd() {

        garageView.uppdateraInläsningsfältAnställd();
        String indataAnställd = scan.nextLine().trim().toLowerCase();

        if (indataAnställd.equals("1")) {

            garageView.skrivUtMeddelandeTillKund("Vilket reg nr?");
            String regNr = scan.nextLine().trim().toUpperCase();
            int parkeringsPlats = garage.hittaFordon(regNr);
            if (parkeringsPlats == -1) {
                garageView.skrivUtFelmeddelande("Bilen är inte parkerad här!");
            } else {
                System.out.println(garage.getParkeradeFordon().get(parkeringsPlats).toString());
            }
        } else if (indataAnställd.equals("2")) {
            kund();
        } else if (indataAnställd.equals("3")) {
            garage.skrivUtIncheckadeFordon();
        } else if (indataAnställd.equals("4")) {
            garage.kontrollerBegränsningParkeradeDagar();
        } else if (indataAnställd.equals("5")) {
            garageView.skrivUtMeddelandeTillKund("Adjöken!");
            databas.sparaFordon(garage.getParkeradeFordon());
            System.exit(0);
        } else {
            garageView.skrivUtMeddelandeTillKund("Adjöken");
        }
    }

    public void välkommenOchInfo() {
        garageView.skrivUtVälkomstText();
    }

    public void läsInFordon() {
        if((databas.läsInFordon(garage)) == -1){
            garageView.skrivUtSkrivLäsFilFelmeddelande("Kunde inte läsa in fordon från databas.");
        }
        //List<FordonInterface> test123 = databas.läsInFordon();
        //garage.setParkeradeFordon(test123);
    }

}
