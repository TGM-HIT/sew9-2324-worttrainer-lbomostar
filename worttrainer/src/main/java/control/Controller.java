package control;
import model.Persistenz;
import model.PersistenzJSON;
import model.Rechtschreibtrainer;
import model.Worteintrag;
import model.Wortliste;
import view.Frame;
import view.Panel;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JOptionPane;
/**
 * Die Klasse Controller
 * @author Luka Bomostar
 * @version 23.01.2024
 */
public class Controller implements ActionListener {
        private Panel panel;
        private Frame frame;
        private Rechtschreibtrainer trainer;
        private Persistenz persistenz;

        public Controller() {
            trainer = new Rechtschreibtrainer(new Wortliste());
            persistenz = new PersistenzJSON(trainer);
            persistenz.load();
            trainer = persistenz.getTrainer();
            panel = new Panel(this);
            frame = new Frame(panel);
            panel.statistikAktualisieren(trainer.getSpieleGespielt(), trainer.getSpieleGewonnen());
            this.zeigWort();
        }

        /**
         * Methode: actionPerformed...der Eventhandler
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Zurücksetzen")) {
                this.reset();
                persistenz.save();
            } else if (e.getActionCommand().equals("Wort hinzufügen")) {
                this.addWort();
                persistenz.save();
            } else {
                this.check();
                persistenz.save();
            }
        }

        public static void main(String[] args) {
            Controller control = new Controller();
        }
        /**
         * Methdoe: addWort...hier wird ein Wort hinzugefügt
         */
        public void addWort() {
            String wort = JOptionPane.showInputDialog(null, "Geben Sie das Wort ein: ");
            String url = JOptionPane.showInputDialog(null, "Geben Sie die URL ein: ");
            if (wort != null && url != null) {
                if (trainer == null) {
                    Wortliste liste = null;
                    try {
                        liste = new Wortliste();
                        liste.addWort(wort, url);
                        trainer = new Rechtschreibtrainer(liste);
                        this.zeigWort();
                    } catch (IllegalArgumentException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                } else {
                    Wortliste liste = trainer.getListe();
                    try {
                        liste.addWort(wort, url);
                    } catch (IllegalArgumentException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                        liste = null;
                    }
                    if (liste != null) {
                        trainer.setListe(liste);
                    }
                }
            }
        }

        /**
         * zeigWort...hier wird das Wort angezeigt
         */
        public void zeigWort() {
            if (trainer != null) {
                trainer.zufallWort();
                Worteintrag zufall = trainer.getWorteintrag();
                URL url = null;
                try {
                    url = new URL(zufall.getUrl());
                } catch (MalformedURLException e1) {
                    JOptionPane.showMessageDialog(null, "URL nicht gefunden: " + e1.getMessage());
                    try {
                        Wortliste liste = trainer.getListe();
                        liste.deleteWort(trainer.getWorteintrag().getWort());
                    } catch (IllegalArgumentException e2) {
                        trainer = null;
                    }
                }
                if (url != null) panel.bildAendern(url);
            }
        }

        /**
         * check...hier wird das Wort welches übergeben wird durch die Eingagbe, und anschließend wird es mit dem aktuellen Wort verglichen.
         */
        public void check() {
            String wort = panel.getTextFromTextField();
            if (trainer.check(wort)) {
                JOptionPane.showMessageDialog(null, "Das Wort ist richtig geschrieben");
                this.zeigWort();
            } else {
                trainer.setSpieleGespielt(trainer.getSpieleGespielt() - 1);
                if (trainer.checkGrossKleinschreibung(wort)) {
                    trainer.setSpieleGewonnen(trainer.getSpieleGewonnen() - 1);
                    JOptionPane.showMessageDialog(null, "Die Gro\\u00df-/Kleinschreibung ist falsch");
                } else {
                    JOptionPane.showMessageDialog(null, "Das Wort ist falsch");
                }
            }
            panel.statistikAktualisieren(trainer.getSpieleGespielt(), trainer.getSpieleGewonnen());
        }

        /**
         * reset...hier werden die Werte zurückgesetzt, also auf default
         */
        public void reset() {
            trainer.setSpieleGespielt(0);
            trainer.setSpieleGewonnen(0);
            panel.statistikAktualisieren(0, 0);
        }
    }