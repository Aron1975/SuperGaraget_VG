package SuperGaraget_VG;

import java.time.LocalDate;

public class Moped extends Fordon {

   // private final String regNr;
    private final double pris = 20;

    //private final LocalDate incheckningstid;

    public Moped(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        return ("Moped, " + this.getRegNr() + ", " + this.getIncheckningstid());
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
