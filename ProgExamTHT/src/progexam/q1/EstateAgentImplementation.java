
package progexam.q1;

import progexam.q1.EstateAgent;

/**
 *
 * @author Rebone Motshegare ST10205672
 */

public class EstateAgentImplementation implements EstateAgent {
    
    //This method was adapted from W3schools
    //Author:W3schools
    //Link:https://www.w3schools.com/java/ref_keyword_double.asp
    
    @Override
    public double estateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }

    @Override
    public double estateAgentCommission(double propertySales) {
        return 0.02 * propertySales;
    }

    @Override
    public int topEstateAgent(double[] totalSales) {
        int topAgentIndex = 0;
        double maxSales = totalSales[0];

        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topAgentIndex = i;
            }
        }

        return topAgentIndex;
    }
}