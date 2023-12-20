package SuperGaraget_VG.FordonFactory;

import SuperGaraget_VG.FordonFactory.Fordon;

import java.time.LocalDate;

public class Bat extends Fordon {

    //private final String regNr;
    private final double pris = 100;

    //private final LocalDate incheckningstid;

    public Bat(String regNr, String modell, String färg, String ägare, LocalDate incheckningstid) {
        super(regNr, modell, färg, ägare, incheckningstid);
        //this.incheckningstid = incheckningstid;
    }

    public Bat(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        return ("Båt, " + this.getRegNr() + ", " + this.getIncheckningstid());
    }
/*
    @Override
    public LocalDate getIncheckningstid() {
        return incheckningstid;
    }

    public String getRegNr() {
        return this.regNr;
    }
*/
    public double getPris() {
        return this.pris;
    }
}
