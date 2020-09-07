package player;

import behaviours.Melee;
import weapon.WeaponType;

import java.util.Scanner;

public class Dwarf extends Player implements Melee {
    public Dwarf(int healthPoints) {
        super(healthPoints);
        this.weapon = WeaponType.AXE;
        this.damageResistance = 1;
    }

    public String fight() {
        return "You are fighting the " + currentRoom.getEnemy().getName() + " using your " + this.weapon.getName();
    }

    public void doDamage() {
        int damage = this.weapon.getDamage();
        currentRoom.enemyTakeDamage(damage);
        System.out.println("You do " + this.weapon.getDamage() + " damage to the " + currentRoom.getEnemy().getName());
    }

    public void changeWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    @Override
    public void fightEnemy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You currently have " + this.healthPoints + " health points remaining.");
        System.out.println("Do you fight the " + currentRoom.getEnemy().getName() + "?");
        String fightChoice = scanner.nextLine();
        if(fightChoice.equalsIgnoreCase("yes")) {
            System.out.println(fight());

            while (currentRoom.getEnemyHealth() > 0) {
                takeDamage();
                if (healthPoints <= 0) {
                    System.out.println("You have died! Your total loot was " + getLoot() + " gold pieces");
                    break;
                } else {
                    doDamage();
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

                WeaponType roomItem = currentRoom.getWeapon();
                System.out.println("You find a " + roomItem.getName() + ". Use this weapon instead?");
                String weaponChoice = scanner.nextLine();
                if (weaponChoice.equalsIgnoreCase("yes")) {
                    changeWeapon(roomItem);
                    System.out.println("You have equipped the " + roomItem.getName());
                }
            }

        } else {
            System.out.println("You run away");
        }
    }
}
