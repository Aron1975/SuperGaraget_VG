package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonInterface;

import java.time.LocalDate;


//import
public abstract class FordonDecorator implements FordonInterface {
    private FordonInterface fordonInterface;

    public FordonDecorator(FordonInterface fordonInterface) {
        this.fordonInterface = fordonInterface;
    }

    @Override
    public LocalDate getIncheckningstid() {
        return null;
    }

    @Override
    public String getRegNr() {
        return null;
    }
    @Override
    public  void extraService(){
        System.out.println("Service beställt: ");
    }

}
