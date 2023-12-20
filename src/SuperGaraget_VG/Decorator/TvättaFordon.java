package SuperGaraget_VG.Decorator;

import SuperGaraget_VG.FordonFactory.FordonInterface;


public class TvättaFordon extends FordonDecorator {

    double prisTvätt = 99;

    public TvättaFordon(FordonInterface fordonInterface) {
        super(fordonInterface);
    }

    public double getPrisExtra() {
        return prisTvätt;
    }

    @Override
    public void extraService() {
        super.extraService();
        System.out.println("Tvätt: " + prisTvätt);
    }

    @Override
    public double getTotalPrisExtra(){
        return (super.getTotalPrisExtra() + prisTvätt);
    }

    @Override
    public String toString(){
        return super.toString() + " Extra: Tvätt";
    }
}
