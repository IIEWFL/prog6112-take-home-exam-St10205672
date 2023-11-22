
package progexam.q1;
/**
 *
 * @author Rebone Motshegare ST10205672
 */
import progexam.q1.EstateAgentImplementation;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstateAgentImplementationTest {
    
    public EstateAgentImplementationTest() {
    }
    
    private final double[][] propertySales = {
            {800000, 700000},
            {1500000, 1200000},
            {2000000, 1600000}
    };

    @Test
    public void testEstateAgentSales() {
        
        EstateAgentImplementation estateAgentImpl = new EstateAgentImplementation();
        
        double[] totalSales = new double[propertySales.length];

        for (int i = 0; i < propertySales.length; i++) {
            totalSales[i] = estateAgentImpl.estateAgentSales(propertySales[i]);
            
            // calculating total sales match the expected values
             //this code is adapted from stack overflow
             //Author:rHeberson
            //Link:https://stackoverflow.com/questions/38489417/java-how-to-use-assert-assertequals-when-sometimes-a-string-is-returned-and-so
            
            assertEquals(getExpectedTotalSales(i), totalSales[i]);
        }
        
    }

    @Test
    public void testEstateAgentCommission() {
        EstateAgentImplementation estateAgentImpl = new EstateAgentImplementation();

        double[] totalSales = new double[propertySales.length];
        double[] totalCommissions = new double[propertySales.length];

        for (int i = 0; i < propertySales.length; i++) {
            totalSales[i] = estateAgentImpl.estateAgentSales(propertySales[i]);
            totalCommissions[i] = estateAgentImpl.estateAgentCommission(totalSales[i]);
            
            assertEquals(getExpectedCommission(i), totalCommissions[i]);
        }
    }

    @Test
    public void testTopEstateAgent() {
        EstateAgentImplementation estateAgentImpl = new EstateAgentImplementation();

        double[] totalSales = new double[propertySales.length];

        for (int i = 0; i < propertySales.length; i++) {
            totalSales[i] = estateAgentImpl.estateAgentSales(propertySales[i]);
        }

      
        assertEquals(getExpectedTopAgent(), estateAgentImpl.topEstateAgent(totalSales));
    }
    
        private double getExpectedTotalSales(int agentIndex) {
        double sum = 0;
        for (double sale : propertySales[agentIndex]) {
            sum += sale;
        }
        return sum;
    }

    // Defining expected commission values based on the sample property sales data
        
    private double getExpectedCommission(int agentIndex) {
        return 0.02 * getExpectedTotalSales(agentIndex);
    }

    // Defining expected top agent index based on the sample property sales data
    private int getExpectedTopAgent() {
        
        // In the given sample data, Joe Bloggs is the top-selling agent for each month
        return 2;
    }
}
