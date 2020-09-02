package player;

import room.Room;

import java.util.ArrayList;

public abstract class Player {
    protected int healthPoints;
    protected String weapon;
    protected ArrayList<String> spells;
    protected Room currentRoom;
    protected int loot;
    protected int damageResistance;

    public Player(int healthPoints) {
        this.healthPoints = healthPoints;
        this.currentRoom = new Room();
        this.loot = 0;
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

    public int getLoot() {
        return loot;
    }

    public void collectTreasure() {
        System.out.println("Wow, there's " + currentRoom.getTreasure() + " gold pieces in here!");
        loot += currentRoom.getTreasure();
    }

    public abstract void fightEnemy();

    public void completeRoom() {
        if(currentRoom.getContents() == "an enemy") {
            fightEnemy();
        } else {
            collectTreasure();
        }
        if (this.healthPoints > 0) currentRoom = new Room();
    }

    public void takeDamage() {
        int damageTaken = currentRoom.getEnemy().getDamage();
        int modifiedDamage = damageTaken - this.damageResistance;
        if (modifiedDamage < 0) {
            modifiedDamage = 0;
        }
        this.healthPoints -= modifiedDamage;
        System.out.println("You take damage! Your current health is " + this.healthPoints);
    }
}
