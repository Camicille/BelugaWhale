import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends Actor
{
    public static final int WIDTH = 852;
    public static final int HEIGHT = 173;
    private static final int SPEED = 4;
    /**
     * Act - do whatever the Road wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - SPEED, getY());
        if (getX() <= -WIDTH/2){
            int newX = ((MyWorld.WIDTH / WIDTH + 1) * WIDTH + WIDTH/2);
            setLocation(newX, getY());
        }
    }    
}
