package edu.nyu.cs.zw1718;

import processing.core.*;
/**
 * This class represents the person that picks fruits.
 * @author Ziyi Wang
 * @version 0.1
 *
 */

public class Person {
	

	private App app;
	
	private PImage img;
	private int y;
	private int x;
	private final int WIDTH=150;
	private final int HEIGHT=230;
	private float mapping;
	
	/**
	 * constructor for the person
	 * @param app A reference to the object that controls the flow of the game.
	 */
	public Person(App app) {
		this.app=app;
		this.img=app.loadImage("edu/nyu/cs/zw1718/farmer.png");
		this.y=380;
		this.x=app.mouseX;
	}
	
	/**
	 * draws the person to the screen.
	 */
	public void draw() {
		this.app.image(this.img,this.app.mouseX*850/1000,this.y,this.WIDTH,this.HEIGHT);
	}
	
	/**
	 * gets the width of the person based on the width of the image
	 * @return the width of the person
	 */
	public int getWidth() {
		return this.WIDTH;
	}
	
	/**
	 * gets the height of the person based on the height of the image
	 * @return the height of the person
	 */
	public int getHeight() {
		return this.HEIGHT;
	}
	
	/**
	 * gets the x-coordinate of the person in the screen
	 * @return x-coordinate
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * gets the y-coordinate of the person in the screen
	 * @return y-coordinate
	 */
	public int getY() {
		return this.y;
	}



}
