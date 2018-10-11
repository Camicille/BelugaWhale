import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goldfish2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goldfish2 extends Goldfish
{
    public Goldfish2(){
        setImage(Fr1);
   }
    /**
     * Act - do whatever the Goldfish2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { super.act();
       
    }    
    
    public  void movement()
    {int amp = Greenfoot.getRandomNumber(2) +3;
         double time = Math.toRadians(getCount());
         double shift = 0.0;
         double offset = 0.0;
         double frequency =.5;
         int push = (int)Math.PI * (Greenfoot.getRandomNumber(2)+1);
         double aF = 2 * Math.PI * frequency;
         int stuff = (int) ( amp *  (-Math.sin( aF * time +shift) + offset));
         setLocation( getX() + push,getY() + stuff);
         
         
        }
}
