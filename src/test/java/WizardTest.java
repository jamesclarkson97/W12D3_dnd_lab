import org.junit.Before;
import org.junit.Test;
import player.Wizard;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard wizard;

    @Before
    public void before() {
        wizard = new Wizard(15, "Fireball");
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(15, wizard.getHealthPoints());
    }

    @Test
    public void hasSpell() {
        assertEquals(1, wizard.getSpells().size());
    }

    @Test
    public void hasCreature() {
        assertEquals("Ogre", wizard.getCreature());
    }

    @Test
    public void canAddSpell() {
        wizard.addSpell("Magic Missile");
        assertEquals(2, wizard.getSpells().size());
    }

    @Test
    public void canRemoveSpell() {
        wizard.removeSpell("Fireball");
        assertEquals(0, wizard.getSpells().size());
    }

    @Test
    public void canCastSpell() {
        assertEquals("Wizard casts Fireball", wizard.castSpell("Fireball"));
    }

    @Test
    public void cannotCastSpellIfNotInList() {
        assertEquals("Wizard doesn't know that spell", wizard.castSpell("Eldritch Blast"));
    }

    @Test
    public void canChangeCreature() {
        wizard.changeCreature("Cat");
        assertEquals("Cat", wizard.getCreature());
    }

    @Test
    public void canPlay() {
        wizard.completeRoom();
        wizard.completeRoom();
        wizard.completeRoom();
        wizard.completeRoom();
    }

}
