package player;

import behaviours.Melee;

public class Barbarian extends Player implements Melee {

    public Barbarian(int healthPoints, String weapon) {
        super(healthPoints);
        this.weapon = weapon;
    }

    public String fight() {
        return "Barbarian is fighting";
    }

    public void changeWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void fightEnemy() {
        System.out.println(fight());
        System.out.println("Barbarian has killed the " + currentRoom.getEnemy().getName());
    }
}
