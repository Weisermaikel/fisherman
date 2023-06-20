package obiektyNaturalne;

import plansza.Losowanie;
import plansza.Plansza;
import ryby.SrednieRyby;

import java.util.Random;

public class PodwodneLaki extends ObiektyNaturalne{

    private int poleobiektuX;
    private int poleobiektuY;
    private final Plansza miejscenaplanszy;

    public PodwodneLaki(int x, int y, Plansza miejscanaplanszy){
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

