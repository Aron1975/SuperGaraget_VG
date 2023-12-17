package SuperGaraget_VG;

public class GarageMain {
    public GarageMain(DatabasInterface dbi, Garage g, GarageView v) {
        new GarageController(dbi, g, v);
        //v.setVisible(true);
    }


    public static void main(String[] args) {
        DatabasInterface dbi = new Databas();
        Garage g = new Garage();
        GarageView v = new GarageView();

        GarageMain garageMain = new GarageMain(dbi, g, v);
    }
}
