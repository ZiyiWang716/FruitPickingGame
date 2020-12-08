package edu.nyu.cs.zw1718;

import processing.core.*;
import java.util.Random;

/**
 * this class represents a falling bomb.
 * It extends the FallingObject class.
 * @author Ziyi Wang
 * @version 0.1
 *
 */

public class Bomb extends FallingObject{
	
	private PImage img;
	private int speed;
	
	/**
	 * an overridden constructor of the parent class Falling Object.
	 * the constructor that constructs a bomb
	 * @param app A reference to the object that controls the flow of the game
	 * @param speed the speed that the bomb will fall 
	 */
	public Bomb(App app, int speed) {
		super(app,speed);
		this.img=this.setImage("edu/nyu/cs/zw1718/bomb.png");
		
	}
	
	/**
	 * an overridden method that controls the movement of the falling bomb
	 */
	public void move() {
		super.move();
		if (super.getY()==0) {
			Random random= new Random();
			int speed= random.nextInt(5);
			this.setSpeed(speed);
		}
	}
	
	

}
