package obiektyNaturalne;

import plansza.Plansza;

public class ObiektyNaturalne {

    private int poleobiektuX;
    private int poleobiektuY;
    private final Plansza miejscenaplanszy;


    public ObiektyNaturalne(int x, int y, Plansza miejscenaplanszy){
        poleobiektuX = x;
        poleobiektuY = y;
        this.miejscenaplanszy = miejscenaplanszy;

        miejscenaplanszy.setPolaobiekty(x,y,this);
    }


}