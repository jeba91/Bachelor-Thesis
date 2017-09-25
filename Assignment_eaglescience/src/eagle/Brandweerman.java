package eagle;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Brandweerman {
	
//	List containing the coordinates walked of the firefighter
	private List<Point2D.Double> points;
		
//	Constructor for the firefighter
	public Brandweerman(){
		points = new ArrayList<Point2D.Double>();
	}
	
//	Function to return the coordinates of the firefighter
    public List<Point2D.Double> getPoints(){
    	return points;
    }
	
//  Function to parse the coordinates delivered from the SenSuit system    
    public void parseFile(File coordinates) throws FileNotFoundException{
		Scanner identifiers = new Scanner(coordinates);
		final String regex = ",";		
		
		while (identifiers.hasNext()){
			
			String coordinate_raw = identifiers.next();
			String[] coordinate = coordinate_raw.split(regex);
			
			double x = Double.parseDouble(coordinate[0]);
			double y = Double.parseDouble(coordinate[1]);
			
			Point2D.Double add = new Point2D.Double(x,y);
			
			points.add(add);
		}
		identifiers.close();
    }    
}
