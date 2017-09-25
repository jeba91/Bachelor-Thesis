import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_interface {


	
	//file = new File();

	
	//brandweerman_1 = new Brandweerman brandweerman(file);
	
	
	//cell_grid = new Cell cell;
	//grid_map = new Grid grid(cell_grid);
	
	
	//grid_map.add_walkable(brandweerman);
	
	
	//while(grid_map.check_connections() == false){
	//	cell.enlarge();
	//	grid_map = new Grid grid(cell_grid);
	
	
	//for coordinate in brandweerman.coordinates{
	//	if grid.contains_coordinates(coordinate){
	//		grid.set_walkable(coordinate)
	//	else{
	//		while(grid.contains_coordinates(coordinate)==false){
	//			grid.add_row
	//			grid.add_column
	//		grid.set_walkable(coordinate)
	
	
	//algorithm_used = new Algorithm astar;
	
	//grid_map.route(algorithm_used);
	
	//grid_map.print();
	
	

    
	public static void main() throws FileNotFoundException {
		new Main_interface().start();
	}

	public void start() throws FileNotFoundException {
		
		File file = new File("C:/Users/Jeroen/workspacejava/Assignment_eaglescience/src/Files/coordinates.txt");
		Brandweerman bmw1 = new Brandweerman();
		bmw1.parseFile(file);
		
		for(int i = 0; i < bmw1.points.size(); i++ ){
			System.out.println(bmw1.points.get(i).getX());
			System.out.println(bmw1.points.get(i).getY());			
		}
		
	}
	
}
