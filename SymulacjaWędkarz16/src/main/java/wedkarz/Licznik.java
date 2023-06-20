package wedkarz;

public class Licznik {

    private int iloscMalychRybek;
    private int iloscMalychRyb;
    private int iloscSrednichRyb;
    private int iloscDrapieznikow;
    private int suma;

    public Licznik(int rybki, int male, int srednie, int drapiezniki){
        iloscMalychRybek = rybki;
        iloscMalychRyb = male;
        iloscSrednichRyb = srednie;
        iloscDrapieznikow = drapiezniki;
        suma = rybki + male*2 + srednie*3 + drapiezniki*5;
    }

    public int getIloscMalychRybek() {
        return iloscMalychRybek;
    }

    public int getIloscMalychRyb() {
        return iloscMalychRyb;
    }

    public int getIloscSrednichRyb() {
        return iloscSrednichRyb;
    }

    public int getIloscDrapieznikow() {
        return iloscDrapieznikow;
    }

    protected void setIloscMalychRybek(int iloscMalychRybek) {
        this.iloscMalychRybek = iloscMalychRybek;
    }

    protected void setIloscMalychRyb(int iloscMalychRyb) {
        this.iloscMalychRyb = iloscMalychRyb;
    }

    protected void setIloscSrednichRyb(int iloscSrednichRyb) {
        this.iloscSrednichRyb = iloscSrednichRyb;
    }

    protected void setIloscDrapieznikow(int iloscDrapieznikow) {
        this.iloscDrapieznikow = iloscDrapieznikow;
    }

    /**
     * jeśli wędkarz ma złowić drapieżnika, używa jedej małej rybki jako przynęty
     */

    protected String przyneta(){
        if (getIloscMalychRybek()>0){
            setIloscMalychRybek(getIloscMalychRybek() - 1);
            return "Rybka";
        }
        return "Zwykła";
    }

    public int sumaPunktow(){
        return suma;
    }

    protected void zmienPunkty(int suma){
        this.suma = suma;
    }

    /**
     * zlicza wszystkie punkty zdobyte przez wędkarza
     */

    public int  Zliczniepunktow(int rybki, int male, int srednie, int drapiezniki){
        int suma = rybki + male*2 + srednie*3 + drapiezniki*5;
        System.out.println("Ilość punktów łącznie: "+ suma);
        return suma ;
    }
}