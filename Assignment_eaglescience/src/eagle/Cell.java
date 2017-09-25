package eagle;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Cell {
//	The coordinates of the firefighter for this cell
	public List<Point2D.Double> coordinates_bmw;
//	The average of the coordinates of this cell
	private Point2D.Double middle;
//	If the cell is walkable or not
	private boolean walkable;
//	The x and y of the cell
	private int index_x;
	private int index_y;
//	The weight of the fire
	private int weightFire;
//	The info for each algorithm
	public AstarCellInfo Astar;
	public BFSCellInfo BFS;
	public DFSCellInfo DFS;
	public DijkstraCellInfo Dijkstra;
	
//	The constructor of the cell
	public Cell(){
		coordinates_bmw = new ArrayList<Point2D.Double>();
		walkable = false;
		weightFire = 0;
		Astar = new AstarCellInfo();
		BFS = new BFSCellInfo();
		DFS = new DFSCellInfo();
		Dijkstra = new DijkstraCellInfo();
	}
	
//	Function to empty the cell when a new algorithm is run
	public void emptyCell(){
		Astar = new AstarCellInfo();
		BFS = new BFSCellInfo();
		DFS = new DFSCellInfo();
		Dijkstra = new DijkstraCellInfo();
	}
	
//	Function to add a coordinate to the cell
	public void add_coordinate(Point2D.Double coordinate){
		coordinates_bmw.add(coordinate);
		if(coordinates_bmw.size()>0){
			walkable = true;
		}
		calculate_middle();
	}
	
//	Function to calculate the average coordinate of the cell
	private void calculate_middle(){
		middle = new Point2D.Double(0, 0);
		double x = 0;
		double y = 0;
		double size = coordinates_bmw.size();
		for(int i = 0; i < coordinates_bmw.size(); i++){
			x = x + coordinates_bmw.get(i).getX();
			y = y + coordinates_bmw.get(i).getY();
		}
		middle.x = x / size;
		middle.y = y / size;
	}
//	Function that returns the x
	public int getIndexX(){
		return index_x;
	}
//	Function that returns the y
	public int getIndexY(){
		return index_y;
	}
//	Function to set the x
	public void setIndexX(int x){
		this.index_x = x;
	}
//	Function to set the y
	public void setIndexY(int y){
		this.index_y = y;
	}
//	Function to return the average of the coordinates
	public Point2D.Double getMiddle() {
		return middle;
	}
//	Function to return if the cell is walkable
	public boolean getWalkable(){
		return walkable;		
	}
//	Function to set the weight for the fire
	public void setFireWeight(int weight){
		this.weightFire = weight;		
	}
//	Function to return the weight of the fire
	public int getFireWEight(){
		return this.weightFire;
	}
}