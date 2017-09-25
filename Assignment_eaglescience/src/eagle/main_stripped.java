
package eagle;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main_stripped {
	
	private int x ;
	private int y ;
	private List<Brandweerman> brandweermannen;
	private List<Point2D.Double> fires;
    
	public static void main(String[] args){
		try {
			new main().start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EagleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() throws FileNotFoundException, EagleException {
		
		BFS BFSAlgorithm = new BFS();
		DFS DFSAlgorithm = new DFS();
		Dijkstra DijkstraAlgorithm = new Dijkstra();
		AStar AstarAlgorithm = new AStar();

		List<Cell> pathBFS1 = new ArrayList<Cell>();
		List<Cell> pathBFS2 = new ArrayList<Cell>();
		List<Cell> pathDFS1 = new ArrayList<Cell>();
		List<Cell> pathDFS2 = new ArrayList<Cell>();
		List<Cell> pathDijkstra1 = new ArrayList<Cell>();
		List<Cell> pathDijkstra2 = new ArrayList<Cell>();
		List<Cell> pathAstar1 = new ArrayList<Cell>();
		List<Cell> pathAstar2 = new ArrayList<Cell>();

		brandweermannen = new ArrayList<Brandweerman>();
		fires = new ArrayList<Point2D.Double>();
		
		String scenario = "1";

		Point2D.Double begin_point = new Point2D.Double(40,5);
		Point2D.Double eind_point  = new Point2D.Double(6,61);
		Point2D.Double eind_point2 = new Point2D.Double(55,36);
		
		addBmw("C:/Users/Jeroen/workspacejava/Assignment_eaglescience/src/Files/scenario"+scenario+"_bmw1.txt");
		addBmw("C:/Users/Jeroen/workspacejava/Assignment_eaglescience/src/Files/scenario"+scenario+"_bmw2.txt");
		
		Grid grid = createGrid();

		pathBFS1 = BFSAlgorithm.findPath(grid, begin_point, eind_point);
		pathBFS2 = BFSAlgorithm.findPath(grid, begin_point, eind_point2);

		pathDFS1 = DFSAlgorithm.findPath(grid, begin_point, eind_point);
		pathDFS2 = DFSAlgorithm.findPath(grid, begin_point, eind_point2);

		pathDijkstra1 = DijkstraAlgorithm.findPath(grid, begin_point, eind_point);
		pathDijkstra2 = DijkstraAlgorithm.findPath(grid, begin_point, eind_point2);

		pathAstar1 = AstarAlgorithm.findPath(grid, begin_point, eind_point);
		pathAstar2 = AstarAlgorithm.findPath(grid, begin_point, eind_point2);
		
		grid.printGridBetter();
		
		grid.printBetter(pathBFS1);
		grid.printBetter(pathBFS2);
		
		grid.printBetter(pathDFS1);
		grid.printBetter(pathDFS2);
		
		grid.printBetter(pathDijkstra1);
		grid.printBetter(pathDijkstra2);
		
		grid.printBetter(pathAstar1);
		grid.printBetter(pathAstar2);

	}
	

	public Grid createGrid(){
		Grid grid = new Grid(x,y);
		for(int i = 0; i < brandweermannen.size(); i++){
			grid.parse_coordinates(brandweermannen.get(i));
		}
		
		for(int j = 0; j < fires.size(); j = j +2){
			int widthFire = (int)fires.get(j+1).getX(); 
			grid.addFire(fires.get(j), widthFire);
		}
		
		return grid;
	}
	
	public void addBmw(String file_location) throws FileNotFoundException{
		File file = new File(file_location);
		Brandweerman bmw = new Brandweerman();
		bmw.parseFile(file);
		brandweermannen.add(bmw);
		calculate_grid_size();
	}
	
	public void calculate_grid_size(){
		double largest_x = 0;
		double largest_y = 0;
		
		for(int i = 0; i<brandweermannen.size(); i++){
			Brandweerman bmw_search = brandweermannen.get(i);
			
			for(int j = 0; j< bmw_search.getPoints().size(); j++){
				Point2D.Double point_search = bmw_search.getPoints().get(j);
				if(point_search.getX() > largest_x){
					largest_x = point_search.getX();
				}
				if(point_search.getY() > largest_y){
					largest_y = point_search.getY();
				}
				
			}
		}
		
		this.x = (int) (largest_x + 3);
		this.y = (int) (largest_y + 3);
	}
	

	
	
}
