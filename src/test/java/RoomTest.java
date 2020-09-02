import org.junit.Before;
import org.junit.Test;
import room.Room;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class RoomTest {
    Room room;

    @Before
    public void before() {
        room = new Room();
    }

    @Test
    public void hasTreasure() {
        assertNotNull(room.getTreasure());
    }

    @Test
    public void hasEnemy() {
        assertNotNull(room.getEnemy());
    }

    @Test
    public void startsNotCompleted() {
        assertFalse(room.getCompleted());
    }
}
