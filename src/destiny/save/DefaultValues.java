package destiny.save;

import destiny.mover.Monster;
import destiny.mover.Mover;

import java.io.*;
import java.util.ArrayList;

import static destiny.GameManager.getDefaultSpellsList;

public class DefaultValues {

    public static ArrayList<Mover> getMonstersListFile() {
        ArrayList<Mover> lstMonsters = new ArrayList<>();
        try {
            File file = new File("monstres_values.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.startsWith("#"))
                    continue;
                String[] data = line.split("\t");
                if(!data[0].equals("MONSTER"))
                    continue;
                lstMonsters.add(new Monster(data[2], Integer.parseInt(data[3]), getDefaultSpellsList(), data[4].equals("true")));
            }
            fileReader.close();
        }
        catch (IOException e) {
            lstMonsters.add(new Monster("Monster 1", 120, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 2", 140, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 3", 160, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 4", 180, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 5", 200, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 6", 220, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 7", 240, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 8", 260, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 9", 280, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 10", 300, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Monster 11", 320, getDefaultSpellsList(), false));
            lstMonsters.add(new Monster("Boss final", 400, getDefaultSpellsList(), true));
        }
        return lstMonsters;
    }

}
