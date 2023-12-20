package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonFactory.FordonInterface;

public class PoleraFordon extends FordonDecorator {

    double prisPolera = 300;

    public PoleraFordon(FordonInterface fordonInterface) {
        super(fordonInterface);
    }

    @Override
    public double getPrisExtra() {
        return prisPolera;
    }

    @Override
    public void extraService() {
        super.extraService();
        System.out.println("Polering.");
    }

    @Override
    public double getTotalPrisExtra(){
        System.out.println("Pris: " + prisPolera);
        return (super.getTotalPrisExtra() + prisPolera);

    }
    @Override
    public String toString() {
        return super.toString() + " Extra: Polering";
    }
}
