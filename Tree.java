import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Actor
{
    private GreenfootImage img1, img2, img3;
    private int randomNum;

    public Tree(){
        randomNum = Greenfoot.getRandomNumber(100);
        img1 = new GreenfootImage ("tree1.png");
        img2 = new GreenfootImage ("tree2.png");
        img3 = new GreenfootImage ("tree3.png");
        if(randomNum <=33)
            setImage(img2);
        else if(randomNum >33 && randomNum <= 66)
            setImage(img3);
        else if(randomNum > 66)
            setImage(img1);
    }

    public void act() 
    {
        setLocation( getX()-3, getY());
        if(getX() <= -50)
            getWorld().removeObject(this);
    }
}
