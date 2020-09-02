package player;

import java.util.HashMap;

public class Cleric extends Player {

    private HashMap<String, Integer> healingItems;

    public Cleric(int healthPoints) {
        super(healthPoints);
        this.healingItems = new HashMap<String, Integer>() {{
            put("Potion", 5);
        }};
        this.damageResistance = -1;
    }

    public HashMap<String, Integer> getHealingItems() {
        return healingItems;
    }

    public void addHealingItems(String item, int amount) {
        if (healingItems.containsKey(item)) {
            healingItems.put(item, healingItems.get(item) + amount);
        } else {
            healingItems.put(item, amount);
        }
    }

    public void removeHealingItems(String item, int amount) {
        if (healingItems.containsKey(item)) {
            if (healingItems.get(item) <= amount) {
                healingItems.remove(item);
            } else {
                healingItems.put(item, healingItems.get(item) - amount);
            }
        }
    }

    public String useHealingItem(String item) {
        if (healingItems.containsKey(item)) {
            removeHealingItems(item, 1);
            return "Cleric uses a " + item;
        } else {
            return "Cleric doesn't have any " + item;
        }
    }

    @Override
    public void fightEnemy() {
        System.out.println("The Cleric is running away from the " + currentRoom.getEnemy().getName());
        takeDamage();
        if (healthPoints <= 0) {
            System.out.println("You have died! Your total loot was " + getLoot() + " gold pieces");
        } else {
            System.out.println("The Cleric has escaped successfully!");
        }
    }
}
