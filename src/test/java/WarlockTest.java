import org.junit.Before;
import org.junit.Test;
import player.Warlock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WarlockTest {

    Warlock warlock;

    @Before
    public void before() {
        warlock = new Warlock(20, "Eldritch Blast");
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(20, warlock.getHealthPoints());
    }

    @Test
    public void hasSpell() {
        assertEquals(1, warlock.getSpells().size());
    }

    @Test
    public void hasCreature() {
        assertEquals("Dragon", warlock.getCreature());
    }

    @Test
    public void canAddSpell() {
        warlock.addSpell("Phantasmal Force");
        assertEquals(2, warlock.getSpells().size());
    }

    @Test
    public void canRemoveSpell() {
        warlock.removeSpell("Eldritch Blast");
        assertEquals(0, warlock.getSpells().size());
    }

    @Test
    public void canCastSpell() {
        assertEquals("Warlock casts Eldritch Blast", warlock.castSpell("Eldritch Blast"));
    }

    @Test
    public void cannotCastSpellIfNotInList() {
        assertEquals("Warlock doesn't know that spell", warlock.castSpell("Fireball"));
    }

    @Test
    public void canChangeCreature() {
        warlock.changeCreature("Cat");
        assertEquals("Cat", warlock.getCreature());
    }
}
