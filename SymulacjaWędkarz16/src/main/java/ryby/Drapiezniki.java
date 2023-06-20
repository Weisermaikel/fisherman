package ryby;

import plansza.Plansza;

import java.util.Random;

public class Drapiezniki extends Ryby{
    private int koordynatX;
    private int koordynatY;
    private final Plansza plansza;
    public Drapiezniki(int x, int y, Plansza plansza){
        super(x, y, plansza);
        koordynatX = x;
        koordynatY = y;
        this.plansza = plansza;
        plansza.setPola(x,y,this);
    }

    /**
     * ruch drapieżnika, który uwzględnia zjadanie innych ryb - rozszerza standardowy ruch ryby
     */


    @Override
    public void ruch() {
        int ruchX = 0;
        int ruchY = 0;
        Random losowanie = new Random();
        char KtoryKoordynat = (char) (losowanie.nextInt(2) + 120);
        switch (KtoryKoordynat) {
            case 'x':
                while (ruchX == 0 || koordynatX + ruchX >= plansza.getRozmiarX() || koordynatX + ruchX < 0)
                    ruchX = losowanie.nextInt(3) - 1;
                break;
            case 'y':
                while (ruchY == 0 || koordynatY + ruchY >= plansza.getRozmiarY() || koordynatY + ruchY < 0)
                    ruchY = losowanie.nextInt(3) - 1;
                break;
        }
        if (!plansza.czyZajete(koordynatX + ruchX, koordynatY + ruchY)) {
            plansza.przemieszczenie(koordynatX, koordynatY, koordynatX + ruchX, koordynatY + ruchY);
            koordynatX += ruchX;
            koordynatY += ruchY;
        } else {
            String kto = plansza.ktoJest(koordynatX + ruchX, koordynatY + ruchY);
            if (kto.equals("Średnia ryba") || kto.equals("Mała ryba") || kto.equals("Mała rybka")) {
                plansza.wyczyscPole(koordynatX + ruchX, koordynatY + ruchY);
                plansza.przemieszczenie(koordynatX, koordynatY, koordynatX + ruchX, koordynatY + ruchY);
                koordynatX += ruchX;
                koordynatY += ruchY;
                System.out.println("> Drapieżnik zjadł rybę");
            }

        }
    }

    public int getKoordynatX() {
        return koordynatX;
    }

    public int getKoordynatY() {
        return koordynatY;
    }

}
