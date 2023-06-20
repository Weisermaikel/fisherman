package plansza;


import obiektyNaturalne.*;
import ryby.*;
import wedkarz.Wedkarz;


import java.util.Random;

public class Plansza {

    private int zajetePola;
    private final int rozmiarX;
    private final int rozmiarY;
    public final int iloscPol;
    private final Losowanie losowanie;
    private final Ryby[][] pola;
    private final ObiektyNaturalne[][] pole;
    private final Wedkarz[][] lodka;

    public Plansza(int x, int y, Losowanie losowanie){

        if (x<8 || y<8)
            throw new IllegalArgumentException("Podano za mały bok");
        if(x != y)
            throw new IllegalArgumentException("Plansza nie jest kwadratowa");

        rozmiarX = x;
        rozmiarY = y;
        iloscPol = x*y;
        zajetePola = 0;
        this.losowanie = losowanie;
        pola = new Ryby[x][y];
        pole = new ObiektyNaturalne[x][y];
        lodka = new Wedkarz[x][y];
        System.out.println("TESTY ilosc pol to " +iloscPol);
    }


    public void setPola(int x, int y,Ryby ryba){
        pola[x][y] = ryba;
        zajetePola++;
    }

    public void setLodka(int x, int y,Wedkarz wedkarz){
        y = 0;
        lodka[x][y] = wedkarz;
        zajetePola++;
    }

    public void setPolaobiekty(int x, int y,ObiektyNaturalne obiekt){
        pole[x][y] = obiekt;
    }

    public int getRozmiarY() {
        return rozmiarY;}

    public int getRozmiarX() {
        return rozmiarX;}

    /**
     * przemieszczenie odnosi się do ryb, a pływanie do ruchu wędkarza
    */
    public void przemieszczenie(int stareX, int stareY, int noweX, int noweY){
        pola[noweX][noweY] = pola[stareX][stareY];
        pola[stareX][stareY] = null;
    }

    public void plywanie(int stareX, int stareY, int noweX, int noweY){
        lodka[noweX][noweY] = lodka[stareX][stareY];
        lodka[stareX][stareY] = null;
    }

    public boolean czyZajete(int x, int y){
        if(pola[x][y] != null) return true;
        else return false;
    }

    public int getZajetePola() {
        return zajetePola;
    }


    /**
     * tworzy na planszy ryby i dodaje nowe, jeśli znajduje się ich mniej niż połowa pól planszy
     */

    public void uzupelnienie(){
        Random losuj = new Random();
        int x;
        int y;
        int z=0;

        while(zajetePola<iloscPol/2) {

            x = losuj.nextInt(getRozmiarX());
            y = losuj.nextInt(getRozmiarY());

            do{
                x = losuj.nextInt(getRozmiarX());
                y = losuj.nextInt(getRozmiarY());
            } while (czyZajete(x, y));


            if (!czyZajete(x, y)) {

                String kto = losowanie.losuj();
                if (kto.equals("Mała rybka")) {
                    new MaleRybki(x, y, this);
                }
                if (kto.equals("Mała ryba")) {
                    new MaleRyby(x, y, this);
                }
                if (kto.equals("Średnia ryba")) {
                    new SrednieRyby(x, y, this);
                }
                if (kto.equals("Drapieżnik")) {
                    new Drapiezniki(x, y, this);
                }
                z++;
                System.out.println("nowa RYBA położenie: x " + x + " y " + y + "  " + kto + "| ilość ryb: " + z);
            }
        }

    }

    public String ktoJest(int x, int y){
        if (pola[x][y].getClass() == Drapiezniki.class ) return "Drapieżnik";
        if (pola[x][y].getClass() == SrednieRyby.class) return "Średnia ryba";
        if (pola[x][y].getClass() == MaleRyby.class) return "Mała ryba";
        if (pola[x][y].getClass() == MaleRybki.class) return "Mała rybka";
        if (pole[x][y].getClass() == ZatopioneKonary.class) return "Konary";
        else return "Puste";
    }

    public void wyczyscPole(int x, int y){
        pola[x][y] = null;
        zajetePola--;
    }


    /**
     * tworzenie naturalnych obiektów na planszy - podwodnych łąk, konarów i żerowisk
     */

    public void Tworzenielaki() {

        if(getRozmiarX()>30 && getRozmiarX()<100)
            for(int i=0; i<2; i++) {
                Random r = new Random();
                int x;
                int y;
                int z;
                x = r.nextInt(getRozmiarX());
                y = r.nextInt(getRozmiarY());
                z=r.nextInt(losowanie.losSuma);
                new PodwodneLaki(x, y,this);
                if(z> losowanie.losSredniaRyba-2)
                    new SrednieRyby(x,y,this);
                System.out.println("TESTY Ląki x "+x+" y "+y);}
        if(getRozmiarX()>=100)
            for(int i=0; i<3; i++) {
                Random r = new Random();
                int x;
                int y;
                int z;
                x = r.nextInt(getRozmiarX());
                y = r.nextInt(getRozmiarY());
                z=r.nextInt(losowanie.losSuma);
                new PodwodneLaki(x, y, this);
                if(z> losowanie.losSredniaRyba-2)
                    new SrednieRyby(x,y,this);
                System.out.println("TESTY Ląki x "+x+" y "+y);}
        if(getRozmiarX()<=30)
            for(int i=0; i<1; i++) {
                Random r = new Random();
                int x;
                int y;
                int z;
                x = r.nextInt(getRozmiarX());
                y = r.nextInt(getRozmiarY());
                z=r.nextInt(losowanie.losSuma);
                new PodwodneLaki(x, y, this);
                if(z> losowanie.losSredniaRyba-2)
                    new SrednieRyby(x,y,this);
                System.out.println("TESTY Ląki x "+x+" y "+y);}

    }
    public void Tworzeniekonaru() {
        if(getRozmiarX()<30)
            for(int i=0; i<1; i++) {
                Random r = new Random();
                int x;
                int y;
                int z;
                x = r.nextInt(getRozmiarX());
                y = r.nextInt(getRozmiarY());
                z=r.nextInt(losowanie.losSuma);
                new ZatopioneKonary(x, y, this);
                if(z>losowanie.losSuma-1)
                    new SrednieRyby(x,y,this);
                System.out.println("TESTY Konar x "+x+" y "+y);}
        if(getRozmiarX()>100)
            for(int i=0; i<3; i++) {
                Random r = new Random();
                int x;
                int y;
                int z;
                x = r.nextInt(getRozmiarX());
                y = r.nextInt(getRozmiarY());
                z=r.nextInt(losowanie.losSuma);
                new ZatopioneKonary(x, y, this);
                if(z>losowanie.losSuma-1)
                    new SrednieRyby(x,y,this);
                System.out.println("TESTY Konar x "+x+" y "+y);}
        if(getRozmiarX()>=30 && getRozmiarX()<=100)
            for(int i=0; i<2; i++) {
                Random r = new Random();
                int x;
                int y;
                int z;
                x = r.nextInt(getRozmiarX());
                y = r.nextInt(getRozmiarY());
                z=r.nextInt(losowanie.losSuma);
                new ZatopioneKonary(x, y, this);
                if(z>losowanie.losSuma-1)
                    new SrednieRyby(x,y,this);
                System.out.println("TESTY Konar x "+x+" y "+y);}





    }
    public void Tworzeniezerowiska() {
        Random r = new Random();
        int x;
        int y;
        if(getRozmiarX()>=30 && getRozmiarX()<=100)
            for(int i=0; i<2; i++) {

                x = r.nextInt(getRozmiarX()-1);
                y = r.nextInt(getRozmiarY()-1);


                new Zerowiska(x, y, this);
                new SrednieRyby(x,y,this);
                new Zerowiska(x+1,y,this);
                new Zerowiska(x,y+1,this);
                new Zerowiska(x+1,y+1,this);
                System.out.println("TESTY Żerowisko x "+x+" y "+y);}
        if(getRozmiarX()<30)
            for(int i=0; i<1; i++) {

                x = r.nextInt(getRozmiarX()-1);
                y = r.nextInt(getRozmiarY()-1);

                new Zerowiska(x, y, this);
                new SrednieRyby(x,y,this);
                new Zerowiska(x+1,y,this);
                new Zerowiska(x,y+1,this);
                new Zerowiska(x+1,y+1,this);
                System.out.println("TESTY Żerowisko x "+x+" y "+y);}
        if(getRozmiarX()>100)
            for(int i=0; i<3; i++) {

                x = r.nextInt(getRozmiarX()-1);
                y = r.nextInt(getRozmiarY()-1);

                new Zerowiska(x, y, this);
                new SrednieRyby(x,y,this);
                new Zerowiska(x+1,y,this);
                new Zerowiska(x,y+1,this);
                new Zerowiska(x+1,y+1,this);
                System.out.println("TESTY Żerowisko x "+x+" y "+y);}


    }
}
