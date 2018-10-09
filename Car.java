import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A car that moves and interacts with the world
 * 
 * @author Chandler Clarke 
 * @version 1.1
 */
public class Car extends Actor
{
    private int animationCount, aniTimer, SPEED, LATERALSPEED;
    private String carImages[] =
        {"car1", "car2", "car3", "car4"};
    
    public Car(){
        SPEED = 4;
        LATERALSPEED = 3;
    }
        
    public void act() {
        controller();
        updateImage();
    }   

    private void controller(){
        if (Greenfoot.isKeyDown("W") && getY() >= 110)
            setLocation (getX(), getY() - LATERALSPEED);
        if (Greenfoot.isKeyDown("S") && getY() <= 266)
            setLocation (getX(), getY() + LATERALSPEED);
        if (Greenfoot.isKeyDown("A") && getX() >= 31){
            setLocation (getX() - SPEED, getY());
        }
        if (Greenfoot.isKeyDown("D") && getX() <= 568)
            setLocation (getX() + SPEED, getY());
        updateImage();
    }
    private void updateImage(){
        if (aniTimer == 7){
            setImage(carImages[animationCount] + ".png");
            animationCount++;
            aniTimer = 0;
        }
        if (animationCount >= 4)
            animationCount = 0;
        aniTimer++;
    }
}
