package plansza;
import java.util.Random;

public class Losowanie {

    /**
     przechowuje "moc losowania" - im wieksza, tym większe prawdopodobieństwo wylosowania,
     losSuma to suma wszystkich mocy
    */
    public final int losSuma;
    private final int losDrapieznik;
    private final int losMalaRybka;
    private final int losMalaRyba;
    public final int losSredniaRyba;


    public Losowanie(int drapieznik, int mRybka, int mRyba, int sRyba){
        losDrapieznik = drapieznik;
        losMalaRybka = mRybka;
        losMalaRyba = mRyba;
        losSredniaRyba = sRyba;
        losSuma = drapieznik + mRybka + mRyba + sRyba;
    }

    protected String losuj(){
        Random losowanie = new Random();
        int liczba = losowanie.nextInt(losSuma)+1;

        if (liczba <= losMalaRybka) return "Mała rybka";
        if (liczba > losMalaRybka && liczba <= (losMalaRyba+losMalaRybka)) return "Mała ryba";
        if (liczba > losMalaRyba && liczba <= (losMalaRyba+losMalaRybka+losSredniaRyba)) return "Średnia ryba";
        if (liczba > losSredniaRyba && liczba <= (losMalaRyba+losMalaRybka+losSredniaRyba+losDrapieznik)) return "Drapieżnik";
        return "Błąd";
    }
}
