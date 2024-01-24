package Graph;
/**<pre>
 * Class        WeightedEdge.java
 * Description  Extands the Edge class defined in Abstract class and implements
 *              the Comparable interface.
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 143
 * Hourse       1 hours and 9 minutes
 * Date         11/28/2022
 * History Log  
 * @author	<i>Tyler Ingram</i>
 * @version 	%1% %2%
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit 
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class WeightedEdge extends AbstractGraph.Edge
    implements Comparable<WeightedEdge> 
{
    public double weight; // The weight on edge (u, v)

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  WeightedEdge()-constructor
     * Description  Create a weighted edge on (u, v).
     * Date         11/28/2022
     * History Log  
     * @author      <i>Tyler Ingram</i>
     * @param       u int
     * @param       v int
     * @param       weight double
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public WeightedEdge(int u, int v, double weight) 
    {
        super(u, v);
        this.weight = weight;
    }

    /** Compare two edges on weights
     * @param edge */
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  WeightedEdge()-constructor
     * Description  Compare two edges on weights.
     * Date         11/28/2022
     * History Log  
     * @author      <i>Tyler Ingram</i>
     * @param       edge WeightedEdge
     * @return      -1, 0, or 1 int
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    @Override
    public int compareTo(WeightedEdge edge) 
    {
        if (weight > edge.weight) 
        {
            return 1;
        }
        else if (weight == edge.weight) 
        {
            return 0;
        }
        else 
        {
            return -1;
        }
    }
}
