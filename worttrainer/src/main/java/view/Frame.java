package view;
import javax.swing.JPanel;
import javax.swing.JFrame;
/**
 * Die Klasse Frame
 * @author Luka Bomostar
 * @version 23.01.2024
 */
public class Frame extends JFrame {
    /**
     * Konstruktor
     * @param panel Das Layout
     */
    public Frame(JPanel panel) {
        super("Worttrainer");
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 600, 450);
        this.setVisible(true);
    }
}