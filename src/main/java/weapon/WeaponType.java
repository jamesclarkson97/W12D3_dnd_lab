package weapon;

public enum WeaponType {
    CLUB("Club", 3),
    AXE("Axe", 4),
    SWORD("Sword", 3),
    GREAT_SWORD("Greatsword", 5),
    DAGGER("Dagger", 2);

    private String name;
    private int damage;

    WeaponType(String name, int damage) {
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
