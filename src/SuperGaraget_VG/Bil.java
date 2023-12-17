package SuperGaraget_VG;

import java.time.LocalDate;

public class Bil extends Fordon {

    //private final String regNr;
    private final double pris = 70;

    //private final LocalDate incheckningstid;

    public Bil(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        return ("Bil, " + this.getRegNr() + ", " + this.getIncheckningstid());
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
