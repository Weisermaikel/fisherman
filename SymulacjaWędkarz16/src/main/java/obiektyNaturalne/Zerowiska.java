package obiektyNaturalne;

import java.util.Random;

import plansza.Losowanie;
import plansza.Plansza;
import ryby.SrednieRyby;

public class Zerowiska extends ObiektyNaturalne {
    private int poleobiektuX;
    private int poleobiektuY;
    private final Plansza miejscenaplanszy;


    public Zerowiska(int x, int y, Plansza miejscenaplanszy){
        super(x,y,miejscenaplanszy);
        poleobiektuX = x;
        poleobiektuY = y;
        this.miejscenaplanszy = miejscenaplanszy;
    }

    public int getpoleobiektuX() {
        return poleobiektuX;
    }

    public int getpoleobiektuY() {
        return poleobiektuY;
    }




}
