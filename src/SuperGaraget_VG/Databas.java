package SuperGaraget_VG;

import SuperGaraget_VG.FordonFactory.FordonInterface;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class Databas implements DatabasInterface {
    private final String filnamn = "src/fordonsFil.txt";

    public int sparaFordon(List<FordonInterface> parkeradeF) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filnamn))) {
            for (FordonInterface fordon : parkeradeF) {
                writer.write(fordon.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fel uppstod vid skrivning till fil.");
            return -1;
        }
        return 0;
    }

    public int läsInFordon(Garage garage) {

        FordonInterface f;
        try (BufferedReader reader = new BufferedReader(new FileReader(filnamn))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tempDelar = line.split(", ");

                String fordonsTyp = tempDelar[0];
                String regNummer = tempDelar[1];
                LocalDate parkeringsDatum = LocalDate.parse(tempDelar[2]);

                if ((f = garage.skapaFordon(fordonsTyp, regNummer, parkeringsDatum)) != null) {
                    garage.läggFordonTillListan(f);
                } else {
                    System.out.println("Fel vid inläsning");
                    return -1;
                }
            }
        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil.");
            return -1;
        }

        // return parkeradeBilar;
        return 0;
    }
}