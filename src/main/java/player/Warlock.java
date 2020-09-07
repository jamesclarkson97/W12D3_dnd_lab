package player;

import behaviours.Spellcaster;
import weapon.SpellType;
import weapon.WeaponType;

import java.util.ArrayList;
import java.util.Scanner;

public class Warlock extends Player implements Spellcaster {

    private String creature;

    public Warlock(int healthPoints) {
        super(healthPoints);
        this.spells = new ArrayList<SpellType>(){{add(SpellType.ELDRITCH_BLAST);}};
        this.creature = "Dragon";
        this.damageResistance = 0;
    }

    public String getCreature() {
        return creature;
    }

    public void addSpell(SpellType spell) {
        this.spells.add(spell);
    }

    public void removeSpell(SpellType spell) {
        this.spells.remove(spell);
    }

    public String castSpell(SpellType spell) {
        return spells.contains(spell) ? "Warlock casts " + spell.getName() : "Warlock doesn't know that spell";
    }

    public void changeCreature(String creature) {
        this.creature = creature;
    }

    @Override
    public void fightEnemy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You currently have " + this.healthPoints + " health points remaining.");
        System.out.println("Do you fight the " + currentRoom.getEnemy().getName() + "?");
        String fightChoice = scanner.nextLine();
        if(fightChoice.equalsIgnoreCase("yes")) {
            System.out.println("Which spell would you like to use? " + getSpells());
            String spellChoice = scanner.nextLine();
            SpellType actualSpell = SpellType.checkSpell(spellChoice);
            System.out.println(castSpell(actualSpell));
            takeDamage();
            if (healthPoints <= 0) {
                System.out.println("You have died! Your total loot was " + getLoot() + " gold pieces");
            } else {
                System.out.println("You have killed the " + currentRoom.getEnemy().getName());
                SpellType roomItem = currentRoom.getSpell();
                System.out.println("You find a scroll of " + roomItem.getName() + ". Add this to your spell book?");
                String addChoice = scanner.nextLine();
                if(addChoice.equalsIgnoreCase("yes")) {
                    addSpell(roomItem);
                    System.out.println("You have learned the " + roomItem.getName());
                }
            }
        } else {
            System.out.println("You run away");
        }
    }

}
