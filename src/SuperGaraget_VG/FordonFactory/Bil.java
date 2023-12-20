package SuperGaraget_VG.FordonFactory;

import java.time.LocalDate;

public class Bil extends Fordon {
    private final double pris = 70;

    public Bil(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        return ("Bil, " + this.getRegNr() + ", " + this.getIncheckningstid());
    }

    public double getPris() {
        return this.pris;
    }
}
