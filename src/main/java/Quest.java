import player.*;

import java.util.Scanner;

public class Quest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please pick a class");
        System.out.println("Barbarian, Knight, Dwarf, Wizard, Warlock, Cleric");
        String className = scanner.nextLine();
        System.out.println("You have picked " + className);
        System.out.println("Are you ready to begin?");
        boolean response = scanner.nextBoolean();
        if (!response) return;
        if (className.equals("Barbarian")) {
            Barbarian barbarian = new Barbarian(40, "Club");
            while (barbarian.getHealthPoints() > 0) {
                barbarian.completeRoom();
            }
        } else if (className.equals("Knight")) {
            Knight knight = new Knight(50, "Sword");
            while (knight.getHealthPoints() > 0) {
                knight.completeRoom();
            }
        } else if (className.equals("Dwarf")) {
            Dwarf dwarf = new Dwarf(30, "Axe");
            while (dwarf.getHealthPoints() > 0) {
                dwarf.completeRoom();
            }
        } else if (className.equals("Warlock")) {
            Warlock warlock = new Warlock(20, "Eldritch Blast");
            while (warlock.getHealthPoints() > 0) {
                warlock.completeRoom();
            }
        } else if (className.equals("Wizard")) {
            Wizard wizard = new Wizard(15, "Fireball");
            while (wizard.getHealthPoints() > 0) {
                wizard.completeRoom();
            }
        } else if (className.equals("Cleric")) {
            Cleric cleric = new Cleric(20);
            while (cleric.getHealthPoints() > 0) {
                cleric.completeRoom();
            }
        } else {
            System.out.println("That's not a class!");
        }
    }
}