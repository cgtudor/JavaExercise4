package uk.ac.tees.advanced.username;

import uk.ac.tees.advanced.username.Railgun;
import uk.ac.tees.advanced.username.NeedAmmoState;
import uk.ac.tees.advanced.username.NormalState;
import java.awt.Point;
import static org.junit.Assert.*;
import org.junit.Test;
import uk.ac.tees.advanced.username.NeedAmmoState;
import uk.ac.tees.advanced.username.NormalState;
import uk.ac.tees.advanced.username.Railgun;

/** A set of unit tests to exercise the NeedAmmo class.
 *
 * Based on work created by Mark Truran </p>
 */
public class NeedAmmoStateTest {
    
    /**
     * Test of fire method, of class NeedAmmoState. Should always fail.
     */
    @Test
    public void testFire() {
        final Railgun railgun = new Railgun();
        railgun.setAmmo(0);
        railgun.setState(new NeedAmmoState());
        final int x1 = 223;
        final int y1 = 172;
        final int numRounds = 4;
        final String actualResult = railgun.fire(new Point(x1, y1), numRounds);
        //System.out.println(actualResult);
        final String expectedResult = "Fire order: Failure 0/4";
        assertEquals(expectedResult, actualResult); 
    }

    /**
     * Test of move method, of class NeedAmmoState. Should always succeed.
     */
    @Test
    public void testMove() {
        final Railgun railgun = new Railgun();
        railgun.setAmmo(0);
        railgun.setState(new NeedAmmoState());
        final int x = 676;
        final int y = 449;
        final String actualResult = railgun.move(new Point(x, y));
        final String expectedResult = "Move order: Success";
        //System.out.println(actualResult);
        assertEquals(expectedResult, actualResult);
        assertEquals(new Point(x, y), railgun.getPosition());
    }
    
    /**
     * Visit ammo dump. Should result in state transition to normal state and
     * ammo should be refreshed.
     */
    @Test
    public void testAmmoDump() {
        final Railgun railgun = new Railgun();
        railgun.setAmmo(0);
        railgun.setState(new NeedAmmoState());
        final int x = 320;
        final int y = 43;
        railgun.move(new Point(x, y));
        assertEquals(railgun.getAmmo(), Railgun.MAX_AMMO);
        assertEquals(railgun.getState().getClass(), NormalState.class); 
        assertEquals(new Point(x, y), railgun.getPosition());
    } 
}
