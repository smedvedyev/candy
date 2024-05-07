import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 *
<!--//# BEGIN TODO: Name, student ID, and date-->
<p><b>Medvedyev Serhiy, 1948237, 06.05.24</b></p>
<!--//# END TODO-->
 */
public class CandyTest {

    static final Candy SUT = null; // to simplify method calls

    static final long MAX_VALUE = 999999999999999999L;

    /**
     * Checks the result of SUT.divide(k, c).
     */
    private void check(long k, long c, boolean expected) {
        System.out.println("divide(" + k + ", " + c + ")");
        long result = SUT.divide(k, c);
        System.out.println("  result = " + result);
        assertEquals(expected, 0 <= result, "possible (0 <= result)");
        if (0 <= result) {
            assertTrue(result <= MAX_VALUE, "range (result <= MAX_VALUE)");
            assertEquals(result * k, c, "quotient (result * k == c)");
        }
    }

    // Test cases

    /** Regular input, possible to divide.*/
    
    @Test 
    public void testDivideGivenExample() {
        check(3, 15, true);
    }
    /**Regular input, not possible to divide.*/
    
    @Test
    public void testDivideCannotDivide() {
        check(3, 20, false);
    }
    /**Border value of candies, can be divided.*/
    
    @Test
    public void testDivideBorderCaseTrue() {
        check(1, MAX_VALUE, true);
    } 
    /**Border value of candies, although cannot be divided.*/
    
    @Test
    public void testDivideBorderCaseFalse() {
        check(MAX_VALUE - 1, MAX_VALUE, false);
    }
    /**Border value of children, although cannot be divided.*/
    
    @Test
    public void testDivideBorderChildrenTrue() {
        check(MAX_VALUE, MAX_VALUE, true);
    }
    /**Border value of children, although cannot be divided.*/
    
    @Test
    public void testDivideBorderChildrenCantDivide() {
        check(MAX_VALUE, 1, false);
    }
    /**No kids, not possible to divide between 0 kids.*/
    
    @Test
    public void testDivideNoKids() {
        check(0, 1, false);
    }
    /**No candies, hence each child gets 0 candies.*/
    
    @Test
    public void testDivideNoCandies() {
        check(1, 0, true);
    }
    /**No candies and no children, hence impossible to divide.*/
    
    @Test
    public void testDivideBothZeros() {
        check(0, 0, false);
    }
    /**Large numbers, which can be divided.*/
    
    @Test
    public void testDivideLargeNumbersDivide() {
        check(100000, 200000, true);
    }
    /**Large numbers, which can be divided.*/
    
    @Test
    public void testDivideLargeNumbersNotDivide() {
        check(100001, 200000, false);
    }
}
