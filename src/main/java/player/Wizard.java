package player;

import behaviours.Spellcaster;
import room.EnemyType;
import weapon.SpellType;

import java.util.ArrayList;
import java.util.Scanner;

public class Wizard extends Player implements Spellcaster {

    private EnemyType creature;

    public Wizard(int healthPoints) {
        super(healthPoints);
        this.spells = new ArrayList<SpellType>() {{add(SpellType.RAY_OF_FROST);}};
        this.creature = EnemyType.DRAGON;
        this.damageResistance = 0;
    }


    public void addSpell(SpellType spell) {
        spells.add(spell);
    }

    public void removeSpell(SpellType spell) {
        spells.remove(spell);
    }

    public String castSpell(SpellType spell) {
        return spells.contains(spell) ? "Wizard casts " + spell : "Wizard doesn't know that spell";
    }

    public String getCreature() {
        return creature.getName();
    }

    public String useCreature() {
        return "Your " + creature.getName() + " attacks the enemy " + currentRoom.getEnemy().getName() + "!";
    }

    public void changeCreature(EnemyType creature) {
        this.creature = creature;
    }

    public void doSpellDamage(int damage) {
        currentRoom.enemyTakeDamage(damage);
        System.out.println("You do " + damage + " damage to the " + currentRoom.getEnemy().getName());
    }

    public void doCreatureDamage() {
        int damage = this.creature.getDamage();
        currentRoom.enemyTakeDamage(damage);
        System.out.println("Your " + this.creature.getName() + " does " + damage + " damage to the enemy " + currentRoom.getEnemy().getName());
    }

    @Override
    public void fightEnemy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You currently have " + this.healthPoints + " health points remaining.");
        System.out.println("Do you fight the " + currentRoom.getEnemy().getName() + "?");
        String fightChoice = scanner.nextLine();

        if(fightChoice.equalsIgnoreCase("yes")) {

            while (currentRoom.getEnemyHealth() > 0) {
                takeDamage();
                if (healthPoints <= 0) {
                    System.out.println("You have died! Your total loot was " + getLoot() + " gold pieces");
                    break;
                } else {
                    System.out.println("Use your creature or cast a spell?");
                    String weaponChoice = scanner.nextLine();

                    if(weaponChoice.equalsIgnoreCase("Spell")) {
                        System.out.println("Which spell would you like to use? " + getSpells());
                        String spellChoice = scanner.nextLine();
                        SpellType actualSpell = SpellType.checkSpell(spellChoice);
                        System.out.println(castSpell(actualSpell));
                        doSpellDamage(actualSpell.getDamage());
                    } else {
                        System.out.println(useCreature());
                        doCreatureDamage();
                    }
                    if (currentRoom.getEnemyHealth() > 0) {
                        System.out.println("Do you wish to escape this fight?");
                        String leaveFight = scanner.nextLine();
                        if (leaveFight.equalsIgnoreCase("yes")) {
                            System.out.println("You run away");
                            break;
                        }
                    }
                }
            }

            if (healthPoints > 0) {
                System.out.println("You have killed the " + currentRoom.getEnemy().getName());

                SpellType roomItem = currentRoom.getSpell();
                System.out.println("You find a scroll of " + roomItem.getName() + ". Add this to your spell book?");
                String addChoice = scanner.nextLine();
                if (addChoice.equalsIgnoreCase("yes")) {
                    addSpell(roomItem);
                    System.out.println("You have learned the " + roomItem.getName() + " spell");
                }
            }

        } else {
            System.out.println("You run away");
        }
    }
}
