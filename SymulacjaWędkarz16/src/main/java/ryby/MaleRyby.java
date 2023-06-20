package ryby;

import plansza.Plansza;

public class MaleRyby extends Ryby{
    private int koordynatX;
    private int koordynatY;
    private final Plansza plansza;
    public MaleRyby(int x, int y, Plansza plansza){
        super(x, y, plansza);
        koordynatX = x;
        koordynatY = y;
        this.plansza = plansza;
        plansza.setPola(x,y,this);
        //ruch();
    }

    public int getKoordynatX() {
        return koordynatX;
    }

    public int getKoordynatY() {
        return koordynatY;
    }


}
