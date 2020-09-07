package player;

import room.Room;
import weapon.SpellType;
import weapon.WeaponType;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {
    protected int healthPoints;
    protected WeaponType weapon;
    protected ArrayList<SpellType> spells;
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

    public void endGame() {
        this.healthPoints = 0;
    }

    public String getWeapon() {
        return this.weapon.getName();
    }

    public ArrayList<SpellType> getSpells() {
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

    public void pickRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("There is a room to your left and your right. Which one do you choose?");
        scanner.nextLine();
        completeRoom();
    }

    public void completeRoom() {
        System.out.println(currentRoom.whatsInTheRoom());
        if(currentRoom.getContents() == "an enemy") {
            fightEnemy();
        } else {
            collectTreasure();
        }
        if (this.healthPoints > 0) {
            System.out.println("Do you wish to delve deeper into the dungeon?");
            Scanner scanner = new Scanner(System.in);
            String playerChoice = scanner.nextLine();
            if (playerChoice.equalsIgnoreCase("yes")) {
                currentRoom = new Room();
            } else {
                endGame();
                System.out.println("You leave with " + getLoot() + " gold pieces. Until next time...");
            }
        }
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
