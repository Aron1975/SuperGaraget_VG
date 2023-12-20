package SuperGaraget_VG.FordonFactory;

import java.time.LocalDate;

public class Motorcykel extends Fordon {
    private final double pris = 50;

    public Motorcykel(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        return ("Motorcykel, " + this.getRegNr() + ", " + getIncheckningstid());
    }

    public double getPris() {
        return this.pris;
    }
}
