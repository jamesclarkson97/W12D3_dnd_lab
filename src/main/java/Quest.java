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
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            if (className.equalsIgnoreCase("Barbarian")) {
            Barbarian barbarian = new Barbarian(40);
            while (barbarian.getHealthPoints() > 0) {
                barbarian.pickRoom();
            }
            } else if (className.equalsIgnoreCase("Knight")) {
            Knight knight = new Knight(50);
            while (knight.getHealthPoints() > 0) {
                knight.pickRoom();
            }
            } else if (className.equalsIgnoreCase("Dwarf")) {
            Dwarf dwarf = new Dwarf(30);
            while (dwarf.getHealthPoints() > 0) {
                dwarf.pickRoom();
            }
            } else if (className.equalsIgnoreCase("Warlock")) {
            Warlock warlock = new Warlock(20);
            while (warlock.getHealthPoints() > 0) {
                warlock.pickRoom();
            }
            } else if (className.equalsIgnoreCase("Wizard")) {
            Wizard wizard = new Wizard(15);
            while (wizard.getHealthPoints() > 0) {
                wizard.pickRoom();
            }
            } else if (className.equalsIgnoreCase("Cleric")) {
            Cleric cleric = new Cleric(20);
            while (cleric.getHealthPoints() > 0) {
                cleric.pickRoom();
            }
            } else {
                System.out.println("That's not a class!");
            }
        }
    }
}