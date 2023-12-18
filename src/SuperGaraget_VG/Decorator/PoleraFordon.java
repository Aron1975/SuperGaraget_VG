package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonInterface;

public class PoleraFordon extends FordonDecorator{

    double pris = 300;
    public PoleraFordon(FordonInterface fordonInterface) {
        super(fordonInterface);
    }

    @Override
    public double getPris() {
        return pris;
    }

    @Override
    public  void extraService(){
        System.out.println("Polering.");
    }
}
