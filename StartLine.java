import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartLine extends Actor
{
    /**
     * Act - do whatever the StartLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        setLocation( getX()-world.getSpeed(), getY());
        if(getX() <= -50)
            getWorld().removeObject(this);
    }    
}
