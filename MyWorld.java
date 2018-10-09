import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main World class
 * 
 * @author Chandler Clarke
 * @version 1.1
 */
public class MyWorld extends greenfoot.World
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private int timerHouseOne, timerTrees = 0;
    private static int MAXHEALTH = 5;
    private int yCoord, score, health;
   
    public MyWorld()
    {    
        super(WIDTH, HEIGHT, 1, false); 
        prepare();
        health = 5;
        score = 0;
        showText("Score: " + score, 100, 25);
        showText("Health: " + health, 500, 25);
    }

    public void act(){
        setPaintOrder(Car.class);
        itemSpawner();
        timers();
        showText("Score: " + score, 100, 25);
        showText("Health: " + health, 500, 25);
    }
    //Builds base world
    private void prepare(){
        addObject(new Road(), 600, 200);
        addObject(new Road(), 200, 200);
        addObject(new Road(), -260, 200);
        addObject(new Car(), 300, 200);
    }
    //Spawns randomly generated objects
    public void itemSpawner(){
        if(Greenfoot.getRandomNumber(100) < 2 && timerHouseOne > 20){
            addObject (new House1(), 650, 87);
            timerHouseOne = 0;
        }
        if(Greenfoot.getRandomNumber(100) < 5 && timerTrees > 10){
            yCoord = Greenfoot.getRandomNumber(80) + 310;
            addObject (new Tree(), 650, yCoord);
            timerTrees = 0;
        }
    }
    //Timer method that helps remove overlap between backkground objects.
    private void timers(){
        timerHouseOne++;
        timerTrees++;
    }
    //Sets points
    public void addPoints(int points){
        score = score + points;
    }
    //Sets health
    public void addHealth(int change){
        health = health + change;
        if (health > MAXHEALTH)
            health = MAXHEALTH;
    }
}
