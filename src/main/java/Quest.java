import player.Barbarian;

import java.util.Scanner;

public class Quest {

    public static void main(String[]args){

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
        }
    }
}
