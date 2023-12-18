package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonInterface;

public class BytaDäckFordon extends FordonDecorator{

    double pris = 200;
    public BytaDäckFordon(FordonInterface fordonInterface) {
        super(fordonInterface);
    }

    @Override
    public double getPris() {
        return pris;
    }

    @Override
    public  void extraService(){
        System.out.println("Däckbyte.");
    }
}
