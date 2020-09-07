package behaviours;

import room.EnemyType;
import weapon.SpellType;

public interface Spellcaster {

    public void addSpell(SpellType spell);
    public void removeSpell(SpellType spell);
    public String castSpell(SpellType spell);
    public String getCreature();
    public void changeCreature(EnemyType creature);
    public String useCreature();
}
