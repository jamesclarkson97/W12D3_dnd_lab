import player.Dwarf;
import org.junit.Before;
import org.junit.Test;
import weapon.WeaponType;

import static org.junit.Assert.assertEquals;

public class DwarfTest {
    Dwarf dwarf;

    @Before
    public void before() {
        dwarf = new Dwarf(30);
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(30, dwarf.getHealthPoints());
    }

    @Test
    public void hasWeapon() {
        assertEquals("Axe", dwarf.getWeapon());
    }

    @Test
    public void canFight() {
        assertEquals("Dwarf is fighting", dwarf.fight());
    }

    @Test
    public void canChangeWeapon() {
        dwarf.changeWeapon(WeaponType.GREAT_SWORD);
        assertEquals("Great Sword", dwarf.getWeapon());
    }

    @Test
    public void canPlay() {
        dwarf.completeRoom();
        dwarf.completeRoom();
        dwarf.completeRoom();
        dwarf.completeRoom();
    }
}
