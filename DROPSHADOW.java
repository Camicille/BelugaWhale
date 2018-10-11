import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DROPSHADOW extends Actor{
    public DROPSHADOW(int Lx, int Ly){
        getImage().scale(Lx,Ly);
        trimWhite();
    }
    
    
    private void trimWhite(){
        int range = 15; //Should be in the range 0-255.
        GreenfootImage img = getImage();
        Color transparent = new Color(0, 0, 0, 0);
        for(int x = 0; x < img.getWidth(); x++)        {
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
