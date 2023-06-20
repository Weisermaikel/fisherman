package main;

import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import plansza.*;
import ryby.*;
import wedkarz.*;

public class Main {
    /**
     * zapisanie informacji o wyniku symulacji do pliku z rozszerzeniem .txt
    */
    public static void zapisPliku(String nazwa, int iloscruchow, int drap, int sumapkt) throws IOException {
        FileWriter plik = null;
        try {

            plik = new FileWriter(nazwa);
            String tekst = "Symulacja zakończona po ";
            int x= iloscruchow;
            String tekst1 = " ruchach, złowiono ";
            int d= drap;
            String tekst2 = " drapieżników i uzyskano ";
            int s= sumapkt;
            String tekst3 = " punktów.";
            plik.write(tekst+x+ tekst1+d+tekst2+s+tekst3);
        }
        finally {
            if (plik != null) {
                plik.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Podaj długość boku planszy: ");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        Licznik licznik = new Licznik(0, 0, 0, 0);
        Losowanie los = new Losowanie(5, 40, 30, 10);
        Plansza testplansza = new Plansza(x, x, los);
        testplansza.Tworzenielaki();
        testplansza.Tworzeniekonaru();
        testplansza.Tworzeniezerowiska();
        Random rand = new Random();
        int z = rand.nextInt(x);
        Wedkarz testwedkarz = new Wedkarz(z, 0, 0, 0, 0, 0, testplansza);
        Drapiezniki testdrapieznik = new Drapiezniki(5,5,testplansza);
        testplansza.uzupelnienie();
        int zajetepola=testplansza.getZajetePola();

        licznik.Zliczniepunktow(testwedkarz.getIloscmalychrybek(),testwedkarz.getIloscmalychryb(),testwedkarz.getIloscsrednichryb(),testwedkarz.getIloscdrapieznikow());


        /**
         * pętla, w której dzieje się symulacja - odbywa sie ruch wękdarza, drapieżnika i uzupełnianie brakujących ryb
         */

        do{
            testwedkarz.ruchW();
            testdrapieznik.ruch();
            testplansza.uzupelnienie();
        } while(licznik.Zliczniepunktow(testwedkarz.getIloscmalychrybek(),testwedkarz.getIloscmalychryb(),testwedkarz.getIloscsrednichryb(),testwedkarz.getIloscdrapieznikow())<30 || testwedkarz.getIloscdrapieznikow()<1);


        int iloscruchów= testwedkarz.getIloscRuchow();
        int drap = testwedkarz.getIloscdrapieznikow();
        int sumapkt = licznik.Zliczniepunktow(testwedkarz.getIloscmalychrybek(),testwedkarz.getIloscmalychryb(),testwedkarz.getIloscsrednichryb(),testwedkarz.getIloscdrapieznikow());
        System.out.println("Symulacja zakończona po "+ iloscruchów + " ruchach");
        String nazwaPliku = "test.txt";
        zapisPliku(nazwaPliku,iloscruchów,drap,sumapkt);}
}
