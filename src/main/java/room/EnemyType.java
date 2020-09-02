package room;

public enum EnemyType {
    DRAGON("Dragon", 10),
    OGRE("Ogre", 5),
    DROW("Drow", 4),
    SKELETON("Skeleton", 1);

    private String name;
    private int damage;

    EnemyType(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }
}
