package model;
import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.IOException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
/**
 * Die PersistenzJSON Klasse
 * @author Luka Bomostar
 * @version 23.01.2024
 */
public class PersistenzJSON extends Persistenz {
    /**
     * Konstruktor
     * @param trainer Der Rechtschreibtrainer
     */
    public PersistenzJSON(Rechtschreibtrainer trainer) {
        super(trainer);
    }
    /**
     * speichern Methode
     */
    @Override
    public void save() {
        FileWriter fileWriter = null;
        JSONObject jsonObject = new JSONObject(trainer);
        try {
            fileWriter = new FileWriter("persistenz.json");
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }
    /**
     * laden Methode
     */
    public void load() {
        try {
            Reader input = new FileReader("persist.json");
            Gson gson = new Gson();
            Type type = new TypeToken<Rechtschreibtrainer>(){}.getType();
            trainer = gson.fromJson(input, type);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

