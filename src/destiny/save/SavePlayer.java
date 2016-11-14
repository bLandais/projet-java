package destiny.save;

import destiny.mover.Mover;
import destiny.mover.Player;

import java.io.*;

public class SavePlayer {
    private static Mover moverSave;
    private static ObjectOutputStream oos;

    /**
     * Serialisation de l'objet Mover
     */
    public static void saveMover() {
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("tonFichierTexte.txt"))));
            oos.writeObject(moverSave);
            oos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialisation de l'objet Mover
     * @return L'objet lu depuis le fichier de sauvegarde (ou null en cas d'erreur)
     */
    public static Mover lireMover() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("tonFichierTexte.txt"))));
            moverSave = (Mover) ois.readObject();
            ois.close();
            return moverSave;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        finally {
            return null; // en cas d'erreur
        }
    }
}