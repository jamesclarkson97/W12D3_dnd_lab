package player;

import java.util.ArrayList;

public abstract class Player {
    private int healthPoints;
    protected String weapon;
    protected ArrayList<String> spells;

    public Player(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public ArrayList<String> getSpells() {
        return this.spells;
    }
}
