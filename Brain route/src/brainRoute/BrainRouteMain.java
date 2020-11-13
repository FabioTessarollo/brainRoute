package brainRoute;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BrainRouteMain {
	
	static int Lvl = 1;
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.print("Press enter to start\n");
		s.nextLine();
		
		oneLevel(3, s);
		oneLevel(5, s);
		oneLevel(8, s);
		
		System.out.print("Well done, you are a brain route genius!");
		s.close();

	}

	public static void oneLevel(int length, Scanner s) {

		List<String> route = generateRoute(length);
		String ans;
		
		System.out.println("Level" + Lvl + "\n");
		
		for (int j = 0; j < route.size(); j++) {
			System.out.println(route.get(j));	
			ans = s.nextLine().toString();
			if (j == route.size() - 1) {
				if (ans.compareTo("s") == 0) {
					System.out.print("Good job, next level\n\n");
					Lvl++;
				}
				else {
					System.out.print("You are mistaken, try again\n\n");
					oneLevel(length, s);
				}
			} else {
				if (ans.compareTo("s") == 0) {
					System.out.print("Too early, try again\n");
					oneLevel(length, s);
					return;
				}
			}
		}
	}

	public static List<String> generateRoute(int lenght) {

		List<String> route = new LinkedList<String>();
		Point point = new Point(0, 0, 0);

		List<Integer> givenList = Arrays.asList(1, 2, 3);
		Random rand = new Random();

		for (int i = 0; i <= lenght; i++) {

			int direction = givenList.get(rand.nextInt(givenList.size()));

			if (direction == 1)
				route.add(point.moveX());
			if (direction == 2)
				route.add(point.moveY());
			if (direction == 3)
				route.add(point.moveZ());

			if (point.isOrigin()) {
				route.remove(i);
				i--;
			}
		}

		while (!point.isOrigin()) {

			int direction = givenList.get(rand.nextInt(givenList.size()));

			if (direction == 1 && point.getX() != 0)
				route.add(point.moveBackX());
			if (direction == 2 && point.getY() != 0)
				route.add(point.moveBackY());
			if (direction == 3 && point.getZ() != 0)
				route.add(point.moveBackZ());
		}

		return route;
	}

}
