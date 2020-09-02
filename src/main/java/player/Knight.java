package player;

import behaviours.Melee;

public class Knight extends Player implements Melee {

    public Knight(int healthPoints, String weapon) {
        super(healthPoints);
        this.weapon = weapon;
    }

    public String fight() {
        return "Knight is fighting";
    }

    public void changeWeapon(String weapon) {
        this.weapon = weapon;
    }
}
