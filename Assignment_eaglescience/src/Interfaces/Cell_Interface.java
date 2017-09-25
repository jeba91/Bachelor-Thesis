
public interface Cell_Interface {
	
	
	
    public void cell();
    /** cell with defined height
     * @precondition
     *          - 
     * @postcondition
     *         	- empty cell object
     **/

    public void cell_size(int size);
    /** set cell_size to int size
     * @precondition
     *          - empty cell object
     * @postcondition
     *         	- cell object with size
     **/
    
    public void enlarge();
    /** enlarge size cell object 
     * @precondition
     *          - cell object with size
     * @postcondition
     *         	- cell object with size enlarged
     **/
    
    public void decrease();
    /** decrease size cell object 
     * @precondition
     *          - cell object with size
     * @postcondition
     *         	- cell object with size decreased
     **/
	
    public void set_walkable(boolean walk);
    /** set variable of walkable to boolean
     * @precondition
     *          -  
     * @postcondition
     *         	- walkable is boolean
     **/
    
    

}
