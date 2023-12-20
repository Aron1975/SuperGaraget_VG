package SuperGaraget_VG;

import SuperGaraget_VG.Decorator.BytaDäckFordon;
import SuperGaraget_VG.Decorator.PoleraFordon;
import SuperGaraget_VG.Decorator.TvättaFordon;
import SuperGaraget_VG.FordonFactory.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage {

    private static final int antalParkeringsplatser = 20;
    private int antalParkeradeFordon = 0;
    private double totalPris = 0;
    private final int maxTidParkering = 365;
    private List<FordonInterface> parkeradeFordon = new ArrayList<>();

    public FordonInterface checkaInFordon(String typ, String regNr, LocalDate parkeringsDatum) {

        FordonInterface f = skapaFordon(typ, regNr, parkeringsDatum);

        if (f != null) {

            if(sistaKollInnanCheckIn(f)) {
                läggFordonTillListan(f);
            }
        }
        return f;
    }

    public FordonInterface skapaFordon(String typ, String regNr, LocalDate parkeringsDatum) {
        FordonInterface f = null;
        regNr = regNr.toUpperCase().trim();
        if (typ.equalsIgnoreCase("Bil")) {
            f = new Bil(regNr, parkeringsDatum);
        }
        if (typ.equalsIgnoreCase("Båt")) {
            f = new Bat(regNr, parkeringsDatum);
        }
        if (typ.equalsIgnoreCase("Moped")) {
            f = new Moped(regNr, parkeringsDatum);
        }
        if (typ.equalsIgnoreCase("Motorcykel")) {
            f = new Motorcykel(regNr, parkeringsDatum);
        }
        /*
        System.out.println("Kallar på Extra tjänst!!!");
        f = läggTillExtraTjänst(f);
        System.out.println("Efter kall på Extra tjänst!!!");
        f.extraService();*/
        return f;
    }
    public void läggFordonTillListan(FordonInterface f){
        parkeradeFordon.add(f);
        antalParkeradeFordon++;
    }
    public boolean sistaKollInnanCheckIn(FordonInterface f) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pris: " + f.getPris() + " kr per dag.\n Skriv nej för avbryt");
        String inputUser = scan.nextLine().trim().toLowerCase();

        if (inputUser.equals("nej")) {
            System.out.println("Adjö");
            return false;
        } else {
            System.out.println("Välkommen in och parkera!");
        }
        return true;
    }

    public double checkaUtFordon(String regNr) {
        double totPris = -1;
        int bilPaPlats = hittaFordon(regNr);
        if (bilPaPlats != -1) {
            totPris = beräknaPris(parkeradeFordon.get(bilPaPlats), kontrolleraParkeringstid(parkeradeFordon.get(bilPaPlats)));
            parkeradeFordon.remove(bilPaPlats);
        }
        return totPris;
    }

    public int hittaFordon(String regNr) {
        int counter = 0;
        for (FordonInterface f : parkeradeFordon) {
            if (f.getRegNr().equals(regNr.toUpperCase())) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    public int kontrolleraParkeringstid(FordonInterface f) {
        LocalDate lD = LocalDate.now();
        System.out.println(f.getIncheckningstid().toString());
        Period periods = Period.between(f.getIncheckningstid(), lD);
        long days = ChronoUnit.DAYS.between(f.getIncheckningstid(), lD);
        return (int)days;
    }

    public double beräknaPris(FordonInterface f, int antalDagar) {
        return (f.getPris() * antalDagar);
    }

    public void skrivUtPris(FordonInterface f){
        int antalDagar = kontrolleraParkeringstid(f);
        System.out.println("Priset för nuvarande är: ");
        System.out.println("Parkering: " + antalDagar + " dagar: " + f.getPris()*antalDagar);
        f.extraService();
        System.out.println(" " + f.getPrisExtra());
        System.out.println("Total pris extras: " + f.getTotalPrisExtra());
    }

    public double skickaFaktura() {
        return totalPris;
    }

    public void skrivUtIncheckadeFordon() {
        for (FordonInterface f : parkeradeFordon) {
            System.out.println(f.toString());
            f.extraService();
        }
    }

    public boolean kontrolleraPlats() {
        return antalParkeradeFordon < antalParkeringsplatser;
    }

    public int antalPlatserLediga() {
        int ledigaPlatser = antalParkeringsplatser - antalParkeradeFordon;

        return ledigaPlatser;
    }

    public List<FordonInterface> getParkeradeFordon() {
        return parkeradeFordon;
    }

    public void setParkeradeFordon(List<FordonInterface> parkeradeFordon) {
        this.parkeradeFordon = parkeradeFordon;
    }

    public int getMaxTidParkering() {
        return maxTidParkering;
    }

    public int[] kontrolleraBegränsningParkeradeDagar(String regNr) {

        int[] dagar = new int[]{-1,0};
        int i = hittaFordon(regNr);
        if (i != -1) {
            dagar[0] = kontrolleraParkeringstid(getParkeradeFordon().get(i));
            dagar[1] = getMaxTidParkering() - dagar[0];
        }
        return dagar;
    }

    public void uppdateraFordonILista(int plats, FordonInterface fordon){
        parkeradeFordon.set(plats, fordon);
    }

    public FordonInterface läggTillExtraTjänst(FordonInterface f){
        System.out.println("1 Tvätt\n2 Däckbyte\n3 Polering");
        Scanner scan = new Scanner(System.in);

        String tjänst = scan.nextLine();
        if(tjänst.equals("1")){
            f = new TvättaFordon(f);
        }
        if(tjänst.equals("2")){
            f = new BytaDäckFordon(f);
        }
        if(tjänst.equals("3")){
            f = new PoleraFordon(f);
        }
        return f;
    }
}
