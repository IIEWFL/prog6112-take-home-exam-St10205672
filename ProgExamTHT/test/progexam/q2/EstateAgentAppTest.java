
package progexam.q2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author reboneriri
 */
public class EstateAgentAppTest {
    
    @Test
    public void testCalculatedSuccessfully() {
        
       
        double result = CalculateCommission.calculate(100000, 0.05);
        assertEquals(5000, result); 
    }

    @Test
    public void testCalculatedUnsuccessfully() {
     
        double result = CalculateCommission.calculate(100000, -0.05);
        assertEquals(0, result); 

    
}
}
