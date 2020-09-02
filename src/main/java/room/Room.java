package room;

import java.util.Random;

public class Room {
    private int treasure;
    private EnemyType enemy;
    private boolean completed;

    public Room() {
        this.treasure = randomTreasureAmount();
        this.enemy = randomEnemy();
        this.completed = false;
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
}
