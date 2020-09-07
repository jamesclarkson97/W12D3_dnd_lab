package room;

import weapon.SpellType;
import weapon.WeaponType;

import java.util.Random;

public class Room {
    private int treasure;
    private EnemyType enemy;
    private String contents;

    public Room() {
        this.treasure = randomTreasureAmount();
        this.enemy = randomEnemy();
        this.contents = selectContents();
    }

    public int getTreasure() {
        return treasure;
    }

    public EnemyType getEnemy() {
        return enemy;
    }

    public int randomTreasureAmount() {
        int max = 100;
        int min = 5;
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    public EnemyType randomEnemy() {
        int pick = new Random().nextInt(EnemyType.values().length);
        return EnemyType.values()[pick];
    }

    public String selectContents() {
        String treasure = "treasure";
        String enemy = "an enemy";
        Random random = new Random();
        int coinFlip = random.ints(0, 2).findFirst().getAsInt();
        return coinFlip == 0 ? treasure : enemy;
    }

    public String getContents() {
        return contents;
    }

    public String whatsInTheRoom() {
        if(this.contents == "treasure") {
            return "There is " + this.contents + " in here!";
        } else {
            return "Oh no! There is a " + this.enemy.getName() + " in here!";
        }
    }

    public WeaponType getWeapon() {
        int pick = new Random().nextInt(WeaponType.values().length);
        return WeaponType.values()[pick];
    }

    public SpellType getSpell() {
        int pick = new Random().nextInt(SpellType.values().length);
        return SpellType.values()[pick];
    }
}
