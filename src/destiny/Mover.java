package src.destiny;

import java.util.ArrayList;

public abstract class Mover {
    private int HP;
    private String name;
    private ArrayList<Sort> sorts;

    public int getHP() { return this.HP; }
    public void setHP(int HP) { this.HP = HP; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Sort> getSorts() { return this.sorts; }
    public void setSorts(ArrayList<Sort> sorts) { this.sorts = sorts; }

}