import player.Dwarf;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {
    Dwarf dwarf;

    @Before
    public void before() {
        dwarf = new Dwarf(30, "Axe");
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(30, dwarf.getHealthPoints());
    }

    @Test
    public void hasWeapon() {
        assertEquals("Axe", dwarf.getWeapon());
    }
}
