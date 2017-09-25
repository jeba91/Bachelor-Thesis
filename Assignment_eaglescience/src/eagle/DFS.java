package eagle;

import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class DFS {
	
//	The openlist contains the nodes visited
    public List<Cell> openList;
//  The closedlist contains the nodes visited and processed
    public List<Cell> closedList;
//  The walkedlist is to for research purposes, to get all the nodes used.
    public List<Cell> walkedList;
//  The boolean is to set the algorithm to done
    public boolean done;
    
//	The constructor for the DFS algorithm
    public DFS(){
    	openList = new LinkedList<Cell>();
        closedList = new LinkedList<Cell>();
        walkedList = new LinkedList<Cell>();
        done = false;
    }
    
//  The function for finding a path, will continue until reaching the goal state.
    public final List<Cell> findPath(Grid grid, Point2D.Double begin_point, Point2D.Double eind_point) throws EagleException, FileNotFoundException {
    	Cell current = new Cell();
        openList = new LinkedList<Cell>();
        closedList = new LinkedList<Cell>();
        walkedList = new LinkedList<Cell>();
        done = false;
        
        Cell begin = grid.grid[grid.parse_x(begin_point)][grid.parse_y(begin_point)];
        Cell eind = grid.grid[grid.parse_x(eind_point)][grid.parse_y(eind_point)];
        
        if(!begin.getWalkable() == true || !eind.getWalkable() == true){
        	throw new EagleException("begin or end is not walkable");        	
        }
        
        openList.add(begin);
                
        while(!done){
        	if(openList.size() == 0){
        		LinkedList<Cell> path = new LinkedList<Cell>();
        		return path;
        	}
        	current = openList.get(openList.size()-1);
        	if(!closedList.contains(current)){
            	closedList.add(current);
        	}
        	openList.remove(current);
        	if(current.getIndexX() == eind.getIndexX() && current.getIndexY() == eind.getIndexY()){
	    		walkedList.addAll(openList);
	    		walkedList.addAll(closedList);
	    		return calcPath(begin, eind);
        	}
        	List<Cell> adjacentCells = getAdjacent(current.getMiddle(), grid);
        	for(int i = 0; i< adjacentCells.size(); i++){
        		Cell currentAdj = adjacentCells.get(i);
        		if(!openList.contains(currentAdj)){
        			currentAdj.DFS.setPrevious(current);
        			currentAdj.DFS.setGcost(current, grid);
        			openList.add(currentAdj);    			
        		}        		
        		else if(currentAdj.DFS.getGcost() > currentAdj.DFS.calculateGcost(current, grid)){
    				currentAdj.DFS.setPrevious(current);
    				currentAdj.DFS.setGcost(current, grid);
        		}
        	}
        }
        LinkedList<Cell> path = new LinkedList<Cell>();
        return path;
    }
    
//  Function that returns the path after reaching the goal state
    private List<Cell> calcPath(Cell start, Cell goal) {
    	LinkedList<Cell> path = new LinkedList<Cell>();
	    Cell current = goal; 
	    boolean done = false;
	    while(!done){
	    	path.addFirst(current);
	    	current = current.DFS.getPrevious();
	    	if (current.equals(start)) {
	    		done = true;
	    	}
	    }
	    return path;
    }
    
//  Function that returns the adjacent nodes from a certain cell.
	public List<Cell> getAdjacent(Point2D.Double center, Grid grid) {    	
    	int x = (int) (center.getX() / grid.cell_size());	
    	int y = (int) (center.getY() / grid.cell_size());                
        List<Cell> adj = new LinkedList<Cell>();
        Cell temp;
        if (x > 0) {
            temp = grid.grid[x - 1][y];
            if (temp.coordinates_bmw.size() > 0 && !closedList.contains(temp) && !temp.DFS.directions.contains("left")) {
            	temp.DFS.directions.add("left");
                adj.add(temp);
            }
        }
        if (x < grid.x) {
            temp = grid.grid[x + 1][y];
            if (temp.coordinates_bmw.size() > 0 && !closedList.contains(temp) && !temp.DFS.directions.contains("right")) {
            	temp.DFS.directions.add("right");
                adj.add(temp);
            }
        }
        if (y > 0) {
            temp = grid.grid[x][y - 1];
            if (temp.coordinates_bmw.size() > 0 && !closedList.contains(temp) && !temp.DFS.directions.contains("down")) {
            	temp.DFS.directions.add("down");
                adj.add(temp);
            }
        }
        if (y < grid.y) {
            temp = grid.grid[x][y + 1];
            if (temp.coordinates_bmw.size() > 0 && !closedList.contains(temp) && !temp.DFS.directions.contains("up")) {
            	temp.DFS.directions.add("up");
                adj.add(temp);
            }
        }
        return adj;
    }	
	
	


}
