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

    @Override
    public void fightEnemy() {
        System.out.println(fight());
        System.out.println("Dwarf has killed the " + currentRoom.getEnemy().getName());
    }
}
