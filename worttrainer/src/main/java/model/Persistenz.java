package model;
/**
 * Die Persistenz Klasse
 * @author Luka Bomostar
 * @version 23.01.2024
 */
public abstract class Persistenz {
    protected Rechtschreibtrainer trainer;
    public abstract void save();
    public abstract void load();
    /**
     * Konstruktor
     * @param trainer Der Rechtschreibtrainer
     */
    public Persistenz(Rechtschreibtrainer trainer) {
        this.trainer = trainer;
    }
    /**
     * getter-Methode
     * @return Der Wert der zurückgegeben wird
     */
    public Rechtschreibtrainer getTrainer() {
        return trainer;
    }
}