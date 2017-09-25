package eagle;

import java.awt.geom.Point2D;

public class DijkstraCellInfo{
//	The distance from the start
	private double gcost;
//	The previous cell
	private Cell previous_cell;
//	The constructor for Dijkstra
	public DijkstraCellInfo(){
		gcost = 0;
	}
	
//	Function to calculate the gcost
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
//	Function to calculate the absolute value
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
}
