import java.awt.Point;

public interface Grid_Interface {

	
	
    public void init();
    /** creates grid object
     * @precondition
     *          - 
     * @postcondition
     *         	Empty grid is created (int[][]{})

     **/

    public void grid(Cell_Interface cell);
    /** creates grid object with object cell as cells
     * @precondition
     *          - empty grid
     * @postcondition
     *         	- Grid is created with cells
     **/
    
    public void add_row();
    /** add a extra row to grid
     * @precondition
     *          - grid
     * @postcondition
     *         	- grid with a extra row
     **/
    
    public void add_column();
    /** add a extra column to grid
     * @precondition
     *          - grid
     * @postcondition
     *         	- grid with a extra column
     **/
    
    public void contains_coordinate();
    /** check if coordinate is in grid
     * @precondition
     *          - 
     * @postcondition
     *         	- boolean
     **/
    
    public void set_walkable(Point coordinate);
    /** set cell with coordinate to true
     * @precondition
     *          - 
     * @postcondition
     *         	- cell with walkable true 
     **/
    
    public void print();
    /** print grid with route displayed
     * @precondition
     *          - 
     * @postcondition
     *         	- print grid with route
     **/
		
		
}
