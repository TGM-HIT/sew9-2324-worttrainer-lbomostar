import control.Controller;
import model.Rechtschreibtrainer;
import model.Wortliste;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.List;
/**
 * Die JUnit Testklasse
 * @author Luka Bomostar
 * @version 23.01.2024
 */
public class JUnitTest {
    @Test
    public void validateInput() {
        Wortliste liste = new Wortliste();
        liste.addWort("Bus","https://img.kleinezeitung.at/public/incoming/1np7me-Fotoliabus_1438859384265984_v0_h.jpg/alternates/WIDE_1200/Fotoliabus_1438859384265984_v0_h.jpg");
        Rechtschreibtrainer rt = new Rechtschreibtrainer(liste);
        rt.zufallWort();
        assertTrue(rt.check("Bus"));
    }

    @Test
    public void validateInputFalse() {
        Wortliste liste = new Wortliste();
        liste.addWort("Bus","https://img.kleinezeitung.at/public/incoming/1np7me-Fotoliabus_1438859384265984_v0_h.jpg/alternates/WIDE_1200/Fotoliabus_1438859384265984_v0_h.jpg");
        Rechtschreibtrainer rt = new Rechtschreibtrainer(liste);
        rt.zufallWort();
        assertFalse(rt.check("Flugzeug"));
    }

    @Test
    public void removeWort() {
        Wortliste liste = new Wortliste();
        liste.addWort("Bus","https://img.kleinezeitung.at/public/incoming/1np7me-Fotoliabus_1438859384265984_v0_h.jpg/alternates/WIDE_1200/Fotoliabus_1438859384265984_v0_h.jpg");
        liste.deleteWort("Bus");
        liste.addWort("Maus","https://www.zooroyal.de/magazin/wp-content/uploads/2017/05/maus-760x560.jpg");
        Rechtschreibtrainer rt = new Rechtschreibtrainer(liste);
        rt.zufallWort();
        assertTrue(rt.check("Maus"));

    }
}