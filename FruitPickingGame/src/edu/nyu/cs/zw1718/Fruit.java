package edu.nyu.cs.zw1718;


import java.util.Random;

import processing.core.*;

/**
 * this class represents a falling fruit.
 * It extends the FallingObject class.
 * @author Ziyi Wang
 * @version 0.1
 *
 */

public class Fruit extends FallingObject{
	
	private String fruitName;
	private PImage img;
	
	/**
	 * an overridden constructor of the parent class Falling Object.
	 * the constructor that constructs a random fruit.
	 * @param app A reference to the object that controls the flow of the game
	 * @param type the type of the fruits that will be represented
	 */
	public Fruit(App app, String type) {
		super(app);
		if (type.equals("strawberry")) {
			this.img = this.setImage("edu/nyu/cs/zw1718/strawberry.png");
		}
		else if (type.equals("banana")) {
			this.img = this.setImage("edu/nyu/cs/zw1718/banana.png");
		}
		else if (type.equals("orange")) this.img=this.setImage("edu/nyu/cs/zw1718/orange.png");
		else if (type.equals("blueberry")) this.img = this.setImage("edu/nyu/cs/zw1718/blueberry.png");
		
		fruitName=type;
		
	}
	
	/**
	 * removes this fruit from the  PApplet's list of fruits
	 */
	public void intoBasket() {
		super.getApp().getFruits().remove(this);
		}
	/**
	 * gets the name of the fruit
	 * @return a string represents the name of the fruit
	 */
	public String getFruitName() {
		return fruitName;
	}
	

	
}
	
	
	


