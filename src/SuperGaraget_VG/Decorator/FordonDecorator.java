package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonFactory.FordonInterface;

import java.time.LocalDate;


//import
public abstract class FordonDecorator implements FordonInterface {
    private FordonInterface fordonInterface;
    //private double totalPrisExtra;

    public FordonDecorator(FordonInterface fordonInterface) {
        this.fordonInterface = fordonInterface;
    }

    @Override
    public LocalDate getIncheckningstid() {
        return fordonInterface.getIncheckningstid();
    }

    @Override
    public String getRegNr() {

        return fordonInterface.getRegNr();
    }
    @Override
    public void extraService(){
        System.out.println("Service beställt: ");
    }

    @Override
    public double getPris(){
        return fordonInterface.getPris();
    }

    public double getTotalPrisExtra(){
        //return totalPrisExtra;
        return fordonInterface.getTotalPrisExtra();
    }

    @Override
    public String toString(){
        return fordonInterface.toString();
    }
}
