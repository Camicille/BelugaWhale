import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The weapon's path
 * Replace null with enemy types in monsterKiller method or else it can delete anything
 * 
 * @author Chandler Clarke 
 * @version 1.0
 */
public class SwordAttack extends Sword{
    //Variables
    private boolean hasOriented;
    //Methods
    public void act(){
        if (hasOriented == false){
            swordLocator();
        }
        swordPath();
    }
    //Finds player location
    private void swordLocator(){
        int swordX = ((Sword) getWorld().getObjects(Sword.class).get(0)).getX();
        int swordY = ((Sword) getWorld().getObjects(Sword.class).get(0)).getY();
        setLocation(swordX, swordY);
        hasOriented = true;
    }
    //Moves sword Projectile
    private void swordPath(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        turnTowards(mouse.getX(), mouse.getY());
        move(70);
        Greenfoot.delay(1);
        monsterKiller();
        getWorld().removeObject(this);
    }
    //Kills monsters
    private void monsterKiller(){  //Replace null with enemy types
        if (isTouching(Goldfish.class)){
            removeTouching(Goldfish.class);
            MyWorld w = (MyWorld)getWorld();
            w.addScore(10);
        }
    }

}