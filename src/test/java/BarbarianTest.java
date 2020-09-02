import org.junit.Before;
import org.junit.Test;
import player.Barbarian;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {

    Barbarian barbarian;

    @Before
    public void before() {
        barbarian = new Barbarian(40, "Club");
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(40, barbarian.getHealthPoints());
    }

    @Test
    public void hasWeapon() {
        assertEquals("Club", barbarian.getWeapon());
    }

    @Test
    public void canFight() {
        assertEquals("Barbarian is fighting", barbarian.fight());
    }

    @Test
    public void canChangeWeapon() {
        barbarian.changeWeapon("Great Sword");
        assertEquals("Great Sword", barbarian.getWeapon());
    }
}
