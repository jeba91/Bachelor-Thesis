package eagle;

public class BFSCellInfo {
//	The cost of moving from the start
	private double gcost;
//	The previous cell of this cell
	private Cell previous_cell;
	
//	Constructor for BFS
	public BFSCellInfo(){
		gcost = 0;
	}
	
//	Function to get the gcost
	public double getGcost(){
		return gcost;
	}
	
//	Function to set the gcost
	public void setGcost(Cell current, Cell adjacent, Grid grid){
		gcost = calculateGcost(current, adjacent, grid);	
	}

//	Function to calculate the gcost
	public double calculateGcost(Cell current, Cell adjacent, Grid grid){
		double distance = current.BFS.getGcost() + grid.cell_size();
		return current.BFS.getGcost() + distance;
	}
	
//	Function to set previous cell
	public void setPrevious(Cell cell){
		previous_cell = cell;
	}
	
//	Function to get the previous cell
	public Cell getPrevious(){
		return previous_cell;
	}

}
