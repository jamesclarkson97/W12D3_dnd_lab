import org.junit.Before;
import org.junit.Test;
import player.Cleric;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Cleric cleric;

    @Before
    public void before() {
        cleric = new Cleric(20);
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(20, cleric.getHealthPoints());
    }

    @Test
    public void hasHealingItem() {
        HashMap<String, Integer> expected = new HashMap<String, Integer>() {{
            put("Potion", 5);
        }};
        assertEquals(expected, cleric.getHealingItems());
    }

    @Test
    public void canAddHealingItem() {
        cleric.addHealingItems("Bandage", 1);
        HashMap<String, Integer> expected = new HashMap<String, Integer>() {{
            put("Potion", 5);
            put("Bandage", 1);
        }};
        assertEquals(expected, cleric.getHealingItems());
    }

    @Test
    public void canRemoveHealingItem() {
        cleric.removeHealingItems("Potion", 3);
        HashMap<String, Integer> expected = new HashMap<String, Integer>() {{
            put("Potion", 2);
        }};
        assertEquals(expected, cleric.getHealingItems());
    }

    @Test
    public void canUseHealingItem() {
        assertEquals("Cleric uses a Potion", cleric.useHealingItem("Potion"));

        HashMap<String, Integer> expected = new HashMap<String, Integer>() {{
            put("Potion", 4);
        }};
        assertEquals(expected, cleric.getHealingItems());
    }

    @Test
    public void cannotUseHealingItemNotInHashMap() {
        assertEquals("Cleric doesn't have any Bandage", cleric.useHealingItem("Bandage"));
    }


    @Test
    public void canPlay() {
        cleric.completeRoom();
        cleric.completeRoom();
        cleric.completeRoom();
        cleric.completeRoom();
    }

}
