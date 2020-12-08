package edu.nyu.cs.zw1718;

import java.util.ArrayList;

/**
 * Controller for the fruit-picking game containing the logic of the game
 * @author Ziyi Wang
 * @version 0.1
 */
import java.util.Random;

import processing.core.*;

public class App extends PApplet {
	
	private final int W = 1000;
	private final int H = 650;
	
	
	private PImage bg;
	
	private Person person;
	
	private Bomb bomb;
	
	private ScoreBoard scoreBoard;
	
	private PImage endImg1;
	private PImage endImg2;
	
	private int time;
	private int totalTime;
	
	private ArrayList<Fruit> fruits = new ArrayList<Fruit>();
	private int pickedOranges;
	private int pickedStrawberries;
	private int pickedBlueberries;
	private int pickedBananas;
	private String fruitName;
	private int sGoal;
	private int blGoal;
	private int baGoal;
	private int oGoal;
	int sRemaining;
	int blRemaining;
	int baRemaining;
	int oRemaining;
	
	/**
	 * Called once to set up window.
	 */
	public void settings() {
		this.size(this.W, this.H);
	}
	
	/**
	 * Called once on load. Used to create the settings of the window.
	 */
	public void setup() {
		this.bg=loadImage("edu/nyu/cs/zw1718/orchard.jpg");
		//create 5 random fruits on screen
		for (int i=0; i<5; i++) {
			String[] fruitChoices= {"strawberry","blueberry","orange","banana"};			
			Random rd=new Random();
			int index=rd.nextInt(fruitChoices.length);
			String fruitChoice=fruitChoices[index];
			Fruit fruit = new Fruit(this,fruitChoice);  
			this.fruits.add(fruit); 
		}
		
		this.person= new Person(this);
		this.bomb=new Bomb(this,5);
		this.scoreBoard=new ScoreBoard(this);
		this.endImg1=this.loadImage("edu/nyu/cs/zw1718/gameEnd.png");
		this.endImg2=this.loadImage("edu/nyu/cs/zw1718/congratulations.png");
		this.time=this.millis();
		this.totalTime=66000;
		Random rd=new Random();
		this.sGoal=rd.nextInt(20)+1;
		this.blGoal=rd.nextInt(20)+1;
		this.baGoal=rd.nextInt(20)+1;
		this.oGoal=rd.nextInt(20)+1;

			
		
	}
	
	/**
	 * Called repeatedly approximately 60 times per second, causing animation effect.
	 */
	public void draw() {
		this.background(this.bg);
		
		//loop through fruits ArrayList
		if (fruits.size()==5) {
			for (int i=0; i<fruits.size(); i++) {
				Fruit fruit = this.fruits.get(i);
				fruit.move(); 
				fruit.draw(); 
			}
		}
		else {
			for (int i=0;i<5-fruits.size();i++) {
				String[] fruitChoices= {"strawberry","blueberry","orange","banana"};			
				Random rd=new Random();
				int index=rd.nextInt(fruitChoices.length);
				String fruitChoice=fruitChoices[index];
				Fruit fruit = new Fruit(this,fruitChoice);  
				this.fruits.add(0,fruit); 
				}
			for (int i=0; i<fruits.size(); i++) {
				Fruit fruit = this.fruits.get(i);
				fruit.move(); 
				fruit.draw(); 
			}
				
				
			}
		
		//person and bomb movement
		this.person.draw();
		this.bomb.move();
		this.bomb.draw();
		
		ArrayList<Fruit> fruitsToRemove = new  ArrayList<Fruit>();
		
		//detect whether the person has picked the bomb
		if (bomb.isCollision(this, bomb, person)) {
			this.image(this.endImg1,100,70,800,600);
			this.fill(0);
			this.text("BOMB!",370,320);
			this.text("GAME OVER!",300,450);
			this.fill(255);
			this.noLoop();
			
		}
		
		//count down with representation on the screen
		if(totalTime-this.millis()>=0){
		    time=(totalTime-this.millis())/1000;
			this.text(Integer.toString(time),800,80);
		}
		else {
			this.image(this.endImg1,100,70,800,600);
			this.fill(0);
			this.text("TIME OVER!",300,400);
			this.fill(255);
			this.noLoop();
		}
		
		//detect whether the person has picked fruits
		for (Fruit fruit: this.fruits) {
			if (Fruit.isCollision(this,fruit, person)){
				fruitsToRemove.add(fruit);
				fruitName=fruit.getFruitName();
				switch (fruitName){
					case("orange"):
						pickedOranges++;
						break;
					case("strawberry"):
						pickedStrawberries++;
						break;
					case("blueberry"):
						pickedBlueberries++;
						break;
					case("banana"):
						pickedBananas++;
						break;
				}
			}
		}
		
		//remove the fruits that have been picked from the fruits ArrayList
		for (Fruit fruit : fruitsToRemove) {
			fruit.intoBasket(); 
		}

		//scoreBoard recording the remaining fruits needed to pick to win the game
		sRemaining=(sGoal>=pickedStrawberries)? sGoal-pickedStrawberries: 0;
		blRemaining=(blGoal>=pickedBlueberries)? blGoal-pickedBlueberries: 0;
		baRemaining=(baGoal>=pickedBananas)? baGoal-pickedBananas: 0;
		oRemaining=(oGoal>=pickedOranges)? oGoal-pickedOranges: 0;
		
		this.scoreBoard.update(baRemaining, blRemaining, sRemaining, oRemaining);
		this.scoreBoard.draw();
		
		if (sRemaining==0&&blRemaining==0&&baRemaining==0&&oRemaining==0) {
			this.image(this.endImg2,100,70,800,600);
			this.text("Mission Complete!",220,350);
			this.noLoop();
		}
	}
	
	/**
	 * Getter for the ArrayList of Fruit objects currently on the screen
	 * @return ArrayList of Fruit objects
	 */
	public ArrayList<Fruit> getFruits() {
		return this.fruits;
	}
	
	/**
	 * Automatically called to start program.  This method calls PApplet's main method and passes it the class name of this class.
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		PApplet.main("edu.nyu.cs.zw1718.App");
	}	
	
	
	

}


