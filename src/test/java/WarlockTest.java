import org.junit.Before;
import org.junit.Test;
import player.Warlock;

import static org.junit.Assert.assertEquals;

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
}
