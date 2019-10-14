package uk.ac.tees.advanced.username;

import uk.ac.tees.advanced.username.Railgun;
import uk.ac.tees.advanced.username.NeedAmmoState;
import uk.ac.tees.advanced.username.DamagedState;
import java.awt.Point;
import static org.junit.Assert.*;
import org.junit.Test;
import uk.ac.tees.advanced.username.DamagedState;
import uk.ac.tees.advanced.username.NeedAmmoState;
import uk.ac.tees.advanced.username.Railgun;

/** A set of unit tests to exercise the NeedAmmo class.
 *
 * Based on work created by Mark Truran </p>
 */
public class DamagedStateTest {
    
    /**
     * Test of fire method, of class DamagedState. Gun should fire at 50%
     * rate until exhausted. When exhausted, it should change to noammo state.
     */
    @Test
    public void testFire() {
        final Railgun railgun = new Railgun();
        railgun.setState(new DamagedState());
        final int numRounds = 10;
        final int x = 199;
        final int y = 993;
        String actualResult = railgun.fire(new Point(x, y), numRounds);
        String expectedResult = "Fire order: Partial success 5/10";
        //System.out.println(actualResult);
        assertEquals(expectedResult, actualResult);
        actualResult = railgun.fire(new Point(x, y), numRounds);
        //System.out.println(actualResult);
        expectedResult = "Fire order: Partial success 5/10";
        assertEquals(expectedResult, actualResult);
        actualResult = railgun.fire(new Point(x, y), numRounds);
        //System.out.println(actualResult);
        expectedResult = "Fire order: Failure 0/10";
        assertEquals(expectedResult, actualResult);
        // Check the state transition to NeedAmmo state
        assertEquals(railgun.getState().getClass(), NeedAmmoState.class); 
    }

    /**
     * Move order should always result in failure.
     */
    @Test
    public void testMove() {
        final Railgun railgun = new Railgun();
        final int x1 = 227;
        final int y1 = 767;
        railgun.setPosition(new Point(x1, y1));
        railgun.setState(new DamagedState());
        final int x2 = 427;
        final int y2 = 867;
        final String actualResult = railgun.move(new Point(x2, y2));
        final String expectedResult = "Move order: Failure";
        //System.out.println(actualResult);
        assertEquals(expectedResult, actualResult);
        assertEquals(new Point(x1, y1), railgun.getPosition());
    }
}
