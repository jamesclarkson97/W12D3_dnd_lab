package room;

import java.util.Random;

public class Room {
    private int treasure;
    private EnemyType enemy;
    private boolean completed;
    private String contents;

    public Room() {
        this.treasure = randomTreasureAmount();
        this.enemy = randomEnemy();
        this.completed = false;
        this.contents = selectContents();
    }

    public int getTreasure() {
        return treasure;
    }

    public EnemyType getEnemy() {
        return enemy;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void changeCompleted() {
        completed = true;
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
        return "There is " + this.contents + "in here!";
    }
}
