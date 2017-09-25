package eagle;

import java.awt.geom.Point2D;

public class AstarCellInfo{
	
//	The gcost is the cost from the start
	private double gcost;
//	the hcost is the cost from the end
	private double hcost;
//	the fcsot is these two combined
	private double fcost;
	
//	The previous cell for every cell, used to backtrack the route
	private Cell previous_cell;
	
//	The constructor for the cell info
	public AstarCellInfo(){
		gcost = 0;
		hcost = 0;
		fcost = 0;
	}
	
//	Function to calculate the g cost
	public double calculateGcost(Cell current, Cell adjacent){
		Point2D.Double currentMiddle = current.getMiddle();
		Point2D.Double adjMiddle = adjacent.getMiddle();
		double distance = absoluteValue(currentMiddle.getX() - adjMiddle.getX()) + absoluteValue(currentMiddle.getY() - adjMiddle.getY());
		return current.Dijkstra.getGcost() + distance + current.getFireWEight();
	}
	
//	Function to set the gcost
	public void setGcost(Cell current, Cell adjacent){
		gcost = calculateGcost(current, adjacent);	
	}
	
//	Function to set the hcost
	public void setHcost(Cell current, Cell end){
		Point2D.Double currentMiddle = current.getMiddle();
		Point2D.Double endMiddle = end.getMiddle();
		double heuristic = absoluteValue(currentMiddle.getX() - endMiddle.getX()) + absoluteValue(currentMiddle.getY() - endMiddle.getY());
		hcost = heuristic;
	}
	
//	Function to set the fcost
	public void setFcost(Cell current, Cell end, Cell currentAdj){
		setHcost(current, end);
		setGcost(current, currentAdj);
		fcost = hcost + gcost;
	}
	
//	Function to calculate the absolute value, used for the distance
	public double absoluteValue(double value){
		if(value < 0){
			value = value * -1;
		}
		return value;		
	}
	
//	Function to set the previous cell
	public void setPrevious(Cell cell){
		previous_cell = cell;
	}
	
//	Function to get the previous cell
	public Cell getPrevious(){
		return previous_cell;
	}
	
//	Function to get the gcost
	public double getGcost(){
		return gcost;
	}
	
//	Function to get the hcost
	public double getHcost(){
		return hcost;
	}
	
//	Function to get the fcost
	public double getFcost(){
		return fcost;
	}
}
