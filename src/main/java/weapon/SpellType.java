package weapon;

import java.util.ArrayList;

public enum SpellType {
    FIREBALL("fireball", 4),
    ELDRITCH_BLAST("eldritch blast", 2),
    PHANTASMAL_FORCE("phantasmal force", 3),
    RAY_OF_FROST("ray of frost", 2);

    private String name;
    private int damage;

    SpellType(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public static SpellType checkSpell(String spellChoice) {
//        SpellType allSpells[] = SpellType.values();
        for(SpellType spell : SpellType.values()) {
            if (spell.name.equalsIgnoreCase(spellChoice)) {
                return spell;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

}
