package model;
import java.util.Random;
/**
 * Die Klasse Rechtschreibtrainer
 * @author Luka Bomostar
 * @version 22.01.2024
 */
public class Rechtschreibtrainer {
    private Worteintrag worteintrag;
    private Wortliste liste;
    private int spieleGewonnen;
    private int spieleGespielt;
    /**
     * Der Konstruktor
     * @param liste Die Liste
     * @throws IllegalArgumentException Diese Exception wird geworfen, falls die Eingabe nicht stimmt.
     */
    public Rechtschreibtrainer(Wortliste liste) {
        this.liste = liste;
    }
    /**
     * zufallWort...Diese Methode nimmt ein zufälliges Wort aus der Liste.
     * @throws IllegalArgumentException Diese Exception wird ausgegeben, wenn die Liste nicht gültig ist.
     */
    public void zufallWort() throws IllegalArgumentException {
        if (this.liste.getListe().isEmpty()) {
            throw new IllegalArgumentException("Die Liste ist leer.");
        }
        Random random = new Random();
        worteintrag = this.liste.getWort(random.nextInt(this.liste.getListe().size()));
    }
    /**
     * Methode: indexAuswahl...Mithilfe vom Index wird das Wort ausgewählt.
     * @param index Der Index
     * @throws IndexOutOfBoundsException Falls der Index ungültig ist.
     * @throws IllegalArgumentException  Falls die Liste leer ist.
     */
    public void indexAuswahl(int index) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index >= this.liste.getListe().size()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.liste.getListe().isEmpty()) {
            throw new IllegalArgumentException("Die Liste ist ungültig.");
        } else {
            this.worteintrag = this.liste.getWort(index);
        }
    }
    /**
     * checkGrossKleinschreibung...Hier wird nicht geachtet, ob das Wort klein oder groß ist.
     * @param wort Das Wort
     * @return Der Wert der zurückgegeben wird.
     */
    public boolean checkGrossKleinschreibung(String wort) {
        this.spieleGespielt++;
        if (wort.equalsIgnoreCase(this.worteintrag.getWort())) {
            this.spieleGewonnen++;
            return true;
        }
        return false;
    }
    /**
     * check...Hier schaut man ob die Eingabe, mit dem aktuellen Wort übereinstimmt.
     * @param wort Das Wort
     * @return Der Wert der zurückgegeben wird.
     */
    public boolean check(String wort) {
        this.spieleGespielt++;                              //jedes Mal, wenn etwas eingegeben wird, ist es ein Versuch
        if (wort.equals(this.worteintrag.getWort())) {
            this.spieleGewonnen++;
            return true;
        }
        return false;
    }
    /**
     * toString...Hier wird die Ausgabe als Textform zurückgegeben.
     */
    @Override
    public String toString() {
        String ausgabe = this.spieleGespielt + ", " + this.spieleGewonnen + "\n";
        ausgabe = ausgabe + this.liste.toString();
        return ausgabe;
    }
    /**
     * getter-Methode
     * @return Der Wert, der zurückgegeben wird.
     */
    public Wortliste getListe() {
        return liste;
    }
    /**
     * getter-Methode
     * @return Der Wert, der zurückgegeben wird.
     */
    public Worteintrag getWorteintrag() {
        return worteintrag;
    }
    /**
     * getter-Methode
     * @return Der Wert, der zurückgegeben wird.
     */
    public int getSpieleGespielt() {
        return this.spieleGespielt;
    }
    /**
     * getter-Methode
     * @return Der Wert, der zurückgegeben wird.
     */
    public int getSpieleGewonnen() {
        return spieleGewonnen;
    }
    /**
     * setter-Methode
     */
    public void setSpieleGespielt(int zahl) {
        this.spieleGespielt = zahl;
    }
    /**
     * setter-Methode
     */
    public void setListe(Wortliste list) {
        this.liste = list;
    }
    /**
     * setter-Methode
     */
    public void setSpieleGewonnen(int zahl) {
        this.spieleGewonnen = zahl;
    }
}