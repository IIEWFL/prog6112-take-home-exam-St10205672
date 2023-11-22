
package progexam.q1;

/**
 *
 * @author Rebone MOtshegare ST10205672
 */

public class ProgExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        double[][] propertySales = {
                {800000, 700000},
                {1500000, 1200000},
                {2000000, 1600000}
        };
        
        EstateAgentImplementation estateAgentImpl = new EstateAgentImplementation();

        // Calculates and prints out total property sales and commission for each estate agent
        ///this code is adapted from W3schools
        //Author: W3schools
        //Link: https://www.w3schools.com/java/ref_keyword_double.asp
        
        double[] totalSales = new double[propertySales[0].length];
        double[] totalCommissions = new double[propertySales[0].length];

        for (int i = 0; i < propertySales[0].length; i++) {
            totalSales[i] = estateAgentImpl.estateAgentSales(propertySales[i]);
            totalCommissions[i] = estateAgentImpl.estateAgentCommission(totalSales[i]);

            System.out.println("Total property sales for Estate Agent " + (i + 1) + ": R" + totalSales[i]);
            System.out.println("Total commission earned: R" + totalCommissions[i]);
            System.out.println();
        }

        // Identifies and prints the top-performing estate agent
        //this code is adapted from W3schools
        //Author:w3schools
        //Link:https://www.w3schools.com/java/java_class_methods.asp#:~:text=The%20dot%20(%20.%20)%20is%20used,Main%20and%20Main.java).
        
        int topAgentIndex = estateAgentImpl.topEstateAgent(totalSales);
        System.out.println("Top performing estate agent: Estate Agent " + (topAgentIndex + 1));
    }
}
