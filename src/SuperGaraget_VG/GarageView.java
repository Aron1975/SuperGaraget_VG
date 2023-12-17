package SuperGaraget_VG;

import javax.swing.*;

public class GarageView extends JFrame {

    public void skrivUtVälkomstText() {

        System.out.println("Välkommen till Super Garaget!");
        System.out.println("Om något inte fungerar kontakta oss på Supergaraget AB: 076 123 45 67" + "\n" +
                "\n Garaget är öppet: Måndag-Söndag 00:00 - 23:59." +
                "\n - Obemannat 16:00 - 23:59.");
    }

    public void skrivUtKundEllerAnställdMeddelande(String meddelande) {
        System.out.println(meddelande);
    }

    public void skrivUtAntaletLedigaPlatser(int ledigaPlatser) {
        System.out.println("Antal lediga platser i Garaget: " + ledigaPlatser);
        System.out.println(" ");
    }

    public void uppdateraInläsningsfältAnställd() {
        System.out.println("Vad vill du göra? Ange: \n- 1 för att söka i databas eller\n- 2 för Checka in eller checka ut en kund" +
                "\n- 3 för att skriva ut alla fordon" + " \n- 4 för att kontrollera parkeringstid."
                + " \n- 5 för att stänga ner programmet.");
    }

    public void skrivUtMeddelandeTillKund(String meddelande) {
        System.out.println(meddelande);

    }

    public void skrivUtFelmeddelande(String meddelande) {
        System.out.println(meddelande);
    }

    public void skrivUtSkrivLäsFilFelmeddelande(String meddelande){
        System.out.println(meddelande);
    }
}
