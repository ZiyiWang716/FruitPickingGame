package edu.nyu.cs.zw1718;

import processing.core.*;
import java.util.Random;

/**
 * This class represents all the falling objects in the game.
 * @author Ziyi Wang
 * @version 0.1
 */


public class FallingObject {
	private App app; 
	
	private int x;
	private int y;
	private int speed;
	private PImage img;
	private final int WIDTH=70;
	private final int HEIGHT=70;
	
	
	
	/**
	 * constructor for a falling object
	 * @param app A reference to the object that controls the flow of the game
	 */
	public FallingObject(App app) {
		this.app = app; 
		this.y = 0; 
		Random random=new Random();
		this.x = random.nextInt(1000); 
		this.speed = random.nextInt(5)+3;
		
	}
	
	/**
	 * an overloaded constructor for a falling object with customized speed
	 * @param app A reference to the object that controls the flow of the game
	 * @param speed the speed that the object will fall
	 */
	public FallingObject(App app,int speed) {
		this.app=app;
		this.y=0;
		Random random = new Random();
		this.x=random.nextInt(1000);
		this.speed=speed;
		
	}
	
	/**
	 * sets the image of the falling object
	 * @param imgPath the file path of the image that will be loaded
	 * @return the image 
	 */
	public PImage setImage(String imgPath) {
		this.img=this.app.loadImage(imgPath);
		return this.img;
		
	}
	
	
	/**
	 * draws the falling object to the screen
	 */
	public void draw() {
		this.app.image(this.img,this.x,this.y,70,70);
	}
	/**
	 * sets the position of the falling object
	 * @param x the x-position of the object
	 * @param y the y-position of the object
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * makes the falling of the object 
	 */
	public void move() {
		int newY;
		int newX;
		Random random=new Random();
		if (this.y<600) {
			newY = this.y + this.speed;
			this.y=newY;
			newX=this.x;
		}
		else {
			newY=0;
			newX=random.nextInt(1000);
		}
		this.setPosition(newX,newY);
		
	}
	
	/**
	 * gets the width of the object based on the width of its image
	 * @return the width of the object
	 */
	public int getWidth() {
		return this.WIDTH;
	}
	
	/**
	 * gets the height of the object based on the height of its image
	 * @return the height of the object
	 */
	public int getHeight() {
		return this.HEIGHT;
	}
	/**
	 * gets the x-coordinate of the object in the screen
	 * @return x-coordinate
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * gets the y-coordinate of the object in the screen
	 * @return y-coordinate
	 */
	public int getY() {
		return this.y;
	}
	/**
	 * gets the speed of the object's falling
	 * @return the speed of the object
	 */
	public int getSpeed() {
		return this.speed;
	}
	

	/**
	 * checks the collision between an falling object and the person.
	 * @param app A reference to the object that controls the flow of the game
	 * @param object the falling object
	 * @param person the person
	 * @return a boolean expression tells whether the collision has happened
	 */
	public static boolean isCollision(App app, FallingObject  object, Person person) {
		boolean collision = false; 
		if (object.getX() >= app.mouseX*850/1000+10 && object.getX()<app.mouseX*850/1000+person.getWidth()-50) {
			if (object.getY()+object.getHeight() >= 440&& object.getY()+object.getHeight()<=490) {
				collision = true;
			}
		}
		
		return collision;

	}
	
	/**
	 * gets the reference to the object that controls the flow of the game
	 * @return the reference
	 */
	public App getApp() {
		return app;
	}
	
	/**
	 * sets the x-position of the object
	 * @param x an integer indicates the x-position
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * sets the y-position of the object
	 * @param x an integer indicates the y-position
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * sets the speed of the object
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
