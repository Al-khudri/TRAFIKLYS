import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // oprettet en scanner instans for at læse input fra brugeren
        Scanner scanner = new Scanner(System.in);
        // bruger indtaster information
        System.out.println("Tid på dagen(dag,aften,nat)");
        String tid = scanner.nextLine().toLowerCase();

        System.out.println("Trafik mængde(høj eller lav)");
        String trafik = scanner.nextLine().toLowerCase();

        System.out.println("Område(bolig,erhverv,blandet)");
        String omraade = scanner.nextLine().toLowerCase();

        System.out.println("Er dette en nødsituation (ja,nej)");
        String noedsituation = scanner.nextLine().toLowerCase();

        //Bestemmer trafiklysets farve
        String trafiklys = "Rødt";
        // if og else if bestemmer trafiklys ud fra brugerens input
        if (noedsituation.equals("ja")){
            trafiklys = "Grønt"; // Nødsituation har altid prioritet
        }
        else if (tid.equals("dag") && trafik.equals("lav")) {
            trafiklys = "Grønt";
        }
        else if (tid.equals("aften")){
            trafiklys = "Gult";
        } 
        else if (tid.equals("nat") && trafik.equals("lav")) {
            trafiklys = "Gult";
        }
        else if (tid.equals("nat") && trafik.equals("høj")) {
            trafiklys = "Rødt";
        }
        else if (omraade.equals("bolig") && trafik.equals("høj")) {
            trafiklys = "Rødt";
        }
        // Bestem adgang til området OG HUSK INGEN CITATIONER I BOOLEAN
        boolean adgang = true;
        if (omraade.equals("erhverv") || omraade.equals("blandet") && trafik.equals("lav")) {
            adgang = true; // tillader biler i erhvervs område og blandet område med høj trafik
        }
        else if (omraade.equals("bolig") && tid.equals("nat")) {
             adgang = false; // forbyder adgang hvis det er bolig område og nat
        }
        // Udskriv resultatet
        System.out.println("Trafiklyset viser: " + trafiklys);
        if (adgang) {
            System.out.println("Biler har adgang til området.");
        }
        else {
            System.out.println("Biler har ikke adgang til området.");
        }


    }
}