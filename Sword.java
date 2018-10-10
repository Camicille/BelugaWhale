import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A rotatable weapon that can kill by itself or generate a projectile to kill for it.
 * Modified for the group project
 * 
 * @Chandler Clarke 
 * @Version 1.2
 */
public class Sword extends Actor
{
    //Variables
    private int MEGAMAN1X, MEGAMAN1Y;
    private GreenfootImage sword1, sword2;
    //Methods
    
    public Sword(){
        sword1 = new GreenfootImage("sword1.png");
        sword2 = new GreenfootImage("sword2.png");
    }
    
    public void act() 
    {
        MEGAMAN1Locator();
        orientation();
        attack();
    }
    //Makes sword follow cursor
    public void orientation(){
        //From Greenfoot user "danpost".  Turns the sword towards the mouse.
        if (Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null)
            {
                turnTowards(mouse.getX(), mouse.getY());
            }
        }
    }
    //Finds MEGAMAN1 location
    public void MEGAMAN1Locator(){
        int MEGAMAN1X = ((MEGAMAN1) getWorld().getObjects(MEGAMAN1.class).get(0)).getX()+10;
        int MEGAMAN1Y = ((MEGAMAN1) getWorld().getObjects(MEGAMAN1.class).get(0)).getY()+2;
        setLocation(MEGAMAN1X, MEGAMAN1Y);
    }
    //Generates a Sword Attack
    public void attack(){
        if (Greenfoot.mouseClicked (null)){
            Greenfoot.playSound("swing.mp3");
            updateImage();
            SwordAttack SwordAttack = new SwordAttack();
            getWorld().addObject(SwordAttack, getX(), getY());
        }
    }
    
    private void monsterKiller(){
        if (isTouching(null)){  //Replace null with enemy types
            removeTouching(null);
            MyWorld w = (MyWorld)getWorld();
            w.addScore(10);
        }
    }
    
    public void updateImage(){
        if (getImage() == sword1)
            setImage(sword2);
        else setImage(sword1);
    }
}