import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MEGAMAN1 extends Actor{
    private int MAPX = 600;
    private int MAPY = 100; //MAPY + MAPZ = 400
    private int MAPZ = 300;
    private int time = 0;
    private int gravity = 0;
    private int dx,dy,dz = 0;
    private int speed = 3;
    private int jump = 5;
    private int jumptime = 10;
    private String direction = "stop";
    private DROPSHADOW floor;
    private boolean onFloor = true;
    private int floorHeight;
    private String png = "MM_R1_G1.jpg";
    
    private boolean setup = true;
    public MEGAMAN1(){
        trimWhite();
    }
    public void SETUP(){
        floor = new DROPSHADOW(25,10);
        floorHeight = getImage().getHeight()/2 + getY();
        getWorld().addObject(floor,getX(),floorHeight);
        getWorld().setPaintOrder(MEGAMAN1.class,DROPSHADOW.class);
        setup = false;
    }
    public void act(){
        if(setup)
            SETUP();
        INPUT();
        LOGIC();
        run();
        updateImage();
        time = (time + 1) % 16;
    }
    
    
    private void INPUT(){
        if(onFloor){
            if(Key("space")){
                onFloor = false;
                dz = -jump;
                jumptime = 10;
            }
        } else {
            dz = 0;
            if(jumptime > 0)
                dz = -jump;
            jumptime--;
        }
        if(Key("up") || Key("w"))
            dy = -speed;
        else if(Key("down") || Key("s"))
            dy = speed;
        else
            dy = 0;
        if(Key("right") || Key("d"))
            dx = speed;
        else if(Key("left") || Key("a"))
            dx = -speed;
        else
            dx = 0;
    }
    public void LOGIC(){
        dz += Gravity();
        if(((getY() + dy + dz) > MAPY + MAPZ) || ((getY() + dy) < 0) || ((getY() + dz) < 0)){
            dy = 0;
            dz = 0;
        }
        if((getX() + dx > MAPX) || (getX() + dx < 0))
            dx = 0;
        if((getY() + dy > 250 && dy > 0) || (getY() + dy < 100 && dy < 0))
            dy = 0;
        floorHeight += dy;
        floor.setLocation(getX(),floorHeight);
        Shift();
    }
    private int Gravity(){
        if((getY() + getImage().getHeight()/2 + dz) >= floorHeight){
            dz = 0;
            gravity = 0;
            onFloor = true;
        }
        else
            gravity = 1;
        return gravity;
    }
    private void Shift(){
        setLocation(getX() + dx, getY() + dy + dz);
    }
    
    
    private void run(){
        switch(time % 16){
            case 0:
                png = "MM_RR1_G.jpg";
            break;
            case 4:
                png = "MM_RR2_G.jpg";
            break;
            case 8:
                png = "MM_RR3_G.jpg";
            break;
            case 12:
                png = "MM_RR4_G.jpg";
            break;
        }
    }
    
    
    public boolean Key(String _key){
        return Greenfoot.isKeyDown(_key);
    }
    private void updateImage(){
        setImage(png);
        trimWhite();
    }
    public void trimWhite(){
        int range = 25; //Should be in the range 0-255.
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
