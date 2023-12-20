package SuperGaraget_VG.FordonFactory;

import SuperGaraget_VG.FordonFactory.Fordon;

import java.time.LocalDate;

public class Motorcykel extends Fordon {

    //private final String regNr;
    private final double pris = 50;

    //private final LocalDate incheckningstid;

    public Motorcykel(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        return ("Motorcykel, " + this.getRegNr() + ", " + getIncheckningstid());
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
