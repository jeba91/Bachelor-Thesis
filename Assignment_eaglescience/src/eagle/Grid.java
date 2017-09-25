package eagle;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Grid {
//	Creating an array of array containing all cells for the grid
	Cell[][] grid;
//	The cell size
	private double cell_size = 1;
//	The largest x and y
	public int x;
	public int y;
//	Constructor for the grid
	public Grid(int x, int y){	
		grid = new Cell[x][y];
		this.x = x;
		this.y = y;	
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				Cell cell = new Cell();
				cell.setIndexX(i);
				cell.setIndexY(j);
				grid[i][j] = cell;
			}
		}
	}
//	Constructor for the grid with different cell size
	public Grid(int x, int y, double cell_size){
		
		this.cell_size = cell_size;
		
		grid = new Cell[x][y];
		
		this.x = x;
		this.y = y;
		
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				Cell cell = new Cell();
				cell.setIndexX(i);
				cell.setIndexY(j);
				grid[i][j] = cell;
			}
		}
	}
//	Empty the whole grid for new algorithm
	public void emptyGrid(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				grid[i][j].emptyCell();
			}
		}
	}
//	Function to get the cell size
	public double cell_size(){
		return this.cell_size;
	}	
//	Function to parse the x coordinate
	public int parse_x(Point2D.Double point){
		int parsedX = (int) (point.getX() / this.cell_size);
		return parsedX;
	}
//	Function to parse the y coordinate
	public int parse_y(Point2D.Double point){
		int parsedY = (int) (point.getY() / this.cell_size);
		return parsedY;
	}
//	Function to parse the coordinates of a firefighter
	public void parse_coordinates(Brandweerman bmw){
		for(int i = 0; i < bmw.getPoints().size(); i++){
			
			Point2D.Double coordinate = bmw.getPoints().get(i);			
			
			int x = parse_x(coordinate);
			int y = parse_y(coordinate);
			
			grid[x][y].add_coordinate(coordinate);
		}
	}
//	Returns the walkable part count
	public int walkable_part(){
		int walkable = 0;
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				if(grid[i][j].getWalkable() == true){
					walkable = walkable + 1;
				}
			}
		}
		return walkable;
	}
//	Function to print the grid in the console
	public void print(int x, int y){
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i = 0; i < x; i++){
		    for (int j = 0; j < y; j++){
		    	if(grid[i][j].getWalkable() == true){
		    		System.out.print(df.format(grid[i][j].getMiddle().getX()) + "." + df.format(grid[i][j].getMiddle().getY()));
		    		System.out.print("\t");
		    	}else{
		    		System.out.print("--");
		    		System.out.print("\t");
		    	}
		    }
		    System.out.println("");
		}
	}
//	Function to print the path in the console
	public void print_path(int x, int y, List<Cell> path ){
		DecimalFormat df = new DecimalFormat("#.##");	
		for (int i = 0; i < x; i++){
		    for (int j = 0; j < y; j++){
		    	if(path.contains(grid[i][j])){
		    		System.out.print(df.format(grid[i][j].getMiddle().getX()) + "." + df.format(grid[i][j].getMiddle().getY()));
		    		System.out.print("\t");
		    	}else{
		    		System.out.print("--");
		    		System.out.print("\t");
		    	}
		    }
		    System.out.println("");
		}
	}
	
//	Function used by the function that prints the path in a JPanel
	public static class printGrid extends JPanel {
	        private List<Point> fillCells;
	        private List<Point> fireCells;
	        public printGrid() {
	            fillCells = new ArrayList<>(25);
	            fireCells = new ArrayList<>(25);
	        }
	        @Override
	        protected void paintComponent(Graphics g) {
	          	super.paintComponent(g);   
	            for (Point fillCell : fireCells) {
	                int cellX = 4 + (fillCell.x * 4);
	                int cellY = 4 + (fillCell.y * 4);
	                g.setColor(Color.YELLOW);
	                g.fillRect(cellX, cellY, 4, 4);
	            }
	            for (Point fillCell : fillCells) {
	                int cellX = 4 + (fillCell.x * 4);
	                int cellY = 4 + (fillCell.y * 4);
	                g.setColor(Color.RED);
	                g.fillRect(cellX, cellY, 4, 4);
	            }        
	            g.setColor(Color.BLACK);
	            g.drawRect(4, 4, 50, 50);
	            for (int i = 4; i <= 1200; i += 4) {
	                g.drawLine(i, 4, i, 1210);
	            }
	            for (int i = 4; i <= 1200; i += 4) {
	                g.drawLine(4, i, 1210, i);
	            }
	        }
	        public void fillCell(int x, int y) {
	            fillCells.add(new Point(x, y));
	            repaint();
	        } 
	        public void fillCell2(int x, int y) {
	            fireCells.add(new Point(x, y));
	            repaint();
	        }
   }
	
//	Function to print the path in JPanel
	public static void printBetter(List<Cell> path) throws FileNotFoundException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                printGrid printgrid = new printGrid();
                JFrame window = new JFrame();
                window.setSize(300, 350);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(printgrid);
                window.setVisible(true);
            	for (int i = 0; i < path.size(); i++){
                	printgrid.fillCell(path.get(i).getIndexX(), path.get(i).getIndexY());
                }
            }
        });
    }
	
//	Function to print the grid in JPanel
	public void printGridBetter() throws FileNotFoundException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                printGrid printgrid = new printGrid();
                JFrame window = new JFrame();
                window.setSize(300, 350);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(printgrid);
                window.setVisible(true);
            	for (int i = 0; i < x ; i++){
            		for (int j = 0; j < y ; j++){
            			if(grid[i][j].getWalkable() == true){
        					printgrid.fillCell(grid[i][j].getIndexY(), grid[i][j].getIndexX());
        				}
            			if(grid[i][j].getFireWEight() > 0){
        					printgrid.fillCell2(grid[i][j].getIndexY(), grid[i][j].getIndexX());
        				}
                    }
                }
            }
        });
    }

//	Function to add the fires
	public void addFire(Point2D.Double fire, int widthFire){
		List<Cell> fireCells = new LinkedList<Cell>();	
		int fireX = parse_x(fire);
		int fireY = parse_y(fire);
		Cell fireStart = grid[fireX][fireY];
		fireCells.add(fireStart);		
		for(int i = widthFire; i > 0; i = i-1){			
			List<Cell> adjacentFire = new LinkedList<Cell>();		
			for(int j=0; j<fireCells.size(); j++){
				Point2D.Double current = new Point2D.Double(fireCells.get(j).getIndexX(), fireCells.get(j).getIndexY());
				List<Cell> adjacentCells = getAdjacent(current);
				adjacentFire.addAll(adjacentCells);
			}			
			while(fireCells.size() != 0){
				fireCells.get(0).setFireWeight(i*3);
				fireCells.remove(0);
			}			
			fireCells.addAll(adjacentFire);			
		}			
	}
//	Function for the fire to get the adjacent cells
	public List<Cell> getAdjacent(Point2D.Double center) {		
    	int x = (int) (center.getX() / cell_size());	
    	int y = (int) (center.getY() / cell_size());               
        List<Cell> adj = new LinkedList<Cell>();
        Cell temp;
        if (x > 0) {
            temp = this.grid[x - 1][y];
            if(temp.getFireWEight() == 0){
            	adj.add(temp);
            }
        }
        if (x < (this.x-1)) {
            temp = this.grid[x + 1][y];
            if(temp.getFireWEight() == 0){
            	adj.add(temp);
            }
        }
        if (y > 0) {
            temp = this.grid[x][y - 1];
            if(temp.getFireWEight() == 0){
            	adj.add(temp);	
            }
        }
        if (y < (this.y-1)) {
        	temp = this.grid[x][y + 1];
        	if(temp.getFireWEight() == 0){
                adj.add(temp);
        	}
        }
        return adj;
    }	
	    
	    
		
		
}
