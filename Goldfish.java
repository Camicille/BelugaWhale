
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * pet Goldfish attacks floats up down in wave moves left goldfish2 moves right 
 * 
 * @author (Philip Jepkes)
 * @version(v1.0)
 */
public class Goldfish extends Actor
{   public GreenfootImage normal1,normal2,normal3,normal4,normal5,normal6,normal7,
    normal8,normal9,normal10,normal11,normal12;
    public GreenfootImage Fr1,Fr2,Fr3,Fr4,Fr5,Fr6,Fr7,
    Fr8,Fr9,Fr10,Fr11,Fr12;
    public double count;
    public int animationCount;//variable to be counted and reset with animCounter altered with animCounter plus 1 per act and reset with alterAnimation
    public int alterAnimation = 2;//variable to use to reset animation count and to denote after how many acts to switch image--alter till it looks nice
    
    
    public Goldfish(){
        normal1 = new GreenfootImage("swim000.png");
        normal2 = new GreenfootImage("swim001.png");
        normal3 = new GreenfootImage("swim002.png");
        normal4 = new GreenfootImage("swim003.png");
        normal5 = new GreenfootImage("swim004.png");
       normal6 = new GreenfootImage("swim005.png");
        normal7 = new GreenfootImage("swim006.png");
        normal8 = new GreenfootImage("swim007.png");
       normal9 = new GreenfootImage("swim008.png");
        normal10 = new GreenfootImage("swim009.png");
        normal11 = new GreenfootImage("swim010.png");
        normal12 = new GreenfootImage("swim011.png");
        Fr1 = new GreenfootImage("faceR000.png");
        Fr2 = new GreenfootImage("faceR001.png");
        Fr3 = new GreenfootImage("faceR002.png");
        Fr4 = new GreenfootImage("faceR003.png");
        Fr5 = new GreenfootImage("faceR004.png");
       Fr6 = new GreenfootImage("faceR005.png");
        Fr7 = new GreenfootImage("faceR006.png");
        Fr8 = new GreenfootImage("faceR007.png");
       Fr9 = new GreenfootImage("faceR008.png");
        Fr10 = new GreenfootImage("faceR009.png");
        Fr11 = new GreenfootImage("faceR010.png");
        Fr12 = new GreenfootImage("faceR011.png");
        setImage(normal1);
        
        count = 0;
    }
    
    /**
     * Act - do whatever the Goldfish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
       alterCount();
       animCounter();
       updateImage();
       touch();
       movement();
       destroy();
        
    }
   
    /**
     * sin wav equation from physics book but rounded so its not sin wave 
     * moves in trapazoid esque pattern cant use double method getExact from helper class . 
     * need set location method from "actor" as requirement  
     * i dont know if overloading counts as differnt method from another class so dont alter
     */
    public  void movement()
    {int amp = Greenfoot.getRandomNumber(2) +3;
         double time = Math.toRadians(getCount());
         double shift = 0.0;
         double offset = 0.0;
         double frequency =.5;   
         int push = (int)Math.PI * (Greenfoot.getRandomNumber(2)+1) ;
         double aF = 2 * Math.PI * frequency;
         int stuff = (int) ( amp *  (-Math.sin( aF * time +shift) + offset));
         setLocation( getX()-push,getY() + stuff);
        }
    /**
     * same thing as movement but for goldfish2
     */    
    public double getCount(){return count;}
    public void alterCount(){count++;}
    /**
     * frames of fish
     */
    public void updateImage()
    {   
        if (getImage() == normal1&& getFrame()==alterAnimation )
        {setImage(normal2);
        }
        else if (getImage() == normal2&& getFrame()==alterAnimation )
        {setImage(normal3);
        }
        else if (getImage() == normal3&& getFrame()==alterAnimation )
        {setImage(normal4);
        }
        else if (getImage() == normal4&& getFrame()==alterAnimation )
        {setImage(normal5);
        }
        else if (getImage() == normal5&& getFrame()==alterAnimation )
        {setImage(normal6);
        }
        else if (getImage() == normal6&& getFrame()==alterAnimation )
        {setImage(normal7);
        }
        else if (getImage() == normal7&& getFrame()==alterAnimation )
        {setImage(normal8);
        }
        else if (getImage() == normal8&& getFrame()==alterAnimation )
        {setImage(normal9);
        }
        else if (getImage() == normal9&& getFrame()==alterAnimation )
        {setImage(normal10);
        }
        else if (getImage() == normal10&& getFrame()==alterAnimation )
        {setImage(normal11);
        }
        else if (getImage() == normal11&& getFrame()==alterAnimation )
        {setImage(normal12);
        }
        else if  (getImage() == normal12&& getFrame()==alterAnimation )
        {setImage(normal1);
        }
             if (getImage() == Fr1&& getFrame()==alterAnimation )
        {setImage(Fr2);
        }
        else if (getImage() == Fr2&& getFrame()==alterAnimation )
        {setImage(Fr3);
        }
        else if (getImage() == Fr3&& getFrame()==alterAnimation )
        {setImage(Fr4);
        }
        else if (getImage() == Fr4&& getFrame()==alterAnimation )
        {setImage(Fr5);
        }
        else if (getImage() == Fr5&& getFrame()==alterAnimation )
        {setImage(Fr6);
        }
        else if (getImage() == Fr6&& getFrame()==alterAnimation )
        {setImage(Fr7);
        }
        else if (getImage() == Fr7&& getFrame()==alterAnimation )
        {setImage(Fr8);
        }
        else if (getImage() == Fr8&& getFrame()==alterAnimation )
        {setImage(Fr9);
        }
        else if (getImage() == Fr9&& getFrame()==alterAnimation )
        {setImage(Fr10);
        }
        else if (getImage() == Fr10&& getFrame()==alterAnimation )
        {setImage(Fr11);
        }
        else if (getImage() == Fr11&& getFrame()==alterAnimation )
        {setImage(Fr12);
        }
        else if  (getImage() == Fr12&& getFrame()==alterAnimation )
        {setImage(Fr1);
        }
        trimWhite();
    }
    private void shrink(){
         int worldWidth = getWorld().getWidth(); 
         int modifier = 2; //modify the place  to shrink the image. 
     //if (getExactX()<worldWidth / modifier && getImage()==normal1){setImage(mini1);}
     //else if (getExactX()<worldWidth * modifier && getImage()==normal2 ){setImage(mini2);}
     //else if (getExactX()<worldWidth *modifier && getImage()==normal3 ){setImage(mini3);}
     //else if (getExactX()<worldWidth * modifier && getImage()==normal4 ){setImage(mini4);}
}  


public void animCounter(){animationCount++; if (animationCount >alterAnimation){animationCount=0;} }
    public int getFrame(){return animationCount;}
    /**
         * for trouble shooting
         */
        public void printY(){int location =getY(); 
    System.out.println("" + location);}
    
    
    public void touch(){ 
        if(isTouching(MEGAMAN1.class)){
            MyWorld blank = (MyWorld)getWorld();
            Greenfoot.playSound("au.wav"); 
            blank.addScore(-10); 
            blank.addHealth(-1); 
            }
        }
    public void destroy(){
        if((isTouching(MEGAMAN1.class)) || (getX() < 0) || (getX() > 600)){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * just to trim background of image by tyler decided to put here by group for aesthetic reasons because they called the image ugly
     */public void trimWhite(){
        int range = 1; //Should be in the range 0-255.
        GreenfootImage img = getImage();
        Color transparent = new Color(0, 0, 0, 0);
        for(int x = 0; x < img.getWidth(); x++)
        {
            for(int y = 0; y < img.getHeight(); y++)
            {
                Color color = img.getColorAt(x, y);
                if(color.getRed()   > 255 - range
                && color.getGreen() > 255 - range
                && color.getBlue()  > 255 - range)
                    img.setColorAt(x, y, transparent);
            }
        }
    }
    }

