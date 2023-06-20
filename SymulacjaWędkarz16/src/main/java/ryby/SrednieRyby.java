package ryby;

import plansza.Plansza;

public class SrednieRyby extends Ryby{
    private int koordynatX;
    private int koordynatY;
    private final Plansza plansza;
    public SrednieRyby(int x, int y, Plansza plansza){
        super(x, y, plansza);
        koordynatX = x;
        koordynatY = y;
        this.plansza = plansza;
        plansza.setPola(x,y,this);
    }

    public int getKoordynatX() {
        return koordynatX;
    }

    public int getKoordynatY() {
        return koordynatY;
    }


}
