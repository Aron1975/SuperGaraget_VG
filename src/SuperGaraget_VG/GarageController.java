package SuperGaraget_VG;

import SuperGaraget_VG.FordonFactory.FordonInterface;

import java.time.LocalDate;
import java.util.Scanner;

public class GarageController {

    private DatabasInterface databas;
    private Garage garage;
    private GarageView garageView;
    private final Scanner scan = new Scanner(System.in);
    private final LocalDate parkeringsDatum = LocalDate.now();
    private FordonInterface fordonAttCheckaIn;

   // private List<FordonInterface> parkeradeFordon = new ArrayList<>();

    public GarageController(DatabasInterface databas, Garage garage, GarageView garageView) {
        this.databas = databas;
        this.garage = garage;
        this.garageView = garageView;
        läsInFordon();
        välkommenOchInfo();
        kundEllerAnställd();
    }

    public void kundEllerAnställd() {

        try {
            while (true) {
                garageView.skrivUtKundEllerAnställdMeddelande("Är du kund elled anställd?  \n- 1. Kund \n" +
                        "- 2. Anställd\n Tryck Enter för att avsluta.");
                String s = scan.nextLine().trim().toLowerCase();
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



    public void kund() {
        boolean fortsätt = true;
        while(fortsätt) {
            garageView.skrivUtKundEllerAnställdMeddelande("Vill du checka in eller checka ut ett fordon? \nAnge: \n- 1 för att checka in \n- 2 för att checka ut" +
                    "\n- 3 för att återgå till huvudmenyn");
            String inEllerUtFråga = scan.nextLine().trim().toLowerCase();
            if (inEllerUtFråga.equals("1")) {
                if (garage.kontrolleraPlats()) {

                    garageView.skrivUtMeddelandeTillKund("Vad har du för registreringsnummer?");
                    String regNr = scan.nextLine();
                    garageView.skrivUtMeddelandeTillKund("Vad har du för fordonstyp?");
                    String fordonsTyp = scan.nextLine();

                    if ((fordonAttCheckaIn = garage.checkaInFordon(fordonsTyp, regNr, parkeringsDatum)) == null) {
                        garageView.skrivUtMeddelandeTillKund("Fordonet får inte parkera här.");
                    } else{
                        garageView.skrivUtMeddelandeTillKund("\nVill du ha en tilläggstjänst? Annars tryck enter1. Tvätt \\n2. Däckbyte \\n3. Polering\"");
                        garage.läggTillExtraTjänst(fordonAttCheckaIn);
                    }

                } else {
                    garageView.skrivUtMeddelandeTillKund("Garaget är fullt, vänligen återkom i ett senare skede.");
                }
            } else if (inEllerUtFråga.equals("2")) {
                garageView.skrivUtMeddelandeTillKund("Vad har du för registreringsnummer?");
                String regNr = scan.nextLine();
                double totalPris = garage.checkaUtFordon(regNr);
                if (totalPris != -1) {
                    garageView.skrivUtMeddelandeTillKund("Ditt totalpris blir: " + totalPris + "kronor. \n" +
                            "Fakturan skickas till fordonsägarens hemadress, välkommen åter.");
                } else {
                    garageView.skrivUtMeddelandeTillKund("Fordonet är inte parkerad här");
                }
            } else if (inEllerUtFråga.equals("3")) {
                garageView.skrivUtMeddelandeTillKund("Adjöken!");
                databas.sparaFordon(garage.getParkeradeFordon());
                fortsätt = false;
            }
        }
    }

    public void anställd() {
        boolean fortsätt = true;
        while(fortsätt) {
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
                    garage.skrivUtPris(garage.getParkeradeFordon().get(parkeringsPlats));
                }
            } else if (indataAnställd.equals("2")) {
                kund();
            } else if (indataAnställd.equals("3")) {
                garage.skrivUtIncheckadeFordon();
            } else if (indataAnställd.equals("4")) {
                garageView.skrivUtMeddelandeTillKund("Vilken fordon vill du kontrollera? (Skriv in registreringsnummer)");
                String regNr = scan.nextLine().trim().toUpperCase();
                int dagar[] = garage.kontrolleraBegränsningParkeradeDagar(regNr);
                if (dagar[0] != -1) {
                    garageView.skrivUtMeddelandeTillAnställd("Kunden har parkerat: " + dagar[0] + " dagar.\n" +
                            "Kunden får stå parkerad totalt: " + dagar[1] + " dagar till.");
                } else {
                    garageView.skrivUtMeddelandeTillAnställd("Fordonet står inte parkerad här!");
                }

            } else if (indataAnställd.equals("5")) {
                garageView.skrivUtMeddelandeTillKund("Vilket reg nr?");
                String regNr = scan.nextLine().trim().toUpperCase();
                int parkeringsPlats = garage.hittaFordon(regNr);
                if (parkeringsPlats == -1) {
                    garageView.skrivUtFelmeddelande("Bilen är inte parkerad här!");
                } else {
                    //Kalla på tilläggstjänster
                    FordonInterface f = garage.getParkeradeFordon().get(parkeringsPlats);
                    f = garage.läggTillExtraTjänst(f);
                    garage.uppdateraFordonILista(parkeringsPlats, f);
                    System.out.println(garage.getParkeradeFordon().get(parkeringsPlats).toString());
                    garage.skrivUtPris(garage.getParkeradeFordon().get(parkeringsPlats));
                }
            }else{
                garageView.skrivUtMeddelandeTillKund("Adjöken!");
                databas.sparaFordon(garage.getParkeradeFordon());
                fortsätt = false;

            }
        }
    }

    public void välkommenOchInfo() {
        garageView.skrivUtVälkomstText();
        garageView.skrivUtAntaletLedigaPlatser(garage.antalPlatserLediga());
    }

    public void läsInFordon() {
        if((databas.läsInFordon(garage)) == -1){
            garageView.skrivUtSkrivLäsFilFelmeddelande("Kunde inte läsa in fordon från databas.");

        }
        //List<FordonInterface> test123 = databas.läsInFordon();
        //garage.setParkeradeFordon(test123);
    }

}
