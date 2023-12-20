package SuperGaraget_VG.FordonFactory;

import java.time.LocalDate;

public class Bat extends Fordon {

    private final double pris = 100;

    public Bat(String regNr, String modell, String färg, String ägare, LocalDate incheckningstid) {
        super(regNr, modell, färg, ägare, incheckningstid);
    }

    public Bat(String regNr, LocalDate incheckningstid) {
        super(regNr, incheckningstid);
    }

    @Override
    public String toString() {
        return ("Båt, " + this.getRegNr() + ", " + this.getIncheckningstid());
    }

    public double getPris() {
        return this.pris;
    }
}
