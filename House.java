import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    /**
     * Act - do whatever the House1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img1, img2;

    public House(){
        img1 = new GreenfootImage ("House1.png");
        img2 = new GreenfootImage ("House2.png");
        if(Greenfoot.getRandomNumber(100) >= 50)
            setImage(img2);
        else setImage(img1);
    }

    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        setLocation( getX()-world.getSpeed(), getY());
        if(getX() <= -50)
            getWorld().removeObject(this);
    }
}
