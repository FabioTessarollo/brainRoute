package brainRoute;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Point {
	
    int x;
    int y;
    int z;

	public Point(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String moveX() {
		List<Integer> givenList = Arrays.asList(-1, 1);
	    Random rand = new Random();
	    int oneStep = givenList.get(rand.nextInt(givenList.size()));
	    this.x = x + oneStep;
	    if(oneStep == 1) 
	    	return "right";
	    else
	    	return "left";
	}
	
	public String moveY() {
		List<Integer> givenList = Arrays.asList(-1, 1);
	    Random rand = new Random();
	    int oneStep = givenList.get(rand.nextInt(givenList.size()));
	    this.y = y + oneStep;
	    if(oneStep == 1) 
	    	return "forward";
	    else
	    	return "backward";
	}
	
	public String moveZ() {
		List<Integer> givenList = Arrays.asList(-1, 1);
	    Random rand = new Random();
	    int oneStep = givenList.get(rand.nextInt(givenList.size()));
	    this.z = z + oneStep;
	    if(oneStep == 1) 
	    	return "up";
	    else
	    	return "down";
	}
	
	
	public String moveBackX() {
		if(this.x>0) {
			this.x = x - 1;
			return "left";
		}		
		else {
			this.x = x + 1;
			return "right";
		}	
	}
	
	public String moveBackY() {
		if(this.y>0) {
			this.y = y - 1;
			return "backward";
		}		
		else {
			this.y = y + 1;
			return "forward";
		}	
	}
	
	public String moveBackZ() {
		if(this.z>0) {
			this.z = z - 1;
			return "down";
		}		
		else {
			this.z = z + 1;
			return "up";
		}	
	}
	


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	
	public boolean isOrigin() {
		if (x == 0 && y == 0 && z == 0)
			return true;
		return false;
	}
	
	
    
}
