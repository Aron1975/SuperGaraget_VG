package SuperGaraget_VG.FordonFactory;

import java.time.LocalDate;

public interface FordonInterface {

    String toString();

    LocalDate getIncheckningstid();

    String getRegNr();

    double getPris();

    void extraService();

    double getPrisExtra();

    double getTotalPrisExtra();

}
