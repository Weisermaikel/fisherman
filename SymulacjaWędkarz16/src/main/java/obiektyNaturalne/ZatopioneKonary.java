package obiektyNaturalne;

import java.util.Random;

import plansza.Losowanie;
import plansza.Plansza;
import ryby.SrednieRyby;

public class ZatopioneKonary extends ObiektyNaturalne {
    private int poleobiektuX;
    private int poleobiektuY;
    private final Plansza miejscenaplanszy;

    public ZatopioneKonary(int x, int y, Plansza miejscanaplanszy){
        super(x, y, miejscanaplanszy);
        poleobiektuX = x;
        poleobiektuY = y;
        this.miejscenaplanszy = miejscanaplanszy;
    }

    public int getpoleobiektuX() {
        return poleobiektuX;
    }

    public int getpoleobiektuY() {
        return poleobiektuY;
    }




}
