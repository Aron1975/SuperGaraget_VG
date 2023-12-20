package SuperGaraget_VG.FordonFactory;

import SuperGaraget_VG.FordonFactory.FordonInterface;

import java.time.LocalDate;
public abstract class Fordon implements FordonInterface {

    private String regNr;
    private String modell = "";
    private String färg = "";
    private String ägare = "";
    private LocalDate incheckningstid;


    public Fordon(String regNr, String modell, String färg, String ägare, LocalDate incheckningstid) {

        this.regNr = regNr;
        this.modell = modell;
        this.färg = färg;
        this.ägare = ägare;
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

    /*public  void extraService(){
        System.out.println("Inget extra: ");
    }*/
    public  void extraService(){}
    @Override
    public double getPrisExtra() {return 0;}

    @Override
    public double getTotalPrisExtra(){return 0;}
}
