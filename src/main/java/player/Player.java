package player;

import room.Room;

import java.util.ArrayList;

public abstract class Player {
    private int healthPoints;
    protected String weapon;
    protected ArrayList<String> spells;
    protected Room currentRoom;
    private int loot;

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
        currentRoom = new Room();
    }
}
