package SuperGaraget_VG;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GarageMain {
    public GarageMain(DatabasInterface dbi, Garage g, View v) {
        new GarageController(dbi, g, v);
        //v.setVisible(true);
    }


    public static void main(String[] args) {
        DatabasInterface dbi = new Databas();
        Garage g = new Garage();
        View v = new View();

        GarageMain garageMain = new GarageMain(dbi, g, v);
    }
}
