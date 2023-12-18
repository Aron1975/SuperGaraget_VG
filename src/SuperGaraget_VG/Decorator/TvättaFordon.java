package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonInterface;


public class TvättaFordon extends FordonDecorator{

    double pris = 100;
    public TvättaFordon(FordonInterface fordonInterface) {
        super(fordonInterface);
    }

    @Override
    public double getPris() {
        return pris;
    }

    @Override
    public  void extraService(){
        System.out.println("Tvätt");
    }
}
