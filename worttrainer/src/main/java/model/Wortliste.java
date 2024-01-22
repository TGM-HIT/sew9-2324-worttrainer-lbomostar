package model;
import java.util.LinkedList;
/**
 * Die Klasse Wortliste
 * @author Luka Bomostar
 * @version 22.01.2024
 */
public class Wortliste {
    private LinkedList<Worteintrag> liste;
    /**
     * Der Konstruktor
     */
    public Wortliste() {
        this.liste = new LinkedList<>();
    }
    /**
     * getter-Methode...hier wird ein Worteintrag zurückgegeben
     * @param index Der Index
     * @return Der Wert, der zurückgegeben wird.
     * @throws IndexOutOfBoundsException Hier tritt die Exception ein, wenn der Index nicht gültig ist.
     */
    public Worteintrag getWort(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.liste.size()) {
            return this.liste.get(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * getter-Methode
     * @return Der Wert, der zurückgegeben wird.
     */
    public LinkedList<Worteintrag> getListe() {
        return this.liste;
    }
    /**
     * addWort...hier wird ein Wort erstellt, und anschließend in die Liste hinzugefügt.
     * @param wort Das Wort
     * @param url  Die URL
     * @throws IllegalArgumentException Diese Exception wird geworfen, falls die Eingaben nicht stimmen.
     */
    public void addWort(String wort, String url) throws IllegalArgumentException {
        Worteintrag eintrag = new Worteintrag(wort, url);
        this.liste.addLast(eintrag);                            //fügt es oben darauf hinzu
    }
    /**
     * deleteWort...hier wird ein Wort aus der Liste gelöscht.
     * @param wort Das Wort
     * @return true oder false
     * @throws IllegalArgumentException Diese Exception wird geworfen, falls das Wort nicht passt.
     */
    public boolean deleteWort(String wort) throws IllegalArgumentException {
        boolean ausgabe = false;
        if (wort.length() < 2) {
            throw new IllegalArgumentException("Das Wort ist nicht gültig");
        }
        if (wort == null) {
            throw new IllegalArgumentException("Das Wort ist nicht gültig");
        }
        for (Worteintrag eintrag : this.liste) {
            if (eintrag.getWort().equals(wort)) {
                ausgabe = true;
                this.liste.remove();
            }
        }
        return ausgabe;
    }
    /**
     * toString...hier wird die Ausgabe als Textform zurückgegeben
     * @return Der String-Text
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Worteintrag eintrag : this.liste) {
            text.append(eintrag.toString()).append("\n");
        }
        return text.toString();
    }
}
