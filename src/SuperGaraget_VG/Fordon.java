package SuperGaraget_VG;

import java.time.LocalDate;
public abstract class Fordon implements FordonInterface{

    private String regNr;
    private String modell = "";
    private String färg = "";
    private String ägare = "";
    private LocalDate incheckningstid;

    public Fordon(String regNr, String modell, String färg, LocalDate incheckningstid) {

        this.regNr = regNr;
        this.modell = modell;
        this.färg = färg;
        this.incheckningstid = incheckningstid;
    }

    public Fordon(String regNr, LocalDate incheckningstid) {
        this.regNr = regNr;
        this.incheckningstid = incheckningstid;
    }

    @Override
    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getFärg() {
        return färg;
    }

    public void setFärg(String färg) {
        this.färg = färg;
    }

    @Override
    public LocalDate getIncheckningstid() {
        return incheckningstid;
    }

    public void setIncheckningstid(LocalDate incheckningstid) {
        this.incheckningstid = incheckningstid;
    }

    public abstract double getPris();
}
