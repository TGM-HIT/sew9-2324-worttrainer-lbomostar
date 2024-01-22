package model;
import org.apache.commons.validator.routines.UrlValidator;
public class Worteintrag {
    /**
     * Die Klasse Worteintrag
     * @author Luka Bomostar
     * @version 22.01.2024
     */
    private String url = "";
    private String wort = "";
    /**
     * Konstruktor
     * @param wort Das Wort des Worteintrages
     * @param url  Die URL des Worteintrages
     * @throws IllegalArgumentException Diese Exception wird geworfen, falls die Eingaben nicht stimmen.
     */
    public Worteintrag(String wort, String url) throws IllegalArgumentException {
        this.setWort(wort);
        this.setUrl(url);
    }
    /**
     * getWort
     * @return Der Wert, der zurückgegeben wird.
     */
    public String getWort() {
        return this.wort;
    }
    /**
     * setter-Methode
     * @return Der Wert der zurückgegeben wird.
     */
    public String getUrl() {
        return this.url;
    }
    /**
     * urlUeberpruefung...Hier wird geschaut, ob die URL gültig ist.
     * @param url Die URL die überprüft werden soll.
     * @return true oder false
     */
    public static boolean urlUeberpruefung(String url) {
        String[] types = {"http", "https", "ftp"};
        UrlValidator validator = new UrlValidator(types);
        return validator.isValid(url);
    }
    /**
     * setter-Methode
     * @param wort Das Wort
     * @throws IllegalArgumentException Diese Exception wird geworfen, falls das Wort nicht passt.
     */
    public void setWort(String wort) throws IllegalArgumentException {
        if (wort == null) {
            throw new IllegalArgumentException("Das Wort ist nicht gültig");
        }
        if (wort.length() >=2) {
            this.wort = wort;
        } else {
            throw new IllegalArgumentException("Das Wort ist nicht gültig");
        }
    }
    /**
     * setter-Methode
     * @param url Die URL
     * @throws IllegalArgumentException Diese Exception wird geworfen, falls das Wort nicht passt.
     */
    public void setUrl(String url) throws IllegalArgumentException {
        if (Worteintrag.urlUeberpruefung(url)) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("Die URL ist nicht gültig");
        }
    }
    /**
     * toString...Der Wert wird in Textform zurückgegeben
     * @return Der Wert, der zurückgegeben wird
     */
    @Override
    public String toString() {
        return this.wort + ", " + this.url;
    }
}
