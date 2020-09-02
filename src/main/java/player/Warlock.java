package player;

import behaviours.Spellcaster;

import java.util.ArrayList;

public class Warlock extends Player implements Spellcaster {

    private String creature;

    public Warlock(int healthPoints, final String spell) {
        super(healthPoints);
        this.spells = new ArrayList<String>(){{add(spell);}};
        this.creature = "Dragon";
        this.damageResistance = 0;
    }

    public String getCreature() {
        return creature;
    }

    public void addSpell(String spell) {
        this.spells.add(spell);
    }

    public void removeSpell(String spell) {
        this.spells.remove(spell);
    }

    public String castSpell(String spell) {
        return spells.contains(spell) ? "Warlock casts " + spell : "Warlock doesn't know that spell";
    }

    public void changeCreature(String creature) {
        this.creature = creature;
    }

    @Override
    public void fightEnemy() {
        System.out.println(castSpell("Eldritch Blast"));
        takeDamage();
        if (healthPoints <= 0) {
            System.out.println("You have died! Your total loot was " + getLoot() + " gold pieces");
        } else {
            System.out.println("Warlock has killed the " + currentRoom.getEnemy().getName());
        }
    }
}
