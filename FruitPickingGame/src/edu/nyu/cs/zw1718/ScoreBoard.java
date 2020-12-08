package edu.nyu.cs.zw1718;

import processing.core.*;
/**
 * this class represents the score board of the game.
 * @author Ziyi Wang
 * @version 0.1
 */


public class ScoreBoard {
	private int bananas;
	private int strawberries;
	private int blueberries;
	private int oranges;
	private App app;
	private PImage baImg;
	private PImage blImg;
	private PImage oImg;
	private PImage sImg;
	
	/**
	 * constructor for a score board
	 * @param app A reference to the object that controls the flow of the game
	 */
	ScoreBoard(App app ){
		this.app=app;
		this.baImg=this.app.loadImage("edu/nyu/cs/zw1718/banana.png");
		this.blImg=this.app.loadImage("edu/nyu/cs/zw1718/blueberry.png");
		this.sImg=this.app.loadImage("edu/nyu/cs/zw1718/strawberry.png");
		this.oImg=this.app.loadImage("edu/nyu/cs/zw1718/orange.png");
	}
	
	/**
	 * draws the score board on the top left of the screen
	 */
	public void draw() {
		this.app.image(this.baImg,10,10,80,80);
		this.app.image(this.blImg,150,10,80,80);
		this.app.image(this.sImg,290,10,80,80);
		this.app.image(this.oImg,450,10,80,80);
		this.app.textSize(40);
		this.app.text(Integer.toString(bananas),100,80);
		this.app.text(Integer.toString(blueberries),240,80);
		this.app.text(Integer.toString(strawberries),380,80);
		this.app.text(Integer.toString(oranges),540,80);
		this.app.textSize(70);
	}
	
	/**
	 * updates the scores on the score board 
	 * @param ba the remaining bananas needed to be picked
	 * @param bl the remaining blueberries needed to be picked
	 * @param s the remaining strawberries needed to be picked
	 * @param o the remaining oranges needed to be picked
	 */
	public void update(int ba, int bl, int s, int o) {
		this.bananas=ba;
		this.blueberries=bl;
		this.strawberries=s;
		this.oranges=o;
		
		
	}
	

}
