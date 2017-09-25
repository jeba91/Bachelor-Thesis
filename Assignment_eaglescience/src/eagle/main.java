
package eagle;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main {
	
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
		List<Cell> finalpathBFS = new ArrayList<Cell>();
		
		List<Cell> pathDFS1 = new ArrayList<Cell>();
		List<Cell> pathDFS2 = new ArrayList<Cell>();
		List<Cell> finalpathDFS = new ArrayList<Cell>();
		
		List<Cell> pathDijkstra1 = new ArrayList<Cell>();
		List<Cell> pathDijkstra2 = new ArrayList<Cell>();
		List<Cell> finalpathDijkstra = new ArrayList<Cell>();
				
		List<Cell> pathAstar1 = new ArrayList<Cell>();
		List<Cell> pathAstar2 = new ArrayList<Cell>();
		List<Cell> finalpathAstar = new ArrayList<Cell>();
		
		int noRouteBFS = 0;
		int noRouteDFS = 0;
		int noRouteDijkstra = 0;
		int noRouteAstar = 0;
		
		brandweermannen = new ArrayList<Brandweerman>();
		fires = new ArrayList<Point2D.Double>();
		
		String scenario = "4";
		
		if(scenario == "1"){
			fires.add(new Point2D.Double(8, 14));
			fires.add(new Point2D.Double(10, 0));
		}
		if(scenario == "2"){
			fires.add(new Point2D.Double(13, 10));
			fires.add(new Point2D.Double(12, 0));
		}
		if(scenario == "3"){
			fires.add(new Point2D.Double(58, 39));
			fires.add(new Point2D.Double(12, 0));
		}
		if(scenario == "4"){
			fires.add(new Point2D.Double(28, 52));
			fires.add(new Point2D.Double(11, 0));
		}
		
		Point2D.Double begin_point = new Point2D.Double(40,5);
		Point2D.Double eind_point = new Point2D.Double(6,61);
		Point2D.Double eind_point2 = new Point2D.Double(55,36);
		
		int walkedBFS1 = 0;
		int walkedBFS2 = 0;
		int walkedBFSfinal = 0;
		int walkedDFS1 = 0;
		int walkedDFS2 = 0;
		int walkedDFSfinal = 0;
		int walkedDijkstra1 = 0;
		int walkedDijkstra2 = 0;
		int walkedDijkstrafinal = 0;
		int walkedAstar1 = 0;
		int walkedAstar2 = 0;
		int walkedAstarfinal = 0;
		
		

						
//		addBmw("C:/Users/Jeroen/workspacejava/Assignment_eaglescience/src/Files/scenario"+scenario+"_bmw1missing.txt");
//		addBmw("C:/Users/Jeroen/workspacejava/Assignment_eaglescience/src/Files/scenario"+scenario+"_bmw2missing.txt");
		
		addBmw("C:/Users/Jeroen/workspacejava/Assignment_eaglescience/src/Files/scenario"+scenario+"_bmw1.txt");
		addBmw("C:/Users/Jeroen/workspacejava/Assignment_eaglescience/src/Files/scenario"+scenario+"_bmw2.txt");
		
		Grid grid = createGrid();

//		grid = increase_grid_size(grid);

		grid.printGridBetter();
//		grid = increase_grid_size(grid);
//		
//		
//		grid.printGridBetter();
		
		double totalTimeBFS = 0;
		double totalTimeDFS = 0;
		double totalTimeDijkstra = 0;
		double totalTimeAstar = 0;
		
		double lengthBFS1 = 0;
		double lengthBFS2 = 0;
		double lengthDFS1 = 0;
		double lengthDFS2 = 0;
		double lengthDijkstra1 = 0;
		double lengthDijkstra2 = 0;
		double lengthAstar1 = 0;
		double lengthAstar2 = 0;
			
		
		for(int i = 0; i <1000; i++){
			long startTimeBFS = System.nanoTime();
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathBFS1 = BFSAlgorithm.findPath(grid, begin_point, eind_point);
			walkedBFS1 = BFSAlgorithm.walkedList.size();
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathBFS2 = BFSAlgorithm.findPath(grid, begin_point, eind_point2);
			walkedBFS2 = BFSAlgorithm.walkedList.size();
			long endTimeBFS = System.nanoTime() ;
			totalTimeBFS = totalTimeBFS +((endTimeBFS-startTimeBFS)/1000000000.0);
		}
		
		if(pathBFS1.size() > pathBFS2.size()){
			walkedBFSfinal = walkedBFS2;
			finalpathBFS = pathBFS2;
		}else{
			walkedBFSfinal = walkedBFS1;
			finalpathBFS = pathBFS1;
		}
		
		if(pathBFS1.size() == 0){
			walkedBFSfinal = walkedBFS2;
			finalpathBFS = pathBFS2;
			noRouteBFS = noRouteBFS + 1;
		}
		if(pathBFS2.size() == 0){
			walkedBFSfinal = walkedBFS1;
			finalpathBFS = pathBFS1;
			noRouteBFS = noRouteBFS + 1;
		}

		
		for(int i = 0; i <1000; i++){
			long startTimeDFS = System.nanoTime();
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathDFS1 = DFSAlgorithm.findPath(grid, begin_point, eind_point);
			walkedDFS1 = DFSAlgorithm.walkedList.size();
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathDFS2 = DFSAlgorithm.findPath(grid, begin_point, eind_point2);
			walkedDFS2 = DFSAlgorithm.walkedList.size();
			long endTimeDFS = System.nanoTime() ;
			totalTimeDFS = totalTimeDFS +((endTimeDFS-startTimeDFS)/1000000000.0);
		}

		if(pathDFS1.size() > pathDFS2.size()){
			finalpathDFS = pathDFS2;
			walkedDFSfinal = walkedDFS2;
		}else{
			finalpathDFS = pathDFS1;
			walkedDFSfinal = walkedDFS1;
		}
		
		if(pathDFS1.size() == 0){
			finalpathDFS = pathDFS2;
			walkedDFSfinal = walkedDFS2;
			noRouteDFS = noRouteDFS + 1;
		}
		if(pathDFS2.size() == 0){
			finalpathDFS = pathDFS1;
			walkedDFSfinal = walkedDFS1;
			noRouteDFS = noRouteDFS + 1;
		}
		
		for(int i = 0; i <1000; i++){
			long startTimeDijkstra = System.nanoTime();
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathDijkstra1 = DijkstraAlgorithm.findPath(grid, begin_point, eind_point);
			walkedDijkstra1 = DijkstraAlgorithm.walkedList.size();
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathDijkstra2 = DijkstraAlgorithm.findPath(grid, begin_point, eind_point2);
			walkedDijkstra2 = DijkstraAlgorithm.walkedList.size();
			long endTimeDijkstra = System.nanoTime() ;
			totalTimeDijkstra = totalTimeDijkstra +((endTimeDijkstra-startTimeDijkstra)/1000000000.0);
		}
		int sizePathDijkstra1 = 0;
		sizePathDijkstra1 = pathDijkstra1.size();
		for(int i =0; i < pathDijkstra1.size(); i++){
			sizePathDijkstra1 = sizePathDijkstra1 + pathDijkstra1.get(i).getFireWEight();
		}
		int sizePathDijkstra2 = 0;
		sizePathDijkstra2 = pathDijkstra2.size();
		for(int i =0; i < pathDijkstra2.size(); i++){
			sizePathDijkstra2 = sizePathDijkstra2 + pathDijkstra2.get(i).getFireWEight();
		}
		if(sizePathDijkstra1 > sizePathDijkstra2){
			finalpathDijkstra = pathDijkstra2;
			walkedDijkstrafinal = walkedDijkstra2;
		}else{
			finalpathDijkstra = pathDijkstra1;
			walkedDijkstrafinal = walkedDijkstra1;
		}
		
		if(sizePathDijkstra1 == 0){
			finalpathDijkstra = pathDijkstra2;
			walkedDijkstrafinal = walkedDijkstra2;
			noRouteDijkstra = noRouteDijkstra + 1;
		}
		if(sizePathDijkstra2 == 0){
			finalpathDijkstra = pathDijkstra1;
			walkedDijkstrafinal = walkedDijkstra1;
			noRouteDijkstra = noRouteDijkstra + 1;
		}
		
		for(int i = 0; i <1000; i++){
			long startTimeAstar = System.nanoTime() ;
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathAstar1 = AstarAlgorithm.findPath(grid, begin_point, eind_point);
			walkedAstar1 = AstarAlgorithm.walkedList.size();
			grid.emptyGrid();
//			grid = createGrid();
//			grid = increase_grid_size(grid);
			pathAstar2 = AstarAlgorithm.findPath(grid, begin_point, eind_point2);
			walkedAstar2 = AstarAlgorithm.walkedList.size();
			long endTimeAstar = System.nanoTime() ;
			totalTimeAstar = totalTimeAstar +((endTimeAstar-startTimeAstar)/1000000000.0);
		}
		int sizePathAstar1 = 0;
		sizePathAstar1 = pathAstar1.size();
		for(int i =0; i < pathAstar1.size(); i++){
			sizePathAstar1 = sizePathAstar1 + pathAstar1.get(i).getFireWEight();
		}
		int sizePathAstar2 = 0;
		sizePathAstar2 = pathAstar2.size();
		for(int i =0; i < pathAstar2.size(); i++){
			sizePathAstar2 = sizePathAstar2 + pathAstar2.get(i).getFireWEight();
		}
		
		if(sizePathAstar1 > sizePathAstar2){
			finalpathAstar = pathAstar2;
			walkedAstarfinal = walkedAstar2;
		}else{
			finalpathAstar = pathAstar1;
			walkedAstarfinal = walkedAstar1;
		}
		if(sizePathAstar1 == 0){
			finalpathAstar = pathAstar2;
			walkedAstarfinal = walkedAstar2;
			noRouteAstar = noRouteAstar + 1;
		}
		if(sizePathAstar2 == 0){
			finalpathAstar = pathAstar1;
			walkedAstarfinal = walkedAstar1;
			noRouteAstar = noRouteAstar + 1;
		}
		
		for(int i = 0; i < (pathBFS1.size()-1); i++){
			lengthBFS1 = lengthBFS1 + pathBFS1.get(i).Dijkstra.calculateGcost(pathBFS1.get(i), pathBFS1.get(i+1));
		}
		for(int i = 0; i < (pathBFS2.size()-1); i++){
			lengthBFS2 = lengthBFS2 + pathBFS2.get(i).Dijkstra.calculateGcost(pathBFS2.get(i), pathBFS2.get(i+1));
		}
		for(int i = 0; i < (pathDFS1.size()-1); i++){
			lengthDFS1 = lengthDFS1 + pathDFS1.get(i).Dijkstra.calculateGcost(pathDFS1.get(i), pathDFS1.get(i+1));
		}
		for(int i = 0; i < (pathDFS2.size()-1); i++){
			lengthDFS2 = lengthDFS2 + pathDFS2.get(i).Dijkstra.calculateGcost(pathDFS2.get(i), pathDFS2.get(i+1));
		}
		for(int i = 0; i < (pathDijkstra1.size()-1); i++){
			lengthDijkstra1 = lengthDijkstra1 + pathDijkstra1.get(i).Dijkstra.calculateGcost(pathDijkstra1.get(i), pathDijkstra1.get(i+1));
		}
		for(int i = 0; i < (pathDijkstra2.size()-1); i++){
			lengthDijkstra2 = lengthDijkstra2 + pathDijkstra2.get(i).Dijkstra.calculateGcost(pathDijkstra2.get(i), pathDijkstra2.get(i+1));
		}
		for(int i = 0; i < (pathAstar1.size()-1); i++){
			lengthAstar1 = lengthAstar1 + pathAstar1.get(i).Dijkstra.calculateGcost(pathAstar1.get(i), pathAstar1.get(i+1));
		}
		for(int i = 0; i < (pathAstar2.size()-1); i++){
			lengthAstar2 = lengthAstar2 + pathAstar2.get(i).Dijkstra.calculateGcost(pathAstar2.get(i), pathAstar2.get(i+1));
		}
		
		if(lengthBFS2 > lengthBFS1){
			System.out.println(lengthBFS1);
		}else{
			System.out.println(lengthBFS2);
		}
		if(lengthDFS2 > lengthDFS1){
			System.out.println(lengthDFS1);
		}else{
			System.out.println(lengthDFS2);
		}
		if(lengthDijkstra2 > lengthDijkstra1){
			System.out.println(lengthDijkstra1);
		}else{
			System.out.println(lengthDijkstra2);
		}
		if(lengthAstar2 > lengthAstar1){
			System.out.println(lengthAstar1);
		}else{
			System.out.println(lengthAstar2);
		}





		
		
		
		System.out.println(grid.walkable_part());
		
		System.out.println(walkedBFSfinal);
		System.out.println(walkedDFSfinal);
		System.out.println(walkedDijkstrafinal);
		System.out.println(walkedAstarfinal);
				
		System.out.println("length BFS       " + finalpathBFS.size());
		System.out.println("length DFS       " + finalpathDFS.size());
		System.out.println("length dijkstra  " + finalpathDijkstra.size());
		System.out.println("length Astar     " + finalpathAstar.size());
		
//		System.out.println("end time BFS       " + totalTimeBFS);
//		System.out.println("end time DFS       " + totalTimeDFS);
//		System.out.println("end time dijkstra  " + totalTimeDijkstra);
//		System.out.println("end time Astar     " + totalTimeAstar);
//
//		System.out.println(checkEqual(finalpathDijkstra, finalpathBFS));
//		System.out.println(checkEqual(finalpathDijkstra, finalpathDFS));
//		System.out.println(checkEqual(finalpathDijkstra, finalpathDijkstra));
//		System.out.println(checkEqual(finalpathDijkstra, finalpathAstar));
//		
//		if(finalpathBFS.equals(pathBFS2)){
//			System.out.println("BFS exit 2");
//		}else{
//			System.out.println("BFS exit 1");
//		}
//		
//		if(finalpathDFS.equals(pathDFS2)){
//			System.out.println("DFS exit 2");
//		}else{
//			System.out.println("DFS exit 1");
//		}
//		
//		if(finalpathDijkstra.equals(pathDijkstra2)){
//			System.out.println("dijkstra exit 2");
//		}else{
//			System.out.println("dijkstra exit 1");
//		}
//		
//		if(finalpathAstar.equals(pathAstar2)){
//			System.out.println("astar exit 2");
//		}else{
//			System.out.println("astar exit 1");
//		}
//		
//		System.out.println(noRouteBFS + "," + noRouteDFS + "," +  noRouteDijkstra + "," + noRouteAstar);

		
//		grid = increase_grid_size(grid);
//		grid.printGridBetter();
//		
//		grid.printBetter(BFSAlgorithm.walkedList);
//		grid.printBetter(DFSAlgorithm.walkedList);
//		grid.printBetter(DijkstraAlgorithm.walkedList);
//		grid.printBetter(AstarAlgorithm.walkedList);
//		
//		grid.printBetter(finalpathBFS);
//		grid.printBetter(finalpathDFS);
//		grid.printBetter(finalpathDijkstra);
//		grid.printBetter(finalpathAstar);

		
	}
	

	

	private double checkEqual(List<Cell> goodPath, List<Cell> checkPath) {
		double check = 0;
		for(int i = 0; i< checkPath.size(); i++){
			for(int j = 0; j < goodPath.size(); j++){
				if(checkPath.get(i).getIndexX() == goodPath.get(j).getIndexX() && checkPath.get(i).getIndexY() == goodPath.get(j).getIndexY()){
					check = check+1;
				}
			}
		}
		
		return (check/checkPath.size())*100;
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
	
	public Grid increase_grid_size( Grid grid_old){
		double grid_size = grid_old.cell_size() + 0.5;
//		double change_factor = grid_old.cell_size()/grid_size;
//		grid_old.x =  1 + (int) (x * change_factor);
//		grid_old.y =  1 + (int) (y * change_factor);
		
		Grid grid = new Grid(x,y,grid_size);
		
		for(int i = 0; i < brandweermannen.size(); i++){
			grid.parse_coordinates(brandweermannen.get(i));
		}
		return grid;
	}
		
	public Grid decrease_grid_size(Grid grid_old){
		double grid_size = grid_old.cell_size() - 0.5;
		double change_factor = grid_old.cell_size()/grid_size;
//		x =  1 + (int) (x * change_factor);
//		y =  1 + (int) (y * change_factor);
		
		Grid grid = new Grid(x,y,grid_size);
		
		for(int i = 0; i < brandweermannen.size(); i++){
			grid.parse_coordinates(brandweermannen.get(i));
		}
		return grid;
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
