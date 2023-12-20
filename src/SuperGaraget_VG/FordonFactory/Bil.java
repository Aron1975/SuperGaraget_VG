package SuperGaraget_VG.FordonFactory;

import SuperGaraget_VG.FordonFactory.Fordon;

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
        //extraService();
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
