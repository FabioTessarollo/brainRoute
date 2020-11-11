package brainRoute;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BrainRouteMain {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		CLIn cleaner = new CLIn();
		int n = 4; // number of desired levels

		System.out.print("Press enter to start\n");
		s.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.print("Level " + i + " \n");
			oneLevel(3 * i - i, s, cleaner); // formula that generates levels
		}
		System.out.print("Well done, you are a brain route genius!");
		s.close();

	}

	public static void oneLevel(int length, Scanner s, CLIn cleaner) {

		List<String> route = generateRoute(length);
		String ans;

		for (int j = 0; j < route.size(); j++) {
			if (s.nextLine() != null) {
				cleaner.clearCLI(); // terminal is cleared before printing next step
				System.out.println(route.get(j));
			}
			ans = s.nextLine().toString();
			if (j == route.size() - 1) {
				if (ans.compareTo("s") == 0)
					System.out.print("Good job, next level\n");
				else {
					System.out.print("You are mistaken, try again\n");
					oneLevel(length, s, cleaner);
				}
			} else {
				if (ans.compareTo("s") == 0) {
					/*
					 * If user presses s before it should notify him then let him retry the level.
					 * Once he completes the level return to the main, as user should not be
					 * prompted with the remaining steps of the level he failed earlier.
					 */
					System.out.print("Too early, try again\n");
					oneLevel(length, s, cleaner);
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
