package SuperGaraget_VG.FordonFactory;

import java.time.LocalDate;

public class Moped extends Fordon {
    private final double pris = 20;

    public Moped(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        this.extraService();
        return ("Moped, " + this.getRegNr() + ", " + this.getIncheckningstid());
    }

    public double getPris() {
        return this.pris;
    }
}
