
public interface Algorithm_Interface {
	
    public void astar();
    /** searches for shortest route using astar
     * @precondition
     *          - grid with walkable list, start and finish
     * @postcondition
     *         	- shortest route from start to finish
     **/
    
    public void dijkstra();
    /** searches for shortest route using dijkstra
     * @precondition
     *          - grid with walkable list, start and finish
     * @postcondition
     *         	- shortest route from start to finish
     **/
}
