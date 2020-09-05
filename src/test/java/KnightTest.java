import org.junit.Before;
import org.junit.Test;
import player.Knight;
import weapon.WeaponType;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;

    @Before
    public void before() {
        knight = new Knight(50);
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(50, knight.getHealthPoints());
    }

    @Test
    public void hasWeapon() {
        assertEquals("Sword", knight.getWeapon());
    }

    @Test
    public void canFight() {
        assertEquals("Knight is fighting", knight.fight());
    }

    @Test
    public void canChangeWeapon() {
        knight.changeWeapon(WeaponType.GREAT_SWORD);
        assertEquals("Great Sword", knight.getWeapon());
    }

    @Test
    public void canPlay() {
        knight.completeRoom();
        knight.completeRoom();
        knight.completeRoom();
        knight.completeRoom();
    }
}
