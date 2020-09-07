package room;

public enum EnemyType {
    DRAGON("Dragon", 10, 10),
    OGRE("Ogre", 5, 5),
    DROW("Drow", 4, 4),
    SKELETON("Skeleton", 1, 1);

    private String name;
    private int damage;
    private int health;

    EnemyType(String name, int damage, int health) {
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHealth() {return this.health;}

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
