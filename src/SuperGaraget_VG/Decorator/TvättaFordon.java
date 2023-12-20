package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonFactory.FordonInterface;


public class TvättaFordon extends FordonDecorator {

    double prisTvätt = 99;

    public TvättaFordon(FordonInterface fordonInterface) {
        super(fordonInterface);
    }

    /*
    @Override
    public double getPris() {
        return pris;
    }*/

    public double getPrisExtra() {
        return prisTvätt;
    }

    @Override
    public void extraService() {
        super.extraService();
        //System.out.println("Tvätt: " + prisTvätt);
        System.out.println("Tvätt: ");
    }

    @Override
    public double getTotalPrisExtra(){
        System.out.println("Pris: " + prisTvätt);
        return (super.getTotalPrisExtra() + prisTvätt);
    }

    @Override
    public String toString(){
        return super.toString() + " Extra: Tvätt";
    }
}
