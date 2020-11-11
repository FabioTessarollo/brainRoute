package brainRoute;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BrainRouteMain {

	public static void main(String[] args) {
		
			Scanner s = new Scanner(System.in);
			System.out.print("Press enter to start\n");
			s.nextLine();
			System.out.print("Level 1\n");
			oneLevel(3);
			System.out.print("Level 2\n");
			oneLevel(5);
			System.out.print("Level 3\n");
			oneLevel(8);
			System.out.print("Level 4\n");
			oneLevel(10);
			System.out.print("Well done, you are a brain route genius!");
			s.close();
			
	}
	
	public static void oneLevel(int length) {
		

			Scanner s = new Scanner(System.in);
			List<String> route = generateRoute(length);
			String ans = "";
			
			for(int j=0;j<route.size();j++){
				if(s.nextLine() != null)
					System.out.println(route.get(j));
				if(j==route.size()-1) {
					ans = s.nextLine().toString();
					if(ans.compareTo("s") == 0)
						System.out.print("Good job, next level\n");
					else {
						System.out.print("You are mistaken, try again\n");
						oneLevel(length);
				}
			}
		}
	}
	
	public static List<String> generateRoute(int lenght)
	{

		List<String> route = new LinkedList<String>();
		Point point = new Point(0,0,0);
		
		List<Integer> givenList = Arrays.asList(1,2,3);
	    Random rand = new Random();

		
		for (int i = 0; i <= lenght; i++) {
			
		    int direction = givenList.get(rand.nextInt(givenList.size()));
		    
		    if(direction == 1)
		    	route.add(point.moveX());
		    if(direction == 2)
		    	route.add(point.moveY());
		    if(direction == 3)
		    	route.add(point.moveZ());
		    
		    if(point.isOrigin()) {
		    	route.remove(i);
		    	i--;
		    }
		}
		
		while (!point.isOrigin()) {
			
		    int direction = givenList.get(rand.nextInt(givenList.size()));
		    
		    if(direction == 1 && point.getX()!=0)
		    	route.add(point.moveBackX());
		    if(direction == 2 && point.getY()!=0)
		    	route.add(point.moveBackY());
		    if(direction == 3 && point.getZ()!=0)
		    	route.add(point.moveBackZ());
		}
		
		return route;
	}
	
}
