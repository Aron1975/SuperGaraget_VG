package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonFactory.FordonInterface;

public class BytaDäckFordon extends FordonDecorator {

    double prisBytaDäck = 200;

    public BytaDäckFordon(FordonInterface fordonInterface) {
        super(fordonInterface);
    }

    @Override
    public double getPrisExtra() {
        return prisBytaDäck;
    }

    @Override
    public void extraService() {
        super.extraService();
        System.out.println("Däckbyte: " + prisBytaDäck);
    }

    @Override
    public double getTotalPrisExtra(){
        return (super.getTotalPrisExtra() + prisBytaDäck);
    }

    @Override
    public String toString() {
        return super.toString() + " Extra: Däckbyte";
    }
}
