import greenfoot.*;

/** class Health: provides players with Health
  * 
  * @author tylerbakeman
  * @version 1.01
 **/
public class Health extends Actor{

    //DYNAMIC In-Class
    private static boolean destroy = false;
    private static int time = 0;
    //DYNAMIC Out-Class
    private static int yMapRestrict = 20; //vertical map restriction
    private static int mapSpeed = 3;
    //Method Modification
    private static int wobbleDir = (-1); //direction
    private static int wobbleBuffer = 4; //timing
    private static int wobbleMag = 16;   //rotation

    /** MAIN:
      *
      * act() 
     **/
    public Health(){
        int h = yMapRestrict;
        int x = getWorld().getWidth();
        int y = Greenfoot.getRandomNumber(getWorld().getHeight() - (2 * h)) + h;
        setLocation(x,y);
        trimWhite();
    }
    public void act(){
        if(destroy != true){
            shift();
            wobble();
            updateTime();
        } else {
            getWorld().removeObject(this);
        }
    }
    private void updateTime(){
        time++;
        if(time > 5000)
            time = 0;
    }


    /**LOCOMOTION:
      *
      * shift()
      * wobble()
     **/
    private void shift(){
        setLocation(getX() - mapSpeed);
        if(getX() <= 0)
            destroy = true;
    }
    private void wobble(){
        switch(time % (wobbleBuffer * 4){
            case 0:
                wobbleDir = (-1);
            break;
            case 4:
                wobbleDir = 1;
            break;
            case 8:
                wobbleDir = 1;
            break;
            case 12:
                wobbleDir = (-1);
            break;
        }
        turn(wobbleDir * (wobbleMag / 4));
    }

    private void trimWhite(){
        int range = 15; //Should be in the range 0-255.
        GreenfootImage img = getImage();
        Color transparent = new Color(0, 0, 0, 0);
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color color = img.getColorAt(x, y);
                if(color.getRed()   > 255 - range
                && color.getGreen() > 255 - range
                && color.getBlue()  > 255 - range)
                    img.setColorAt(x, y, transparent);
            }
        }
    }    
}
