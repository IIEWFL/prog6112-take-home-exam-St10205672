
package progexam.q1;

/**
 *
 * @author Rebone Motshegare ST10205672
 */

public interface EstateAgent {
    public double estateAgentSales(double[] propertySales);
    public double estateAgentCommission(double propertySales);
    int topEstateAgent(double[] totalSales);
}