package player;

import behaviours.Melee;

public class Dwarf extends Player implements Melee {
    public Dwarf(int healthPoints, String weapon) {
        super(healthPoints);
        this.weapon = weapon;
    }

    public String fight() {
        return "Dwarf is fighting";
    }

    public void changeWeapon(String weapon) {
        this.weapon = weapon;
    }
}
