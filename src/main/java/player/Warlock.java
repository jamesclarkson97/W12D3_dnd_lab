package player;

import java.util.ArrayList;

public class Warlock extends Player {

    private String creature;

    public Warlock(int healthPoints, final String spell) {
        super(healthPoints);
        this.spells = new ArrayList<String>(){{add(spell);}};
        this.creature = "Dragon";
    }

    public String getCreature() {
        return creature;
    }
}
