package ryby;

import plansza.Plansza;

import java.util.Random;

public class Ryby {

    private int koordynatX;
    private int koordynatY;
    private final Plansza plansza;

    public Ryby(int x, int y, Plansza plansza){
        koordynatX = x;
        koordynatY = y;
        this.plansza = plansza;
    }

    /**
     * ruch ryby bez zjadania innych
     */

    public void ruch(){
        boolean czyMozliwy = false;
        int ruchX = 0;
        int ruchY = 0;
        Random losowanie = new Random();

        if(koordynatX+1 < plansza.getRozmiarX()){
            if(!plansza.czyZajete(koordynatX+1, koordynatY)) czyMozliwy = true;}
        if(koordynatX-1 >= 0){
            if(!plansza.czyZajete(koordynatX-1, koordynatY)) czyMozliwy = true;}
        if(koordynatY+1 < plansza.getRozmiarY()){
            if(!plansza.czyZajete(koordynatX, koordynatY+1)) czyMozliwy = true;}
        if(koordynatY-1 >= 0){
            if(!plansza.czyZajete(koordynatX, koordynatY-1)) czyMozliwy = true;}

        if(czyMozliwy){
            char KtoryKoordynat = (char) (losowanie.nextInt(2)+120);
            switch(KtoryKoordynat){
                case 'x': while(ruchX == 0 || koordynatX+ruchX >= plansza.getRozmiarX() || koordynatX+ruchX < 0 || plansza.czyZajete(koordynatX+ruchX, koordynatY)) ruchX = losowanie.nextInt(3)-1; break;
                case 'y': while(ruchY == 0 || koordynatY+ruchY >= plansza.getRozmiarY() || koordynatY+ruchY < 0 || plansza.czyZajete(koordynatX, koordynatY+ruchY)) ruchY = losowanie.nextInt(3)-1; break;
            }
            plansza.przemieszczenie(koordynatX, koordynatY, koordynatX+ruchX, koordynatY+ruchY);
            koordynatX += ruchX;
            koordynatY += ruchY;
        }
    }

}
