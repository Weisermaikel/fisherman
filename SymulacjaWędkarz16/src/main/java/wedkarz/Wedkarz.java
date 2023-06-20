package wedkarz;

import plansza.Plansza;
import java.util.Random;

public class Wedkarz {

    private int koordynatX;
    private int koordynatY;
    private int iloscRuchow;
    private final Plansza plansza;
    private final Licznik zlowione;

    public Wedkarz(int x, int y, int rybki, int male, int srednie, int drapiezniki, Plansza plansza){
        if(x < 0 ||  y < 0 || y >= plansza.getRozmiarY() || x > plansza.getRozmiarX())
            throw new IllegalArgumentException("Błędne koordynaty");
        koordynatX = x;
        koordynatY = y;
        iloscRuchow = 0;
        zlowione = new Licznik(rybki, male, srednie, drapiezniki);
        this.plansza = plansza;
        plansza.setLodka(x,y,this);
        System.out.println("TESTY polożenie początkowe wędkarz x "+x+" y "+y);
    }


    /**
     * ruch wędkarza, który uwzględnia poruszanie się po mapie i decydowanie jakie kroki podjąć po spotkaniu
     * danej ryby lub obiektu
     */

    public void ruchW(){
        int ruchX = 0;
        int ruchY = 0;
        Random losowanie = new Random();

        char KtoryKoordynat = (char) (losowanie.nextInt(2)+120);
        switch(KtoryKoordynat){
            case 'x': while(ruchX == 0 || koordynatX+ruchX >= plansza.getRozmiarX() || koordynatX+ruchX < 0) ruchX = losowanie.nextInt(3)-1; break;
            case 'y': while(ruchY == 0 || koordynatY+ruchY >= plansza.getRozmiarY() || koordynatY+ruchY < 0) ruchY = losowanie.nextInt(3)-1; break;
        }
        if(!plansza.czyZajete(koordynatX+ruchX, koordynatY+ruchY)){
            plansza.plywanie(koordynatX, koordynatY, koordynatX+ruchX, koordynatY+ruchY);
            koordynatX += ruchX;
            koordynatY += ruchY;
            iloscRuchow++;
        }
        else {
            String kto = plansza.ktoJest(koordynatX + ruchX, koordynatY + ruchY);
            if (kto.equals("Średnia ryba") || kto.equals("Mała ryba") || kto.equals("Mała rybka")) {
                lowienie(kto, ruchX, ruchY);
                plansza.plywanie(koordynatX, koordynatY, koordynatX + ruchX, koordynatY + ruchY);
                koordynatX += ruchX;
                koordynatY += ruchY;
                iloscRuchow++;

            }
            if (kto.equals("Drapieżnik")) {
                String jaka = zlowione.przyneta();
                if (jaka.equals("Rybka")) {
                    lowienie(kto, ruchX, ruchY);
                    plansza.plywanie(koordynatX, koordynatY, koordynatX + ruchX, koordynatY + ruchY);
                    koordynatX += ruchX;
                    koordynatY += ruchY;
                    iloscRuchow++;
                }
            }
            if (kto.equals("Konary")) {
                Random los = new Random();
                int zerwij = los.nextInt(2);
                if (zerwij==1)
                    if (zlowione.sumaPunktow() > 5) {
                        zlowione.zmienPunkty(zlowione.sumaPunktow() - 5);
                        System.out.println("zerwana żyłka");
                    }
                plansza.plywanie(koordynatX, koordynatY, koordynatX + ruchX, koordynatY + ruchY);
                koordynatX += ruchX;
                koordynatY += ruchY;
                iloscRuchow++;
            }
        }
        System.out.println("RUCH polożenie wędkarza: x "+koordynatX +" y "+koordynatY);

    }

    /**
     * łowienie ryb i ich zapamiętywanie
     */


    public void lowienie(String kto, int ruchX, int ruchY){
        if (kto.equals("Mała rybka")){
            zlowione.setIloscMalychRybek(zlowione.getIloscMalychRybek() + 1);
            System.out.println("/ Wędkarz złowił małą rybkę");
        }
        if (kto.equals("Mała ryba")){
            zlowione.setIloscMalychRyb(zlowione.getIloscMalychRyb() + 1);
            System.out.println("/ Wędkarz złowił małą rybę");
        }
        if (kto.equals("Średnia ryba")){
            zlowione.setIloscSrednichRyb(zlowione.getIloscSrednichRyb() + 1);
            System.out.println("/ Wędkarz złowił średnią rybę");
        }
        if (kto.equals("Drapieżnik")){
            zlowione.setIloscDrapieznikow(zlowione.getIloscDrapieznikow() + 1);
            System.out.println("/ Wędkarz złowił drapieżnika");
        }
        plansza.wyczyscPole(getKoordynatX() + ruchX, getKoordynatY() + ruchY);

        int a= zlowione.getIloscMalychRybek();
        int b= zlowione.getIloscMalychRyb();
        int c= zlowione.getIloscSrednichRyb();
        int d= zlowione.getIloscDrapieznikow();

        System.out.println("= Małe rybki  "+ a + "  Małe ryby "+ b+ " Średnie ryby "+ c + " Drapieżniki "+d);

    }


    public int getKoordynatX() {
        return koordynatX;
    }

    public int getKoordynatY() {
        return koordynatY;
    }

    public int getIloscRuchow() {
        return iloscRuchow;}

    public int getIloscmalychrybek() {
        return zlowione.getIloscMalychRybek();}

    public int getIloscmalychryb() {
        return zlowione.getIloscMalychRyb();}

    public int getIloscsrednichryb() {
        return zlowione.getIloscSrednichRyb();}

    public int getIloscdrapieznikow() {
        return zlowione.getIloscDrapieznikow();}
}