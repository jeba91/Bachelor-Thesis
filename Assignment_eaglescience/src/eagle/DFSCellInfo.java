package eagle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSCellInfo {
//	The distance from the start
	private double gcost;
//	The previous cell
	private Cell previous_cell;
//	Directions already travelled
	public List<String> directions;	
	
//	Constructor for the DFS cell info
	public DFSCellInfo(){
		directions = new ArrayList<String>();
		gcost = 0;
	}
//	Function to return gcost
	public double getGcost(){
		return gcost;
	}
//	Function to set the gcost
	public void setGcost(Cell current, Grid grid){
		gcost = calculateGcost(current, grid);	
	}
//	Function to calculate the gcost
	public double calculateGcost(Cell current, Grid grid){
		double distance = current.DFS.getGcost() + grid.cell_size();
		return distance;
	}
//	Function to set the previous cell
	public void setPrevious(Cell cell){
		previous_cell = cell;
	}
//	Function to get the previous cell
	public Cell getPrevious(){
		return previous_cell;
	}
}
