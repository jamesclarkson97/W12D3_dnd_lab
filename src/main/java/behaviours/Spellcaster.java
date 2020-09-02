package behaviours;

public interface Spellcaster {

    public void addSpell(String spell);
    public void removeSpell(String spell);
    public String castSpell(String spell);
    public String getCreature();
    public void changeCreature(String creature);
}
